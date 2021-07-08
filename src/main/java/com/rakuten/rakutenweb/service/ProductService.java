package com.rakuten.rakutenweb.service;

import com.rakuten.rakutenweb.model.Product;
import com.rakuten.rakutenweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    @Override
    public Product updateProductById(long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()){
            product = optional.get();
        }else {
            throw new RuntimeException("not found product"+id);
        }
        return product;
    }

    @Override
    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }

}
