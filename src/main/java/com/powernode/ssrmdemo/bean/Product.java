package com.powernode.ssrmdemo.bean;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    // 产品名称
    private String name;
    // 利率
    private Double rate;
    // 募集金额
    private Double amount;
    // 以筹集资金
    private Double raised;
    // 产品周期
    private Integer cycle;
    // 产品募集结束时间
    private String endTime;
}
