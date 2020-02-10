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
 * �ͻ��߼���ʵ��
 * 2019/0710
 * ��˶
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired  
    private UcustomerMapper customerDao; 
	
	/*
	 *�����Ŷ���Ϣ
	 * 2019/7/10
	 * ��˶
	 */
	public boolean addCustomer(Ucustomer customer)throws Exception{
		if(customerDao.insert(customer)>=1) {
			return true;
		}
		return false;
	}
	
	/*
	 * ���������Ŷ���Ϣ
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
	 * �����Ŷ���Ϣ
	 * 2019/07/10
	 */
	public boolean updateCustomer(Ucustomer customer)throws Exception{
		if(customerDao.updateByPrimaryKey(customer)>=1){
			return true;
		}
		return false;
	}
	
	/*
	 * ɾ���Ŷ���Ϣ
	 * 2019/07/10
	 */
	public boolean deleteTeaminfo(Integer infoid)throws Exception{
		if(true) {
			return true;
		}
		return false;
	}
}
