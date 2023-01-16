package com.mart.form.ChuongTrinh;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mart.dao.ChuongTrinhDAO;
import com.mart.entity.ChuongTrinh;
import com.mart.utils.MsgBox;
import com.mart.utils.XDate;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChuongTrinhPanel extends JPanel {
	private static JTable tbChuongtrinh;
	private static JTextField txtTim;
	private static ChuongTrinhDAO ctrinhdao = new ChuongTrinhDAO();
	int row;

	/**
	 * Create the panel.
	 */
	public ChuongTrinhPanel() {
		initCompnent();
		fillTable();
		row = -1;
	}
	
	public void initCompnent() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHƯƠNG TRÌNH KHUYẾN MÃI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(273, 0, 377, 41);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 963, 440);
		add(scrollPane);
		
		tbChuongtrinh = new JTable();
		tbChuongtrinh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
				      row = tbChuongtrinh.getSelectedRow();
				      edit();
				    } 
			}
		});
		tbChuongtrinh.setModel(new DefaultTableModel(
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
				"Mã chương trình", "Nội dung", "Giá trị", "Số lượng", "Ngày tạo", "Hạn sử dụng"
			}
		){
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
	          
	          public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return this.canEdit[columnIndex];
	          }
		});
		scrollPane.setViewportView(tbChuongtrinh);
		
		JButton btnThem = new JButton("Thêm mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChinhsuCTFrame chuongtrinh = new ChinhsuCTFrame();
				chuongtrinh.setVisible(true);
			}
		});
		btnThem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\plus.png"));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(10, 562, 130, 35);
		add(btnThem);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first();
			}
		});
		btnFirst.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\fast-backward.png"));
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFirst.setBounds(751, 562, 48, 35);
		add(btnFirst);
		
		JButton btnPrev = new JButton("");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		btnPrev.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\back-button.png"));
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrev.setBounds(809, 562, 48, 35);
		add(btnPrev);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\next-button.png"));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(867, 562, 48, 35);
		add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\last-backward.png"));
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLast.setBounds(925, 562, 48, 35);
		add(btnLast);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 67, 70, 35);
		add(lblNewLabel_1);
		
		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(90, 67, 743, 35);
		add(txtTim);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTable();
			}
		});
		btnTim.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTim.setBounds(843, 67, 130, 35);
		add(btnTim);

	}
	
	public static void fillTable() {
		DefaultTableModel tb = (DefaultTableModel)tbChuongtrinh.getModel();
		tb.setRowCount(0);
		try {
			String keyword = txtTim.getText();
			List<ChuongTrinh> list = ctrinhdao.selectByKeyword(keyword);
			for (ChuongTrinh chuongTrinh : list) {
				Object[] row = {
						chuongTrinh.getMaCT(),
						chuongTrinh.getNoidung(),
						chuongTrinh.getGiatri(),
						chuongTrinh.getSoluong(),
						chuongTrinh.getNgaytao(),
						chuongTrinh.getHSD()
				};
				tb.addRow(row);
			}
		} catch (Exception e) {
			MsgBox.alert(null, "Lỗi truy vấn dữ liệu");
		}
	}
	
	public void edit() {
		String mactrinh = (String) tbChuongtrinh.getValueAt(row, 0);
		ChuongTrinh ctrinh = ctrinhdao.selectById(mactrinh);
		ChinhsuCTFrame csct = new ChinhsuCTFrame();
		csct.setVisible(true);
		csct.setForm(ctrinh);
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
			row = tbChuongtrinh.getRowCount() - 1;
			edit();
		}
	}
	
	public void next() {
		if(row < tbChuongtrinh.getRowCount() - 1) {
			row++;
			edit();
		} else {
			row = 0;
			edit();
		}
	}
	
	public void last() {
		row = tbChuongtrinh.getRowCount() - 1;
		edit();
	}
}
