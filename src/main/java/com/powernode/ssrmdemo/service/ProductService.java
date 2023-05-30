package com.powernode.ssrmdemo.service;


import com.powernode.ssrmdemo.bean.Product;

import java.util.ArrayList;

public interface ProductService {
    Double findTurnover();

    ArrayList<Product> findAllProducts();

    ArrayList<Product> findProductsByName(String name);

    int insertProduct(Product product);

}
