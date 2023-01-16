package com.mart.form.NhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.NhanVienDAO;
import com.mart.entity.KhachHang;
import com.mart.entity.NhanVien;
import com.mart.form.KhachHang.KhachHangPanel;
import com.mart.utils.MsgBox;

import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ChinhsuaNVFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaNV;
	private static JTextField txtHoten;
	private static JTextField txtEmail;
	private static JPasswordField txtMatkhau;
	private JLabel lblLoiMaNV;
	private JLabel lblLoiHoten;
	private JLabel lblLoIEmail;
	private JLabel lblLoiMatkhau;
	private JLabel lblLoiVaiTro;
	private static JRadioButton rdNhanvien;
	private static JRadioButton rdTruongcuahang;
	private ButtonGroup ButtonGroup1;
	
	NhanVienDAO nvdao = new NhanVienDAO();

	String rexgeEmail = "^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}$";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuaNVFrame frame = new ChinhsuaNVFrame();
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
	
	public ChinhsuaNVFrame() {
		initComponents();
	}
	public void initComponents() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NHÂN VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(247, 0, 145, 46);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 67, 97, 32);
		contentPane.add(lblNewLabel_1);
		
		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(117, 70, 495, 32);
		contentPane.add(txtMaNV);
		
		txtHoten = new JTextField();
		txtHoten.setColumns(10);
		txtHoten.setBounds(117, 131, 495, 32);
		contentPane.add(txtHoten);
		
		JLabel lblNewLabel_2 = new JLabel("Họ và tên: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 128, 97, 32);
		contentPane.add(lblNewLabel_2);
		
		lblLoiMaNV = new JLabel("");
		lblLoiMaNV.setForeground(Color.RED);
		lblLoiMaNV.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiMaNV.setBounds(117, 105, 308, 19);
		contentPane.add(lblLoiMaNV);
		
		lblLoiHoten = new JLabel("");
		lblLoiHoten.setForeground(Color.RED);
		lblLoiHoten.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiHoten.setBounds(117, 167, 308, 19);
		contentPane.add(lblLoiHoten);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(10, 194, 97, 32);
		contentPane.add(lblNewLabel_2_1);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(117, 194, 495, 32);
		contentPane.add(txtEmail);
		
		lblLoIEmail = new JLabel("");
		lblLoIEmail.setForeground(Color.RED);
		lblLoIEmail.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoIEmail.setBounds(117, 230, 419, 19);
		contentPane.add(lblLoIEmail);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(10, 259, 97, 32);
		contentPane.add(lblNewLabel_2_1_1);
		
		lblLoiMatkhau = new JLabel("");
		lblLoiMatkhau.setForeground(Color.RED);
		lblLoiMatkhau.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiMatkhau.setBounds(117, 295, 308, 19);
		contentPane.add(lblLoiMatkhau);
		
		rdTruongcuahang = new JRadioButton("Trưởng cửa hàng");
		rdTruongcuahang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdTruongcuahang.setBounds(117, 325, 145, 32);
		contentPane.add(rdTruongcuahang);
		
		rdNhanvien = new JRadioButton("Nhân viên");
		rdNhanvien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdNhanvien.setBounds(280, 325, 145, 32);
		contentPane.add(rdNhanvien);
		
		ButtonGroup1 = new ButtonGroup();
		ButtonGroup1.add(rdNhanvien);
		ButtonGroup1.add(rdTruongcuahang);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Vai trò");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(10, 325, 97, 32);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		lblLoiVaiTro = new JLabel("");
		lblLoiVaiTro.setForeground(Color.RED);
		lblLoiVaiTro.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiVaiTro.setBounds(117, 358, 308, 19);
		contentPane.add(lblLoiVaiTro);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(117, 397, 114, 35);
		contentPane.add(btnThem);
		
		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(247, 397, 114, 35);
		contentPane.add(btnCapnhat);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(371, 397, 114, 35);
		contentPane.add(btnXoa);
		
		txtMatkhau = new JPasswordField();
		txtMatkhau.setBounds(117, 262, 495, 32);
		contentPane.add(txtMatkhau);
		
		setLocationRelativeTo(null);
	}
	
	NhanVien getForm() {
    	NhanVien nv = new NhanVien();
    	nv.setMaNV(txtMaNV.getText());
    	nv.setHoten(txtHoten.getText());
    	nv.setEmail(txtEmail.getText());
    	nv.setMatkhau(txtMatkhau.getText());
    	nv.setVaitro(rdTruongcuahang.isSelected());
    	return nv;
    }
	
    public static void setForm(NhanVien nv) {
    	try {
			txtMaNV.setText(nv.getMaNV());
			txtHoten.setText(nv.getHoten());
			txtEmail.setText(nv.getEmail());
			txtMatkhau.setText(nv.getMatkhau());
			if(nv.isVaitro()) {
				rdTruongcuahang.setSelected(true);
			} else {
				rdNhanvien.setSelected(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void clearForm() {
        NhanVien nv = new NhanVien();
        setFormClean(nv);
        lblLoiMaNV.setText("");
        lblLoiHoten.setText("");
        lblLoIEmail.setText("");
        lblLoiMatkhau.setText("");
        lblLoiVaiTro.setText("");
      }
    
    public void setFormClean(NhanVien nv) {
  	  	txtMaNV.setText("");
  	    txtHoten.setText(""); 
  	    txtEmail.setText("");
  	    txtMatkhau.setText("");
  	  if (nv.isVaitro()) {
  	      rdTruongcuahang.setSelected(false);
  	    } else {
  	      rdNhanvien.setSelected(false);
  	    }
    }
    
    void insert() {
    	if(checkNull() ==true && checkValidate() == true) {
	  	    NhanVien nv = getForm();
	  	    try {
	  	      this.nvdao.insert(nv);
	  	      NhanVienPanel.fillTable();
	  	      clearForm();
	  	      MsgBox.alert(this, "Thêm mới thành công!");
	  	    this.setVisible(false);
	  	    } catch (Exception e) {
	  	      MsgBox.alert(this, "Thêm mới thất bại!");
	  	    this.setVisible(false);
	  	      e.printStackTrace();
	  	    } 
    	}
    }
    
    void update() {
    	if(checkNull()) {
	        NhanVien model = getForm();
	        try {
	          this.nvdao.update(model);
	          NhanVienPanel.fillTable();
	          clearForm();
	          MsgBox.alert(this, "Cập nhật thành công!");
	          this.setVisible(false);
	        } catch (Exception e) {
	        	this.setVisible(false);
	          e.printStackTrace();
	        } 
    	}
      }
      
      void delete() {
    	  if(checkNull()) {
	        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa nhân viên này?")) {
	          String manh = txtMaNV.getText();
	          try {
	            this.nvdao.delete(manh);
	            NhanVienPanel.fillTable();
	            clearForm();
	            MsgBox.alert(this, "Xóa thành công!");
	            this.setVisible(false);
	          } catch (Exception e) {
	            MsgBox.alert(this, "Xóa thất bại!");
	            this.setVisible(false);
	            e.printStackTrace();
	          } 
	        } 
    	  }
      }
          
      public boolean checkNull() {
    	  if (txtMaNV.getText().equals("")) {
    		  lblLoiMaNV.setText("Không để trống thông tin");
    		  lblLoiMaNV.setForeground(Color.red);
    		  lblLoiMaNV.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtMaNV.requestFocus();
    		  return false;
    	  } else if (txtHoten.getText().equals("")) {
    		  lblLoiHoten.setText("Không để trống thông tin");
    		  lblLoiHoten.setForeground(Color.red);
    		  lblLoiHoten.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtHoten.requestFocus();
    		  return false;
    	  } else if (txtEmail.getText().equals("")) {
    		  lblLoIEmail.setText("Không để trống thông tin");
    		  lblLoIEmail.setForeground(Color.red);
    		  lblLoIEmail.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtEmail.requestFocus();
    		  return false; 
    	  } else if(String.valueOf(txtMatkhau.getPassword()).equals("")){
      		lblLoiMatkhau.setText("Không để trống thông tin");
      		lblLoiMatkhau.setForeground(Color.red);
      		lblLoiMatkhau.setFont(new Font("Tahoma", Font.ITALIC, 15));
      		txtMatkhau.requestFocus();
      		return false;
      		} else if (rdTruongcuahang.isSelected() == false && rdNhanvien.isSelected() == false) {
      			lblLoiVaiTro.setForeground(Color.red);
		  		lblLoiVaiTro.setText("Không để trống thông tin");
		  		lblLoiVaiTro.setFont(new Font("Tahoma", Font.ITALIC, 15));  		  
		  		  return false;
      		}
    	  return true;
      }
      public boolean checkValidate() {
    	  if(!txtEmail.getText().matches(rexgeEmail)) {
    		  lblLoIEmail.setText("Email không đúng định dạng (VD:abc@gmail.com)");
    		  lblLoIEmail.setForeground(Color.red);
    		  lblLoIEmail.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtEmail.requestFocus();
    		  return false; 
    	  }
    	  if (!String.valueOf(txtMatkhau.getPassword()).equals(txtMaNV.getText())) {
    		  lblLoiMatkhau.setText("Mật khẩu phải giống mã nhân viên");
        	  lblLoiMatkhau.setForeground(Color.red);
        	  lblLoiMatkhau.setFont(new Font("Tahoma", Font.ITALIC, 15));
        	  txtMatkhau.requestFocus();
        		return false;
  		  }
    	  
    	return true;
      }
}
