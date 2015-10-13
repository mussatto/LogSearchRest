var logSearchApp = angular.module('logSearchApp', []);
var searchUrl = "http://localhost:8080/services/search";

logSearchApp.controller('SearchController', function ($scope) {

  $scope.loglines=[];

  $scope.doSearch = function(){
    var queryString = $("#query").val();

    $.post(searchUrl, {queryString: queryString}, function(loglines){
            $scope.loglines=[];
            $scope.loglines=loglines;
        });
  };



});