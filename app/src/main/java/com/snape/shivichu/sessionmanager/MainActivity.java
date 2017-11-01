package com.snape.shivichu.sessionmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.snape.shivichu.sessionmanager.utils.SessionManager;

public class MainActivity extends AppCompatActivity {

    EditText eEmail,ePwd;
    String sEmail,sPwd;
    Button bLogin;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Session manager
        sessionManager = new SessionManager(getApplicationContext());

        // Check if user is already logged in or not
        if (sessionManager.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
            finish();
        }

        //CASTING WIDGETS
        eEmail = (EditText)findViewById(R.id.edt_email);
        ePwd = (EditText)findViewById(R.id.edt_pwd);
        bLogin = (Button)findViewById(R.id.btn_login);


        eEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence!=null)
                {
                    sEmail = eEmail.getText().toString().trim();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        ePwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence!=null)
                {
                    sPwd = ePwd.getText().toString().trim();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(sEmail.equals("admin"))
                {
                    if(sPwd.equals("admin"))
                    {

                        sessionManager.setLogin(true);
                        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
