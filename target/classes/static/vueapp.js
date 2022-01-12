
Vue.component('movie-detail',{

	props:['movie'],
	template:`



	<div class="card text-white bg-dark mb-3"  style="width: 18rem;">
  <img class="card-img-top" v-bind:src="movie.Poster" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">{{movie.Title}}</h5>
    <a href="#" class="btn btn-primary" v-on:click="postData">Add To Watch Later</a>
  </div>
</div>
	

	


	`,

	methods:{

		postData(){
			let movie = {
				Title:this.movie.Title,
				Year:this.movie.Year,
				Poster:this.movie.Poster


			}

			console.log(movie);

		axios.post("http://localhost:8080/film",movie)
		.catch(error => {
  alert(error);
});
	
			

			
			

		

		

		}
	

	}




})


new Vue ({

	el:"#app",
	data:{
		searchKey:'',
		moviesList:[]
	},
	methods:{

		searchMovies(){

			var url ='http://www.omdbapi.com/?s='+this.searchKey+'&apikey=993ea234'
			fetch(url)
			.then(response=>response.json())
			.then(data=>{
				
				if(data.Response ==="True"){
					document.getElementById("error").innerHTML="";
					
				}else{
					let divError= document.getElementById("error");
					divError.innerHTML="movie entered not found";
					divError.style.color="red";
				}

				this.moviesList=data;
			})
		},

		


	

	}








})