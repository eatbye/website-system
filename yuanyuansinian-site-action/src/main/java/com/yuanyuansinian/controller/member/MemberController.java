/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanyuansinian.model.member.Member;
import com.yuanyuansinian.pub.base.MyBaseController;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.pub.util.MyShaEncrypt;
import com.yuanyuansinian.pub.util.MyUserSessionUtil;
import com.yuanyuansinian.service.member.IMemberService;

import framework.system.model.Log;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.pub.util.DateUtil;
import framework.system.service.ILogService;

/**
 * @Description: 会员管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("/sinian/member/memberController")
public class MemberController extends MyBaseController {
	// 会员Service
	@Resource
	private IMemberService memberService;
	
	@Resource
	private ILogService logService;

	/**
	 * 
	 * @Description: 跳转到分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberList")
	public String toMemberList(HttpServletRequest request, Model model) {

		return "member/memberList";
	}

	/**
	 * 
	 * @Description: 跳转到新增页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberAdd")
	public String toMemberAdd(HttpServletRequest request, Model model) {

		return "member/memberAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberUpdate")
	public String toMemberUpdate(HttpServletRequest request, Model model) {
		int memberId = Integer.parseInt(request.getParameter("id"));
		Member member = this.memberService.queryMemberById(memberId);
		model.addAttribute("member", member);

		return "member/memberUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toMemberDetail")
	public String toMemberDetail(HttpServletRequest request, Model model) {
		int memberId = Integer.parseInt(request.getParameter("id"));
		Member member = this.memberService.queryMemberById(memberId);
		model.addAttribute("member", member);

		return "member/memberDetail";
	}

	/**
	 * 
	 * @Description: 分页列表
	 * @param request
	 * @param response
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryMemberList")
	public DataTablePageUtil<Member> queryMemberList(HttpServletRequest request,
			HttpServletResponse response, Member member) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Member> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Member>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Member> memberList = this.memberService.queryMemberList(member);
			// 用PageInfo对结果进行包装
			PageInfo<Member> pageInfo = new PageInfo<Member>(memberList);

			// 封装数据给DataTables
			dataTable.setDraw(dataTable.getDraw());
			dataTable.setData(pageInfo.getList());
			dataTable.setRecordsTotal((int) pageInfo.getTotal());
			dataTable.setRecordsFiltered(dataTable.getRecordsTotal());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return dataTable;
	}

	/**
	 * 
	 * @Description: 添加网站会员
	 * @param request
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addMember")
	public Map<String, Object> addMember(HttpServletRequest request, Member member) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String pwd = member.getPwd();
			String pwdDb = MyShaEncrypt.encryptSHA(pwd);
			//设置加密后的密码
			member.setPwd(pwdDb);
			member.setCreate_date(MyDateUtil.getDateTime());
			memberService.addMember(request, member);
			map.put("model_id", member.getId());
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	
	/**
	 * 
	 * @Description: 网站会员注册 
	 * @param request
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/registerMember")
	public Map<String, Object> registerMember(HttpServletRequest request, Member member) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String vCode = request.getParameter("vCode");
			String sCode = (String) request.getSession().getAttribute("validateCode");
			if(vCode.equals(sCode)){
				String pwd = member.getPwd();
				String pwdDb = MyShaEncrypt.encryptSHA(pwd);
				//设置加密后的密码
				member.setPwd(pwdDb);
				member.setCreate_date(MyDateUtil.getDateTime());
				memberService.addMember(request, member);
				map.put("model_id", member.getId());
				map.put(RESULT_MESSAGE_STRING, "注册成功");
				map.put(RESULT_STATUS_STRING, "1");
				//移除会员
				MyUserSessionUtil.removeMember(request);
				//存放session
				MyUserSessionUtil.putMember(request, member);
				
				Log log = new Log();
				log.setUser(member.getPhone());
				log.setIp(this.getIpAddr(request));
				log.setCreate_date(DateUtil.getDateTime());
				log.setOperation("会员注册");
				log.setType("Member");
				logService.saveLog(log);
			}else{
				map.put(RESULT_MESSAGE_STRING, "验证码不正确！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, "注册会员失败，请联系管理员！");
		}

		return map;
	}
	
	/**
	 * 
	 * @Description: 头像上传  
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/uploadImg")
	public Map<String, Object> uploadImg(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id = nullToStringZero(request.getParameter("model_id"));
			//保存数据
			memberService.uploadImg(request, id);
			
			//map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			//map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	
	/**
	 * 
	 * @Description: 会员信息修改
	 * @param request
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateMember")
	public Map<String, Object> updateMember(HttpServletRequest request, Member member) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String pwd = member.getPwd();
			String pwdDb = MyShaEncrypt.encryptSHA(pwd);
			//设置加密后的密码
			member.setPwd(pwdDb);
			//member.setCreate_date(MyDateUtil.getDateTime());
			int count = this.memberService.updateMember(member);
			map.put("model_id", member.getId());
			if (RESULT_COUNT_1 == count) {
				map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
			} else {
				map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}

	/**
	 * 
	 * @Description: 会员信息保存
	 * @param request
	 * @param member
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveMember")
	public Map<String, Object> saveMember(HttpServletRequest request, Member member) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String pwd = member.getPwd();
			String pwdDb = MyShaEncrypt.encryptSHA(pwd);
			//设置加密后的密码
			member.setPwd(pwdDb);
			//member.setCreate_date(MyDateUtil.getDateTime());
			int count = this.memberService.updateMember(member);
			if (RESULT_COUNT_1 == count) {
				map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
			} else {
				map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}

	/**
	 * 
	 * @Description: 删除会员信息
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteMember")
	public Map<String, Object> deleteMember(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int memberId = Integer.parseInt(request.getParameter("id"));
		int count = this.memberService.deleteMember(memberId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}

	/**
	 * 
	 * @Description: 验证手机号是否已经注册。状态0：不可用注册，1：可以注册 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkMemberByPhone")
	public boolean checkMemberByPhone(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String phone = request.getParameter("phone")==null? "":request.getParameter("phone");
		int count = 1;
		if(!"".equals(phone)){
			count = this.memberService.queryMemberCountByPhone(phone);
		}else{
			map.put(RESULT_MESSAGE_STRING, "手机号码为空！");
			map.put(RESULT_STATUS_STRING, "0");
		}
		if (count > 0) {
			return false;
		} else if(RESULT_COUNT_0 == count){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * @Description: 验证会员邮箱是否已经被注册
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkMemberByEmail")
	public boolean checkMemberByEmail(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String email = request.getParameter("email")==null? "":request.getParameter("email");
		int count = 1;
		if(!"".equals(email)){
			count = this.memberService.queryMemberCountByEmail(email);
		}else{
			map.put(RESULT_MESSAGE_STRING, "手机号码为空！");
			map.put(RESULT_STATUS_STRING, "0");
		}
		if (count > 0) {
			return false;
		} else if(RESULT_COUNT_0 == count){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * @Description: 验证会员名称是否重复 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkMemberByMemberName")
	public boolean checkMemberByMemberName(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String member_name = request.getParameter("member_name")==null? "":request.getParameter("member_name");
		int count = 1;
		if(!"".equals(member_name)){
			count = this.memberService.queryMemberCountByMemberName(member_name);
		}else{
			map.put(RESULT_STATUS_STRING, "0");
		}
		if (count > 0) {
			return false;
		} else if(RESULT_COUNT_0 == count){
			return true;
		}else{
			return false;
		}
		

	}
	
	/**
	 * 
	 * @Description: 会员登录 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/memberLogin")
	public Map<String, Object> memberLogin(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Member member = null;
		try {
			String vCode = request.getParameter("vCode");
			String sCode = (String) request.getSession().getAttribute("validateCode");
			if(vCode.equals(sCode)){
				//标识为灵堂购买礼品
				String flag = request.getParameter("flag")==null? "":request.getParameter("flag");
				//标识单人馆还是双人馆
				String type = request.getParameter("type")==null? "":request.getParameter("type");
				String hallId = request.getParameter("hallId")==null? "":request.getParameter("hallId");
				
				String name = request.getParameter("name")==null? "":request.getParameter("name");
				String pwdP = request.getParameter("pwd")==null? "":request.getParameter("pwd");
				//加密后的密码
				String pwd = MyShaEncrypt.encryptSHA(pwdP);
				
				if(!"".equals(name) && name.indexOf("@") > 0){
					//邮箱登录
					member = this.memberService.queryMemberByEmail(name,pwd);
				}else{
					//手机号登录:默认查询的数据不验证密码
					member = this.memberService.queryMemberByPhone(name,"");
				}
				//该手机号已经存在注册用户
				if (null != member) {
					//查询到的用户密码
					String userPwd = member.getPwd();
					//和录入的密码比较
					if(userPwd.equals(pwd)){
						//存放session
						MyUserSessionUtil.putMember(request, member);
						map.put(RESULT_MESSAGE_STRING, "登录成功！");
						map.put(RESULT_STATUS_STRING, "1");
						map.put("flag", flag);
						map.put("type", type);
						map.put("hallId", hallId);
						
						Log log = new Log();
						log.setUser(member.getPhone());
						log.setIp(this.getIpAddr(request));
						log.setCreate_date(DateUtil.getDateTime());
						log.setOperation("会员登录");
						log.setType("Member");
						logService.saveLog(log);
					}else{
						map.put(RESULT_MESSAGE_STRING, "密码不正确！");
						map.put(RESULT_STATUS_STRING, "0");
					}
					
				} else {
					map.put(RESULT_MESSAGE_STRING, "用户不存在！");
					map.put(RESULT_STATUS_STRING, "0");
				}
			}else{
				map.put(RESULT_MESSAGE_STRING, "验证码不正确！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, "登录失败，请联系管理员！");
		}
		
		return map;
	}
	
	//会员注销
	@ResponseBody
	@RequestMapping("/memberLogout")
	public Map<String, Object> memberLogout(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MyUserSessionUtil.removeMember(request);
			map.put(RESULT_MESSAGE_STRING, "用户退出成功！");
		} catch (Exception e) {
			map.put(RESULT_MESSAGE_STRING, "用户退出失败，请联系管理员！");
		}
		
		return map;
	}
	
	
	/**
	 * 获取IP
	 * @param request
	 * @return
	 */
	String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
