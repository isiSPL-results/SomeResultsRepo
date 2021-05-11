
//#if -1248248358 
// Compilation Unit of /UMLTableCellRenderer.java 
 

//#if -114360420 
package org.argouml.uml.ui;
//#endif 


//#if -2111443510 
import javax.swing.table.DefaultTableCellRenderer;
//#endif 


//#if -1908963061 
import org.argouml.model.Model;
//#endif 


//#if 693998876 
public class UMLTableCellRenderer extends 
//#if 646966497 
DefaultTableCellRenderer
//#endif 

  { 

//#if 638190104 
public UMLTableCellRenderer()
    { 

//#if 1360229200 
super();
//#endif 

} 

//#endif 


//#if -1864289770 
@Override
    public void setValue(Object value)
    { 

//#if -990589588 
if(Model.getFacade().isAModelElement(value))//1
{ 

//#if -1767977326 
String name = Model.getFacade().getName(value);
//#endif 


//#if -618922289 
setText(name);
//#endif 

} 
else
{ 

//#if -1353687171 
if(value instanceof String)//1
{ 

//#if -1738439798 
setText((String) value);
//#endif 

} 
else
{ 

//#if 288258804 
setText("");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

