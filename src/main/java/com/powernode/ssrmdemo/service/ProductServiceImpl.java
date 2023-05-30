package com.powernode.ssrmdemo.service;


import com.powernode.ssrmdemo.bean.Product;
import com.powernode.ssrmdemo.mapper.ProductMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private RedisTemplate<String , String> rt;

    @Override
    public Double findTurnover() {
        // 获取Redis指定key的操作对象
        BoundValueOperations<String, String> ops = rt.boundValueOps("turnover");
        // 从缓存中读取指定key的value
        String turnover = ops.get();
//        // 如果缓存中没有该数据，则先从DB中查询，然后再写入到缓存
//        if (turnover == null) {
//            Date date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            turnover = mapper.selectTurnover(sdf.format(date)).toString();
//            // 将查询结果写入缓存
//            ops.set(turnover, 10, TimeUnit.SECONDS);
//        }

        // 双重检测所预防缓存击穿问题
        if (turnover == null) {
            synchronized (this){
                turnover = ops.get();
                if (turnover == null) {
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    turnover = mapper.selectTurnover(sdf.format(date)).toString();
                    // 将查询结果写入缓存
                    ops.set(turnover, 10, TimeUnit.SECONDS);
                }
            }
        }

        return Double.parseDouble(turnover);
    }

    @Override
    @Cacheable(value = "pc", key = "'product_all'")
    public ArrayList<Product> findAllProducts() {
        return mapper.findAllProducts();
    }

    @Override
    @Cacheable(value = "pc", key = "'product_'+#name")
    public ArrayList<Product> findProductsByName(String name) {
        return mapper.findProductsByName(name);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    @CacheEvict(value = "pc", allEntries = true)
    public int insertProduct(Product product) {
        return mapper.insertProduct(product);
    }
}
