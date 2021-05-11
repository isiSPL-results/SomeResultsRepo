package org.argouml.uml.ui;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import org.argouml.model.Model;
public class UMLSearchableComboBox extends UMLEditableComboBox
  { 
protected Object search(Object item)
    { 
String text = (String) item;
ComboBoxModel model = getModel();
for (int i = 0; i < model.getSize(); i++) //1
{ 
Object element = model.getElementAt(i);
if(Model.getFacade().isAModelElement(element))//1
{ 
if(getRenderer() instanceof UMLListCellRenderer2)//1
{ 
String labelText = ((UMLListCellRenderer2) getRenderer())
                                       .makeText(element);
if(labelText != null && labelText.startsWith(text))//1
{ 
return element;
} 
} 
if(Model.getFacade().isAModelElement(element))//1
{ 
Object/*MModelElement*/ elem = element;
String name = Model.getFacade().getName(elem);
if(name != null && name.startsWith(text))//1
{ 
return element;
} 
} 
} 
} 
return null;
} 
public UMLSearchableComboBox(UMLComboBoxModel2 model,
                                 Action selectAction, boolean showIcon)
    { 
super(model, selectAction, showIcon);
} 
protected void doOnEdit(Object item)
    { 
Object element = search(item);
if(element != null)//1
{ 
setSelectedItem(element);
} 
} 
public UMLSearchableComboBox(UMLComboBoxModel2 arg0,
                                 Action selectAction)
    { 
this(arg0, selectAction, true);
} 

 } 
