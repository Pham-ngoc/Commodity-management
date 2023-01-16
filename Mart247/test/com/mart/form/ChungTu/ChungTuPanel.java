package com.mart.form.ChungTu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mart.dao.ChungTuDAO;
import com.mart.dao.NhaNCCDAO;
import com.mart.entity.ChungTu;
import com.mart.entity.NhaCC;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChungTuPanel extends JPanel {
	private static JTable tbChungtu;
	private static JComboBox cbxTim;
	
	private static ChungTuDAO ctdao = new ChungTuDAO();
	private static NhaNCCDAO nccdao = new NhaNCCDAO();
	DefaultComboBoxModel<String> cbx = new DefaultComboBoxModel<>();
	int row;

	/**
	 * Create the panel.
	 */
	public ChungTuPanel() {
		initComponents();
		init();
	}
	
	public void initComponents() {
		setLayout(null);
		
		JLabel lblChngT = new JLabel("CHỨNG TỪ");
		lblChngT.setBounds(363, 0, 163, 46);
		lblChngT.setHorizontalAlignment(SwingConstants.CENTER);
		lblChngT.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblChngT);
		
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
		
		tbChungtu = new JTable();
		tbChungtu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				      row = tbChungtu.getSelectedRow();
				      edit();
				    } 
			}
		});
		tbChungtu.setModel(new DefaultTableModel(
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
				"Mã chứng từ", "Tên chứng từ", "Nội dung", "Ghi chú", "Nhà cung cấp"
			}
		){
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
		scrollPane_1.setViewportView(tbChungtu);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaCTFrame ct = new ChinhsuaCTFrame();
				ct.setVisible(true);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhà cung cấp: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 51, 114, 35);
		add(lblNewLabel_1_1);
		
		cbxTim = new JComboBox();
		cbxTim.setBounds(114, 51, 725, 35);
		cbxTim.setModel(cbx);
		add(cbxTim);		
	}
	public void init() {
		row = -1;
		fillComboxNCC();
		fillDanhSachCT();
	}
	
	public void fillComboxNCC() {
		cbx.removeAllElements();
		List<NhaCC> list = nccdao.selectAll();
		for (NhaCC ncc : list) {
			cbx.addElement(String.valueOf(ncc.getTenNCC()));
		}
	}
	
	public static void fillDanhSachCT() {
	    DefaultTableModel model = (DefaultTableModel)tbChungtu.getModel();
	    model.setRowCount(0);
	    List<Object[]> list = ctdao.getDanhSachCT();
	    for (Object[] row : list)
	      model.addRow(row); 
	  }
	
	void fillDanhSachNCCtheoTenLH() {
	    DefaultTableModel model = (DefaultTableModel)this.tbChungtu.getModel();
	    model.setRowCount(0);
	    String ctu = (String)cbxTim.getSelectedItem();
	    List<Object[]> list = ctdao.getDanhSachCTtheoTenNCC(ctu);
	    for (Object[] row : list) {
	      model.addRow(row);
	    } 
	  }
	
	public void edit() {
//		int vctRow = tbNCC.getSelectedRow();
//		displayDetails(vctRow);
    	String mact = (String)tbChungtu.getValueAt(row, 0);
    	ChungTu ctu = ctdao.selectById(mact);
    	ChinhsuaCTFrame chungtu = new ChinhsuaCTFrame();
    	chungtu.setVisible(true);
    	chungtu.setForm(ctu);
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
    		row = tbChungtu.getRowCount() - 1;
    		edit();
    	}
    }
    
    public void next() {
		if(row < tbChungtu.getRowCount() - 1) {
			row++;
			edit();
		} else {
			row = 0;
			edit();
		}
	}
    
    public void last() {
		row = tbChungtu.getRowCount() - 1;
		edit();
	}
}
