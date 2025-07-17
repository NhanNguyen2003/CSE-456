package vn.edu.eiu.lab2.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class GenericDAO<T> {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");
    private Class<T> clazz;

    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void create(T entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();
        em.close();
    }

    public T read(Object id) {
        EntityManager em = emf.createEntityManager();
        T entity = em.find(clazz, id);
        em.close();
        return entity;
    }

    public void update(T entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(entity);
        tx.commit();
        em.close();
    }

    public void delete(Object id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        T entity = em.find(clazz, id);
        if (entity != null) {
            em.remove(entity);
        }
        tx.commit();
        em.close();
    }

    public List<T> getAll() {
        EntityManager em = emf.createEntityManager();
        List<T> list = em.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
        em.close();
        return list;
    }
}