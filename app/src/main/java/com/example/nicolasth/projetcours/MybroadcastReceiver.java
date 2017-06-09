package com.example.nicolasth.projetcours;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Nicolas Th on 24/05/2017.
 */

public class MybroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                if (intent.getBooleanExtra("state", true)) {
                    Toast.makeText(context, "Mode avion ON !", Toast.LENGTH_SHORT).show();
                } else if (!intent.getBooleanExtra("state", true)) {
                    Toast.makeText(context, "Mode avion OFF !", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
