app.controller('MovieDetailController', function($scope, $routeParams, Movie) {
	$scope.movie = Movie.get({id:$routeParams.id});
	
})
