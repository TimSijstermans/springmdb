app.controller('SeriesDetailController', function($scope, $location, $route, $routeParams, Series, Episode) {
	$scope.series = Series.get({id:$routeParams.id});
	
	
	$scope.deleteSeries = function(seriesId){
		Series.delete({id: seriesId}).$promise.then(deleteSeriesSuccess, deleteSeriesError);
	}
	
	$scope.deleteEpisode = function(epId){
		Episode.delete({id: epId}).$promise.then(deleteEpSuccess, deleteEpError);
	}
	
	function deleteSeriesSuccess(resp){
		$location.path('/screenplays/series')
	}
	function deleteSeriesError(resp){
		$scope.deleteSeriesError = resp;
	}
	
	function deleteEpSuccess(resp){
		$route.reload();
	}
	function deleteEpError(resp){
		$scope.deleteEpisodeError = resp;
	}
})
