package com.jude.controller;

import com.jude.entity.LetterSend;
import com.jude.entity.Log;
import com.jude.entity.Pic;
import com.jude.service.LogService;
import com.jude.service.PicService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 函件发送
 * @author jude
 *
 */
@RestController
@RequestMapping("/pic")
public class PicController {

	@Resource
	private PicService picService;

	@Resource
	private LogService logService;

	/**
	 * 分页查询供应商信息
	 * @param LetterSend
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	//@RequiresPermissions(value = { "供应商管理" })
	public Map<String,Object> list(LetterSend LetterSend, @RequestParam(value="page",required=false)Integer page, @RequestParam(value="rows",required=false)Integer rows)throws Exception{
		List<LetterSend> LetterSendList= picService.list(LetterSend, page, rows, Sort.Direction.ASC, "id");
		Long total= picService.getCount(LetterSend);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("rows", LetterSendList);
		resultMap.put("total", total);
		//logService.save(new Log(Log.SEARCH_ACTION,"查询供应商信息")); // 写入日志
		return resultMap;
	}

	@RequestMapping("/getBase")
	public Map<String,Object> getBase(Integer id)throws Exception{
		Pic pic= picService.getBase(id);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("rows", pic);
		resultMap.put("total", 1);
		return resultMap;
	}




	/**
	 * 添加或者修改供应商信息
	 * @param LetterSend
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	@RequiresPermissions(value = { "供应商管理" })
	public Map<String,Object> save(LetterSend LetterSend)throws Exception{
		if(LetterSend.getId()!=null){ // 写入日志
			logService.save(new Log(Log.UPDATE_ACTION,"更新供应商信息"+LetterSend));
		}else{
			logService.save(new Log(Log.ADD_ACTION,"添加供应商信息"+LetterSend));
		}
		Map<String, Object> resultMap = new HashMap<>();
		picService.save(LetterSend);
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
			//logService.save(new Log(Log.DELETE_ACTION,"删除供应商信息"+ letterSendService.findById(id)));  // 写入日志
			picService.delete(id);
		}
		resultMap.put("success", true);
		return resultMap;
	}


}
