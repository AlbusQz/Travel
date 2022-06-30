package Oracle11g.GUI;

import javax.swing.JPanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class main_op extends javax.swing.JFrame {
	private JButton userButton;
	private JButton mulButton;
	private JButton orderButton;
	private JButton dataButton;
	private JToggleButton returnButton;
	private JToggleButton closeButton;
	private JPanel MyPanel;

	private JPanel imgPanel;
	private JLabel JLabel;

	public main_op() {
		initComponents();
	}

	private void initComponents() {
		MyPanel = new JPanel();
		userButton = new JButton();
		mulButton = new JButton();
		orderButton = new JButton();
		dataButton = new JButton();
		
		returnButton = new JToggleButton();
		closeButton = new JToggleButton();
		//图片
		
		imgPanel = new JPanel();
		ImageIcon img = new ImageIcon(".\\logo\\logo.jpg");
		img =new ImageIcon(img.getImage().getScaledInstance(470, 450, Image.SCALE_DEFAULT)); 
	    JLabel = new JLabel();
	    JLabel.setIcon(img);
		imgPanel.add(JLabel);
		imgPanel.setBackground(new java.awt.Color(120,150,190));
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		MyPanel.setBackground(new java.awt.Color(120,150,190));
		MyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "旅游信息管理系统", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("微软雅黑", 1, 24), new java.awt.Color(255, 255, 255)));
		MyPanel.setAutoscrolls(true);//?
		
		returnButton.setText("返回");
		returnButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				main_op.this.setVisible(false);
				//显示登录界面
	
			}
		});
		
		closeButton.setText("退出");
		closeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});
		
		userButton.setText("用户管理");
		userButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				userButtonActionPerformed(evt);
			}
		});
		
		mulButton.setText("内容管理");
		mulButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mulButtonActionPerformed(evt);
			}
		});
		
		orderButton.setText("订单管理");
		orderButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				orderButtonActionPerformed(evt);
			}
		});
		
		dataButton.setText("数据分析");
		dataButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dataButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout MyPanelLayout = new javax.swing.GroupLayout(MyPanel);
        MyPanel.setLayout(MyPanelLayout);
        MyPanelLayout.setHorizontalGroup(
        		MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userButton)
                    .addComponent(mulButton)
                    .addComponent(orderButton)
                    .addComponent(dataButton))
                .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MyPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 474, Short.MAX_VALUE)
                        .addComponent(returnButton)
                        .addGap(18, 18, 18)
                        .addComponent(closeButton))
                    .addGroup(MyPanelLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
        );
        MyPanelLayout.setVerticalGroup(
        		MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyPanelLayout.createSequentialGroup()
                .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userButton)
                        .addGap(18, 18, 18)
                        .addComponent(mulButton)
                        .addGap(18, 18, 18)
                        .addComponent(orderButton)
                        .addGap(18, 18, 18)
                        .addComponent(dataButton))
                    .addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnButton)
                    .addComponent(closeButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(MyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(MyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(435, Short.MAX_VALUE))
        );

        pack();
    } 	
	private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {
		main_op.this.setVisible(false);
		//用户管理
		userManage userManage = new userManage();
		userManage.setVisible(true);
	}
	private void mulButtonActionPerformed(java.awt.event.ActionEvent evt) {
		main_op.this.setVisible(false);
		//内容管理
		mulManage mulManage = new mulManage();
		mulManage.setVisible(true);
	}
	private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {
		main_op.this.setVisible(false);
		//订单管理
		orderManage orderManage = new orderManage();
		orderManage.setVisible(true);
	}
	private void dataButtonActionPerformed(java.awt.event.ActionEvent evt) {
		main_op.this.setVisible(false);
		//数据分析
		dataAnalysis dataAnalysis = new dataAnalysis();
		dataAnalysis.setVisible(true);
	}
	
	public static void main(String args[]) {
		//try catch
		new main_op().setVisible(true);	
	}
}
