package com.example.product_manager.repository;

import com.example.product_manager.model.Product;

import java.util.Map;

public interface IProductRepository {
    Product getProduct(int id);

    Map<Integer, Product> listProduct();

    public void updateProduct(int id, Product product);

    void deleteProduct(int id);

    void createNew(Product product);
}
