package cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.kgc.tangcco.tcmp073.qizu.entity.Companyresume;
import cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.mapper.CompanyresumeMapper;
import cn.kgc.tangcco.tcmp073.qizu.recruit.companyresume.service.CompanyresumeService;
@Service
public class CompanyresumeServiceImpl implements CompanyresumeService {

	@Resource
	private CompanyresumeMapper cm;
	
	@Override
	public int addCompanyresume(Companyresume cr) {
		return cm.addCompanyresume(cr);
	}

	@Override
	public int updateCompanyresume(Companyresume cr) {
		return cm.updateCompanyresume(cr);
	}

	@Override
	public int deleteCompanyresume(Integer crid) {
		return cm.deleteCompanyresume(crid);
	}

	@Override
	public List<Companyresume> queryAllCompanyresume(Companyresume cr) {
		return cm.queryAllCompanyresume(cr);
	}

}
