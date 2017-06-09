package com.example.appville.controller;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appville.R;
import com.example.appville.model.Event;
import com.example.appville.model.Fields;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private Fields event;
    private TextView tvTitre;
    private TextView tvDescription;
    private TextView tvLieu;
    private Button btAddEvent;
    private ArrayList<Event> arrayEvents;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-05-29 12:15:57 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    //---------------------------
    //          METHODE
    //---------------------------
    private void findViews() {
        tvTitre = (TextView) findViewById(R.id.tv_titre);
        tvDescription = (TextView) findViewById(R.id.tv_description);
        tvLieu = (TextView) findViewById(R.id.tv_lieu);
        btAddEvent = (Button) findViewById(R.id.bt_addEvent);

        btAddEvent.setOnClickListener(this);
    }

    private void setContenu() {
        tvTitre.setText(event.getNom_de_la_manifestation());
        tvDescription.setText(event.getDescriptif_long());
        tvLieu.setText(event.getLieu_adresse_2());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void addAgenda() {
        Log.w("Tag_date", event.getDate_debut());
//        Log.w("Tag_heure", event.getHoraires());
        Event eventAgenda;
        if (event.getDate_debut() != "" && !event.getDate_debut().isEmpty()) {
            String[] arrayDate = event.getDate_debut().split("-");
            Calendar calendar = Calendar.getInstance();
            calendar.set(parseInt(arrayDate[0]), parseInt(arrayDate[1]), parseInt(arrayDate[2]));
            eventAgenda = new Event(calendar, event.getNom_de_la_manifestation(), event.getDescriptif_court());
            Intent intent = new Intent(Intent.ACTION_INSERT)
                    .setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, eventAgenda.getCalendar().getTimeInMillis())
                    .putExtra(CalendarContract.Events.ALL_DAY, true)
                    .putExtra(CalendarContract.Events.TITLE, eventAgenda.getTitle())
                    .putExtra(CalendarContract.Events.DESCRIPTION, eventAgenda.getDescription())
                    .putExtra(CalendarContract.Events.EVENT_LOCATION, "The gym")
                    .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
            startActivity(intent);
            Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();

        }


    }

    //---------------------------
    // OVERRIDE
    //---------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        findViews();
        event = (Fields) getIntent().getSerializableExtra("event");
        setContenu();
        arrayEvents = new ArrayList<>();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v == btAddEvent) {
            // Handle clicks for btAddEvent
            addAgenda();
        }
    }

}
