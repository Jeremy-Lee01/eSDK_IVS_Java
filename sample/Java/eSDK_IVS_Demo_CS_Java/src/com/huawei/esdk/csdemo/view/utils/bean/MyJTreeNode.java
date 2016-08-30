package com.huawei.esdk.csdemo.view.utils.bean;

import java.util.ArrayList;
import java.util.List;

public class MyJTreeNode extends MyNode
{

    public MyJTreeNode(String key, String value)
    {
        super(key, value);
    }
    private List<MyJTreeNode> sonNode;
    
    public List<MyJTreeNode> getSonNode()
    {
        if(null == sonNode)
        {
            sonNode = new ArrayList<MyJTreeNode>();
        }
        return sonNode;
    }

    public void addSonNode(MyJTreeNode sonNode)
    {
        getSonNode().add(sonNode);
    }
}

