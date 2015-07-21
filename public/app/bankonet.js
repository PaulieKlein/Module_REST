angular.module("bankonet",['ngRoute'])
.config(function ($routeProvider){
		$routeProvider
		.when("/",{
			templateUrl :'views/home.html',
			controller : "HomeController",
			controllerAs : "homectrl"
		})
		.when("/new",{
			templateUrl :"views/new.html",
			controller : "NewController",
			controllerAs : "newctrl"
		})
		.when("/search",{
			templateUrl :"views/search.html",
			controller : "SearchController",
			controllerAs : "searchctrl"
		})
		.when("/update/:id",{
			templateUrl :"views/update.html",
			controller : "UpdateController",
			controllerAs : "updatectrl"
		})
		.otherwise({
			redirectTo:"/"
		});
	})