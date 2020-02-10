package nju.sofware.service.implement;

import java.util.List;

import nju.sofware.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nju.sofware.data.dao.TeaminfoMapper;
import nju.sofware.data.dao.UcustomerMapper;
import nju.sofware.data.dataobject.Teaminfo;
import nju.sofware.data.dataobject.Ucustomer;
/*
 * 客户逻辑层实现
 * 2019/0710
 * 刘硕
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired  
    private UcustomerMapper customerDao; 
	
	/*
	 *插入团队信息
	 * 2019/7/10
	 * 刘硕
	 */
	public boolean addCustomer(Ucustomer customer)throws Exception{
		if(customerDao.insert(customer)>=1) {
			return true;
		}
		return false;
	}
	
	/*
	 * 查找所有团队信息
	 * 2019/07/10
	 */
	public List<Ucustomer> getCustomers()throws Exception{
		List<Ucustomer> customers=customerDao.selectAll();
		return customers;
	}

	@Override
	public boolean deleteCustomer(Integer id) throws Exception {
		return false;
	}

	/*
	 * 更新团队信息
	 * 2019/07/10
	 */
	public boolean updateCustomer(Ucustomer customer)throws Exception{
		if(customerDao.updateByPrimaryKey(customer)>=1){
			return true;
		}
		return false;
	}
	
	/*
	 * 删除团队信息
	 * 2019/07/10
	 */
	public boolean deleteTeaminfo(Integer infoid)throws Exception{
		if(true) {
			return true;
		}
		return false;
	}
}
