package com.bozhidarstoyanov.fragmenttransactions.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * @author bozhidar.stoyanov.
 */
public class BaseActivity extends AppCompatActivity {

    private CallbackSafeFragmentManager mCallbackSafeFragmentManager;
    private boolean mAfterOnSaveInstanceState = false;

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mAfterOnSaveInstanceState = false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mAfterOnSaveInstanceState = true;
    }

    public FragmentManager getCallbackSafeFragmentManager() {

        if (mCallbackSafeFragmentManager == null) {
            FragmentManager fm = getSupportFragmentManager();
            if (fm != null) {
                CallbackSafeFragmentTransactionHandler handler = new CallbackSafeFragmentTransactionHandler(this);
                mCallbackSafeFragmentManager = new CallbackSafeFragmentManager(fm, handler);
            }
        }
        return mCallbackSafeFragmentManager;
    }
}
