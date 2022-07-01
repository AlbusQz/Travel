package Oracle11g.GUI;

import Oracle11g.Entity.*;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import java.awt.Image;

public class mulManage extends javax.swing.JFrame {
	
	private JTabbedPane JTab;
	
	private JPanel[] jPanels;
	private JButton[] queryButtons;
	private JButton[] addButtons;
	private JButton[] editButtons;
	private JButton[] saveButtons;
	private JButton[] deleteButtons;
	private JCheckBox[] autoSaves;
	private JScrollPane[] jScrollPanes;
    private JTable[] jTables;
    private DefaultTableModel[] models;
    private JTextField[] jTextFields;
    
    
    //预览图片
    private JButton[] prevButton;
    //插入图片
    private JButton[] selButton;

    //0 line      路线
    //1 scenic    景点
    //2 hotel     酒店
    //3 tips      攻略
    //4 ticket    车票
    //5 insurance 保险
    //6 room      房间
    
    private JToggleButton[] returnButtons;
    private JToggleButton[] closeButtons;  
    
    private Object table_data0[][] = null;
    private Object table_data1[][] = null;
    private Object table_data2[][] = null;
    private Object table_data3[][] = null;
    private Object table_data4[][] = null;
    private Object table_data5[][] = null;
    private Object table_data6[][] = null;
    
    private String column0[] = null;
    private String column1[] = null;
    private String column2[] = null;
    private String column3[] = null;
    private String column4[] = null;
    private String column5[] = null;
    private String column6[] = null;
    
    //new components are as follows : 
   boolean isChange_edit = false;
   boolean isChange_add = false;

   private Map<Integer, String> map = new HashMap<>();

   private List<Tips> list;     //using for recording conveniently 

    public mulManage() {
        initComponents();
    }
    
    private void initComponents() {

        map.put(0, "Line");
        map.put(1, "Scenic");
        map.put(2, "Hotel");
        map.put(3, "Tips");
        map.put(4, "Ticket");
        map.put(5, "Insurance");
        map.put(6, "Room");

        try{
            AbstractAdmin.getAdmin().getConnection();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"错误提示", JOptionPane.WARNING_MESSAGE);
        }

    	JTab = new JTabbedPane(JTabbedPane.TOP);
        prevButton = new JButton[6];
        selButton = new JButton[6];
    	jPanels = new JPanel[7];
    	jTables = new JTable[7];
    	queryButtons = new JButton[7];
    	addButtons = new JButton[7];
    	editButtons = new JButton[7];
    	saveButtons = new JButton[7];
    	deleteButtons = new JButton[7];
    	autoSaves = new JCheckBox[7];
    	jScrollPanes = new JScrollPane[7];
    	models = new DefaultTableModel[7];
    	jTextFields = new JTextField[7];
    	returnButtons = new JToggleButton[7];
    	closeButtons = new JToggleButton[7];

