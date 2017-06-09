package com.example.appville.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appville.R;
import com.example.appville.model.AppVilleWS;
import com.example.appville.model.Fields;
import com.example.appville.view.EventAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, EventAdapter.OnEventListner {

    //---------------------------
    //         ATTRIBUTS
    //---------------------------
    private Button btLoad;
    private RecyclerView rvEvent;
    private ArrayList<Fields> listEvent;
    private EventAdapter eventAdapter;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-05-29 11:55:20 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    //---------------------------
    //          METHODE
    //---------------------------
    private void findViews() {
        btLoad = (Button) findViewById(R.id.bt_load);
        rvEvent = (RecyclerView) findViewById(R.id.rv_event);

        btLoad.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-05-29 11:55:20 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    //---------------------------
    // OVERRIDE
    //---------------------------
    @Override
    public void onClick(View v) {
        if (v == btLoad) {
            // Handle clicks for btLoad
            RequeteAT requeteAT = new RequeteAT();
            requeteAT.execute();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //getIntent().getSerializableExtra()


        findViews();
        listEvent = new ArrayList<>();
        eventAdapter = new EventAdapter(listEvent, this);
        rvEvent.setAdapter(eventAdapter);
        rvEvent.setLayoutManager(new LinearLayoutManager(this));
        rvEvent.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onClick(Fields fields) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("event", fields);
        startActivity(intent);
    }

    public class RequeteAT extends AsyncTask {
        private ArrayList<Fields> eventArrayList = null;
        private Exception exception = null;

        @Override
        protected Object doInBackground(Object[] params) {
            try {
                eventArrayList = AppVilleWS.getFieldServ();
            } catch (Exception e) {
                exception = e;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (exception != null) {
                exception.printStackTrace();
                Toast.makeText(MainActivity.this, "" + exception.getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                //Toast.makeText(MainActivity.this, "Requete ok !", Toast.LENGTH_SHORT).show();
                listEvent.clear();
                listEvent.addAll(eventArrayList);
                eventAdapter.notifyDataSetChanged();
            }

        }
    }
}
