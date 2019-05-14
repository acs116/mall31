package cafe.jjdev.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.Category;

@Mapper
public interface CategoryMapper {
	public List<Category> selectCategoryList();
}
