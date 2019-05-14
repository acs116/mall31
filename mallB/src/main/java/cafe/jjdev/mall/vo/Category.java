package cafe.jjdev.mall.vo;

public class Category {
	private int categoryNo;
	private String categoryName;
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	
}
