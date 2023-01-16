package com.mart.form.NhaCC;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.mart.dao.LoaiHangDAO;
import com.mart.dao.NhaNCCDAO;
import com.mart.entity.DonHang;
import com.mart.entity.LoaiHang;
import com.mart.entity.NhaCC;
import com.mart.form.DonHang.ChinhsuaDHFrame;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NhaCCPanel extends JPanel {
	private static JTable tbNCC;
	private static JComboBox cbxTenLH;
	
	private static LoaiHangDAO lhdao = new LoaiHangDAO();
	private static NhaNCCDAO nccdao = new NhaNCCDAO();
	DefaultComboBoxModel<String> cbx = new DefaultComboBoxModel<>();
	int row;
	private static Vector vectorRow = new Vector();

	/**
	 * Create the panel.
	 */
	public NhaCCPanel() {
		initComponents();
		init();
	}

	public void initComponents() {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên loại hàng: ");
		lblNewLabel_1.setBounds(10, 51, 114, 35);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_1);
		
		JLabel lblNhCungCp = new JLabel("NHÀ CUNG CẤP");
		lblNhCungCp.setBounds(349, 0, 192, 46);
		lblNhCungCp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhCungCp.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblNhCungCp);
		
		JButton btnTimkiem = new JButton("Tìm kiếm");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillDanhSachNCCtheoTenLH(); 
			}
		});
		btnTimkiem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTimkiem.setBounds(849, 51, 130, 35);
		btnTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnTimkiem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 96, 969, 426);
		add(scrollPane_1);
		
		tbNCC = new JTable();
		tbNCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				      row = tbNCC.getSelectedRow();
				      edit();
				    } 
			}
		});
		tbNCC.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Mã NCC", "Tên NCC", "Số điện thoại", "Loại hàng hóa"
			}
		){
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
		scrollPane_1.setViewportView(tbNCC);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaNCCFrame ncc = new ChinhsuaNCCFrame();
				ncc.setVisible(true);
			}
		});
		btnThem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\plus.png"));
		btnThem.setBounds(10, 532, 130, 35);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnThem);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first();
			}
		});
		btnFirst.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\fast-backward.png"));
		btnFirst.setBounds(757, 532, 48, 35);
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnFirst);
		
		JButton btnPrev = new JButton("");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		btnPrev.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\back-button.png"));
		btnPrev.setBounds(815, 532, 48, 35);
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnPrev);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\next-button.png"));
		btnNext.setBounds(873, 532, 48, 35);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		btnLast.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\last-backward.png"));
		btnLast.setBounds(931, 532, 48, 35);
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnLast);
		
		cbxTenLH = new JComboBox();
		cbxTenLH.setBounds(110, 51, 729, 35);
		cbxTenLH.setModel(cbx);
		add(cbxTenLH);		
	}
	public void init() {
		fillComboxLoaihang();
		fillDanhSachNCC();
		row = -1;
	}
	
	public void fillComboxLoaihang() {
		cbx.removeAllElements();
		List<LoaiHang> list = lhdao.selectAll();
		for (LoaiHang lh : list) {
			cbx.addElement(String.valueOf(lh.getTenLH()));
		}
	}
	
	public static void fillDanhSachNCC() {
	    DefaultTableModel model = (DefaultTableModel)tbNCC.getModel();
	    model.setRowCount(0);
	    List<Object[]> list = nccdao.getDanhSachNCC();
	    for (Object[] row : list)
	      model.addRow(row); 
	  }
	
	void fillDanhSachNCCtheoTenLH() {
	    DefaultTableModel model = (DefaultTableModel)this.tbNCC.getModel();
	    model.setRowCount(0);
	    String lh = (String)cbxTenLH.getSelectedItem();
	    List<Object[]> list = nccdao.getDanhSachtheoTenLH(lh);
	    for (Object[] row : list) {
	      model.addRow(row);
	    } 
	  }
	
	public void edit() {
//		int vctRow = tbNCC.getSelectedRow();
//		displayDetails(vctRow);
    	String mancc = (String)tbNCC.getValueAt(row, 0);
    	NhaCC ncc = nccdao.selectById(mancc);
    	ChinhsuaNCCFrame cs = new ChinhsuaNCCFrame();
    	cs.setVisible(true);
    	cs.setForm(ncc);
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
    		row = tbNCC.getRowCount() - 1;
    		edit();
    	}
    }
    
    public void next() {
		if(row < tbNCC.getRowCount() - 1) {
			row++;
			edit();
		} else {
			row = 0;
			edit();
		}
	}
    
    public void last() {
		row = tbNCC.getRowCount() - 1;
		edit();
	}
    
    public void displayDetails(int index) {
    		Vector vctRow = (Vector) vectorRow.get(index);
    	
    }
}
