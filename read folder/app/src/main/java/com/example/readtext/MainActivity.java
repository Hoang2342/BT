package com.example.readtext;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 100;
    Button read;
    ArrayList<String> myList;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.list);
        read = findViewById(R.id.read);
        myList = new ArrayList<>();
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = Environment.getExternalStorageState();
                if (Environment.MEDIA_MOUNTED.equals(state)) {
                    if (Build.VERSION.SDK_INT > = 23) {
                        if (checkPermission()) {
                            File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/");
                            if (dir.exists()) {
                                Log.d("path", dir.toString());
                                File list[] = dir.listFiles();
                                for (int i = 0; i < list.length; i++) {
                                    myList.add(list[i].getName());
                                }
                                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, myList);
                                listview.setAdapter(arrayAdapter);
                            }
                        } else {
                            requestPermission(); // Code for permission
                        }
                    } else {
                        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/");
                        if (dir.exists()) {
                            Log.d("path", dir.toString());
                            File list[] = dir.listFiles();
                            for (int i = 0; i < list.length; i++) {
                                myList.add(list[i].getName());
                            }
                            ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, myList);
                            listview.setAdapter(arrayAdapter);
                        }
                    }
                }
            }
        });
    }
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(MainActivity.this,          android.Manifest.permission.READ_EXTERNAL_STORAGE);
        if (result = = PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,  android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Toast.makeText(MainActivity.this, "Write External Storage permission allows us to read  files.
                    Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]
                    {android.Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] = = PackageManager.PERMISSION_GRANTED) {
                Log.e("value", "Permission Granted, Now you can use local drive .");
            } else {
                Log.e("value", "Permission Denied, You cannot use local drive .");
            }
            break;
        }
    }
}