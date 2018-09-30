package com.example.fox28.ruier.patient.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.example.fox28.base.BaseActivity;
import com.example.fox28.ruier.R;
import com.example.fox28.ruier.patient.adapter.AddPatientAdapter;
import com.example.fox28.ruier.patient.model.bean.PGroupMemberEntity;
import com.example.fox28.ruier.utils.DataFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddGroupActivity extends BaseActivity {

    @BindView(R.id.et_name)
    EditText mEtName;                 // 输入分组名称，如儿科
    @BindView(R.id.recyc_view)
    RecyclerView mRecycView;           // 患者头像

    private List<PGroupMemberEntity> mList;     // 数据集
    private AddPatientAdapter mAdpater;        // 适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData() {
        super.initData();
        mList = DataFactory.obtainListDataForAddGroup(10);
        mAdpater.setList(mList);
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar("添加分组");
        // 绑定适配器
        mList = new ArrayList<>();
        mAdpater = new AddPatientAdapter(this, mList);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecycView.setLayoutManager(manager);
        mRecycView.setAdapter(mAdpater);
    }

    @Override
    protected void setContentLayout() {
        super.setContentLayout();
        setContentView(R.layout.activity_add_group);
    }
}
