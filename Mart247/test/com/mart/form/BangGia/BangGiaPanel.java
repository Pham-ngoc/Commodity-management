package com.mart.form.BangGia;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BangGiaPanel extends JPanel {
	private JTextField txtTenhang;
	private JTable tbBanggia;

	/**
	 * Create the panel.
	 */
	public BangGiaPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BẢNG GIÁ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(382, 0, 137, 44);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 51, 71, 35);
		add(lblNewLabel_1);
		
		txtTenhang = new JTextField();
		txtTenhang.setColumns(10);
		txtTenhang.setBounds(91, 51, 742, 35);
		add(txtTenhang);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 963, 440);
		add(scrollPane);
		
		tbBanggia = new JTable();
		tbBanggia.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Mã hàng hóa", "Tên hàng hóa", "Giá vốn", "Giá bán"
			}
		));
		scrollPane.setViewportView(tbBanggia);
		
		JButton btnFirst = new JButton("");
		btnFirst.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\fast-backward.png"));
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFirst.setBounds(751, 546, 48, 35);
		add(btnFirst);
		
		JButton btnPrev = new JButton("");
		btnPrev.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\back-button.png"));
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrev.setBounds(809, 546, 48, 35);
		add(btnPrev);
		
		JButton btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\next-button.png"));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(867, 546, 48, 35);
		add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\last-backward.png"));
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLast.setBounds(925, 546, 48, 35);
		add(btnLast);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaBGFrame banggia = new ChinhsuaBGFrame();
				banggia.setVisible(true);
			}
		});
		btnThem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\plus.png"));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(10, 546, 130, 35);
		add(btnThem);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(843, 51, 130, 35);
		add(btnTim);

	}

}
