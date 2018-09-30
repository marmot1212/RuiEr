package com.example.fox28.ruier.patient.model.bean;

/**
 * @Description: 分组成员对应的实体类
 * @Author: Scorpion
 * @Date: 2018/9/24 23:38
 * @Tags:
 */
public class PGroupMemberEntity {

    private String name;
    private String url;

    public PGroupMemberEntity() {
    }

    public PGroupMemberEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PGroupMemberEntity{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
