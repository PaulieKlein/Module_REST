angular.module("bankonet")
	.factory("BankonetService", function($http){
		return {
			version:"1.0",

			getAll : function(){
				return $http.get("http://localhost:8090/BankonetREST/api/Employes")
					.then(function (result) {
                    return result.data;
                })
					
			},

			get : function(id){
				return $http.get("http://localhost:8090/BankonetREST/api/Employes/"+id).then(function (result) {
                    return result.data;
                })
			},


			save : function(employe){
					
					console.log(employe)
					console.log(JSON.stringify(employe))
					return $http.post("http://localhost:8090/BankonetREST/api/Employes",employe)
			},

			delete : function(employe){
				console.log(employe.id)
				return $http.delete("http://localhost:8090/BankonetREST/api/Employes/"+employe.id)
			},

			update : function(employe){
					
					return $http.update("http://localhost:8090/BankonetREST/api/Employes/"+employe.id,employe)
			}
		}



})