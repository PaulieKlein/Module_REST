angular.module("bankonet").controller("bankonetController",function (BankonetService,$location) {
															
	function fetchEmployes(){
	BankonetService.getAll()
		.then(function (employes){
			bankonetCtrl.employes = employes
		})
	}

		 fetchemployes()


			var bankonetCtrl = this;
			bankonetCtrl.employes = [];
			

			this.Create= function(form){
				if (form.$invalid) return
					var clone = angular.copy(bankonetCtrl.employe)
					bankonetCtrl.employes.push(clone)
					employeService.save(clone)
					.then(function(){
						$location.path("/")
						}
						)

			}
			})

			