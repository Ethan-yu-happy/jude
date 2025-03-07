package com.jude.controller;

import com.jude.entity.LetMsgTem;
import com.jude.entity.Log;
import com.jude.repository.LetMsgTemRepository;
import com.jude.service.LetMsgTemService;
import com.jude.service.LogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("/letMsgTem")
public class LetMsgTemController {

	@Resource
	private LetMsgTemService letterMsgService;
	@Resource
	private LetMsgTemRepository letMsgTemRepository;

	@Resource
	private LogService logService;

	/**
	 * 分页查询函件短信模版信息
	 * @param letterMsg
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String,Object> list(LetMsgTem letterMsg, @RequestParam(value="page",required=false)Integer page, @RequestParam(value="rows",required=false)Integer rows)throws Exception{
		List<LetMsgTem> letterMsgList= letterMsgService.list(letterMsg, page, rows, Sort.Direction.ASC, "id");
		Long total= letterMsgService.getCount(letterMsg);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("rows", letterMsgList);
		resultMap.put("total", total);
		//logService.save(new Log(Log.SEARCH_ACTION,"查询函件短信模版信息")); // 写入日志
		return resultMap;
	}

	@RequestMapping("/listMenu")
	public List<LetMsgTem> listMenu()throws Exception{
		List<LetMsgTem> list= letMsgTemRepository.findAll();
		return list;
	}





	/**
	 * 添加或者修改函件短信模版信息
	 * @param letterMsg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public Map<String,Object> save(LetMsgTem letMsgTem)throws Exception{
		if(letMsgTem.getId()!=null){ // 写入日志
			logService.save(new Log(Log.UPDATE_ACTION,"更新函件短信模版信息"+letMsgTem));
		}else{
			logService.save(new Log(Log.ADD_ACTION,"添加函件短信模版信息"+letMsgTem));
		}
		Map<String, Object> resultMap = new HashMap<>();
		letterMsgService.save(letMsgTem);
		resultMap.put("success", true);
		return resultMap;
	}


	/**
	 * 删除函件短信模版信息
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions(value = { "函件短信模版管理" })
	public Map<String,Object> delete(String ids)throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			int id=Integer.parseInt(idsStr[i]);
			//logService.save(new Log(Log.DELETE_ACTION,"删除函件短信模版信息"+ letterMsgService.findById(id)));  // 写入日志
			letterMsgService.delete(id);
		}
		resultMap.put("success", true);
		return resultMap;
	}
}
