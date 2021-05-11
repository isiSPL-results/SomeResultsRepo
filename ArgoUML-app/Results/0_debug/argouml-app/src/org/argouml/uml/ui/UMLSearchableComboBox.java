
//#if 1250027695 
// Compilation Unit of /UMLSearchableComboBox.java 
 

//#if 728928995 
package org.argouml.uml.ui;
//#endif 


//#if 629755903 
import javax.swing.Action;
//#endif 


//#if -774561419 
import javax.swing.ComboBoxModel;
//#endif 


//#if 39985362 
import org.argouml.model.Model;
//#endif 


//#if 211930045 
public class UMLSearchableComboBox extends 
//#if -177915736 
UMLEditableComboBox
//#endif 

  { 

//#if -845696521 
protected Object search(Object item)
    { 

//#if -1957361629 
String text = (String) item;
//#endif 


//#if -926697231 
ComboBoxModel model = getModel();
//#endif 


//#if -988725007 
for (int i = 0; i < model.getSize(); i++) //1
{ 

//#if -1441514504 
Object element = model.getElementAt(i);
//#endif 


//#if 918029177 
if(Model.getFacade().isAModelElement(element))//1
{ 

//#if 1043959911 
if(getRenderer() instanceof UMLListCellRenderer2)//1
{ 

//#if 152391400 
String labelText = ((UMLListCellRenderer2) getRenderer())
                                       .makeText(element);
//#endif 


//#if 1982107714 
if(labelText != null && labelText.startsWith(text))//1
{ 

//#if -720161494 
return element;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1385330135 
if(Model.getFacade().isAModelElement(element))//1
{ 

//#if 1588027742 
Object/*MModelElement*/ elem = element;
//#endif 


//#if -1530108721 
String name = Model.getFacade().getName(elem);
//#endif 


//#if 578937433 
if(name != null && name.startsWith(text))//1
{ 

//#if -1828782099 
return element;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1517237210 
return null;
//#endif 

} 

//#endif 


//#if -2104597443 
public UMLSearchableComboBox(UMLComboBoxModel2 model,
                                 Action selectAction, boolean showIcon)
    { 

//#if 277433402 
super(model, selectAction, showIcon);
//#endif 

} 

//#endif 


//#if 1533047096 
protected void doOnEdit(Object item)
    { 

//#if 910494177 
Object element = search(item);
//#endif 


//#if 1117296640 
if(element != null)//1
{ 

//#if -912026354 
setSelectedItem(element);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1247051838 
public UMLSearchableComboBox(UMLComboBoxModel2 arg0,
                                 Action selectAction)
    { 

//#if -295170567 
this(arg0, selectAction, true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

