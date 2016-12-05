package io.github.keyfour13.simplewebviewappexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 *
 * Created by Aleksandr Karpov <keyfour13@gmail.com> on 05.12.16.
 */

/**
   Main app activity. Superclass is AppCompatActivity because of compatibility with
   more devices
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.acitivity_main);

        if (getSupportFragmentManager().findFragmentById(R.id.frame_container) == null) {
            Fragment fragment = new WebViewFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_container, fragment)
                    .commit();
        }

    }

}