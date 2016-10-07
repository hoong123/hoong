package zqx.login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.*;

import zqx.info.StudentInfo;
import zqx.info.UI;


public class Login extends JFrame implements ActionListener{
	//��ȡ����IP
	private static String getIpAddress() throws UnknownHostException { 
		InetAddress address = InetAddress.getLocalHost(); 
		return address.getHostAddress(); 
	}
	
	JButton jb1,jb2=null;  
    //JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4,jp5=null;  
    JTextField jtf1, jtf2=null;  
    JLabel jlb1,jlb2,jlb3, jlb4=null;  
    JPasswordField jpf=null;  
    ButtonGroup bg=null;  
              
    public static void main(String[] args) {   
        Login ms=new Login();  
    }
    
    public Login()  
    {  
         //�������  
        jb1=new JButton("��¼");  
        jb2=new JButton("����");  
        //���ü���  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
          
        //jrb1=new JRadioButton("��ʦ");  
        //jrb2=new JRadioButton("ѧ��");  
        //bg=new ButtonGroup();  
        //bg.add(jrb1);  
        //bg.add(jrb2);  
        //jrb2.setSelected(true);  
          
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        //jp4=new JPanel();
        jp5=new JPanel();
          
        jlb1=new JLabel("ѧ    �ţ�");
        jlb3=new JLabel("��    �룺");  
        //jlb4=new JLabel("Ȩ    �ޣ�");
        jlb2=new JLabel("��    ����");
          
        jtf1=new JTextField(10);
        jtf2=new JTextField(10);
        jpf=new JPasswordField(10);  
        //���뵽JPanel��  
        jp1.add(jlb1);  
        jp1.add(jtf1);  
        
        jp2.add(jlb2);
        jp2.add(jtf2);
        
        jp3.add(jlb3);  
        jp3.add(jpf);  
          
        //jp4.add(jlb4);  
        //jp4.add(jrb1);  
        //jp4.add(jrb2);  
          
        jp5.add(jb1);  
        jp5.add(jb2);  
          
        //����JFrame��  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        //this.add(jp4);
        this.add(jp5);
        //���ò��ֹ�����  
        this.setLayout(new GridLayout(4,1));  
        //���������ñ���  
        this.setTitle("Զ��������ϵͳ");  
        //���ô����С  
        this.setSize(300,210);  
        //���ô����ʼλ��  
        this.setLocation(200, 150);  
        //���õ��رմ���ʱ����֤JVMҲ�˳�  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //��ʾ����  
        this.setVisible(true);  
        this.setResizable(true);  
          
    }
    
    public void actionPerformed(ActionEvent e) {  
          
        if(e.getActionCommand()=="��¼")  
        {  
//            //���ѡ�н�ʦ��¼  
//            if(jrb1.isSelected())  
//            {  
//                   
//            }else if(jrb2.isSelected()) //ѧ���ڵ�¼ϵͳ  
//            {  
            	stulogin();
//            }  
              
        }else if(e.getActionCommand()=="����")  
        {  
              clear();  
        }             
          
    }
    
  //ѧ����¼�жϷ���  
    public void stulogin()  
    {  
        if(jtf1.getText().isEmpty()||jtf2.getText().isEmpty()||jpf.getPassword().length == 0)  
        {  
            JOptionPane.showMessageDialog(null,"������ѧ�š����������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
        }else{  
        	System.out.println("��¼�ɹ�");  
            JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
            String id = jtf1.getText();
            String username = jtf2.getText();
            clear();
            dispose();
            try {
				StudentInfo studentinfo = new StudentInfo(id, username, getIpAddress());
				studentinfo.initialize(getIpAddress(), 5000);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
            //UI ui=new UI();
        }  
    }
    
    public  void clear()  
    {  
        jtf1.setText("");
        jtf2.setText("");
        jpf.setText("");  
    }  
}
