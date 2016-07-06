package com.bozhidarstoyanov.fragmenttransactions.activity;

import android.os.Looper;
import android.os.Message;

import com.bozhidarstoyanov.fragmenttransactions.custom.handler.RetainingHandler;

import java.lang.ref.WeakReference;

/**
 * @author bozhidar.stoyanov.
 */
public class CallbackSafeFragmentTransactionHandler extends RetainingHandler {

    public static final int MESSAGE_COMMIT_TRANSACTION = 1;

    private WeakReference<BaseActivity> mActivityRef;

    public CallbackSafeFragmentTransactionHandler(BaseActivity activity) {
        super(Looper.getMainLooper());

        this.mActivityRef = new WeakReference<>(activity);
    }

    @Override
    protected boolean validateMessage(Message message) {
        return false;
    }

    @Override
    protected boolean storeMessage(Message message) {
        return false;
    }

    @Override
    protected void processMessage(Message message) {

    }
}
