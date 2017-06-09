package com.example.nicolasth.projetcours;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nicolas Th on 23/05/2017.
 */

public class SecondeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btHome;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-05-24 09:20:32 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        btHome = (Button) findViewById(R.id.bt_home);

        btHome.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-05-24 09:20:32 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == btHome) {
            // Handle clicks for btHome
            finish();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViews();
    }
}
