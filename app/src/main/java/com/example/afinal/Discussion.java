package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Discussion extends AppCompatActivity {
    WebView myWebView;
//    public class DownloadTask extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... urls) {
//            // receive data from /qna
//            String result = "";
//            URL url;
//            HttpURLConnection urlConnection = null;
//            try {
//                url = new URL(urls[0]);
//                urlConnection = (HttpURLConnection) url.openConnection();
//                InputStream in = urlConnection.getInputStream();
//                InputStreamReader reader = new InputStreamReader(in);
//                int data = reader.read();
//
//                while (data != -1) {
//                    char current = (char) data;
//                    result += current;
//                    data = reader.read();
//                }
//
//                return result;
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            // display questions
//            ListView listView = findViewById(R.id.listView);
//            final ArrayList<String> arr = new ArrayList<>();
//            final ArrayList<String> replies = new ArrayList<>();
//            try {
//                JSONArray jsonArray = new JSONArray(s);
//                for (int i = 0; i < jsonArray.length(); i++) {
//                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                    arr.add(jsonObject.getString("question"));
//                    replies.add(jsonObject.getString("replies"));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Discussion.this, android.R.layout.simple_list_item_1, arr);
//            listView.setAdapter(arrayAdapter);
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
//                    // pass value to reply
//                    // switch to ReplyActivity
//                    Intent intent = new Intent(getApplicationContext(), ReplyActivity.class);
//                    intent.putExtra("reply", replies.get(i));
//                    intent.putExtra("question", arr.get(i));
//                    startActivity(intent);
//                }
//            });
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);

        // Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.discussion);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.discussion:
                        return true;
                    case R.id.checklist:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        // add question
        View addQuestion = findViewById(R.id.addQuestion);
        addQuestion.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PostQuestion.class);
                startActivity(intent);
            }
        });

        // webview
        myWebView = findViewById(R.id.webView);
        myWebView.loadUrl("https://gt-onboarding.appspot.com/advisor/discussForAndroid");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());

        // fetch data
//        DownloadTask task = new DownloadTask();
//        task.execute("https://gt-onboarding.appspot.com/qna");

    }

    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            finish();
        }
    }
}
