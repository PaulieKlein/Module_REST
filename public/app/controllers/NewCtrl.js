angular.module("bankonet").controller("NewController",function (BankonetService,$location) {
	var newctrl =this;
	
	newctrl.save = function (form) {
        if (form.$invalid) return;
        BankonetService.save(newctrl.employe)
            .then(function () {
                $location.path("/")
            })
    }
})