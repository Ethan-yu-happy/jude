package com.jude.service.impl;

import com.jude.entity.CopInfo;
import com.jude.repository.CopInfoRepository;
import com.jude.service.CopService;
import com.jude.util.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * 客户Service实现类
 * @author jude
 *
 */
@Service("copService")
public class CopInfoServiceImpl implements CopService {

	@Resource
	private CopInfoRepository copInfoRepository;
	

	@Override
	public CopInfo save(CopInfo CopInfo) {
		return copInfoRepository.save(CopInfo);
	}

	@Override
	public List<CopInfo> list(CopInfo CopInfo, Integer page, Integer pageSize, Direction direction, String... properties) {
		Pageable pageable=new PageRequest(page-1, pageSize, direction,properties);
		Page<CopInfo> pageCopInfo=copInfoRepository.findAll(new Specification<CopInfo>() {
			
			@Override
			public Predicate toPredicate(Root<CopInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
//				if(CopInfo!=null){
//					if(StringUtil.isNotEmpty(CopInfo.getName())){
//						predicate.getExpressions().add(cb.like(root.get("name"), "%"+CopInfo.getName().trim()+"%"));
//					}
//				}
				return predicate;
			}
		}, pageable);
		return pageCopInfo.getContent();
	}

	@Override
	public Long getCount(CopInfo copInfo) {
		Long count=copInfoRepository.count(new Specification<CopInfo>() {

			@Override
			public Predicate toPredicate(Root<CopInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
//				if(CopInfo!=null){
//					if(StringUtil.isNotEmpty(CopInfo.getName())){
//						predicate.getExpressions().add(cb.like(root.get("name"), "%"+CopInfo.getName().trim()+"%"));
//					}
//				}
				return predicate;
			}
		});
		return count;
	}

	@Override
	public void delete(Integer id) {
		copInfoRepository.delete(id);
	}

	@Override
	public CopInfo findById(Integer id) {
		return copInfoRepository.findOne(id);
	}

	@Override
	public List<CopInfo> findByName(String name) {
		return copInfoRepository.findByName(name);
	}


}
