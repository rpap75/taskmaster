package com.rpap.taskmaster.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rpap.taskmaster.R;

public class taskFragmentTitleStatus extends Fragment {

    public taskFragmentTitleStatus() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static taskFragmentTitleStatus newInstance(String param1, String param2) {
        taskFragmentTitleStatus fragment = new taskFragmentTitleStatus();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_tasks, container, false);
    }
}