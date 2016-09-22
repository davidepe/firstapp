package com.example.david.gpsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Temperature extends AppCompatActivity {

    public Button but2;
    public void init2(){
        but2 = (Button)findViewById(R.id.but2);
        but2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent t2 = new Intent(Temperature.this, MainActivity.class);
                startActivity(t2);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        init2();
    }
}
