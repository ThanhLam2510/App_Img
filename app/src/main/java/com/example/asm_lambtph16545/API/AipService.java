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
    //https://www.flickr.com/services/rest/?method=flickr.favorites.getList&api_key=22ecd0f164a5d2a638b151f3a83d0ff2&extras=views%2Csurl_sq%2C+url_t%2C+url_s%2C+url_q%2C+url_m%2C+url_n%2C+url_z%2C+url_o&per_page=50&format=json&nojsoncallback=1&auth_token=72157720856911171-f73fa7c4f9d5df90&api_sig=f530c82095e31bf5fb76361380002e2f
   AipService AIP_SERVICE = new Retrofit.Builder()
            .baseUrl("https://www.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .build()
            .create(AipService.class);
    @GET("services/rest/?method=flickr.favorites.getList&api_key=22ecd0f164a5d2a638b151f3a83d0ff2&extras=views%2Csurl_sq%2C+url_t%2C+url_s%2C+url_q%2C+url_m%2C+url_n%2C+url_z%2C+url_o&per_page=50&format=json&nojsoncallback=1&auth_token=72157720856911171-f73fa7c4f9d5df90&api_sig=f530c82095e31bf5fb76361380002e2f")
    Call<User> getAPI();
//@GET("services/rest/?method=flickr.favorites.getList&api_key=21197a5a96d999bb72ad108eb2c028b5&extras=views%2Csurl_sq%2C+url_t%2C+url_s%2C+url_q%2C+url_m%2C+url_n%2C+url_z%2C+url_o&per_page=50&format=json&nojsoncallback=1&auth_token=72157720852322424-825ddae1993462c4&api_sig=c1a5df158d02ce4bc087bade31fbeb8d")
//Call<User> getAPI();
}
