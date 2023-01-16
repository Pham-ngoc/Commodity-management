package com.mart.form.ThietBi;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.mart.dao.NhanVienDAO;
import com.mart.dao.ThietBiDAO;
import com.mart.entity.NhanVien;
import com.mart.entity.ThietBi;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThietBiPanel extends JPanel {
	private static JTextField txtTim;
	private static JTable tbThietbi;
	private static JComboBox cbxMaNV;

	private int row;
	private static ThietBiDAO tbdao = new ThietBiDAO();
	private static NhanVienDAO nvdao = new NhanVienDAO();
	private static DefaultComboBoxModel<String> cbx = new DefaultComboBoxModel<>();
	/**
	 * Create the panel. 
	 */
	public ThietBiPanel() {
		initCompnent();
		init();

	}
	
	public void initCompnent() {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên thiết bị: ");
		lblNewLabel_1.setBounds(10, 51, 95, 35);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_1);
		
		txtTim = new JTextField();
		txtTim.setBounds(101, 51, 318, 35);
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTim.setColumns(10);
		add(txtTim);
		
		JLabel lblNewLabel = new JLabel("THIẾT BỊ");
		lblNewLabel.setBounds(363, 0, 163, 46);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblNewLabel);
		
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
		
		tbThietbi = new JTable();
		tbThietbi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				      row = tbThietbi.getSelectedRow();
				      edit();
				    } 
			}
		});
		tbThietbi.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Mã thiết bị", "Tên thiết bị", "Ngày bảo trì", "Số lượng", "Nội dung", "Ghi chú", "Mã nhân viên"
			}
		){
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
		scrollPane_1.setViewportView(tbThietbi);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaTBFrame tb = new ChinhsuaTBFrame();
				tb.setVisible(true);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã nhân viên: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(441, 51, 102, 35);
		add(lblNewLabel_1_1);
		
		cbxMaNV = new JComboBox();
		cbxMaNV.setModel(cbx);
		cbxMaNV.setBounds(553, 51, 286, 35);
		add(cbxMaNV);
	}
	public void init() {
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
    
    public static void fillTableTimMaNV() {
    	DefaultTableModel tb = (DefaultTableModel)tbThietbi.getModel();
    	tb.setRowCount(0);
    	try {
			String keyword = String.valueOf(cbxMaNV.getSelectedItem());
			List<ThietBi> list = tbdao.selectByKeyword(keyword);
			for (ThietBi tbi : list) {
				Object[] row = {
					tbi.getMaTB(),
					tbi.getTenTB(),
					tbi.getNgaybaotri(), 
					tbi.getSoluong(),
					tbi.getNoidung(),
					tbi.getGhichu(),
					tbi.getMaNV()
				};
				tb.addRow(row);
			}
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi truy vẫn dữ liệu");
		}
    }
    
    public static void fillTableTimTenTB() {
    	DefaultTableModel tb = (DefaultTableModel)tbThietbi.getModel();
    	tb.setRowCount(0);
    	try {
			String keyword = String.valueOf(txtTim.getText());
			List<ThietBi> list = tbdao.selectByTenTB(keyword);
			for (ThietBi tbi : list) {
				Object[] row = {
						tbi.getMaTB(),
						tbi.getTenTB(),
						tbi.getNgaybaotri(), 
						tbi.getSoluong(),
						tbi.getNoidung(),
						tbi.getGhichu(),
						tbi.getMaNV()
				};
				tb.addRow(row);
			}
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi truy vẫn dữ liệu");
		}
    }
    
    public static void fillTable() {
    	DefaultTableModel tb = (DefaultTableModel)tbThietbi.getModel();
    	tb.setRowCount(0);
    	try {
			List<ThietBi> list = tbdao.selectAll();
			for (ThietBi tbi : list) {
				Object[] row = {
					tbi.getMaTB(),
					tbi.getTenTB(),
					tbi.getNgaybaotri(), 
					tbi.getSoluong(),
					tbi.getNoidung(),
					tbi.getGhichu(),
					tbi.getMaNV()
				};
				tb.addRow(row);
			}
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi truy vẫn dữ liệu");
		}
    }
    
    public void edit() {
    	String madh = (String)tbThietbi.getValueAt(row, 0);
    	ThietBi tbi = tbdao.selectById(madh);
    	ChinhsuaTBFrame cstb = new ChinhsuaTBFrame();
    	cstb.setVisible(true);
    	cstb.setForm(tbi);
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
    		row = tbThietbi.getRowCount() - 1;
    		edit();
    	}
    }
    
    public void next() {
		if(row < tbThietbi.getRowCount() - 1) {
			row++;
			edit();
		} else {
			row = 0;
			edit();
		}
	}
    
    public void last() {
		row = tbThietbi.getRowCount() - 1;
		edit();
	}
    
    public void find() {
    	fillTableTimMaNV();
    	fillTableTimTenTB();
    }
}
