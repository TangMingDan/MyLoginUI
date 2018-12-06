package com.example.administrator.myloginui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registeredActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button bnt_registered;
    private EditText edt_number;
    private EditText edt_password;
    private SharedPreferences sharedPreferences;
    private String SP_NEW_USERNUMBER = "sp_usernumber";
    private String SP_NEW_PASSWORD = "sp_password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        initUI();
        initData();
    }

    public void initData(){
            sharedPreferences = getApplicationContext().getSharedPreferences("new", Context.MODE_WORLD_WRITEABLE);

        edt_number.setText(sharedPreferences.getString(SP_NEW_USERNUMBER,""));
        edt_password.setText(sharedPreferences.getString(SP_NEW_PASSWORD,""));
    }

    private void initUI() {
        toolbar = (Toolbar)findViewById(R.id.toolbar_registered);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        edt_number = (EditText)findViewById(R.id.edit_registered_username);
        edt_password = (EditText)findViewById(R.id.edit_registered_password);
        bnt_registered = (Button)findViewById(R.id.btn_registeredactivity_registered);
        bnt_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        //实例化SharedPreferences 对象
                        sharedPreferences = getApplicationContext().getSharedPreferences("new", Context.MODE_WORLD_WRITEABLE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(SP_NEW_USERNUMBER,edt_number.getText().toString());
                        System.out.println(edt_number.getText().toString());
                        editor.putString(SP_NEW_PASSWORD,edt_password.getText().toString());
                        editor.commit();
                        Toast.makeText(registeredActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                        Intent intent =new Intent();
                        intent.putExtra("1",edt_number.getText().toString());
                        intent.putExtra("2",edt_password.getText().toString());
                        setResult(RESULT_OK,intent);
                        finish();
                }
        });
    }
}
