package com.mart.form.LoaiHang;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mart.dao.LoaiHangDAO;
import com.mart.entity.DonHang;
import com.mart.entity.LoaiHang;
import com.mart.entity.NhanVien;
import com.mart.form.DonHang.ChinhsuaDHFrame;
import com.mart.utils.MsgBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoaiHangPanel extends JPanel {
	private static JTable tbLoaiHang;
	private static LoaiHangDAO lhdao = new LoaiHangDAO();	
	private static int row;
	private static DefaultComboBoxModel<String> cbx = new DefaultComboBoxModel<>();
	private static JComboBox cbxMaLH;

	/**
	 * Create the panel.
	 */
	public LoaiHangPanel() {
		setLayout(null);
		
		JLabel lblLoiHngHa = new JLabel("LOẠI HÀNG HÓA");
		lblLoiHngHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoiHngHa.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLoiHngHa.setBounds(374, 0, 225, 41);
		add(lblLoiHngHa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 963, 440);
		add(scrollPane);
		
		tbLoaiHang = new JTable();
		tbLoaiHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				      row = tbLoaiHang.getSelectedRow();
				      edit();
				    } 
			}
		});
		tbLoaiHang.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Mã loại hàng", "Tên loại hàng"
			}
		){
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
		scrollPane.setViewportView(tbLoaiHang);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaLHFrame loaihang = new ChinhsuaLHFrame();
				loaihang.setVisible(true);
			}
		});
		btnThem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\plus.png"));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(10, 546, 130, 35);
		add(btnThem);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first();
			}
		});
		btnFirst.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\fast-backward.png"));
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFirst.setBounds(751, 546, 48, 35);
		add(btnFirst);
		
		JButton btnPrev = new JButton("");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		btnPrev.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\back-button.png"));
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrev.setBounds(809, 546, 48, 35);
		add(btnPrev);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\next-button.png"));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(867, 546, 48, 35);
		add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		btnLast.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\last-backward.png"));
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLast.setBounds(925, 546, 48, 35);
		add(btnLast);
		
		JLabel lblNewLabel_1 = new JLabel("Mã loại hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 45, 107, 35);
		add(lblNewLabel_1);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTabletimTenLH();
			}
		});
		btnTim.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(843, 51, 130, 35);
		add(btnTim);
		
		cbxMaLH = new JComboBox();
		cbxMaLH.setBounds(110, 47, 718, 33);
		cbxMaLH.setModel(cbx);
		add(cbxMaLH);
		
		fillTable();
		fillComboboxLoaihang();
		row = -1;

	}
	
	public void fillComboboxLoaihang() {
    	cbx.removeAllElements();
    	List<LoaiHang> list = lhdao.selectAll();
    	for (LoaiHang loaiHang : list) {
			cbx.addElement(loaiHang.getTenLH());
		}
    }
	
	public static void fillTable() {
		DefaultTableModel tb = (DefaultTableModel)tbLoaiHang.getModel();
		tb.setRowCount(0);
		try {
//			String keyword = (String)cbxMaLH.getSelectedItem();
			List<LoaiHang> list = lhdao.selectAll();
			for (LoaiHang loaiHang : list) {
				Object[] row = {
						loaiHang.getMaLH(),
						loaiHang.getTenLH()
				};
				tb.addRow(row);
			}
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi truy vẫn dữ liệu");
		}
 	}
	
	public void fillTabletimTenLH() {
		DefaultTableModel tb = (DefaultTableModel)tbLoaiHang.getModel();
		tb.setRowCount(0);
		try {
			String keyword = (String)cbxMaLH.getSelectedItem();
			List<LoaiHang> list = lhdao.selectByKeyword(keyword);
			for (LoaiHang loaiHang : list) {
				Object[] row = {
						loaiHang.getMaLH(),
						loaiHang.getTenLH()
				};
				tb.addRow(row);
			}
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi truy vẫn dữ liệu");
		}
 	}
	
	public void edit() {
    	String malh = (String)tbLoaiHang.getValueAt(row, 0);
    	LoaiHang loaihang = lhdao.selectById(malh);
    	ChinhsuaLHFrame cslh = new ChinhsuaLHFrame();
    	cslh.setVisible(true);
    	cslh.setForm(loaihang);
    }
    
    public void first() {
    	row = 0;
    	edit();
    }
    
    public void prev() { 
    	if(row > 0) {
    		row--;
    		edit();
    	} else {
    		row = tbLoaiHang.getRowCount() - 1;
    		edit();
    	}
    }
    
    public void next() {
		if(row < tbLoaiHang.getRowCount() - 1) {
			row++;
			edit();
		} else {
			row = 0;
			edit();
		}
	}
    
    public void last() {
		row = tbLoaiHang.getRowCount() - 1;
		edit();
	}
}
