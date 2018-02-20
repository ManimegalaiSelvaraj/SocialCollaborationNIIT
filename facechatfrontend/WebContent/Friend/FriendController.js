myapp.controller("FriendController", function($scope, $http, $location, $rootScope)
		{
	$scope.friend={friendId:"",friendname:"",username:"",status:""};
		var cuser= $rootScope.currentUser.username;
		$scope.currentuser=cuser;
		
			$http.get('http://localhost:8080/fcmiddleware/getAllusers/'+$rootScope.currentUser.username)
			.then(function(response)
			{
			$scope.userdata=response.data;
		
			});
			
			$http.get('http://localhost:8080/fcmiddleware/getAllFriendRequest/'+$rootScope.currentUser.username)
			.then(function(response)
			{
			$scope.frienddata=response.data;
		
			});
			
			function getallfriends()
			{
				$http.get('http://localhost:8080/fcmiddleware/getAllFriendRequest/'+$rootScope.currentUser.username)
				.then(function(response)
				{
				$scope.frienddata=response.data;
			
				});	
			}
			
			
			$scope.request=function(user)
			{
				$scope.clickuser=user;
			}
			
			$scope.addfriend=function()
			
			{
				var cuser= $rootScope.currentUser.username;
				$scope.friend.friendname=$scope.clickuser.username;
				$scope.friend.username=cuser;
				console.log("entered into request friend")
				$http.post('http://localhost:8080/fcmiddleware/createfriendrequest',$scope.friend)
			}
			
			
			$scope.acceptrequest=function(friendId)
			{
				$http.get('http://localhost:8080/fcmiddleware/approvalfriendrequest/'+friendId).then(getallfriends(),function(response){
					console.log('friend accepted');
					
					});
			}
			
			$scope.deleterequest=function(friendId)
			{
				$http.get('http://localhost:8080/fcmiddleware/deletefriend/'+friendId).then(getallfriends(),function(response){
					console.log('friend deleted');
					
					});
			}
			
			
			$scope.friends=function()
			{
				$http.get('http://localhost:8080/fcmiddleware/getapprovefriends/'+$rootScope.currentUser.username)
				.then(function(response)
				{
				$scope.frienddata1=response.data;
			
				});	
			}
			
		});