package com.jude.service;

import com.jude.entity.Employee;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

/**
 * 客户Service接口
 * @author java1234 小锋老师
 *
 */
public interface EmployeeService {

	/**
	 * 根据名称模糊查询客户信息
	 * @param name
	 * @return
	 */
	public List<Employee> findByName(String name);

	/**
	 * 根据名称模糊查询客户信息
	 * @param name
	 * @return
	 */
	public Employee findByUserId(Integer userId);
	
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public Employee findById(Integer id);
	
	/**
	 * 添加或者修改客户信息
	 * @param Employee
	 */
	public void save(Employee Employee);
	
	/**
	 * 根据条件分页查询客户信息
	 * @param Employee
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return
	 */
	public List<Employee> list(Employee Employee,Integer page,Integer pageSize,Direction direction,String... properties);
	
	/**
	 * 获取总记录数
	 * @param Employee
	 * @return
	 */
	public Long getCount(Employee Employee);
	
	/**
	 * 根据id删除客户
	 * @param id
	 */
	public void delete(Integer id);
}
