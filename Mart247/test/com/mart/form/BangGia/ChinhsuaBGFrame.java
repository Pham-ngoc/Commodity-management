package com.mart.form.BangGia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class ChinhsuaBGFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHH;
	private JTextField txtGiavon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuaBGFrame frame = new ChinhsuaBGFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChinhsuaBGFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 682, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BẢNG GIÁ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(251, 0, 139, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hàng hóa: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 72, 99, 32);
		contentPane.add(lblNewLabel_1);
		
		txtMaHH = new JTextField();
		txtMaHH.setBounds(119, 72, 522, 32);
		contentPane.add(txtMaHH);
		txtMaHH.setColumns(10);
		
		JLabel lblLoiMaHH = new JLabel("");
		lblLoiMaHH.setForeground(Color.RED);
		lblLoiMaHH.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiMaHH.setBounds(119, 111, 308, 19);
		contentPane.add(lblLoiMaHH);
		
		JLabel lblLoiGiavon = new JLabel("");
		lblLoiGiavon.setForeground(Color.RED);
		lblLoiGiavon.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiGiavon.setBounds(119, 176, 308, 19);
		contentPane.add(lblLoiGiavon);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giá vốn: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 137, 99, 32);
		contentPane.add(lblNewLabel_1_1);
		
		txtGiavon = new JTextField();
		txtGiavon.setColumns(10);
		txtGiavon.setBounds(119, 137, 522, 32);
		contentPane.add(txtGiavon);
		
		JButton btnThem = new JButton("Thêm ");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(119, 220, 114, 35);
		contentPane.add(btnThem);
		
		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(243, 220, 114, 35);
		contentPane.add(btnCapnhat);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(367, 220, 114, 35);
		contentPane.add(btnXoa);
		
		JButton btnLammoi = new JButton("Làm mới");
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLammoi.setBounds(491, 220, 114, 35);
		contentPane.add(btnLammoi);
		
		setLocationRelativeTo(null);
	}

}
