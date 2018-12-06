package com.example.administrator.myloginui;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button bnt_login;
    private EditText edt_number;
    private EditText edt_password;
    private String inputNumber;
    private String inputPassword;
    private Toolbar toolbar;
    private SharedPreferences sharedPreferences;
    private String SP_USERNUMBER = "sp_usernumber";
    private String SP_PASSWORD = "sp_password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();
        inputNumber = intent.getStringExtra("1");
        inputPassword = intent.getStringExtra("2");
        initUI();
        initData();
    }

    public void initUI(){
        edt_number = (EditText)findViewById(R.id.edit_username);
        edt_password = (EditText)findViewById(R.id.edit_password);
        bnt_login = (Button)findViewById(R.id.btn_loginactivity_login);
        bnt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_number.getText().toString().equals(inputNumber)&& edt_password.getText().toString().equals(inputPassword)){
                        //实例化SharedPreferences 对象
                        sharedPreferences = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(SP_USERNUMBER,inputNumber);
                        editor.putString(SP_PASSWORD,inputPassword);
                        editor.commit();
                    Intent intent = new Intent(LoginActivity.this,ItemActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
        toolbar = (Toolbar)findViewById(R.id.toolbar_login);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public static void actionStart(Context context,String inputNumber,String inputPassword){
        Intent intent = new Intent(context,LoginActivity.class);
        intent.putExtra("1",inputNumber);
        intent.putExtra("2",inputPassword);
        context.startActivity(intent);
    }
    public void initData(){
        if(sharedPreferences == null){
            sharedPreferences = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        edt_number.setText(sharedPreferences.getString(SP_USERNUMBER,""));
        edt_password.setText(sharedPreferences.getString(SP_PASSWORD,""));
    }
}
