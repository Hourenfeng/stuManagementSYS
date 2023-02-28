package com.JavaCourseDesign.View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.JavaCourseDesign.Dao.ClazzDao;
import com.JavaCourseDesign.Model.Clazz;
import com.JavaCourseDesign.Util.StringUtil;

public class AddClazzFrame extends JInternalFrame {
	private JTextField clazzNameTextField;
	private JTextArea clazzInfoTextArea;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddClazzFrame frame = new AddClazzFrame();
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
	public AddClazzFrame() {
		setTitle("\u6DFB\u52A0\u73ED\u7EA7\u4FE1\u606F");
		setBounds(100, 100, 450, 300);
		setClosable(true);   //可以被关闭
		setIconifiable(true);  //可以被最小化
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AddClazzFrame.class.getResource("/imageSource/\u73ED\u7EA7\u540D\u79F0.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\u4ECB\u7ECD:");
		lblNewLabel_1.setIcon(new ImageIcon(AddClazzFrame.class.getResource("/imageSource/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		
		clazzNameTextField = new JTextField();
		clazzNameTextField.setColumns(10);
		
		clazzInfoTextArea = new JTextArea();
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitClazz(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddClazzFrame.class.getResource("/imageSource/\u786E\u8BA4.png")));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddClazzFrame.class.getResource("/imageSource/\u91CD\u7F6E.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(clazzInfoTextArea)
						.addComponent(clazzNameTextField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
					.addContainerGap(152, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(95))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(clazzNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(clazzInfoTextArea, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(66))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submitClazz(ActionEvent ae) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String className = clazzNameTextField.getText().toString();
				String classInfo = clazzInfoTextArea.getText().toString();
				if(StringUtil.isEmpty(className)){
					JOptionPane.showMessageDialog(this, "班级名称不能为空！");
					return;
				}
				Clazz scl = new Clazz();
				scl.setName(className);
				scl.setInfo(classInfo);
				ClazzDao clazzDao = new ClazzDao();
				if(clazzDao.addClass(scl)){
					JOptionPane.showMessageDialog(this, "班级添加成功！");
				}else{
					JOptionPane.showMessageDialog(this, "班级添加失败！");
				}
				clazzDao.closeDao();
				resetValue(ae);
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		clazzNameTextField.setText("");
		clazzInfoTextArea.setText("");
	}
}
