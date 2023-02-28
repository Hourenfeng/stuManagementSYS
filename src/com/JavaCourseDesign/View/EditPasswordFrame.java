package com.JavaCourseDesign.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.JavaCourseDesign.Dao.AdminDao;
import com.JavaCourseDesign.Model.Admin;
import com.JavaCourseDesign.Util.StringUtil;


public class EditPasswordFrame extends JInternalFrame {

	private JPanel contentPane;
	private JTextField oldPasswordField;
	private JTextField newPasswordField;
	private JTextField confrimNewPasswordField; 
	private JLabel currentUserLabel; 
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditPasswordFrame frame = new EditPasswordFrame();
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
	public EditPasswordFrame() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);   //可以被关闭
		setIconifiable(true);  //可以被最小化
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u7528\u6237");
		lblNewLabel.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/imageSource/\u7528\u6237\u540D.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u539F\u5BC6\u7801");
		lblNewLabel_1.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/imageSource/\u5BC6\u7801.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u65B0\u5BC6\u7801");
		lblNewLabel_2.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/imageSource/\u4FEE\u6539\u5BC6\u7801.png")));
		
		JLabel lblNewLabel_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_3.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/imageSource/\u4FEE\u6539\u5BC6\u7801.png")));
		
		oldPasswordField = new JTextField();
		oldPasswordField.setColumns(10);
		
		newPasswordField = new JTextField();
		newPasswordField.setColumns(10);
		
		confrimNewPasswordField = new JTextField();
		confrimNewPasswordField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEdit(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/imageSource/\u786E\u8BA4.png")));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/imageSource/\u91CD\u7F6E.png")));
		
		currentUserLabel = new JLabel("111111111111111");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(submitButton, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(oldPasswordField, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
								.addComponent(currentUserLabel, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
								.addComponent(newPasswordField, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
								.addComponent(confrimNewPasswordField, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))))
					.addGap(136))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(currentUserLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(oldPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(confrimNewPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		if("系统管理员".equals(SystemFrame.userType.getName())){
			Admin admin = (Admin)SystemFrame.userObject;
			currentUserLabel.setText("【系统管理员】" + admin.getName());
		}else if("学生".equals(SystemFrame.userType.getName())){
//			Student student = (Student)SystemFrame.userObject;
//			currentUserLabel.setText("【学生】" + student.getName());
		}else{
//			Teacher teacher = (Teacher)SystemFrame.userObject;
//			currentUserLabel.setText("【学生】" + teacher.getName());
		}
	}

	protected void submitEdit(ActionEvent ae) {
		// TODO Auto-generated method stub
		String oldPassword = oldPasswordField.getText().toString();
		String newPassword = newPasswordField.getText().toString();
		String conformPassword = confrimNewPasswordField.getText().toString();
		if(StringUtil.isEmpty(oldPassword)){
			JOptionPane.showMessageDialog(this, "请填写旧密码！");
			return;
		}
		if(StringUtil.isEmpty(newPassword)){
			JOptionPane.showMessageDialog(this, "请填写新密码！");
			return;
		}
		if(StringUtil.isEmpty(conformPassword)){
			JOptionPane.showMessageDialog(this, "请确认新密码！");
			return;
		}
		if(!newPassword.equals(conformPassword)){
			JOptionPane.showMessageDialog(this, "两次密码输入不一致！");
			return;
		}
		if("系统管理员".equals(SystemFrame.userType.getName())) {
			AdminDao adminDao = new AdminDao();
			Admin adminTem = new Admin();
			Admin admin = (Admin)SystemFrame.userObject;
			adminTem.setId(admin.getId());
			adminTem.setName(admin.getName());
			adminTem.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTem, newPassword));
			adminDao.closeDao();
			return;
		}
		
		 
		
		
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		oldPasswordField.setText("");
		newPasswordField.setText("");
		confrimNewPasswordField.setText("");
	}

}
