package com.huawei.esdk.csdemo.view.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.huawei.esdk.csdemo.view.utils.bean.MyJTreeNode;

public class MyJTreeNodeUtils
{
    public static MyJTreeNode getMyJTreeNode(){

        MyJTreeNode result = null;
        List<String[]> data = TreeConfigPropertiesUtils.getAllValue();
        
        if(null != data && 1 < data.size())
        {
            Map<String, MyJTreeNode> nodes = new LinkedHashMap<String, MyJTreeNode>();
            List<String[]> relations = new ArrayList<String[]>();

           result = new MyJTreeNode(data.get(0)[0], data.get(0)[1]);
           nodes.put(data.get(0)[0], result);
   
            for(int i = 1; i < data.size(); i++)
            {
                String[] item = data.get(i);
                
                String key = item[0];
                
                String[] values = item[1].split("#");
                String parentKey = values[0];
                String value = values[1];
                
                nodes.put(key, new MyJTreeNode(key, value)) ;
                relations.add(new String[]{parentKey, key});
            }
            
            for(String[] item : relations)
            {
                nodes.get(item[0]).addSonNode(nodes.get(item[1]));
            }
        }

        return result;
            
    }

}
