/**
 * Created by tim on 22-7-16.
 */
'use strict';
angular.module('mdbApp')
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/home.html',
                controller: 'MainController'
            })
            .when('/screenplays', {
                templateUrl: 'views/screenplays.html',
                controller: 'ScreenplayController'
            })
            .when('/screenplays/series', {
                templateUrl: 'views/series.html',
                controller: 'ScreenplayController'
            })
            .when('/screenplays/movies', {
                templateUrl: 'views/movies.html',
                controller: 'ScreenplayController'
            })
            .when('/persons', {
                templateUrl: 'views/persons.html',
                controller: 'PersonController'
            })
            .when('/persons/actors', {
                templateUrl: 'views/actors.html',
                controller: 'PersonController'
            })
            .when('/persons/directors', {
                templateUrl: 'views/directors.html',
                controller: 'PersonController'
            })
            .otherwise({redirectTo: '/'});
    });