package com.huawei.esdk.csdemo.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import com.huawei.esdk.csdemo.view.tabs.MyTabPane;
import com.huawei.esdk.csdemo.view.utils.InternationalUtils;
import com.huawei.esdk.csdemo.view.utils.MyJTreeNodeUtils;
import com.huawei.esdk.csdemo.view.utils.bean.MyJTreeNode;
import com.huawei.esdk.csdemo.view.utils.bean.MyNode;



public class MainFrame extends javax.swing.JFrame {

    /**
     * 注释内容
     */
    private static final long serialVersionUID = 7848608073737504147L;
    
    private javax.swing.JComboBox languageJComboBox;
    private javax.swing.JLabel demoSubDesc;
    private javax.swing.JLabel demoDesc;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel jLabel2;

    private javax.swing.JScrollPane JtreeJScrollPane;

    private javax.swing.JSeparator jSeparator1;

    private TabPanelContent tabContent;

    private javax.swing.JTree jTree;
    
    public MainFrame(TabPanelContent tabContent) {
        this.tabContent = tabContent;
        this.tabContent.setLayout(new BoxLayout(tabContent,1));
        this.setTitle("eSDK_IVS_Demo_CS_Java");
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pack();  

        Image headerImage = Toolkit.getDefaultToolkit().getImage(MainFrame.getPath("001.png"));
        this.setIconImage(headerImage);

        initComponents();
    }
    public static URL getPath(String img)
    {
        return MainFrame.class.getResource("/" + img);
    }
    
    private void initComponents() {

        JtreeJScrollPane = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();

        
        jSeparator1 = new javax.swing.JSeparator();
        demoSubDesc = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        languageJComboBox = new javax.swing.JComboBox();
        demoDesc = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        footer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);


        
        
        MyJTreeNode jtreBean =   MyJTreeNodeUtils.getMyJTreeNode();
        
        DefaultMutableTreeNode parentNode = createTreeMode(jtreBean);
        
        jTree.setModel(new DefaultTreeModel(parentNode));
        
        JtreeJScrollPane.setViewportView(jTree);
        JtreeJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JtreeJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        addMouseListenerForTreeMode();


        demoSubDesc.setText("本Demo介绍eSDK IVS典型功能和场景的使用方式");

        languageJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "中文", "English" }));

        demoDesc.setFont(new java.awt.Font("宋体", 1, 18));
        demoDesc.setText("eSDK_IVS_Demo_CS_Java");

        logo.setIcon(new ImageIcon(MainFrame.getPath("logo.png")));

        footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        footer.setText("版权所有 © 华为技术有限公司 1998-2014。 保留一切权利。粤A2-20044005号");
        footer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(demoSubDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(demoDesc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(languageJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(logo))
                .addGap(26, 26, 26)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, true)
                    .addComponent(footer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20,20,20)
                        .addComponent(JtreeJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 228, 280)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabContent, javax.swing.GroupLayout.PREFERRED_SIZE, 592, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(demoDesc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(demoSubDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(languageJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabContent,439,439,Short.MAX_VALUE)
                    .addComponent(JtreeJScrollPane, 439, 439, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        languageJComboBox.addItemListener(new ItemListener()
        {
            
            @Override
            public void itemStateChanged(final ItemEvent event)
            {
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        
                        String item = (String)event.getItem();
                        int state = event.getStateChange();
                        
                        int languageFlag = 0;
                        if(1 == state){
                            if("中文".equals(item)){
                                languageFlag = 0;
                            }else{
                                languageFlag = 1; 
                            }
                        }
                        
                        for(Entry<String, MyTabPane> entry :tabContent.getTabs().entrySet()){
                            entry.getValue().International(languageFlag);
                        }
                        
                        International(languageFlag);
                    }
                });
                

            }
        });
        
        International(0);
        
        pack();
    }                        

   

    private DefaultMutableTreeNode createTreeMode(MyJTreeNode jtreBean){
        
        MyJTreeNode mainNodeItem = new MyJTreeNode(jtreBean.getKey(), jtreBean.getValue());
        DefaultMutableTreeNode mainNode= new DefaultMutableTreeNode(mainNodeItem);
        
        addSonNode(mainNode, jtreBean.getSonNode());
        
        return mainNode;
    }
    
    private void addSonNode(DefaultMutableTreeNode parentNode, List<MyJTreeNode> beans){
        
        if(null == beans){
            return;
        }
        
        for(MyJTreeNode item : beans){
            MyNode sonNodeItem = new MyNode(item.getKey(), item.getValue());
            DefaultMutableTreeNode sonNode = new DefaultMutableTreeNode(sonNodeItem);
            parentNode.add(sonNode);
            addSonNode(sonNode, item.getSonNode());
        }
    }
    
    private void addMouseListenerForTreeMode(){
        jTree.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                TreePath selectPath = jTree.getSelectionModel().getLeadSelectionPath();
                if(null == selectPath)
                {
                    return;
                }
                
                DefaultMutableTreeNode node =  (DefaultMutableTreeNode)selectPath.getLastPathComponent();
                
               if(null != node.getUserObject())
               {
                   String tabKey = ((MyNode)node.getUserObject()).getKey();
                   
                   if(null != tabKey){
                       tabContent.showTabByName(tabKey);
                   }
               }

            }
            
        });
    }

    private void International(int languageFlag){
        InternationalUtils.languageFlag = languageFlag;
        demoSubDesc.setText(InternationalUtils.getValue("demoSubDesc"));
        footer.setText(InternationalUtils.getValue("demoFooter"));
        
        TreePath selectPath = jTree.getSelectionPath();

        //国际化Jtree
        DefaultTreeModel defaultTreeNode = (DefaultTreeModel)jTree.getModel();
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode)defaultTreeNode.getRoot();
        
        InternationalTreeNode(rootNode);
        
        defaultTreeNode.reload();
        jTree.setSelectionPath(selectPath);
        jTree.setExpandsSelectedPaths(true);
    }
    
    private void InternationalTreeNode(DefaultMutableTreeNode node){
        MyNode myNode = (MyNode)node.getUserObject();
        String disPlayName = InternationalUtils.getValue(myNode.getValue());
        if(!("".equals(disPlayName))){
            myNode.setDisplayName(disPlayName);
        }else{
            myNode.setDisplayName("Undefind");
        }

        int childNodeSize = node.getChildCount();
        
        if(0 != childNodeSize){
            for(int i = 0; i < childNodeSize; i++){
                InternationalTreeNode((DefaultMutableTreeNode)node.getChildAt(i));
            }
        }

    }

    public javax.swing.JComboBox getLanguageJComboBox()
    {
        return languageJComboBox;
    }


    public void setLanguageJComboBox(javax.swing.JComboBox languageJComboBox)
    {
        this.languageJComboBox = languageJComboBox;
    }


    public javax.swing.JLabel getDemoSubDesc()
    {
        return demoSubDesc;
    }


    public void setDemoSubDesc(javax.swing.JLabel demoSubDesc)
    {
        this.demoSubDesc = demoSubDesc;
    }


    public javax.swing.JLabel getDemoDesc()
    {
        return demoDesc;
    }


    public void setDemoDesc(javax.swing.JLabel demoDesc)
    {
        this.demoDesc = demoDesc;
    }


    public javax.swing.JLabel getLogo()
    {
        return logo;
    }


    public void setLogo(javax.swing.JLabel logo)
    {
        this.logo = logo;
    }


    public javax.swing.JLabel getFooter()
    {
        return footer;
    }


    public void setFooter(javax.swing.JLabel footer)
    {
        this.footer = footer;
    }


    public javax.swing.JLabel getjLabel2()
    {
        return jLabel2;
    }


    public void setjLabel2(javax.swing.JLabel jLabel2)
    {
        this.jLabel2 = jLabel2;
    }


    public javax.swing.JScrollPane getJtreeJScrollPane()
    {
        return JtreeJScrollPane;
    }


    public void setJtreeJScrollPane(javax.swing.JScrollPane jtreeJScrollPane)
    {
        JtreeJScrollPane = jtreeJScrollPane;
    }


    public javax.swing.JSeparator getjSeparator1()
    {
        return jSeparator1;
    }


    public void setjSeparator1(javax.swing.JSeparator jSeparator1)
    {
        this.jSeparator1 = jSeparator1;
    }


    public TabPanelContent getTabContent()
    {
        return tabContent;
    }


    public void setTabContent(TabPanelContent tabContent)
    {
        this.tabContent = tabContent;
    }


    public javax.swing.JTree getjTree()
    {
        return jTree;
    }


    public void setjTree(javax.swing.JTree jTree)
    {
        this.jTree = jTree;
    }


                
}
