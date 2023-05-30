package com.powernode.ssrmdemo.service;


import com.powernode.ssrmdemo.bean.Product;
import com.powernode.ssrmdemo.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper mapper;
    @Override
    public Double findTurnover() {
        // 获取当前日期，格式化
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return mapper.selectTurnover(sdf.format(date));
    }

    @Override
    public ArrayList<Product> findAllProducts() {
        return mapper.findAllProducts();
    }

    @Override
    public ArrayList<Product> findProductsByName(String name) {
        return mapper.findProductsByName(name);
    }

    @Override
    public int insertProduct(Product product) {
        return mapper.insertProduct(product);
    }
}
