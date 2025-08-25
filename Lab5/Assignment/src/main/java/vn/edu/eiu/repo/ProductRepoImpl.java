package vn.edu.eiu.repo;

import org.hibernate.Session;
import vn.edu.eiu.entity.Product;

import java.util.List;

public class ProductRepoImpl implements ProductRepo {
    private Session session;

    public ProductRepoImpl(Session session) {
        this.session = session;
    }

    @Override
    public List<Product> findAllProducts() {
        return session.createQuery("FROM Product", Product.class).getResultList();
    }
}

