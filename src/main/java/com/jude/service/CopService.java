package com.jude.service;

import com.jude.entity.CopInfo;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

/**
 * 客户Service接口
 * @author java1234 小锋老师
 *
 */
public interface CopService {

	/**
	 * 根据名称模糊查询客户信息
	 * @param name
	 * @return
	 */
	public List<CopInfo> findByName(String name);
	
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public CopInfo findById(Integer id);
	
	/**
	 * 添加或者修改客户信息
	 * @param CopInfo
	 */
	public CopInfo save(CopInfo CopInfo);
	
	/**
	 * 根据条件分页查询客户信息
	 * @param CopInfo
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<CopInfo> list(CopInfo CopInfo,Integer page,Integer pageSize,Direction direction,String... properties);
	
	/**
	 * 获取总记录数
	 * @param CopInfo
	 * @return
	 */
	public Long getCount(CopInfo CopInfo);
	
	/**
	 * 根据id删除客户
	 * @param id
	 */
	public void delete(Integer id);
}
