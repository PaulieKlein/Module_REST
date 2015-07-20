angular.module("bankonet").controller("SearchController",function (BankonetService) {
	var searchctrl =this;

	searchctrl.get = function (form) {
        if (form.$invalid) return;
        BankonetService.get(searchctrl.employe.id).then(function(employe){
		searchctrl.employe = employe
		})
    }
})