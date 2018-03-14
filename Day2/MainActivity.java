package com.example.thoailun.demo;

import android.content.Intent;
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
import android.widget.Toast;

import java.util.ArrayList;

// Intent Explicit

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    SeekBar skHealth;
    ListView lvMenu;

    ArrayList<String> menus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        skHealth = findViewById(R.id.skHealth);
        lvMenu = findViewById(R.id.lvMenu);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("aaaaaaaaa", "1111");
                Intent intent = new Intent(MainActivity.this, DemoListActivity.class);
                intent.putExtra("username", "nguyen the thoai");
                startActivity(intent);
            }
        });
        // Seek bar ------------
        skHealth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("SK: ", "Gía trị " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // Array --------------------
        menus = new ArrayList<>();
        menus.add("View");
        menus.add("Clipboard");
        menus.add("View2");

        // adapter dung de ket noi
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1, menus);

        lvMenu.setAdapter(adapter);
    }
}
