package com.jude.service.impl;

import com.jude.entity.LetterSend;
import com.jude.repository.LetterSendRepository;
import com.jude.service.LetterSendService;
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
@Service("LetterSendService")
public class LetterSendServiceImpl implements LetterSendService {

	@Resource
	private LetterSendRepository letterSendRepository;
	

	@Override
	public void save(LetterSend LetterSend) {
		letterSendRepository.save(LetterSend);
	}

	@Override
	public List<LetterSend> list(LetterSend LetterSend, Integer page, Integer pageSize, Direction direction, String... properties) {
		Pageable pageable=new PageRequest(page-1, pageSize, direction,properties);
		Page<LetterSend> pageLetterSend= letterSendRepository.findAll(new Specification<LetterSend>() {
			
			@Override
			public Predicate toPredicate(Root<LetterSend> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(LetterSend!=null){
					if(StringUtil.isNotEmpty(LetterSend.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+LetterSend.getName().trim()+"%"));
					}	
				}
				return predicate;
			}
		}, pageable);
		return pageLetterSend.getContent();
	}

	@Override
	public Long getCount(LetterSend LetterSend) {
		Long count= letterSendRepository.count(new Specification<LetterSend>() {

			@Override
			public Predicate toPredicate(Root<LetterSend> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(LetterSend!=null){
					if(StringUtil.isNotEmpty(LetterSend.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+LetterSend.getName().trim()+"%"));
					}	
				}
				return predicate;
			}
		});
		return count;
	}

	@Override
	public void delete(Integer id) {
		letterSendRepository.delete(id);
	}

	@Override
	public LetterSend findById(Integer id) {
		return letterSendRepository.findOne(id);
	}

	@Override
	public List<LetterSend> findAll() {
		return letterSendRepository.findAll();
	}


}
