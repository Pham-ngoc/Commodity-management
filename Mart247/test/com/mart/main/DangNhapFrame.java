package com.mart.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.NhanVienDAO;
import com.mart.entity.NhanVien;
import com.mart.utils.Auth;
import com.mart.utils.MsgBox;
import com.mart.utils.XImage;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DangNhapFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JPasswordField pwMatKhau;
	private NhanVienDAO nvdao = new NhanVienDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapFrame frame = new DangNhapFrame();
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
	public DangNhapFrame() {
		setBackground(new Color(255, 255, 255));
		setUndecorated(true);
//		setTitle("ĐĂNG NHẬP");
		setIconImage(XImage.getAppIcon());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl247Mart = new JLabel("247Mart");
		lbl247Mart.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbl247Mart.setBounds(311, 86, 132, 44);
		contentPane.add(lbl247Mart);
		
		JButton btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setBackground(new Color(240, 240, 240));
		btnDangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDangNhap.setBackground(new Color(73,84,189));
				btnDangNhap.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDangNhap.setBackground(new Color(255,255,255));
				btnDangNhap.setForeground(new Color(0,0,0));
			}
		});
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnDangNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		btnDangNhap.setIcon(new ImageIcon("E:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\login.png"));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDangNhap.setBounds(184, 269, 167, 44);
		contentPane.add(btnDangNhap);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("E:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\logo.png"));
		lblLogo.setBounds(169, 54, 132, 103);
		contentPane.add(lblLogo);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMaNV.setBounds(70, 177, 111, 34);
		contentPane.add(lblMaNV);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu: ");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMatKhau.setBounds(70, 221, 111, 34);
		contentPane.add(lblMatKhau);
		
		txtMaNV = new JTextField();
		txtMaNV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtMaNV.setBounds(184, 178, 320, 34);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JButton btnThoat = new JButton("THOÁT");
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnThoat.setBackground(new Color(73,84,189));
				btnThoat.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnThoat.setBackground(new Color(255,255,255));
				btnThoat.setForeground(new Color(0,0,0));
			}
		});
		btnThoat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.exit(0);
				}
			}
		});
		btnThoat.setBackground(new Color(255, 255, 255));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setIcon(new ImageIcon("E:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\exit.png"));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThoat.setBounds(361, 269, 143, 44);
		contentPane.add(btnThoat);
		
		pwMatKhau = new JPasswordField();
		pwMatKhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		pwMatKhau.setBounds(184, 225, 320, 34);
		contentPane.add(pwMatKhau);
		setLocationRelativeTo(null);
	}
	 	
	public void login() {
		String manv = txtMaNV.getText();
		String password = new  String(pwMatKhau.getPassword());
		NhanVien nv = this.nvdao.selectById(manv);
		if(checkNull()) {
			if(nv == null) {
				MsgBox.alert(this, "Mã nhân viên không tồn tại");
				txtMaNV.setText("");
				txtMaNV.requestFocus(); 
			} else if (!manv.equals(nv.getMaNV())) {
				MsgBox.alert(this, "Sai mã nhân viên");
				txtMaNV.setText("");
				txtMaNV.requestFocus(); 
			}else if (!password.equals(nv.getMatkhau())) {
				MsgBox.alert(this, "Sai mật khẩu");
				pwMatKhau.setText("");
				pwMatKhau.requestFocus(); 
			} else {
				MsgBox.alert(this, "Đăng nhập thành công");
				Auth.user = nv;
				Main load = new Main();
				load.setVisible(true);
				DangNhapFrame.this.setVisible(false);
			}
		}
	}
	
	public boolean checkNull() {
		if(txtMaNV.getText().equals("")) {
			MsgBox.alert(this, "Nhập mã nhân viên của bạn!");
			txtMaNV.requestFocus();
			return false;
		} else if (String.valueOf(pwMatKhau.getPassword()).equals("")) {
			MsgBox.alert(this, "Nhập mật khẩu của bạn!");
			pwMatKhau.requestFocus();
			return false;
		}
		return true;
	}
}
