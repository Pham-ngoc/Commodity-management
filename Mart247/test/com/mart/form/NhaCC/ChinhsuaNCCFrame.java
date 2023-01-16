package com.mart.form.NhaCC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.LoaiHangDAO;
import com.mart.dao.NhaNCCDAO;
import com.mart.entity.LoaiHang;
import com.mart.entity.NhaCC;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChinhsuaNCCFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaNCC;
	private static JTextField txtTenNCC;
	private static JTextField txtSDT;
	private static JTextField txtMaLH;
	private static JComboBox cbxTenLH;
	JLabel lblLoiMaNCC;
	JLabel lblLoiTenNCC;
	JLabel lblLoISDT;

	
	private DefaultComboBoxModel<String> dcb = new DefaultComboBoxModel<String>();
	private static LoaiHangDAO lhdao = new LoaiHangDAO();
	private static NhaNCCDAO nccdao = new NhaNCCDAO();
	String regexSDT = "0\\d{8,10}?";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuaNCCFrame frame = new ChinhsuaNCCFrame();
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
	public ChinhsuaNCCFrame() {
		initComponents();
		init();
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 654, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNhCungCp = new JLabel("NHÀ CUNG CẤP");
		lblNhCungCp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhCungCp.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNhCungCp.setBounds(200, 0, 209, 46);
		contentPane.add(lblNhCungCp);
		
		JLabel lblNewLabel_1 = new JLabel("Mã NCC:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 67, 97, 32);
		contentPane.add(lblNewLabel_1);
		
		lblLoiMaNCC = new JLabel("");
		lblLoiMaNCC.setForeground(Color.RED);
		lblLoiMaNCC.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiMaNCC.setBounds(117, 105, 308, 19);
		contentPane.add(lblLoiMaNCC);
		
		txtMaNCC = new JTextField();
		txtMaNCC.setColumns(10);
		txtMaNCC.setBounds(117, 70, 495, 32);
		contentPane.add(txtMaNCC);
		
		txtTenNCC = new JTextField();
		txtTenNCC.setColumns(10);
		txtTenNCC.setBounds(117, 131, 495, 32);
		contentPane.add(txtTenNCC);
		
		JLabel lblNewLabel_2 = new JLabel("Tên NCC: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 128, 97, 32);
		contentPane.add(lblNewLabel_2);
		
		lblLoiTenNCC = new JLabel("");
		lblLoiTenNCC.setForeground(Color.RED);
		lblLoiTenNCC.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiTenNCC.setBounds(117, 167, 308, 19);
		contentPane.add(lblLoiTenNCC);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(117, 194, 495, 32);
		contentPane.add(txtSDT);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số điện thoại:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(10, 194, 97, 32);
		contentPane.add(lblNewLabel_2_1);
		
		lblLoISDT = new JLabel("");
		lblLoISDT.setForeground(Color.RED);
		lblLoISDT.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoISDT.setBounds(117, 230, 419, 19);
		contentPane.add(lblLoISDT);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Loại hàng hóa:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(10, 259, 114, 32);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblLoi = new JLabel("");
		lblLoi.setForeground(Color.RED);
		lblLoi.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoi.setBounds(117, 295, 308, 19);
		contentPane.add(lblLoi);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(117, 344, 114, 35);
		contentPane.add(btnThem);
		
		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(247, 344, 114, 35);
		contentPane.add(btnCapnhat);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(371, 344, 114, 35);
		contentPane.add(btnXoa);
		
		JButton btnLammoi = new JButton("Làm mới");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLammoi.setBounds(495, 344, 114, 35);
		contentPane.add(btnLammoi);
		
		txtMaLH = new JTextField();
		txtMaLH.setEnabled(false);
		txtMaLH.setBounds(117, 259, 185, 32);
		contentPane.add(txtMaLH);
		txtMaLH.setColumns(1);
		
		cbxTenLH = new JComboBox();
		cbxTenLH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMaLoaihang();
			}
		});
		cbxTenLH.setBounds(312, 259, 300, 32);
		cbxTenLH.setModel(dcb);
		contentPane.add(cbxTenLH);
		
		setLocationRelativeTo(null);		
	}
	
	public void init() {
		fillComboxLoaihang();
	}
	
	public void fillComboxLoaihang() {
		dcb.removeAllElements();
		List<LoaiHang> list = lhdao.selectAll();
		for (LoaiHang lh : list) {
//		     cb.addElement(lh); 
//			System.out.println(lh.getTenLH());
			dcb.addElement(String.valueOf(lh.getTenLH()));
		}
	}
	
	public void getMaLoaihang() {
		List<LoaiHang> list = lhdao.selectAll();
		for (LoaiHang loaiHang : list) {
			if(String.valueOf(cbxTenLH.getSelectedItem()).equals(loaiHang.getTenLH())) {
				txtMaLH.setText(loaiHang.getMaLH());
			}
		}
	}
	
	void insert() {
    	if(checkNull() == true && checkValidate() == true) {
	  	    NhaCC ncc = getForm();
	  	    try {
	  	      this.nccdao.insert(ncc);
//	  	      System.out.println(XDate.toString(kh.getNgaysinh(), "MM/dd/yyyy"));
	  	      NhaCCPanel.fillDanhSachNCC();
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
	        NhaCC model = getForm();
	        try {
	          this.nccdao.update(model);
	          NhaCCPanel.fillDanhSachNCC();
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
	        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa nhà cung cấp này?")) {
	          String mancc = txtMaNCC.getText();
	          try {
	            this.nccdao.delete(mancc);
	            NhaCCPanel.fillDanhSachNCC();
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
    	  if (txtMaNCC.getText().equals("")) {
    		  lblLoiMaNCC.setText("Không để trống thông tin");
    		  lblLoiMaNCC.setForeground(Color.red);
    		  lblLoiMaNCC.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtMaNCC.requestFocus();
    		  return false;
    	  } else if (txtTenNCC.getText().equals("")) {
    		  lblLoiTenNCC.setText("Không để trống thông tin");
    		  lblLoiTenNCC.setForeground(Color.red);
    		  lblLoiTenNCC.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtTenNCC.requestFocus();
    		  return false;
    	  } else if (txtSDT.getText().equals("")) {
    		  lblLoISDT.setText("Không để trống thông tin");
    		  lblLoISDT.setForeground(Color.red);
    		  lblLoISDT.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtSDT.requestFocus();
    		  return false; 
    	  }
    	  return true;
      }
      
      public boolean checkValidate() {
    	  if (!txtSDT.getText().matches(regexSDT)) {
    			lblLoISDT.setText("Điện thoại không đúng định dạng (VD: 0912345678)");
      			lblLoISDT.setForeground(Color.red);
      			lblLoISDT.setFont(new Font("Tahoma", Font.ITALIC, 15));
      			txtSDT.requestFocus();
      			return false;
  		  }
    	  
    	return true;
      }
      
      
    public static void setForm(NhaCC ncc) {
    	List<LoaiHang> lh = lhdao.selectAll();;
    	try {
	        txtMaNCC.setText(ncc.getMaNCC());
	        txtTenNCC.setText(ncc.getTenNCC());
	        txtSDT.setText(ncc.getSDT());
	        txtMaLH.setText(ncc.getMaLH());
	        for (LoaiHang loaiHang : lh) {
	        	if(txtMaLH.getText().equals(loaiHang.getMaLH())) {
		        	cbxTenLH.setSelectedItem(loaiHang.getTenLH());
	        	}
	        }
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
      }
    
    NhaCC getForm() {
    	NhaCC ncc = new NhaCC();
    	ncc.setMaNCC(txtMaNCC.getText());
    	ncc.setTenNCC(txtTenNCC.getText());
    	ncc.setSDT(txtSDT.getText());
    	ncc.setMaLH(txtMaLH.getText());
    	return ncc;
    }
    
    void clearForm() {
        NhaCC ncc = new NhaCC();
        setFormClean(ncc);
        lblLoiMaNCC.setText("");
        lblLoiTenNCC.setText("");
        lblLoISDT.setText("");
      }
    
    void setFormClean(NhaCC ncc) {
  	  	txtMaNCC.setText("");
  	    txtTenNCC.setText("");
  	    txtSDT.setText("");
  	    txtMaLH.setText("");
    }
}
