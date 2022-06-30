package Oracle11g.GUI;

import java.awt.*;
import java.awt.event.*;
    
import javax.swing.*;
import javax.swing.border.*;

import Oracle11g.Entity.*;

public class MainUI extends JFrame implements ActionListener{

    private JTextField jTextField_account;
    private JPasswordField jTextField_password;
    // private JTextField jTextField_verifyCode;

    private JButton jButton_login;

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    new MainUI();
                } 
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public MainUI()
    {
        super("旅游管理系统");
		setBounds(420, 200, 450, 320);
		JPanel jpanel_main = new JPanel();
        jpanel_main.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jpanel_main);
        jpanel_main.setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //jlabels
        JLabel jLabel_account = new JLabel(" 账号  : ");
        JLabel jLabel_password = new JLabel(" 密码  : ");
        // JLabel jLabel_verifyCode = new JLabel("验证码 : ");

        jLabel_account.setFont(new Font("宋体",Font.PLAIN,16));
        jLabel_password.setFont(new Font("宋体",Font.PLAIN,16));
        // jLabel_verifyCode.setFont(new Font("宋体",Font.PLAIN,16));

        jLabel_account.setBounds(100, 60, 80, 20);
        jLabel_password.setBounds(100, 120, 80, 20);
        // jLabel_verifyCode.setBounds(100, 160, 80, 20);

        //jtextfields
        this.jTextField_account = new JTextField();
        this.jTextField_password = new JPasswordField();
        this.jTextField_password.setEchoChar('*');
        // this.jTextField_verifyCode = new JTextField();

        this.jTextField_account.setBounds(200, 60, 120, 20);
        this.jTextField_password.setBounds(200, 120, 120, 20);
        // this.jTextField_verifyCode.setBounds(200, 160, 120, 20);

        this.jTextField_password.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if(ke.getKeyChar() == KeyEvent.VK_ENTER) {
                    jButton_login.doClick();
                }
            }
        });

        //jbutton
        this.jButton_login = new JButton("登录");
        this.jButton_login.setFont(new Font("宋体",Font.PLAIN,20));
        this.jButton_login.setBounds(165, 200, 75, 35);
        this.jButton_login.addActionListener(this);

        jpanel_main.add(jLabel_account);
        jpanel_main.add(jLabel_password);
        // jpanel_main.add(jLabel_verifyCode);

        jpanel_main.add(this.jTextField_account);
        jpanel_main.add(this.jTextField_password);
        // jpanel_main.add(this.jTextField_verifyCode);

        jpanel_main.add(this.jButton_login);

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == this.jButton_login){
            String account = this.jTextField_account.getText();
            String password = String.valueOf(this.jTextField_password.getPassword());
            AbstractAdmin admin = CheckLogin.checkLogin(account, password);
            String errorMessage = admin.getErrorMessage();
            if(errorMessage == null){
                AbstractAdmin.initAdmin(admin);
                this.dispose();
                new main_op().setVisible(true);
                //登录成功,跳转
            }
            else{
                JOptionPane.showMessageDialog(null, errorMessage, "登陆错误提示", JOptionPane.WARNING_MESSAGE);
            }
        }
        // TODO Auto-generated method stub
    }
}
