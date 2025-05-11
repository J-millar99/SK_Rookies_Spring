package mylab.customer.service;

import mylab.customer.dao.CustomerDAO;
import mylab.customer.vo.CustomerVO;

import java.util.List;

public interface CustomerService {
    // Customer를 id로 조회
    CustomerVO getCustomerInfo(int id);

    // Customer 목록 조회
    List<CustomerVO> getAllCustomerList();

    // Customer 등록 구현
    void insertCustomer(CustomerVO customer);
}
