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
                templateUrl: 'views/screenplays/screenplays.html',
                controller: 'ScreenplayController'
            })
            .when('/screenplays/new', {
                templateUrl: 'views/screenplays/newscreenplay.html',
                controller: 'NewScreenplayController'
            })
            .when('/screenplays/series', {
                templateUrl: 'views/screenplays/series.html',
                controller: 'ScreenplayController'
            })
            .when('/screenplays/series/:id', {
                templateUrl: 'views/screenplays/seriesdetail.html',
                controller: 'SeriesDetailController'
            })
            .when('/screenplays/movies', {
                templateUrl: 'views/screenplays/movies.html',
                controller: 'ScreenplayController'
            })
            .when('/screenplays/movies/:id', {
                templateUrl: 'views/screenplays/moviedetail.html',
                controller: 'MovieDetailController'
            })
            .when('/persons', {
                templateUrl: 'views/persons/persons.html',
                controller: 'PersonController'
            })
            .when('/persons/new', {
                templateUrl: 'views/persons/newperson.html',
                controller: 'PersonController'
            })
            .when('/persons/actors', {
                templateUrl: 'views/persons/actors.html',
                controller: 'PersonController'
            })
            .when('/persons/actors/:id', {
                templateUrl: 'views/persons/actordetail.html',
                controller: 'PersonController'
            })
            .when('/persons/directors', {
                templateUrl: 'views/persons/directors.html',
                controller: 'PersonController'
            })
            .when('/persons/directors/:id', {
                templateUrl: 'views/persons/directordetail.html',
                controller: 'PersonController'
            })
            .when('', {redirectTo: '/'})
            .otherwise({redirectTo: '/'});
    });