        for(int i = 0;i < 6;i++){
            int j = i;
    	
            prevButton[i] = new JButton("预览图片");
            selButton[i] = new JButton("插入图片");
            
            prevButton[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    prevButtonActionPerformed(evt, j);
                }
            });
            selButton[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    selButtonActionPerformed(evt ,j);
                }
            });
        }
    	
        column0 = new String[] {
            	"ID", "路线名称", "出发城市", "到达城市", "出发时间", "到达时间", "旅游社", "价格", "简介", "图片"
            		
        };
        column1 = new String [] {
        		"ID", "景点名", "城市", "容量", "价格", "星级", "简介", "图片"
        };
        column2 = new String[] {
            	"ID", "酒店名", "城市", "联系方式", "简介", "图片"
        };
        column3 = new String[] {
            	"ID", "发布用户ID", "发布时间", "文本", "图片"
        };
        column4 = new String[] {
            	"ID", "出发城市", "到达城市", "出发时间", "到达时间", "车票种类", "车票公司", "价格", "图片"
        };
        column5 = new String[] {
                "ID", "名称", "保期", "保险公司", "价格", "简介", "图片"
        };
        column6 = new String[] {
        		"ID", "房间类型", "房间所属酒店ID", "房间容量", "房间价格"
        };
    	
        models[0] = new DefaultTableModel(table_data0, column0);
        models[1] = new DefaultTableModel(table_data1, column1);
        models[2] = new DefaultTableModel(table_data2, column2);
        models[3] = new DefaultTableModel(table_data3, column3);
        models[4] = new DefaultTableModel(table_data4, column4);
        models[5] = new DefaultTableModel(table_data5, column5);
        models[6] = new DefaultTableModel(table_data6, column6);
        
        
    	for(int i = 0; i < 7; i++) {
    		jPanels[i] = new JPanel();
    		jTextFields[i] = new JTextField();
    		returnButtons[i] = new JToggleButton("返回");
    		closeButtons[i] = new JToggleButton("退出");
    		editButtons[i] = new JButton("修改");
    		saveButtons[i] = new JButton("落实");
    		autoSaves[i] = new JCheckBox("自动落实");
        	jTables[i] = new JTable();
        	jScrollPanes[i] = new JScrollPane();
        	jTables[i].setModel(models[i]);
        	jScrollPanes[i].setViewportView(jTables[i]);
        	addButtons[i] = new JButton("添加行");
        	deleteButtons[i] = new JButton("删除行");
        	queryButtons[i] = new JButton("查询");
    	}	

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTab.setBackground(new java.awt.Color(120, 150, 190));
        JTab.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "内容管理模块", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("微软雅黑", 1, 24), new java.awt.Color(0, 0, 0))); // NOI18N
        JTab.setAutoscrolls(true);

        
        for(int i = 0; i < 7; i++) {
        	int j = i;
            closeButtons[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    closeButtonActionPerformed(evt);
                }
            });
            returnButtons[i].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    returnButtonActionPerformed(evt);
                }
            });
            editButtons[j].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    editButtonActionPerformed(evt, j);
                }
            });
            saveButtons[j].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    saveButtonActionPerformed(evt);
                }
            });
            autoSaves[j].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    autoSaveActionPerformed(evt, j);
                }
            });
            addButtons[j].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    addButtonActionPerformed(evt, j);
                }
            });
            deleteButtons[j].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    deleteButtonActionPerformed(evt, j);
                }
            });
            queryButtons[j].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    queryButtonActionPerformed(evt, j);
                }
            });
        }
        
        for(int i = 0; i < 7; i++) {
        	if(i != 6) {
        		jPanels[i].setBackground(new java.awt.Color(120, 150, 190));
                jPanels[i].setAutoscrolls(true);

                javax.swing.GroupLayout MyPanelLayout = new javax.swing.GroupLayout(jPanels[i]);
                jPanels[i].setLayout(MyPanelLayout);
                MyPanelLayout.setHorizontalGroup(
                		MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyPanelLayout.createSequentialGroup()
                                .addGap(0, 699, Short.MAX_VALUE)
                                .addComponent(returnButtons[i])
                                .addGap(18, 18, 18)
                                .addComponent(closeButtons[i]))
                            .addGroup(MyPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPanes[i])
                                .addContainerGap())
                            
                            .addGroup(MyPanelLayout.createSequentialGroup()
                            	.addComponent(saveButtons[i])
                            	.addGap(18, 18, 18)
                            	.addComponent(autoSaves[i])
                            		)
                            .addGroup(MyPanelLayout.createSequentialGroup()
                                .addComponent(jTextFields[i], javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(queryButtons[i])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addButtons[i])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteButtons[i])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editButtons[i])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prevButton[i])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selButton[i])
                                .addGap(54, 54, 54))))
                );
                MyPanelLayout.setVerticalGroup(
                		MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFields[i], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queryButtons[i])
                            .addComponent(addButtons[i])
                            .addComponent(deleteButtons[i])
                            .addComponent(editButtons[i])
                            .addComponent(prevButton[i])
                            .addComponent(selButton[i])
                            )
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPanes[i], javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        	.addComponent(saveButtons[i])
                        	.addComponent(autoSaves[i]))
                        .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(returnButtons[i])
                            .addComponent(closeButtons[i]))
                        .addContainerGap())
                );
            }
        	else {
        		jPanels[i].setBackground(new java.awt.Color(120, 150, 190));
                jPanels[i].setAutoscrolls(true);

                javax.swing.GroupLayout MyPanelLayout = new javax.swing.GroupLayout(jPanels[i]);
                jPanels[i].setLayout(MyPanelLayout);
                MyPanelLayout.setHorizontalGroup(
                		MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyPanelLayout.createSequentialGroup()
                                .addGap(0, 699, Short.MAX_VALUE)
                                .addComponent(returnButtons[i])
                                .addGap(18, 18, 18)
                                .addComponent(closeButtons[i]))
                            .addGroup(MyPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPanes[i])
                                .addContainerGap())
                            
                            .addGroup(MyPanelLayout.createSequentialGroup()
                            	.addComponent(saveButtons[i])
                            	.addGap(18, 18, 18)
                            	.addComponent(autoSaves[i])
                            		)
                            .addGroup(MyPanelLayout.createSequentialGroup()
                                .addComponent(jTextFields[i], javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(queryButtons[i])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addButtons[i])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteButtons[i])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editButtons[i])
                                .addGap(54, 54, 54))))
                );
                MyPanelLayout.setVerticalGroup(
                		MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFields[i], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queryButtons[i])
                            .addComponent(addButtons[i])
                            .addComponent(deleteButtons[i])
                            .addComponent(editButtons[i])
                            )
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPanes[i], javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        	.addComponent(saveButtons[i])
                        	.addComponent(autoSaves[i]))
                        .addGroup(MyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(returnButtons[i])
                            .addComponent(closeButtons[i]))
                        .addContainerGap())
                );
            }
        }

            JTab.addTab("路线管理", jPanels[0]);
            JTab.addTab("景点管理", jPanels[1]);
            JTab.addTab("酒店管理", jPanels[2]);
            JTab.addTab("酒店房间管理", jPanels[6]);
            JTab.addTab("攻略管理", jPanels[3]);
            JTab.addTab("车票管理", jPanels[4]);
            JTab.addTab("保险管理", jPanels[5]);

              
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(JTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(282, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(JTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(359, Short.MAX_VALUE))
            );

            pack();  	
    }// </editor-fold>                        

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt, int i) {

        /**
         * 
         * My suggestions are as follows : 
         * 
         */
        isChange_edit = true;
        int slrow = jTables[i].getSelectedRow();
        if(slrow >= 0){
            final String table = this.map.get(i);
            final int size = (AbstractAdmin.getAdmin().getCountMap().get(table)) - (table.equals("Tips") ? 1 : 0);
            String[] origin_val = new String[size];
            for(int ii = 0;ii < size;ii++){
                Object t = jTables[i].getValueAt(slrow, ii);
                origin_val[ii] = t == null ? "" : t.toString();
            }
            jTables[i].addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    if(ke.getKeyChar() == KeyEvent.VK_ENTER && isChange_edit) {
                        int current_slrow = jTables[i].getSelectedRow();
                        if(current_slrow >= 0 && current_slrow == slrow){
                            try{
                                String[] val = new String[size];
                                for(int ii = 0;ii < size;ii++){
                                    Object t = jTables[i].getValueAt(slrow, ii);
                                    val[i] = t == null ? "" : t.toString();
                                }
                                int res = AbstractAdmin.getAdmin().executeUpdate(table, val, origin_val);
                                if(res != 1)
                                    JOptionPane.showMessageDialog(null, "修改失败", "修改错误提示", JOptionPane.ERROR_MESSAGE);
                                else
                                    JOptionPane.showMessageDialog(null, "修改成功", "修改成功提示", JOptionPane.INFORMATION_MESSAGE);
                            } catch(Exception e){
                                JOptionPane.showMessageDialog(null, e.getMessage(),"修改错误提示", JOptionPane.WARNING_MESSAGE);
                            }
                            finally{
                                isChange_edit = false;
                            }
                        }
                    }
                }
            });
        }
    }                     
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt, int i) {

        if(i == 3)
            return;     //table 'Tips' no need to insert

        isChange_add = true;
        String table = this.map.get(i);
        int size = AbstractAdmin.getAdmin().getCountMap().get(table);
        models[i].addRow(new String[size]);
        jTables[i].addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyChar() == KeyEvent.VK_ENTER && isChange_add){
                    try{
                        int slrow = jTables[i].getSelectedRow();
                        String[] val = new String[size];
                        for(int ii = 0;ii < size;ii++){
                            Object t = jTables[i].getValueAt(slrow, ii);
                            val[i] = t == null ? "" : t.toString();
                        }
                        int res = AbstractAdmin.getAdmin().executeInsert(table, val);
                        if(res != 1)
                            JOptionPane.showMessageDialog(null, "添加失败", "添加错误提示", JOptionPane.ERROR_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, "添加成功", "添加成功提示", JOptionPane.INFORMATION_MESSAGE);

                    } catch(Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage(),"添加错误提示", JOptionPane.WARNING_MESSAGE);
                    }
                    finally{
                        isChange_add = false;
                    }
                }
            }
        });
    	
	}
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt, int i) {
    	
        String table = this.map.get(i);
        int size = AbstractAdmin.getAdmin().getCountMap().get(table);
    	int delrow = jTables[i].getSelectedRow();
        if(delrow >= 0){
            try{
                int res = 0;
                if(table.equals("Tips"))
                    res = AbstractAdmin.getAdmin().executeDelete(table, this.list, delrow);
                else{
                    String[] origin_data = new String[size];
                    for(int ii = 0;ii < size;ii++){
                        Object t = jTables[i].getValueAt(delrow, ii);
                        origin_data[i] = t == null ? "" : t.toString();
                    }
                    res = AbstractAdmin.getAdmin().executeDelete(table, origin_data);
                }
                if(res != 1)
                    JOptionPane.showMessageDialog(null, "删除失败", "删除错误提示", JOptionPane.ERROR_MESSAGE);
                else{
                    models[i].removeRow(delrow);
                    JOptionPane.showMessageDialog(null, "删除成功", "删除成功提示", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(),"删除错误提示", JOptionPane.WARNING_MESSAGE);
            }
        }    
    }
    
    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt, int i) {
    	
		int slrow = jTables[i].getSelectedRow();
        if(slrow >= 0){                                 //necessary
            try{

                Image image = AbstractAdmin.getAdmin().previewPic(map.get(i), list, slrow);
                if(image == null){
                    JOptionPane.showMessageDialog(null,"图片为空，无法查看","提示",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                final JFrame jframe_i = new JFrame("图片预览");
                jframe_i.setBounds(120,120,480,650);
                jframe_i.setLayout(null);
                JLabel jlabel_i = new JLabel(new ImageIcon(image));
                jlabel_i.setBounds(10,10,450,470);
                jframe_i.add(jlabel_i);
                JLabel jlabel_m = new JLabel("是否保存");
                //jlabel_m.setFont(new Font("微软雅黑",Font.PLAIN,20));;
                jlabel_m.setBounds(180,480,120,50);
                jframe_i.add(jlabel_m);
                JButton jbut_yep = new JButton("是");
                JButton jbut_nope = new JButton("否");
                jbut_yep.setBounds(90,540,80,30);
                jbut_nope.setBounds(280,540,80,30);
                jframe_i.add(jbut_yep);
                jframe_i.add(jbut_nope);
                jframe_i.setVisible(true);
                jbut_yep.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser jfilechooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                        jfilechooser.setDialogTitle("请选择图片保存位置");
                        jfilechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        
                        int value = jfilechooser.showSaveDialog(null);
                        if(value == JFileChooser.APPROVE_OPTION) {
                            if(jfilechooser.getSelectedFile().isDirectory()) {
                                String path = null;
                                try {
                                    String save_path = jfilechooser.getSelectedFile().toString();
                                    path = save_path + "\\Tips_photo_" + list.get(slrow).getC_ID() + "_" + list.get(slrow).getCtime() + ".jpg";
                                    AbstractAdmin.getAdmin().savePreviewImage(map.get(i), list, slrow, path);
                                } 
                                catch (Exception e0) {
                                    JOptionPane.showMessageDialog(null, e0.getMessage(),"错误提示", JOptionPane.WARNING_MESSAGE);
                                } 
                                jframe_i.setVisible(false);
                                JOptionPane.showMessageDialog(null,"照片已保存为 : " + path ,"保存成功",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                });
                jbut_nope.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jframe_i.setVisible(false);
                    }
                });
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(),"预览错误提示", JOptionPane.WARNING_MESSAGE);
            }
        }
		//try catch
        

    }
    private void selButtonActionPerformed(java.awt.event.ActionEvent evt, int i) {
        int slrow = jTables[i].getSelectedRow();
        if(slrow >= 0){
            try{
                JFileChooser jfilechooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jfilechooser.setDialogTitle("请选择图片");
                jfilechooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG JPEG PNG GIF images","jpg","jpeg","png","gif");
                jfilechooser.addChoosableFileFilter(filter);
                                                        
                int value = jfilechooser.showOpenDialog(null);
                if(value == JFileChooser.APPROVE_OPTION) {
                    String photo_path = jfilechooser.getSelectedFile().getAbsolutePath().toString();
                    int res = AbstractAdmin.getAdmin().executeUpdate("Tips", this.list, slrow, photo_path);
                    if(res != 1)
                        JOptionPane.showMessageDialog(null, "插入操作未完成", "失败", JOptionPane.ERROR_MESSAGE);
                    else{
                        JOptionPane.showMessageDialog(null,"插入操作完成","成功",JOptionPane.INFORMATION_MESSAGE);
                        queryButtons[3].doClick();
                    }
                }
		        //落实之后pic列内容才发生变化 String
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(),"插入错误提示", JOptionPane.WARNING_MESSAGE);
            }
        }

    }
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {

        try{
    	    AbstractAdmin.getAdmin().commit();
            JOptionPane.showMessageDialog(null, "落实完成","提示", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"落实错误提示", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    private void autoSaveActionPerformed(java.awt.event.ActionEvent evt, int i) {
    	
        try{
    	    AbstractAdmin.getAdmin().setAutoCommit(autoSaves[i].isSelected());    
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"错误提示", JOptionPane.WARNING_MESSAGE);
        }  
        
    }

    private void queryButtonActionPerformed(java.awt.event.ActionEvent evt, int i) {                                         
    	switch(i) {
    	case 0:
    	{
    		//涉及Clob 
            try{
                List<Line> list = AbstractAdmin.getAdmin().getLine(jTextFields[0].getText());
                int length = list.size();
                table_data0 = new Object[length][column0.length];
                for(int j = 0;j < length;j++){
                    int count = 0;
                    table_data0[j][count++] = list.get(j).getID();
                    table_data0[j][count++] = list.get(j).getName();
                    table_data0[j][count++] = list.get(j).getT_city();
                    table_data0[j][count++] = list.get(j).getR_city();
                    table_data0[j][count++] = list.get(j).getT_time();
                    table_data0[j][count++] = list.get(j).getR_time();
                    table_data0[j][count++] = list.get(j).getAgency();
                    table_data0[j][count++] = list.get(j).getPrice();
                    table_data0[j][count++] = list.get(j).getIntro();
                    Object t = list.get(j).getPic();
                    table_data0[j][count] = t == null ? null : t.toString();

                }
                models[0] = new DefaultTableModel(table_data0, column0);
                jTables[0].setModel(models[0]);
            } catch (Exception e){
    			JOptionPane.showMessageDialog(null, e.getMessage(),"查询错误提示", JOptionPane.WARNING_MESSAGE);
            }
    		break;
    	}
    	case 1:
    	{
            try{
                List<Scenic> list = AbstractAdmin.getAdmin().getScenic(jTextFields[1].getText());
                int length = list.size();
                table_data1 = new Object[length][column1.length];
                for(int j = 0;j < length;j++){
                    int count = 0;
                    table_data1[j][count++] = list.get(j).getID();
                    table_data1[j][count++] = list.get(j).getName();
                    table_data1[j][count++] = list.get(j).getCity();
                    table_data1[j][count++] = list.get(j).getCapacity();
                    table_data1[j][count++] = list.get(j).getPrice();
                    table_data1[j][count++] = list.get(j).getStars();
                    table_data1[j][count++] = list.get(j).getIntro();
                    Object t = list.get(j).getPic();
                    table_data1[j][count] = t == null ? null : t.toString();
                }
                models[1] = new DefaultTableModel(table_data1, column1);
                jTables[1].setModel(models[1]);
            } catch (Exception e){
    			JOptionPane.showMessageDialog(null, e.getMessage(),"查询错误提示", JOptionPane.WARNING_MESSAGE);
            }
    		break;
    	}
    	case 2:
    	{
    		//涉及Clob 
            try{
                List<Hotel> list = AbstractAdmin.getAdmin().getHotel(jTextFields[2].getText());
                int length = list.size();
                table_data2 = new Object[length][column2.length];
                for(int j = 0;j < length;j++){
                    int count = 0;
                    table_data2[j][count++] = list.get(j).getID();
                    table_data2[j][count++] = list.get(j).getName();
                    table_data2[j][count++] = list.get(j).getCity();
                    table_data2[j][count++] = list.get(j).getTel();
                    table_data2[j][count++] = list.get(j).getIntro();
                    Object t = list.get(j).getPic();
                    table_data2[j][count] = t == null ? null : t.toString();
                }
                models[2] = new DefaultTableModel(table_data2, column2);
                jTables[2].setModel(models[2]);
            } catch (Exception e){
    			JOptionPane.showMessageDialog(null, e.getMessage(),"查询错误提示", JOptionPane.WARNING_MESSAGE);
            }
    		break;
    	}
    		
    	case 3:
    	{
    		//涉及Blob
    		try{
                this.list = AbstractAdmin.getAdmin().getTips(jTextFields[3].getText());
                int length = list.size();
                table_data3 = new Object[length][column3.length];
                for(int j = 0;j < length;j++){
                    int count = 0;
                    table_data3[j][count++] = list.get(j).getID();
                    table_data3[j][count++] = list.get(j).getC_ID();
                    Object t = list.get(j).getCtime();
                    table_data3[j][count++] = t == null ? null : t;
                    t = list.get(j).getText();
                    table_data3[j][count++] = t == null ? null : t;
                    t = list.get(j).getPic();
                    table_data3[j][count] = t == null ? null : t.toString();
                }
                models[3] = new DefaultTableModel(table_data3, column3);
                jTables[3].setModel(models[3]);
            } catch (Exception e){
    			JOptionPane.showMessageDialog(null, e.getMessage(),"查询错误提示", JOptionPane.WARNING_MESSAGE);
            }	
    		break;
    	}
    	case 4:
    	{
    		//涉及Clob 
            try{
                List<Ticket> list = AbstractAdmin.getAdmin().getTicket(jTextFields[4].getText());
                int length = list.size();
                table_data4 = new Object[length][column4.length];
                for(int j = 0;j < length;j++){
                    int count = 0;
                    table_data4[j][count++] = list.get(j).getID();
                    table_data4[j][count++] = list.get(j).getT_city();
                    table_data4[j][count++] = list.get(j).getR_city();
                    table_data4[j][count++] = list.get(j).getT_time();
                    table_data4[j][count++] = list.get(j).getR_time();
                    table_data4[j][count++] = list.get(j).getType();
                    table_data4[j][count++] = list.get(j).getAgency();
                    table_data4[j][count++] = list.get(j).getPrice();
                    Object t = list.get(j).getPic();
                    table_data4[j][count] = t == null ? null : t.toString();
                }
                models[4] = new DefaultTableModel(table_data4, column4);
                jTables[4].setModel(models[4]);
            } catch (Exception e){
    			JOptionPane.showMessageDialog(null, e.getMessage(),"查询错误提示", JOptionPane.WARNING_MESSAGE);
            }
    		break;
    	}
    	case 5:
    	{
    		//涉及Clob 
            try{
                List<Insurance> list = AbstractAdmin.getAdmin().getInsurance(jTextFields[5].getText());
                int length = list.size();
                table_data5 = new Object[length][column5.length];
                for(int j = 0;j < length;j++){
                    int count = 0;
                    table_data5[j][count++] = list.get(j).getID();
                    table_data5[j][count++] = list.get(j).getname();
                    table_data5[j][count++] = list.get(j).getPeriod();
                    table_data5[j][count++] = list.get(j).getAgency();
                    table_data5[j][count++] = list.get(j).getPrice();
                    table_data5[j][count++] = list.get(j).getIntro();
                    Object t = list.get(j).getPic();
                    table_data5[j][count] = t == null ? null : t.toString();
                }
                models[5] = new DefaultTableModel(table_data5, column5);
                jTables[5].setModel(models[5]);
            } catch (Exception e){
    			JOptionPane.showMessageDialog(null, e.getMessage(),"查询错误提示", JOptionPane.WARNING_MESSAGE);
            }
    		break;
    	}
    	case 6:
    	{
    		try{
                List<Room> list = AbstractAdmin.getAdmin().getRoom(jTextFields[6].getText());
                int length = list.size();
                table_data6 = new Object[length][column6.length];
                for(int j = 0;j < length;j++){
                    int count = 0;
                    //        		"ID", "房间类型", "房间所属酒店ID", "房间容量", "房间价格"

                    table_data6[j][count++] = list.get(j).getID();
                    table_data6[j][count++] = list.get(j).getType();
                    table_data6[j][count++] = list.get(j).getH_ID();
                    table_data6[j][count++] = list.get(j).getCapacity();
                    table_data6[j][count] = list.get(j).getPrice();
                }
                models[6] = new DefaultTableModel(table_data6, column6);
                jTables[6].setModel(models[6]);
            } catch (Exception e){
    			JOptionPane.showMessageDialog(null, e.getMessage(),"查询错误提示", JOptionPane.WARNING_MESSAGE);
            }
    		break;
    	}
    	}
    }

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        mulManage.this.setVisible(false);
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
                new mulManage().setVisible(true);
            }
        });
    }
               
}