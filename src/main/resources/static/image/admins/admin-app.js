app = angular.module("admin-app",["ngRoute"]);

app.config(function($routeProvider){
    $routeProvider
    .when("/product",{
        templateUrl:"/image/admins/product/index.html",
        controller:"product-ctrl"
    })

    .when("/authorize",{
        templateUrl:"/image/admins/authority/index.html",
        controller:"authority-ctrl"
    })
    
    .when("/category",{
        templateUrl:"/image/admins/category/index.html",
        controller:"category-ctrl"
    })
    
     .when("/user",{
        templateUrl:"/image/admins/user/index.html",
        controller:"user-ctrl"
    })

    .when("/unauthorized",{
        templateUrl:"/image/admins/authority/unauthorized.html",
        controller:"authority-ctrl"
    })
    .otherwise({
        template:"<h1 class='text-center'>Administration</h1>"
    });
});