package com.JavaCourseDesign.View;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import com.JavaCourseDesign.Dao.StudentDao;
import com.JavaCourseDesign.Model.Clazz;
import com.JavaCourseDesign.Model.Student;
import com.JavaCourseDesign.Util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class StudentManageFrame extends JInternalFrame {
	private JTextField searchStudentNameTextField;
	private JTextField editStudentNameField;
	private JTextField editClaidField;
	private JTextField editStudentsexField;
	private JTable studentListTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManageFrame frame = new StudentManageFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentManageFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5B66\u751F\u7BA1\u7406");
		setBounds(100, 100, 557, 431);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D");
		lblNewLabel.setIcon(new ImageIcon(StudentManageFrame.class.getResource("/imageSource/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		lblNewLabel.setBounds(94, 35, 77, 15);
		getContentPane().add(lblNewLabel);
		
		searchStudentNameTextField = new JTextField();
		searchStudentNameTextField.setBounds(173, 32, 92, 21);
		getContentPane().add(searchStudentNameTextField);
		searchStudentNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchStudent(e);
			}
		});
		searchButton.setIcon(new ImageIcon(StudentManageFrame.class.getResource("/imageSource/\u641C\u7D22.png")));
		searchButton.setBounds(371, 31, 97, 23);
		getContentPane().add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 79, 475, 206);
		getContentPane().add(scrollPane);
		
		studentListTable = new JTable();
		studentListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectTableRow(e);
			}
		});
		studentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u73ED\u7EA7", "\u6027\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
		scrollPane.setViewportView(studentListTable);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setIcon(new ImageIcon(StudentManageFrame.class.getResource("/imageSource/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		lblNewLabel_1.setBounds(51, 308, 58, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED\u53F7");
		lblNewLabel_2.setIcon(new ImageIcon(StudentManageFrame.class.getResource("/imageSource/\u73ED\u7EA7\u540D\u79F0.png")));
		lblNewLabel_2.setBounds(51, 333, 58, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B");
		lblNewLabel_3.setIcon(new ImageIcon(StudentManageFrame.class.getResource("/imageSource/\u6027\u522B.png")));
		lblNewLabel_3.setBounds(51, 358, 58, 15);
		getContentPane().add(lblNewLabel_3);
		
		editStudentNameField = new JTextField();
		editStudentNameField.setBounds(105, 305, 66, 21);
		getContentPane().add(editStudentNameField);
		editStudentNameField.setColumns(10);
		
		editClaidField = new JTextField();
		editClaidField.setBounds(105, 330, 66, 21);
		getContentPane().add(editClaidField);
		editClaidField.setColumns(10);
		
		editStudentsexField = new JTextField();
		editStudentsexField.setBounds(105, 355, 66, 21);
		getContentPane().add(editStudentsexField);
		editStudentsexField.setColumns(10);
		
		JButton deleteButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEdit(e);
			}
		});
		deleteButton.setIcon(new ImageIcon(StudentManageFrame.class.getResource("/imageSource/\u786E\u8BA4.png")));
		deleteButton.setBounds(247, 304, 136, 23);
		getContentPane().add(deleteButton);
		
		JButton submitButton = new JButton("\u5220\u9664");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteStudent(e);
			}
		});
		submitButton.setIcon(new ImageIcon(StudentManageFrame.class.getResource("/imageSource/\u5220\u9664.png")));
		submitButton.setBounds(247, 354, 136, 23);
		getContentPane().add(submitButton);

	}
	protected void deleteStudent(ActionEvent e) {
		int index = studentListTable.getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(this, "请选择要删除的数据!");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "将删除该学生，确认删除？") == JOptionPane.OK_OPTION) {
			DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
			int id = Integer.parseInt(dft.getValueAt(studentListTable.getSelectedRow(),0).toString());
			StudentDao studentDao=new StudentDao();
			if(studentDao.delete(id)) {
				JOptionPane.showMessageDialog(this, "删除成功!");
			}else {
				JOptionPane.showMessageDialog(this, "删除失败!");
			}
			studentDao.closeDao();
			setTable(new Student());
		}
	}
	protected void submitEdit(ActionEvent e) {
		StudentDao studentDao=new StudentDao();
		int index=studentListTable.getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(this, "请选中要修改的数据!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
		String studentName=dft.getValueAt(studentListTable.getSelectedRow(), 1).toString();
		int studentclaid=Integer.parseInt(dft.getValueAt(studentListTable.getSelectedRow(), 2).toString());
		String studentsex=dft.getValueAt(studentListTable.getSelectedRow(), 3).toString();
		String editstudentName=editStudentNameField.getText().toString();
		int editstudentClaid=Integer.parseInt(editClaidField.getText().toString());
		String editstudentsex=editStudentsexField.getText().toString();
		if(StringUtil.isEmpty(editstudentName)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的姓名!");
			return;
		}
		if(studentName.equals(editstudentName)&&studentclaid==editstudentClaid&&studentsex.equals(editstudentsex)) {
			JOptionPane.showMessageDialog(this, "您还没有做任何修改!");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "确认修改？")==JOptionPane.OK_OPTION) {
			int id=Integer.parseInt(dft.getValueAt(studentListTable.getSelectedRow(), 0).toString());
			Student student=new Student();
			student.setId(id);
			student.setName(editstudentName);
			student.setCla_id(editstudentClaid);
			student.setSex(editstudentsex);
			if(studentDao.update(student)) {
				JOptionPane.showMessageDialog(this, "修改成功!");
			}else {
				JOptionPane.showMessageDialog(this, "修改失败!");
			}
			studentDao.closeDao();
			setTable(new Student());
		}
	}
	protected void selectTableRow(MouseEvent e) {
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
		editStudentNameField.setText(dft.getValueAt(studentListTable.getSelectedRow(),1).toString());
		editClaidField.setText(dft.getValueAt(studentListTable.getSelectedRow(),2).toString());
		editStudentsexField.setText(dft.getValueAt(studentListTable.getSelectedRow(),3).toString());
	}
	protected void searchStudent(ActionEvent e) {
		Student student = new Student();
		student.setName(searchStudentNameTextField.getText().toString());
		setTable(student);
	}
	protected void setTable(Student student) {
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
		dft.setRowCount(0);
		StudentDao studentDao=new StudentDao();
		List<Student> studentList=studentDao.getStudentList(student);
		for(Student cl:studentList) {
			Vector v=new Vector();
			v.add(cl.getId());
			v.add(cl.getName());
			v.add(cl.getCla_id());
			v.add(cl.getSex());
			dft.addRow(v);
		}
		studentDao.closeDao();
		
	}
}
