package com.example.thoailun.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by THOAILUN on 03/13/18.
 */

public class StaffAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<Staff> staffList;

    public StaffAdapter(Context context, int layout, List<Staff> staffList) {
        this.context = context;
        this.layout = layout;
        this.staffList = staffList;
    }

    @Override
    public int getCount() {
        return staffList.size();
        // tra ve so dong cua list view
    }

    @Override
    public Object getItem(int i) {
        // return object
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView txtUername = (TextView) view.findViewById(R.id.txtUsername);
        ImageView imgStaff = (ImageView) view.findViewById(R.id.imgStaff);

        // get value
        Staff staff = staffList.get(i);
        txtUername.setText(staff.getStaffUsername());
        imgStaff.setImageResource(staff.getStaffImage());
        return view;
    }
}
