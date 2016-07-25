app.controller('PersonDetailController', function($scope, $routeParams, $http, Person) {
	$scope.person = Person.get({
		id : $routeParams.id
	})

	$http({method: 'GET', url: 'api/persons/'+ $routeParams.id + '/screenplays'}).success(function(data){
		$scope.screenplays = data;
	});

})