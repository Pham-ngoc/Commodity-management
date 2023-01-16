package com.mart.form.KhachHang;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.KhachHangDAO;
import com.mart.entity.KhachHang;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;
import com.raven.datechooser.DateChooser;

public class ChinhsuaKH extends JFrame {

	 JPanel contentPane;
	 public static JTextField txtMaKH;
	 public static JTextField txtHoten;
	 public static JTextField txtNgaysinh;
	 public static JTextField txtSDT;
	 public static JRadioButton rdNam;
	 public static JRadioButton rdNu;
	 public static ButtonGroup ButtonGroup1;
	 private JLabel lblLoiMaKH;
	 private JLabel lblLoiHoTen;
	 private JLabel lblLoiGioitinh;
	 private JLabel lblLoiNgaysinh;
	 private JLabel lblLoiSDT;
	 private DateChooser brithdate = new DateChooser(); 
	 
	 //Regex
	 String regexSDT = "0\\d{8,10}?";
	 
	 //số lôi
	int row;
	KhachHangDAO khdao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuaKH frame = new ChinhsuaKH();
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
	public ChinhsuaKH() {
		initComponents();
	    khdao = new KhachHangDAO();
	    brithdate.setTextField(txtNgaysinh);
	    brithdate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//	    JTextFieldDateEditor editorNgaySinh = (JTextFieldDateEditor) txtNgaysinh.getDateEditor();
	}
	
	public void initComponents(){
//		setUndecorated(true);
		setTitle("KHÁCH HÀNG");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(255, 0, 170, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 80, 114, 28);
		contentPane.add(lblNewLabel_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(131, 76, 595, 32);
		contentPane.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Họ và tên: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 142, 114, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 204, 61, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày sinh:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 262, 114, 31);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Số điện thoại:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 339, 114, 28);
		contentPane.add(lblNewLabel_5);
		
		txtHoten = new JTextField();
		txtHoten.setBounds(131, 138, 595, 32);
		contentPane.add(txtHoten);
		txtHoten.setColumns(10);
		
		rdNam = new JRadioButton("Nam");
		rdNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdNam.setBounds(131, 204, 61, 28);
		contentPane.add(rdNam);
		
		rdNu = new JRadioButton("Nữ");
		rdNu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdNu.setBounds(236, 204, 61, 28);
		contentPane.add(rdNu);
		
		ButtonGroup ButtonGroup1 = new ButtonGroup();
		ButtonGroup1.add(rdNam);
		ButtonGroup1.add(rdNu);
		
		lblLoiMaKH = new JLabel("");
		lblLoiMaKH.setForeground(new Color(255, 0, 0));
		lblLoiMaKH.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiMaKH.setBounds(131, 114, 308, 19);
		contentPane.add(lblLoiMaKH);
		
		lblLoiHoTen = new JLabel("");
		lblLoiHoTen.setForeground(Color.RED);
		lblLoiHoTen.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiHoTen.setBounds(131, 175, 308, 19);
		contentPane.add(lblLoiHoTen);
		
		lblLoiGioitinh = new JLabel("");
		lblLoiGioitinh.setForeground(Color.RED);
		lblLoiGioitinh.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiGioitinh.setBounds(131, 232, 308, 19);
		contentPane.add(lblLoiGioitinh);
		
		txtNgaysinh = new JTextField();
		txtNgaysinh.setBounds(131, 261, 595, 32);
		contentPane.add(txtNgaysinh);
		txtNgaysinh.setColumns(10);
		
