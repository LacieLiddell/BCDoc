package com.example.lacie.bcdoc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AuthFragment extends Fragment {
    public String login;
    Button confirmButton;
    EditText loginEdit;
    Bundle bundle;
    public String name;
    public String lastName;
    String jsonString;
    JSONArray arrayResults;
    JSONObject objectResult;
    ArrayList<String> patients;
    ArrayList<String> historyDate;
    ArrayList<String> diseases;
    private final NetworkManager.OnRequestCompleteListener queryListener =
            new NetworkManager.OnRequestCompleteListener(){

                @Override
                public void onRequestComplete(final String body) {
                    getActivity().runOnUiThread(new Runnable(){
                         @Override
                         public void run() {
                             try {
                                 arrayResults = new JSONArray(body);
                                 patients = new ArrayList<>();
                                 historyDate = new ArrayList<>();
                                 diseases = new ArrayList<>();

                                 for (int i = 0; i < arrayResults.length(); i++){
                                     objectResult = arrayResults.getJSONObject(i);
                                     if (objectResult.getString("doctor_id").equals(login)){
                                         patients.add(objectResult.getString("patient_id"));
                                         historyDate.add(objectResult.getString("created_at"));
                                         diseases.add(objectResult.getString("record"));
                                     }

                                 }
                             } catch (JSONException e) {
                                 e.printStackTrace();
                             }

                         }
                     });
                }
            };

    public AuthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_auth, container, false);
        loginEdit = v.findViewById(R.id.login_edit);
        confirmButton = v.findViewById(R.id.confirm_button);
        bundle = new Bundle();
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkManager.getINSTANCE()
                        .get("http://188.225.34.176:3000/api/History", queryListener);
                    login = loginEdit.getText().toString();
//                    Bundle bundle = new Bundle();
//                    bundle.putStringArrayList("patient", patients);
//                    bundle.putStringArrayList("date", historyDate);
//                    bu
                    Fragment fragment = new PatientListFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();


            }
        });
        return v;
    }




}
