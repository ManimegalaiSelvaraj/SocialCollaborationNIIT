var myapp=angular.module("myApp",['ngRoute','ngCookies']);//'ngCookies'
myapp.factory('chatService', function($q , $timeout)
		{
			console.log("Inside chatService");
			var base_url="http://localhost:8080/fcmiddleware";
			
			var service={},listener=$q.defer(),socket={client:null,stomp:null},messageIds=[];

			service.RECONNECT_TIMEOUT=30000;
			service.SOCKET_URL=base_url+"/chat";
			service.CHAT_TOPIC="/topic/message";
			service.CHAT_BROKER="/app/chat";

			service.send=function(message)
			{
				console.log("Inside Chat - send");
				var id=Math.floor(Math.random()*1000000);
				socket.stomp.send(service.CHAT_BROKER,{priority:9},JSON.stringify({message:message,id:id}));
				messageIds.push(id);
			};

			service.receive=function()
			{
				console.log("Inside chat - receive");
				return listener.promise;
			};

			var reconnect=function()
			{
				console.log("Inside Chat - reconnect");
				$timeout(function()
				{
				initialize();
				},this.RECONNECT_TIMEOUT);
			};

			var getMessage=function(data)
			{
				console.log("Inside Chat - getMessage");
				var message=JSON.parse(data),out={};
				out.message=message.message;
				out.time=new Date(message.time);
				return out;
			};

			var startListener=function()
			{
				console.log("Inside Chat - startListener");
				socket.stomp.subscribe(service.CHAT_TOPIC,function(data)
				{
				listener.notify(getMessage(data.body));
				});
			};

			var initialize=function()
			{
				socket.client=new SockJS(service.SOCKET_URL);
				socket.stomp=Stomp.over(socket.client);
				socket.stomp.connect({},startListener);
				socket.stomp.onclose=reconnect;
			};

			initialize();

			return service;
			

		});


myapp.config(function($routeProvider)
		{
		 $routeProvider.when("/",{templateUrl:"User/UserHome.html"})
						  .when("/Blog",{templateUrl:"Blog/Blog.html"})
						  .when("/AdminBlog",{templateUrl:"Blog/AdminBlog.html"})
						  .when("/Forum",{templateUrl:"Forum/Forum.html"})
			              .when("/Register",{templateUrl:"User/Register.html"})
			              .when("/Login",{templateUrl:"User/Login.html"})
			               .when("/Logout",{templateUrl:"User/Logout.html"})
			               .when("/Job",{templateUrl:"Job/Jobinsert.html"})
				              .when("/Showjob",{templateUrl:"Job/Showjob.html"})
				              .when("/Friend",{templateUrl:"Friend/Friend.html"})
				              .when("/UserList",{templateUrl:"Friend/UserList.html"})
				              .when("/Logout",{templateUrl:"User/Logout.html"})
				              .when("/ProfilePicture",{templateUrl:"User/ProfilePicture.html"})
				              
				              .when("/Chat",{templateUrl:"Chat/Chat.html"})
				              
		});
		myapp.run(function($rootScope,$cookieStore)
		{
			console.log("im in Run function");
			console.log($rootScope.currentUser);
			
			if($rootScope.currentUser==undefined)
				{
				$rootScope.currentUser=$cookieStore.get('user');
				}
			      else
				{
				   console.log($rootScope.currentUser.username);
				   console.log($rootScope.currentUser.role);
				}
		});
