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
		.otherwise({
			redirectTo:"/"
		});
	})