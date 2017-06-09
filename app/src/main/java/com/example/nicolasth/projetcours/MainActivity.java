package com.example.nicolasth.projetcours;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {


    private RadioButton rbLike;
    private RadioButton rbDislike;
    private TextView tvNew;
    private EditText etNewText;
    private ImageView ivImg;
    private Button btCancel;
    private Button btValid;
    private RadioGroup rg_radio;
    private final int ID_ALERT_DIAL = 10;
    private final int ID_TIME_PIKER = 11;
    private final int ID_DATE_PIKER = 12;
    private final int ID_RECYCLER = 13;
    private Calendar calendar = Calendar.getInstance();

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-05-23 13:47:07 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        rbLike = (RadioButton) findViewById(R.id.rb_like);
        rbDislike = (RadioButton) findViewById(R.id.rb_dislike);
        tvNew = (TextView) findViewById(R.id.tv_new);
        etNewText = (EditText) findViewById(R.id.et_newText);
        ivImg = (ImageView) findViewById(R.id.iv_img);
        btCancel = (Button) findViewById(R.id.bt_cancel);
        btValid = (Button) findViewById(R.id.bt_valid);
        rg_radio = (RadioGroup) findViewById(R.id.rg_radio);

        btCancel.setOnClickListener(this);
        btValid.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-05-23 13:47:07 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */

    private void displayAlert() {
        //Préparation de la fenêtre
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        //Message
        alertDialogBuilder.setMessage("Mon message");
        //titre
        alertDialogBuilder.setTitle("Mon titre");
        //bouton ok
        alertDialogBuilder.setPositiveButton("ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Affiche un toast apres le click sur le bouton ok
                        Toast.makeText(MainActivity.this, "Click sur ok",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        //Icone
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);
        //Afficher la fenêtre
        alertDialogBuilder.show();
    }

    private void displayTimePiker() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    private void displayDatePiker() {
        //Création de la fenêtre
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        //Afficher la fenêtre
        datePickerDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v == btCancel) {
            // Handle clicks for btCancel
            Intent intent = new Intent(this, SecondeActivity.class);
            startActivity(intent);

            //rg_radio.clearCheck();
            //etNewText.setText("");
            //ivImg.setColorFilter(Color.BLACK);
            //ivImg.setImageResource(R.drawable.ic_delete);
        } else if (v == btValid) {
            // Handle clicks for btValid
            ivImg.setImageResource(R.drawable.ic_action_name);
            if (rbLike.isChecked()) {
                ivImg.setColorFilter(Color.GREEN);
                etNewText.setText(R.string.like);
                Toast.makeText(this, R.string.like, Toast.LENGTH_SHORT).show();
            } else if (rbDislike.isChecked()) {
                ivImg.setColorFilter(Color.RED);
                etNewText.setText(R.string.dislike);
                Toast.makeText(this, R.string.dislike, Toast.LENGTH_SHORT).show();
            } else {

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, ID_ALERT_DIAL, 0, R.string.alert_dial).setIcon(R.drawable.ic_alert).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, ID_TIME_PIKER, 0, R.string.time_piker).setIcon(R.drawable.ic_time).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, ID_DATE_PIKER, 0, R.string.date_piker).setIcon(R.drawable.ic_date).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, ID_RECYCLER, 0, R.string.recycler);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == ID_ALERT_DIAL) {
            displayAlert();
        } else if (item.getItemId() == ID_TIME_PIKER) {
            displayTimePiker();
        } else if (item.getItemId() == ID_DATE_PIKER) {
            displayDatePiker();
        } else if (item.getItemId() == ID_RECYCLER) {
            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(this, "" + hourOfDay + "h" + minute, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Toast.makeText(this, "" + dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
    }
}
