
//#if 2069427137 
// Compilation Unit of /UMLMetaClassComboBoxModel.java 
 

//#if -1869673888 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if 486300667 
import java.util.Collection;
//#endif 


//#if -2104546712 
import java.util.Collections;
//#endif 


//#if 1601629026 
import java.util.LinkedList;
//#endif 


//#if 2034002043 
import java.util.List;
//#endif 


//#if 774731286 
import org.argouml.model.Model;
//#endif 


//#if 408650946 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 1122493595 
public class UMLMetaClassComboBoxModel extends 
//#if -117291849 
UMLComboBoxModel2
//#endif 

  { 

//#if 1613009769 
private List<String> metaClasses;
//#endif 


//#if 1425173837 
protected boolean isValidElement(Object element)
    { 

//#if -535201970 
return metaClasses.contains(element);
//#endif 

} 

//#endif 


//#if -1518282983 
protected void buildModelList()
    { 

//#if -264328785 
setElements(metaClasses);
//#endif 

} 

//#endif 


//#if -1365865822 
public UMLMetaClassComboBoxModel()
    { 

//#if 166808761 
super("tagType", true);
//#endif 


//#if -1522266273 
Collection<String> tmpMetaClasses =
            Model.getCoreHelper().getAllMetatypeNames();
//#endif 


//#if 274525783 
if(tmpMetaClasses instanceof List)//1
{ 

//#if 1909853587 
metaClasses = (List<String>) tmpMetaClasses;
//#endif 

} 
else
{ 

//#if 356714858 
metaClasses = new LinkedList<String>(tmpMetaClasses);
//#endif 

} 

//#endif 


//#if 153393220 
tmpMetaClasses.addAll(Model.getCoreHelper().getAllMetaDatatypeNames());
//#endif 


//#if -143073338 
try //1
{ 

//#if 177907207 
Collections.sort(metaClasses);
//#endif 

} 

//#if 357815980 
catch (UnsupportedOperationException e) //1
{ 

//#if 1197473288 
metaClasses = new LinkedList<String>(tmpMetaClasses);
//#endif 


//#if 788174418 
Collections.sort(metaClasses);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1707464577 
@Override
    protected Object getSelectedModelElement()
    { 

//#if -564661556 
if(getTarget() != null)//1
{ 

//#if 83204106 
return Model.getFacade().getType(getTarget());
//#endif 

} 

//#endif 


//#if -1339999520 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

