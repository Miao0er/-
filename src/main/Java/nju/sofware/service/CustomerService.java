package nju.sofware.service;

import java.util.List;

import nju.sofware.data.dataobject.Teaminfo;
import nju.sofware.data.dataobject.Ucustomer;

/*
 * 客户逻辑层接口
 * 2019/0710
 * 刘硕
 */
public interface CustomerService {
	boolean addCustomer(Ucustomer customer)throws Exception;
	List<Ucustomer> getCustomers()throws Exception;
	boolean deleteCustomer(Integer id)throws Exception;
	boolean updateCustomer(Ucustomer customer)throws Exception;
}
