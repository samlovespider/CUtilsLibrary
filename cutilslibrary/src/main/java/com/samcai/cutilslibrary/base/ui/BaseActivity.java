package com.samcai.cutilslibrary.base.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.samcai.cutilslibrary.utils.LoadTaskUtils;
import com.samcai.cutilslibrary.utils.LogUtils;


/**
 * Created by caizhenliang on 2018/3/2.
 *
 * @version 1.6
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * use load task or not
     */
    private boolean mLoadTaskEnable = false;

    public boolean isLoadTaskEnable() {
        return mLoadTaskEnable;
    }

    public void setLoadTaskEnable(boolean sLoadTaskEnable) {
        this.mLoadTaskEnable = sLoadTaskEnable;
    }

    /*///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(initLayoutID());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            handleIntent(bundle);
        }

        initHeader();
        initNavigationBar();
        initCoverLayer(this);

        initContent();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        handleNewIntent(bundle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int menuID;
        menuID = initMenuID();
        if (menuID != 0) {
            getMenuInflater().inflate(menuID, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    /*///////////////////////////////////////////////////////////////////////////
    // abstract
    ///////////////////////////////////////////////////////////////////////////*/

    protected abstract int initLayoutID();

    /**
     * 1,handleIntent<br>
     * 2,initHeader<br>
     * 3,initNavigationBar<br>
     * 4,initCoverLayer<br>
     * 5,initContent<br>
     * 6,handleNewIntent<br>
     */
    protected abstract void initContent();

    /*///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////*/

    /**
     * 1,handleIntent<br>
     * 2,initHeader<br>
     * 3,initNavigationBar<br>
     * 4,initCoverLayer<br>
     * 5,initContent<br>
     * 6,handleNewIntent<br>
     */
    protected void handleNewIntent(Bundle sBundle) {}

    /**
     * 1,handleIntent<br>
     * 2,initHeader<br>
     * 3,initNavigationBar<br>
     * 4,initCoverLayer<br>
     * 5,initContent<br>
     * 6,handleNewIntent<br>
     */
    protected void handleIntent(Bundle sBundle) {}

    protected void initHeader() {}

    protected void initNavigationBar() {}

    protected void initCoverLayer(Context sContext) {}

    protected int initMenuID() {
        return 0;
    }

    protected Handler doInBackgroud(String sBackTaskName) {
        HandlerThread tHandlerThread = new HandlerThread(sBackTaskName);
        tHandlerThread.start();
        Handler tUIHandler = new Handler(new CUICallback());
        return new Handler(tHandlerThread.getLooper(), new CChildCallback());
    }

    protected void backHandlerCallback(int sWhat) {}

    protected void uiHandlerCallback(Message sMsg) {}

    /*///////////////////////////////////////////////////////////////////////////
    // CallBack
    ///////////////////////////////////////////////////////////////////////////*/

    protected void presenterCallbackMessage(String sJsonStr, String sServiceName) {
        LogUtils.LogSuccess(sJsonStr, sServiceName);
        loadTaskState(sServiceName);
    }

    protected void presenterCallbackEmpty(int sCode, String sServiceName) {
        LogUtils.LogEmpty(sCode, sServiceName);
        loadTaskState(sServiceName);
    }

    protected void presenterCallbackError(int sCode, String sJsonStr, String sServiceName) {
        LogUtils.LogError(sCode, sJsonStr, sServiceName);
    }

    protected void presenterCallbackFailure(String sJsonStr, String sServiceName) {
        LogUtils.LogFailure(sJsonStr, sServiceName);
    }

    protected void presenterCallbackAllTaskFinish(String sServiceName) {
        LogUtils.d(LoadTaskUtils.TAG, LoadTaskUtils.ALL_FINISHED, LoadTaskUtils.TAG);
    }

    private void loadTaskState(String sServiceName) {
        if (mLoadTaskEnable) {
            LoadTaskUtils.setLoadTaskFinished(sServiceName);
            if (LoadTaskUtils.isAllFinished()) {
                presenterCallbackAllTaskFinish(sServiceName);
            }
        }
    }

    /*///////////////////////////////////////////////////////////////////////////
    // Keyborad
    ///////////////////////////////////////////////////////////////////////////*/

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /*///////////////////////////////////////////////////////////////////////////
    // class
    ///////////////////////////////////////////////////////////////////////////*/

    public class HeaderLeftClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    }

    public class CChildCallback implements Handler.Callback {

        @Override
        public boolean handleMessage(Message msg) {
            backHandlerCallback(msg.what);
            return false;
        }
    }

    public class CUICallback implements Handler.Callback {

        @Override
        public boolean handleMessage(Message msg) {
            uiHandlerCallback(msg);
            return false;
        }
    }
}
