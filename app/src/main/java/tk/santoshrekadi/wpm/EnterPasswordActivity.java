package tk.santoshrekadi.wpm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {
   AutoCompleteTextView pass;
    Button login;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);
        getWindow().setBackgroundDrawableResource(R.drawable.background);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        SharedPreferences settings = getSharedPreferences("PREFS",0);
        password=settings.getString("password","");

        pass=findViewById(R.id.pwd);
        login=findViewById(R.id.Enter);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=pass.getText().toString();

                if(text.equals(password)){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                }else {
                    Toast.makeText(EnterPasswordActivity.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
