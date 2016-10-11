package com.mdc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.mdc.service.ICountryService;
import com.mdc.service.IFacilityService;
import com.mdc.view.MlinkCountry;
import com.mdc.view.MlinkFacility;

@Controller
@RequestMapping("/abroad")
public class AbroadController {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private ICountryService countryService;
	@Autowired
	private IFacilityService facilityService;

	@RequestMapping(path = "/index/{countryid}")
	public String index(@PathVariable String countryid, HttpServletRequest request) {
		try {
			MlinkCountry country = countryService.getCountryById(countryid);
			if (country != null) {
				request.setAttribute("countryname", country.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		request.setAttribute("countryid", countryid);
		return "abroad";
	}

	@RequestMapping(path = "/getFacilityList")
	public void getFacilityList(HttpServletRequest request, HttpServletResponse response) {
		String countryid = request.getParameter("countryid");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> argsMap = new HashMap<String, Object>();
		argsMap.put("countryid", countryid);
		List<FacilityData> resultList = new ArrayList<FacilityData>();
		try {
			list = facilityService.getAllMapList(argsMap);
			if (list != null) {
				Iterator<Map<String, Object>> it = list.iterator();
				while (it.hasNext()) {
					Map<String, Object> map = it.next();
					List<MlinkFacility> datalist = new ArrayList<MlinkFacility>();
					FacilityData data = new FacilityData();
					if ("0".equals((String) map.get("type"))) {
						data.setType("0");
						data.setSize("1");
						MlinkFacility facility = new MlinkFacility();
						facility.setName((String) map.get("name"));
						facility.setPower((String) map.get("power"));
						facility.setPrice((String) map.get("price"));
						facility.setStandard((String) map.get("standard"));
						datalist.add(facility);
					} else if ("1".equals((String) map.get("type"))) {
						data.setType("1");
						String name = map.get("name").toString();
						String[] standard = map.get("standard").toString().split(";");
						String[] power = map.get("power").toString().split(";");
						String[] price = map.get("price").toString().split(";");
						data.setSize(String.valueOf(standard.length));
						for (int i = 0; i < standard.length; i++) {
							MlinkFacility facility = new MlinkFacility();
							facility.setName(name);
							facility.setPower(power[i]);
							facility.setPrice(price[i]);
							facility.setStandard(standard[i]);
							datalist.add(facility);
						}
					} else if ("2".equals((String) map.get("type"))) {
						data.setType("2");
						// (机房-托管规格)-机柜功率-机柜价格
						String name = map.get("name").toString();
						String[] power = map.get("power").toString().split(";");
						String[] price = map.get("price").toString().split(";");
						data.setSize(String.valueOf(power.length));
						for (int i = 0; i < power.length; i++) {
							MlinkFacility facility = new MlinkFacility();
							facility.setName(name);
							facility.setPower(power[i]);
							facility.setPrice(price[i]);
							datalist.add(facility);
						}
					} else if ("3".equals((String) map.get("type"))) {
						data.setType("3");
						// (机房-托管规格)-(机柜功率-机柜价格)
						String name = map.get("name").toString();
						String power = map.get("power").toString();
						data.setSize("1");
						MlinkFacility facility = new MlinkFacility();
						facility.setName(name);
						facility.setPower(power);
						datalist.add(facility);
					}
					data.setData(datalist);
					resultList.add(data);
				}
			}
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("result", true);
			resultMap.put("data", resultList);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(new Gson().toJson(resultMap));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
	}

}

class FacilityData {
	private String type;
	private String size;
	private List<MlinkFacility> data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<MlinkFacility> getData() {
		return data;
	}

	public void setData(List<MlinkFacility> data) {
		this.data = data;
	}

}
