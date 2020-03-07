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
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_question);

        View addQuestion = findViewById(R.id.button);
        addQuestion.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the question
                EditText editText = findViewById(R.id.question);
                String text = editText.getText().toString();

                // prepare the JSON data
                JSONObject postData = new JSONObject();
                try {
                    postData.put("question", text);
                    postData.put("id", "CS");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // send the question
                String url = "https://gt-onboarding.appspot.com/qna";
                new SendDeviceDetails().execute(url, postData.toString());

                // return to the discussion
                Intent intent = new Intent(getApplicationContext(), Discussion.class);
                startActivity(intent);
            }
        });
    }
}
