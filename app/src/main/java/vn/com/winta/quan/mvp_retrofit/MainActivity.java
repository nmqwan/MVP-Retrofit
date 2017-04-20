package vn.com.winta.quan.mvp_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.com.winta.quan.mvp_retrofit.Model.User;
import vn.com.winta.quan.mvp_retrofit.Presenter.Login.ILoginListener;
import vn.com.winta.quan.mvp_retrofit.Presenter.Login.PresenterLogin;

public class MainActivity extends AppCompatActivity implements ILoginListener {
    private Button btnLogin;
    private EditText edtUser, edtPass;
    private PresenterLogin presenterLogin;
    private TextView txtResult,txtResult2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        setEvent();
    }

    void initData() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtPass = (EditText) findViewById(R.id.edPass);
        edtUser = (EditText) findViewById(R.id.edtUser);
        txtResult= (TextView) findViewById(R.id.txtResult);
        txtResult2= (TextView) findViewById(R.id.txtResult1);
    }

    void setEvent() {
        btnLogin.setOnClickListener(v -> {
            presenterLogin = new PresenterLogin(this,edtUser.getText().toString()
                    ,edtPass.getText().toString(),txtResult,this);
            presenterLogin.loginPresenter();
        });
    }

    @Override
    public void getUser(User u) {
        txtResult2.setText(u.toString());
    }
}
