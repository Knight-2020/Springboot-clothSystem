package com.demo.clothSystem.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;

public class ClothDto {

    private static final long serialVersionUID = 1L;

        private String name;
        public String getName() {
        return this.name;
        }
        public void setName(String name) {
        this.name = name;
        }
                private String typeName;
                public String getTypeName() {
                return this.typeName;
                }
                public void setTypeName(String typeName) {
                this.typeName = typeName;
                }
        private Integer typeId;
        public Integer getTypeId() {
        return this.typeId;
        }
        public void setTypeId(Integer typeId) {
        this.typeId = typeId;
        }
        private String image;
        public String getImage() {
        return this.image;
        }
        public void setImage(String image) {
        this.image = image;
        }
        private Integer id;
        public Integer getId() {
        return this.id;
        }
        public void setId(Integer id) {
        this.id = id;
        }
            @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        private LocalDateTime createAt;
        public LocalDateTime getCreateAt() {
        return this.createAt;
        }
        public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
        }
            @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        private LocalDateTime updateAt;
        public LocalDateTime getUpdateAt() {
        return this.updateAt;
        }
        public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
        }
}