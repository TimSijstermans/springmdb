app.controller('SeriesDetailController', function($scope, $routeParams, Series) {
	$scope.series = Series.get({id:$routeParams.id});
	
})
