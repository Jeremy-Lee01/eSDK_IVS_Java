package com.huawei.esdk.csdemo.view.tabs;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;

import com.huawei.esdk.csdemo.common.PropertiesUtils;
import com.huawei.esdk.csdemo.view.utils.InternationalUtils;

public class GetDeviceList extends MyTabPane
{
    /**
     * 序列号
     */
    private static final long serialVersionUID = 3296547845318987007L;

    //输入
//    private javax.swing.JLabel input;
    //第一个输入框
    private javax.swing.JLabel inputLabel1;
    private javax.swing.JTextField inputText1;
    //第二个输入框
    private javax.swing.JLabel inputLabel2;
    private javax.swing.JTextField inputText2;
    //第三个输入框
    private javax.swing.JLabel inputLabel3;
    private javax.swing.JTextField inputText3;
    
    //状态栏
    private Boolean isSuccess;
    private javax.swing.JLabel statusPanel;

    //输出
//    private javax.swing.JLabel output;
    //第一个输出
    private javax.swing.JLabel outputLabel1;
    private javax.swing.JTextField outputText1;
    //第二个输出
    private javax.swing.JLabel outputLabel2;
    private javax.swing.JScrollPane output2Jscroll;
    private javax.swing.JTextArea outputText2;

    //主面板
    private JScrollPane paneJscroll = new JScrollPane();
    private javax.swing.JPanel jPanel;
    private JPanel inputPanel;
    private JPanel outputPanel;

    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;

    
    //接口说明
    private ScrollPane descEditPaneJscroll = new ScrollPane();
    private JEditorPane descEditPane = new JEditorPane();
    private Font font = new Font("微软雅黑,宋体,Arial,sans-serif", Font.PLAIN, 14);
    
    //代码示例
    private ScrollPane codeEditPaneJscroll = new ScrollPane();
    private JEditorPane codeEditPane = new JEditorPane();


    
    public void initComponents(){


        jPanel = new javax.swing.JPanel();
        
        inputLabel1 = new javax.swing.JLabel();
        inputText1 = new javax.swing.JTextField();
        inputLabel2 = new javax.swing.JLabel();
        inputText2 = new javax.swing.JTextField();
        inputLabel3 = new javax.swing.JLabel();
        inputText3 = new javax.swing.JTextField();

        jSeparator1 = new javax.swing.JSeparator();
        statusPanel = new javax.swing.JLabel();

        jSeparator2 = new javax.swing.JSeparator();

        outputLabel2 = new javax.swing.JLabel();
        output2Jscroll = new javax.swing.JScrollPane();
        outputText2 = new javax.swing.JTextArea();
        outputLabel1 = new javax.swing.JLabel();
        outputText1 = new javax.swing.JTextField();
 
        descEditPane.setContentType("text/html;charset=utf-8");
        descEditPane.setEditable(false);
        descEditPaneJscroll.add(descEditPane);
        this.addTab("说明", descEditPaneJscroll);
        this.setPreferredSize(getSize());
    
        outputText2.setColumns(20);
        outputText2.setRows(5);
        outputText2.setLineWrap(true);
        output2Jscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        output2Jscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        output2Jscroll.setViewportView(outputText2);
    
        statusPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusPanel.setText("");
    
        //输入框
        inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createTitledBorder("输入"));
        GroupLayout jPanel2Layout = new GroupLayout(inputPanel);
        inputPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                    .addComponent(inputLabel1, 160, 160, Short.MAX_VALUE)
                    .addComponent(inputLabel2, 160, 160, Short.MAX_VALUE)
                    .addComponent(inputLabel3, 160, 160, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                    .addComponent(actionBtn, 208, 208, Short.MAX_VALUE)
                    .addComponent(inputText1, 208, 208, Short.MAX_VALUE)
                    .addComponent(inputText2,  208, 208, Short.MAX_VALUE)
                    .addComponent(inputText3,  208, 208, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(inputLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputText1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(inputLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputText2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(inputLabel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputText3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(actionBtn)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        
        //输出框
        outputPanel = new JPanel();
        outputPanel.setBorder(BorderFactory.createTitledBorder("输出"));
        GroupLayout jPanel3Layout = new GroupLayout(outputPanel);
        outputPanel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                    .addComponent(outputLabel1, 160, 160, Short.MAX_VALUE)
                    .addComponent(outputLabel2, 160, 160, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                    .addComponent(outputText1, 208, 208, Short.MAX_VALUE)
                    .addComponent(output2Jscroll, 208, 208, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(statusPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(outputLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputText1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(outputLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(output2Jscroll, 133, 133, GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusPanel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    
          
        JPanel jPanel1 = new JPanel();
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                    .addComponent(outputPanel, 540, 540, Short.MAX_VALUE)
                    .addComponent(inputPanel, 540, 540, Short.MAX_VALUE))
                .addContainerGap(10, 10)
        ));
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(inputPanel, 200, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(outputPanel, 315, 315, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, 10)
        ));
        
        
        paneJscroll.add(jPanel1);
        paneJscroll.setBorder(BorderFactory.createEtchedBorder());
        paneJscroll.setViewportView(jPanel1);
        
        JPanel mainPanelContent = new JPanel();
        GroupLayout layout = new GroupLayout(mainPanelContent);
        mainPanelContent.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneJscroll, 580, 580,  Short.MAX_VALUE)
        ));
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneJscroll, 400, 400, Short.MAX_VALUE)
        ));


        this.addTab("执行", mainPanelContent);
    
        
        String code =   PropertiesUtils.getValue("getDeviceList");
        codeEditPane.setText(code);
        codeEditPane.setContentType("text/html;charset=utf-8");
        codeEditPane.setEditable(false);
        codeEditPaneJscroll.add(codeEditPane);
    
        this.addTab("源码", codeEditPaneJscroll);
        
        International(0);
    }

