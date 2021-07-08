package com.rakuten.rakutenweb.service;

import com.rakuten.rakutenweb.model.Product;
import com.rakuten.rakutenweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
