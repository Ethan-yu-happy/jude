package com.jude.repository;

import com.jude.entity.CopInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 客户Repository接口
 * @author jude
 *
 */
public interface CopInfoRepository extends JpaRepository<CopInfo, Integer>,JpaSpecificationExecutor<CopInfo>{

	/**
	 * 根据名称模糊查询客户信息
	 * @param name
	 * @return
	 */
	@Query(value="select * from t_CopInfo where name like ?1",nativeQuery=true)
	public List<CopInfo> findByName(String name);
}
