package nick.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText userName,password,email,age;
    Button register;
    Intent intent;
    private String PREF_FILE;
    String EMAIL,USERNAME,PASSWORD,AGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText)findViewById(R.id.editText_email);
        userName = (EditText)findViewById(R.id.editText_user);
        password= (EditText)findViewById(R.id.editText_password);
        age = (EditText)findViewById(R.id.editText_age);
        register = (Button) findViewById(R.id.register);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.length() != 0 && userName.length() != 0 && password.length() != 0 && age.length() != 0){
                    Intent intent = new Intent();
                    intent.setClass(RegisterActivity.this,UserHomePage.class);
                    startActivity(intent);
                    restore();
                }else{
                    Toast.makeText(RegisterActivity.this, "欄位不可空白", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private  void restore() {
        SharedPreferences settings = getSharedPreferences(PREF_FILE,MODE_PRIVATE);

        settings.edit().putString(EMAIL,email.getText().toString()).commit();
        settings.edit().putString(USERNAME,userName.getText().toString()).commit();
        settings.edit().putString(PASSWORD,password.getText().toString()).commit();
        settings.edit().putString(AGE,age.getText().toString()).commit();
        Toast.makeText(RegisterActivity.this, "註冊成功", Toast.LENGTH_SHORT).show();
    }
}
