package com.mart.form.HangHuy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.HangDatDAO;
import com.mart.dao.HangHoaDAO;
import com.mart.dao.HangHuyDAO;
import com.mart.entity.HangDat;
import com.mart.entity.HangHoa;
import com.mart.entity.HangHuy;
import com.mart.form.HangDat.HangDatPanel;
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
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChinhsuaHHuyFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaHH;
	private static JTextField txtSoluong;
	private static JTextField txtNgay;
	private static DateChooser dateHuy = new DateChooser();
	private static JComboBox cbxTenHH;
	private JLabel lblLoiNgayhuy;
	private JLabel lblLoiSoluong;
	
	private DefaultComboBoxModel<String> dcb = new DefaultComboBoxModel<String>();
	private static HangHoaDAO hhdao = new HangHoaDAO();
	private static HangHuyDAO hhuydao = new HangHuyDAO();
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
					ChinhsuaHHuyFrame frame = new ChinhsuaHHuyFrame();
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
	public ChinhsuaHHuyFrame() {
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
		
		JLabel lblHyHng = new JLabel("H???Y H??NG");
		lblHyHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblHyHng.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHyHng.setBounds(292, 0, 170, 60);
		contentPane.add(lblHyHng);
		
		JLabel lblNewLabel_1 = new JLabel("M?? h??ng h??a: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 80, 114, 28);
		contentPane.add(lblNewLabel_1);
		
		txtMaHH = new JTextField();
		txtMaHH.setColumns(10);
		txtMaHH.setBounds(131, 76, 141, 32);
		contentPane.add(txtMaHH);
		
		JLabel lblNewLabel_1_1 = new JLabel("S??? l?????ng h???y: ");
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
		
		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(131, 205, 595, 32);
		txtNgay.setText(date);
		dateHuy.setTextField(txtNgay);
		contentPane.add(txtNgay);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ng??y h???y: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 209, 114, 28);
		contentPane.add(lblNewLabel_1_1_1);
		
		lblLoiNgayhuy = new JLabel("");
		lblLoiNgayhuy.setForeground(Color.RED);
		lblLoiNgayhuy.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiNgayhuy.setBounds(131, 243, 308, 19);
		contentPane.add(lblLoiNgayhuy);
		
		JButton btnThem = new JButton("Th??m ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(131, 289, 114, 35);
		contentPane.add(btnThem);
		
		JButton btnCapnhat = new JButton("C???p nh???t");
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(255, 289, 114, 35);
		contentPane.add(btnCapnhat);
		
		JButton btnXoa = new JButton("Xo??");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(379, 289, 114, 35);
		contentPane.add(btnXoa);
		
		JButton btnLammoi = new JButton("L??m m???i");
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
		cbxTenHH.setBounds(282, 76, 444, 32);
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
	
	public static void setForm(HangHuy hhuy) {
		List<HangHoa> hh = hhdao.selectAll();;
		try {
	        txtMaHH.setText(hhuy.getMaHH());
	        txtSoluong.setText(String.valueOf(hhuy.getSoluongHuy()));
	        txtNgay.setText(hhuy.getNgayhuy());
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
	  	    HangHuy hd = getForm();
	  	    try {
	  	      this.hhuydao.insert(hd);
	  	      HangHuyPanel.fillTableHangHuy();
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
	        HangHuy model = getForm();
	        try {
	          this.hhuydao.update(model);
	          HangHuyPanel.fillTableHangHuy();
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
	        if (MsgBox.confirm(this, "B???n th???c s??? mu???n x??a h??ng h???y n??y?")) {
	          String mahd = txtMaHH.getText();
	          try {
	            this.hhuydao.delete(mahd);
	            HangHuyPanel.fillTableHangHuy();
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
    	  if (txtSoluong.getText().equals("")) {
    		  lblLoiSoluong.setText("Kh??ng ????? tr???ng th??ng tin");
    		  lblLoiSoluong.setForeground(Color.red);
    		  lblLoiSoluong.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtSoluong.requestFocus();
    		  return false;
    	  } else if (txtNgay.getText().equals("")) {
    		  lblLoiNgayhuy.setText("Kh??ng ????? tr???ng th??ng tin");
    		  lblLoiNgayhuy.setForeground(Color.red);
    		  lblLoiNgayhuy.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtNgay.requestFocus();
    		  return false; 
    	  } 
    	  return true;
      }
      
      public boolean checkValidate() {
    	   if(Integer.parseInt(txtSoluong.getText()) < 1){
  			lblLoiSoluong.setText("S??? l?????ng h??ng ?????t kh??ng ???????c nh??? h??n 1");
  			lblLoiSoluong.setForeground(Color.red);
  			lblLoiSoluong.setFont(new Font("Tahoma", Font.ITALIC, 15));
  			txtSoluong.requestFocus();
  			return false;
		}
    	  
    	return true;
      }
      
      HangHuy getForm() {
      	HangHuy hhuy = new HangHuy();
      	hhuy.setMaHH(txtMaHH.getText());
      	hhuy.setSoluongHuy(Integer.parseInt(txtSoluong.getText()));
      	hhuy.setNgayhuy(txtNgay.getText());
      	return hhuy;
      }
      
      void clearForm() {
          HangHuy hhuy = new HangHuy();
          setFormClean(hhuy);
          lblLoiSoluong.setText("");
          lblLoiNgayhuy.setText("");
        }
      
      void setFormClean(HangHuy hhuy) {
    	  	txtMaHH.setText("");
    	    txtSoluong.setText("");
    	    txtNgay.setText("");
      }
}
