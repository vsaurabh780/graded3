package com.saurabh.project.service;

import com.saurabh.project.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerServiceImpl implements CustomerService {

    private SessionFactory sessionFactory;

    // create session
    private Session session;

    @Autowired
    CustomerServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

    }

    @Override
    @Transactional
    public List<Customer> findAll() {
        Transaction tx = session.beginTransaction();
        List<Customer> customers = session.createQuery("from Customer").list();
        tx.commit();
        return customers;
    }

    @Override
    @Transactional
    public Customer findById(Integer id) {
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, id);

        tx.commit();

        return customer;
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(customer);
        tx.commit();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        tx.commit();
    }
}
