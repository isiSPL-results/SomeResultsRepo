package org.argouml.ui.explorer;
import javax.swing.tree.DefaultMutableTreeNode;
import org.argouml.i18n.Translator;
public class TypeThenNameOrder extends NameOrder
  { 
@Override
    public String toString()
    { 
return Translator.localize("combobox.order-by-type-name");
} 
@Override
    public int compare(Object obj1, Object obj2)
    { 
if(obj1 instanceof DefaultMutableTreeNode)//1
{ 
DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj1;
obj1 = node.getUserObject();
} 
if(obj2 instanceof DefaultMutableTreeNode)//1
{ 
DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj2;
obj2 = node.getUserObject();
} 
if(obj1 == null)//1
{ 
if(obj2 == null)//1
{ 
return 0;
} 
return -1;
} 
else
if(obj2 == null)//1
{ 
return 1;
} 
String typeName = obj1.getClass().getName();
String typeName1 = obj2.getClass().getName();
int typeNameOrder = typeName.compareTo(typeName1);
if(typeNameOrder == 0)//1
{ 
return compareUserObjects(obj1, obj2);
} 
if(typeName.indexOf("Diagram") == -1
                && typeName1.indexOf("Diagram") != -1)//1
{ 
return 1;
} 
if(typeName.indexOf("Diagram") != -1
                && typeName1.indexOf("Diagram") == -1)//1
{ 
return -1;
} 
if(typeName.indexOf("Package") == -1
                && typeName1.indexOf("Package") != -1)//1
{ 
return 1;
} 
if(typeName.indexOf("Package") != -1
                && typeName1.indexOf("Package") == -1)//1
{ 
return -1;
} 
return typeNameOrder;
} 
public TypeThenNameOrder()
    { 
} 

 } 
