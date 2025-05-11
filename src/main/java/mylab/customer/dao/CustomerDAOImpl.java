package mylab.customer.dao;

import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerDAO")
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerVO selectCustomer(int id) {
        return customerMapper.selectCustomerById(id);
    }

    @Override
    public List<CustomerVO> selectAllCustomer() {
        return customerMapper.selectAllCustomer();
    }

    @Override
    public void insertCustomer(CustomerVO customer) {
        customerMapper.insertCustomer(customer);
        System.out.println("등록된 Customer Record UserId=" + customer.getEmail() + " Name=" + customer.getName());
    }
}
