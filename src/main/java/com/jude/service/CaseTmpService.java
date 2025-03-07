package com.jude.service;

import com.jude.entity.CaseTmp;
import com.jude.entity.CaseTmpDetail;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

/**
 * 供应商Service接口
 * @author jude
 *
 */
public interface CaseTmpService {

	/**
	 * 根据名称模糊查询供应商信息
	 * @param name
	 * @return
	 */
	public List<CaseTmp> findAll();
	
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public CaseTmp findById(Integer id);
	
	/**
	 * 修改或者修改供应商信息
	 * @param CaseTmp
	 */
	public void save(CaseTmp CaseTmp);
	
	/**
	 * 根据条件分页查询供应商信息
	 * @param CaseTmp
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<CaseTmp> list(CaseTmp CaseTmp,Integer page,Integer pageSize,Direction direction,String... properties);

	public List<CaseTmpDetail> detail(String id, Integer page, Integer pageSize, Direction direction, String... properties);
	
	/**
	 * 获取总记录数
	 * @param CaseTmp
	 * @return
	 */
	public Long getCount(CaseTmp CaseTmp);
	
	/**
	 * 根据id删除供应商
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 根据id删除供应商
	 * @param id
	 */
	public CaseTmp getBase(Integer id);


}
