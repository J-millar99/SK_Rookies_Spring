package mylab.customer.dao;

import mylab.customer.vo.CustomerVO;

import java.util.List;

public interface CustomerDAO {
    // Customer를 id로 조회
    CustomerVO selectCustomer(int id);
    // Customer 목록 조회
    List<CustomerVO> selectAllCustomer();
    // Customer 등록 구현
    void insertCustomer(CustomerVO customer);
}
