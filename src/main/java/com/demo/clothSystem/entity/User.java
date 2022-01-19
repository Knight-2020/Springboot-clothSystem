package com.demo.clothSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

        private String username;
        private String password;
        private String role;
        private String height;
        private String weight;
        private String bra;
        private String yao;
        private String ass;
            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
            @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
            @TableField(fill = FieldFill.INSERT)
        private LocalDateTime createAt;
            @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
            @TableField(fill = FieldFill.INSERT_UPDATE)
        private LocalDateTime updateAt;
        public String getUsername() {
            return this.username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPassword() {
            return this.password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getRole() {
            return this.role;
        }
        public void setRole(String role) {
            this.role = role;
        }
        public String getHeight() {
            return this.height;
        }
        public void setHeight(String height) {
            this.height = height;
        }
        public String getWeight() {
            return this.weight;
        }
        public void setWeight(String weight) {
            this.weight = weight;
        }
        public String getBra() {
            return this.bra;
        }
        public void setBra(String bra) {
            this.bra = bra;
        }
        public String getYao() {
            return this.yao;
        }
        public void setYao(String yao) {
            this.yao = yao;
        }
        public String getAss() {
            return this.ass;
        }
        public void setAss(String ass) {
            this.ass = ass;
        }
        public Integer getId() {
            return this.id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public LocalDateTime getCreateAt() {
            return this.createAt;
        }
        public void setCreateAt(LocalDateTime createAt) {
            this.createAt = createAt;
        }
        public LocalDateTime getUpdateAt() {
            return this.updateAt;
        }
        public void setUpdateAt(LocalDateTime updateAt) {
            this.updateAt = updateAt;
        }
}