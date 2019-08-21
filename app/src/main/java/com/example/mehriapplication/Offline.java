package com.example.mehriapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mehriapplication.MOVIE.Search;

import java.util.List;

public class Offline extends AppCompatActivity {
    DataBaseHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);

        handler = new DataBaseHandler(Offline.this,"STAR",null,1);
        Button btnSearch = findViewById(R.id.btnSearch);
        final EditText edtMovieName = findViewById(R.id.edtMovieName);
        final RecyclerView recyclerDataBase = findViewById(R.id.recyclerDataBase);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = edtMovieName.getText().toString();
                List<Search> list = handler.GetData(string);

                Adapter adapter = new Adapter(list);
                recyclerDataBase.setAdapter(adapter);
                recyclerDataBase.setLayoutManager(new LinearLayoutManager(Offline.this, RecyclerView.VERTICAL, false));
            }
        });
    }
}
