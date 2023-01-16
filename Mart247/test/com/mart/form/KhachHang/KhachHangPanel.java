package com.mart.form.KhachHang;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mart.dao.KhachHangDAO;
import com.mart.entity.KhachHang;
import com.mart.main.Main;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KhachHangPanel extends JPanel {
	public static JTable tbKhachHang;
	public static JTextField txtTimkiem;
	int row = -1;
	public static KhachHangDAO khdao = new KhachHangDAO();
	private static DefaultTableModel tb = new DefaultTableModel();

	/**
	 * Create the panel.
	 */    
	
	public KhachHangPanel() {
		initComponents();
	    init();
	}
	
	public void initComponents() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(395, 0, 170, 47);
		add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 106, 969, 426);
		add(scrollPane_1);
		
		tbKhachHang = new JTable();
		tbKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
				      row = tbKhachHang.getSelectedRow();
				      edit();
				    } 
			}
		});
		tbKhachHang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã KH", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại"
			}
		) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
//		tbKhachHang.setModel(tb);
		scrollPane_1.setViewportView(tbKhachHang);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(21, 61, 114, 35);
		add(lblNewLabel_1);
		
		txtTimkiem = new JTextField();
		txtTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimkiem.setBounds(145, 61, 705, 35);
		add(txtTimkiem);
		txtTimkiem.setColumns(10);
		
		JButton btnTimkiem = new JButton("Tìm kiếm");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tim();
			}
		});
		btnTimkiem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimkiem.setBounds(860, 61, 130, 35);
		add(btnTimkiem);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaKH cs = new ChinhsuaKH();
				cs.setVisible(true);
				cs.setLocationRelativeTo(null);
			}
		});
		btnThem.setIcon(new ImageIcon(getClass().getResource("/com/mart/icon/plus.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(21, 542, 130, 35);
		add(btnThem);
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		btnLast.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\next-button.png"));
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLast.setBounds(942, 542, 48, 35);
		add(btnLast);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\last-backward.png"));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(884, 542, 48, 35);
		add(btnNext);
		
		JButton btnPrev = new JButton("");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		btnPrev.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\fast-backward.png"));
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrev.setBounds(826, 542, 48, 35);
		add(btnPrev);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first();
			}
		});
		btnFirst.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\back-button.png"));
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFirst.setBounds(768, 542, 48, 35);
		add(btnFirst);

	}
	
	public void init() {
		fillTable();
	    this.row = -1;
	}
	
	public static void fillTable() {
		tb = (DefaultTableModel)tbKhachHang.getModel();
    	tb.setRowCount(0);
        try {
          List<KhachHang> list = khdao.selectAll();
          for (KhachHang kh : list) {
            Object[] row = { 
            		kh.getMaKH(), 
            		kh.getHoten(), 
            		kh.isGioitinh() ? "Nam" : "Nữ", 
//            		XDate.toString(kh.getNgaysinh(), "dd-MM-yyyy"), 
            		kh.getNgaysinh(),
            		kh.getSDT()
            		};
            tb.addRow(row);
//            System.out.println(kh.getNgaysinh());
          } 
//        	for(KhachHang kh : khdao.selectAll()) {
//    			Object rowData[] = new Object[5];
//    			rowData[0] = kh.getMaKH();
//    			rowData[1] = kh.getHoten();
//    			rowData[2] = kh.isGioitinh() ? "Nam" : "Nữ";
//    			rowData[3] = kh.getNgaysinh();
//    			rowData[4] = kh.getSDT();
//    			tb.addRow(rowData);
//    		}
        } catch (Exception e) {
          MsgBox.alert(null, "Lỗi truy vấn dữ liệu!");
        } 
    }
	
	public static void fillTableTim() {
		tb = (DefaultTableModel)tbKhachHang.getModel();
    	tb.setRowCount(0);
        try {
          String keyword = txtTimkiem.getText();
          List<KhachHang> list = khdao.selectByKeyword(keyword);
          for (KhachHang kh : list) {
            Object[] row = { 
            		kh.getMaKH(), 
            		kh.getHoten(), 
            		kh.isGioitinh() ? "Nam" : "Nữ", 
//            		XDate.toString(kh.getNgaysinh(), "dd-MM-yyyy"), 
            		kh.getNgaysinh(),
            		kh.getSDT()
            		};
            tb.addRow(row);
          }
        } catch (Exception e) {
          MsgBox.alert(null, "Lỗi truy vấn dữ liệu!");
        } 
    }
	
	void first() {
	    this.row = 0;
	    edit();
	  }
	  
	  void prev() {
	    if (this.row > 0) {
	      this.row--;
	      edit();
	    } 
	  }
	  
	  void next() {
	    if (this.row < this.tbKhachHang.getRowCount() - 1) {
	      this.row++;
	      edit();
	    } 
	  }
	  
	  void last() {
	    this.row = this.tbKhachHang.getRowCount() - 1;
	    edit();
	  }
	  
	  void edit() {
		    String manh = (String)this.tbKhachHang.getValueAt(this.row, 0);
		    KhachHang kh = this.khdao.selectById(manh);
		    ChinhsuaKH chinhsua = new ChinhsuaKH();
		    chinhsua.setVisible(true);
		    chinhsua.setForm(kh);
	  }
	  
	  public void tim() {
		  fillTableTim();
	  }
}
