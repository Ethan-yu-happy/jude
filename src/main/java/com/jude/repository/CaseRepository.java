package com.jude.repository;

import com.jude.entity.Case;
import com.jude.entity.CaseInfo;
import com.jude.entity.DamageListGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 供应商Repository接口
 * @author jude
 *
 */
public interface CaseRepository extends JpaRepository<Case, Integer>,JpaSpecificationExecutor<Case>{

	/**
	 * 根据名称模糊查询供应商信息
	 * @param name
	 * @return
	 */
	//@Query(value="select * from t_letter_send")
	//public List<LetterSend> findAll();

	/**
	 * 根据报损单id查询所有报损单商品
	 * @param damageListId
	 * @return
	 */
	@Query(value="select * from t_case where employee_id=?1 and tmp_id=?2",nativeQuery=true)
	public List<Case> listByTemIdEmployeeId(Integer damageListId ,String tmpId);
	
}
