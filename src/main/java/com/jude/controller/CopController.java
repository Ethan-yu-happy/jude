package com.jude.controller;

import com.jude.entity.*;
import com.jude.service.CopService;
import com.jude.service.EmployeeService;
import com.jude.service.UserRoleService;
import com.jude.service.UserService;
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
 *
 * @author jude
 */
@RestController
@RequestMapping("/cop")
public class CopController {


    @Resource
    private UserRoleService userRoleService;

    @Resource
    private CopService copService;
    @Resource
    private EmployeeService employeeService;



    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public Map<String, Object> list(CopInfo cop, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) throws Exception {
        List<CopInfo> copList = copService.list(cop, page, rows, Direction.ASC, "id");
        Long total = copService.getCount(cop);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", copList);
        resultMap.put("total", total);
        return resultMap;
    }

    /**
     * 下拉框模糊查询
     *
     * @param q
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/comboList")
    public List<CopInfo> comboList(String q) throws Exception {
        if (q == null) {
            q = "";
        }
        return copService.findByName("%" + q + "%");
    }

    /**
     * 添加或者修改客户信息
     *
     * @param cop
     * @return
     * @throws Exception
     */
    @Transactional
    @RequestMapping("/save")
    public Map<String, Object> save(CopInfo cop) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        CopInfo copInfo=copService.save(cop);
        User user = new User();
        user.setPassword("123456");
        user.setUserName(cop.getNumber());
        user.setTrueName(cop.getContact());
        User newUser = userService.save(user);
        Employee employee =new Employee();
        employee.setName(cop.getContact());
        employee.setCopId(copInfo.getId().toString());
        employee.setUserId(newUser.getId().toString());
        employee.setNumber(cop.getNumber());
        employeeService.save(employee);
        UserRole userRole = new UserRole();
        Role role = new Role();
        role.setId(9);//总经理
        userRole.setRole(role);
        userRole.setUser(newUser);
        userRoleService.save(userRole);
        resultMap.put("success", true);
        return resultMap;

    }


    /**
     * 删除客户信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public Map<String, Object> delete(String ids) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            copService.delete(id);
        }
        resultMap.put("success", true);
        return resultMap;
    }

}
