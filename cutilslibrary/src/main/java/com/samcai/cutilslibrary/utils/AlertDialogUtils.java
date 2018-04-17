package com.samcai.cutilslibrary.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.samcai.cutilslibrary.R;


/**
 * Created by caizhenliang on 2018/3/16.
 *
 * @version 1.5
 */
public class AlertDialogUtils {

    private static int POSITIVE_STRING = R.string.alert_dialog_positive;
    private static int NEGATIVE_STRING = R.string.alert_dialog_negative;


    /**
     * for yes and no option
     *
     * @param sContext
     * @param sTitle
     * @param sMessage
     * @param sPositiveButton
     * @return
     */
    public static AlertDialog Build(Context sContext,
                                    int sTitle,
                                    String sMessage,
                                    DialogInterface.OnClickListener sPositiveButton) {
        return buildDialog(sContext, sContext.getString(sTitle), sMessage,
                           sContext.getString(POSITIVE_STRING),
                           sContext.getString(NEGATIVE_STRING),
                           sPositiveButton);
    }

    /**
     * for yes and no option
     *
     * @param sContext
     * @param sTitle
     * @param sMessage
     * @param sPositiveButton
     * @return
     */
    public static AlertDialog Build(Context sContext,
                                    int sTitle,
                                    int sMessage,
                                    DialogInterface.OnClickListener sPositiveButton) {
        return buildDialog(sContext, sContext.getString(sTitle), sContext.getString(sMessage),
                           sContext.getString(POSITIVE_STRING),
                           sContext.getString(NEGATIVE_STRING),
                           sPositiveButton);
    }

    /**
     * yes option
     *
     * @param sContext
     * @param sTitle
     * @param sMessage
     * @return
     */
    public static AlertDialog Build(Context sContext,
                                    int sTitle,
                                    int sMessage) {
        return buildDialog(sContext, sContext.getString(sTitle), sContext.getString(sMessage),
                           sContext.getString(POSITIVE_STRING));
    }

    /*------------*/


    /**
     * single choice dialog
     *
     * @param sContext
     * @param sTitle
     * @param sItems
     * @param sChoice
     * @return
     */
    public static AlertDialog BuildSingle(Context sContext,
                                          int sTitle,
                                          CharSequence[] sItems,
                                          DialogInterface.OnClickListener sChoice) {
        return buildSingleDialog(sContext, sContext.getString(sTitle), sItems, sContext.getString(NEGATIVE_STRING), sChoice);
    }

    /**
     * single choice dialog
     *
     * @param sContext
     * @param sTitle
     * @param sItems
     * @param sChoice
     * @return
     */
    public static AlertDialog BuildSingle(Context sContext,
                                          String sTitle,
                                          CharSequence[] sItems,
                                          DialogInterface.OnClickListener sChoice) {
        return buildSingleDialog(sContext, sTitle, sItems, sContext.getString(NEGATIVE_STRING), sChoice);
    }

    /*------------*/

    /**
     * custom view dialog
     *
     * @param sContext
     * @param sTitle
     * @param layoutId
     * @param sChoice
     * @return
     */
    public static AlertDialog BuildView(Context sContext,
                                        int sTitle,
                                        int layoutId,
                                        DialogInterface.OnClickListener sChoice) {
        return buildViewDialog(sContext, sContext.getString(sTitle), layoutId,
                               NEGATIVE_STRING,
                               POSITIVE_STRING,
                               sChoice);
    }

    /**
     * custom view dialog
     *
     * @param sContext
     * @param sTitle
     * @param layoutId
     * @param sChoice
     * @return
     */
    public static AlertDialog BuildView(Context sContext,
                                        String sTitle,
                                        int layoutId,
                                        DialogInterface.OnClickListener sChoice) {
        return buildViewDialog(sContext, sTitle, layoutId,
                               NEGATIVE_STRING,
                               POSITIVE_STRING,
                               sChoice);
    }

