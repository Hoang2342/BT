package com.example.giaodiengmail;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemModel> items;
    TextView text1, text2 ;
    List<Name> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text_view1);
        text2 = findViewById(R.id.text_view2);
        items = new ArrayList<>();



        for (int i = 1; i <= 20 ; i++) {
            items.add(new ItemModel("Google","G"));

        }
        ItemAdapter adapter = new ItemAdapter(items);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }
}