angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/products';
    $scope.loadProducts = function () {
        $http.get(contextPath + '/allJSON').then(function (response) {
            $scope.products = response.data;
        });};

        $scope.deleteProduct = function (productId) {
            $http.get(contextPath + '/delete/' + productId)
            $scope.loadProducts();
        };
    $scope.loadProducts();
});