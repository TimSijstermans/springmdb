app.controller('UpdateSeriesController', function($scope, $location, $routeParams, $q, Series, Director) {
	$scope.series = Series.get({id:$routeParams.id});
	
	$scope.directors = Director.query();
	
	$q.all([
	        $scope.directors.$promise,
	        $scope.series.$promise
	    ]).then(function() { 
	        for (i = 0; i < $scope.directors.length; i++) { 
	        	if ($scope.directors[i].person_id == $scope.series.director.person_id){
	            	$scope.series.director = $scope.directors[i]
	            	break;
	            }
	        }
	    });
	
    $scope.submitScreenplay = function(){
    	Series.update({id:$routeParams.id}, $scope.series).$promise.then(seriesPutSucces, seriesPutError);
    }
    
    function seriesPutSucces(response){
		var url = '/screenplays/series/'+response.screenplayId
    	$location.path(url);
    }
    function seriesPutError(response){
        $scope.errormessage = 'Serie kan niet worden opgeslagen, zijn alle velden correct ingevuld?'
    }
})
