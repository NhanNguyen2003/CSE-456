package vn.edu.eiu.repo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.eiu.entity.Customer;

public class CustomerRepoImpl implements CustomerRepo {
    private Session session;

    public CustomerRepoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Customer findCustomerById(int id) {
        return session.get(Customer.class, id);
    }
}
