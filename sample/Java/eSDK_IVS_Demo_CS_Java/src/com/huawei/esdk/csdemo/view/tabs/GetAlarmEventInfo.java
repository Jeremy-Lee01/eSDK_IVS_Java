package com.huawei.esdk.csdemo.view.tabs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;


import com.huawei.esdk.csdemo.common.PropertiesUtils;
import com.huawei.esdk.csdemo.view.utils.InternationalUtils;

public class GetAlarmEventInfo extends MyTabPane
{
    /**
     * 序列号
     */
    private static final long serialVersionUID = 8299636168688988867L;
    

    //输入
    //第一个输入框
    private javax.swing.JLabel inputLabel1;
    private JTextField inputText1;
    //第二个输入框
    private JLabel inputLabel2;
    private JTextField inputText2;
    
    //状态栏
    private Boolean isSuccess;
    private JLabel statusPanel;

    //输出
    //第一个输出
    private JLabel outputLabel1;
    private JTextField outputText1;
    //第二个输出
    private JLabel outputLabel2;
    private JScrollPane output2Jscroll;
    private JTextArea outputText2;

    //主面板  
    private JScrollPane paneJscroll = new JScrollPane();
    private JPanel jPanel;
    private JPanel inputPanel;
    private JPanel outputPanel;

    private JSeparator jSeparator1;
    private JSeparator jSeparator2;

    
    //接口说明
    private ScrollPane descEditPaneJscroll = new ScrollPane();
    private JEditorPane descEditPane = new JEditorPane();
    private Font font = new Font("微软雅黑,宋体,Arial,sans-serif", Font.PLAIN, 14);
    
