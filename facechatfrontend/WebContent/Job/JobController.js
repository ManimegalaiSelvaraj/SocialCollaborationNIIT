myapp.controller("jobController", function($scope, $http, $location,$rootScope)
		{
	$scope.jobs=={jobId:0,status:'',qualification:'',salary:0,postdate:''};
	$scope.jobList;
	
$scope.insertjob=function()
{
	console.log("insertinng job");
	$http.post('http://localhost:8080/fcmiddleware/insertjob',$scope.jobs)
	.then(function(response)
			{
		console.log('insert the job successfuly')
			});
}
	

/*$scope.deleteJob=function(jobId)
{
	console.log('Deleting job');
	$http.get('http://localhost:8076/MiddleWareProject/deletejob')
	.then(function(response)
			{
		console.log('job deleted');
			});
}
*/

$scope.deleteJob = function(jobId) 
{
	console.log("entering in delete blog");
	$http.get("http://localhost:8080/fcmiddleware/deletejob/"+ jobId)
			.success(fetchAllBlog(), function(response)
		{
		console.log('successful deletion');
		$scope.refresh();
		$location.path("/ShowJob");

	});
};

function fetchAllJobs() 
	{
	console.log("fetched all jobs")
 $http.get('http://localhost:8080/fcmiddleware/getAllJobs')
.then(function(response)
{
	$scope.jobList = response.data;
	console.log($scope.jobList)
});
	
}

fetchAllJobs();
});//controller
