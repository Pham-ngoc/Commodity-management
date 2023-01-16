package com.mart.form.HangDat;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mart.dao.HangDatDAO;
import com.mart.dao.HangHoaDAO;
import com.mart.entity.HangDat;
import com.mart.entity.HangHoa;
import com.mart.entity.LoaiHang;
import com.mart.form.HangHoa.ChinhsuaHHFrame;
import com.mart.utils.XDate;
import com.raven.datechooser.DateChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HangDatPanel extends JPanel {
	private static JTable tbHangDat;
	private static JComboBox cbxTenhang;
	
	int row = -1;
	private static HangDatDAO hddao = new HangDatDAO();
	private static HangHoaDAO hhdao = new HangHoaDAO();
	private static DefaultComboBoxModel<String> cb = new DefaultComboBoxModel<>();
	private JTextField txtNgay;
	private DateChooser date = new DateChooser();
	
	/**
	 * Create the panel.
	 */
	public HangDatPanel() {
		initCompnent();
		init();
		date.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
	}
	
	public void initCompnent() {
		setLayout(null);
		
		JLabel lblHngt = new JLabel("HÀNG ĐẶT ");
		lblHngt.setHorizontalAlignment(SwingConstants.CENTER);
		lblHngt.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblHngt.setBounds(405, 0, 139, 41);
		add(lblHngt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên hàng hóa:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 49, 119, 35);
		add(lblNewLabel_1_1);
		
		cbxTenhang = new JComboBox();
		cbxTenhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableTim();
			}
		});
		cbxTenhang.setBounds(120, 51, 345, 35);
		cbxTenhang.setModel(cb);
		add(cbxTenhang);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableTimNgay();
			}
		});
		btnTim.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(843, 51, 130, 35);
		add(btnTim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 963, 440);
		add(scrollPane);
		
		tbHangDat = new JTable();
		tbHangDat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					row = tbHangDat.getSelectedRow();
					edit();
				}
			}
		});
		tbHangDat.setModel(new DefaultTableModel(
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
				"Mã hàng hóa", "Tên hàng hóa", "Số lượng đặt", "Ngày đặt", "Tổng giá"
			}
		){
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
		scrollPane.setViewportView(tbHangDat);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaHDFrame dathang = new ChinhsuaHDFrame();
				dathang.setVisible(true);
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(484, 49, 60, 35);
		add(lblNewLabel_1_1_1);
		
		txtNgay = new JTextField();
		txtNgay.setBounds(539, 51, 279, 35);
		add(txtNgay);
		txtNgay.setColumns(10);
		date.setTextField(txtNgay);
	}
	
	public void init() {
		fillComboxhang();
		fillTableHangDat();
	}
	
	public void fillComboxhang() {
		cb.removeAllElements();
		List<HangHoa> list = hhdao.selectAll();
		for (HangHoa hhoa : list) {
//			System.out.println(lhang);
			cb.addElement(String.valueOf(hhoa.getTenHH())); 
		}
	}
	
	public static void fillTableHangDat() {
	    DefaultTableModel model = (DefaultTableModel)tbHangDat.getModel();
	    model.setRowCount(0);
	    List<Object[]> list = hddao.getDanhSachHangDat();
	    for (Object[] row : list)
	      model.addRow(row); 
	  }
	  
	void fillTableTim() {
	    DefaultTableModel model = (DefaultTableModel)this.tbHangDat.getModel();
	    model.setRowCount(0);
	    String hd = (String) cbxTenhang.getSelectedItem();
	    List<Object[]> list = this.hddao.getDanhSachHangDattheoTenHH(hd);
	    for (Object[] row : list) {
	      model.addRow(row);
	    } 
	}
	
	void fillTableTimNgay() {
	    DefaultTableModel model = (DefaultTableModel)this.tbHangDat.getModel();
	    model.setRowCount(0);
	    String ngay = txtNgay.getText();
	    List<Object[]> list = this.hddao.getDanhSachHangDattheoNgay(ngay);
	    for (Object[] row : list) {
//	    	System.out.println(this.row);
	    	model.addRow(row);
	    } 
	}
	
	public void edit() {
    	String mahd = (String)tbHangDat.getValueAt(row, 0); // lấy cột mã hàng hóa
    	HangDat hdat = hddao.selectById(mahd);
    	ChinhsuaHDFrame cshd = new ChinhsuaHDFrame();
    	cshd.setVisible(true);
    	cshd.setForm(hdat);
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
    		row = tbHangDat.getRowCount() - 1;
    		edit();
    	}
    }
    
    public void next() {
		if(row < tbHangDat.getRowCount() - 1) {
			row++;
			edit();
		} else {
			row = 0;
			edit();
		}
	}
    
    public void last() {
		row = tbHangDat.getRowCount() - 1;
		edit();
	}
}
