$(document).ready(function(){
    $('ul.tabs').tabs();
});

(function() {
    var app = angular.module('catalog',  ['ngRoute']);

    app.controller('CatalogController', function($http, $scope, $route, $location){
        this.categories = null;
        this.categoryId = $location.search().id;
        that = this;
        console.log(this.categoryId);
        this.isCurrentCategory = function(id){
            return this.categoryId === id;
        }

        this.setCategory = function(id){
            this.categoryId = id;
            for (category in this.categories){
                if(category.id === id){
                    this.products = category.products;
                }
            }
            Materialize.fadeInImage('#staggered');

            console.log("set category id " + id);
        };

        $http.get("/api/categories/").then(function(response) {
            that.categories = response.data;
            that.categoryId = that.categoryId | that.categories[0].id;
        });

    });

})();
