/**
 * Copyright (C), 2015, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.controller;

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

import framework.system.model.Role;
import framework.system.pub.base.MyBaseController;
import framework.system.pub.util.DataTablePageUtil;
import framework.system.service.IRoleService;

/**
 * @Description: 角色管理
 * @author lizhaotao lzh_me@126.com
 * @date 2017年1月17日 下午1:52:12
 * @version V1.0
 */
@Controller
@RequestMapping("system/controller/roleController")
public class RoleController extends MyBaseController {

	@Resource
	private IRoleService roleService;


	/**
	 * 
	 * @Description: 跳转到列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toRoleList")
	public String toRoleList(HttpServletRequest request, Model model) {

		return "system/role/roleList";
	}

	/**
	 * @Description:  跳转到新增
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toRoleAdd")
	public String toRoleAdd(HttpServletRequest request, Model model) {
		
		return "system/role/roleAdd";
	}

	/**
	 * 
	 * @Description: 跳转到修改
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toRoleUpdate")
	public String toRoleUpdate(HttpServletRequest request, Model model) {
		int roleId = Integer.parseInt(request.getParameter("id"));
		Role role = this.roleService.queryRoleById(roleId);
		model.addAttribute("role", role);

		return "system/role/roleUpdate";
	}

	/**
	 * 
	 * @Description: 跳转到明细页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/toRoleDetail")
	public String toRoleDetail(HttpServletRequest request, Model model) {
		int roleId = Integer.parseInt(request.getParameter("id"));
		Role role = this.roleService.queryRoleById(roleId);
		model.addAttribute("role", role);

		return "system/role/roleDetail";
	}

	/**
	 * 
	 * @Description: 栏目分页查询
	 * @param request
	 * @param response
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRoleList")
	public DataTablePageUtil<Role> queryRoleList(
			HttpServletRequest request, HttpServletResponse response,
			Role role) {
		// 使用DataTables的属性接收分页数据
		DataTablePageUtil<Role> dataTable = null;
		try {
			// 使用DataTables的属性接收分页数据
			dataTable = new DataTablePageUtil<Role>(request);
			// 开始分页：PageHelper会处理接下来的第一个查询
			PageHelper.startPage(dataTable.getPage_num(),
					dataTable.getPage_size());
			// 还是使用List，方便后期用到
			List<Role> roleList = this.roleService
					.queryRoleList(role);
			// 用PageInfo对结果进行包装
			PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);

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
	 * @Description: 添加 
	 * @param request
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addRole")
	public Map<String, Object> addRole(HttpServletRequest request, Role role) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			roleService.addRole(request, role);
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}
		
		return map;
	}

	/**
	 * 
	 * @param request
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateRole")
	public Map<String, Object> updateRole(HttpServletRequest request, Role role) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.roleService.updateRole(role);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}
	

	/**
	 * 
	 * @Description: 保存
	 * @param request
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveRole")
	public Map<String, Object> saveRole(HttpServletRequest request,
			Role role) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = this.roleService.updateRole(role);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, SAVE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, SAVE_FAILED_MESSAGE);
		}

		return map;
	}

	/**
	 * 
	 * @Description: 删除
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteRole")
	public Map<String, Object> deleteRole(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int roleId = Integer.parseInt(request.getParameter("id"));
		int count  = this.roleService.deleteRole(roleId);
		if (RESULT_COUNT_1 == count) {
			map.put(RESULT_MESSAGE_STRING, DELETE_SUCESS_MESSAGE);
		} else {
			map.put(RESULT_MESSAGE_STRING, DELETE_FAILED_MESSAGE);
		}
		return map;
	}

}