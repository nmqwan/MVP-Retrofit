package vn.com.winta.quan.mvp_retrofit.Presenter.Login;

import android.content.Context;
import android.widget.TextView;

import vn.com.winta.quan.mvp_retrofit.API.ApiService;
import vn.com.winta.quan.mvp_retrofit.Model.User;

/**
 * Created by QWAN on 20/04/2017.
 */

public class PresenterLogin {
    String TAG = PresenterLogin.class.getSimpleName();
    ApiService apiService;
    Context context;
    String username, password;
    ILoginListener listener;
    TextView txt;

    public PresenterLogin(Context context, String username, String password, TextView txt, ILoginListener listener) {
        this.context = context;
        this.username = username;
        this.password = password;
        apiService = new ApiService();
        this.txt = txt;
        this.listener = listener;
    }

    public void loginPresenter() {
        final User[] result = {new User()};
        apiService.login(new ILoginPresenter() {
            @Override
            public void success(User u) {
                listener.getUser(u);
                txt.setText(u.toString());
            }
        }, username, password);
    }
}
