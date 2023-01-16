package com.mart.utils;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Check {
	public static boolean manage() {
		if(!Auth.isManager()) {
			MsgBox.alert(null, "Không có quyền truy cập!");
			return false;
		}
		return true;
	}
	
	public static boolean checkEmail(String str) {
		  final String validate_email = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
		  Pattern pattern;
		  Matcher matcher;
		  pattern = Pattern.compile(validate_email);
		  matcher = pattern.matcher(str);
		  return matcher.matches();
	  }
	
	public static boolean checkNull(JTextField txtext, JLabel label) {
		if(txtext.getText().equals("")) {
			label.setForeground(Color.red);
			label.setText("Không để trống thông tin");
			label.setFont(new Font("Tahoma", Font.ITALIC, 15));
			txtext.requestFocus();
			return false;
		}
		return true;
	}
	
	public static String getDate(String str) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			Date NexTtomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24 * 2));
		  	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  	String NgaySinh = formatter.format(NexTtomorrow);
		  	return NgaySinh;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
