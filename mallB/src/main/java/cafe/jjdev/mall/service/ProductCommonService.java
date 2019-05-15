package cafe.jjdev.mall.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.mall.mapper.ProductCommonMapper;
import cafe.jjdev.mall.vo.ProductCommon;

@Service
@Transactional
public class ProductCommonService {
	@Autowired
	private ProductCommonMapper productCommonMapper;
	
	public Map<String, Object> getProductCommonList(int categoryNo, int currentPage, String searchWord){
		
		final int ROW_PER_PAGE = 10; 
		int startRow = (currentPage - 1)* ROW_PER_PAGE;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		map.put("categoryNo", categoryNo);
		map.put("searchWord", "%"+searchWord+"%");
				
		List<ProductCommon> list = productCommonMapper.selectProductCommonList(map);
		System.out.println(list+"BoardCommentService.java list");
				
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("categoryNo", categoryNo);
		parameterMap.put("searchWord", "%"+searchWord+"%");
		
		int countProductCommon = productCommonMapper.selectProductCommonCount(parameterMap);
		int lastPage = countProductCommon/ROW_PER_PAGE;
		if(countProductCommon%ROW_PER_PAGE != 0) {
			lastPage++;
		}
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		
		returnMap.put("lastPage", lastPage);
		returnMap.put("currentPage", currentPage);
		returnMap.put("countProductCommon", countProductCommon);
		return returnMap;
	}
	public ProductCommon getProductListByCategory(int productCommonNo) {
		System.out.println("getProductListByCategory ProductCommonService productCommonNo"+ productCommonNo);
		System.out.println("getProductListByCategory ProductCommonService productCommonNo"+ productCommonMapper.selectProductListByCategory(productCommonNo));
		return productCommonMapper.selectProductListByCategory(productCommonNo);
	}

}
