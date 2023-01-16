package com.mart.form.ThietBi;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.mart.dao.NhanVienDAO;
import com.mart.dao.ThietBiDAO;
import com.mart.entity.NhanVien;
import com.mart.entity.ThietBi;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;
import com.raven.datechooser.DateChooser;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ChinhsuaTBFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField txtMaTB;
	private static JTextField txtTenTB;
	private static JTextField txtNgayBaotri;
	private static JTextField txtSoluong;
	private static JTextField txtNoidung;
	private static JTextArea txaGhichu;
	private static JComboBox cbxMaNV;
	private JLabel lblLoiMaTB;
	private JLabel lblLoiTenTB;
	private JLabel lblLoiNgaybaotri;
	private JLabel lblLoiSoluong;
	private JLabel lblLoiNoidung;
	
	DefaultComboBoxModel<String> cbx = new DefaultComboBoxModel<>();
	DateChooser dateTB = new DateChooser();
	NhanVienDAO nvdao = new NhanVienDAO();
	ThietBiDAO tbdao = new ThietBiDAO();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLaf.registerCustomDefaultsSource("com.mart.style");
		FlatIntelliJLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChinhsuaTBFrame frame = new ChinhsuaTBFrame();
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
	public ChinhsuaTBFrame() {
		initCompnent();
		init();
	}
	
	public void initCompnent() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 773, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHngHa = new JLabel("THIẾT BỊ");
		lblHngHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngHa.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHngHa.setBounds(325, 0, 152, 60);
		contentPane.add(lblHngHa);
		
		txtMaTB = new JTextField();
		txtMaTB.setColumns(10);
		txtMaTB.setBounds(149, 81, 595, 32);
		contentPane.add(txtMaTB);
		
		JLabel lblNewLabel_1 = new JLabel("Mã thiết bị: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 81, 129, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên thiết bị: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 144, 129, 32);
		contentPane.add(lblNewLabel_1_1);
		
		lblLoiMaTB = new JLabel("");
		lblLoiMaTB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiMaTB.setBounds(149, 116, 386, 19);
		contentPane.add(lblLoiMaTB);
		
		txtTenTB = new JTextField();
		txtTenTB.setColumns(10);
		txtTenTB.setBounds(149, 144, 595, 32);
		contentPane.add(txtTenTB);
		
		lblLoiTenTB = new JLabel("");
		lblLoiTenTB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiTenTB.setBounds(149, 179, 386, 19);
		contentPane.add(lblLoiTenTB);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày bảo trì:  ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 208, 129, 32);
		contentPane.add(lblNewLabel_1_2);
		
		txtNgayBaotri = new JTextField();
		txtNgayBaotri.setColumns(10);
		txtNgayBaotri.setBounds(149, 208, 595, 32);
		dateTB.setTextField(txtNgayBaotri);
		contentPane.add(txtNgayBaotri);
		
		lblLoiNgaybaotri = new JLabel("");
		lblLoiNgaybaotri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiNgaybaotri.setBounds(149, 243, 386, 19);
		contentPane.add(lblLoiNgaybaotri);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số lượng:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 269, 129, 32);
		contentPane.add(lblNewLabel_1_3);
		
		txtSoluong = new JTextField();
		txtSoluong.setColumns(10);
		txtSoluong.setBounds(149, 269, 595, 32);
		contentPane.add(txtSoluong);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nội dung: ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(10, 330, 129, 32);
		contentPane.add(lblNewLabel_1_4);
		
		lblLoiSoluong = new JLabel("");
		lblLoiSoluong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiSoluong.setBounds(149, 304, 386, 19);
		contentPane.add(lblLoiSoluong);
		
		txtNoidung = new JTextField();
		txtNoidung.setColumns(10);
		txtNoidung.setBounds(149, 330, 595, 32);
		contentPane.add(txtNoidung);
		
		lblLoiNoidung = new JLabel("");
		lblLoiNoidung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoiNoidung.setBounds(149, 365, 386, 19);
		contentPane.add(lblLoiNoidung);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Ghi chú: ");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_1.setBounds(10, 388, 129, 32);
		contentPane.add(lblNewLabel_1_4_1);
		
		JButton btnThem = new JButton("Thêm ");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(149, 577, 114, 35);
		contentPane.add(btnThem);
		
		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCapnhat.setBounds(273, 577, 114, 35);
		contentPane.add(btnCapnhat);
		
		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(397, 577, 114, 35);
		contentPane.add(btnXoa);
		
		JButton btnLammoi = new JButton("Làm mới");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLammoi.setBounds(521, 577, 114, 35);
		contentPane.add(btnLammoi);
		
		txaGhichu = new JTextArea();
		txaGhichu.setBounds(149, 394, 595, 95);
		contentPane.add(txaGhichu);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Mã nhân viên: ");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_2.setBounds(10, 517, 129, 32);
		contentPane.add(lblNewLabel_1_4_2);
		
		cbxMaNV = new JComboBox();
		cbxMaNV.setBounds(149, 517, 595, 32);
		cbxMaNV.setModel(cbx);
		contentPane.add(cbxMaNV);
		
		setLocationRelativeTo(null);		
	}
	public void init() {
		fillComboboxNhanvien();
		dateTB.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
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
	  	    ThietBi ct = getForm();
	  	    try {
	  	      this.tbdao.insert(ct);
//	  	      System.out.println(XDate.toString(kh.getNgaysinh(), "MM/dd/yyyy"));
	  	      ThietBiPanel.fillTable();
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
	        ThietBi model = getForm();
	        try {
	          this.tbdao.update(model);
	          ThietBiPanel.fillTable();
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
	        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa thiết bị này?")) {
	          String tbi = txtMaTB.getText();
	          try {
	            this.tbdao.delete(tbi);
	            ThietBiPanel.fillTable();
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
    	  if (txtMaTB.getText().equals("")) {
    		  lblLoiMaTB.setText("Không để trống thông tin");
    		  lblLoiMaTB.setForeground(Color.red);
    		  lblLoiMaTB.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtMaTB.requestFocus();
    		  return false;
    	  } else if (txtTenTB.getText().equals("")) {
    		  lblLoiTenTB.setText("Không để trống thông tin");
    		  lblLoiTenTB.setForeground(Color.red);
    		  lblLoiTenTB.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtTenTB.requestFocus();
    		  return false;
    	  } else if (txtNgayBaotri.getText().equals("")) {
    		  lblLoiNgaybaotri.setText("Không để trống thông tin");
    		  lblLoiNgaybaotri.setForeground(Color.red);
    		  lblLoiNgaybaotri.setFont(new Font("Tahoma", Font.ITALIC, 15));
    		  txtNgayBaotri.requestFocus();
    		  return false; 
    	  } else if(txtSoluong.getText().equals("")){
        		lblLoiSoluong.setText("Không để trống thông tin");
          		lblLoiSoluong.setForeground(Color.red);
          		lblLoiSoluong.setFont(new Font("Tahoma", Font.ITALIC, 15));
          		txtSoluong.requestFocus();
          		return false;
          } else if(txtNoidung.getText().equals("")){
      		lblLoiNoidung.setText("Không để trống thông tin");
      		lblLoiNoidung.setForeground(Color.red);
      		lblLoiNoidung.setFont(new Font("Tahoma", Font.ITALIC, 15));
      		txtNoidung.requestFocus();
      		return false;
      } 
    	  return true;
      }
      
      public boolean checkValidate() {
    	  if (Integer.parseInt(txtSoluong.getText()) < 1) {
  			lblLoiSoluong.setText("Số lượng phải lớn hơn hoặc bằng 0");
  			lblLoiSoluong.setForeground(Color.red);
  			lblLoiSoluong.setFont(new Font("Tahoma", Font.ITALIC, 15));
  			txtSoluong.requestFocus();
  			return false;
  		  }
    	  
    	return true;
      }
      
      
    public static void setForm(ThietBi tbi) {
    	try {
	        txtMaTB.setText(tbi.getMaTB());
	        txtTenTB.setText(tbi.getTenTB());
	        txtNgayBaotri.setText(tbi.getNgaybaotri());
	        txtSoluong.setText(String.valueOf(tbi.getSoluong()));
	        txtNoidung.setText(tbi.getNoidung());
	        txaGhichu.setText(tbi.getGhichu());
	        cbxMaNV.setSelectedItem(tbi.getMaNV());
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
      }
    
    ThietBi getForm() {
    	ThietBi tbi = new ThietBi();
    	tbi.setMaNV(txtMaTB.getText());
    	tbi.setTenTB(txtTenTB.getText());
    	tbi.setNgaybaotri(txtNgayBaotri.getText()); //soluong, noidung, ghichu
    	tbi.setSoluong(Integer.parseInt(txtSoluong.getText()));
    	tbi.setNoidung(txtNoidung.getText());
    	tbi.setGhichu(txaGhichu.getText());
    	tbi.setMaNV(String.valueOf(cbxMaNV.getSelectedItem()));
    	return tbi;
    }
    
    void clearForm() {
        ThietBi tbi = new ThietBi();
        setFormClean(tbi);
        lblLoiMaTB.setText("");
        lblLoiTenTB.setText("");
        lblLoiNgaybaotri.setText("");
        lblLoiSoluong.setText("");
        lblLoiNoidung.setText("");
      }
    
    void setFormClean(ThietBi tbi) {
  	  	txtMaTB.setText("");
  	    txtTenTB.setText("");
  	    txtNgayBaotri.setText("");
  	    txtNoidung.setText("");
  	    txaGhichu.setText("");
  	    txtSoluong.setText("");
    }
}
