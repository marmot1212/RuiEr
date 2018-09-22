package com.example.fox28.ruier.patient.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fox28.base.BaseActivity;
import com.example.fox28.ruier.R;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class AddPatientActivity extends BaseActivity {

    @BindView(R.id.tv_name)
    TextView mTvName;               // 医生名称
    @BindView(R.id.tv_rank)
    TextView mTvRank;               // 医生职称
    @BindView(R.id.tv_hospital)
    TextView mTvHospital;           // 所属医院
    @BindView(R.id.tv_irc_id)
    TextView mTvIrcId;              // 瑞尔编号
    @BindView(R.id.iv_qrcode)
    ImageView mIvQrcode;            // 分享二维码
    @BindView(R.id.btn_share)
    Button mBtnShare;               // 分享按钮
    @BindView(R.id.iv_avatar)
    CircleImageView mIvAvatar;       // 头像

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar("添加患者");
    }

    @Override
    protected void setContentLayout() {
        super.setContentLayout();
        setContentView(R.layout.p_activity_add_patient);
    }
}
