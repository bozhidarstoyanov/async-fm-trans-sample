package com.bozhidarstoyanov.fragmenttransactions.activity;

import android.os.Message;
import android.support.annotation.AnimRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

/**
 * @author bozhidar.stoyanov.
 */
public class CallbackSafeFragmentTransaction extends FragmentTransaction {

    private FragmentTransaction mTransaction;
    private CallbackSafeFragmentTransactionHandler mHandler;

    public CallbackSafeFragmentTransaction(FragmentTransaction transaction, CallbackSafeFragmentTransactionHandler handler) {
        this.mTransaction = transaction;
        this.mHandler = handler;
    }

    @Override
    public FragmentTransaction add(Fragment fragment, String tag) {
        return null;
    }

    @Override
    public FragmentTransaction add(@IdRes int containerViewId, Fragment fragment) {
        return null;
    }

    @Override
    public FragmentTransaction add(@IdRes int containerViewId, Fragment fragment, @Nullable String tag) {
        return null;
    }

    @Override
    public FragmentTransaction replace(@IdRes int containerViewId, Fragment fragment) {
        return null;
    }

    @Override
    public FragmentTransaction replace(@IdRes int containerViewId, Fragment fragment, @Nullable String tag) {
        return null;
    }

    @Override
    public FragmentTransaction remove(Fragment fragment) {
        return null;
    }

    @Override
    public FragmentTransaction hide(Fragment fragment) {
        return null;
    }

    @Override
    public FragmentTransaction show(Fragment fragment) {
        return null;
    }

    @Override
    public FragmentTransaction detach(Fragment fragment) {
        return null;
    }

    @Override
    public FragmentTransaction attach(Fragment fragment) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public FragmentTransaction setCustomAnimations(@AnimRes int enter, @AnimRes int exit) {
        return null;
    }

    @Override
    public FragmentTransaction setCustomAnimations(@AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        return null;
    }

    @Override
    public FragmentTransaction addSharedElement(View sharedElement, String name) {
        return null;
    }

    @Override
    public FragmentTransaction setTransition(int transit) {
        return null;
    }

    @Override
    public FragmentTransaction setTransitionStyle(@StyleRes int styleRes) {
        return null;
    }

    @Override
    public FragmentTransaction addToBackStack(@Nullable String name) {
        return null;
    }

    @Override
    public boolean isAddToBackStackAllowed() {
        return false;
    }

    @Override
    public FragmentTransaction disallowAddToBackStack() {
        return null;
    }

    @Override
    public FragmentTransaction setBreadCrumbTitle(@StringRes int res) {
        return null;
    }

    @Override
    public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        return null;
    }

    @Override
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int res) {
        return null;
    }

    @Override
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        return null;
    }

    @Override
    public int commit() {

        Message msg = mHandler.obtainMessage(CallbackSafeFragmentTransactionHandler.MESSAGE_COMMIT_TRANSACTION, this);
        mHandler.sendMessage(msg);

        return 0;
    }

    @Override
    public int commitAllowingStateLoss() {

        return this.mTransaction.commitAllowingStateLoss();
    }
}
