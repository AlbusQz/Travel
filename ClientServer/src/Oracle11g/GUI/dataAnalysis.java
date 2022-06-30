package Oracle11g.GUI;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import Oracle11g.Entity.AbstractAdmin;

public class dataAnalysis extends javax.swing.JFrame {
	
	private JButton lineButton;//路线统计
	private JButton insuranceButton;//保险统计
	private JButton historyButton1;//订单类型统计
	private JButton historyButton2;//订单数量统计
	private JPanel MyPanel;
	private JToggleButton returnButton;
	private JToggleButton closeButton;
	private JPanel chartPanel;

	
	public dataAnalysis() {
		initComponents();
	}
    private void initComponents() {

        try{
            AbstractAdmin.getAdmin().getConnection();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"错误提示", JOptionPane.WARNING_MESSAGE);
        }

		MyPanel = new JPanel();
		
		lineButton = new JButton();
		insuranceButton = new JButton();
		historyButton1 = new JButton();
		historyButton2 = new JButton();
		
		//MyScrollPane = new JScrollPane();
		chartPanel = new JPanel();

		returnButton = new JToggleButton();
		closeButton = new JToggleButton();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		MyPanel.setBackground(new java.awt.Color(120, 150, 190));
		MyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "数据分析模块", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("微软雅黑", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
		MyPanel.setAutoscrolls(true);

        closeButton.setText("退出");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	closeButtonActionPerformed(evt);
            }
        });

        returnButton.setText("返回");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	returnButtonActionPerformed(evt);
            }
        });

        lineButton.setText("      路  线  统  计      ");
        lineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
				lineButtonActionPerformed(evt);
            }
        });

        insuranceButton.setText("  保 险 公 司 统 计  ");
        insuranceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	insuranceButtonActionPerformed(evt);
            }
        });

        historyButton1.setText("  订 单 类 型 统 计  ");
        historyButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	historyButton1ActionPerformed(evt);
            }
        });

        historyButton2.setText("每日订单数量统计");
        historyButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	historyButton2ActionPerformed(evt);
            }
        });

        
        javax.swing.GroupLayout MyPanelLayout = new javax.swing.GroupLayout(MyPanel);
        MyPanel.setLayout(MyPanelLayout);
        MyPanelLayout.setHorizontalGroup(
        		MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lineButton)
                    .addComponent(insuranceButton)
                    .addComponent(historyButton1)
                    .addComponent(historyButton2))
                .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MyPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 474, Short.MAX_VALUE)
                        .addComponent(returnButton)
                        .addGap(18, 18, 18)
                        .addComponent(closeButton))
                    .addGroup(MyPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 570 , javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        MyPanelLayout.setVerticalGroup(
        		MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyPanelLayout.createSequentialGroup()
                .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lineButton)
                        .addGap(18, 18, 18)
                        .addComponent(insuranceButton)
                        .addGap(18, 18, 18)
                        .addComponent(historyButton1)
                        .addGap(18, 18, 18)
                        .addComponent(historyButton2)
                        .addGap(18, 18, 18)
                        .addComponent(insuranceButton))
                    .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }// </editor-fold>                        

    private void lineButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	BarChart chart = null;
		try {
			chart = new BarChart();
		} catch (Exception e) {
			e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "错误提示", JOptionPane.ERROR_MESSAGE);
		}
        
		JPanel jpanel = chart.getChartPanel();
		jpanel.setPreferredSize(new Dimension(570,334));
        chartPanel.removeAll();
		chartPanel.add(jpanel);
        chartPanel.updateUI();
    } 
    
    private void insuranceButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	PieChart_Insurance chart = null;
		try {
			chart = new PieChart_Insurance();
		} catch (Exception e) {
			e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "错误提示", JOptionPane.ERROR_MESSAGE);
		}
		JPanel jpanel = chart.getChartPanel();
		jpanel.setPreferredSize(new Dimension(570,334));
        chartPanel.removeAll();
		chartPanel.add(jpanel);
        chartPanel.updateUI();
    }
    
    private void historyButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
    	PieChart_Order chart = null;
		try {
			chart = new PieChart_Order();
		} catch (Exception e) {
			e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "错误提示", JOptionPane.ERROR_MESSAGE);
		}
		JPanel jpanel = chart.getChartPanel();
		jpanel.setPreferredSize(new Dimension(570,334));
        chartPanel.removeAll();
		chartPanel.add(jpanel);
        chartPanel.updateUI();
    } 
    
    private void historyButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	TimeSeriesChart chart = null;
		try {
			chart = new TimeSeriesChart();
		} catch (Exception e) {
			e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "错误提示", JOptionPane.ERROR_MESSAGE);
		}
		JPanel jpanel = chart.getChartPanel();
		jpanel.setPreferredSize(new Dimension(570,334));
        chartPanel.removeAll();
		chartPanel.add(jpanel);
        chartPanel.updateUI();
    } 
    

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        System.exit(0);
    }                                              

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	dataAnalysis.this.setVisible(false);
        main_op main_op = new main_op();
        main_op.setVisible(true);
    }                                              
    
    public static void main(String args[]) {

        new dataAnalysis().setVisible(true);

    }
}
                

