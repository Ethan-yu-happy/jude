package com.jude.repository;

import com.jude.entity.CaseInfo;
import com.jude.entity.Pic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 供应商Repository接口
 * @author jude
 *
 */
public interface CaseInfoRepository extends JpaRepository<CaseInfo, Integer>,JpaSpecificationExecutor<CaseInfo>{
	@Query(value="select * from t_case_info where  case_id = ?1",nativeQuery=true)
	List<CaseInfo> listByCaseId(String string);
	/**
	 * 根据名称模糊查询供应商信息
	 * @param name
	 * @return
	 */
	//@Query(value="select * from t_letter_send")
	//public List<LetterSend> findAll();
	
}
