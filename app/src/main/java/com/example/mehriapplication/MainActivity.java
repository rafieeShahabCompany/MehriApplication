package com.example.mehriapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mehriapplication.MOVIE.MOVIE;
import com.example.mehriapplication.MOVIE.Search;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    DataBaseHandler handler;
    List<Search> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new DataBaseHandler(MainActivity.this, "STAR", null,1);
        final EditText edtText = findViewById(R.id.edtText);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnSave = findViewById(R.id.btnSave);
        final RecyclerView recycler = findViewById(R.id.recycler);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieName = edtText.getText().toString();
                String address = "http://www.omdbapi.com/?s=" + movieName + "&apikey=b3421f5b";
                AsyncHttpClient client = new AsyncHttpClient();
                client.get(address, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        System.out.println(response.toString());
                        Gson gson = new Gson();
                        MOVIE MOVIE = gson.fromJson(response.toString(), com.example.mehriapplication.MOVIE.MOVIE.class);


                        List<Search> list = MOVIE.getSearch();
                        Adapter adapter = new Adapter(list);
                        recycler.setAdapter(adapter);
                        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }
                });
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list != null){
                    handler.addData(list);
                }
            }
        });
            }




    }

