package com.bozhidarstoyanov.fragmenttransactions;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String DIALOG_TAG_NO_CONNECTION = "dialog_tag_no_connection";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                simulateNetworkError();
            }
        });
    }

    private void simulateNetworkError() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                showNoNetwork();
            }
        }, 2000);
    }

    private void showNoNetwork() {

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().commitAllowingStateLoss();
        NoNetworkDialog dialog = NoNetworkDialog.newInstance();
        dialog.show(fm, DIALOG_TAG_NO_CONNECTION);
    }
}
