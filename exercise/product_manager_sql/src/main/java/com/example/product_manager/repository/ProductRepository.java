package com.example.product_manager.repository;

import com.example.product_manager.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static final Map<Integer, Product> listProduct = new HashMap<>();

    static {
        listProduct.put(1, new Product(1, "iphone 11", 10, 200));
        listProduct.put(2, new Product(2, "iphone 12", 10, 100));
        listProduct.put(3, new Product(3, "iphone 13", 10, 300));
        listProduct.put(4, new Product(4, "iphone 14", 10, 150));
        listProduct.put(5, new Product(5, "iphone 15", 10, 250));
        listProduct.put(6, new Product(6, "iphone 16", 10, 350));
    }

    @Override
    public Product getProduct(int id) {
        return listProduct.get(id);
    }

    @Override
    public Map<Integer, Product> listProduct() {
        return listProduct;
    }

    @Override
    public void updateProduct(int id, Product product) {
        listProduct.put(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        listProduct.remove(id);
    }

    @Override
    public void createNew(Product product) {
        listProduct.put(product.getId(), product);
    }
}
