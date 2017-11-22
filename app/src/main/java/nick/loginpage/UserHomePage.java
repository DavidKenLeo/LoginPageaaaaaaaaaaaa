package nick.loginpage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserHomePage extends AppCompatActivity {

    TextView text;
    private String PREF_FILE;
     String USERNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhomepage);
        text =(TextView)findViewById(R.id.tv_userpage);

        SharedPreferences settings = getSharedPreferences(PREF_FILE,MODE_PRIVATE);
        String name = settings.getString(USERNAME,"");
        text.setText("Welcome!"+name);
    }
}
