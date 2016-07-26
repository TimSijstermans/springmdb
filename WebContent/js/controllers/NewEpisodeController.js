app.controller('NewEpisodeController', function($scope, $location, $routeParams, Series, Episode) {

	$scope.series = Series.get({id:$routeParams.id});
	

	
	$scope.submitEpisode = function(){
		$scope.save = {}
		$scope.save.episode = angular.copy($scope.episode);
		$scope.save.series = $scope.series
		Episode.save($scope.save).$promise.then(postSucces, postError);
	}
	
	function postSucces(response){
		var url = '/screenplays/series/'+ $routeParams.id
    	$location.path(url);
    }
    function postError(response){
        $scope.errormessage = 'Episode kan niet worden opgeslagen, zijn alle velden correct ingevuld?'
    }
})