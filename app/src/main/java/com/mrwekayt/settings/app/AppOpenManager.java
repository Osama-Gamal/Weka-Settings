package com.mrwekayt.settings.app;

import static androidx.lifecycle.Lifecycle.Event.ON_START;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.mrwekayt.settings.app.ui.MainOptions;

import java.util.Date;

/** Prefetches App Open Ads. */
public class AppOpenManager implements LifecycleObserver, Application.ActivityLifecycleCallbacks{
    private static final String LOG_TAG = "AppOpenManager";
    private Activity currentActivity;
    private static boolean isShowingAd = false;
    private long loadTime = 0;
    public static boolean showAd = false;
    private final ApplicationClass myApplication;

    /** Constructor */
    public AppOpenManager(ApplicationClass myApplication) {
        this.myApplication = myApplication;
        this.myApplication.registerActivityLifecycleCallbacks(this);
    }


    /** Shows the ad if one isn't already showing. */
    public void showAdIfAvailable() {

    }

    /** Request an ad */
    public void fetchAd() {



    }

    /** Creates and returns ad request. */

    private boolean wasLoadTimeLessThanNHoursAgo(long numHours) {
        long dateDifference = (new Date()).getTime() - this.loadTime;
        long numMilliSecondsPerHour = 3600000;
        return (dateDifference < (numMilliSecondsPerHour * numHours));
    }

    /** Utility method that checks if ad exists and can be shown. */
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        showAdIfAvailable();

    }
    @Override
    public void onActivityStarted(Activity activity) {
        currentActivity = activity;

    }

    @Override
    public void onActivityResumed(Activity activity) {
        currentActivity = activity;

    }

    @Override
    public void onActivityStopped(Activity activity) {}

    @Override
    public void onActivityPaused(Activity activity) {}

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {}

    @Override
    public void onActivityDestroyed(Activity activity) {
        currentActivity = null;
    }

    /** LifecycleObserver methods */
    @OnLifecycleEvent(ON_START)
    public void onStart() {


        Log.d(LOG_TAG, "onStart");
    }


}