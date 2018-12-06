package com.example.administrator.myloginui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_login;
    private Button btn_registered;
    private String inputPassword = "0000";
    private String inputNumber = "0000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UI();
    }
    public void UI(){
        btn_login =(Button) findViewById(R.id.btn_mainactivity_login);
        btn_registered = (Button)findViewById(R.id.bt_registered);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.actionStart(MainActivity.this,inputNumber,inputPassword);
            }
        });
        btn_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,registeredActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    inputNumber = data.getStringExtra("1");
                    inputPassword = data.getStringExtra("2");
                }
        }
    }
}
