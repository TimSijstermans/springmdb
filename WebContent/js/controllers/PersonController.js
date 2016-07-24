app.controller('PersonController', function($scope, Person) {
    Person.query(function(data) {
        $scope.persons = data;
    });
})