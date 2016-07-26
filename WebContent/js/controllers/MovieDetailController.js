app.controller('MovieDetailController', function($scope, $location, $routeParams, Movie) {
	$scope.movie = Movie.get({id:$routeParams.id});
	
	$scope.deleteMovie = function(movieId){
		Movie.delete({id: movieId}).$promise.then(deleteSuccess, deleteError);
	}
	
	function deleteSuccess(resp){
		$location.path('/screenplays/movies')
	}
	function deleteError(resp){
		$scope.deleteSeriesError = resp;
	}
})
