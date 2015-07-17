angular.module("bankonet").controller("HomeController",function (BankonetService,$location) {
	var homectrl =this;
function fetchemployes() {
        BankonetService.getAll()
            .then(function (employes) {
                homectrl.employes = employes
            })
    }
    fetchemployes()

     homectrl.delete = function (employe) {
        BankonetService.delete(employe)
            
    }

    homectrl.update = function(employe){
        $location.path("/update/" +employe.id)
    }

})
