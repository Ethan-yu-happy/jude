package com.jude.service;

import com.jude.entity.LetterSend;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

/**
 * 供应商Service接口
 * @author jude
 *
 */
public interface LetterSendService {

	/**
	 * 根据名称模糊查询供应商信息
	 * @param name
	 * @return
	 */
	public List<LetterSend> findAll();
	
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public LetterSend findById(Integer id);
	
	/**
	 * 修改或者修改供应商信息
	 * @param LetterSend
	 */
	public void save(LetterSend LetterSend);
	
	/**
	 * 根据条件分页查询供应商信息
	 * @param LetterSend
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<LetterSend> list(LetterSend LetterSend,Integer page,Integer pageSize,Direction direction,String... properties);
	
	/**
	 * 获取总记录数
	 * @param LetterSend
	 * @return
	 */
	public Long getCount(LetterSend LetterSend);
	
	/**
	 * 根据id删除供应商
	 * @param id
	 */
	public void delete(Integer id);
}
