package com.mart.form.DonHang;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mart.dao.DonHangDAO;
import com.mart.dao.NhanVienDAO;
import com.mart.entity.DonHang;
import com.mart.entity.NhanVien;
import com.mart.form.ChiTieu.ChinhsuaChitieuFrame;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;

import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DonHangPanel extends JPanel {
	private static JTable tbDonhang;
	private static JComboBox cbxTimManv;
	private static JComboBox cbxTim;
	
	private static DonHangDAO dhdao = new DonHangDAO();
	private static NhanVienDAO nvdao = new NhanVienDAO();
	private static int row;
	private static DefaultComboBoxModel<String> cbx = new DefaultComboBoxModel<>();
	/**
	 * Create the panel.
	 */
	public DonHangPanel() {
		initComponents();
		init();
	}
	
	public void initComponents() {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên: ");
		lblNewLabel_1.setBounds(10, 51, 114, 35);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_1);
		
		JLabel lblnHng = new JLabel("ĐƠN HÀNG");
		lblnHng.setBounds(363, 0, 163, 57);
		lblnHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblnHng.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblnHng);
		
		JButton btnTimkiem = new JButton("Tìm kiếm");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
			}
		});
		btnTimkiem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTimkiem.setBounds(849, 51, 130, 35);
		btnTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnTimkiem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 96, 969, 426);
		add(scrollPane_1);
		
		tbDonhang = new JTable();
		tbDonhang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				      row = tbDonhang.getSelectedRow();
				      edit();
				    } 
			}
		});
		tbDonhang.setModel(new DefaultTableModel(
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
				"Mã hóa đơn", "Ngày bán", "Tổng giá", "Phương thức thanh toán", "Người bán"
			}
		){
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
		scrollPane_1.setViewportView(tbDonhang);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaDHFrame donhang = new ChinhsuaDHFrame();
				donhang.setVisible(true);
				donhang.setLocationRelativeTo(null);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Phương thức thanh toán: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(434, 51, 176, 35);
		add(lblNewLabel_1_1);
		
		cbxTim = new JComboBox();
		cbxTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableTimPTTT();
			}
		});
		cbxTim.setModel(new DefaultComboBoxModel(new String[] {"Tiền mặt", "Thẻ ngân hàng", "Ví Momo", "Ví Shoppepay", "Ví Zalopay", "Ví VNPay"}));
		cbxTim.setBounds(620, 51, 219, 35);
		add(cbxTim);
		
		cbxTimManv = new JComboBox();
		cbxTimManv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTabletimNV();
			}
		});
		cbxTimManv.setBounds(120, 51, 289, 35);
		cbxTimManv.setModel(cbx);
		add(cbxTimManv);		
	}
    public void init() {
    	row = -1;
    	fillComboboxNhanvien();
    	fillTable();
    }
    
    public void fillComboboxNhanvien() {
    	cbx.removeAllElements();
    	List<NhanVien> list = nvdao.selectAll();
    	for (NhanVien nhanVien : list) {
			cbx.addElement(nhanVien.getMaNV());
		}
    }
    
    public static void fillTable() {
    	DefaultTableModel tb = (DefaultTableModel)tbDonhang.getModel();
    	tb.setRowCount(0);
    	try {
//			String keyword = String.valueOf(cbxTimManv.getSelectedItem());
//			List<DonHang> list = dhdao.selectByKeyword(keyword);
			List<DonHang> listDonhang = dhdao.selectAll();
			for (DonHang dh : listDonhang) {
				Object[] row = {
					dh.getMaDH(),
					dh.getNgayban(),
					dh.getTonggia(),
					dh.getPTTT(),
					dh.getMaNV()
				};
				tb.addRow(row);
			}
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi truy vẫn dữ liệu");
		}
    }
    
    public static void fillTabletimNV() {
    	DefaultTableModel tb = (DefaultTableModel)tbDonhang.getModel();
    	tb.setRowCount(0);
    	try {
			String keyword = String.valueOf(cbxTimManv.getSelectedItem());
			List<DonHang> list = dhdao.selectByKeyword(keyword);
//			List<DonHang> listDonhang = dhdao.selectAll();
			for (DonHang dh : list) {
				Object[] row = {
					dh.getMaDH(),
					dh.getNgayban(),
					dh.getTonggia(),
					dh.getPTTT(),
					dh.getMaNV()
				};
				tb.addRow(row);
			}
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi truy vẫn dữ liệu");
		}
    }
    
    public static void fillTableTimPTTT() {
    	DefaultTableModel tb = (DefaultTableModel)tbDonhang.getModel();
    	tb.setRowCount(0);
    	try {
			String keyword = String.valueOf(cbxTim.getSelectedItem());
			List<DonHang> list = dhdao.selectByPTTT(keyword);
			for (DonHang dh : list) {
				Object[] row = {
					dh.getMaDH(),
					dh.getNgayban(),
					dh.getTonggia(),
					dh.getPTTT(),
					dh.getMaNV()
				};
				tb.addRow(row);
			}
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi truy vẫn dữ liệu");
		}
    }
    
    public void edit() {
    	String madh = (String)tbDonhang.getValueAt(row, 0);
    	DonHang ct = dhdao.selectById(madh);
    	ChinhsuaDHFrame dh = new ChinhsuaDHFrame();
    	dh.setVisible(true);
    	dh.setForm(ct);
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
    		row = tbDonhang.getRowCount() - 1;
    		edit();
    	}
    }
    
    public void next() {
		if(row < tbDonhang.getRowCount() - 1) {
			row++;
			edit();
		} else {
			row = 0;
			edit();
		}
	}
    
    public void last() {
		row = tbDonhang.getRowCount() - 1;
		edit();
	}
    
    public void find() {
    	fillTabletimNV();
    	fillTableTimPTTT();
    }
}
