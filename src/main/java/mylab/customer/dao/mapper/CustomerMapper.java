package mylab.customer.dao.mapper;

import mylab.customer.vo.CustomerVO;

import java.util.List;

public interface CustomerMapper {
    // Customer를 id로 조회
    CustomerVO selectCustomerById(int id);
    // Customer를 Email로 조회
    CustomerVO selectCustomerByEmail(String email);
    // Customer 목록 조회
    List<CustomerVO> selectAllCustomer();
    // Customer 등록 구현
    void insertCustomer(CustomerVO customer);
}
