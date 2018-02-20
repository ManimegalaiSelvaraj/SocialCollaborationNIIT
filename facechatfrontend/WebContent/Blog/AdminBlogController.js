myapp.controller("adminblogcontroller", function ($scope,$http,$location)
{
	//$scope.blog={blogId:0,blogName:'',blogContent:'',userName:'',createDate:'',status:'',likes:''};
	//$scope.blogdata;
	/*function fetchAllBlog()
	{
		console.log("fetching all blogs");
	}
	*/
	
	//fetchAllBlog();
	
	function fetchAllBlog()
	{
		console.log('fetching all blogs');
		$http.get('http://localhost:8080/fcmiddleware/getAllBlogs')
		
		.then(function (response)
		{
			$scope.blogdata=response.data;
			console.log("blog fetched");
		});
	};
	
	
	fetchAllBlog();
	
	$scope.approveblog=function(blogId)
	{
		console.log("enter the approve blog")
		$http.get('http://localhost:8080/fcmiddleware/approveBlog/'+blogId)
		.then(fetchAllBlog(), function (response)
		{
			console.log("Blog is approved");
		});

	};
	
	
	$scope.rejectblog=function(blogId)
	{
		console.log("enter the reject blog")
		$http.get('http://localhost:8080/fcmiddleware/rejectBlog/'+blogId)
		.then(fetchAllBlog(), function (response)
		{
			console.log("Blog is rejected");
			});

	};
	
	
});//controller