package com.jude.service.impl;

import com.jude.entity.Employee;
import com.jude.repository.EmployeeRepository;
import com.jude.service.EmployeeService;
import com.jude.service.EmployeeService;
import com.jude.util.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

/**
 * 客户Service实现类
 * @author jude
 *
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeRepository employeeRepository;

	@Override
	public void save(Employee Employee) {
		employeeRepository.save(Employee);
	}

	@Override
	public List<Employee> list(Employee employee, Integer page, Integer pageSize, Direction direction, String... properties) {
		Pageable pageable=new PageRequest(page-1, pageSize, direction,properties);
		Page<Employee> pageEmployee=employeeRepository.findAll(new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(employee!=null){
					if(StringUtil.isNotEmpty(employee.getCopId())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+employee.getName().trim()+"%"));
						predicate.getExpressions().add(cb.equal(root.get("copId"), employee.getCopId()));
					}	
				}
				return predicate;
			}
		}, pageable);
		return pageEmployee.getContent();
	}

	@Override
	public Long getCount(Employee Employee) {
		Long count=employeeRepository.count(new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(Employee!=null){
					if(StringUtil.isNotEmpty(Employee.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+Employee.getName().trim()+"%"));
					}	
				}
				return predicate;
			}
		});
		return count;
	}

	@Override
	public void delete(Integer id) {
		employeeRepository.delete(id);
	}

	@Override
	public Employee findById(Integer id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public List<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public Employee  findByUserId(Integer userId) {
		List<Employee> employees = employeeRepository.findByUserId(userId);
		if (!CollectionUtils.isEmpty(employees))
		return employees.get(0);
		else
			return null;
	}


}
