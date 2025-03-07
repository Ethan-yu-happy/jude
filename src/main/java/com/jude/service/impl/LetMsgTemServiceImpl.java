package com.jude.service.impl;

import com.jude.entity.LetMsgTem;
import com.jude.repository.LetMsgTemRepository;
import com.jude.service.LetMsgTemService;
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
 * 供应商Service实现类
 * @author jude
 *
 */
@Service("LetMsgTemService")
public class LetMsgTemServiceImpl implements LetMsgTemService {

	@Resource
	private LetMsgTemRepository letterMsgRepository;
	

	@Override
	public void save(LetMsgTem letterMsg) {
		letterMsgRepository.save(letterMsg);
	}

	@Override
	public List<LetMsgTem> list(LetMsgTem letMsgTem, Integer page, Integer pageSize, Direction direction, String... properties) {
		Pageable pageable=new PageRequest(page-1, pageSize, direction,properties);
		Page<LetMsgTem> pageLetterMsg= letterMsgRepository.findAll(new Specification<LetMsgTem>() {
			
			@Override
			public Predicate toPredicate(Root<LetMsgTem> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(letMsgTem!=null){
					//判断条件
					/*if(StringUtil.isNotEmpty(LetterMsg.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+LetterMsg.getName().trim()+"%"));
					}*/
				}
				return predicate;
			}
		}, pageable);
		return pageLetterMsg.getContent();
	}

	@Override
	public Long getCount(LetMsgTem letterMsg) {
		//Long count= letterMsgRepository.count(new Specification<LetMsgTem>() {
/*
			@Override
			public Predicate toPredicate(Root<LetMsgTem> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(letterMsg!=null){
					if(StringUtil.isNotEmpty(letterMsg.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+letterMsg.getName().trim()+"%"));
					}	
				}
				return predicate;
			}
		});*/
		return 0L;
	}

	@Override
	public void delete(Integer id) {
		letterMsgRepository.delete(id);
	}

	@Override
	public LetMsgTem findById(Integer id) {
		return letterMsgRepository.findOne(id);
	}

	@Override
	public List<LetMsgTem> findAll() {
		return letterMsgRepository.findAll();
	}


}
