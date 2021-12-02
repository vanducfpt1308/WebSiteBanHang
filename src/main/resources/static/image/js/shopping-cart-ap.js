/**
 * 
 */
const app = angular.module("shopping-cart-ap", []);

app.controller("shopping-cart-ctrl",function($scope,$http){

	$scope.cart={
		items: [],
		//them
		add(id){
			
			var item=this.items.find(item => item.id == id);
			if(item){
				item.qty ++;
				this.saveToLocalStorage();
			}else{
				$http.get(`/rest/product/${id}`).then(resp => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
				} )
			}
		
			
		},
		//tong so luong cac mat hang
		get count(){
			return this.items
			.map(item => item.qty)
			.reduce((total, qty)=> total += qty, 0);
		},
		//xoa sp
		remove(id){
			var index= this.items.findIndex(item=>item.id==id);
			this.items.splice(index,1);
			this.saveToLocalStorage();
		},
		// xoa het sp
		clear(){
			this.items=[]
			this.saveToLocalStorage();
		
		
		},
		//tong tien
		get amount(){
			return this.items
			.map(item => item.qty * item.price)
			.reduce((total, qty)=> total += qty, 0);
		},
		
		//luu vao gio hang local
		
		saveToLocalStorage(){
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart",json);		
		},
		
		//doc gio hang tu local
		
		loadFromLocal(){
		 var json = localStorage.getItem("cart");
		 this.items = json ? JSON.parse(json):[];
		
		},
		
		
	}
	
	$scope.cart.loadFromLocal();
	
	$scope.order={
		createDate:new Date(),
		address:"",
		account:{username:$("#username").text()},
		get orderDetails(){
			return $scope.cart.items.map(item => {
				return{
					product:{id: item.id},
					price: item.price,
					quantity: item.qty
				}
			
			});
		
		},
		purchase(){
			var order = angular.copy(this);
			//thuc hien dat hang
			$http.post("/rest/orders",order).then(resp => {
					alert("Đặt Hàng Thành Công");
					$scope.cart.clear();
					location.href="/order/detail/"+ resp.data.id;
				
			}).catch(error=>{
				alert("Lỗi đặt")
				console.log(error)
			
			})
		
		}
	}	
	
})