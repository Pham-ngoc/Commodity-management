package com.mart.form.HangHoa;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mart.dao.HangHoaDAO;
import com.mart.dao.LoaiHangDAO;
import com.mart.entity.DonHang;
import com.mart.entity.HangHoa;
import com.mart.entity.LoaiHang;
import com.mart.entity.NhaCC;
import com.mart.form.NhaCC.ChinhsuaNCCFrame;
import com.mart.utils.MsgBox;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HangHoaPanel extends JPanel {
	private static JTable tbHangHoa;
	private static JComboBox cbxLoaihang;
	private static LoaiHangDAO lhdao = new LoaiHangDAO();
	private static HangHoaDAO hhdao = new HangHoaDAO();
	private static DefaultComboBoxModel<String> cb = new DefaultComboBoxModel<>();

	int row = -1;
	/**
	 * Create the panel.
	 */
	public HangHoaPanel() {
		initCompnent();
		init();
		
	}
	
	public void initCompnent() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HÀNG HÓA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(420, 0, 136, 41);
		add(lblNewLabel);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.setIcon(new ImageIcon(getClass().getResource("/com/mart/icon/plus.png")));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaHHFrame them = new ChinhsuaHHFrame();
				them.setVisible(true);
				
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(25, 546, 130, 35);
		add(btnThem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 96, 963, 440);
		add(scrollPane);
		
		tbHangHoa = new JTable();
		tbHangHoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				      row = tbHangHoa.getSelectedRow();
				      edit();
				    }
			}
		});
		tbHangHoa.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Mã hàng hóa", "Tên hàng hóa", "Đơn vị tính", "Giá bán", "Tồn kho", "Loại hàng"
			}
		){
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
		scrollPane.setViewportView(tbHangHoa);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableTim();
//				fillTabletheoTenHH();
			}
		});
		btnTim.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(858, 51, 130, 35);
		add(btnTim);
		
		JLabel lblNewLabel_1_1 = new JLabel("Loại hàng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(25, 51, 71, 35);
		add(lblNewLabel_1_1);
		
		cbxLoaihang = new JComboBox();
		cbxLoaihang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableTim();
			}
		});
		cbxLoaihang.setBounds(106, 51, 742, 35);
		cbxLoaihang.setModel(cb);
		add(cbxLoaihang);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first();
			}
		});
		btnFirst.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\fast-backward.png"));
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFirst.setBounds(766, 546, 48, 35);
		add(btnFirst);
		
		JButton btnPrev = new JButton("");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		btnPrev.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\back-button.png"));
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrev.setBounds(824, 546, 48, 35);
		add(btnPrev);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\next-button.png"));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(882, 546, 48, 35);
		add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		btnLast.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\last-backward.png"));
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLast.setBounds(940, 546, 48, 35);
		add(btnLast);
	}
	
	public void init() {
		fillComboxLoaihang();
		fillTableHangHoa();
	}
	public void fillComboxLoaihang() {
		cb.removeAllElements();
		List<LoaiHang> list = lhdao.selectAll();
		for (LoaiHang lhang : list) {
//			System.out.println(lhang);
			cb.addElement(String.valueOf(lhang.getTenLH())); 
		}
	}
	
	public static void fillTableHangHoa() {
	    DefaultTableModel model = (DefaultTableModel)tbHangHoa.getModel();
	    model.setRowCount(0);
	    List<Object[]> list = hhdao.getDanhSach();
	    for (Object[] row : list)
	      model.addRow(row); 
	  }
	  
	void fillTableTim() {
	    DefaultTableModel model = (DefaultTableModel)this.tbHangHoa.getModel();
	    model.setRowCount(0);
	    String lh = (String) cbxLoaihang.getSelectedItem();
	    List<Object[]> list = this.hhdao.getDSTheoLoai(lh);
	    for (Object[] row : list) {
	      model.addRow(row);
	    } 
	}
	
//	public void fillTabletheoTenHH() {
//		DefaultTableModel model = (DefaultTableModel)this.tbHangHoa.getModel();
//	    model.setRowCount(0);
//	    String tenhh = txtTimTenhang.getText();
//	    List<Object[]> list = this.hhdao.getDSTheoHH(tenhh);
//		for (Object[] row : list) {
//		   model.addRow(row);
//		} 
//	}
	
	public void edit() {
//		int vctRow = tbNCC.getSelectedRow();
//		displayDetails(vctRow);
    	String mahh = (String)tbHangHoa.getValueAt(row, 0); // lấy cột mã hàng hóa
    	HangHoa hh = hhdao.selectById(mahh);
    	ChinhsuaHHFrame cshh = new ChinhsuaHHFrame();
    	cshh.setVisible(true);
    	cshh.setForm(hh);
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
    		row = tbHangHoa.getRowCount() - 1;
    		edit();
    	}
    }
    
    public void next() {
		if(row < tbHangHoa.getRowCount() - 1) {
			row++;
			edit();
		} else {
			row = 0;
			edit();
		}
	}
    
    public void last() {
		row = tbHangHoa.getRowCount() - 1;
		edit();
	}
}
