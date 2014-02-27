package com.bookstore.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.log4j.Logger;

public class SqlDateAdapter extends XmlAdapter<String, Date> {

	private static Logger log = Logger.getLogger(SqlDateAdapter.class);

	public String marshal(java.sql.Date d) {
		return d.toString();
	}

	public Date unmarshal(String v) {
		java.sql.Date sqlDate = getSqlDatefromString(v);
		return sqlDate;
	}

	public static java.sql.Date getSqlDatefromString(String date) {
		// String date format yyyyMMdd
		java.sql.Date sqlDate = null;
		try {
			if (date != null && date != "") {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				java.util.Date parsed = format.parse(date);
				sqlDate = new java.sql.Date(parsed.getTime());
			}
		} catch (ParseException e) {
			log.error("String to Date parsing error :" + e.getMessage());
		}
		return sqlDate;
	}

}
