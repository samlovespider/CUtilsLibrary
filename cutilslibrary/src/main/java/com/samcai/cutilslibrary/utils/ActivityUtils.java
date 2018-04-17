package com.samcai.cutilslibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by caizhenliang on 2018/3/16.
 *
 * @version 1.5
 */
public class ActivityUtils {


    /**
     * if nextFragment didn't add to activity then add, if already added then show and hide others;<br>
     * can back to previous page.
     *
     * @param fragmentManager
     * @param frameId
     * @param nextFragment
     * @param otherFragment
     */
    public static void SwitchFragmentBackStack(@NonNull FragmentManager fragmentManager, int frameId, @NonNull Fragment nextFragment,
                                               @Nullable Fragment... otherFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (nextFragment.isAdded()) {
            transaction.show(nextFragment);
        } else {
            transaction.add(frameId, nextFragment);
            transaction.addToBackStack(null);
        }

        if (otherFragment != null) {
            for (Fragment fragment :
                    otherFragment) {
                if (fragment != null && fragment.isAdded()) {
                    transaction.hide(fragment);
                }
            }
        }

        transaction.commit();
    }

    /**
     * if nextFragment didn't add to activity then add, if already added then show and hide others;<br>
     * can't back to previous page.
     *
     * @param fragmentManager
     * @param frameId
     * @param nextFragment
     * @param otherFragment
     */
    public static void SwitchFragment(@NonNull FragmentManager fragmentManager, int frameId, @NonNull Fragment nextFragment,
                                      @Nullable Fragment... otherFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (nextFragment.isAdded()) {
            transaction.show(nextFragment);
        } else {
            transaction.add(frameId, nextFragment);
        }

        if (otherFragment != null) {
            for (Fragment fragment :
                    otherFragment) {
                if (fragment != null && fragment.isAdded()) {
                    transaction.hide(fragment);
                }
            }
        }

        transaction.commit();
    }

    /**
     * replace previous fragment;<br>
     * can't back to previous page.
     *
     * @param fragmentManager
     * @param frameId
     * @param nextFragment
     */
    public static void replaceFragmentInActivity(@NonNull FragmentManager fragmentManager, int frameId,
                                                 @NonNull Fragment nextFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, nextFragment);
        transaction.commit();
    }


    public static void gotoActivity(Context sContext, Class<?> sCls) {
        gotoActivity(sContext, sCls, null);
    }

    public static void gotoActivity(Context sContext, Class<?> sCls, Bundle sBundle) {
        Intent intent = new Intent(sContext, sCls);
        if (sBundle != null) {
            intent.putExtras(sBundle);
        }
        sContext.startActivity(intent);
    }

    public static void gotoActivityClearTop(Context sContext, Class<?> sCls) {
        gotoActivityClearTop(sContext, sCls, null);
    }

    public static void gotoActivityClearTop(Context sContext, Class<?> sCls, Bundle sBundle) {
        Intent intent = new Intent(sContext, sCls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (sBundle != null) {
            intent.putExtras(sBundle);
        }
        sContext.startActivity(intent);
    }


}
