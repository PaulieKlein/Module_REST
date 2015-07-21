angular.module("bankonet").controller("UpdateController",function (BankonetService,$routeParams,$location) {
	var updatectrl =this;
	
	console.log("update update : " + $routeParams.id);
	
        BankonetService.get($routeParams.id)
            .then(function (employe) {

                updatectrl.employe = employe
            })

	updatectrl.update = function (form) {
        if (form.$invalid) return;
        BankonetService.update(updatectrl.employe)
            .then(function () {
                $location.path("/")
            })
    }
})