    @Override
    public void International(int languageFlag){
        InternationalUtils.languageFlag = languageFlag;
        this.setTitleAt(0, InternationalUtils.getValue("instruction"));
        this.setTitleAt(1, InternationalUtils.getValue("execute"));
        this.setTitleAt(2, InternationalUtils.getValue("code"));

        inputPanel.setBorder(BorderFactory.createTitledBorder((InternationalUtils.getValue("input"))));
        outputPanel.setBorder(BorderFactory.createTitledBorder((InternationalUtils.getValue("output"))));
        
        inputLabel1.setText(InternationalUtils.getValue("deviceType")+":");
        inputLabel2.setText(InternationalUtils.getValue("fromIndex")+":");
        inputLabel3.setText(InternationalUtils.getValue("toIndex")+":");
        
        actionBtn.setText(InternationalUtils.getValue("getDeviceList"));
        
        outputLabel1.setText(InternationalUtils.getValue("resultCode")+":");
        outputLabel2.setText(InternationalUtils.getValue("deviceListInfo")+":");
        
        showOperationStatus(isSuccess);
        
        if(0 == languageFlag){
            String htmlDesc = PropertiesUtils.getHtmlFromTxt("getDeviceList_zh.txt");
            descEditPane.setText(htmlDesc);
            String codeDesc = PropertiesUtils.getHtmlFromTxt("getDeviceList_code_zh.txt");
            codeEditPane.setText(codeDesc);
        }
        else if(1 == languageFlag)
        {
            String htmlDesc = PropertiesUtils.getHtmlFromTxt("getDeviceList_en.txt");
            descEditPane.setText(htmlDesc);
            String codeDesc = PropertiesUtils.getHtmlFromTxt("getDeviceList_code_en.txt");
            codeEditPane.setText(codeDesc);
        }
    }

    public void showOperationStatus(Boolean status){
        isSuccess = status;
        if(null != isSuccess){
            if(isSuccess)
            {
                statusPanel.setText(InternationalUtils.getValue("success"));
            }else{
                statusPanel.setText(InternationalUtils.getValue("fail"));
            }
        }else{
            statusPanel.setText("");
        }
    }

