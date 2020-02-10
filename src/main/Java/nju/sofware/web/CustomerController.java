/*
 * �ͻ�Controller��
 * 2019/7/10
 * ��˶
 */
package nju.sofware.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import nju.sofware.data.dataobject.Teaminfo;
import nju.sofware.data.dataobject.Ucustomer;
import nju.sofware.service.CustomerService;
import nju.sofware.service.TeamService;
import nju.sofware.util.JsTool;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired  
    private CustomerService customerService;
	
	/**
	* ����˵��
	* �ͻ�������淵��
	*/
	@RequestMapping(value = "/cutomerpage",method = RequestMethod.GET)
	public ModelAndView customerPage() {
		try {
		ModelAndView modelAndView = new ModelAndView();
		List<Ucustomer> customers=customerService.getCustomers();
		modelAndView.addObject("customers", customers);
		modelAndView.setViewName("ManageCustomer");
		return modelAndView;
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
	/**
	* ����˵��
	* �ͻ�form�ύ����
	*/
	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public ModelAndView addCustomer(HttpServletRequest request,@ModelAttribute("customerForm")Ucustomer customer,HttpServletResponse response) {
		try {
			if(customerService.addCustomer(customer)) {
				JsTool.redirectAlert("��ӳɹ���", "customer/customerpage", response);
				return new ModelAndView("ManageCustomer");
			}else {
				JsTool.redirectAlert("���ʧ�ܣ�", "customer/customerpage", response);
				return new ModelAndView("ManageCustomer");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
	/**
	* ����˵��
	* �ͻ���Ϣ�޸�
	*/
	@RequestMapping(value = "/updatecustomer", method = RequestMethod.POST)
	public ModelAndView updatecustomer(HttpServletRequest request,@ModelAttribute("customer")Ucustomer customer,HttpServletResponse response) {
		try {
			if(customerService.updateCustomer(customer)) {
				JsTool.redirectAlert("�޸ĳɹ���", "customer/customerpage", response);
				return new ModelAndView("ManageCustomer");
			}else {
				JsTool.redirectAlert("�޸�ʧ�ܣ�", "customer/customerpage", response);
				return new ModelAndView("ManageCustomer");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
	
	/**
	* ����˵��
	* ɾ���ͻ���Ϣ
	*/
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public ModelAndView deletecustomer(HttpServletRequest request,@RequestParam("customerid")Integer customerid,HttpServletResponse response) {
		try {
			if(customerService.deleteCustomer(customerid)) {
				JsTool.redirectAlert("ɾ���ɹ���", "customer/customerpage", response);
				return new ModelAndView("ManageTeam");
			}else {
				JsTool.redirectAlert("ɾ��ʧ�ܣ�", "customer/customerpage", response);
				return new ModelAndView("ManageTeam");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}
}
