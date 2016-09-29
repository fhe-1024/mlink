package com.mdc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.mdc.service.ICityService;
import com.mdc.service.ICountryService;
import com.mdc.service.IInternationalService;
import com.mdc.service.INodeService;
import com.mdc.util.PageUtil;
import com.mdc.view.MlinkCity;
import com.mdc.view.MlinkCountry;
import com.mdc.view.MlinkInternational;
import com.mdc.view.MlinkNode;
import com.mdc.view.TreeData;

@Controller
@RequestMapping("/tree")
public class TreeController {

	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private IInternationalService internationalService;
	@Autowired
	private ICountryService countryService;
	@Autowired
	private ICityService cityService;
	@Autowired
	private INodeService nodeService;

	@RequestMapping(path = "getTreeMenu", method = RequestMethod.GET)
	public void getTreeMenu(HttpServletResponse response) {
		TreeData node = new TreeData();
		node.setId("0");
		node.setText("mlink");
		node.setLevel("mlink");
		List<TreeData> nodeChildren = new ArrayList<TreeData>();
		try {
			List<Map<String, Object>> internationalList = internationalService
					.getAllMapList(new HashMap<String, Object>());
			if (internationalList != null && internationalList.size() > 0) {
				Iterator<Map<String, Object>> internationalit = internationalList.iterator();
				while (internationalit.hasNext()) {
					Map<String, Object> internationalMap = internationalit.next();
					TreeData first = new TreeData();
					first.setId((String) internationalMap.get("id"));
					first.setText((String) internationalMap.get("name"));
					first.setLevel("international");
					nodeChildren.add(first);
					Map<String, Object> searchCountryMap = new HashMap<String, Object>();
					searchCountryMap.put("internationalid", internationalMap.get("id"));
					List<Map<String, Object>> countryList = countryService.getAllMapList(searchCountryMap);
					List<TreeData> firstChildren = new ArrayList<TreeData>();
					if (countryList != null && countryList.size() > 0) {
						Iterator<Map<String, Object>> countryit = countryList.iterator();
						while (countryit.hasNext()) {
							Map<String, Object> countryMap = countryit.next();
							TreeData second = new TreeData();
							second.setId((String) countryMap.get("id"));
							second.setText((String) countryMap.get("name"));
							second.setLevel("country");
							firstChildren.add(second);
							Map<String, Object> searchCityMap = new HashMap<String, Object>();
							searchCityMap.put("countryid", second.getId());
							List<Map<String, Object>> cityList = cityService.getAllMapList(searchCityMap);
							List<TreeData> secondChildren = new ArrayList<TreeData>();
							if (cityList != null && cityList.size() > 0) {
								Iterator<Map<String, Object>> cityit = cityList.iterator();
								while (cityit.hasNext()) {
									Map<String, Object> cityMap = cityit.next();
									TreeData three = new TreeData();
									three.setId((String) cityMap.get("id"));
									three.setText((String) cityMap.get("name"));
									three.setLevel("city");
									secondChildren.add(three);
									Map<String, Object> searchNodeMap = new HashMap<String, Object>();
									searchNodeMap.put("cityid", cityMap.get("id"));
									List<Map<String, Object>> nodeList = nodeService.getAllMapList(searchNodeMap);
									List<TreeData> threeChildren = new ArrayList<TreeData>();
									if (nodeList != null && nodeList.size() > 0) {
										Iterator<Map<String, Object>> nodeit = nodeList.iterator();
										while (nodeit.hasNext()) {
											Map<String, Object> nodeMap = nodeit.next();
											TreeData four = new TreeData();
											four.setId((String) nodeMap.get("id"));
											four.setText((String) nodeMap.get("name"));
											four.setLevel("node");
											threeChildren.add(four);
										}
									}
									three.setChildren(threeChildren);
								}
							}
							second.setChildren(secondChildren);
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
			log.error(e);
		}
	}

	@RequestMapping(path = "getNodeList")
	public void getNodeList(HttpServletResponse response, HttpServletRequest request) {
		log.info("/area/getNodeList invoked");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		String level = request.getParameter("level");
		String id = request.getParameter("id");
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> argsMap = new HashMap<String, Object>();
			if ("mlink".equals(level) || StringUtils.isBlank(level)) {
				list = internationalService.getAllMapList(new HashMap<String, Object>());
			} else if ("international".equals(level)) {
				argsMap.put("internationalid", id);
				list = countryService.getAllMapList(argsMap);
			} else if ("country".equals(level)) {
				argsMap.put("countryid", id);
				list = cityService.getAllMapList(argsMap);
			} else if ("city".equals(level)) {
				argsMap.put("cityid", id);
				list = nodeService.getAllMapList(argsMap);
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", 100);
			map.put("rows", list);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(new Gson().toJson(map));
		} catch (Exception e) {
			log.error(e);
		}
	}

	@RequestMapping(path = "saveLevel")
	public void saveLevel(HttpServletResponse response, HttpServletRequest request) {
		log.info("/area/saveLevel invoked");
		String nodeid = request.getParameter("levelid");
		String nodelevel = request.getParameter("levelname");
		String name = request.getParameter("level_name");
		String sort = request.getParameter("sort");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			int effectrow = 0;
			String id = UUID.randomUUID().toString();
			String level = "";
			if ("mlink".equals(nodelevel) || StringUtils.isBlank(nodelevel)) {
				MlinkInternational international = new MlinkInternational();
				international.setId(id);
				international.setName(name);
				international.setSort(Integer.parseInt(sort));
				effectrow = internationalService.save(international);
				level = "international";
			} else if ("international".equals(nodelevel)) {
				MlinkCountry country = new MlinkCountry();
				country.setId(id);
				country.setName(name);
				country.setSort(Integer.parseInt(sort));
				country.setInternationalid(nodeid);
				effectrow = countryService.save(country);
				level = "country";
			} else if ("country".equals(nodelevel)) {
				MlinkCity city = new MlinkCity();
				city.setId(id);
				city.setName(name);
				city.setSort(Integer.parseInt(sort));
				city.setCountryid(nodeid);
				effectrow = cityService.save(city);
				level = "city";
			} else if ("city".equals(nodelevel)) {
				MlinkNode node = new MlinkNode();
				node.setId(id);
				node.setName(name);
				node.setSort(Integer.parseInt(sort));
				node.setCityid(nodeid);
				effectrow = nodeService.save(node);
				level = "node";
			} else if ("node".equals(nodelevel)) {
			}

			if (effectrow > 0) {
				resultMap.put("id", id);
				resultMap.put("level", level);
				resultMap.put("result", true);
			} else {
				resultMap.put("result", false);
			}

		} catch (Exception e) {
			resultMap.put("result", false);
			log.error(e);
		} finally {
			try {
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().write(new Gson().toJson(resultMap));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
		}
	}

	@RequestMapping(path = "saveNode")
	public void saveNode(HttpServletResponse response, HttpServletRequest request) {
		log.info("/area/saveNode invoked");
		String nodeid = request.getParameter("nodeid");
		String nodelevel = request.getParameter("nodelevel");
		String name = request.getParameter("node_name");
		String sort = request.getParameter("sort");
		String area = request.getParameter("area");
		String protocol = request.getParameter("protocol");
		String electricity = request.getParameter("electricity");
		String authentication = request.getParameter("authentication");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			int effectrow = 0;
			String id = UUID.randomUUID().toString();
			String level = "";
			if ("city".equals(nodelevel)) {
				MlinkNode node = new MlinkNode();
				node.setId(id);
				node.setName(name);
				node.setSort(Integer.parseInt(sort));
				node.setCityid(nodeid);
				node.setArea(area);
				node.setProtocol(protocol);
				node.setElectricity(electricity);
				node.setAuthentication(authentication);
				effectrow = nodeService.save(node);
				level = "node";
			}
			if (effectrow > 0) {
				resultMap.put("id", id);
				resultMap.put("level", level);
				resultMap.put("result", true);
			} else {
				resultMap.put("result", false);
			}
		} catch (Exception e) {
			resultMap.put("result", false);
			log.error(e);
		} finally {
			try {
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().write(new Gson().toJson(resultMap));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
		}
	}

}
