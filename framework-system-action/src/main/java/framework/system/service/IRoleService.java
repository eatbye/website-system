/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import framework.system.model.Role;
import framework.system.model.UserRole;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:49:54 
 * @version V1.0   
 */
public interface IRoleService {
	/**
	 * @param role
	 * @return
	 */
	int updateRole(Role role);


	Role queryRoleById(int roleId);


	List<Role> queryRoleList(Role role);


	int addRole(HttpServletRequest request,Role role);


	int deleteRole(int roleId);

	/**
	 * 
	 * @Description: 角色下拉列表 
	 * @return
	 */
	List<Role> getRoleSelectList();


	List<Role> queryRoleTree(Role role);


	List<UserRole> queryUserRoleTree(String user_code);


	boolean addUserRole(String login_name,String role_ids);


	boolean addUserFuncright(String role_id, String funcright_ids);


}
