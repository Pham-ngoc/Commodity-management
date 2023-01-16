package com.mart.form.ChuongTrinh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.ChuongTrinhDAO;
import com.mart.entity.ChuongTrinh;
import com.mart.entity.KhachHang;
import com.mart.form.KhachHang.KhachHangPanel;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;
import com.raven.datechooser.DateChooser;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChinhsuCTFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaCT;
	private static JTextField txtNoidung;
	private static JTextField txtGiatri;
	private static JTextField txtSoluong;
	private static JTextField txtNgaytao;
	private DateChooser dateNgaytao = new DateChooser();
	private DateChooser dateHSD = new DateChooser();
	private ChuongTrinhDAO ctrinhdao = new ChuongTrinhDAO();
	private static JTextField txtHSD;
	private JLabel lblLoiMaCT;
	private JLabel lblLoiNoidung;
	private JLabel lblLoiGiatri;
	private JLabel lblLoiSoluong;
	private JLabel lblLoiNgaytao;
	private JLabel lblLoiHSD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuCTFrame frame = new ChinhsuCTFrame();
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
	public ChinhsuCTFrame() {
		initCompnent();
		dateNgaytao.setTextField(txtNgaytao);
		dateHSD.setTextField(txtHSD);
	}
	
	public void initCompnent() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 783, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHngHa = new JLabel("CHƯƠNG TRÌNH KHUYẾN MÃI");
		lblHngHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngHa.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHngHa.setBounds(224, 0, 386, 60);
		contentPane.add(lblHngHa);
		
		txtMaCT = new JTextField();
		txtMaCT.setColumns(10);
		txtMaCT.setBounds(149, 81, 595, 32);
		contentPane.add(txtMaCT);
		
		JLabel lblNewLabel_1 = new JLabel("Mã chương trình: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 81, 129, 32);
		contentPane.add(lblNewLabel_1);
		
		lblLoiMaCT = new JLabel("");
		lblLoiMaCT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiMaCT.setBounds(149, 116, 386, 19);
		contentPane.add(lblLoiMaCT);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nội dung: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 144, 129, 32);
		contentPane.add(lblNewLabel_1_1);
		
		txtNoidung = new JTextField();
		txtNoidung.setColumns(10);
		txtNoidung.setBounds(149, 144, 595, 32);
		contentPane.add(txtNoidung);
		
		lblLoiNoidung = new JLabel("");
		lblLoiNoidung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiNoidung.setBounds(149, 179, 386, 19);
		contentPane.add(lblLoiNoidung);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giá trị:  ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 208, 129, 32);
		contentPane.add(lblNewLabel_1_2);
		
		txtGiatri = new JTextField();
		txtGiatri.setColumns(10);
		txtGiatri.setBounds(149, 208, 595, 32);
		contentPane.add(txtGiatri);
		
		lblLoiGiatri = new JLabel("");
		lblLoiGiatri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiGiatri.setBounds(149, 243, 386, 19);
		contentPane.add(lblLoiGiatri);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số lượng:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 269, 129, 32);
		contentPane.add(lblNewLabel_1_3);
		
		txtSoluong = new JTextField();
		txtSoluong.setColumns(10);
		txtSoluong.setBounds(149, 269, 595, 32);
		contentPane.add(txtSoluong);
		
		lblLoiSoluong = new JLabel("");
		lblLoiSoluong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiSoluong.setBounds(149, 304, 386, 19);
		contentPane.add(lblLoiSoluong);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày tạo: ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(10, 330, 129, 32);
		contentPane.add(lblNewLabel_1_4);
		
		txtNgaytao = new JTextField();
		txtNgaytao.setColumns(10);
		txtNgaytao.setBounds(149, 330, 595, 32);
		contentPane.add(txtNgaytao);
		
		lblLoiNgaytao = new JLabel("");
		lblLoiNgaytao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiNgaytao.setBounds(149, 365, 386, 19);
		contentPane.add(lblLoiNgaytao);
		
		JButton btnThem = new JButton("Thêm ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(149, 475, 114, 35);
		contentPane.add(btnThem);
		
		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(273, 475, 114, 35);
		contentPane.add(btnCapnhat);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(399, 475, 114, 35);
		contentPane.add(btnXoa);
		
		JButton btnLammoi = new JButton("Làm mới");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLammoi.setBounds(521, 475, 114, 35);
		contentPane.add(btnLammoi);
		
		lblLoiHSD = new JLabel("");
		lblLoiHSD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiHSD.setBounds(149, 423, 386, 19);
		contentPane.add(lblLoiHSD);
		
		txtHSD = new JTextField();
		txtHSD.setColumns(10);
		txtHSD.setBounds(149, 388, 595, 32);
		contentPane.add(txtHSD);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Hạn sử dụng: ");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1.setBounds(10, 388, 129, 32);
		contentPane.add(lblNewLabel_1_4_1);
		
		setLocationRelativeTo(null);
	}
	
	public static void setForm(ChuongTrinh ctrinh) {
		try {
			txtMaCT.setText(ctrinh.getMaCT());
			txtNoidung.setText(ctrinh.getNoidung());
			txtGiatri.setText(String.valueOf(ctrinh.getGiatri()));
			txtSoluong.setText(String.valueOf(ctrinh.getSoluong()));
			txtNgaytao.setText(ctrinh.getNgaytao());
			txtHSD.setText(ctrinh.getHSD());
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi hệ thống");
			e.printStackTrace();
		}
	}
	
	ChuongTrinh getForm() {
    	ChuongTrinh ctrinh = new ChuongTrinh();
    	ctrinh.setMaCT(txtMaCT.getText());
    	ctrinh.setNoidung(txtNoidung.getText());
    	ctrinh.setGiatri(Float.parseFloat(txtGiatri.getText()));
    	ctrinh.setSoluong(Integer.parseInt(txtSoluong.getText()));
    	ctrinh.setNgaytao(txtNgaytao.getText());
    	ctrinh.setHSD(txtHSD.getText());
    	return ctrinh;
    }
    
    void clearForm() {
        ChuongTrinh ctrinh = new ChuongTrinh();
        setFormClean(ctrinh);
        lblLoiMaCT.setText("");
        lblLoiNoidung.setText("");
        lblLoiGiatri.setText("");
        lblLoiSoluong.setText("");
        lblLoiNgaytao.setText("");
        lblLoiHSD.setText("");
      }
    
    void setFormClean(ChuongTrinh ctrinh) {
  	  	txtMaCT.setText("");
  	    txtNoidung.setText("");
  	    txtGiatri.setText("");
  	    txtSoluong.setText("");
  	    txtNgaytao.setText("");
  	    txtHSD.setText("");
    }
    
    void insert() {
    	if(checkNull() == true && checkValidate() == true) {
	  	    ChuongTrinh ctrinh = getForm();
	  	    try {
	  	      this.ctrinhdao.insert(ctrinh);
	  	      ChuongTrinhPanel.fillTable();
	  	      clearForm();
	  	      MsgBox.alert(this, "Thêm mới thành công!");
	  	    } catch (Exception e) {
	  	      MsgBox.alert(this, "Thêm mới thất bại!");
	  	      e.printStackTrace();
	  	    } 
    	}
    }
    
    void update() {
    	if(checkNull()) {
    		ChuongTrinh ctrinh = getForm();
	        try {
	          this.ctrinhdao.update(ctrinh);
	          ChuongTrinhPanel.fillTable();
	          clearForm();
	          MsgBox.alert(this, "Cập nhật thành công!");
	        } catch (Exception e) {
	          MsgBox.alert(this, "Cập nhật thất bại!");
	          e.printStackTrace();
	        } 
    	}
      }
      
      void delete() {
    	  if(checkNull()) {
	        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa khách hàng này?")) {
	          String manh = txtMaCT.getText();
	          try {
	            this.ctrinhdao.delete(manh);
	            ChuongTrinhPanel.fillTable();
	            clearForm();
	            MsgBox.alert(this, "Xóa thành công!");
	          } catch (Exception e) {
	            MsgBox.alert(this, "Xóa thất bại!");
	            e.printStackTrace();
	          } 
	        } 
    	  }
      }
      
      public boolean checkNull() {
    	  if (txtMaCT.getText().equals("")) {
    		  lblLoiMaCT.setText("Không để trống thông tin");
    		  lblLoiMaCT.setForeground(Color.red);
    		  lblLoiMaCT.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtMaCT.requestFocus();
    		  return false;
    	  } else if (txtNoidung.getText().equals("")) {
    		  lblLoiNoidung.setText("Không để trống thông tin");
    		  lblLoiNoidung.setForeground(Color.red);
    		  lblLoiNoidung.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtNoidung.requestFocus();
    		  return false;
    	  } else if (txtGiatri.getText().equals("")) {
    		  lblLoiGiatri.setText("Không để trống thông tin");
    		  lblLoiGiatri.setForeground(Color.red);
    		  lblLoiGiatri.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtGiatri.requestFocus();
    		  return false; 
    	  } else if(txtSoluong.getText().equals("")){
      		lblLoiSoluong.setText("Không để trống thông tin");
      		lblLoiSoluong.setForeground(Color.red);
      		lblLoiSoluong.setFont(new Font("Tahoma", Font.ITALIC, 15));
      		txtSoluong.requestFocus();
      		return false;
      	} else if(txtNgaytao.getText().equals("")){
      		lblLoiNgaytao.setText("Không để trống thông tin");
      		lblLoiNgaytao.setForeground(Color.red);
      		lblLoiNgaytao.setFont(new Font("Tahoma", Font.ITALIC, 15));
      		txtNgaytao.requestFocus();
      		return false;
      	} else if(txtHSD.getText().equals("")){
      		lblLoiHSD.setText("Không để trống thông tin");
      		lblLoiHSD.setForeground(Color.red);
      		lblLoiHSD.setFont(new Font("Tahoma", Font.ITALIC, 15));
      		txtHSD.requestFocus();
      		return false;
      	}
    	  return true;
      }
      
      public boolean checkValidate() {
    	  if(Float.parseFloat(txtGiatri.getText()) < 1000) {
    		  lblLoiGiatri.setText("Giá trị khuyến mãi không dưới 1000 VNĐ");
    		  lblLoiGiatri.setForeground(Color.red);
    		  lblLoiGiatri.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtGiatri.requestFocus();
    		  return false; 
    	  } 
    	  if(Integer.parseInt(txtSoluong.getText()) < 0) {
    		  lblLoiSoluong.setText("Số lượng không được dưới 1");
        		lblLoiSoluong.setForeground(Color.red);
        		lblLoiSoluong.setFont(new Font("Tahoma", Font.ITALIC, 15));
        		txtSoluong.requestFocus();
        		return false;
    	  }
    	  return true;
      }
}
