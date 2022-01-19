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

public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
        private String role;
        private String model;
        private String operation;
            @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
            @TableField(fill = FieldFill.INSERT)
        private LocalDateTime createAt;
            @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
            @TableField(fill = FieldFill.INSERT_UPDATE)
        private LocalDateTime updateAt;
        public Integer getId() {
            return this.id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getRole() {
            return this.role;
        }
        public void setRole(String role) {
            this.role = role;
        }
        public String getModel() {
            return this.model;
        }
        public void setModel(String model) {
            this.model = model;
        }
        public String getOperation() {
            return this.operation;
        }
        public void setOperation(String operation) {
            this.operation = operation;
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