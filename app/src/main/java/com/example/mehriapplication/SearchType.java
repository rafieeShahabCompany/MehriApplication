package com.example.mehriapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_type);

        Button btnON = findViewById(R.id.btnON);
        Button btnOFF = findViewById(R.id.btnOFF);

        btnON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchType.this , MainActivity.class);
                startActivity(i);
            }
        });
        btnOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchType.this,Offline.class);
                startActivity(i);

            }
        });
    }
}
