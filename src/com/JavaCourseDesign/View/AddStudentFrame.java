package com.JavaCourseDesign.View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.JavaCourseDesign.Dao.StudentDao;
import com.JavaCourseDesign.Model.Student;
import com.JavaCourseDesign.Util.StringUtil;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddStudentFrame extends JInternalFrame {
	private JTextField stu_idTextArea;
	private JTextField stu_nameTextArea;
	private JTextField stu_claidTextArea;
	private JTextField stu_sexTextArea;
	private JPanel panel;
	private static JLabel lblNewLabel_4;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentFrame frame = new AddStudentFrame();
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
	public AddStudentFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u6DFB\u52A0\u5B66\u751F");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
		lblNewLabel.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/imageSource/\u5B66\u751F\u7BA1\u7406.png")));
		lblNewLabel.setBounds(46, 56, 58, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7");
		lblNewLabel_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/imageSource/\u73ED\u7EA7\u540D\u79F0.png")));
		lblNewLabel_1.setBounds(46, 133, 58, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/imageSource/\u6027\u522B.png")));
		lblNewLabel_2.setBounds(46, 173, 58, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u59D3\u540D");
		lblNewLabel_3.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/imageSource/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		lblNewLabel_3.setBounds(46, 95, 58, 15);
		getContentPane().add(lblNewLabel_3);
		
		stu_idTextArea = new JTextField();
		stu_idTextArea.setBounds(136, 53, 114, 21);
		getContentPane().add(stu_idTextArea);
		stu_idTextArea.setColumns(10);
		
		stu_nameTextArea = new JTextField();
		stu_nameTextArea.setBounds(136, 92, 114, 21);
		getContentPane().add(stu_nameTextArea);
		stu_nameTextArea.setColumns(10);
		
		stu_claidTextArea = new JTextField();
		stu_claidTextArea.setBounds(136, 133, 114, 21);
		getContentPane().add(stu_claidTextArea);
		stu_claidTextArea.setColumns(10);
		
		stu_sexTextArea = new JTextField();
		stu_sexTextArea.setBounds(136, 170, 114, 21);
		getContentPane().add(stu_sexTextArea);
		stu_sexTextArea.setColumns(10);
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitStudent(e);
			}
		});
		submitButton.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/imageSource/\u786E\u8BA4.png")));
		submitButton.setBounds(69, 220, 97, 23);
		getContentPane().add(submitButton);
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		resetButton.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/imageSource/\u91CD\u7F6E.png")));
		resetButton.setBounds(269, 220, 97, 23);
		getContentPane().add(resetButton);
		
		btnNewButton = new JButton("\u4E0A\u4F20\u5934\u50CF");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addpicture(btnNewButton);
			}
		});
		btnNewButton.setBounds(297, 165, 97, 23);
		getContentPane().add(btnNewButton);
		
		panel = new JPanel();
		panel.setBounds(297, 56, 97, 98);
		getContentPane().add(panel);
		
		lblNewLabel_4 = new JLabel("");
		panel.add(lblNewLabel_4);

	}
	protected void submitStudent(ActionEvent e) {
		int studentid=Integer.parseInt(stu_idTextArea.getText().toString());
		String studentname=stu_nameTextArea.getText().toString();
		int studentclaid=Integer.parseInt(stu_claidTextArea.getText().toString());
		String studentsex=stu_sexTextArea.getText().toString();
		if(StringUtil.isEmpty(studentname)) {
			JOptionPane.showMessageDialog(this, "ѧ����������Ϊ�գ�");
			return;
		}
		Student scl=new Student();
		scl.setId(studentid);
		scl.setName(studentname);
		scl.setCla_id(studentclaid);
		scl.setSex(studentsex);
		StudentDao studentDao=new StudentDao();
		if(studentDao.addStudent(scl)) {
			JOptionPane.showMessageDialog(this, "ѧ����ӳɹ���");
		}else {
			JOptionPane.showMessageDialog(this, "ѧ�����ʧ�ܣ�");
		}
		studentDao.closeDao();
		resetValue(e);
	}
	protected void resetValue(ActionEvent e) {
		stu_idTextArea.setText("");
		stu_nameTextArea.setText("");
		stu_claidTextArea.setText("");
		stu_sexTextArea.setText("");
	}
	protected void addpicture(JButton button) {
		JFileChooser chooser = new JFileChooser();
		  chooser.setMultiSelectionEnabled(true);
		  /** �����ļ����� * */
		  FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg","png");
		  chooser.setFileFilter(filter);
		  int returnVal = chooser.showOpenDialog(button);
		  if (returnVal == JFileChooser.APPROVE_OPTION) { 
		   /** �õ�ѡ����ļ�* */
		   File[] arrfiles = chooser.getSelectedFiles();
		   if (arrfiles == null || arrfiles.length == 0) {
		    return;
		   }
		   //�ж��Ƿ����ļ�Ϊjpg����png
		 File  ff = chooser.getSelectedFile();
		 //����һ��fileName�õ�ѡ���ļ�������
		 String fileName =ff.getName();
		 //lastIndexOf(".") ����"."���ļ��������һ�γ��ֵ��±�
		 //substring(int index)��ָ����index��ʼ��ȡ������ַ���
		 //���磺 a.txt ���һ�γ��ֵ�.�±��� 1 substring(1)���Ǵ��±�1��λ�ÿ�ʼ��ȡ ��ȡ������ַ���Ϊ .txt
		 //����������Ҫ+1 ����ֻ��ȡ�ļ����� txt
		 String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
		 //�ж�ѡ����ļ��Ƿ���ͼƬ�ļ� �����ų����ǵ���� ��Ȼ���������ᱨ��
		 if(!(prefix.equals("jpg") || prefix.equals("png"))){
		 JOptionPane.showMessageDialog(new JDialog(),":��ѡ��.jpg �� .png��ʽ��ͼƬ");
		 return;
		 }
		   FileInputStream input = null;
		   FileOutputStream out = null;
		   //Ҫ�ϴ�����·���������������Ҫ��ͼƬ��·��
		   String path = "D:/eclipse/workspace/StudentManagementSystemGUI/pages";
		   try {
		    for (File f : arrfiles) {
		     File dir = new File(path);
		     /** Ŀ���ļ��� * */
		     File[] fs = dir.listFiles();
		     String set = new String();
		     for (File file : fs) {
		      set=set+file.getName();
		     }
		     
		   //ͨ���ļ�ѡ���������õ�ѡ����ļ�.�õ����ļ��ľ���·��
		     String absolutePath = chooser.getSelectedFile().getAbsolutePath();
		   //����һ��ImageIcon���� ����ͼƬ�ļ��ľ���·��
		     ImageIcon imageIcon = new ImageIcon(absolutePath);
		     
		     imageIcon.setImage(imageIcon.getImage().getScaledInstance(97, 98, Image.SCALE_DEFAULT));
		     
		     lblNewLabel_4.setIcon(imageIcon);
		     lblNewLabel_4.getIcon();
		     input = new FileInputStream(f);
		     byte[] buffer = new byte[1024];
		     File des = new File(path, f.getName());
		     out = new FileOutputStream(des);
		     int len = 0;
		     while (-1 != (len = input.read(buffer))) {
		      out.write(buffer, 0, len);
		     }
		     out.close();
		     input.close();
		    }
		    JOptionPane.showMessageDialog(null, "�ϴ��ɹ���", "��ʾ",
		      JOptionPane.INFORMATION_MESSAGE);
		   } catch (FileNotFoundException e1) {
		    JOptionPane.showMessageDialog(null, "�ϴ�ʧ�ܣ�", "��ʾ",
		      JOptionPane.ERROR_MESSAGE);
		    e1.printStackTrace();
		   } catch (IOException e1) {
		    JOptionPane.showMessageDialog(null, "�ϴ�ʧ�ܣ�", "��ʾ",
		      JOptionPane.ERROR_MESSAGE);
		    e1.printStackTrace();
		   }
		  }
	}
}
