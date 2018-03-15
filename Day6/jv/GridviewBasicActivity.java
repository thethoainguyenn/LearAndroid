package com.example.thoailun.day5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class GridviewBasicActivity extends AppCompatActivity {
    GridView gvStaff;
    String[] arr = {"Ti", "Teo", "Tun"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_basic);
        gvStaff = (GridView) findViewById(R.id.gvStaff);

        ArrayAdapter adapter = new ArrayAdapter(GridviewBasicActivity.this, android.R.layout.simple_list_item_1, arr);
        gvStaff.setAdapter(adapter);
        gvStaff.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridviewBasicActivity.this, "" + i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
