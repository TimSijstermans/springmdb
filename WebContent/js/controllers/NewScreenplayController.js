/**
 * Created by tim on 24-7-16.
 */
app.controller('NewScreenplayController', function($scope, Series, Movie, Director) {
    Director.query(function(data) {
        $scope.directors = data;
    });
    
    $scope.submitScreenplay = function(){
    	$scope.save = angular.copy($scope.screenplay);
    	$scope.save.director = JSON.parse($scope.save.director) 
    	if($scope.save.type == "Movie"){
    		console.log(Movie.save($scope.save));
    		$location.path('#/movies');
    	} else {
    		Series.save($scope.save);
    		$location.path('#/series');
    	}
    	
    }
    
})