    //代码示例
    private ScrollPane codeEditPaneJscroll = new ScrollPane();
    private JEditorPane codeEditPane = new JEditorPane();


    
    public void initComponents(){

        jPanel = new JPanel();
        inputLabel1 = new JLabel();
        inputText1 = new JTextField("47006");
        inputLabel2 = new JLabel();
        inputText2 = new JTextField("09336090000000000101");

        jSeparator1 = new JSeparator();
        statusPanel = new JLabel();

        jSeparator2 = new JSeparator();

        outputLabel2 = new JLabel();
        output2Jscroll = new JScrollPane();
        outputText2 = new JTextArea();
        outputLabel1 = new JLabel();
        outputText1 = new JTextField();

        descEditPane.setContentType("text/html;charset=utf-8");
        descEditPane.setEditable(false);
        descEditPane.setPreferredSize(new Dimension(getWidth(), 12750));
        descEditPaneJscroll.add(descEditPane);

        this.addTab("说明", descEditPaneJscroll);
        this.setPreferredSize(getSize());
        
        outputText2.setColumns(20);
        outputText2.setRows(5);
        outputText2.setLineWrap(true);
        output2Jscroll.add(outputText2);
        output2Jscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        output2Jscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        output2Jscroll.setViewportView(outputText2);

    
        statusPanel.setHorizontalAlignment(SwingConstants.CENTER);
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
                    .addComponent(inputLabel2, 160, 160, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, true)
                    .addComponent(actionBtn, 208, 208, Short.MAX_VALUE)
                    .addComponent(inputText1, 208, 208, Short.MAX_VALUE)
                    .addComponent(inputText2,  208, 208, Short.MAX_VALUE))
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
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING,true)
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
                .addComponent(inputPanel, 150, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(outputPanel, 315, 315, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE)
        ));
        
        
        paneJscroll.add(jPanel1);
        paneJscroll.setBorder(BorderFactory.createEtchedBorder());
        paneJscroll.setViewportView(jPanel1);
        
        JPanel mainPanelContent = new JPanel();
        GroupLayout layout = new GroupLayout(mainPanelContent);
        mainPanelContent.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING,true)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneJscroll, 580, 580, Short.MAX_VALUE)
        ));
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING,true)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneJscroll, 400, 400, Short.MAX_VALUE)
        ));


        this.addTab("执行", mainPanelContent);
        
        
        String code =   PropertiesUtils.getValue("getAlarmEvent");
        codeEditPane.setText(code);
        codeEditPane.setFont(font);
        
        codeEditPane.setContentType("text/html;charset=utf-8");
        codeEditPane.setEditable(false);
        
        codeEditPaneJscroll.add(codeEditPane);
        codeEditPaneJscroll.setPreferredSize(new Dimension(450, 200));
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
        
        inputLabel1.setText(InternationalUtils.getValue("alarmEventId")+":");
        inputLabel2.setText(InternationalUtils.getValue("alarmInCode")+":");
        
        outputLabel1.setText(InternationalUtils.getValue("resultCode")+":");
        outputLabel2.setText(InternationalUtils.getValue("AlarmEventDetail")+":");
        
        actionBtn.setText(InternationalUtils.getValue("getAlarmEventInfo"));
        
        showOperationStatus(isSuccess);
        
        if(0 == languageFlag){
            String htmlDesc = PropertiesUtils.getHtmlFromTxt("getAlarmEventInfo_zh.txt");
            descEditPane.setText(htmlDesc);
            String htmlCode = PropertiesUtils.getHtmlFromTxt("getAlarmEventInfo_code_zh.txt");
            codeEditPane.setText(htmlCode);
            
        }
        else if(1 == languageFlag)
        {
            String htmlDesc = PropertiesUtils.getHtmlFromTxt("getAlarmEventInfo_en.txt");
            descEditPane.setText(htmlDesc);
        }
        
        this.repaint();
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

    public JLabel getInputLabel1()
    {
        return inputLabel1;
    }

    public void setInputLabel1(JLabel inputLabel1)
    {
        this.inputLabel1 = inputLabel1;
    }

    public JTextField getInputText1()
    {
        return inputText1;
    }

    public void setInputText1(JTextField inputText1)
    {
        this.inputText1 = inputText1;
    }

    public JLabel getInputLabel2()
    {
        return inputLabel2;
    }

    public void setInputLabel2(JLabel inputLabel2)
    {
        this.inputLabel2 = inputLabel2;
    }

    public JTextField getInputText2()
    {
        return inputText2;
    }

    public void setInputText2(JTextField inputText2)
    {
        this.inputText2 = inputText2;
    }

    public JLabel getStatusPanel()
    {
        return statusPanel;
    }

    public void setStatusPanel(JLabel statusPanel)
    {
        this.statusPanel = statusPanel;
    }

    public JLabel getOutputLabel1()
    {
        return outputLabel1;
    }

    public void setOutputLabel1(JLabel outputLabel1)
    {
        this.outputLabel1 = outputLabel1;
    }

    public JTextField getOutputText1()
    {
        return outputText1;
    }

    public void setOutputText1(JTextField outputText1)
    {
        this.outputText1 = outputText1;
    }

    public JLabel getOutputLabel2()
    {
        return outputLabel2;
    }

    public void setOutputLabel2(JLabel outputLabel2)
    {
        this.outputLabel2 = outputLabel2;
    }

    public JScrollPane getOutput2Jscroll()
    {
        return output2Jscroll;
    }

    public void setOutput2Jscroll(JScrollPane output2Jscroll)
    {
        this.output2Jscroll = output2Jscroll;
    }

    public JTextArea getOutputText2()
    {
        return outputText2;
    }

    public void setOutputText2(JTextArea outputText2)
    {
        this.outputText2 = outputText2;
    }

    public JPanel getjPanel()
    {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel)
    {
        this.jPanel = jPanel;
    }

    public JSeparator getjSeparator1()
    {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1)
    {
        this.jSeparator1 = jSeparator1;
    }

    public JSeparator getjSeparator2()
    {
        return jSeparator2;
    }

    public void setjSeparator2(JSeparator jSeparator2)
    {
        this.jSeparator2 = jSeparator2;
    }


    public ScrollPane getDescEditPaneJscroll()
    {
        return descEditPaneJscroll;
    }

    public void setDescEditPaneJscroll(ScrollPane descEditPaneJscroll)
    {
        this.descEditPaneJscroll = descEditPaneJscroll;
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


    
    
}
