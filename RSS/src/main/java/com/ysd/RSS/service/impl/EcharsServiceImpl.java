package com.ysd.RSS.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.RSS.dao.EcharsDao;
import com.ysd.RSS.Jpadao.EcharsJpaDao;
import com.ysd.RSS.service.EcharsService;
@Service
public class EcharsServiceImpl implements EcharsService {
   @Autowired
   private EcharsDao echarsdao;
   @Autowired
   private EcharsJpaDao echarsJpaDao;
	@Override
	public List<Map<Object,Object>> SelectTuBiaoXiCount() {
		// TODO Auto-generated method stub
		
		return echarsdao.SelectTuBiaoXiCount();
	}
	@Override
	public List<Map<Object, Object>> SelectTuBiaoBanJiCount() {
		// TODO Auto-generated method stub
		return echarsdao.SelectTuBiaoBanJiCount();
	}
	@Override
	public List<Map<Object, Object>> SelectTuBiaoKeShiCount() {
		// TODO Auto-generated method stub
		return echarsdao.SelectTuBiaoKeShiCount();
	}
	@Override
	public List<Map<Object, Object>> SelectTuBiaoBenYueCount() {
		// TODO Auto-generated method stub
		return echarsdao.SelectTuBiaoBenYueCount();
	}
	@Override
	public List<Map<Object, Object>> SelectTuBiaoXueLiCount() {
		// TODO Auto-generated method stub
		return echarsdao.SelectTuBiaoXueLiCount();
	}
	@Override
	public List<List<String>> SelectTuBiaoDataYueLanShiCount() {
		// TODO Auto-generated method stub
		List<List<String>> selectTuBiaoDataYueLanShiCount = echarsJpaDao.SelectTuBiaoDataYueLanShiCount();
		String []arr= {"月份","一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
		List<String> array =new ArrayList<>(Arrays.asList(arr));
		selectTuBiaoDataYueLanShiCount.add(0,array);
		return selectTuBiaoDataYueLanShiCount;
	}
	@Override
	public List<List<String>> SelectTuBiaoZhouYueLanShiCount() {
		// TODO Auto-generated method stub
				List<List<String>> SelectTuBiaoZhouYueLanShiCount = echarsJpaDao.SelectTuBiaoZhouYueLanShiCount();
				String []arr= {"月份","周一","周二","周三","周四","周五","周六","周日"};
				List<String> array =new ArrayList<>(Arrays.asList(arr));
				SelectTuBiaoZhouYueLanShiCount.add(0,array);
				return SelectTuBiaoZhouYueLanShiCount;
	}
	@Override
	public List<Map<Object, Object>>  SelectTuBiaoMeiiGeXiCount() {
		// TODO Auto-generated method stub
		return echarsJpaDao.SelectTuBiaoMeiiGeXiCount();
	}
	@Override
	public List<Map<Object, Object>> SelectTuBiaoMeiiGeZhuanYeCount() {
		// TODO Auto-generated method stub
		return echarsJpaDao.SelectTuBiaoMeiiGeZhuanYeCount();
	}
}
