/**
 * Created by tim on 22-7-16.
 */
app.controller('ScreenplayController', function($scope, $http) {
    $scope.message = 'Check this screenplay out!';

    $http({method: 'GET', url: 'api/screenplays/'}).success(function(data)
    {
        $scope.screenplays = data; // response data
    });

})