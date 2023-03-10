package com.mart.form.ChiTieu;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.ChiTieuDAO;
import com.mart.dao.NhanVienDAO;
import com.mart.entity.ChiTieu;
import com.mart.entity.KhachHang;
import com.mart.entity.NhanVien;
import com.mart.form.KhachHang.KhachHangPanel;
import com.mart.utils.Check;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;
import com.raven.datechooser.DateChooser;

import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChinhsuaChitieuFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaHM;
	private static JTextField txtTenHM;
	private static JTextField txtNgaytao;
	private static JTextField txtGiatien;
	private JLabel lblLoiMaHM;
	private JLabel lblLoiTenHM;
	private JLabel lblLoiNgaytao;
	private JLabel lblLoiMaNV;
	private JLabel lblLoiGiatien;
	private static JComboBox cbxMaNV;
	private static JTextArea txaGhichu;
	
	DateChooser dateTao = new DateChooser();
	ChiTieuDAO chitieudao = new ChiTieuDAO();
	NhanVienDAO nvdao = new NhanVienDAO();
	DefaultComboBoxModel<String> cbx = new DefaultComboBoxModel<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuaChitieuFrame frame = new ChinhsuaChitieuFrame();
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
	public ChinhsuaChitieuFrame() {
		initCompnent();
		init();
	}
	
	public void initCompnent() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 765, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHngHa = new JLabel("CHI TI??U");
		lblHngHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngHa.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHngHa.setBounds(224, 0, 386, 60);
		contentPane.add(lblHngHa);
		
		txtMaHM = new JTextField();
		txtMaHM.setColumns(10);
		txtMaHM.setBounds(149, 81, 595, 32);
		contentPane.add(txtMaHM);
		
		JLabel lblNewLabel_1 = new JLabel("M?? h???ng m???c: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 81, 129, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T??n h???ng m???c: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 144, 129, 32);
		contentPane.add(lblNewLabel_1_1);
		
		lblLoiMaHM = new JLabel("");
		lblLoiMaHM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiMaHM.setBounds(149, 116, 386, 19);
		contentPane.add(lblLoiMaHM);
		
		txtTenHM = new JTextField();
		txtTenHM.setColumns(10);
		txtTenHM.setBounds(149, 144, 595, 32);
		contentPane.add(txtTenHM);
		
		lblLoiTenHM = new JLabel("");
		lblLoiTenHM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiTenHM.setBounds(149, 179, 386, 19);
		contentPane.add(lblLoiTenHM);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ng??y t???o:  ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 208, 129, 32);
		contentPane.add(lblNewLabel_1_2);
		
		txtNgaytao = new JTextField();
		txtNgaytao.setColumns(10);
		txtNgaytao.setBounds(149, 208, 595, 32);
		dateTao.setTextField(txtNgaytao);
		contentPane.add(txtNgaytao);
		
		lblLoiNgaytao = new JLabel("");
		lblLoiNgaytao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiNgaytao.setBounds(149, 243, 386, 19);
		contentPane.add(lblLoiNgaytao);
		
		JLabel lblNewLabel_1_3 = new JLabel("M?? ng?????i t???o:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 269, 129, 32);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Gi?? ti???n: ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(10, 330, 129, 32);
		contentPane.add(lblNewLabel_1_4);
		
		lblLoiMaNV = new JLabel("");
		lblLoiMaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiMaNV.setBounds(149, 304, 386, 19);
		contentPane.add(lblLoiMaNV);
		
		txtGiatien = new JTextField();
		txtGiatien.setColumns(10);
		txtGiatien.setBounds(149, 330, 595, 32);
		contentPane.add(txtGiatien);
		
		lblLoiGiatien = new JLabel("");
		lblLoiGiatien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiGiatien.setBounds(149, 365, 386, 19);
		contentPane.add(lblLoiGiatien);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Ghi ch??: ");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1.setBounds(10, 388, 129, 32);
		contentPane.add(lblNewLabel_1_4_1);
		
		JButton btnThem = new JButton("Th??m ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(149, 475, 114, 35);
		contentPane.add(btnThem);
		
		JButton btnCapnhat = new JButton("C???p nh???t");
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(273, 475, 114, 35);
		contentPane.add(btnCapnhat);
		
		JButton btnXoa = new JButton("Xo??");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(399, 475, 114, 35);
		contentPane.add(btnXoa);
		
		JButton btnLammoi = new JButton("L??m m???i");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLammoi.setBounds(521, 475, 114, 35);
		contentPane.add(btnLammoi);
		
		cbxMaNV = new JComboBox();
		cbxMaNV.setBounds(149, 272, 595, 29);
		cbxMaNV.setModel(cbx);
		contentPane.add(cbxMaNV);
		
		txaGhichu = new JTextArea();
		txaGhichu.setBounds(149, 394, 595, 71);
		contentPane.add(txaGhichu);
		
	}
	public void init() {
		setLocationRelativeTo(null);
		fillComboboxNhanvien();
	}
	
	public void fillComboboxNhanvien() {
		cbx.removeAllElements();
		List<NhanVien> list = nvdao.selectByTruongphong();
		for (NhanVien nhanVien : list) {
				cbx.addElement(nhanVien.getMaNV());
		}
	}
	
	void insert() {
    	if(checkNull() == true && checkValidate() == true) {
	  	    ChiTieu ct = getForm();
	  	    try {
	  	      this.chitieudao.insert(ct);
//	  	      System.out.println(XDate.toString(kh.getNgaysinh(), "MM/dd/yyyy"));
	  	      ChiTieuPanel.fillTable();
	  	      clearForm();
	  	      MsgBox.alert(this, "Th??m m???i th??nh c??ng!");
	  	    this.setVisible(false);
	  	    } catch (Exception e) {
	  	      MsgBox.alert(this, "Th??m m???i th???t b???i!");
	  	    this.setVisible(false);
	  	      e.printStackTrace();
	  	    } 
    	}
    }
    
    void update() {
    	if(checkNull()) {
	        ChiTieu model = getForm();
	        try {
	          this.chitieudao.update(model);
	          ChiTieuPanel.fillTable();
	          clearForm();
	          MsgBox.alert(this, "C???p nh???t th??nh c??ng!");
	          this.setVisible(false);
	        } catch (Exception e) {
	          MsgBox.alert(this, "C???p nh???t th???t b???i!");
	          this.setVisible(false);
	          e.printStackTrace();
	        } 
    	}
      }
      
      void delete() {
    	  if(checkNull()) {
	        if (MsgBox.confirm(this, "B???n th???c s??? mu???n x??a h???ng m???c chi ti??u n??y?")) {
	          String manh = txtMaHM.getText();
	          try {
	            this.chitieudao.delete(manh);
	            ChiTieuPanel.fillTable();
	            clearForm();
	            MsgBox.alert(this, "X??a th??nh c??ng!");
	            this.setVisible(false);
	          } catch (Exception e) {
	            MsgBox.alert(this, "X??a th???t b???i!");
	            this.setVisible(false);
	            e.printStackTrace();
	          } 
	        } 
    	  }
      }
          
      public boolean checkNull() {
    	  if (txtMaHM.getText().equals("")) {
    		  lblLoiMaHM.setText("Kh??ng ????? tr???ng th??ng tin");
    		  lblLoiMaHM.setForeground(Color.red);
    		  lblLoiMaHM.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtMaHM.requestFocus();
    		  return false;
    	  } else if (txtTenHM.getText().equals("")) {
    		  lblLoiTenHM.setText("Kh??ng ????? tr???ng th??ng tin");
    		  lblLoiTenHM.setForeground(Color.red);
    		  lblLoiTenHM.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtTenHM.requestFocus();
    		  return false;
    	  } else if (txtNgaytao.getText().equals("")) {
    		  lblLoiNgaytao.setText("Kh??ng ????? tr???ng th??ng tin");
    		  lblLoiNgaytao.setForeground(Color.red);
    		  lblLoiNgaytao.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtNgaytao.requestFocus();
    		  return false; 
    	  } else if(txtGiatien.getText().equals("")){
        		lblLoiGiatien.setText("Kh??ng ????? tr???ng th??ng tin");
          		lblLoiGiatien.setForeground(Color.red);
          		lblLoiGiatien.setFont(new Font("Tahoma", Font.ITALIC, 15));
          		txtGiatien.requestFocus();
          		return false;
          } 
    	  return true;
      }
      
      public boolean checkValidate() {
    	  if (Float.parseFloat(txtGiatien.getText()) < 1.000) {
  			lblLoiGiatien.setText("S??? ti???n kh??ng ???????c nh??? h??n 1.000");
  			lblLoiGiatien.setForeground(Color.red);
  			lblLoiGiatien.setFont(new Font("Tahoma", Font.ITALIC, 15));
  			txtGiatien.requestFocus();
  			return false;
  		  }
    	  
    	return true;
      }
      
      
    public static void setForm(ChiTieu cT) {
    	try {
	        txtMaHM.setText(cT.getMaHangmuc());
	        txtTenHM.setText(cT.getTenHangmuc());
	        txtNgaytao.setText(cT.getNgaytao());
	        cbxMaNV.setSelectedItem(cT.getMaNV());
	        txtGiatien.setText(String.valueOf(cT.getGiatien()));
	        txaGhichu.setText(cT.getGhichu());
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
      }
     
    ChiTieu getForm() {
    	ChiTieu ct = new ChiTieu();
    	ct.setMaHangmuc(txtMaHM.getText());
    	ct.setTenHangmuc(txtTenHM.getText());
    	ct.setNgaytao(txtNgaytao.getText());
    	ct.setMaNV(String.valueOf(cbxMaNV.getSelectedItem()));
    	ct.setGiatien(Float.parseFloat(txtGiatien.getText()));
    	ct.setGhichu(txaGhichu.getText());
    	return ct;
    }
    
    void clearForm() {
        ChiTieu ct = new ChiTieu();
        setFormClean(ct);
        lblLoiMaHM.setText("");
        lblLoiTenHM.setText("");
        lblLoiNgaytao.setText("");
        lblLoiMaNV.setText("");
        lblLoiGiatien.setText("");
      }
    
    void setFormClean(ChiTieu ct) {
  	  	txtMaHM.setText("");
  	    txtTenHM.setText("");
  	    txtNgaytao.setText(""); 
  	    txtGiatien.setText("");
  	    txaGhichu.setText("");
    }
}
