var logSearchApp = angular.module('logSearchApp', []);
var searchUrl = "http://localhost:8080/services/search";

logSearchApp.controller('SearchController', function ($scope, $http) {

  $scope.loglines=[];

  $scope.doSearch = function(){
    var queryString = $("#query").val();

    $.post(searchUrl,{"queryString":queryString},function(data){
        $scope.$apply(function(){
            $scope.loglines=data;
        });
    });

  };

  function processLogline(data){
    var logline={logLineNumber:"1", log:"my log"};
    $scope.loglines.push(logline);
  };



});