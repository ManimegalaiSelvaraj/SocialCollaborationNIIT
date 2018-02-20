myapp.controller("usercontroller", function($scope, $http, $location,$rootScope,$cookieStore) 
	{
	$scope.user={username:'',password:'',emailId:'',isOnline:'',role:''};
	$scope.allusers;
	$scope.registeruser=function()
	{
		console.log('Enter Register');
		$http.post('http://localhost:8080/fcmiddleware/register',$scope.user)
		.then(function(response)
				{
			      console.log('successfully registered');
			     $location.path("/Login");
				});			
	}
	
	$scope.loginuser=function()
	{
		console.log('Login Function');
		$http.post('http://localhost:8080/fcmiddleware/login',$scope.user)
				.then(function(response)
					{
					$scope.user=response.data;
					$rootScope.currentUser=response.data;
					$cookieStore.put('user',response.data);
					console.log($rootScope.currentUser.role);
					$location.path("/");
					});
						};

	function fetchAllUsers()
	{
	console.log("fetching all users");
	$http.get('http://localhost:8080/fcmiddleware/getAllUsers')
	.then (function(response)
			{
		      $scope.allusers=response.data;
			});
	};
	fetchAllUsers();
	
	
	$rootScope.logout=function()
	{
		console.log('logout function');
		delete $rootScope.currentUser;
		$cookieStore.remove('user');
		$location.path("/Logout");
		//user.setisOnline=='N';

	};
	});//close