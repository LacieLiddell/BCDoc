package com.example.lacie.bcdoc;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatientHistoryFragment extends Fragment {
    private int position;

    public PatientHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater
                .inflate(R.layout.fragment_patient_history, container, false);
        String[] drugs = getContext().getResources().getStringArray(R.array.drugs);
        String[] disease = getContext().getResources().getStringArray(R.array.diseases);
        PatientHistoryAdapter adapter = new PatientHistoryAdapter(drugs, disease);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        RecyclerView.RecyclerListener
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        return  recyclerView;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        position = getArguments().getInt(String.valueOf(position));
//    }

//    public static PatientHistoryFragment newInstance(Integer position){
//        PatientHistoryFragment fragment = new PatientHistoryFragment();
//        Bundle args = new Bundle();
//        args.putInt("position", position);
//        fragment.setArguments(args);
//        return fragment;
//    }

}
