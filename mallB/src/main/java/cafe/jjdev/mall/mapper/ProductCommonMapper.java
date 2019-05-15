package cafe.jjdev.mall.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.ProductCommon;

@Mapper
public interface ProductCommonMapper {
	// 1
	public List<ProductCommon> selectProductCommonList(Map<String, Object> map);
	public int selectProductCommonCount(Map<String, Object> parameterMap);
	// 2
	public ProductCommon selectProductListByCategory(int productCommonNo);
}
