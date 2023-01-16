package com.mart.main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\img\\logo-java1.png"));
		lblNewLabel.setBounds(353, 145, 294, 243);
		add(lblNewLabel);
		
		

	}
}
