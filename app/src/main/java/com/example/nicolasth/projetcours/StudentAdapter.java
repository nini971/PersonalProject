package com.example.nicolasth.projetcours;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import beans.StudentBean;

/**
 * Created by Nicolas Th on 24/05/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {


    private ArrayList<StudentBean> listStudent;
    private OnPersonneListner onPersonneListner;

    //---------------------------
    // CONSTRUCTOR
    //---------------------------
    public StudentAdapter(ArrayList<StudentBean> listStudent, OnPersonneListner onPersonneListner) {
        this.listStudent = listStudent;
        this.onPersonneListner = onPersonneListner;
    }

    //---------------------------
    // CLASS VIEW HOLDER
    //---------------------------
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView sc_tv_nom, sc_tv_prenom;
        public ImageView sc_iv;
        public View root;

        public ViewHolder(View itemView) {
            super(itemView);
            sc_tv_nom = (TextView) itemView.findViewById(R.id.sc_tv_nom);
            sc_tv_prenom = (TextView) itemView.findViewById(R.id.sc_tv_prenom);
            sc_iv = (ImageView) itemView.findViewById(R.id.sc_iv);
            root = itemView.findViewById(R.id.root);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup vg, int viewType) {
        View v = LayoutInflater.from(vg.getContext()).inflate(R.layout.row_student, vg, false);
        return new StudentAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final StudentBean eleve = listStudent.get(position);
        holder.sc_tv_nom.setText(eleve.getNom());
        holder.sc_tv_prenom.setText(eleve.getPrenom());
        Glide.with(holder.sc_iv.getContext()).load("http://www.coloriage.tv/dessincolo/ecolier.png").into(holder.sc_iv);


        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPersonneListner.onClick(eleve);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }

    //---------------------------
    // INTERFACE
    //---------------------------
    public interface OnPersonneListner {
        void onClick(StudentBean studentBean);
    }
}
