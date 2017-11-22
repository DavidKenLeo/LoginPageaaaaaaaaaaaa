package nick.loginpage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userName,password;
    Button signIn;
    TextView register;
    String USERNAME,PASSWORD;

    private String PREF_FILE;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences getInfo = getSharedPreferences(PREF_FILE,MODE_PRIVATE);
                final String NAME = getInfo.getString(USERNAME,"");
                final String PASS = getInfo.getString(PASSWORD,"");

                if (userName.length() == 0 || password.length() == 0) {
                    Toast.makeText(LoginActivity.this, "欄位不可空白", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (userName.getText().toString().equals(NAME) && password.getText().toString().equals(PASS)) {
                        Intent intent = new Intent();
                        intent.setClass(LoginActivity.this, UserHomePage.class);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "帳號驗證成功", Toast.LENGTH_SHORT).show();
                    } else if (!userName.getText().toString().equals(NAME) || !password.getText().toString().equals(PASS)) {
                        Toast.makeText(LoginActivity.this, "帳號驗證失敗", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    void findView(){
        userName = (EditText) findViewById(R.id.editText_user);
        password = (EditText) findViewById(R.id.editText_pass);
        signIn = (Button) findViewById(R.id.button);
        register = (TextView) findViewById(R.id.textView);
        context=this;
    }
}
