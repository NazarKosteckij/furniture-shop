$(document).ready(function(){
    $('ul.tabs').tabs();
});

(function() {
    var app = angular.module('catalog', []);

    app.controller('CatalogController', function($http, $scope){
        this.categories = null;
        this.categoryId = 0;
        that = this;

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

            console.log("set category id " + id);
        };

        $http.get("/api/categories/").then(function(response) {
            that.categories = response.data;
            that.categoryId = that.categories[0].id;
        });

    });

})();
