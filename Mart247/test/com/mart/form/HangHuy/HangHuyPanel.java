package com.mart.form.HangHuy;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mart.dao.HangHoaDAO;
import com.mart.dao.HangHuyDAO;
import com.mart.entity.HangDat;
import com.mart.entity.HangHoa;
import com.mart.entity.HangHuy;
import com.mart.form.HangDat.ChinhsuaHDFrame;
import com.raven.datechooser.DateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

public class HangHuyPanel extends JPanel {
	private static JTable tbHangHuy;
	private static JComboBox cbxTenhang;
	
	int row = -1; 
	private JTextField txtNgay;
	private static HangHoaDAO hhdao = new HangHoaDAO();
	private static HangHuyDAO hhuydao = new HangHuyDAO();
	private static DefaultComboBoxModel<String> cb = new DefaultComboBoxModel<>();
	private DateChooser date = new DateChooser();
	/**
	 * Create the panel.
	 */
	public HangHuyPanel() {
		initCompnent();
		init();
		date.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
	}
	
	public void initCompnent() {
		setLayout(null);
		
		JLabel lblHngHy = new JLabel("HÀNG HỦY");
		lblHngHy.setBounds(405, 0, 139, 41);
		lblHngHy.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngHy.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblHngHy);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableTimNgay();
			}
		});
		btnTim.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTim.setBounds(843, 51, 130, 35);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnTim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 963, 440);
		add(scrollPane);
		
		tbHangHuy = new JTable();
		tbHangHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					row = tbHangHuy.getSelectedRow();
					edit();
				}
			}
		});
		tbHangHuy.setModel(new DefaultTableModel(
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
				"Mã hàng hóa", "Tên hàng hóa", "Số lượng hủy", "Ngày hủy", "Tổng hủy"
			}
		){
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
		scrollPane.setViewportView(tbHangHuy);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first(); 
			}
		});
		btnFirst.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\fast-backward.png"));
		btnFirst.setBounds(751, 546, 48, 35);
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnFirst);
		
		JButton btnPrev = new JButton("");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		btnPrev.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\back-button.png"));
		btnPrev.setBounds(809, 546, 48, 35);
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnPrev);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\next-button.png"));
		btnNext.setBounds(867, 546, 48, 35);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		btnLast.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\last-backward.png"));
		btnLast.setBounds(925, 546, 48, 35);
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnLast);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaHHuyFrame huyhang = new ChinhsuaHHuyFrame();
				huyhang.setVisible(true);
			}
		});
		btnThem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\plus.png"));
		btnThem.setBounds(10, 546, 130, 35);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnThem);		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(484, 49, 60, 35);
		add(lblNewLabel_1_1_1);
		
		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(539, 51, 279, 35);
		date.setTextField(txtNgay);
		add(txtNgay);
		
		cbxTenhang = new JComboBox();
		cbxTenhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableTim();
			}
		});
		cbxTenhang.setBounds(120, 51, 345, 35);
		cbxTenhang.setModel(cb);
		add(cbxTenhang);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên hàng hóa:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 49, 119, 35);
		add(lblNewLabel_1_1);
	}
	public void init(){
		fillComboxhang();
		fillTableHangHuy();
	}
	
	public void fillComboxhang() {
		cb.removeAllElements();
		List<HangHoa> list = hhdao.selectAll();
		for (HangHoa hhoa : list) {
//			System.out.println(lhang);
			cb.addElement(String.valueOf(hhoa.getTenHH())); 
		}
	}
	
	public static void fillTableHangHuy() {
	    DefaultTableModel model = (DefaultTableModel)tbHangHuy.getModel();
	    model.setRowCount(0);
	    List<Object[]> list = hhuydao.getDanhSachHangHuy();
	    for (Object[] row : list)
	      model.addRow(row); 
	  }
	  
	void fillTableTim() {
	    DefaultTableModel model = (DefaultTableModel)this.tbHangHuy.getModel();
	    model.setRowCount(0);
	    String hd = (String) cbxTenhang.getSelectedItem();
	    List<Object[]> list = this.hhuydao.getDanhSachHangHuytheoTenHH(hd);
	    for (Object[] row : list) {
	      model.addRow(row);
	    } 
	}
	
	void fillTableTimNgay() {
	    DefaultTableModel model = (DefaultTableModel)this.tbHangHuy.getModel();
	    model.setRowCount(0);
	    String ngay = txtNgay.getText();
	    List<Object[]> list = this.hhuydao.getDanhSachHangHuytheoNgay(ngay);
	    for (Object[] row : list) {
//	    	System.out.println(this.row);
	    	model.addRow(row);
	    } 
	}
	
	public void edit() {
    	String mahhuy = (String)tbHangHuy.getValueAt(row, 0); // lấy cột mã hàng hóa
    	HangHuy hhuy = hhuydao.selectById(mahhuy);
    	ChinhsuaHHuyFrame cshhuy = new ChinhsuaHHuyFrame();
    	cshhuy.setVisible(true);
    	cshhuy.setForm(hhuy);
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
    		row = tbHangHuy.getRowCount() - 1;
    		edit();
    	}
    }
    
    public void next() {
		if(row < tbHangHuy.getRowCount() - 1) {
			row++;
			edit();
		} else {
			row = 0;
			edit();
		}
	}
    
    public void last() {
		row = tbHangHuy.getRowCount() - 1;
		edit();
	}
}
