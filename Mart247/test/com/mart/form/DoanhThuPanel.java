package com.mart.form;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mart.dao.DoanhThuDAO;
import com.mart.dao.DonHangDAO;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoanhThuPanel extends JPanel {
	private JTable tbDoanhThu;
    private JComboBox cbxNam;
    
    private DonHangDAO dhdao = new DonHangDAO();
    private DoanhThuDAO dtdao = new DoanhThuDAO();
//    DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
//    int row;

	/**
	 * Create the panel.
	 */
	public DoanhThuPanel() {
		initComponents();
		init();
	}
	
	public void initComponents() {
		setLayout(null);
		
		JLabel lblnHng = new JLabel("DOANH THU");
		lblnHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblnHng.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblnHng.setBounds(363, 0, 163, 57);
		add(lblnHng);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 96, 969, 426);
		add(scrollPane_1);
		
		tbDoanhThu = new JTable();
		tbDoanhThu.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S\u1ED1 l\u01B0\u1EE3ng \u0111\u01A1n", "T\u1ED5ng doanh thu"
			}
		));
		scrollPane_1.setViewportView(tbDoanhThu);
		
		JLabel lblNewLabel_1 = new JLabel("Tháng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(49, 49, 61, 35);
		add(lblNewLabel_1);
		
		cbxNam = new JComboBox();
		cbxNam.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "Cả năm"}));
//		cbxNam.setModel(model);
		cbxNam.setBounds(120, 51, 675, 35);
		add(cbxNam);
		
		JButton btnTimkiem = new JButton("Tìm kiếm");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableTim();
			}
		});
		btnTimkiem.setIcon(new ImageIcon("D:\\Idea project\\Idea 2\\New folder\\Mart247\\test\\com\\mart\\icon\\searching.png"));
		btnTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimkiem.setBounds(805, 49, 130, 35);
		add(btnTimkiem);		
	}
    public void init() {
//    	fillTableTim();
    	fillTableDoanhthu();
//		fillComboBoxthang();
//		row = -1;
    }
    
//    void fillComboBoxthang() {
//	    model.removeAllElements();
//	    List<Integer> list = this.dhdao.selectMonth();
//	    for (Integer month : list)
//	      model.addElement(month); 
//	  }
	
	public void fillTableDoanhthu() {
	    DefaultTableModel model = (DefaultTableModel)tbDoanhThu.getModel();
	    model.setRowCount(0);
	    List<Object[]> list = dtdao.getDSDoanhThu();
	    for (Object[] row : list)
	      model.addRow(row); 
	  }
	
	void fillTableTim() {
	    DefaultTableModel model = (DefaultTableModel)tbDoanhThu.getModel();
	    model.setRowCount(0);
	    int lh = Integer.parseInt(String.valueOf(cbxNam.getSelectedItem()));
	    List<Object[]> list = dtdao.getDSDoanhThutheoThang(lh);
	    for (Object[] row : list) {
	      model.addRow(row);
	    }
	}
}
