package com.example.product_manager.service;

import com.example.product_manager.model.Product;

import java.util.List;

public interface IProductService {
    Product getProduct(int id);

    List<Product> listProduct();

    public void save(Product product);

    void deleteProduct(int id);
}
