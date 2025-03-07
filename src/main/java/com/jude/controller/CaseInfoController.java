package com.jude.controller;

import com.jude.entity.*;
import com.jude.repository.CaseInfoRepository;
import com.jude.repository.CaseRepository;
import com.jude.service.CaseInfoService;
import com.jude.service.EmployeeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 函件发送
 * @author jude
 *
 */
@RestController
@RequestMapping("/caseInfo")
public class CaseInfoController {

	@Resource
	private CaseInfoService caseInfoService;
	@Resource
	private EmployeeService employeeService;
	@Resource
	private CaseInfoRepository caseInfoRepository;
	@Resource
	private CaseRepository caseRepository;

	/**
	 * 分页查询供应商信息
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	@Transactional
	//@RequiresPermissions(value = { "供应商管理" })
	public Map<String,Object> list(String tmpId, @RequestParam(value="page",required=false)Integer page, @RequestParam(value="rows",required=false)Integer rows)throws Exception{
		List<Map> CaseInfoList= caseInfoService.list(tmpId);
		//Long total= caseInfoService.getCount(caseInfo);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("rows", CaseInfoList);
		resultMap.put("total", CaseInfoList.size());
		//logService.save(new Log(Log.SEARCH_ACTION,"查询供应商信息")); // 写入日志
		return resultMap;
	}




	@RequestMapping("/listAll")
	//@RequiresPermissions(value = { "供应商管理" })
	public List<CaseInfo> listAll()throws Exception{
		List<CaseInfo> caseInfoList= caseInfoRepository.findAll();
		return caseInfoList;
	}


	@RequestMapping("/getBase")
	public Map<String,Object> getBase(Integer id)throws Exception{
		CaseInfo pic= caseInfoService.getBase(id);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("rows", pic);
		resultMap.put("total", 1);
		return resultMap;
	}




	/**
	 * 添加或者修改供应商信息
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Transactional
	//@RequiresPermissions(value = { "供应商管理" })
	public Map<String,Object> save(HttpSession session,@RequestParam  List<String> data,String tmpId,Integer tmpSize)throws Exception{
		User currentUser=(User) session.getAttribute("currentUser");
		Employee CurrentEmployee = employeeService.findByUserId(currentUser.getId());
		Case caseEntity;
		CaseInfo caseInfo;
		//26 13
		int caseNum=data.size()/tmpSize;
		String value;
		for(int i=0;i<caseNum;i++){
			caseEntity=new Case();
			caseEntity.setEmployeeId(CurrentEmployee.getId().toString());
			caseEntity.setTmpId(tmpId);
			caseEntity=  caseRepository.save(caseEntity);
			for (int j=0;j<tmpSize;j++){
				//data.get(i*tmpSize+j).  [{"用户手机号":19117251744
				caseInfo=new CaseInfo();
				caseInfo.setCaseId(caseEntity.getId().toString());
				caseInfo.setTmpId(tmpId);
				caseInfo.setValue(data.get(i*tmpSize+j).substring(data.get(i*tmpSize+j).indexOf(':')+1,data.get(i*tmpSize+j).length()));
				caseInfoRepository.save(caseInfo);
			}
		}
		//data.get(0)
		Map<String, Object> resultMap = new HashMap<>();
		//caseInfoService.save(null);
		resultMap.put("success", true);
		return resultMap;
	}

	public static void main(String[] args) {
		String a="[{\"用户手机号\":19117251744";
		System.out.println(a.substring(a.indexOf(':')+1,a.length()));
	}


	/**
	 * 删除供应商信息
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions(value = { "供应商管理" })
	public Map<String,Object> delete(String ids)throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			int id=Integer.parseInt(idsStr[i]);
			//logService.save(new Log(Log.DELETE_ACTION,"删除供应商信息"+ CaseInfoService.findById(id)));  // 写入日志
			caseInfoService.delete(id);
		}
		resultMap.put("success", true);
		return resultMap;
	}



}
