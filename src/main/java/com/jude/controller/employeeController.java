package com.jude.controller;

import com.jude.entity.*;
import com.jude.service.*;
import com.jude.service.EmployeeService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理客户Controller
 * @author jude
 *
 */
@RestController
@RequestMapping("/employee")
public class employeeController {
	
	@Resource
	private EmployeeService employeeService;

	@Resource
	private UserRoleService userRoleService;

	@Resource
	private CopService copService;

	@Resource
	private UserService userService;




	
	
	/**
	 * 分页查询客户信息
	 * @param Employee
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String,Object> list(HttpSession session, Employee employee, @RequestParam(value="page",required=false)Integer page, @RequestParam(value="rows",required=false)Integer rows)throws Exception{
		User currentUser=(User) session.getAttribute("currentUser");
		//Cop  copService.getCopInfo(currentUser.getId());
		Employee CurrentEmployee = employeeService.findByUserId(currentUser.getId());
		employee.setCopId(CurrentEmployee.getCopId());
		List<Employee> employeeList=employeeService.list(employee, page, rows, Direction.ASC, "id");
		Long total=employeeService.getCount(employee);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("rows", employeeList);
		resultMap.put("total", total);
		return resultMap;
	}
	
	/**
	 * 下拉框模糊查询
	 * @param q
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/comboList")
	public List<Employee> comboList(String q)throws Exception{
		if(q==null){
			q="";
		}
		return employeeService.findByName("%"+q+"%");
	}

	/**
	 * 添加或者修改客户信息
	 * @param Employee
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping("/save")
	public Map<String,Object> save(HttpSession session, Employee employee)throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		User currentUser=(User) session.getAttribute("currentUser");
		User user=new User();
		user.setPassword("123456");
		user.setUserName(employee.getNumber());
		user.setTrueName(employee.getName());
		Employee CurrentEmployee = employeeService.findByUserId(currentUser.getId());
		employee.setCopId(CurrentEmployee.getCopId());
		employeeService.save(employee);
		if (employee.getId()==null){
			User newUser =  userService.save(user);
			UserRole userRole=new UserRole();
			Role role =new Role();
			role.setId(5);
			userRole.setRole(role);
			userRole.setUser(newUser);
			userRoleService.save(userRole);
		}
		resultMap.put("success", true);
		return resultMap;
	}
	
	
	/**
	 * 删除客户信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public Map<String,Object> delete(String ids)throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			int id=Integer.parseInt(idsStr[i]);
			employeeService.delete(id);
		}
		resultMap.put("success", true);
		return resultMap;
	}

}
