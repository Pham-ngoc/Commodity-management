package com.mart.form.LoaiHang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.LoaiHangDAO;
import com.mart.entity.LoaiHang;
import com.mart.utils.MsgBox;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChinhsuaLHFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaLH;
	private static JTextField txtTenLH;
	private JLabel lblLoiMaLH;
	private JLabel lblLoiTenloai;

	private LoaiHangDAO lhdao = new LoaiHangDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuaLHFrame frame = new ChinhsuaLHFrame();
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
	public ChinhsuaLHFrame() {
		initCompnent();
	}
	
	public void initCompnent() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 692, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoiHngHa = new JLabel("LOẠI HÀNG HÓA");
		lblLoiHngHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoiHngHa.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLoiHngHa.setBounds(238, 0, 206, 40);
		contentPane.add(lblLoiHngHa);
		
		JLabel lblNewLabel_1 = new JLabel("Mã loại hàng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 72, 99, 32);
		contentPane.add(lblNewLabel_1);
		
		txtMaLH = new JTextField();
		txtMaLH.setColumns(10);
		txtMaLH.setBounds(130, 72, 511, 32);
		contentPane.add(txtMaLH);
		
		lblLoiMaLH = new JLabel("");
		lblLoiMaLH.setForeground(Color.RED);
		lblLoiMaLH.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiMaLH.setBounds(130, 111, 297, 19);
		contentPane.add(lblLoiMaLH);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên loại hàng: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 137, 110, 32);
		contentPane.add(lblNewLabel_1_1);
		
		txtTenLH = new JTextField();
		txtTenLH.setColumns(10);
		txtTenLH.setBounds(130, 137, 511, 32);
		contentPane.add(txtTenLH);
		
		lblLoiTenloai = new JLabel("");
		lblLoiTenloai.setForeground(Color.RED);
		lblLoiTenloai.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiTenloai.setBounds(130, 176, 297, 19);
		contentPane.add(lblLoiTenloai);
		
		JButton btnThem = new JButton("Thêm ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(130, 220, 114, 35);
		contentPane.add(btnThem);
		
		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(254, 220, 114, 35);
		contentPane.add(btnCapnhat);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(378, 220, 114, 35);
		contentPane.add(btnXoa);
		
		JButton btnLammoi = new JButton("Làm mới");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLammoi.setBounds(505, 220, 114, 35);
		contentPane.add(btnLammoi);
		
		setLocationRelativeTo(null);		
	}
	
	LoaiHang getForm() {
    	LoaiHang lh = new LoaiHang();
    	lh.setMaLH(txtMaLH.getText());
    	lh.setTenLH(txtTenLH.getText());
    	return lh;
    }
	
    public static void setForm(LoaiHang lh) {
    	try {
			txtMaLH.setText(lh.getMaLH());
			txtTenLH.setText(lh.getTenLH());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void clearForm() {
        LoaiHang nv = new LoaiHang();
        setFormClean(nv);
        lblLoiMaLH.setText("");
        lblLoiTenloai.setText("");
      }
    
    public void setFormClean(LoaiHang lh) {
  	  	txtMaLH.setText("");
  	    txtTenLH.setText("");
    }
    
    void insert() {
    	if(checkNull() ==true) {
	  	    LoaiHang nv = getForm();
	  	    try {
	  	      this.lhdao.insert(nv);
	  	      LoaiHangPanel.fillTable();
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
	        LoaiHang model = getForm();
	        try {
	          this.lhdao.update(model);
	          LoaiHangPanel.fillTable();
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
	          String malh = txtMaLH.getText();
	          try {
	            this.lhdao.delete(malh);
	            LoaiHangPanel.fillTable();
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
    	  if (txtMaLH.getText().equals("")) {
    		  lblLoiMaLH.setText("Không để trống thông tin");
    		  lblLoiMaLH.setForeground(Color.red);
    		  lblLoiMaLH.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtMaLH.requestFocus();
    		  return false;
    	  } else if (txtTenLH.getText().equals("")) {
    		  lblLoiTenloai.setText("Không để trống thông tin");
    		  lblLoiTenloai.setForeground(Color.red);
    		  lblLoiTenloai.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtTenLH.requestFocus();
    		  return false;
    	  } 
    	  return true;
      }

}
