package vn.com.winta.quan.mvp_retrofit.API;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.winta.quan.mvp_retrofit.Model.User;
import vn.com.winta.quan.mvp_retrofit.Presenter.Login.ILoginPresenter;

/**
 * Created by QWAN on 20/04/2017.
 */

public class ApiService {
    String TAG= ApiService.class.getSimpleName();
    IApiService iService;

    public ApiService() {
        this.iService =IApiService.retrofit.create(IApiService.class);;
    }

    public void login (final ILoginPresenter iLogin, String username, String password){
        Call<User> call= iService.login(username,password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                iLogin.success(response.body());
                Log.e(TAG, "onResponse: "+response.body() );
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.toString() );
            }
        });
    }
}
