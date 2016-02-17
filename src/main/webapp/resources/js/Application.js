$(document).ready(function(){
    $('ul.tabs').tabs();
});

(function() {
    var app = angular.module('catalog',  ['ngRoute']);

    app.controller('CatalogController', function($http, $scope, $route, $location){
        this.categories = null;
        this.categoryName = '';
        this.categoryId = parseInt($location.search().id) | null;
        that = this;
        console.log(this.categoryId);
        this.isCurrentCategory = function(id){
            return this.categoryId === id;
        }

        this.getCurrentCategoryName = function(){
            return this.categoryName;
        };

        this.setCategory = function(id){
            this.categoryId = parseInt(id) | null;
            for (var i = 0; i < this.categories.length; i++){
                if(this.categories[i].id === id){
                    this.products = this.categories[i].products;
                    this.categoryName = this.categories[i].name;
                }
            }
            Materialize.fadeInImage('#staggered');
            console.log("set category name " + this.categoryName);
            console.log("set category id " + id);
        };

        $http.get("./api/categories/").then(function(response) {
            that.categories = response.data;
            that.setCategory(that.categoryId == 0 ? that.categories[0].id : that.categoryId);
        });

    });

})();
