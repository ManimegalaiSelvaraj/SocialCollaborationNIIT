myapp.controller("forumController", function($scope, $http, $location)
	{
	function fetchAllforum()
	{
		console.log("Fetching all forums");
		$http.get("http://localhost:8080/fcmiddleware/getAllForums")

		.then(function(response) 
		{
			$scope.forumdata = response.data;
			console.log("forum fetched");
		});
	};
	
	fetchAllforum();
	$scope.insertforum = function()
	{
		console.log('Entered insert forum');
		$http.post('http://localhost:8080/fcmiddleware/insertForum',
				$scope.forum).then(fetchAllforum(), function(response) 
		{
			console.log("successful forum entered");
			$scope.refresh();
			$location.path("/forum")
		});
	};
	$scope.deleteforum = function(forumId) 
	{
		console.log("entering in delete forum");
		$http.get("http://localhost:8080/fcmiddleware/deleteForum/"+ forumId)
				.success(fetchAllforum(), function(response)
			{
			console.log('successful deletion');
			$scope.refresh();
			$location.path("/forum");

		});
	};
	
});