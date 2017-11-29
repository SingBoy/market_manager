package com.singe.core.model;

import java.util.List;

/**
 * 菜单
 */
public class Menu extends BaseModel{

    private Integer id;

    private String name;

    private Integer parentId;//父级菜单

    private String parentName;//父级菜单名称(回显所用)

    private String menuUrl;//菜单地址

    private String menuIcon ;//菜单图标

    private String description;

    private List<Menu> secondMenuList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public List<Menu> getSecondMenuList() {
        return secondMenuList;
    }

    public void setSecondMenuList(List<Menu> secondMenuList) {
        this.secondMenuList = secondMenuList;
    }
}