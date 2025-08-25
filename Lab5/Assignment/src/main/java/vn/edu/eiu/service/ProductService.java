package vn.edu.eiu.service;

import vn.edu.eiu.entity.Product;
import vn.edu.eiu.repo.ProductRepo;

import java.util.List;

public class ProductService {
    private ProductRepo productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }
}