		lblLoiNgaysinh = new JLabel("");
		lblLoiNgaysinh.setForeground(Color.RED);
		lblLoiNgaysinh.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiNgaysinh.setBounds(131, 298, 362, 19);
		contentPane.add(lblLoiNgaysinh);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(131, 335, 595, 32);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);
		
		lblLoiSDT = new JLabel("");
		lblLoiSDT.setForeground(Color.RED);
		lblLoiSDT.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiSDT.setBounds(131, 377, 362, 19);
		contentPane.add(lblLoiSDT);
		
		JButton btnThem = new JButton("Thêm ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(131, 430, 114, 35);
		contentPane.add(btnThem);
		
		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(255, 430, 114, 35);
		contentPane.add(btnCapnhat);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(379, 430, 114, 35);
		contentPane.add(btnXoa);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnLmMi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLmMi.setBounds(503, 430, 114, 35);
		contentPane.add(btnLmMi);
		
		setLocationRelativeTo(null);
	}
    
    void insert() {
    	if(checkNull() ==true && checkValidate() == true) {
	  	    KhachHang kh = getForm();
	  	    try {
	  	      this.khdao.insert(kh);
//	  	      System.out.println(XDate.toString(kh.getNgaysinh(), "MM/dd/yyyy"));
	  	      KhachHangPanel.fillTable();
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
	        KhachHang model = getForm();
	        try {
	          this.khdao.update(model);
	          KhachHangPanel.fillTable();
	          clearForm();
	          MsgBox.alert(this, "Cập nhật thành công!");
	          this.setVisible(false);
	        } catch (Exception e) {
	          MsgBox.alert(this, "Cập nhật thất bại!");
	          this.setVisible(false);
	          e.printStackTrace();
	        } 
    	}
      }
      
      void delete() {
    	  if(checkNull()) {
	        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa khách hàng này?")) {
	          String manh = txtMaKH.getText();
	          try {
	            this.khdao.delete(manh);
	            KhachHangPanel.fillTable();
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
    	  if (txtMaKH.getText().equals("")) {
    		  lblLoiMaKH.setText("Không để trống thông tin");
    		  lblLoiMaKH.setForeground(Color.red);
    		  lblLoiMaKH.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtMaKH.requestFocus();
    		  return false;
    	  } else if (txtHoten.getText().equals("")) {
    		  lblLoiHoTen.setText("Không để trống thông tin");
    		  lblLoiHoTen.setForeground(Color.red);
    		  lblLoiHoTen.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtHoten.requestFocus();
    		  return false;
    	  } else if (rdNam.isSelected() == false && rdNu.isSelected() == false) {
    		  lblLoiGioitinh.setForeground(Color.red);
	  		  lblLoiGioitinh.setText("Không để trống thông tin");
	  		  lblLoiGioitinh.setFont(new Font("Tahoma", Font.ITALIC, 15));  		  
	  		  return false;
    	  } else if (rdNam.isSelected() == false && rdNu.isSelected() == false) {
    		  lblLoiGioitinh.setForeground(Color.red);
	  		  lblLoiGioitinh.setText("Không để trống thông tin");
	  		  lblLoiGioitinh.setFont(new Font("Tahoma", Font.ITALIC, 15));  		  
	  		  return false;
    	  } else if (txtNgaysinh.getText().equals("")) {
    		  lblLoiNgaysinh.setText("Không để trống thông tin");
    		  lblLoiNgaysinh.setForeground(Color.red);
    		  lblLoiNgaysinh.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtNgaysinh.requestFocus();
    		  return false; 
    	  } else if(txtSDT.getText().equals("")){
      		lblLoiSDT.setText("Không để trống thông tin");
      		lblLoiSDT.setForeground(Color.red);
      		lblLoiSDT.setFont(new Font("Tahoma", Font.ITALIC, 15));
      		txtSDT.requestFocus();
      		return false;
      	}
    	  return true;
      }
      
      public boolean checkValidate() {
    	  LocalDate brith = LocalDate.parse(txtNgaysinh.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//    	  if (!txtNgaysinh.getText().equalsIgnoreCase(regexNgaySinh(brith))) {
//    		  lblLoiNgaysinh.setText("Ngày sinh sai dịnh dạng (VD: 12/31/2000)");
//    		  lblLoiNgaysinh.setForeground(Color.red);
//    		  lblLoiNgaysinh.setFont(new Font("Tahoma", Font.ITALIC, 15));
//    		  txtNgaysinh.requestFocus();
//    		  return false;
//    	  } 
//    	  else 
    	  if(Age(brith) < 18 ) {
        		  lblLoiNgaysinh.setText("Khách hàng phải lớn hơn hoặc bằng 18 tuổi");
        		  lblLoiNgaysinh.setForeground(Color.red);
        		  lblLoiNgaysinh.setFont(new Font("Tahoma", Font.ITALIC, 15));
        		  txtNgaysinh.requestFocus();
        		  return false;
    	  }
    	  if (!txtSDT.getText().matches(regexSDT)) {
  			lblLoiSDT.setText("Điện thoại không đúng định dạng (VD: 0912345678)");
  			lblLoiSDT.setForeground(Color.red);
  			lblLoiSDT.setFont(new Font("Tahoma", Font.ITALIC, 15));
  			txtSDT.requestFocus();
  			return false;
  		  }
    	  
    	return true;
      }
      
      
    public static void setForm(KhachHang kh) {
    	try {
	        txtMaKH.setText(kh.getMaKH());
	        txtHoten.setText(kh.getHoten());
	        if (kh.isGioitinh()) {
	        	rdNam.setSelected(true);
	        } else {
	        	rdNu.setSelected(true);
	        } 
	        txtNgaysinh.setText(kh.getNgaysinh());
	        txtSDT.setText(kh.getSDT());
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
      }
    
    KhachHang getForm() {
    	KhachHang kh = new KhachHang();
    	kh.setMaKH(txtMaKH.getText());
    	kh.setHoten(txtHoten.getText());
    	kh.setGioitinh(rdNam.isSelected());
//    	kh.setNgaysinh(XDate.toString(txtNgaysinh.getText()), "yyyy-MM-dd"));
    	kh.setNgaysinh(txtNgaysinh.getText());
    	kh.setSDT(txtSDT.getText());
    	return kh;
    }
    
    void clearForm() {
        KhachHang kh = new KhachHang();
        setFormClean(kh);
        lblLoiMaKH.setText("");
        lblLoiHoTen.setText("");
        lblLoiGioitinh.setText("");
        lblLoiNgaysinh.setText("");
        lblLoiSDT.setText("");
      }
    
    void setFormClean(KhachHang kh) {
  	  	txtMaKH.setText("");
  	    txtHoten.setText("");
  	    if (kh.isGioitinh()) {
  	      rdNam.setSelected(false);
  	    } else {
  	      rdNu.setSelected(false);
  	    } 
  	    txtNgaysinh.setText("");
  	    txtSDT.setText("");
    }
    
    public int Age(LocalDate brith) {
    	LocalDate datnow = LocalDate.now();
		return Period.between(brith,datnow).getYears();
	 }
    
    public String regexNgaySinh(LocalDate brith) {
    	return String.valueOf(brith);
    }
}
