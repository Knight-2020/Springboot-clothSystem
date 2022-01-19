package com.demo.clothSystem.dto;

import java.util.List;

public class MenuDto {
    private Integer id;
    private String name;
    private String icon;
    private String role;
    private String href;
    private List<MenuDto> child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<MenuDto> getChild() {
        return child;
    }

    public void setChild(List<MenuDto> child) {
        this.child = child;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
