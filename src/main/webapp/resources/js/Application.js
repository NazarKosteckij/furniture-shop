$(document).ready(function(){
    $('ul.tabs').tabs();
});

(function() {
    var app = angular.module('catalog', []);

    app.controller('CatalogController', function($http, $scope){
        this.products = null;
        $http.get("/api/products/").then(function(response) {
            $scope.myData = response.data.records;
            console.log(response.data)
        });
    });

    app.controller('TabController', function(){
        this.tab = 1;

        this.setTab = function(tab){
            this.tab=tab;
        };

        this.isSet = function(selectedTab){
            return this.tab === selectedTab;
        };

    });
})();
