package com.JavaCourseDesign.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.JavaCourseDesign.Dao.AdminDao;
import com.JavaCourseDesign.Dao.StudentDao;
import com.JavaCourseDesign.Model.Admin;
import com.JavaCourseDesign.Model.Student;
import com.JavaCourseDesign.Model.UserType;
import com.JavaCourseDesign.Util.StringUtil;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JTextField passwordTextField;
	private JComboBox userTypecomboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setTitle("\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);  //设置窗口在屏幕中央
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		lblNewLabel.setFont(new Font("仿宋", Font.BOLD, 19));
		lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/imageSource/logo2.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/imageSource/\u7528\u6237\u540D.png")));
		lblNewLabel_1.setFont(new Font("仿宋", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6 \u7801");
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/imageSource/\u5BC6\u7801.png")));
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u7C7B\u578B");
		lblNewLabel_3.setIcon(new ImageIcon(LoginFrm.class.getResource("/imageSource/userType.png")));
		
		userTypecomboBox = new JComboBox();
		//枚举类已重写toString()方法
		userTypecomboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.TEACHER, UserType.STUDENT}));
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginAction(e);
			}
		});
		loginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/imageSource/\u767B\u5F55.png")));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		resetButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/imageSource/\u91CD\u7F6E.png")));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(56, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_1)))
									.addGap(20))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(10)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(34)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(passwordTextField, Alignment.LEADING)
										.addComponent(userNameTextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
										.addComponent(userTypecomboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(42)
									.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 0, Short.MAX_VALUE)))))
					.addGap(35))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(userTypecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(resetButton))
					.addGap(53))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypecomboBox.getSelectedItem();
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this,"用户名不能为空");  
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this,"密码不能为空");  
		}
		Admin admin = null;
		Student student=null;
		if("系统管理员".equals(selectedItem.getName())) {
			//系统管理员登录
			AdminDao adminDao = new AdminDao();
			Admin adminTem = new Admin();
			adminTem.setName(userName);
			adminTem.setPassword(password);
			admin = adminDao.login(adminTem);
			adminDao.closeDao();
			if(admin == null) {
				JOptionPane.showMessageDialog(this,"用户名或密码错误!");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【" + admin.getName() + "】登录！");
			this.dispose();
			new SystemFrame(selectedItem,admin).setVisible(true);;
			
		}else if("教师".equals(selectedItem.getName())) {
			//教师登录
		}else{
			//学生登录
			StudentDao studentDao = new StudentDao();
			Student studentTem = new Student();
			studentTem.setName(userName);
			studentTem.setPassword(password);
			student = studentDao.login(studentTem);
			studentDao.closeDao();
			if(student == null) {
				JOptionPane.showMessageDialog(this,"用户名或密码错误!");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【" + student.getName() + "】登录！");
			this.dispose();
			new SystemFrame(selectedItem,student).setVisible(true);;
		}
	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		passwordTextField.setText("");
		userTypecomboBox.setSelectedIndex(0);
		
	}
}
