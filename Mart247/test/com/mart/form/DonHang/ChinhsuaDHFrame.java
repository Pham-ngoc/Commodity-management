package com.mart.form.DonHang;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.DonHangDAO;
import com.mart.dao.NhanVienDAO;
import com.mart.entity.DonHang;
import com.mart.entity.HangHoa;
import com.mart.entity.NhanVien;
import com.mart.form.ChiTieu.ChiTieuPanel;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;
import com.raven.datechooser.DateChooser;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ChinhsuaDHFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaDH;
	private static JTextField txtNgayban;
	private static JTextField txtTonggia;
	private JLabel lblLoiMaDH;
	private JLabel lblLoiNgayban;
	private JLabel lblLoiTonggia;
	private JLabel lblLoiPTTT;
	private JLabel lblLoiMaNV;
	private static JComboBox cbxMaNV;
	private static JComboBox cbxPTTT;
	
	DefaultComboBoxModel<String> cbx = new DefaultComboBoxModel<>();
	DateChooser dateDH = new DateChooser();
	DonHangDAO dhdao = new DonHangDAO();
	NhanVienDAO nvdao = new NhanVienDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuaDHFrame frame = new ChinhsuaDHFrame();
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
	public ChinhsuaDHFrame() {
		initCompnent();
		init();
	}
	
	public void initCompnent() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 771, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHngHa = new JLabel("ĐƠN HÀNG");
		lblHngHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngHa.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHngHa.setBounds(299, 0, 195, 60);
		contentPane.add(lblHngHa);
		
		txtMaDH = new JTextField();
		txtMaDH.setColumns(10);
		txtMaDH.setBounds(191, 81, 553, 32);
		contentPane.add(txtMaDH);
		
		JLabel lblNewLabel_1 = new JLabel("Mã đơn hàng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 81, 129, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày bán:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 144, 129, 32);
		contentPane.add(lblNewLabel_1_1);
		
		lblLoiMaDH = new JLabel("");
		lblLoiMaDH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiMaDH.setBounds(191, 116, 344, 19);
		contentPane.add(lblLoiMaDH);
		
		txtNgayban = new JTextField();
		txtNgayban.setColumns(10);
		txtNgayban.setBounds(191, 144, 553, 32);
		dateDH.setTextField(txtNgayban);
		contentPane.add(txtNgayban);
		
		lblLoiNgayban = new JLabel("");
		lblLoiNgayban.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiNgayban.setBounds(191, 179, 344, 19);
		contentPane.add(lblLoiNgayban);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tổng giá:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 208, 129, 32);
		contentPane.add(lblNewLabel_1_2);
		
		txtTonggia = new JTextField();
		txtTonggia.setColumns(10);
		txtTonggia.setBounds(191, 208, 553, 32);
		contentPane.add(txtTonggia);
		
		lblLoiTonggia = new JLabel("");
		lblLoiTonggia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiTonggia.setBounds(191, 243, 344, 19);
		contentPane.add(lblLoiTonggia);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phương thức thanh toán:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 269, 171, 32);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Người bán: ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(10, 330, 129, 32);
		contentPane.add(lblNewLabel_1_4);
		
		lblLoiPTTT = new JLabel("");
		lblLoiPTTT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiPTTT.setBounds(191, 304, 344, 19);
		contentPane.add(lblLoiPTTT);
		
		lblLoiMaNV = new JLabel("");
		lblLoiMaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiMaNV.setBounds(191, 365, 344, 19);
		contentPane.add(lblLoiMaNV);
		
		JButton btnThem = new JButton("Thêm ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(191, 407, 114, 35);
		contentPane.add(btnThem);
		
		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(315, 407, 114, 35);
		contentPane.add(btnCapnhat);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(439, 407, 114, 35);
		contentPane.add(btnXoa);
		
		JButton btnLammoi = new JButton("Làm mới");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLammoi.setBounds(563, 407, 114, 35);
		contentPane.add(btnLammoi);
		
		cbxMaNV = new JComboBox();
		cbxMaNV.setBounds(191, 330, 553, 32);
		cbxMaNV.setModel(cbx);
		contentPane.add(cbxMaNV);
		
		cbxPTTT = new JComboBox();
		cbxPTTT.setBounds(191, 269, 553, 32);
		cbxPTTT.setModel(new DefaultComboBoxModel(new String[] {"Tiền mặt", "Thẻ ngân hàng", "Ví Momo", "Ví Shoppepay", "Ví Zalopay", "Ví VNPay"}));
		contentPane.add(cbxPTTT);
		
		setLocationRelativeTo(null);		
	}
	public void init(){
		fillComboboxNhanvien();
	}
	
	public void fillComboboxNhanvien() {
		cbx.removeAllElements();
		List<NhanVien> list = nvdao.selectAll();
		for (NhanVien nhanVien : list) {
				cbx.addElement(nhanVien.getMaNV());
		}
	}
	
	void insert() {
    	if(checkNull() == true && checkValidate() == true) {
	  	    DonHang ct = getForm();
	  	    try {
	  	      this.dhdao.insert(ct);
//	  	      System.out.println(XDate.toString(kh.getNgaysinh(), "MM/dd/yyyy"));
	  	      DonHangPanel.fillTable();
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
	        DonHang model = getForm();
	        try {
	          this.dhdao.update(model);
	          DonHangPanel.fillTable();
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
	        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa đơn hàng này?")) {
	          String madh = txtMaDH.getText();
	          try {
	            this.dhdao.delete(madh);
	            DonHangPanel.fillTable();
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
    	  if (txtMaDH.getText().equals("")) {
    		  lblLoiMaDH.setText("Không để trống thông tin");
    		  lblLoiMaDH.setForeground(Color.red);
    		  lblLoiMaDH.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtMaDH.requestFocus();
    		  return false;
    	  } else if (txtNgayban.getText().equals("")) {
    		  lblLoiNgayban.setText("Không để trống thông tin");
    		  lblLoiNgayban.setForeground(Color.red);
    		  lblLoiNgayban.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtNgayban.requestFocus();
    		  return false;
    	  } else if (txtTonggia.getText().equals("")) {
    		  lblLoiTonggia.setText("Không để trống thông tin");
    		  lblLoiTonggia.setForeground(Color.red);
    		  lblLoiTonggia.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtTonggia.requestFocus();
    		  return false; 
    	  } else if(String.valueOf(cbxPTTT.getSelectedItem()).equals("")){
        		lblLoiPTTT.setText("Không để trống thông tin");
          		lblLoiPTTT.setForeground(Color.red);
          		lblLoiPTTT.setFont(new Font("Tahoma", Font.ITALIC, 15));
          		return false;
          } else if(String.valueOf(cbxMaNV.getSelectedItem()).equals("")){
      		lblLoiMaNV.setText("Không để trống thông tin");
      		lblLoiMaNV.setForeground(Color.red);
      		lblLoiMaNV.setFont(new Font("Tahoma", Font.ITALIC, 15));
      		return false;
      } 
    	  return true;
      }
      
      public boolean checkValidate() {
    	  if (Float.parseFloat(txtTonggia.getText()) < 1000) {
  			lblLoiTonggia.setText("Số tiền không được nhỏ hơn 1000");
  			lblLoiTonggia.setForeground(Color.red);
  			lblLoiTonggia.setFont(new Font("Tahoma", Font.ITALIC, 15));
  			txtTonggia.requestFocus();
  			return false;
  		  }
    	  
    	return true;
      }
      
      
    public static void setForm(DonHang dh) {
    	try {
	        txtMaDH.setText(dh.getMaDH());
	        txtNgayban.setText(dh.getNgayban());
	        txtTonggia.setText(String.valueOf(dh.getTonggia()));
	        cbxPTTT.setSelectedItem(dh.getPTTT());
	        cbxMaNV.setSelectedItem(dh.getMaNV());
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
      }
    
    DonHang getForm() {
    	DonHang dh = new DonHang();
    	dh.setMaDH(txtMaDH.getText());
    	dh.setNgayban(txtNgayban.getText());
    	dh.setTonggia(Float.parseFloat(txtTonggia.getText()));
    	dh.setPTTT(String.valueOf(cbxPTTT.getSelectedItem()));
    	dh.setMaNV(String.valueOf(cbxMaNV.getSelectedItem()));
    	return dh;
    }
    
    void clearForm() {
        DonHang dh = new DonHang();
        setFormClean(dh);
        lblLoiMaDH.setText("");
        lblLoiNgayban.setText("");
        lblLoiTonggia.setText("");
        lblLoiPTTT.setText("");
        lblLoiMaNV.setText("");
      }
    
    void setFormClean(DonHang dh) {
  	  	txtMaDH.setText("");
  	    txtNgayban.setText("");
  	    txtTonggia.setText("");
    }
}
