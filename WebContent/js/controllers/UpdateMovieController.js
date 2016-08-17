app.controller('UpdateMovieController', function($scope, $location, $routeParams, $q, Movie, Director) {
	$scope.movie = Movie.get({id:$routeParams.id});
	
	$scope.directors = Director.query();
	
	$q.all([
	        $scope.directors.$promise,
	        $scope.movie.$promise
	    ]).then(function() { 
	        for (i = 0; i < $scope.directors.length; i++) { 
	        	if ($scope.directors[i].person_id == $scope.movie.director.person_id){
	            	$scope.movie.director = $scope.directors[i]
	            	break;
	            }
	        }
	    });
	
    $scope.submitScreenplay = function(){
    	Movie.update({id:$routeParams.id}, $scope.movie).$promise.then(moviePutSucces, moviePutError);
    }
    
    function moviePutSucces(response){
		var url = '/screenplays/movies/'+response.screenplayId
    	$location.path(url);
    }
    function moviePutError(response){
        $scope.errormessage = 'Film kan niet worden opgeslagen, zijn alle velden correct ingevuld?'
    }
})
