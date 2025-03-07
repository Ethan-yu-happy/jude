package com.jude.service;

import com.jude.entity.CaseInfo;
import com.jude.entity.CaseInfo;
import com.jude.entity.Pic;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;
import java.util.Map;

/**
 * 供应商Service接口
 * @author jude
 *
 */
public interface CaseInfoService {

	/**
	 * 根据名称模糊查询供应商信息
	 * @param name
	 * @return
	 */
	public List<CaseInfo> findAll();
	
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public CaseInfo findById(Integer id);
	
	/**
	 * 修改或者修改供应商信息
	 * @param CaseInfo
	 */
	public void save(CaseInfo CaseInfo);
	
	/**
	 * 根据条件分页查询供应商信息
	 * @param CaseInfo
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<Map> list(String tmpId);
	
	/**
	 * 获取总记录数
	 * @param CaseInfo
	 * @return
	 */
	public Long getCount(CaseInfo caseInfo);
	
	/**
	 * 根据id删除供应商
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 根据id删除供应商
	 * @param id
	 */
	public CaseInfo getBase(Integer id);


}
