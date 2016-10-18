package com.mdc.view;

public class MlinkTip {
	private String id;
	private String tip;
	private String countryid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getCountryid() {
		return countryid;
	}

	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}

	@Override
	public String toString() {
		return "MlinkTip [id=" + id + ", tip=" + tip + ", countryid=" + countryid + "]";
	}

}
