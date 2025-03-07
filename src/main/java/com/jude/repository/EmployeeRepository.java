package com.jude.repository;

import com.jude.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 客户Repository接口
 * @author jude
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee>{

	/**
	 * 根据名称模糊查询客户信息
	 * @param name
	 * @return
	 */
	@Query(value="select * from t_Employee where name like ?1",nativeQuery=true)
	public List<Employee> findByName(String name);

	/**
	 * 根据用户id查员工信息
	 * @param name
	 * @return
	 */
	@Query(value="select * from t_employee where user_id = ?1",nativeQuery=true)
	public List<Employee> findByUserId(Integer userId);
}
