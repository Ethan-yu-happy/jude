package com.jude.service.impl;

import com.jude.entity.LetterSend;
import com.jude.entity.Pic;
import com.jude.repository.PicRepository;
import com.jude.service.PicService;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 供应商Service实现类
 * @author jude
 *
 */
@Service("PicService")
public class PicServiceImpl implements PicService {

	@Resource
	private PicRepository picRepository;
	

	@Override
	public void save(LetterSend LetterSend) {
		//letterSendRepository.save(LetterSend);
	}

	@Override
	public List<LetterSend> list(LetterSend LetterSend, Integer page, Integer pageSize, Direction direction, String... properties) {

		return null;
	}

	@Override
	public Long getCount(LetterSend LetterSend) {
		return null;
	}

	@Override
	public void delete(Integer id) {
		picRepository.delete(id);
	}

	@Override
	public Pic getBase(Integer id) {
		return picRepository.findOne(id);
	}

	@Override
	public LetterSend findById(Integer id) {
		return null;
	}

	@Override
	public List<LetterSend> findAll() {
		return null;
	}


}
