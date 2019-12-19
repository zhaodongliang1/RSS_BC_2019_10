package com.ysd.RSS.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ysd.RSS.service.EcharsService;
@RestController
@CrossOrigin //跨域
public class EcharsController {
  @Autowired
  private EcharsService  echarsService;
  @PostMapping("/SelectTuBiaoXiCount")
  public List<Map<Object, Object>> SelectTuBiaoXiCount(){
	return echarsService.SelectTuBiaoXiCount();
  }
  @PostMapping("/SelectTuBiaoBanJiCount")
  public List<Map<Object, Object>> SelectTuBiaoBanJiCount(){
	return echarsService.SelectTuBiaoBanJiCount();
  }
  @PostMapping("/SelectTuBiaoKeShiCount")
  public List<Map<Object, Object>> SelectTuBiaoKeShiCount(){
	return echarsService.SelectTuBiaoKeShiCount();
  }
  @PostMapping("/SelectTuBiaoBenYueCount")
  public List<Map<Object, Object>> SelectTuBiaoBenYueCount(){
	return echarsService.SelectTuBiaoBenYueCount();
  }
  @PostMapping("/SelectTuBiaoXueLiCount")
  public List<Map<Object, Object>> SelectTuBiaoXueLiCount(){
	return echarsService.SelectTuBiaoXueLiCount();
  }
  @PostMapping("/SelectTuBiaoDataYueLanShiCount")
  public List<List<String>> SelectTuBiaoDataYueLanShiCount(){
	return echarsService.SelectTuBiaoDataYueLanShiCount();
  }
  @PostMapping("/SelectTuBiaoZhouYueLanShiCount")
  public List<List<String>> SelectTuBiaoZhouYueLanShiCount(){
	return echarsService.SelectTuBiaoZhouYueLanShiCount();
  }
  @PostMapping("/SelectTuBiaoMeiiGeXiCount")
  public Map<Object, Object> SelectTuBiaoMeiiGeXiCount(){
	  List<Map<Object, Object>> selectTuBiaoMeiiGeXiCount = echarsService.SelectTuBiaoMeiiGeXiCount();
	  List<Map<Object, Object>> selectTuBiaoMeiiGeZhuanYeCount = echarsService.SelectTuBiaoMeiiGeZhuanYeCount();
	  Map<Object, Object> map=new HashMap<Object, Object>();
	  map.put("selectTuBiaoMeiiGeXiCount",selectTuBiaoMeiiGeXiCount);
	  map.put("selectTuBiaoMeiiGeZhuanYeCount",selectTuBiaoMeiiGeZhuanYeCount);
	return map;
  }
}
