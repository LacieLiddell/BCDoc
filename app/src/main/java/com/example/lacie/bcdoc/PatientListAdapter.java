package com.example.lacie.bcdoc;

import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.ViewHolder>{
//    ArrayList<String> name;
//    ArrayList<String> historyDate;
//    ArrayList<String> diseases;
    String []name;
    String [] disseases;
    String[] drugs;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(CardView cardView, int position);
    }

    public PatientListAdapter(String[] name, String[] disseases, String[] drugs,
                              OnItemClickListener listener){
        this.name = name;
        this.drugs = drugs;
        this.disseases = disseases;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_card, parent, false);
        return  new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position)  {

        final CardView cardView = holder.cardView;
        TextView nameView = cardView.findViewById(R.id.name);
        nameView.setText(name[position]);
        TextView disease = cardView.findViewById(R.id.patient_id);
        disease.setText(disseases[position]);
        TextView rw = cardView.findViewById(R.id.dr_name);
        rw.setText(drugs[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "Трогнуто: позиция" + holder.getAdapterPosition());
                listener.onItemClick(cardView, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }


    }



}
