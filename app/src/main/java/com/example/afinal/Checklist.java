package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Checklist extends AppCompatActivity {
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        // Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.checklist);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.discussion:
                        startActivity(new Intent(getApplicationContext(),Discussion.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.checklist:
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

//        // switch to Offical Document
//        View checklistView = findViewById(R.id.np_drop_down_1123247_bdbdbd_ek2);
//        checklistView.setOnClickListener(new AdapterView.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), OfficialDocument.class);
//                startActivity(intent);
//            }
//        });

//        View back = findViewById(R.id.np_back_26915_132d57);
//        back.setOnClickListener(new AdapterView.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
//            }
//        });

        // webview
        myWebView = findViewById(R.id.webView);
        myWebView.loadUrl("https://sprint4checklist.appspot.com/test");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
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
