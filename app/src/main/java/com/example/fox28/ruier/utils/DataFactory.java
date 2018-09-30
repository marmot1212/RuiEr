package com.example.fox28.ruier.utils;

import com.example.fox28.ruier.patient.model.bean.PGroupMemberEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 生成模拟数据的工具类
 * @Author: Scorpion
 * @Date: 2018/9/30 14:45
 * @Tags:
 */
public class DataFactory {

    /**
     * 添加分组页面，生成adapter的模拟数据集
     * @param size
     * @return
     */
    public static List<PGroupMemberEntity> obtainListDataForAddGroup(int size) {
        List<PGroupMemberEntity> list = new ArrayList<>();
        for(int i=0; i<size; i++) {
            PGroupMemberEntity entity = new PGroupMemberEntity("病人" + i);
            list.add(entity);
        }
        return list;
    }
}
