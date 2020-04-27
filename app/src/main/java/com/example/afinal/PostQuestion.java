package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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

        // add spinner options
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        String[] items = {"required paperwork", "international student", "campus life", "other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        View addQuestion = findViewById(R.id.button);
        addQuestion.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the question
                EditText editText = findViewById(R.id.question);
                EditText descriptionEditText = findViewById(R.id.discription);
                String text = editText.getText().toString();
                String category = spinner.getSelectedItem().toString();
                String description = descriptionEditText.getText().toString();

                // prepare the JSON data
                JSONObject postData = new JSONObject();
                try {
                    postData.put("question", text);
                    postData.put("description", description);
                    postData.put("id", "CS student");
                    postData.put("category", category);
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

        // back to questions
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
