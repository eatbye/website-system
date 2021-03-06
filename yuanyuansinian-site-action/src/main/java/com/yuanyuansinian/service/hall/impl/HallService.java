/**
 * Copyright (C), 2013, 山东旭日俞和科技有限公司
 * All right reserved.
 */
package com.yuanyuansinian.service.hall.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yuanyuansinian.dao.hall.HallMapper;
import com.yuanyuansinian.model.hall.Hall;
import com.yuanyuansinian.model.hall.HallWithBLOBs;
import com.yuanyuansinian.pub.constants.IMySystemConstants;
import com.yuanyuansinian.pub.util.MyDateUtil;
import com.yuanyuansinian.service.hall.IHallService;

/**   
 * @Description: 友情链接Service 
 * @author lizhaotao lzh_me@126.com  
 * @date 2017年1月18日 上午10:50:13 
 * @version V1.0   
 */
@Service("hallService") 
public class HallService implements IHallService {
	//友情链接Mapper
	@Resource
	private HallMapper hallMapper;
	
	/*
	 * (non-Javadoc)
	 * <p>Title: updateHall</p> 
	 * <p>Description: </p> 
	 * @param hall
	 * @return 
	 * @see ujn.school.cn.service.hall.IHallService#updateHall(ujn.school.cn.model.hall.Hall)
	 */
	@Override
	public int updateHall(HallWithBLOBs hall) {
		// TODO Auto-generated method stub
		return hallMapper.updateByPrimaryKeySelective(hall);
	}
	
	/*
	 * (non-Javadoc)
	 * <p>Title: queryHallById</p> 
	 * <p>Description: </p> 
	 * @param hallId
	 * @return 
	 * @see ujn.school.cn.service.hall.IHallService#queryHallById(int)
	 */
	@Override
	public Hall queryHallById(int hallId) {
		// TODO Auto-generated method stub
		return hallMapper.selectByPrimaryKey(hallId);
	}
	
	
	/*
	 * (non-Javadoc)
	 * <p>Title: deleteHall</p> 
	 * <p>Description: </p> 
	 * @param hallId
	 * @return 
	 * @see ujn.school.cn.service.hall.IHallService#deleteHall(int)
	 */
	@Override
	public int deleteHall(int hallId) {
		
		return hallMapper.deleteByPrimaryKey(hallId);
	}


	@Override
	public List<Hall> queryHallListByType(Hall hall) {
		// TODO Auto-generated method stub
		return hallMapper.queryHallListByType(hall);
	}

	@Override
	public List<Hall> queryHallListByMember(String memberId, int limtNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("limtNum", limtNum);
		
		return hallMapper.queryHallListByMember(map);
	}

	@Override
	public List<Hall> queryHallListByOpenType(String open_type) {
		// TODO Auto-generated method stub
		return hallMapper.queryHallListByOpenType(open_type);
	}

	@Override
	public List<Hall> queryHallList(Hall hall) {
		// TODO Auto-generated method stub
		return hallMapper.queryHallList(hall);
	}

	@Override
	public List<Hall> queryHallPageListByMember(Hall hall) {
		// TODO Auto-generated method stub
		return hallMapper.queryHallPageListByMemberHall(hall);
	}

	@Override
	public List<Hall> queryHallNewList(int countNum) {
		// TODO Auto-generated method stub
		return hallMapper.queryHallNewList(countNum);
	}

	@Override
	public List<Hall> queryHallListBySearch(String search_text) {
		// TODO Auto-generated method stub
		return hallMapper.queryHallListBySearch(search_text);
	}

	@Override
	public void addSingleHall(HttpServletRequest request, HallWithBLOBs hall) {
		//保存
        hallMapper.insert(hall);
	}

	@Override
	public void addDoubleHall(HttpServletRequest request, HallWithBLOBs hall) {
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){  
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //取得request中的所有文件名  
	            Iterator<String> iter = multiRequest.getFileNames();  
	            while(iter.hasNext()){  
	                //取得上传文件  
	                MultipartFile file = multiRequest.getFile(iter.next());  
	                if(file != null){  
	                    //取得当前上传文件的文件名称  
	                    String myFileName = file.getOriginalFilename();  
	                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
	                    if(myFileName.trim() !=""){  
	                        //重命名上传后的文件名  
	                    	UUID uuid = UUID.randomUUID();
	                        String fileName = uuid + file.getOriginalFilename(); 
	                        String path = request.getSession().getServletContext().getRealPath(IMySystemConstants.FILE_PATH_IMAGE);
	                        //定义上传路径  
	                        //String path = "E:/upload-file/"; 
	                        File localFile = new File(path, fileName);  
	                        if(!localFile.exists()){  
	                        	localFile.mkdirs();  
	                        }  
	                        file.transferTo(localFile);  
	                        //hall.setCover_img_url(IMySystemConstants.FILE_PATH_IMAGE + fileName);
	                    }  
	                }  
	            }  
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		//创建时间
		hall.setCreate_date(MyDateUtil.getDateTime());
		hallMapper.insert(hall);
		
	}

	@Override
	public void uploadSingleHallImg(HttpServletRequest request, String hall_id) {
		try {
			//创建一个通用的多部分解析器  
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
	        HallWithBLOBs hall =  null;
	        //判断 request 是否有文件上传,即多部分请求  
	        if(multipartResolver.isMultipart(request)){ 
	        	hall =  new HallWithBLOBs();
	            //转换成多部分request    
	            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
	            //设置ID
				hall.setId(Integer.parseInt(hall_id));
	            //封面照片
	            MultipartFile img_index = multiRequest.getFile("img_index");
	            if(null != img_index){
	            	//取得当前上传文件的文件名称  
                    String myFileName = img_index.getOriginalFilename();  
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        //重命名上传后的文件名  
                    	UUID uuid = UUID.randomUUID();
                        String fileName = uuid + myFileName; 
                        String path = request.getSession().getServletContext().getRealPath(IMySystemConstants.FILE_PATH_IMAGE);
                        //String path = request.getContextPath() + "/" + IMySystemConstants.FILE_PATH_IMAGE;
                        
                        //定义上传路径  
                        //String path = "E:/upload-file/"; 
                        File localFile = new File(path, fileName);  
                        if(!localFile.exists()){  
                        	localFile.mkdirs();  
                        }  
                        img_index.transferTo(localFile); 
                        //处理url
                        hall.setImgs(IMySystemConstants.SERVER_FILE_PATH + fileName);
                    }
	            }
	        }
	        //保存
	        hallMapper.uploadSingleHallImg(hall);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Hall> queryHallNewListByMember(Integer memberId, int limitNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("limitNum", limitNum);
		return hallMapper.queryHallNewListByMember(map);
	}

	@Override
	public List<Hall> queryAllHallList(String hall_type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hall_type", hall_type);
		return hallMapper.queryAllHallList(map);
	}
}
