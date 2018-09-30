package com.example.fox28.ruier.patient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fox28.ruier.R;
import com.example.fox28.ruier.patient.model.bean.PGroupMemberEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @Description:
 * @Author: Scorpion
 * @Date: 2018/9/24 23:35
 * @Tags:
 */
public class AddPatientAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<PGroupMemberEntity> mList;

    public AddPatientAdapter(Context context, List<PGroupMemberEntity> list) {
        mContext = context;
        mList = list;
    }

    /**
     * 刷新数据
     * @param list
     */
    public void setList(List<PGroupMemberEntity> list) {
        mList = list;
        notifyDataSetChanged();
    }

    /**
     * RecyclerView列表项的类型：分别对应 "+"按钮，删除按钮，病人分组成员
     */
    public static final int TYPE_DELETE = 911;
    public static final int TYPE_ADD = 910;
    public static final int TYPE_ITEM = 909;



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case TYPE_DELETE:   // 减号按钮
                contentView = View.inflate(mContext, R.layout.p_recyc_item_addgroup_delete, null);
                holder = new DeleteHolder(contentView);
                break;
            case TYPE_ADD:      // 加号按钮
                contentView = View.inflate(mContext, R.layout.p_recyc_item_addgroup_add, null);
                holder = new AddHolder(contentView);
                break;
            case TYPE_ITEM:     // 其他列表项
                contentView = LayoutInflater.from(mContext).inflate(R.layout.p_recyc_item_addgroup, null);
                holder = new ItemHolder(contentView);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder parentHolder, int position) {
        // "-"
        if (getItemViewType(position) == TYPE_DELETE) {
            DeleteHolder holder = (DeleteHolder) parentHolder;
            holder.rl_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // todo 监听事件
                    Toast.makeText(mContext, "单击删除患者按钮", Toast.LENGTH_SHORT).show();
                }
            });
            return;
        }
        // "+"
        if (getItemViewType(position) == TYPE_ADD) {
            AddHolder holder = (AddHolder) parentHolder;
            holder.rl_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // todo 监听事件
                    Toast.makeText(mContext, "单击增加患者按钮", Toast.LENGTH_SHORT).show();
                }
            });
            return;
        }
        // 其他列表项
        if (getItemViewType(position) == TYPE_ITEM) {
            ItemHolder holder = (ItemHolder) parentHolder;
            holder.refreshUI(mList.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return mList==null? 2 : mList.size()+2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mList.size() + 1) {
            return TYPE_DELETE;
        } else if (position == mList.size()) {
            return TYPE_ADD;
        } else {
            return TYPE_ITEM;
        }
    }

    class DeleteHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rl_parent)
        RelativeLayout rl_parent;

        DeleteHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

   class AddHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rl_parent)
        RelativeLayout rl_parent;

        AddHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

  class ItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_delete)
        ImageView mIvDelete;
        @BindView(R.id.civ_avatar)
        CircleImageView mCivAvatar;
        @BindView(R.id.tv_name)
        TextView mTvName;

        ItemHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        // 刷新UI
       public void refreshUI(PGroupMemberEntity entity) {
            if(entity==null) return;
            mTvName.setText(entity.getName());
           Glide.with(mContext)
                   .load(entity.getUrl())
                   .centerCrop()
                   .dontAnimate()//防止设置placeholder导致第一次不显示网络图片,只显示默认图片的问题
                   .error(R.mipmap.patient_member_head)
                   .placeholder(R.mipmap.patient_member_head)
                   .into(mCivAvatar);
        }
    }
}