    /**
     * custom view dialog
     *
     * @param sContext
     * @param sTitle
     * @param sLayout
     * @param sChoice
     * @return
     */
    public static AlertDialog BuildView(Context sContext,
                                        int sTitle,
                                        View sLayout,
                                        DialogInterface.OnClickListener sChoice) {
        return buildViewDialog(sContext, sContext.getString(sTitle), sLayout,
                               NEGATIVE_STRING,
                               POSITIVE_STRING,
                               sChoice);
    }

    /**
     * custom view dialog
     *
     * @param sContext
     * @param sTitle
     * @param sLayout
     * @param sChoice
     * @return
     */
    public static AlertDialog BuildView(Context sContext,
                                        String sTitle,
                                        View sLayout,
                                        DialogInterface.OnClickListener sChoice) {
        return buildViewDialog(sContext, sTitle, sLayout, NEGATIVE_STRING, POSITIVE_STRING, sChoice);
    }

    /*///////////////////////////////////////////////////////////////////////////
    // private Dialog
    ///////////////////////////////////////////////////////////////////////////*/

    private static AlertDialog buildDialog(Context sContext,
                                           String sTitle,
                                           String sMessage,
                                           String sPositiveStr,
                                           String sNegativeStr,
                                           DialogInterface.OnClickListener sPositiveButton) {

        AlertDialog.Builder tBuilder = new AlertDialog.Builder(sContext);
        tBuilder.setTitle(sTitle);
        tBuilder.setMessage(sMessage);
        tBuilder.setPositiveButton(sPositiveStr, sPositiveButton);
        tBuilder.setNegativeButton(sNegativeStr, (dialog, which) -> {
            dialog.dismiss();
        });
        return tBuilder.create();
    }

    private static AlertDialog buildDialog(Context sContext,
                                           String sTitle,
                                           String sMessage,
                                           String sPositiveStr) {

        AlertDialog.Builder tBuilder = new AlertDialog.Builder(sContext);
        tBuilder.setTitle(sTitle);
        tBuilder.setMessage(sMessage);
        tBuilder.setPositiveButton(sPositiveStr, (dialog, which) -> dialog.dismiss());
        return tBuilder.create();
    }

    /*///////////////////////////////////////////////////////////////////////////
    // private SingleDialog
    ///////////////////////////////////////////////////////////////////////////*/

    private static AlertDialog buildSingleDialog(Context sContext,
                                                 String sTitle,
                                                 CharSequence[] sItems,
                                                 String sNegativeStr,
                                                 DialogInterface.OnClickListener sChoice) {

        AlertDialog.Builder tBuilder = new AlertDialog.Builder(sContext);
        tBuilder.setTitle(sTitle);
        tBuilder.setItems(sItems, sChoice);
        tBuilder.setNegativeButton(sNegativeStr, (dialog, which) -> {
            dialog.dismiss();
        });
        return tBuilder.create();
    }

    /*///////////////////////////////////////////////////////////////////////////
    // private ViewDialog
    ///////////////////////////////////////////////////////////////////////////*/

    private static AlertDialog buildViewDialog(Context sContext,
                                               String sTitle,
                                               int layoutId,
                                               int sNegativeStr,
                                               int sPositiveStr,
                                               DialogInterface.OnClickListener sChoice) {

        AlertDialog.Builder tBuilder = new AlertDialog.Builder(sContext);
        tBuilder.setTitle(sTitle);
        tBuilder.setView(layoutId);
        tBuilder.setNegativeButton(sNegativeStr, (dialog, which) -> {
            dialog.dismiss();
        });
        tBuilder.setPositiveButton(sPositiveStr, sChoice);
        return tBuilder.create();
    }

    private static AlertDialog buildViewDialog(Context sContext,
                                               String sTitle,
                                               View sLayout,
                                               int sNegativeStr,
                                               int sPositiveStr,
                                               DialogInterface.OnClickListener sChoice) {

        AlertDialog.Builder tBuilder = new AlertDialog.Builder(sContext);
        tBuilder.setTitle(sTitle);
        tBuilder.setView(sLayout);
        tBuilder.setNegativeButton(sNegativeStr, (dialog, which) -> {
            dialog.dismiss();
        });
        tBuilder.setPositiveButton(sPositiveStr, sChoice);
        return tBuilder.create();
    }

}
