package com.snape.shivichu.sessionmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.snape.shivichu.sessionmanager.utils.SessionManager;

/**
 * Created by Shivichu on 01-11-2017.
 */

public class SecondActivity extends AppCompatActivity {

    Button bLogout;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sessionManager = new SessionManager(this);

        bLogout = (Button)findViewById(R.id.btn_logout);

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sessionManager.setLogin(false);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
