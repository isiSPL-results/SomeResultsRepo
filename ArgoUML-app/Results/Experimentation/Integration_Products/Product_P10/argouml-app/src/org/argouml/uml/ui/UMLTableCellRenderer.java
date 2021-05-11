package org.argouml.uml.ui;
import javax.swing.table.DefaultTableCellRenderer;
import org.argouml.model.Model;
public class UMLTableCellRenderer extends DefaultTableCellRenderer
  { 
public UMLTableCellRenderer()
    { 
super();
} 
@Override
    public void setValue(Object value)
    { 
if(Model.getFacade().isAModelElement(value))//1
{ 
String name = Model.getFacade().getName(value);
setText(name);
} 
else
{ 
if(value instanceof String)//1
{ 
setText((String) value);
} 
else
{ 
setText("");
} 
} 
} 

 } 
