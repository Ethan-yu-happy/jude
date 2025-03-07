package com.jude.service;

import com.jude.entity.LetMsgTem;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

/**
 * 供应商Service接口
 * @author jude
 *
 */
public interface LetMsgTemService {

	/**
	 * 根据名称模糊查询供应商信息
	 * @return
	 */
	public List<LetMsgTem> findAll();
	
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public LetMsgTem findById(Integer id);
	
	/**
	 * 修改或者修改供应商信息
	 * @param letterMsg
	 */
	public void save(LetMsgTem letterMsg);
	
	/**
	 * 根据条件分页查询供应商信息
	 * @param letterMsg
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<LetMsgTem> list(LetMsgTem letterMsg,Integer page,Integer pageSize,Direction direction,String... properties);
	
	/**
	 * 获取总记录数
	 * @param letterMsg
	 * @return
	 */
	public Long getCount(LetMsgTem letterMsg);
	
	/**
	 * 根据id删除供应商
	 * @param id
	 */
	public void delete(Integer id);
}
