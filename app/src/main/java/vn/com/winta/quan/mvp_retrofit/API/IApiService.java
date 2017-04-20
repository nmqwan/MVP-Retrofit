package vn.com.winta.quan.mvp_retrofit.API;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import vn.com.winta.quan.mvp_retrofit.Model.User;
import vn.com.winta.quan.mvp_retrofit.Util.Util;

/**
 * Created by QWAN on 20/04/2017.
 */

public interface IApiService {
    Retrofit retrofit = new Retrofit.Builder().
            baseUrl(Util.URL_SER)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @FormUrlEncoded
    @POST("login")
    Call<User> login(@Field("user") String user,
                     @Field("pass") String pass);
}
