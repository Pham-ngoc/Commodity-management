package com.mart.form.ChiTieu;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mart.dao.ChiTieuDAO;
import com.mart.dao.NhanVienDAO;
import com.mart.entity.ChiTieu;
import com.mart.entity.NhanVien;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChiTieuPanel extends JPanel {
	private static JTextField txtTim;
	private static JTable tbChitieu;
	
	private static ChiTieuDAO chitieudao = new ChiTieuDAO();
	private NhanVienDAO nvdao = new NhanVienDAO();
	DefaultComboBoxModel<String> cbx = new DefaultComboBoxModel<>();
	private int row;

	/**
	 * Create the panel.
	 */
	public ChiTieuPanel() {
		initComponents();
	    init();
	}
	
	public void initComponents() { 
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên hạng mục: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 51, 114, 35);
		add(lblNewLabel_1);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTim.setColumns(10);
		txtTim.setBounds(134, 51, 295, 35);
		add(txtTim);
		
		JLabel lblNewLabel = new JLabel("CHI TIÊU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(363, 0, 163, 46);
		add(lblNewLabel);
		
		JButton btnTimkiem = new JButton("Tìm kiếm");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
			}
		});
		btnTimkiem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimkiem.setBounds(849, 51, 130, 35);
		add(btnTimkiem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 96, 969, 426);
		add(scrollPane_1);
		
		tbChitieu = new JTable();
		tbChitieu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				      row = tbChitieu.getSelectedRow();
				      edit();
				    } 
			}
		});
		tbChitieu.setModel(new DefaultTableModel(
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
			},
			new String[] {
				"Mã hạng mục", "Tên hạng mục", "Ngày tạo", "Mã người tạo", "Giá tiền", "Ghi chú"
			}
		){
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
		scrollPane_1.setViewportView(tbChitieu);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuaChitieuFrame chitieu = new ChinhsuaChitieuFrame();
				chitieu.setVisible(true);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã nhân viên: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(439, 51, 114, 35);
		add(lblNewLabel_1_1);
		
		JComboBox cbxTim = new JComboBox();
		cbxTim.setBounds(542, 51, 297, 35);
		cbxTim.setModel(cbx);
		add(cbxTim);		
	}
	
    public void init() {
    	row = -1;
    	fillTable();
    	fillComboboxNhanvien();
    }
    
    public void fillComboboxNhanvien() {
		cbx.removeAllElements();
		List<NhanVien> list = nvdao.selectByTruongphong();
		for (NhanVien nhanVien : list) {
				cbx.addElement(nhanVien.getMaNV());
		}
	}
    
    public static void fillTable() {
    	DefaultTableModel tb = (DefaultTableModel)tbChitieu.getModel();
    	tb.setRowCount(0);
    	try {
			String keyword = txtTim.getText();
			List<ChiTieu> list = chitieudao.selectByKeyword(keyword);
			for (ChiTieu chiTieu : list) {
				Object[] row = {
					chiTieu.getMaHangmuc(),
					chiTieu.getTenHangmuc(),
					chiTieu.getNgaytao(),
					chiTieu.getMaNV(),
					chiTieu.getGiatien(),
					chiTieu.getGhichu()
				};
				tb.addRow(row);
			}
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi truy vẫn dữ liệu");
		}
    }
    
    public void edit() {
    	String mahm = (String)tbChitieu.getValueAt(row, 0);
    	ChiTieu ct = chitieudao.selectById(mahm);
    	ChinhsuaChitieuFrame cs = new ChinhsuaChitieuFrame();
    	cs.setVisible(true);
    	cs.setForm(ct);
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
    		row = tbChitieu.getRowCount() - 1;
    		edit();
    	}
    }
    
    public void next() {
		if(row < tbChitieu.getRowCount() - 1) {
			row++;
			edit();
		} else {
			row = 0;
			edit();
		}
	}
    
    public void last() {
		row = tbChitieu.getRowCount() - 1;
		edit();
	}
    
    public void find() {
    	fillTable();
    }
}
