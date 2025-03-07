package com.jude.repository;

import com.jude.entity.LetterSend;
import com.jude.entity.Pic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 供应商Repository接口
 * @author jude
 *
 */
public interface PicRepository extends JpaRepository<Pic, Integer>,JpaSpecificationExecutor<Pic>{

	/**
	 * 根据名称模糊查询供应商信息
	 * @param name
	 * @return
	 */
	//@Query(value="select * from t_letter_send")
	//public List<LetterSend> findAll();
	
}
