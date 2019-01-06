package com.alghubari.myfv.data;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alghubari.myfv.R;

public class PaperFragment extends Fragment {


    public PaperFragment() {
        // Required empty public constructor
    }

    public static PaperFragment newInstance(int page ,String title) {
        PaperFragment fragment = new PaperFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paper, container, false);
    }


}
