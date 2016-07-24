/**
 * Created by tim on 22-7-16.
 */
app.controller('ScreenplayController', function($scope, Screenplay, Series, Movie) {
    $scope.message = 'Check this screenplay out!';

    Screenplay.query(function(data) {
        $scope.screenplays = data;
    });
})