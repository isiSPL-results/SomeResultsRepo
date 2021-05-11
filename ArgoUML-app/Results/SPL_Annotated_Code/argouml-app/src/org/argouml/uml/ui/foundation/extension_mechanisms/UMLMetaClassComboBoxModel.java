// Compilation Unit of /UMLMetaClassComboBoxModel.java 
 
package org.argouml.uml.ui.foundation.extension_mechanisms;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBoxModel2;
public class UMLMetaClassComboBoxModel extends UMLComboBoxModel2
  { 
private List<String> metaClasses;
protected boolean isValidElement(Object element)
    { 
return metaClasses.contains(element);
} 

protected void buildModelList()
    { 
setElements(metaClasses);
} 

public UMLMetaClassComboBoxModel()
    { 
super("tagType", true);
Collection<String> tmpMetaClasses =
            Model.getCoreHelper().getAllMetatypeNames();
if(tmpMetaClasses instanceof List)//1
{ 
metaClasses = (List<String>) tmpMetaClasses;
} 
else
{ 
metaClasses = new LinkedList<String>(tmpMetaClasses);
} 

tmpMetaClasses.addAll(Model.getCoreHelper().getAllMetaDatatypeNames());
try //1
{ 
Collections.sort(metaClasses);
} 
catch (UnsupportedOperationException e) //1
{ 
metaClasses = new LinkedList<String>(tmpMetaClasses);
Collections.sort(metaClasses);
} 


} 

@Override
    protected Object getSelectedModelElement()
    { 
if(getTarget() != null)//1
{ 
return Model.getFacade().getType(getTarget());
} 

return null;
} 

 } 


