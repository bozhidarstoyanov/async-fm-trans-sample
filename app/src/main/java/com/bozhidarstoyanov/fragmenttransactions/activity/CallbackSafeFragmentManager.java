package com.bozhidarstoyanov.fragmenttransactions.activity;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author bozhidar.stoyanov.
 */
public class CallbackSafeFragmentManager extends FragmentManager {

    private FragmentManager mFragmentManager;
    private CallbackSafeFragmentTransactionHandler mHandler;

    public CallbackSafeFragmentManager(FragmentManager manager, CallbackSafeFragmentTransactionHandler handler) {
        this.mFragmentManager = manager;
        this.mHandler = handler;
    }

    @Override
    public FragmentTransaction beginTransaction() {

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        CallbackSafeFragmentTransaction callbackSafeFragmentTransaction = new CallbackSafeFragmentTransaction(
                transaction, mHandler);
        return callbackSafeFragmentTransaction;
    }

    @Override
    public boolean executePendingTransactions() {
        return false;
    }

    @Override
    public Fragment findFragmentById(@IdRes int id) {
        return null;
    }

    @Override
    public Fragment findFragmentByTag(String tag) {
        return null;
    }

    @Override
    public void popBackStack() {

    }

    @Override
    public boolean popBackStackImmediate() {
        return false;
    }

    @Override
    public void popBackStack(String name, int flags) {

    }

    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        return false;
    }

    @Override
    public void popBackStack(int id, int flags) {

    }

    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        return false;
    }

    @Override
    public int getBackStackEntryCount() {
        return 0;
    }

    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        return null;
    }

    @Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {

    }

    @Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {

    }

    @Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {

    }

    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        return null;
    }

    @Override
    public List<Fragment> getFragments() {
        return null;
    }

    @Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment f) {
        return null;
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {

    }
}
