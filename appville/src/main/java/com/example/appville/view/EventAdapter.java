package com.example.appville.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appville.R;
import com.example.appville.model.Fields;

import java.util.ArrayList;

/**
 * Created by Nicolas Th on 29/05/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    //---------------------------
    //         ATTRIBUTS
    //---------------------------

    private ArrayList<Fields> listEvent;
    private OnEventListner onEventListner;

    //---------------------------
    //        CONSTRUCTOR
    //---------------------------

    public EventAdapter(ArrayList<Fields> listEvent, OnEventListner onEventListner) {
        this.listEvent = listEvent;
        this.onEventListner = onEventListner;
    }

    //---------------------------
    //     METHODE OVERRIDE
    //---------------------------
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_event, parent, false);
        return new EventAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Fields fields = listEvent.get(position);
        holder.tv_titre.setText(fields.getNom_de_la_manifestation());
        holder.tv_description.setText(fields.getDescriptif_court());
        holder.tv_lieu.setText(fields.getLieu_adresse_2());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEventListner.onClick(fields);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listEvent.size();
    }

    //---------------------------
    // CLASS VIEW HOLDER
    //---------------------------

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        //---------------------------
        //         ATTRIBUTS
        //---------------------------
        public TextView tv_titre, tv_description, tv_lieu;
        public View root;

        //---------------------------
        //        CONSTRUCTOR
        //---------------------------
        public ViewHolder(View itemView) {
            super(itemView);
            tv_titre = (TextView) itemView.findViewById(R.id.tv_titre);
            tv_description = (TextView) itemView.findViewById(R.id.tv_description);
            tv_lieu = (TextView) itemView.findViewById(R.id.tv_lieu);
            root = itemView.findViewById(R.id.root);
        }
    }

    //---------------------------
    // INTERFACE
    //---------------------------
    public interface OnEventListner {
        void onClick(Fields fields);
    }
}
