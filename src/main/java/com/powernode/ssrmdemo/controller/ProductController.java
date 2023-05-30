package com.powernode.ssrmdemo.controller;

import com.powernode.ssrmdemo.bean.Product;
import com.powernode.ssrmdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    // 处理首页请求
    @GetMapping("/")
    public String indexHandle(Model model){
        System.out.println("现在在controller");
        // 查询平台总交易额
        Double turnover = service.findTurnover();
        model.addAttribute("turnover", turnover);

        // 查询所有产品
        List<Product> allProducts = service.findAllProducts();
        model.addAttribute("allProducts", allProducts);

        return "/index.jsp";
    }

    // 根据name查找产品
    @GetMapping("/product/name")
    public String listHandle(String name, Model model){

        List<Product> result = service.findProductsByName(name);

        model.addAttribute("allProducts", result);
        model.addAttribute("name", name);
        return "/jsp/result.jsp";
    }

    // 添加产品
    @PostMapping("/product")
    public String registerHandle(Product product, Model model){
        // 添加产品
        int i = service.insertProduct(product);
        // 查询所有产品
        List<Product> allProducts = service.findAllProducts();
        model.addAttribute("allProducts", allProducts);
        return "/jsp/manager.jsp";
    }
  }
