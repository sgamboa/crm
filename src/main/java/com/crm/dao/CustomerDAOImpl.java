package com.crm.dao;

import com.crm.entity.Customer;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> getCustomers() {
        Session session = entityManager.unwrap(Session.class);

        List<Customer> customers = entityManager.createQuery("from Customer", Customer.class).getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        entityManager.persist(customer);
    }
}
