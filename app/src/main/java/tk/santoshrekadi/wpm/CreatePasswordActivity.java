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

public class CreatePasswordActivity extends AppCompatActivity {
    AutoCompleteTextView pass,cpass;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);
        getWindow().setBackgroundDrawableResource(R.drawable.beach);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        pass=findViewById(R.id.pwd);
        cpass=findViewById(R.id.cpwd);
        button=findViewById(R.id.Enter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String text1=pass.getText().toString();
                 String text2=cpass.getText().toString();

                 if(text1.equals("")|| text2.equals(""))
                 {
                     Toast.makeText(CreatePasswordActivity.this,"No password Entered!",Toast.LENGTH_SHORT).show();
                 }else
                 {
                     if(text1.equals(text2)){
                         SharedPreferences settings = getSharedPreferences("PREFS",0);
                         SharedPreferences.Editor editor = settings.edit();
                         editor.putString("password",text1);
                         editor.apply();
                         Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                         startActivity(intent);
                         overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                         finish();

                     }
                     else{
                         Toast.makeText(CreatePasswordActivity.this,"Password doesn't match",Toast.LENGTH_SHORT).show();
                     }
                 }
            }
        });
    }
}
