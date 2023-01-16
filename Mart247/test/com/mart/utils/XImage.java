package com.mart.utils;

import java.awt.Image;

import javax.swing.ImageIcon;

public class XImage {
	 public static Image getAppIcon() {
		    String file = "/com/mart/icon/logo.png";
		    return (new ImageIcon(XImage.class.getResource(file))).getImage();
		  }
}
