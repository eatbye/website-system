/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import framework.system.dao.UserDeptMapper;
import framework.system.dao.UserMapper;
import framework.system.model.User;
import framework.system.model.UserDept;
import framework.system.service.IUserService;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("userService") 
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private UserDeptMapper userDeptMapper;
	
	@Override
	public User getUserById(int userId) {
		//加载xml文件
        //ApplicationContext  ac = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        //userMapper = (UserMapper) ac.getBean("userMapper");

        return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public User queryUserByLogin(User userParam) {
		// TODO Auto-generated method stub
		return userMapper.queryUserByLogin(userParam);
	}

	@Override
	public List<User> queryUserList(User user) {
		// TODO Auto-generated method stub
		return userMapper.queryUserList(user);
	}

	@Override
	public int addUser(User user) {
		int count = 0;
		try {
			userMapper.insert(user);
			
			UserDept userDept = new UserDept();
			userDept.setDept_code(user.getDept());
			userDept.setUser_id(user.getId()+"");
			count = userDeptMapper.insert(userDept);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void updateUser(User user) {
		try {
			userMapper.updateByPrimaryKeySelective(user);
			
			UserDept userDept = new UserDept();
			userDept.setDept_code(user.getDept());
			userDept.setUser_id(user.getId()+"");
			userDeptMapper.updateByUserId(userDept);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int stopUser(int userId) {
		// TODO Auto-generated method stub
		return userMapper.stopUser(userId);
	}

	@Override
	public int startUser(int userId) {
		// TODO Auto-generated method stub
		return userMapper.startUser(userId);
	}

}
