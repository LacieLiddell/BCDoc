package com.example.lacie.bcdoc;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatientInfoFragment extends Fragment {
    public String name;
    public String lastName;

    public PatientInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_patient_info, container, false);
        TextView nameInfo = v.findViewById(R.id.name_info);
        nameInfo.setText(name);
        TextView lastNameInfo = v.findViewById(R.id.last_name_info);
        lastNameInfo.setText(lastName);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.container_info, new PatientHistoryFragment());
        transaction.addToBackStack(null);
        transaction.commit();
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
        lastName = getArguments().getString("lastName");
    }
}
