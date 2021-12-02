app.controller("user-ctrl",function($scope,$http,$location){
	$scope.items = [];
	$scope.form ={};
	
	
	   $scope.initialize = function(){
       
        $http.get("/rest/accounts").then(resp => {
            $scope.items = resp.data;
        });
          // load authorities
         $http.get("/rest/authorities?admin=false").then(resp => {
        	$scope.authorities = resp.data;
        }).catch(error => {
        	$location.path("/unauthorized");
        }) 
 		
    }
    //khoi dau
    $scope.initialize();
     //xoa form
    $scope.reset= function(){
		$scope.form = {
		
			ivailable:true,
		};
    }
      //hien thi len form
    $scope.edit = function(acc){
        $scope.form = angular.copy(acc);
        $(".nav-tabs a:eq(0)").tab('show');
    }
      //them sp moi
    $scope.create = function(){
	    var item = angular.copy($scope.form);
        $http.post(`/rest/accounts`,item).then(resp => {
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm mới thành công!");
        }).catch(error => {
            alert("Lỗi thêm mới !");
            console.log("Error",error);
        });
    }
      //cap nhat sp
    $scope.update = function(){
	    var acc = angular.copy($scope.form);
        $http.put(`/rest/accounts/${acc.username}`,acc).then(resp => {
            var index = $scope.items.findIndex(p => p.username == acc.username);
            $scope.items[index] = acc;
            $scope.reset();
            alert("Cập nhật thành công!");
        }).catch(error => {
            alert("Lỗi cập nhật!");
            console.log("Error",error);
        });
    }
    //xoa
     $scope.delete = function(item){
    	$http.delete(`/rest/accounts/${item.username}`).then(resp => {
    		var index = $scope.items.findIndex(a => a.username == item.username);
    		$scope.items.splice(index, 1);
    		alert("Thành công");
    	}).catch(error =>{
    		alert(" Thất bại");
    		console.log("Error",error);
    	})
    }
   
    
        //phan trang
    $scope.pager = {
        page: 0,
        size: 10,
       //lọc sp theo trang
        get items(){
            var start = this.page * this.size;
            return $scope.items.slice(start,start + this.size);
        },
        get count(){
            return Math.ceil(1.0 *$scope.items.length / this.size)
        },
        first(){
        	this.page = 0;
        },
        prev(){
        	this.page--;
        	if(this.page<0){
        		this.last();
        	}
        },
        next(){
        	this.page++;
        	if(this.page>=this.count){
        		this.first();
        	}
        },
        last(){
        	this.page = this.count - 1;
        }
	}
	
	
})