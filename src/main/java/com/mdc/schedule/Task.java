package com.mdc.schedule;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.mdc.service.IExchangeService;
import com.mdc.util.ExchangeUtil;
import com.mdc.view.MlinkExchange;

@Component
public class Task {

	@Autowired
	private IExchangeService exchangeService;

	@Scheduled(cron = "0 0 0/1 * * ?")
	public void exchange() {
		try {
			String info = ExchangeUtil.get(
					"http://apis.baidu.com/apistore/currencyservice/currency?fromCurrency=USD&toCurrency=CNY&amount=1");
			Code code = new Gson().fromJson(info, Code.class);
			if (code != null) {
				MlinkExchange exchange = new MlinkExchange();
				exchange.setId(UUID.randomUUID().toString());
				exchange.setFromcurrency(code.getRetData().getFromCurrency());
				exchange.setTocurrency(code.getRetData().getToCurrency());
				exchange.setExchange(code.getRetData().getCurrency());
				exchange.setCreatetime(new Timestamp(System.currentTimeMillis()));
				exchangeService.save(exchange);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Code {
	private int errNum;
	private String errMsg;
	private Currency retData;

	public int getErrNum() {
		return errNum;
	}

	public void setErrNum(int errNum) {
		this.errNum = errNum;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Currency getRetData() {
		return retData;
	}

	public void setRetData(Currency retData) {
		this.retData = retData;
	}

	@Override
	public String toString() {
		return "Code [errNum=" + errNum + ", errMsg=" + errMsg + ", retData=" + retData + "]";
	}

}

class Currency {
	private String date;
	private String time;
	private String fromCurrency;
	private int amount;
	private String toCurrency;
	private double currency;
	private double convertedamount;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public double getCurrency() {
		return currency;
	}

	public void setCurrency(double currency) {
		this.currency = currency;
	}

	public double getConvertedamount() {
		return convertedamount;
	}

	public void setConvertedamount(double convertedamount) {
		this.convertedamount = convertedamount;
	}

	@Override
	public String toString() {
		return "Currency [date=" + date + ", time=" + time + ", fromCurrency=" + fromCurrency + ", amount=" + amount
				+ ", toCurrency=" + toCurrency + ", currency=" + currency + ", convertedamount=" + convertedamount
				+ "]";
	}

}