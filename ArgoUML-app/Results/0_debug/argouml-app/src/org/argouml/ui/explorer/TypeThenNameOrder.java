
//#if 848550864 
// Compilation Unit of /TypeThenNameOrder.java 
 

//#if -47608733 
package org.argouml.ui.explorer;
//#endif 


//#if -1379646859 
import javax.swing.tree.DefaultMutableTreeNode;
//#endif 


//#if -1285320651 
import org.argouml.i18n.Translator;
//#endif 


//#if -23697921 
public class TypeThenNameOrder extends 
//#if 152338705 
NameOrder
//#endif 

  { 

//#if -617867743 
@Override
    public String toString()
    { 

//#if 1328694963 
return Translator.localize("combobox.order-by-type-name");
//#endif 

} 

//#endif 


//#if -70212309 
@Override
    public int compare(Object obj1, Object obj2)
    { 

//#if -1725555621 
if(obj1 instanceof DefaultMutableTreeNode)//1
{ 

//#if -2020455020 
DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj1;
//#endif 


//#if -1665650424 
obj1 = node.getUserObject();
//#endif 

} 

//#endif 


//#if -1395789860 
if(obj2 instanceof DefaultMutableTreeNode)//1
{ 

//#if -2129424524 
DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj2;
//#endif 


//#if 571466698 
obj2 = node.getUserObject();
//#endif 

} 

//#endif 


//#if -709335759 
if(obj1 == null)//1
{ 

//#if 1356166153 
if(obj2 == null)//1
{ 

//#if -536759155 
return 0;
//#endif 

} 

//#endif 


//#if -887610117 
return -1;
//#endif 

} 
else

//#if 1153958396 
if(obj2 == null)//1
{ 

//#if 922809856 
return 1;
//#endif 

} 

//#endif 


//#endif 


//#if 1914241172 
String typeName = obj1.getClass().getName();
//#endif 


//#if 877766550 
String typeName1 = obj2.getClass().getName();
//#endif 


//#if 2044375437 
int typeNameOrder = typeName.compareTo(typeName1);
//#endif 


//#if -1171477769 
if(typeNameOrder == 0)//1
{ 

//#if 1822358853 
return compareUserObjects(obj1, obj2);
//#endif 

} 

//#endif 


//#if 1298574109 
if(typeName.indexOf("Diagram") == -1
                && typeName1.indexOf("Diagram") != -1)//1
{ 

//#if 1061457362 
return 1;
//#endif 

} 

//#endif 


//#if -621427683 
if(typeName.indexOf("Diagram") != -1
                && typeName1.indexOf("Diagram") == -1)//1
{ 

//#if -2041353862 
return -1;
//#endif 

} 

//#endif 


//#if 778935747 
if(typeName.indexOf("Package") == -1
                && typeName1.indexOf("Package") != -1)//1
{ 

//#if -398570803 
return 1;
//#endif 

} 

//#endif 


//#if -1141066045 
if(typeName.indexOf("Package") != -1
                && typeName1.indexOf("Package") == -1)//1
{ 

//#if -1431894843 
return -1;
//#endif 

} 

//#endif 


//#if -1235698939 
return typeNameOrder;
//#endif 

} 

//#endif 


//#if 1882266450 
public TypeThenNameOrder()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

