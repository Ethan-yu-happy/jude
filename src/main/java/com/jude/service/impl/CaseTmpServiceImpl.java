package com.jude.service.impl;

import com.jude.entity.CaseTmp;
import com.jude.entity.CaseTmpDetail;
import com.jude.repository.CaseTmpDetailRepository;
import com.jude.repository.CaseTmpRepository;
import com.jude.service.CaseTmpService;
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
import java.util.Collections;
import java.util.List;

/**
 * 供应商Service实现类
 * @author jude
 *
 */
@Service("CaseTmpService")
public class CaseTmpServiceImpl implements CaseTmpService {

	@Resource
	private CaseTmpRepository caseTmpRepository;

	@Resource
	private CaseTmpDetailRepository caseTmpDetailRepository;


	

	@Override
	public void save(CaseTmp CaseTmp) {
		caseTmpRepository.save(CaseTmp);
	}

	@Override
	public List<CaseTmp> list(CaseTmp caseTmp, Integer page, Integer pageSize, Direction direction, String... properties) {

		Pageable pageable=new PageRequest(page-1, pageSize, direction,properties);
		Page<CaseTmp> pageLetterSend= caseTmpRepository.findAll(new Specification<CaseTmp>() {

			@Override
			public Predicate toPredicate(Root<CaseTmp> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(caseTmp!=null){
					//if(StringUtil.isNotEmpty(CaseTmp.getName())){
					//	predicate.getExpressions().add(cb.like(root.get("name"), "%"+CaseTmp.getName().trim()+"%"));
					//}
				}
				return predicate;
			}
		}, pageable);
		return pageLetterSend.getContent();
	}

	@Override
	public List<CaseTmpDetail> detail(String  id, Integer page, Integer pageSize, Direction direction, String... properties) {
		page =1;
		pageSize = 9999;
		Pageable pageable=new PageRequest(page-1, pageSize, direction,properties);
		Page<CaseTmpDetail> pageLetterSend= caseTmpDetailRepository.findAll(new Specification<CaseTmpDetail>() {
			@Override
			public Predicate toPredicate(Root<CaseTmpDetail> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
						predicate.getExpressions().add(cb.equal(root.get("tmpId"), id));
				return predicate;
			}
		}, pageable);
		return pageLetterSend.getContent();
	}

	@Override
	public Long getCount(CaseTmp CaseTmp) {
		return null;
	}

	@Override
	public void delete(Integer id) {
		caseTmpRepository.delete(id);
	}

	@Override
	public CaseTmp getBase(Integer id) {
		return caseTmpRepository.findOne(id);
	}

	@Override
	public CaseTmp findById(Integer id) {
		return null;
	}

	@Override
	public List<CaseTmp> findAll() {
		return null;
	}


}