    public javax.swing.JLabel getInputLabel1()
    {
        return inputLabel1;
    }



    public void setInputLabel1(javax.swing.JLabel inputLabel1)
    {
        this.inputLabel1 = inputLabel1;
    }



    public javax.swing.JTextField getInputText1()
    {
        return inputText1;
    }



    public void setInputText1(javax.swing.JTextField inputText1)
    {
        this.inputText1 = inputText1;
    }



    public javax.swing.JLabel getInputLabel2()
    {
        return inputLabel2;
    }



    public void setInputLabel2(javax.swing.JLabel inputLabel2)
    {
        this.inputLabel2 = inputLabel2;
    }



    public javax.swing.JTextField getInputText2()
    {
        return inputText2;
    }



    public void setInputText2(javax.swing.JTextField inputText2)
    {
        this.inputText2 = inputText2;
    }



    public javax.swing.JLabel getInputLabel3()
    {
        return inputLabel3;
    }



    public void setInputLabel3(javax.swing.JLabel inputLabel3)
    {
        this.inputLabel3 = inputLabel3;
    }



    public javax.swing.JTextField getInputText3()
    {
        return inputText3;
    }



    public void setInputText3(javax.swing.JTextField inputText3)
    {
        this.inputText3 = inputText3;
    }



    public javax.swing.JLabel getStatusPanel()
    {
        return statusPanel;
    }



    public void setStatusPanel(javax.swing.JLabel statusPanel)
    {
        this.statusPanel = statusPanel;
    }

    public javax.swing.JLabel getOutputLabel1()
    {
        return outputLabel1;
    }



    public void setOutputLabel1(javax.swing.JLabel outputLabel1)
    {
        this.outputLabel1 = outputLabel1;
    }



    public javax.swing.JTextField getOutputText1()
    {
        return outputText1;
    }



    public void setOutputText1(javax.swing.JTextField outputText1)
    {
        this.outputText1 = outputText1;
    }



    public javax.swing.JLabel getOutputLabel2()
    {
        return outputLabel2;
    }



    public void setOutputLabel2(javax.swing.JLabel outputLabel2)
    {
        this.outputLabel2 = outputLabel2;
    }



    public javax.swing.JScrollPane getOutput2Jscroll()
    {
        return output2Jscroll;
    }



    public void setOutput2Jscroll(javax.swing.JScrollPane output2Jscroll)
    {
        this.output2Jscroll = output2Jscroll;
    }



    public javax.swing.JTextArea getOutputText2()
    {
        return outputText2;
    }



    public void setOutputText2(javax.swing.JTextArea outputText2)
    {
        this.outputText2 = outputText2;
    }



    public javax.swing.JPanel getjPanel()
    {
        return jPanel;
    }



    public void setjPanel(javax.swing.JPanel jPanel)
    {
        this.jPanel = jPanel;
    }



    public javax.swing.JSeparator getjSeparator1()
    {
        return jSeparator1;
    }



    public void setjSeparator1(javax.swing.JSeparator jSeparator1)
    {
        this.jSeparator1 = jSeparator1;
    }



    public javax.swing.JSeparator getjSeparator2()
    {
        return jSeparator2;
    }



    public void setjSeparator2(javax.swing.JSeparator jSeparator2)
    {
        this.jSeparator2 = jSeparator2;
    }

    public JEditorPane getDescEditPane()
    {
        return descEditPane;
    }



    public void setDescEditPane(JEditorPane descEditPane)
    {
        this.descEditPane = descEditPane;
    }



    public Font getFont()
    {
        return font;
    }



    public void setFont(Font font)
    {
        this.font = font;
    }

    public JEditorPane getCodeEditPane()
    {
        return codeEditPane;
    }



    public void setCodeEditPane(JEditorPane codeEditPane)
    {
        this.codeEditPane = codeEditPane;
    }



    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
}
