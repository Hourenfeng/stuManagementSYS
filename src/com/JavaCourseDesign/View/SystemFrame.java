package com.JavaCourseDesign.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;

//import com.JavaCourseDesign.view.LoginFrm;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.JavaCourseDesign.Model.UserType;

public class SystemFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static  UserType userType;
	public static Object userObject;
	/** 
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SystemFrame frame = new SystemFrame();
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
	public SystemFrame(UserType userType, Object userObject) {
		this.userType = userType;
		this.userObject = userObject;
		setTitle("\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 610);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		mnNewMenu.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u4FEE\u6539\u5BC6\u7801.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(JOptionPane.showConfirmDialog(SystemFrame.this, "确定要退出吗?")== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u9000\u51FA.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u5B66\u751F\u7BA1\u7406.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent(e);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u6DFB\u52A0.png")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5B66\u751F\u5217\u8868");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageStudent(e);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u7528\u6237\u5217\u8868.png")));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		mnNewMenu_2.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u73ED\u7EA7\u7BA1\u7406.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u6DFB\u52A0\u73ED\u7EA7");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addClazz(ae);
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u6DFB\u52A0.png")));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u73ED\u7EA7\u7BA1\u7406");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				manageClazz(ae);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u73ED\u7EA7\u5217\u8868.png")));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("\u6559\u5E08\u7BA1\u7406");
		mnNewMenu_3.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u8001\u5E08.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u6DFB\u52A0\u6559\u5E08");
		mntmNewMenuItem_6.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u6DFB\u52A0.png")));
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u6559\u5E08\u5217\u8868");
		mntmNewMenuItem_7.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u8001\u5E08.png")));
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_4 = new JMenu("\u6210\u7EE9\u7BA1\u7406");
		mnNewMenu_4.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u6210\u7EE9\u7BA1\u74061.png")));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u6210\u7EE9\u5217\u8868");
		mntmNewMenuItem_9.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u6210\u7EE9\u5355.png")));
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u6210\u7EE9\u7EDF\u8BA1");
		mntmNewMenuItem_8.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u6210\u7EE9\u7EDF\u8BA11.png")));
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_5 = new JMenu("\u5E2E\u52A9");
//		mnNewMenu_5.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				aboutUs(ae);
//			}
//		});
		mnNewMenu_5.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u5E2E\u52A9.png")));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		mntmNewMenuItem_10.setIcon(new ImageIcon(SystemFrame.class.getResource("/imageSource/\u5173\u4E8E\u6211\u4EEC.png")));
		mnNewMenu_5.add(mntmNewMenuItem_10);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	protected void manageClazz(ActionEvent ae) {
		// TODO Auto-generated method stub
		ClazzManageFrame clazzManageFrame = new ClazzManageFrame();
		clazzManageFrame.setVisible(true);
		desktopPane.add(clazzManageFrame);
	}
	
	protected void manageStudent(ActionEvent e) {
		StudentManageFrame clazzManageFrame = new StudentManageFrame();
		clazzManageFrame.setVisible(true);
		desktopPane.add(clazzManageFrame);
	}
	protected void addStudent(ActionEvent e) {
		AddStudentFrame editPassword = new AddStudentFrame();
		editPassword.setVisible(true);
		desktopPane.add(editPassword);
	}

	protected void addClazz(ActionEvent ae) {
		// TODO Auto-generated method stub
		AddClazzFrame editPassword = new AddClazzFrame();
		editPassword.setVisible(true);
		desktopPane.add(editPassword);
	}

	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		EditPasswordFrame editPassword = new EditPasswordFrame();
		editPassword.setVisible(true);
		desktopPane.add(editPassword);
	}

	protected void aboutUs(ActionEvent ae) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String info = "【关于我们】\n";
		info += "网址：https://share.mubu.com/doc/mKEWL9biaS\n";
		info += "方便学生管理，你值得拥有!";
		String[] buttons = {"迫不及待去看看!","心情不好以后再说!"};
		int ret = JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(LoginFrm.class.getResource("/imageSource/logo.png")), buttons, null);
		if(ret == 0){
			//采用Java 调用系统浏览器打开制定
			try {
				URI uri = new URI("https://share.mubu.com/doc/mKEWL9biaS");

				Desktop.getDesktop().browse(uri);
				//Runtime.getRuntime().exec("explorer http://programmer.ischoolbar.com");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(this, "再见！");
		}
	}

}
