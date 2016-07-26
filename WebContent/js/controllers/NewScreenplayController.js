/**
 * Created by tim on 24-7-16.
 */
app.controller('NewScreenplayController', function($scope, $location, Series, Movie, Director) {
    Director.query(function(data) {
        $scope.directors = data;
    });
    
    $scope.submitScreenplay = function(){
    	$scope.save = angular.copy($scope.screenplay);
    	$scope.save.director = JSON.parse($scope.save.director) 
    	if($scope.save.type == "Movie"){
    		Movie.save($scope.save).$promise.then(moviePostSucces, moviePostError);
    	} else {
    		Series.save($scope.save).$promise.then(seriesPostSucces, seriesPostError);
        }
    }
    
    function moviePostSucces(response){
		var url = '/screenplays/movies/'+response.screenplayId
    	$location.path(url);
    }
    function moviePostError(response){
        $scope.errormessage = 'Film kan niet worden opgeslagen, zijn alle velden correct ingevuld?'
    }
    function seriesPostSucces(response){
		var url = '/screenplays/series/'+response.screenplayId
    	$location.path(url);
    }
    function seriesPostError(response){
        $scope.errormessage = 'Serie kan niet worden opgeslagen, zijn alle velden correct ingevuld?'
    }
})