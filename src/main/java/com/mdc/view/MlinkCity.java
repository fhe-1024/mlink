package com.mdc.view;

public class MlinkCity {
	private String id;
	private String name;
	private int sort;
	private String countryid;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountryid() {
		return countryid;
	}

	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}

	@Override
	public String toString() {
		return "MlinkCity [id=" + id + ", name=" + name + ", sort=" + sort + ", countryid=" + countryid + "]";
	}

}
