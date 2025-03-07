package com.jude.controller;

import com.jude.entity.CaseTmp;
import com.jude.entity.CaseTmpDetail;
import com.jude.repository.CaseTmpDetailRepository;
import com.jude.repository.CaseTmpRepository;
import com.jude.service.CaseTmpService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 函件发送
 * @author jude
 *
 */
@RestController
@RequestMapping("/caseTmp")
public class CaseTmpController {

	@Resource
	private CaseTmpService caseTmpService;
	@Resource
	private CaseTmpDetailRepository caseTmpDetailRepository;

	@Resource
	private CaseTmpRepository caseTmpRepository;


	/**
	 * 分页查询供应商信息
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	//@RequiresPermissions(value = { "供应商管理" })
	public Map<String,Object> list(CaseTmp caseTmp, @RequestParam(value="page",required=false)Integer page, @RequestParam(value="rows",required=false)Integer rows)throws Exception{
		List<CaseTmp> caseTmpList= caseTmpService.list(caseTmp, page, rows, Sort.Direction.ASC, "id");
		Long total= caseTmpService.getCount(caseTmp);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("rows", caseTmpList);
		resultMap.put("total", total);
		//logService.save(new Log(Log.SEARCH_ACTION,"查询供应商信息")); // 写入日志
		return resultMap;
	}



	@RequestMapping("/detail")
	//@RequiresPermissions(value = { "供应商管理" })
	public Map<String,Object> detail(String id, @RequestParam(value="page",required=false)Integer page, @RequestParam(value="rows",required=false)Integer rows)throws Exception{
		List<CaseTmpDetail> caseTmpList= caseTmpService.detail(id, page, rows, Sort.Direction.ASC, "id");
		//Long total= caseTmpService.getCount(caseTmp);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("rows", caseTmpList);
		resultMap.put("total", caseTmpList.size());
		//logService.save(new Log(Log.SEARCH_ACTION,"查询供应商信息")); // 写入日志
		return resultMap;
	}





	@RequestMapping("/listAll")
	//@RequiresPermissions(value = { "供应商管理" })
	public List<CaseTmp> listAll()throws Exception{
		List<CaseTmp> caseTmpList= caseTmpRepository.findAll();
		return caseTmpList;
	}


	@RequestMapping("/getBase")
	public Map<String,Object> getBase(Integer id)throws Exception{
		CaseTmp pic= caseTmpService.getBase(id);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("rows", pic);
		resultMap.put("total", 1);
		return resultMap;
	}




	/**
	 * 添加或者修改供应商信息
	 * @param caseTmp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	//@RequiresPermissions(value = { "供应商管理" })
	public Map<String,Object> save(CaseTmp caseTmp)throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		caseTmpService.save(caseTmp);
		resultMap.put("success", true);
		return resultMap;
	}

	@RequestMapping("/saveDetail")
	//@RequiresPermissions(value = { "供应商管理" })
	public Map<String,Object> saveDetail(CaseTmpDetail caseTmpDetail)throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		caseTmpDetailRepository.save(caseTmpDetail);
		resultMap.put("success", true);
		return resultMap;
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
			caseTmpService.delete(id);
		}
		resultMap.put("success", true);
		return resultMap;
	}

	@RequestMapping("/deleteDetail")
	public Map<String,Object> deleteDetail(String ids)throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			int id=Integer.parseInt(idsStr[i]);
			caseTmpDetailRepository.delete(id);
		}
		resultMap.put("success", true);
		return resultMap;
	}



}
