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
        List<Customer> customers = entityManager.createQuery("from Customer order by lastName", Customer.class).getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
    }
}
