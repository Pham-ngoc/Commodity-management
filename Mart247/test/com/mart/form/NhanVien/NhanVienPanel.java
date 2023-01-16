package com.mart.form.NhanVien;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mart.dao.NhanVienDAO;
import com.mart.entity.KhachHang;
import com.mart.entity.NhanVien;
import com.mart.form.KhachHang.ChinhsuaKH;
import com.mart.utils.MsgBox;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NhanVienPanel extends JPanel {
	private static JTextField txtTimkiem;
	private static JTable tbNhanVien;
	private static NhanVienDAO nvdao = new NhanVienDAO();
	int row;

	/**
	 * Create the panel.
	 */
	
	public NhanVienPanel() {
		initComponents();
	    init();

	}
	public void initComponents(){
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(363, 0, 163, 57);
		add(lblNewLabel);
		
		txtTimkiem = new JTextField();
		txtTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimkiem.setColumns(10);
		txtTimkiem.setBounds(134, 51, 705, 35);
		add(txtTimkiem);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 51, 114, 35);
		add(lblNewLabel_1);
		
		JButton btnTimkiem = new JButton("Tìm kiếm");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableTim();
			}
		});
		btnTimkiem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimkiem.setBounds(849, 51, 130, 35);
		add(btnTimkiem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 96, 969, 426);
		add(scrollPane_1);
		
		tbNhanVien = new JTable();
		tbNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				      row = tbNhanVien.getSelectedRow();
				      edit();
				    } 
			}
		});
		tbNhanVien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Mã nhân viên", "Họ và tên", "Email", "Mật khẩu", "Vai trò"
			}
		) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
		scrollPane_1.setViewportView(tbNhanVien);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaNVFrame nv = new ChinhsuaNVFrame();
				nv.setVisible(true);
			}
		});
		btnThem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\plus.png"));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(10, 532, 130, 35);
		add(btnThem);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first();
			}
		});
		btnFirst.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\fast-backward.png"));
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFirst.setBounds(757, 532, 48, 35);
		add(btnFirst);
		
		JButton btnPrev = new JButton("");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		btnPrev.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\back-button.png"));
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrev.setBounds(815, 532, 48, 35);
		add(btnPrev);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\next-button.png"));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(873, 532, 48, 35);
		add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		btnLast.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\last-backward.png"));
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLast.setBounds(931, 532, 48, 35);
		add(btnLast);
	}
    public void init(){
    	fillTable();
    	row = -1;
    }
    
    public static void fillTable() {
    	DefaultTableModel tb = (DefaultTableModel)tbNhanVien.getModel();
    	tb.setRowCount(0);
    	try {
			List<NhanVien> list =  nvdao.selectAll();
			for (NhanVien nv : list) {
				Object[] row = {
						nv.getMaNV(),
						nv.getHoten(),
						nv.getEmail(),
						nv.getMatkhau(),
						nv.isVaitro() ? "Trưởng cửa hàng" : "Nhân viên"
				};
				tb.addRow(row);
			}
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi truy vấn dữ liệu!");
		}
    }
    
    public static void fillTableTim() {
    	DefaultTableModel tb = (DefaultTableModel)tbNhanVien.getModel();
    	tb.setRowCount(0);
    	try {
			String keyword = txtTimkiem.getText();
			List<NhanVien> list =  nvdao.selectByKeyword(keyword);
			for (NhanVien nv : list) {
				Object[] row = {
						nv.getMaNV(),
						nv.getHoten(),
						nv.getEmail(),
						nv.getMatkhau(),
						nv.isVaitro() ? "Trưởng cửa hàng" : "Nhân viên"
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
	    if (this.row < this.tbNhanVien.getRowCount() - 1) {
	      this.row++;
	      edit();
	    } 
	  }
	  
	  void last() {
	    this.row = this.tbNhanVien.getRowCount() - 1;
	    edit();
	  }
	  
	  void edit() {
		    String manh = (String)this.tbNhanVien.getValueAt(this.row, 0);
		    NhanVien nv = this.nvdao.selectById(manh);
		    ChinhsuaNVFrame chinhsua = new ChinhsuaNVFrame();
		    chinhsua.setVisible(true);
		    chinhsua.setForm(nv);
	  }
}
