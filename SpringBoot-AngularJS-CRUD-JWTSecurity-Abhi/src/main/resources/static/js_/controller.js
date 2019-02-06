var app=angular.module("CustomerManagement",[]);





//Controller part
app.controller("CustomerController", function($scope,$http) {
	
	$scope.customers=[];
	$scope.customerForm={
		customerId:-1,
		customerName:"",
		email:""
	};
	
	//load the data from Server
	_refreshCustomerData()
	
	// HTTP Post/Put for add/edit customer
	//With the help of id, we are going to find out  whether it is Post/ Put operation
	
	$scope.submitCustomer=function(){
        
		
        var method="";
		var url="";
		
		if($scope.customerForm.customerId==-1){
			  //Id is absent in form data, it is create new customer operation
			method="POST";
			url="/addCustomer";
			
		}
		else{
			 //Id is present in form data, it is edit customer operation
			method="PUT";
			url="/addCustomer";
			
		}
		console.log(method+"****"+url+"****"+$scope.customerForm);	
		console.log($scope.customerForm.customerId+"****"+$scope.customerForm.customerName+"**"+$scope.customerForm.email);
		$http({
			method : method,
			url:url,
			data:angular.toJson($scope.customerForm),
		
			headers:{
				'Content-Type' : 'application/json'
			}
		}).then( _success, _error );
		_clearFormData();
		console.log(angular.toJson($scope.customerForm))
		
	};
	
	 //HTTP DELETE- delete customer by Id
	
	$scope.deleteCustomer=function(customer){
		$http({
			method : "DELETE",
			url:"/deleteCustomer/"+customer.customerId
			
		}).then( _success, _error );
		
	};
	
	
	   // In case of edit, populate form fields and assign form.id with customer id
	
	$scope.editCustomer=function(customer){
		
		$scope.customerForm.customerId=customer.customerId;
		$scope.customerForm.customerName=customer.customerName;
		$scope.customerForm.email=customer.email;
		console.log($scope.customerForm.customerId+"****"+$scope.customerForm.customerName+"**"+$scope.customerForm.email);
		
	};
	
	 //HTTP GET- get all customers collection
	
	function _refreshCustomerData(){
		
		$http({
			method:"GET",
			url:'http://localhost:9191/getAllCustomers'
	}).then(function successCallback(response){
		$scope.customers=response.data;
		
	}, function errorCallback(response) {
        console.log(response.statusText);
    });
	}
	
	
	 function _success(){
		_refreshCustomerData();
	}
	
	 function _error(response) {
         console.log(response.statusText);
     }
	 
	 //clear the form
	 function _clearFormData(){
		    $scope.customerForm.customerId=-1;
			$scope.customerForm.customerName="";
			$scope.customerForm.email="";
	 }
});