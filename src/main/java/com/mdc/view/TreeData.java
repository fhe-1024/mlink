package com.mdc.view;

import java.util.List;

public class TreeData {
	private String id;
	private String text;
	private List<TreeData> children;
	private String level;
	private int sort;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<TreeData> getChildren() {
		return children;
	}

	public void setChildren(List<TreeData> children) {
		this.children = children;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
