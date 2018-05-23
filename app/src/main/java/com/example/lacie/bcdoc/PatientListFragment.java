package com.example.lacie.bcdoc;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatientListFragment extends Fragment implements PatientListAdapter.OnItemClickListener{
    String [] names;
    String [] diseases;
    String [] drugs;
//    ArrayList<String> patients;
//    ArrayList<String> historyDate;
//    ArrayList<String> diseases;

    public PatientListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView patientRecycler = (RecyclerView) inflater
                .inflate(R.layout.fragment_patient_list, container, false);
        names = getContext().getResources().getStringArray(R.array.names);
        diseases = getContext().getResources().getStringArray(R.array.diseases);
        drugs = getContext().getResources().getStringArray(R.array.drugs);
//        Bundle bundle = new Bundle();
//        patients = getArguments().getStringArrayList("patient");
//        historyDate = getArguments().getStringArrayList("date");
//        diseases = getArguments().getStringArrayList("diseases");
        //lastNames = getContext().getResources().getStringArray(R.array.last_names);
        PatientListAdapter adapter = new PatientListAdapter(names,
                diseases, drugs, (PatientListAdapter.OnItemClickListener) this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        patientRecycler.setLayoutManager(layoutManager);
        patientRecycler.setAdapter(adapter);
        return patientRecycler;
    }

    @Override
    public void onItemClick(CardView cardView, int position) {
        Bundle bundle = new Bundle();
        TextView nameText = cardView.findViewById(R.id.name);
        bundle.putString("name", nameText.getText().toString());
        TextView disease = cardView.findViewById(R.id.patient_id);
        bundle.putString("disease", disease.getText().toString());
        TextView rw = cardView.findViewById(R.id.dr_name);
        bundle.putString("drugs", rw.getText().toString());
        Fragment fragment = new PatientInfoFragment();
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
