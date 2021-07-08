package com.rakuten.rakutenweb.service;

import java.util.List;

import com.rakuten.rakutenweb.model.Product;

public interface IProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
    Product updateProductById(long id);
    void deleteProductById(long id);
}
