package com.JavaCourseDesign.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.JavaCourseDesign.Dao.ClazzDao;
import com.JavaCourseDesign.Model.Clazz;
import com.JavaCourseDesign.Util.StringUtil;

public class ClazzManageFrame extends JInternalFrame {
	private JTextField searchClazzNameTextField;
	private JTable clazzListTable;
	private JTextField editClazzNameField;
    private JTextArea EditClazzInfoTextArea;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					clazzManageFrame frame = new clazzManageFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ClazzManageFrame() {
		setTitle("\u73ED\u7EA7\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 670, 442);
		setClosable(true);   //可以被关闭
		setIconifiable(true);  //可以被最小化
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0");
		lblNewLabel.setIcon(new ImageIcon(ClazzManageFrame.class.getResource("/imageSource/\u73ED\u7EA7\u540D\u79F0.png")));
		
		searchClazzNameTextField = new JTextField();
		searchClazzNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchClazz(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(ClazzManageFrame.class.getResource("/imageSource/\u641C\u7D22.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\u540D\u79F0");
		lblNewLabel_1.setIcon(new ImageIcon(ClazzManageFrame.class.getResource("/imageSource/\u73ED\u7EA7\u540D\u79F0.png")));
		
		editClazzNameField = new JTextField();
		editClazzNameField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED\u7EA7\u4FE1\u606F");
		lblNewLabel_2.setIcon(new ImageIcon(ClazzManageFrame.class.getResource("/imageSource/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		
		EditClazzInfoTextArea = new JTextArea();
		
		JButton submitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEdit(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(ClazzManageFrame.class.getResource("/imageSource/\u786E\u8BA4.png")));
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteClazz(ae);
			}
		});
		deleteButton.setIcon(new ImageIcon(ClazzManageFrame.class.getResource("/imageSource/\u5220\u9664.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(searchClazzNameTextField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editClazzNameField, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(EditClazzInfoTextArea, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
									.addGap(136)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(submitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
					.addContainerGap(178, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(searchButton)
						.addComponent(searchClazzNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(editClazzNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(EditClazzInfoTextArea, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteButton))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		clazzListTable = new JTable();
		clazzListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				selectTableRow(ae);
			}
		});
		clazzListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		clazzListTable.getColumnModel().getColumn(2).setPreferredWidth(182);
		scrollPane.setViewportView(clazzListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Clazz());
	}
	
	protected void deleteClazz(ActionEvent ae) {
		// TODO Auto-generated method stub
		int index = clazzListTable.getSelectedRow();
		if(index == -1) {
			JOptionPane.showMessageDialog(this, "请选择要删除的数据!");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "将删除该班级以及该班级下的所有学生，确认删除？") == JOptionPane.OK_OPTION) {
			DefaultTableModel dft = (DefaultTableModel) clazzListTable.getModel();
			int id = Integer.parseInt(dft.getValueAt(clazzListTable.getSelectedRow(),0).toString());
			ClazzDao clazzDao = new ClazzDao();
			if(clazzDao.delete(id)) {
				JOptionPane.showMessageDialog(this, "删除成功!");
			}else {
				JOptionPane.showMessageDialog(this, "删除失败!");
			}
			clazzDao.closeDao();
			setTable(new Clazz());
		}
		
		
	}

	protected void submitEdit(ActionEvent ae) {
		// TODO Auto-generated method stub
				ClazzDao clazzDao = new ClazzDao();
				int index = clazzListTable.getSelectedRow();
				if(index == -1){
					JOptionPane.showMessageDialog(this, "请选中要修改的数据!");
					return;
				}
				DefaultTableModel dft = (DefaultTableModel) clazzListTable.getModel();
				String className = dft.getValueAt(clazzListTable.getSelectedRow(), 1).toString();
				String classInfo = dft.getValueAt(clazzListTable.getSelectedRow(), 2).toString();
				String editClassName = editClazzNameField.getText().toString();
				String editClassInfo = EditClazzInfoTextArea.getText().toString();
				if(StringUtil.isEmpty(editClassName)){
					JOptionPane.showMessageDialog(this, "请填写要修改的名称!");
					return;
				}
				if(className.equals(editClassName) && classInfo.equals(editClassInfo)){
					JOptionPane.showMessageDialog(this, "您还没有做任何修改!");
					return;
				}
				if(JOptionPane.showConfirmDialog(this, "确认修改？") == JOptionPane.OK_OPTION) {
					int id = Integer.parseInt(dft.getValueAt(clazzListTable.getSelectedRow(), 0).toString());
					Clazz clazz = new Clazz();
					clazz.setId(id);
					clazz.setName(editClassName);
					clazz.setInfo(editClassInfo);
					if(clazzDao.update(clazz)){
						JOptionPane.showMessageDialog(this, "修改成功!");
					}else{
						JOptionPane.showMessageDialog(this, "修改失败!");
					}
					clazzDao.closeDao();
					setTable(new Clazz());
				}
				
		
	}

	protected void selectTableRow(MouseEvent ae) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) clazzListTable.getModel();
		editClazzNameField.setText(dft.getValueAt(clazzListTable.getSelectedRow(),1).toString());
		EditClazzInfoTextArea.setText(dft.getValueAt(clazzListTable.getSelectedRow(),2).toString());
	
	} 

	protected void searchClazz(ActionEvent ae) {
		// TODO Auto-generated method stub
		Clazz clazz = new Clazz();
		clazz.setName(searchClazzNameTextField.getText().toString());
		setTable(clazz);
	}

	private void setTable(Clazz clazz) {
		DefaultTableModel dft = (DefaultTableModel) clazzListTable.getModel();
		dft.setRowCount(0);
		ClazzDao clazzDao = new ClazzDao();
		List<Clazz> clazzList = clazzDao.getClazzList(clazz);
		for(Clazz cl:clazzList) {
			Vector v = new Vector();
			v.add(cl.getId());
			v.add(cl.getName());
			v.add(cl.getInfo());
			dft.addRow(v);
		}
		clazzDao.closeDao();
	}
}
