package com.example.thoailun.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.icu.text.LocaleDisplayNames;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

// Intent Explicit

public class MainActivity extends AppCompatActivity {
    Database database;
    ListView lvStaff;
    ArrayList<Staff> arrayStaff;
    StaffAdapter adapter;
    Button btnLogin;
    TextView txtUsername;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String USERNAME_KEY = "user";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ===========
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        sharedPreferences = getSharedPreferences("loginPrefs",MODE_PRIVATE);
        // gan gia tri vao
        txtUsername.setText(sharedPreferences.getString(USERNAME_KEY, ""));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // no khoang trang .trim()
                String un = txtUsername.getText().toString().trim();
                if(un.equals("admin")) {
                    Toast.makeText(MainActivity.this, "THANH CONG", Toast.LENGTH_SHORT).show();
                    editor = sharedPreferences.edit();
                    editor.putString(USERNAME_KEY, txtUsername.toString().toString().trim());
                    editor.commit();
                }
            }
        });
        // lv nang cao
        AnhXa();
        adapter = new StaffAdapter(this, R.layout.line_stafff, arrayStaff);
        lvStaff.setAdapter(adapter);
        // Create database
        database = new Database(this, "staff.sqlite", null, 2);
        // Create table
        database.QueryData("CREATE TABLE IF NOT EXISTS User(Id INTEGER PRIMARY KEY AUTOINCREMENT, UserName VARCHAR(200))");
        // Insert
        //database.QueryData("INSERT INTO User VALUE(null, 'thethoainguyenn1111')");
        // SELECT DATA
        Cursor dataUserInfo = database.GetData("SELECT * FROM User");
        while (dataUserInfo.moveToNext()) {
            String un = dataUserInfo.getString(1);
            Toast.makeText(MainActivity.this, "1111", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "OKKKK", Toast.LENGTH_SHORT).show();

     }
     public  void AnhXa() {
        lvStaff = (ListView) findViewById(R.id.lvStaff);
        arrayStaff = new ArrayList<>();
        arrayStaff.add(new Staff("thethoai",R.drawable.minion));
     }
}
