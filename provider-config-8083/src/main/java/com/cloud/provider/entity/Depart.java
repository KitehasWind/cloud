package com.cloud.provider.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
// 忽略属性 , 防止这些属性被序列化到 JSON 中。
@JsonIgnoreProperties({"hibernateLazyInitializer" , "handler" , "fieldHandler"})
public class Depart {
    // 标识id ，且自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


}
