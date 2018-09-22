package com.example.fox28.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.fox28.ruier.R;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {
    public ImmersionBar mImmersionBar;
    private TextView tvTitle;
    protected Handler handler= new Handler();
    private ProgressDialog progressDialog;
    private Toolbar toolbar;
    public boolean isScreenPortrait=true;
    private View view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenOretation();
        if (isScreenPortrait==true){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        setContentLayout();
        ButterKnife.bind(this);
        dealLogicBeforeInitView();
        initView();
        dealLogicAfterInitView();
        initData();
        getTitle();
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.fitsSystemWindows(true).keyboardEnable(true).
                statusBarColor(R.color.titleBarColor).statusBarDarkFont(true).init();   //所有子类都将继承这些相同的属性
    }
    public void setScreenOretation() {

    }

    protected void initToolBar(String title){
        view=findViewById(R.id.v_toolbar_line);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvTitle=(TextView)findViewById(R.id.tv_title);
        tvTitle.setText(title);
    }
    public Toolbar getToolbar(){
        return toolbar;
    }
    public void addViewToToolbar(View view){
        toolbar.addView(view);
    }
    protected void setContentLayout(){}
    protected void dealLogicBeforeInitView(){}
    protected void initView(){}
    protected void dealLogicAfterInitView(){}
    protected void initData(){}
    protected void setTitle(String title){
        tvTitle.setText(title);
    }
    public void hideNavigationIcon(){toolbar.setNavigationIcon(null);}
    public final String getTitleStr(){return tvTitle.getText().toString().trim();}

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        KeyBoardUtils.dismissSoftKeyboard(this);
        return super.onTouchEvent(event);
    }
    public void turnToActivity(Class cClass){
        turnToActivity(cClass,null);
    }

    public void turnToActivity(Class cClass,Bundle extras){
        Intent intent = new Intent(getApplicationContext(),cClass);
        if(extras!=null){
            intent.putExtras(extras);
        }
        startActivity(intent);
    }
    public void showProgressDialog(String message){
        if (progressDialog == null){
            progressDialog = new ProgressDialog(this,ProgressDialog.THEME_HOLO_LIGHT);
            progressDialog.setCancelable(false);
        }

        progressDialog.setMessage(message);
        progressDialog.show();
    }
    public void showProgressDialogInMainThread(final String message){
        handler.post(new Runnable() {
            @Override
            public void run() {
                showProgressDialog(message);
            }
        });
    }
    public void dismissProgressDialog(){
        if (isShowProgressDialog()){
            progressDialog.dismiss();
        }
    }
    public boolean isShowProgressDialog(){
        if (progressDialog!=null&&progressDialog.isShowing()){
            return true;
        }else {
            return false;
        }

    }
    /**
     * 隐藏软键盘
     */
    public static void hideSoftInputMethod(Activity act) {
        View view = act.getWindow().peekDecorView();
        if (view != null) {
            // 隐藏虚拟键盘
            InputMethodManager inputmanger = (InputMethodManager) act
                    .getSystemService(act.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }
}
