package Oracle11g.GUI;

import java.awt.event.KeyEvent;

import java.awt.event.*;

import java.util.List;
import Oracle11g.Entity.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;

import Oracle11g.Entity.AbstractAdmin;

public class userManage extends javax.swing.JFrame {
	private javax.swing.JButton queryButton;//查询
    private javax.swing.JButton addButton;//添加
    private javax.swing.JButton editButton;//修改
    private javax.swing.JButton saveButton;//落实
    private JCheckBox autoSave;//自动落实
    private javax.swing.JButton deleteButton;//删除
    private javax.swing.JPanel MyPanel;
    private javax.swing.JScrollPane MyScrollPane;
    private javax.swing.JTable MyTable;
    private DefaultTableModel model;
    private javax.swing.JTextField MyTextField;
    private javax.swing.JToggleButton returnButton;
    private javax.swing.JToggleButton closeButton;  
    private Object table_data[][] = null;
    private String column[] = null;
    boolean isChange_edit = false;
    boolean isChange_add = false;

    public userManage() {
        initComponents();
    }

    private void initComponents() {

        try{
            AbstractAdmin.getAdmin().getConnection();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"错误提示", JOptionPane.WARNING_MESSAGE);
        }

        MyPanel = new javax.swing.JPanel();
        returnButton = new javax.swing.JToggleButton();
        closeButton = new javax.swing.JToggleButton();
        queryButton = new javax.swing.JButton();
        MyScrollPane = new javax.swing.JScrollPane();
        MyTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        saveButton = new  javax.swing.JButton();
        autoSave = new JCheckBox();
        deleteButton = new javax.swing.JButton();
        MyTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MyPanel.setBackground(new java.awt.Color(120, 150, 190));
        MyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "用户管理模块", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("微软雅黑", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
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

        editButton.setText("修改");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        saveButton.setText("落实");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        autoSave.setText("自动落实");
        autoSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoSaveActionPerformed(evt);
            }
        });

        column = new String [] {
            "身份证号", "姓名", "性别", "出生日期", "住址", "民族"
        };

        model = new DefaultTableModel(table_data, column);

        MyTable.setModel(model);
        MyScrollPane.setViewportView(MyTable);

        addButton.setText("添加行");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("删除行");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        queryButton.setText("查询");
        queryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MyPanelLayout = new javax.swing.GroupLayout(MyPanel);
        MyPanel.setLayout(MyPanelLayout);
        MyPanelLayout.setHorizontalGroup(
        		MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyPanelLayout.createSequentialGroup()
                        .addGap(0, 699, Short.MAX_VALUE)
                        .addComponent(returnButton)
                        .addGap(18, 18, 18)
                        .addComponent(closeButton))
                    .addGroup(MyPanelLayout.createSequentialGroup()
                        .addComponent(MyScrollPane)
                        .addContainerGap())
                    
                    .addGroup(MyPanelLayout.createSequentialGroup()
                    	.addComponent(saveButton)
                    	.addGap(18, 18, 18)
                    	.addComponent(autoSave)
                    		)
                    .addGroup(MyPanelLayout.createSequentialGroup()
                        .addComponent(MyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(queryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addGap(54, 54, 54))))
        );
        MyPanelLayout.setVerticalGroup(
        		MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(queryButton)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(editButton)
                    )
                .addGap(18, 18, 18)
                .addComponent(MyScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                	.addComponent(saveButton)
                	.addComponent(autoSave))
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
                .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(MyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
        );

        pack();
    }                     

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
		//无效输入
    	isChange_edit = true;
        int slrow = MyTable.getSelectedRow();
        if(slrow >= 0){
            String[] origin_val = new String[6];
            for(int i = 0;i < 6;i++)
                origin_val[i] = MyTable.getValueAt(slrow, i).toString();
            MyTable.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    if(ke.getKeyChar() == KeyEvent.VK_ENTER && isChange_edit) {
                        try{
                            int current_slrow = MyTable.getSelectedRow();
                            if(current_slrow >= 0 && current_slrow == slrow) {
                                String []val = new String[6];
                                for(int i = 0;i < 6; i++)
                                    val[i] = MyTable.getValueAt(slrow, i).toString();
                                int res = AbstractAdmin.getAdmin().executeUpdate("Person", val, origin_val);
                                if(res != 1)
                                    JOptionPane.showMessageDialog(null, "修改失败", "修改错误提示", JOptionPane.ERROR_MESSAGE);
                                else
                                    JOptionPane.showMessageDialog(null, "修改成功", "修改成功提示", JOptionPane.INFORMATION_MESSAGE);
                            }

                        }catch(Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(),"修改错误提示", JOptionPane.WARNING_MESSAGE);
                        }
                        finally{
                            isChange_edit = false;
                        }
                    }
                }
            });
        }
    }                     
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
		isChange_add = true;
    	model.addRow(new String[6]);
    	MyTable.addKeyListener(new KeyAdapter() {
    		public void keyPressed(KeyEvent ke) {
    			if(ke.getKeyChar() == KeyEvent.VK_ENTER && isChange_add) {
    				try {
    					int slrow = MyTable.getSelectedRow();
    					String []val = new String[6];
    					for(int i = 0;i < 6; i++){
    						val[i] = MyTable.getValueAt(slrow, i).toString();
    					}
    					int res = AbstractAdmin.getAdmin().executeInsert("Person", val);
    					if(res != 1){
        					JOptionPane.showMessageDialog(null, "添加失败", "添加失败提示", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
    					    JOptionPane.showMessageDialog(null, "添加成功", "添加成功提示", JOptionPane.INFORMATION_MESSAGE);
                        }
    					
    				}catch(Exception e) {
    					JOptionPane.showMessageDialog(null, e.getMessage(),"添加错误提示", JOptionPane.WARNING_MESSAGE);
    				}
                    finally{
                        isChange_add = false;
                    }
    			}
    		}
    	});
	}
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//无效输入
		//获取删除行
		int delrow = MyTable.getSelectedRow();
		if(delrow >= 0) {
			try {
                String[] origin_data = new String[6];
                for(int i = 0;i < 6;i++)
                    origin_data[i] = MyTable.getValueAt(delrow, i).toString();
				int res = AbstractAdmin.getAdmin().executeDelete("Person", origin_data);
				if(res != 1)
					JOptionPane.showMessageDialog(null, "删除失败", "删除失败提示", JOptionPane.ERROR_MESSAGE);
				else
				{
					model.removeRow(delrow);
//					int len = table_data.length;
//					Object[][] tempt = new Object[len - 1][14];
//					for(int i = 0;i < len - 1;i++) {
//						if(i == delrow)
//							continue;
//						for(int j = 0;j < 14;j++)
//							tempt[i][j] = table_data[i][j];
//					}
					JOptionPane.showMessageDialog(null,"删除成功", "删除成功", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"删除错误提示", JOptionPane.WARNING_MESSAGE);
			}

    }}
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	//落实
        try{
    	    AbstractAdmin.getAdmin().commit();
            JOptionPane.showMessageDialog(null, "落实完成","提示", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"落实错误提示", JOptionPane.WARNING_MESSAGE);
        }
    
    	
    }
    private void autoSaveActionPerformed(java.awt.event.ActionEvent evt) {
    	//自动落实
        try{
    	    AbstractAdmin.getAdmin().setAutoCommit(autoSave.isSelected());    
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"错误提示", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void queryButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
		// String text = MyTextField.getText();
        try{
            List<Person> list = AbstractAdmin.getAdmin().getPerson(MyTextField.getText());
            int length = list.size();
            table_data = new Object[length][column.length];
            for(int i = 0;i < length;i++){
                int count = 0;
                table_data[i][count++] = list.get(i).getID();
                table_data[i][count++] = list.get(i).getName();
                table_data[i][count++] = list.get(i).getSex();
                table_data[i][count++] = list.get(i).getBday();
                table_data[i][count++] = list.get(i).getAddress();
                table_data[i][count] = list.get(i).getNationality();
            }
            model = new DefaultTableModel(table_data, column);
            MyTable.setModel(model);
        } catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(),"查询错误提示", JOptionPane.WARNING_MESSAGE);
        }
 
    }

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
       userManage.this.setVisible(false);
        main_op main_op=new main_op();
        main_op.setVisible(true);
        //关闭数据库连接
        try{
            AbstractAdmin.getAdmin().closeConnection();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"错误提示", JOptionPane.WARNING_MESSAGE);
        }
    }                                              

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {   
        //关闭数据库连接
        try{
            AbstractAdmin.getAdmin().closeConnection();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"错误提示", JOptionPane.WARNING_MESSAGE);
        }
        System.exit(0);
    }                                              

    //主函数
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userManage().setVisible(true);
            }
        });
    }
               
}