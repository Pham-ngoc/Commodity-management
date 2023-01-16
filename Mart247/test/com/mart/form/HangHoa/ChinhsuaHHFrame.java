package com.mart.form.HangHoa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.HangHoaDAO;
import com.mart.dao.LoaiHangDAO;
import com.mart.entity.HangHoa;
import com.mart.entity.LoaiHang;
import com.mart.utils.MsgBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChinhsuaHHFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaHH;
	private static JTextField txtTenHH;
	private static JTextField txtDVT;
	private static JTextField txtGiaban;
	private static JTextField txtTonkho;
	private JLabel lblLoiMaHH;
	private JLabel lblLoiTenhang;
	private JLabel lblLoiDVT;
	private JLabel lblLoiTonkho;
	private static JComboBox cbxLoaihang;
	private DefaultComboBoxModel<String> dcb = new DefaultComboBoxModel<String>();
	private static HangHoaDAO hhdao = new HangHoaDAO();
	private static LoaiHangDAO lhdao = new LoaiHangDAO();
	private static JTextField txtMaLH;
	private JLabel lblNewLabel_2_2;
	private JLabel lblLoiGiaban;
	private JLabel lblNewLabel_2_4;
	private JLabel lblLoiTonkho_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuaHHFrame frame = new ChinhsuaHHFrame();
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
	public ChinhsuaHHFrame() {
		initComponents();
		init();
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHngHa = new JLabel("HÀNG HÓA");
		lblHngHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngHa.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHngHa.setBounds(269, 0, 170, 60);
		contentPane.add(lblHngHa);

		txtMaHH = new JTextField();
		txtMaHH.setColumns(10);
		txtMaHH.setBounds(131, 76, 595, 32);
		contentPane.add(txtMaHH);

		JLabel lblNewLabel_1 = new JLabel("Mã hàng hóa: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 80, 114, 28);
		contentPane.add(lblNewLabel_1);

		lblLoiMaHH = new JLabel("");
		lblLoiMaHH.setForeground(Color.RED);
		lblLoiMaHH.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiMaHH.setBounds(131, 114, 308, 19);
		contentPane.add(lblLoiMaHH);

		JLabel lblNewLabel_2 = new JLabel("Tên hàng hóa: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 142, 114, 28);
		contentPane.add(lblNewLabel_2);

		txtTenHH = new JTextField();
		txtTenHH.setColumns(10);
		txtTenHH.setBounds(131, 138, 595, 32);
		contentPane.add(txtTenHH);

		lblLoiTenhang = new JLabel("");
		lblLoiTenhang.setForeground(Color.RED);
		lblLoiTenhang.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiTenhang.setBounds(131, 175, 308, 19);
		contentPane.add(lblLoiTenhang);

		JLabel lblNewLabel_2_1 = new JLabel("Đơn vị tính: ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(10, 202, 114, 28);
		contentPane.add(lblNewLabel_2_1);

		txtDVT = new JTextField();
		txtDVT.setColumns(10);
		txtDVT.setBounds(131, 198, 595, 32);
		contentPane.add(txtDVT);

		lblLoiDVT = new JLabel("");
		lblLoiDVT.setForeground(Color.RED);
		lblLoiDVT.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiDVT.setBounds(131, 235, 308, 19);
		contentPane.add(lblLoiDVT);

		JLabel lblNewLabel_2_3 = new JLabel("Loại hàng hóa");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(10, 392, 114, 28);
		contentPane.add(lblNewLabel_2_3);

		lblLoiTonkho = new JLabel("");
		lblLoiTonkho.setForeground(Color.RED);
		lblLoiTonkho.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiTonkho.setBounds(131, 364, 308, 19);
		contentPane.add(lblLoiTonkho);

		cbxLoaihang = new JComboBox();
		cbxLoaihang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMaLoaihang();
			}
		});
		cbxLoaihang.setModel(dcb);
		cbxLoaihang.setBounds(300, 392, 426, 32);
		contentPane.add(cbxLoaihang);

		JButton btnThem = new JButton("Thêm ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(131, 449, 114, 35);
		contentPane.add(btnThem);

		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(255, 449, 114, 35);
		contentPane.add(btnCapnhat);

		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(379, 449, 114, 35);
		contentPane.add(btnXoa);

		JButton btnLammoi = new JButton("Làm mới");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLammoi.setBounds(503, 449, 114, 35);
		contentPane.add(btnLammoi);
		
		txtMaLH = new JTextField();
		txtMaLH.setEnabled(false);
		txtMaLH.setBounds(131, 393, 159, 31);
		contentPane.add(txtMaLH);
		txtMaLH.setColumns(10);
		
		txtGiaban = new JTextField();
		txtGiaban.setColumns(10);
		txtGiaban.setBounds(131, 264, 595, 32);
		contentPane.add(txtGiaban);
		
		lblNewLabel_2_2 = new JLabel("Giá bán:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(10, 268, 114, 28);
		contentPane.add(lblNewLabel_2_2);
		
		lblLoiGiaban = new JLabel("");
		lblLoiGiaban.setForeground(Color.RED);
		lblLoiGiaban.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiGiaban.setBounds(131, 301, 308, 19);
		contentPane.add(lblLoiGiaban);
		
		txtTonkho = new JTextField();
		txtTonkho.setColumns(10);
		txtTonkho.setBounds(131, 330, 595, 32);
		contentPane.add(txtTonkho);
		
		lblNewLabel_2_4 = new JLabel("Tồn kho:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(10, 334, 114, 28);
		contentPane.add(lblNewLabel_2_4);
		
		lblLoiTonkho_1 = new JLabel("");
		lblLoiTonkho_1.setForeground(Color.RED);
		lblLoiTonkho_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiTonkho_1.setBounds(131, 367, 308, 19);
		contentPane.add(lblLoiTonkho_1);

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
			if(String.valueOf(cbxLoaihang.getSelectedItem()).equals(loaiHang.getTenLH())) {
				txtMaLH.setText(loaiHang.getMaLH());
			}
		}
	}
	
	public static void setForm(HangHoa hh) {
		List<LoaiHang> lh = lhdao.selectAll();;
		try {
	        txtMaHH.setText(hh.getMaHH());
	        txtTenHH.setText(hh.getTenHH());
	        txtDVT.setText(hh.getDVT());
	        txtGiaban.setText(String.valueOf(hh.getGia()));
	        txtTonkho.setText(String.valueOf(hh.getTonkho()));
	        txtMaLH.setText(hh.getMaLH());
	        for (LoaiHang loaiHang : lh) {
	        	if(txtMaLH.getText().equals(loaiHang.getMaLH())) {
		        	cbxLoaihang.setSelectedItem(loaiHang.getTenLH());
	        	}
	        }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void insert() {
    	if(checkNull() == true && checkValidate() == true) {
	  	    HangHoa hh = getForm();
	  	    try {
	  	      this.hhdao.insert(hh);
//	  	      System.out.println(XDate.toString(kh.getNgaysinh(), "MM/dd/yyyy"));
	  	      HangHoaPanel.fillTableHangHoa();
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
	        HangHoa model = getForm();
	        try {
	          this.hhdao.update(model);
	          HangHoaPanel.fillTableHangHoa();
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
	        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa hàng hóa này?")) {
	          String mahh = txtMaHH.getText();
	          try {
	            this.hhdao.delete(mahh);
	            HangHoaPanel.fillTableHangHoa();
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
    	  if (txtMaHH.getText().equals("")) {
    		  lblLoiMaHH.setText("Không để trống thông tin");
    		  lblLoiMaHH.setForeground(Color.red);
    		  lblLoiMaHH.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtMaHH.requestFocus();
    		  return false;
    	  } else if (txtTenHH.getText().equals("")) {
    		  lblLoiTenhang.setText("Không để trống thông tin");
    		  lblLoiTenhang.setForeground(Color.red);
    		  lblLoiTenhang.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtTenHH.requestFocus();
    		  return false;
    	  } else if (txtDVT.getText().equals("")) {
    		  lblLoiDVT.setText("Không để trống thông tin");
    		  lblLoiDVT.setForeground(Color.red);
    		  lblLoiDVT.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtDVT.requestFocus();
    		  return false; 
    	  } else if (txtGiaban.getText().equals("")) {
    		  lblLoiGiaban.setText("Không để trống thông tin");
    		  lblLoiGiaban.setForeground(Color.red);
    		  lblLoiGiaban.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtGiaban.requestFocus();
    		  return false; 
    	  } else if (txtTonkho.getText().equals("")) {
    		  lblLoiTonkho.setText("Không để trống thông tin");
    		  lblLoiTonkho.setForeground(Color.red);
    		  lblLoiTonkho.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtTonkho.requestFocus();
    		  return false; 
    	  }
    	  return true;
      }
      
      public boolean checkValidate() {
    	  if (Float.parseFloat(txtGiaban.getText()) < 1000) {
    			lblLoiGiaban.setText("Giá bán không được nhỏ hơn 1000");
      			lblLoiGiaban.setForeground(Color.red);
      			lblLoiGiaban.setFont(new Font("Tahoma", Font.ITALIC, 15));
      			txtGiaban.requestFocus();
      			return false;
		}
    	  
    	return true;
      }
      
      HangHoa getForm() {
      	HangHoa hh = new HangHoa();
      	hh.setMaHH(txtMaHH.getText());
      	hh.setTenHH(txtTenHH.getText());
      	hh.setDVT(txtDVT.getText());
      	hh.setGia(Float.valueOf(txtGiaban.getText()));
      	hh.setTonkho(Integer.valueOf(txtTonkho.getText()));
      	hh.setMaLH(txtMaLH.getText());
      	return hh;
      }
      
      void clearForm() {
          HangHoa hh = new HangHoa();
          setFormClean(hh);
          lblLoiMaHH.setText("");
          lblLoiTenhang.setText("");
          lblLoiDVT.setText("");
          lblLoiGiaban.setText("");
          lblLoiTonkho.setText("");
        }
      
      void setFormClean(HangHoa hh) {
    	  	txtMaHH.setText("");
    	    txtTenHH.setText("");
    	    txtDVT.setText("");
    	    txtGiaban.setText("");
    	    txtTonkho.setText("");
    	    txtMaLH.setText("");
      }
}

