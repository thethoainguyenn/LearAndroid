package com.example.thoailun.day4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by THOAILUN on 03/14/18.
 */

public class FragmentListView extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // LayoutInflater: connect
        return inflater.inflate(R.layout.fragment_list_view, container, false);
    }
}
