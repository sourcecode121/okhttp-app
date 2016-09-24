package com.example.okhttp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String resp;
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://api.github.com/users/sourcecode121/repos")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    resp = response.body().string();
                    Log.d("RESPONSE", resp);
                    return resp;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }.execute();
    }
}
