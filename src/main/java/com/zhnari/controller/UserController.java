package com.zhnari.controller;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
/**
 * 用户的控制层
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.zhnari.bean.Role;
import com.zhnari.bean.User;
import com.zhnari.bean.User_Role;
import com.zhnari.other.Msg;
import com.zhnari.service.RoleService;
import com.zhnari.service.UserRoleService;
import com.zhnari.service.UserService;
/**
 * 用户控制层
 * @author ASUS
 *
 */

@Controller
public class UserController {

	@Autowired  
	DefaultKaptcha defaultKaptcha;
	@Autowired
	UserService userService;
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	RoleService roleService;
	
	/*开始页面*/
	@RequestMapping("/start")
	public String start(){
			return "start";
	}
	/*验证码的生成*/
	@RequestMapping("/defaultKaptcha")  
    public void defaultKaptcha(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{  
            byte[] captchaChallengeAsJpeg = null;    
             ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();    
             try {    
             //生产验证码字符串并保存到session中  
             String createText = defaultKaptcha.createText();  
             httpServletRequest.getSession().setAttribute("vrifyCode", createText);  
             //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中  
             BufferedImage challenge = defaultKaptcha.createImage(createText);  
             ImageIO.write(challenge, "jpg", jpegOutputStream);  
             } catch (IllegalArgumentException e) {    
                 httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);    
                 return;    
             }   
             //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组  
             captchaChallengeAsJpeg = jpegOutputStream.toByteArray();    
             httpServletResponse.setHeader("Cache-Control", "no-store");    
             httpServletResponse.setHeader("Pragma", "no-cache");    
             httpServletResponse.setDateHeader("Expires", 0);    
             httpServletResponse.setContentType("image/jpeg");    
             ServletOutputStream responseOutputStream =    
                     httpServletResponse.getOutputStream();    
             responseOutputStream.write(captchaChallengeAsJpeg);    
             responseOutputStream.flush();    
             responseOutputStream.close();    
    }  
		
	/*进入到查询所有用户的街面*/
	@RequestMapping("/userAll")
	public String userAll(){
		return "list";
	}
	
	/*查询所有列表 返回json数据*/
	@RequestMapping(value="/userAllSelect")
	@ResponseBody
	public Msg getStudentswithJson(@RequestParam(value="pn",defaultValue="1")Integer pn, Model model){
	PageHelper.startPage(pn, 1);
	List<User> user = userService.selectUserAll();
	PageInfo page = new PageInfo(user);	
	return Msg.success().add("userlist", page);	
			}
	
	/*查询用户角色*/
	@RequestMapping("/selectRole")
	public String selectRole(Integer uid,Model model){
		//根据用户id查询出用户所有的角色
		List<User_Role> selectRoleByUserId = userRoleService.selectRoleByUserId(uid);	
		//查询所有的角色
		List<Role> selectAllRole = roleService.selectAllRole();	
		model.addAttribute("uid", uid);	
		model.addAttribute("selectRoleByUserId", selectRoleByUserId);
		model.addAttribute("selectAllRole", selectAllRole);
		return "userRole";
	}
	
	/*修改用户角色*/
	@RequestMapping("/alterRole")
	public void alterRole(HttpServletRequest request, HttpServletResponse response) {
		String parameter = request.getParameter("id");
		// 创建一个存储用户本身的角色id集合
		List<Integer> hasrid = new ArrayList<>();
		// 根据用户id查询出用户所有的角色
		List<User_Role> selectRoleByUserId = userRoleService.selectRoleByUserId(Integer.parseInt(parameter));
		for (User_Role user_Role : selectRoleByUserId) {
			hasrid.add(user_Role.getrId());
		}
		String[] parameterValues = request.getParameterValues("rid");
		// 创建一个存放选中项的集合
		List<Integer> inid = new ArrayList<>();
		// 创建当前用户的角色id
		if (parameterValues != null) {
			for (String string : parameterValues) {
				inid.add(Integer.parseInt(string));
			}
			for (Integer integer : inid) {
				if (!hasrid.contains(integer)) {
					// 执行新增操作
					User_Role ur = new User_Role();
					ur.setrId(integer);
					ur.setuId(Integer.parseInt(parameter));
					int addUserRole = userRoleService.addUserRole(ur);
				}
			}
			if (hasrid != null) {
				for (Integer integer : hasrid) {
					if (!inid.contains(integer)) {
						// 执行删除操作
						userRoleService.deleteUserRle(Integer.parseInt(parameter), integer);
					}
				}
			}
		} else {

			if (hasrid != null) {
				for (Integer integer : hasrid) {
					if (!inid.contains(integer)) {
						userRoleService.deleteUserRle(Integer.parseInt(parameter), integer);
					}
				}
			}
		}
		try {
			request.getRequestDispatcher("/userAll").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*获得用户的角色和权限名称*/
	@RequestMapping(value="/getUserRole")
	public String getRole(HttpServletRequest request, Model model) {
		/* 创建一个角色名称的集合 */
		List<String> rolename = new ArrayList<>();
		List<String> personname = new ArrayList<>();

		String attribute = (String) request.getSession().getAttribute(("username"));
		List<User> selectRoleByName = userService.selectRoleByName(attribute);
		if (!selectRoleByName.isEmpty()) {
			for (User user : selectRoleByName) {
				Set<Role> roleSet = user.getRoleSet();
				for (Role role : roleSet) {
					rolename.add(role.getrName());

					/* 通过角色名称查询出角色的权限 */
					List<String> selectPermissionByName = userService.selectPermissionByName(role.getrName());
					if (!selectPermissionByName.isEmpty()) {
						for (String string : selectPermissionByName) {
							personname.add(string);
						}
					}
				}
			}
		}
		Set<String> persion = new HashSet<>(personname);
		/* 用户权限的获取 */
		model.addAttribute("persion", persion);
		/* 用户角色的获取 */
		model.addAttribute("rolename", rolename);
		return null;
	}

	/* shiro的登录页面 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(String username, String password, String kaptcha, HttpSession session) {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(usernamePasswordToken); // 完成登录
			if (kaptcha.equals(session.getAttribute("vrifyCode"))) {
				User user = (User) subject.getPrincipal();
				session.setAttribute("user", user);
				System.out.println("---" + user.getuName());
				return "login";
			} else {
				return "start";
			}
		} catch (Exception e) {
			return "start";// 返回登录页面
		}
	}

	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "start";
	}
}
