package com.mart.utils;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MsgBox {
	public static void alert(Component parent, String message) {
	    JOptionPane.showMessageDialog(parent, message, "247Mart", JOptionPane.INFORMATION_MESSAGE);
	  }
	  
	  public static boolean confirm(Component parent, String message) {
	    int result = JOptionPane.showConfirmDialog(parent, message, "247Mart", 0, 3);
	    return (result == 0);
	  }
	  
	  public static String prompt(Component parent, String message) {
	    return JOptionPane.showInputDialog(parent, message, "247Mart", JOptionPane.INFORMATION_MESSAGE);
	  }
}
