package com.example.asm_lambtph16545.API;

import com.example.asm_lambtph16545.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AipService {
    Gson  GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    //https://www.flickr.com/services/rest/?method=flickr.favorites.getList&api_key=1622d179971cf6e08e6e32fe03a5dd05&extras=views%2Csurl_sq%2C+url_t%2C+url_s%2C+url_q%2C+url_m%2C+url_n%2C+url_z%2C+url_o&per_page=&format=json&nojsoncallback=1&auth_token=72157720852401324-774ce3ae569460ec&api_sig=011d0a2c735af9776dd7eefeb8597716
   AipService AIP_SERVICE = new Retrofit.Builder()
            .baseUrl("https://www.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .build()
            .create(AipService.class);
    @GET("services/rest/?method=flickr.favorites.getList&api_key=265119453760b491f16e23598ed27c6b&extras=views%2Csurl_sq%2C+url_t%2C+url_s%2C+url_q%2C+url_m%2C+url_n%2C+url_z%2C+url_o&per_page=50&format=json&nojsoncallback=1&auth_token=72157720852637368-e58cac92e6898ec0&api_sig=9a5376343ae8ba50aef9e6c87545ed18")
    Call<User> getAPI();
//@GET("services/rest/?method=flickr.favorites.getList&api_key=21197a5a96d999bb72ad108eb2c028b5&extras=views%2Csurl_sq%2C+url_t%2C+url_s%2C+url_q%2C+url_m%2C+url_n%2C+url_z%2C+url_o&per_page=50&format=json&nojsoncallback=1&auth_token=72157720852322424-825ddae1993462c4&api_sig=c1a5df158d02ce4bc087bade31fbeb8d")
//Call<User> getAPI();

}
