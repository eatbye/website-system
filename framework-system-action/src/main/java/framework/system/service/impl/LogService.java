/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package framework.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import framework.system.dao.LogMapper;
import framework.system.model.Log;
import framework.system.service.ILogService;

/**   
 * @Description: TODO 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("logService") 
public class LogService implements ILogService {
	@Resource
	private LogMapper logMapper;
	
	@Override
	public Log getLogById(int logId) {
		//加载xml文件
        //ApplicationContext  ac = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        //logMapper = (LogMapper) ac.getBean("logMapper");

        return logMapper.selectByPrimaryKey(logId);
	}


	@Override
	public int saveLog(Log log) {
		// TODO Auto-generated method stub
		return logMapper.insertSelective(log);
	}


	@Override
	public List<Log> queryLogList(Log log) {
		// TODO Auto-generated method stub
		return logMapper.queryLogList(log);
	}

}