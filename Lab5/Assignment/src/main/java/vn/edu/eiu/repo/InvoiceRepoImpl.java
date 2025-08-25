package vn.edu.eiu.repo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.edu.eiu.entity.Invoice;

public class InvoiceRepoImpl implements InvoiceRepo {
    private Session session;

    public InvoiceRepoImpl(Session session) {
        this.session = session;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(invoice);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
