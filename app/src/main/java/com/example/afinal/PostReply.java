package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostReply extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_reply);

        Intent intent = getIntent();
        final String question = intent.getStringExtra("question");

        // post reply
        final View reply = findViewById(R.id.button);
        reply.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the reply
                EditText editText = findViewById(R.id.reply);
                String text = editText.getText().toString();

                // prepare the JSON data
                JSONObject postData = new JSONObject();
                try {
                    postData.put("question", question);
                    postData.put("comment", text);
                    postData.put("id", "CS");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String url = "https://gt-onboarding.appspot.com/reply";
                new SendDeviceDetails().execute(url, postData.toString());

                // return to reply
                Intent intent = new Intent(getApplicationContext(), Discussion.class);
                startActivity(intent);
            }
        });

        // return to the discussion
        View back = findViewById(R.id.back);
        back.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Discussion.class);
                startActivity(intent);
            }
        });

    }
}
