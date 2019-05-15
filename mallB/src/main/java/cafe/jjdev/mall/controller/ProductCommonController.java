package cafe.jjdev.mall.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.mall.service.ProductCommonService;
import cafe.jjdev.mall.vo.ProductCommon;

@Controller
public class ProductCommonController {
	@Autowired
	private ProductCommonService productCommonService;
	
	@GetMapping(value="/product/selectProductCommonList")
	public String getProductCommonList(Model model, 
			@RequestParam(value="categoryNo", required = true) int categoryNo
			,@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage
			,@RequestParam(value="searchWord", defaultValue = "")String searchWord) {
		System.out.println(searchWord+"ProductCommonController.java searchWord");
		Map<String, Object> map = productCommonService.getProductCommonList(categoryNo, currentPage, searchWord);
	model.addAttribute("list", map.get("list"));
	model.addAttribute("currentPage", currentPage);
	model.addAttribute("categoryNo", categoryNo);
	model.addAttribute("searchWord", searchWord);
	System.out.println("ProductCommonController.java searchWord : " + searchWord);
	model.addAttribute("lastPage", map.get("lastPage"));
	model.addAttribute("countProductCommon", map.get("countProductCommon"));
	
	System.out.println("model"+ model);
		
		return "/product/selectProductCommonList";
	}
	@GetMapping(value="/product/getProductListByCategory")
	public String getProductListByCategory(Model model, int productCommonNo) {
		System.out.println("productCommonNo" + productCommonNo);
		ProductCommon productCommon = productCommonService.getProductListByCategory(productCommonNo);
			
		model.addAttribute("productCommon", productCommon);
		System.out.println("productCommon getProductListByCategory" + productCommon);
		return "/product/getProductListByCategory";
	}
	
}
