/*
 *�û�Controller
 *2019/7/10
 *��˶ 
 */
package nju.sofware.web;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import nju.sofware.data.dataobject.Useraccount;
import nju.sofware.data.dataobject.Userinfo;
import nju.sofware.service.LoginService;
import nju.sofware.service.UserService;
import nju.sofware.service.model.UserAccountModel;
import nju.sofware.service.model.UserAccountandInfo;
import nju.sofware.util.JsTool;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * ����˵�� ��ɫ������淵��
	 */
	@RequestMapping(value = "/userinfoPage", method = RequestMethod.GET)
	public ModelAndView userinfoPage() {
		try {
			ModelAndView modelAndView = new ModelAndView();
			List<Userinfo> userinfos = userService.getUserinfos();
			modelAndView.addObject("userinfos", userinfos);
			modelAndView.setViewName("ManageUser");
			return modelAndView;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}

	/**
	 * ����˵�� ��ӽ�ɫform�ύ����
	 */
	@RequestMapping(value = "/addUserinfo", method = RequestMethod.POST)
	public ModelAndView addUserinfo(HttpServletRequest request, @ModelAttribute("userinfoForm") Userinfo userinfo,
			HttpServletResponse response) {
		try {
			if (userService.addUserinfo(userinfo)) {
				JsTool.redirectAlert("��ӳɹ���", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			} else {
				JsTool.redirectAlert("���ʧ�ܣ�", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}

	/**
	 * ����˵�� �û���Ϣ�޸�
	 */
	@RequestMapping(value = "/updateUserinfo", method = RequestMethod.POST)
	public ModelAndView updateUserinfo(HttpServletRequest request, @ModelAttribute("userinfo") Userinfo userinfo,
			HttpServletResponse response) {
		try {
			if (userService.updateUserinfo(userinfo)) {
				JsTool.redirectAlert("�޸ĳɹ���", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			} else {
				JsTool.redirectAlert("�޸�ʧ�ܣ�", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}

	/**
	 * ����˵�� ɾ���û���Ϣ
	 */
	@RequestMapping(value = "/deleteUserinfo", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, @RequestParam("infoid") Integer infoid,
			HttpServletResponse response) {
		try {
			if (userService.deleteUserinfo(infoid)) {
				JsTool.redirectAlert("ɾ���ɹ���", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			} else {
				JsTool.redirectAlert("ɾ��ʧ�ܣ�", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}

	/*
	 * @ModelAttribute("userinfos") public List<Userinfo> getuserinfos() throws
	 * Exception { List<Userinfo> userinfos=userService.getUserinfos(); return
	 * userinfos; }
	 */
	@RequestMapping(value = "/updateuseraccountpage", method = RequestMethod.GET)
	public ModelAndView updateuseraccountpage(HttpServletRequest request,HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			Useraccount useraccount=userService.getUseraccount(username);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("useraccount", useraccount);
			modelAndView.setViewName("ManageUserAccount");
			return modelAndView;
		}catch(Exception ex){
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}

	@RequestMapping(value = "/updateuseraccount", method = RequestMethod.POST)
	public ModelAndView updateuseraccount(HttpServletRequest request,
			@ModelAttribute("UserAccountModel") UserAccountModel useraccountmodel, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			if (multipartResolver.isMultipart(request)) {
				// ת���ɶಿ��request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				// ȡ��request�е������ļ���
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					// ��¼�ϴ�������ʼʱ��ʱ�䣬���������ϴ�ʱ��
					// int pre = (int) System.currentTimeMillis();
					// ȡ���ϴ��ļ�
					MultipartFile file = multiRequest.getFile(iter.next());
					if (file != null) {
						// ȡ�õ�ǰ�ϴ��ļ����ļ�����
						String myFileName = file.getOriginalFilename();
						// ������Ʋ�Ϊ����,˵�����ļ����ڣ�����˵�����ļ�������
						if (myFileName.trim() != "") {
							System.out.println(myFileName);
							// �������ϴ�����ļ���
							String fileName = file.getOriginalFilename();
							// �����ϴ�·��
							String path = "E:\\�о���������ѵ\\sofware\\src\\main\\webapp\\resources\\headimage\\"+username+"\\" + fileName;
							File localFile = new File(path);
							file.transferTo(localFile);
							useraccountmodel.setHeadpicpath(fileName);//����̶�ͼƬ·���� �������ͷ��
						}
					}
				}
			}
			userService.updateUseraccount(useraccountmodel, username);
			Useraccount useraccount=userService.getUseraccount(username);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("useraccount", useraccount);
			modelAndView.setViewName("ManageUserAccount");
			return modelAndView;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}

	/*
	 * public String uploadFile(MultipartFile multipartFile, String dirPath) throws
	 * IOException { String fileName = multipartFile.getOriginalFilename(); String
	 * fileSuffix = fileName.substring(fileName.lastIndexOf("."),
	 * fileName.length()); String localFileName = System.currentTimeMillis() +
	 * fileSuffix; String filePath = dirPath + File.separator + localFileName; File
	 * localFile = new File(filePath); File imagePath = new File(dirPath); if
	 * (!imagePath.exists()) { imagePath.mkdirs(); }
	 * multipartFile.transferTo(localFile); return localFileName; }
	 */

}
