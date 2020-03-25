package com.jfs.domain;

public class Permission {

    private Integer id;

    private String permname;

    private String permtag;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermname() {
        return permname;
    }

    public void setPermname(String permname) {
        this.permname = permname == null ? null : permname.trim();
    }

    public String getPermtag() {
        return permtag;
    }

    public void setPermtag(String permtag) {
        this.permtag = permtag == null ? null : permtag.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permname='" + permname + '\'' +
                ", permtag='" + permtag + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}