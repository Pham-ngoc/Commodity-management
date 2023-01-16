package com.mart.form.HangDat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.HangDatDAO;
import com.mart.dao.HangHoaDAO;
import com.mart.entity.HangDat;
import com.mart.entity.HangHoa;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;
import com.raven.datechooser.DateChooser;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class ChinhsuaHDFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaHH;
	private static JTextField txtSoluong;
	private static JTextField txtNgay;
	private static JLabel lblLoiSoluong;
	private static JLabel lblLoiNgaydat;
	private static JComboBox cbxTenHH;
	private DateChooser datedathang = new DateChooser();
	
	private DefaultComboBoxModel<String> dcb = new DefaultComboBoxModel<String>();
	private static HangHoaDAO hhdao = new HangHoaDAO();
	private static HangDatDAO hddao = new HangDatDAO();
	private LocalDate localDate = LocalDate.now();
	private String date = localDate.format( DateTimeFormatter.ofPattern("dd-MM-yyyy"));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuaHDFrame frame = new ChinhsuaHDFrame();
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
	public ChinhsuaHDFrame() {
		initCompnent();
		init();
	}
	
	public void initCompnent() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHngHa = new JLabel("ĐẶT HÀNG");
		lblHngHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngHa.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHngHa.setBounds(292, 0, 170, 60);
		contentPane.add(lblHngHa);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hàng hóa: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 80, 114, 28);
		contentPane.add(lblNewLabel_1);
		
		txtMaHH = new JTextField();
		txtMaHH.setEnabled(false);
		txtMaHH.setColumns(10);
		txtMaHH.setBounds(131, 76, 141, 32);
		contentPane.add(txtMaHH);
		
		JLabel lblLoiMaHH = new JLabel("");
		lblLoiMaHH.setForeground(Color.RED);
		lblLoiMaHH.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiMaHH.setBounds(131, 114, 308, 19);
		contentPane.add(lblLoiMaHH);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số lượng đặt: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 144, 114, 28);
		contentPane.add(lblNewLabel_1_1);
		
		txtSoluong = new JTextField();
		txtSoluong.setColumns(10);
		txtSoluong.setBounds(131, 140, 595, 32);
		contentPane.add(txtSoluong);
		
		lblLoiSoluong = new JLabel("");
		lblLoiSoluong.setForeground(Color.RED);
		lblLoiSoluong.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiSoluong.setBounds(131, 178, 308, 19);
		contentPane.add(lblLoiSoluong);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày đặt: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 209, 114, 28);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(131, 205, 595, 32);
		txtNgay.setText(date);
		contentPane.add(txtNgay);
		datedathang.setTextField(txtNgay);
		
		lblLoiNgaydat = new JLabel("");
		lblLoiNgaydat.setForeground(Color.RED);
		lblLoiNgaydat.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiNgaydat.setBounds(131, 243, 308, 19);
		contentPane.add(lblLoiNgaydat);
		
		JButton btnThem = new JButton("Thêm ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(131, 289, 114, 35);
		contentPane.add(btnThem);
		
		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(255, 289, 114, 35);
		contentPane.add(btnCapnhat);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(379, 289, 114, 35);
		contentPane.add(btnXoa);
		
		JButton btnLammoi = new JButton("Làm mới");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLammoi.setBounds(503, 289, 114, 35);
		contentPane.add(btnLammoi);
		
		cbxTenHH = new JComboBox();
		cbxTenHH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMaHangHoa();
			}
		});
		cbxTenHH.setBounds(282, 76, 443, 32);
		cbxTenHH.setModel(dcb);
		contentPane.add(cbxTenHH);
		
		setLocationRelativeTo(null);		
	}
	public void init() {
		fillComboxLoaihang();
	}
	
	public void fillComboxLoaihang() {
		dcb.removeAllElements();
		List<HangHoa> list = hhdao.selectAll();
		for (HangHoa hh : list) {
//		     cb.addElement(lh); 
//			System.out.println(lh.getTenLH());
			dcb.addElement(String.valueOf(hh.getTenHH()));
		}
	}
	
	public void getMaHangHoa() {
		List<HangHoa> list = hhdao.selectAll();
		for (HangHoa hangHoa : list) {
			if(String.valueOf(cbxTenHH.getSelectedItem()).equals(hangHoa.getTenHH())) {
				txtMaHH.setText(hangHoa.getMaHH());
			}
		}
	}
	
	public static void setForm(HangDat hd) {
		List<HangHoa> hh = hhdao.selectAll();;
		try {
	        txtMaHH.setText(hd.getMaHH());
	        txtSoluong.setText(String.valueOf(hd.getSoluongDat()));
	        txtNgay.setText(hd.getNgaydat());
	        for (HangHoa hangHoa : hh) {
	        	if(txtMaHH.getText().equals(hangHoa.getMaHH())) {
		        	cbxTenHH.setSelectedItem(hangHoa.getTenHH());
	        	}
	        }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void insert() {
    	if(checkNull() == true && checkValidate() == true) {
	  	    HangDat hd = getForm();
	  	    try {
	  	      this.hddao.insert(hd);
//	  	      System.out.println(XDate.toString(kh.getNgaysinh(), "MM/dd/yyyy"));
	  	      HangDatPanel.fillTableHangDat();
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
	        HangDat model = getForm();
	        try {
	          this.hddao.update(model);
	          HangDatPanel.fillTableHangDat();;
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
	        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa hàng đặt này?")) {
	          String mahd = txtMaHH.getText();
	          try {
	            this.hddao.delete(mahd);
	            HangDatPanel.fillTableHangDat();
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
    	  if (txtSoluong.getText().equals("")) {
    		  lblLoiSoluong.setText("Không để trống thông tin");
    		  lblLoiSoluong.setForeground(Color.red);
    		  lblLoiSoluong.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtSoluong.requestFocus();
    		  return false;
    	  } else if (txtNgay.getText().equals("")) {
    		  lblLoiNgaydat.setText("Không để trống thông tin");
    		  lblLoiNgaydat.setForeground(Color.red);
    		  lblLoiNgaydat.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtNgay.requestFocus();
    		  return false; 
    	  } 
    	  return true;
      }
      
      public boolean checkValidate() {
    	   if(Integer.parseInt(txtSoluong.getText()) < 1){
  			lblLoiSoluong.setText("Số lượng hàng đặt không được nhỏ hơn 1");
  			lblLoiSoluong.setForeground(Color.red);
  			lblLoiSoluong.setFont(new Font("Tahoma", Font.ITALIC, 15));
  			txtSoluong.requestFocus();
  			return false;
		}
    	  
    	return true;
      }
      
      HangDat getForm() {
      	HangDat hd = new HangDat();
      	hd.setMaHH(txtMaHH.getText());
      	hd.setSoluongDat(Integer.parseInt(txtSoluong.getText()));
      	hd.setNgaydat(txtNgay.getText());
      	return hd;
      }
      
      void clearForm() {
          HangDat hd = new HangDat();
          setFormClean(hd);
          lblLoiSoluong.setText("");
          lblLoiNgaydat.setText("");
        }
      
      void setFormClean(HangDat hd) {
    	  	txtMaHH.setText("");
    	    txtSoluong.setText("");
    	    txtNgay.setText("");
      }
}
