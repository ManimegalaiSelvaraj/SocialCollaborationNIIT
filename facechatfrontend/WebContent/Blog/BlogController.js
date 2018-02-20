myapp.controller("BlogController", function($scope, $http, $location)
	{
	function fetchAllBlog()
	{
		console.log("Fetching all blogs");
		$http.get("http://localhost:8080/fcmiddleware/getAllBlogs")

		.then(function(response) 
		{
			$scope.blogdata = response.data;
			console.log("Blog fetched");
		});
	};
	
	fetchAllBlog();
	$scope.addBlog = function()
	{
		console.log('entered insertBlog');
		$http.post('http://localhost:8080/fcmiddleware/insertBlog',
				$scope.blog).then(fetchAllBlog(), function(response) 
		{
			console.log("successful blog entered");
			$location.path("/Blog")
		});
	};
	$scope.deleteBlog = function(blogId) 
	{
		console.log("entering in delete blog");
		$http.get("http://localhost:8080/fcmiddleware/deleteBlog/"+ blogId)
				.success(fetchAllBlog(), function(response)
			{
			console.log('successful deletion');
			$scope.refresh();
			$location.path("/Blog");

		});
	};
	

	$scope.likeBlog=function(blogId)
	{
		console.log("enterd into like ");
		$http.get('http://localhost:8080/fcmiddleware/incLike/'+ blogId)
		.success(fetchAllBlog(),function(response)
				{
				console.log("like incremented")
				$scope.refresh();
				$location.path("/Blog");
				});
	};
});