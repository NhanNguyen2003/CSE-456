package vn.edu.eiu.repo;

import vn.edu.eiu.entity.Product;

import java.util.List;

public interface ProductRepo {
    List<Product> findAllProducts();
}

