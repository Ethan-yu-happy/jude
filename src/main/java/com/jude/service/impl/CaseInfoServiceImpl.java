package com.jude.service.impl;

import com.jude.entity.Case;
import com.jude.entity.CaseInfo;
import com.jude.entity.LetterSend;
import com.jude.repository.CaseInfoRepository;
import com.jude.repository.CaseRepository;
import com.jude.service.CaseInfoService;
import com.jude.util.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供应商Service实现类
 *
 * @author jude
 */
@Service("CaseInfoService")
public class CaseInfoServiceImpl implements CaseInfoService {

    @Resource
    private CaseInfoRepository caseInfoRepository;
    @Resource
    private CaseRepository caseRepository;


    @Override
    public void save(CaseInfo caseInfo) {
        caseInfoRepository.save(caseInfo);
    }

    @Override
    public List<Map> list(String tmpId) {
        List<Map> result=new ArrayList<>();
        List<Case> caseList = caseRepository.listByTemIdEmployeeId(1,tmpId);
        Map<String,String> caseData=null;
        List<CaseInfo> caseInfoList=null;
        for (Case caseEntity : caseList) {
            caseInfoList = caseInfoRepository.listByCaseId(caseEntity.getId().toString());
            caseData=new HashMap();
            for(int i=0;i<caseInfoList.size();i++){
                caseData.put("c"+i,caseInfoList.get(i).getValue());
            }
            result.add(caseData);
        }
        return result;
    }

    @Override
    public Long getCount(CaseInfo CaseInfo) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        caseInfoRepository.delete(id);
    }

    @Override
    public CaseInfo getBase(Integer id) {
        return caseInfoRepository.findOne(id);
    }

    @Override
    public CaseInfo findById(Integer id) {
        return null;
    }

    @Override
    public List<CaseInfo> findAll() {
        return null;
    }


}
