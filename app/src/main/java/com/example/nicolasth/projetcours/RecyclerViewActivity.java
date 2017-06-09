package com.example.nicolasth.projetcours;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

import beans.StudentBean;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener, StudentAdapter.OnPersonneListner {

    private EditText etNom;
    private EditText etPrenom;
    private Button btAjouter;
    private SeekBar sb;
    private Button btAjouterPlusieurs;
    private Button btSupprimer;
    private ArrayList<StudentBean> listStudent;
    private RecyclerView rv;
    private StudentAdapter sAdapter;

    private void addStudent(int nb) {
        for (int i = 0; i < nb; i++) {
            listStudent.add(new StudentBean(etNom.getText().toString(), etPrenom.getText().toString()));
        }
    }

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-05-24 14:55:00 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        etNom = (EditText) findViewById(R.id.et_nom);
        etPrenom = (EditText) findViewById(R.id.et_prenom);
        btAjouter = (Button) findViewById(R.id.bt_ajouter);
        sb = (SeekBar) findViewById(R.id.sb);
        btAjouterPlusieurs = (Button) findViewById(R.id.bt_ajouterPlusieurs);
        btSupprimer = (Button) findViewById(R.id.bt_supprimer);
        rv = (RecyclerView) findViewById(R.id.rv);


        btAjouter.setOnClickListener(this);
        btAjouterPlusieurs.setOnClickListener(this);
        btSupprimer.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-05-24 14:55:00 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == btAjouter) {
            // Handle clicks for btAjouter
            Toast.makeText(this, "Ajouter", Toast.LENGTH_SHORT).show();
            addStudent(1);
            sAdapter.notifyDataSetChanged();
        } else if (v == btAjouterPlusieurs) {
            // Handle clicks for btAjouterPlusieurs
            Toast.makeText(this, "AjouterPlusieurs", Toast.LENGTH_SHORT).show();
            addStudent(sb.getProgress());
            sAdapter.notifyDataSetChanged();
        } else if (v == btSupprimer) {
            // Handle clicks for btSupprimer
            Toast.makeText(this, "Supprimer", Toast.LENGTH_SHORT).show();
            listStudent.remove(listStudent.size() - 1);
            sAdapter.notifyItemRemoved(listStudent.size());

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        findViews();
        listStudent = new ArrayList<>();
        sAdapter = new StudentAdapter(listStudent, this);
        rv.setAdapter(sAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onClick(StudentBean studentBean) {
        Toast.makeText(this, "Clique sur " + studentBean.getPrenom(), Toast.LENGTH_SHORT).show();
    }
}
