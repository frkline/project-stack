'use strict';

/* Controllers */

var app = angular.module('app', ['ui.bootstrap']);
app.controller('DropdownCtrl', ['$scope',
    function($scope) {
        $scope.items = [
            'hello dan 3',
            'And another choice for you.',
            'but wait! A third!'
        ];

        $scope.status = {
            isopen: false
        };

        $scope.toggled = function(open) {
            if(console) {
                console.log('Dropdown is now: ', open);
            }
        };

        $scope.toggleDropdown = function($event) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.status.isopen = !$scope.status.isopen;
        };
    }]);
