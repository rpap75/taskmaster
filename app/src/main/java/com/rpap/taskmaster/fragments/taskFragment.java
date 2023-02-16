package com.rpap.taskmaster.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rpap.taskmaster.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link taskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class taskFragment extends Fragment {

    public taskFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static taskFragment newInstance(String param1, String param2) {
        taskFragment fragment = new taskFragment();
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