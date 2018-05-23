package com.example.lacie.bcdoc;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class PatientHistoryAdapter extends RecyclerView.Adapter<PatientHistoryAdapter.ViewHolder>{
    private String [] drugs;
    private String [] disease;

    public PatientHistoryAdapter(String[] drugs, String [] disease){
        this.drugs = drugs;
        this.disease = disease;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_card, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView disName = cardView.findViewById(R.id.date);
        disName.setText(disease[position]);
        TextView drugName = cardView.findViewById(R.id.patient_name);
        drugName.setText(drugs[position]);
        TextView dr = cardView.findViewById(R.id.disease);
        dr.setText("Alex");
    }

    @Override
    public int getItemCount() {
        return drugs.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }
}
