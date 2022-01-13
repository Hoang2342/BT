package com.example.testapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ChangeActivity extends AppCompatActivity {
    private EditText outputText;
    private Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_main);
        this.outputText = (EditText)this.findViewById(R.id.editText);
        this.button = (Button) this.findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runExample(view);
            }
        });
    }
            private void runExample(View view) {
                try {
                    Information information = ReadJson.readJSONFile(this);
                    outputText.setText(information.toString());
                } catch(Exception e)  {
                    outputText.setText(e.getMessage());
                    e.printStackTrace();
                }
            }
}
