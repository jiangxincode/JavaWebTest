package hibernate3;

import java.util.Set;

public class Category {
	private Long id;

	private String name;

	private Category parentCategory;

	@SuppressWarnings("rawtypes")
	private Set childCategories;

	@SuppressWarnings("rawtypes")
	public Category(String name, Category parentCategory, Set childCategories) {
		this.name = name;
		this.parentCategory = parentCategory;
		this.childCategories = childCategories;
	}

	public Category() {

	}

	@SuppressWarnings("rawtypes")
	public Category(Set childCategories) {
		this.childCategories = childCategories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	@SuppressWarnings("rawtypes")
	public Set getChildCategories() {
		return childCategories;
	}

	@SuppressWarnings("rawtypes")
	public void setChildCategories(Set childCategories) {
		this.childCategories = childCategories;
	}
}
