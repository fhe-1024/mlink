package com.mdc.view;

public class MlinkInternational {
	private String id;
	private String name;
	private int sort;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "MlinkInternational [id=" + id + ", name=" + name + ", sort=" + sort + "]";
	}
	
}
