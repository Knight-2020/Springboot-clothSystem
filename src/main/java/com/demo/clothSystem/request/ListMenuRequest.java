package com.demo.clothSystem.request;
import com.demo.clothSystem.common.PageRequest;

public class ListMenuRequest extends PageRequest {
    private String role = "";

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
