package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // login
        View checklistView = findViewById(R.id.button);
        checklistView.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get username
                EditText usernameEditText = findViewById(R.id.username);
                String username = usernameEditText.getText().toString();
                // get password
                EditText passwordEditText = findViewById(R.id.password);
                String password = passwordEditText.getText().toString();

//                try {
//                    URL url = new URL ("https://gt-onboarding.appspot.com/login");
//                    HttpURLConnection con = (HttpURLConnection)url.openConnection();
//                    con.setRequestMethod("POST");
//                    con.setRequestProperty("Content-Type", "application/json; utf-8");
//                    con.setRequestProperty("Accept", "application/json");
//                    con.setDoOutput(true);
//
//                    JSONObject postData = new JSONObject();
//                    postData.put("username", username);
//                    postData.put("password", password);
//                    String jsonInputString = postData.toString();
//
//                    try(OutputStream os = con.getOutputStream()) {
//                        byte[] input = jsonInputString.getBytes("utf-8");
//                        os.write(input, 0, input.length);
//                    }
//
//                    try(BufferedReader br = new BufferedReader(
//                            new InputStreamReader(con.getInputStream(), "utf-8"))) {
//                        StringBuilder response = new StringBuilder();
//                        String responseLine = null;
//                        while ((responseLine = br.readLine()) != null) {
//                            response.append(responseLine.trim());
//                        }
//                        System.out.println(response.toString());
//                    }
//                } catch (IOException | JSONException e) {
//                    e.printStackTrace();
//                }

//                Log.e("TAG", data);
//                if (data != null && !data.equals("")) {
                    Intent intent = new Intent(getApplicationContext(), Checklist.class);
                    startActivity(intent);
//                }
            }
        });
    }
}
