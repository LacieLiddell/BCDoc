package com.example.lacie.bcdoc;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{// implements OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, new AuthFragment());
        transaction.commit();
    }

//    @Override
//    public void onItemClick() {
//
//    }

//    public void openPatient(Integer position){
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        PatientHistoryFragment frag = PatientHistoryFragment.newInstance(position);
//        transaction.replace(R.id.container, frag);
//        transaction.commit();
//    }
}
