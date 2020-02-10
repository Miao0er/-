/*
 *用户Controller
 *2019/7/10
 *刘硕 
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
	 * 功能说明 角色管理界面返回
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
	 * 功能说明 添加角色form提交处理
	 */
	@RequestMapping(value = "/addUserinfo", method = RequestMethod.POST)
	public ModelAndView addUserinfo(HttpServletRequest request, @ModelAttribute("userinfoForm") Userinfo userinfo,
			HttpServletResponse response) {
		try {
			if (userService.addUserinfo(userinfo)) {
				JsTool.redirectAlert("添加成功！", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			} else {
				JsTool.redirectAlert("添加失败！", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}

	/**
	 * 功能说明 用户信息修改
	 */
	@RequestMapping(value = "/updateUserinfo", method = RequestMethod.POST)
	public ModelAndView updateUserinfo(HttpServletRequest request, @ModelAttribute("userinfo") Userinfo userinfo,
			HttpServletResponse response) {
		try {
			if (userService.updateUserinfo(userinfo)) {
				JsTool.redirectAlert("修改成功！", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			} else {
				JsTool.redirectAlert("修改失败！", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ModelAndView("Error");
		}
	}

	/**
	 * 功能说明 删除用户信息
	 */
	@RequestMapping(value = "/deleteUserinfo", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, @RequestParam("infoid") Integer infoid,
			HttpServletResponse response) {
		try {
			if (userService.deleteUserinfo(infoid)) {
				JsTool.redirectAlert("删除成功！", "user/userinfoPage", response);
				return new ModelAndView("ManageUser");
			} else {
				JsTool.redirectAlert("删除失败！", "user/userinfoPage", response);
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
				// 转换成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					// 记录上传过程起始时的时间，用来计算上传时间
					// int pre = (int) System.currentTimeMillis();
					// 取得上传文件
					MultipartFile file = multiRequest.getFile(iter.next());
					if (file != null) {
						// 取得当前上传文件的文件名称
						String myFileName = file.getOriginalFilename();
						// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
						if (myFileName.trim() != "") {
							System.out.println(myFileName);
							// 重命名上传后的文件名
							String fileName = file.getOriginalFilename();
							// 定义上传路径
							String path = "E:\\研究生暑期培训\\sofware\\src\\main\\webapp\\resources\\headimage\\"+username+"\\" + fileName;
							File localFile = new File(path);
							file.transferTo(localFile);
							useraccountmodel.setHeadpicpath(fileName);//程序固定图片路径以 方便更改头像
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
