package com.mdc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.mdc.service.ICityService;
import com.mdc.service.ICountryService;
import com.mdc.view.TreeData;

@Controller
@RequestMapping("/tree")
public class TreeController {

	@Autowired
	private ICountryService countryService;
	@Autowired
	private ICityService cityService;

	@RequestMapping(path = "getTreeMenu", method = RequestMethod.GET)
	public void getTreeMenu(HttpServletResponse response) {
		TreeData node = new TreeData();
		node.setId("0");
		node.setText("mlink");
		node.setLevel("mlink");
		List<TreeData> nodeChildren = new ArrayList<TreeData>();
		try {
			List<Map<String, Object>> countryList = countryService.getAllMapList(new HashMap<String, Object>());
			if (countryList != null && countryList.size() > 0) {
				Iterator<Map<String, Object>> countit = countryList.iterator();
				while (countit.hasNext()) {
					Map<String, Object> countryMap = countit.next();
					TreeData first = new TreeData();
					first.setId((String) countryMap.get("id"));
					first.setText((String) countryMap.get("name"));
					first.setLevel("country");
					nodeChildren.add(first);
					Map<String, Object> searchMap = new HashMap<String, Object>();
					searchMap.put("countryid", countryMap.get("id"));
					List<Map<String, Object>> cityList = cityService.getAllMapList(searchMap);
					List<TreeData> firstChildren = new ArrayList<TreeData>();
					if (cityList != null && cityList.size() > 0) {
						Iterator<Map<String, Object>> cityit = cityList.iterator();
						while (cityit.hasNext()) {
							Map<String, Object> cityMap = cityit.next();
							TreeData second = new TreeData();
							second.setId((String) cityMap.get("id"));
							second.setText((String) cityMap.get("name"));
							second.setLevel("city");
							firstChildren.add(second);
						}
					}
					first.setChildren(firstChildren);
				}
			}
			node.setChildren(nodeChildren);
			response.setContentType("application/json;charset=utf-8");
			List<Object> resultList = new ArrayList<Object>();
			resultList.add(node);
			response.getWriter().write(new Gson().toJson(resultList));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
