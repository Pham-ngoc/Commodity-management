package com.mart.form.ChungTu;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.ChungTuDAO;
import com.mart.dao.NhaNCCDAO;
import com.mart.entity.ChungTu;
import com.mart.entity.NhaCC;
import com.mart.form.NhaCC.NhaCCPanel;
import com.mart.utils.MsgBox;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChinhsuaCTFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaCT;
	private static JTextField txtTenCT;
	private static JTextField txtNoidung;
	private static JTextField txtMaNCC;
	JLabel lblLoiMaCT;
	JLabel lblLoiTenCT;
	JLabel lblLoiNoiDung;
	private static JComboBox cbxTenNCC;
	private static JTextArea txaGhichu;
	
	private DefaultComboBoxModel<String> dcb = new DefaultComboBoxModel<String>();
	private static NhaNCCDAO nccdao = new NhaNCCDAO();
	private static ChungTuDAO chungtudao = new ChungTuDAO();
	
	

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuaCTFrame frame = new ChinhsuaCTFrame();
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
	public ChinhsuaCTFrame() {
		init();
		initComponents();
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 778, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHngHa = new JLabel("CHỨNG TỪ");
		lblHngHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngHa.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHngHa.setBounds(288, 0, 188, 52);
		contentPane.add(lblHngHa);
		
		JLabel lblNewLabel_1 = new JLabel("Mã chứng từ: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 81, 129, 32);
		contentPane.add(lblNewLabel_1);
		
		txtMaCT = new JTextField();
		txtMaCT.setColumns(10);
		txtMaCT.setBounds(149, 81, 595, 32);
		contentPane.add(txtMaCT);
		
		lblLoiMaCT = new JLabel("");
		lblLoiMaCT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiMaCT.setBounds(149, 116, 386, 19);
		contentPane.add(lblLoiMaCT);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên chứng từ: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 144, 129, 32);
		contentPane.add(lblNewLabel_1_1);
		
		txtTenCT = new JTextField();
		txtTenCT.setColumns(10);
		txtTenCT.setBounds(149, 144, 595, 32);
		contentPane.add(txtTenCT);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nội dung:  ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 208, 129, 32);
		contentPane.add(lblNewLabel_1_2);
		
		lblLoiTenCT = new JLabel("");
		lblLoiTenCT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiTenCT.setBounds(149, 179, 386, 19);
		contentPane.add(lblLoiTenCT);
		
		txtNoidung = new JTextField();
		txtNoidung.setColumns(10);
		txtNoidung.setBounds(149, 208, 595, 32);
		contentPane.add(txtNoidung);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ghi chú:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 272, 129, 32);
		contentPane.add(lblNewLabel_1_3);
		
		lblLoiNoiDung = new JLabel("");
		lblLoiNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiNoiDung.setBounds(149, 243, 386, 19);
		contentPane.add(lblLoiNoiDung);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nhà cung cấp: ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(10, 414, 129, 32);
		contentPane.add(lblNewLabel_1_4);
		
		txtMaNCC = new JTextField();
		txtMaNCC.setEnabled(false);
		txtMaNCC.setColumns(10);
		txtMaNCC.setBounds(149, 414, 114, 32);
		contentPane.add(txtMaNCC);
		
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
		
		cbxTenNCC = new JComboBox();
		cbxTenNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMaNCC();
			}
		});
		cbxTenNCC.setBounds(273, 414, 471, 32);
		cbxTenNCC.setModel(dcb);
		contentPane.add(cbxTenNCC);
		
		txaGhichu = new JTextArea();
		txaGhichu.setBounds(149, 272, 595, 114);
		contentPane.add(txaGhichu);
		
		setLocationRelativeTo(null);		
	}
	public void init() {
		fillComboxNCC();
	}
	
	public void fillComboxNCC() {
		dcb.removeAllElements();
		List<NhaCC> list = nccdao.selectAll();
		for(NhaCC ncc : list) {
//		     cb.addElement(lh); 
//			System.out.println(lh.getTenLH());
			dcb.addElement(String.valueOf(ncc.getTenNCC()));
		}
	}
	
	public void getMaNCC() {
		List<NhaCC> list = nccdao.selectAll();
		for (NhaCC nhaCC : list) {
			if(String.valueOf(cbxTenNCC.getSelectedItem()).equals(nhaCC.getTenNCC())) {
				txtMaNCC.setText(nhaCC.getMaNCC());
			}
		}
	}
	
	void insert() {
    	if(checkNull()) {
	  	    ChungTu chungTu = getForm();
	  	    try {
	  	      this.chungtudao.insert(chungTu);
//	  	      System.out.println(XDate.toString(kh.getNgaysinh(), "MM/dd/yyyy"));
	  	      ChungTuPanel.fillDanhSachCT();
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
	        ChungTu model = getForm();
	        try {
	          this.chungtudao.update(model);
	          ChungTuPanel.fillDanhSachCT();
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
	        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa chứng từ này?")) {
	          String mact = txtMaCT.getText();
	          try {
	            this.chungtudao.delete(mact);
	            ChungTuPanel.fillDanhSachCT();
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
    	  if (txtMaCT.getText().equals("")) {
    		  lblLoiMaCT.setText("Không để trống thông tin");
    		  lblLoiMaCT.setForeground(Color.red);
    		  lblLoiMaCT.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtMaCT.requestFocus();
    		  return false;
    	  } else if (txtTenCT.getText().equals("")) {
    		  lblLoiTenCT.setText("Không để trống thông tin");
    		  lblLoiTenCT.setForeground(Color.red);
    		  lblLoiTenCT.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtTenCT.requestFocus();
    		  return false;
    	  } else if (txtNoidung.getText().equals("")) {
    		  lblLoiNoiDung.setText("Không để trống thông tin");
    		  lblLoiNoiDung.setForeground(Color.red);
    		  lblLoiNoiDung.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtNoidung.requestFocus();
    		  return false; 
    	  }
    	  return true;
      }
       
     public static void setForm(ChungTu chungTu) {
    	List<NhaCC> ncc = nccdao.selectAll();;
    	try {
	        txtMaCT.setText(chungTu.getMaCT());
	        txtTenCT.setText(chungTu.getTenCT());
	        txtNoidung.setText(chungTu.getNoidung());
	        txaGhichu.setText(chungTu.getGhichu());
	        txtMaNCC.setText(chungTu.getMaNCC());
	        for (NhaCC nhaCC : ncc) {
	        	if(txtMaNCC.getText().equals(nhaCC.getMaLH())) {
		        	cbxTenNCC.setSelectedItem(nhaCC.getTenNCC());
	        	}
	        }
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
      }
    
    ChungTu getForm() {
    	ChungTu chungtu = new ChungTu();
    	chungtu.setMaCT(txtMaCT.getText());
    	chungtu.setTenCT(txtTenCT.getText());
    	chungtu.setNoidung(txtNoidung.getText());
    	chungtu.setGhichu(txaGhichu.getText());
    	chungtu.setMaNCC(txtMaNCC.getText());
    	return chungtu;
    }
    
    void clearForm() {
        ChungTu chungTu = new ChungTu();
        setFormClean(chungTu);
        lblLoiMaCT.setText("");
        lblLoiTenCT.setText("");
        lblLoiNoiDung.setText("");
      }
    
    void setFormClean(ChungTu chungtu) {
  	  	txtMaCT.setText("");
  	    txtTenCT.setText("");
  	    txtNoidung.setText("");
  	    txaGhichu.setText("");
  	    txtMaNCC.setText("");
    }
}
