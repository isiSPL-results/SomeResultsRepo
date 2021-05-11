
//#if -1025212267 
// Compilation Unit of /UMLGeneralizationPowertypeComboBoxModel.java 
 

//#if -721239315 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -300197000 
import java.util.ArrayList;
//#endif 


//#if 623425769 
import java.util.Collection;
//#endif 


//#if -1559830003 
import java.util.Set;
//#endif 


//#if 569225419 
import java.util.TreeSet;
//#endif 


//#if 763786146 
import org.argouml.kernel.Project;
//#endif 


//#if -1381071609 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1354746472 
import org.argouml.model.Model;
//#endif 


//#if 1379681712 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 176920511 
import org.argouml.uml.util.PathComparator;
//#endif 


//#if -1509529027 
public class UMLGeneralizationPowertypeComboBoxModel extends 
//#if 2084655879 
UMLComboBoxModel2
//#endif 

  { 

//#if 131936626 
@Override
    protected boolean isLazy()
    { 

//#if 2130535334 
return true;
//#endif 

} 

//#endif 


//#if 894817474 
public UMLGeneralizationPowertypeComboBoxModel()
    { 

//#if 107747855 
super("powertype", true);
//#endif 


//#if 171913992 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getNamespace(), "ownedElement");
//#endif 

} 

//#endif 


//#if -175313559 
protected void buildModelList()
    { 

//#if -162125770 
Set<Object> elements = new TreeSet<Object>(new PathComparator());
//#endif 


//#if 244704350 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 467514739 
for (Object model : p.getUserDefinedModelList()) //1
{ 

//#if 1190861279 
elements.addAll(Model.getModelManagementHelper()
                            .getAllModelElementsOfKind(model,
                                    Model.getMetaTypes().getClassifier()));
//#endif 

} 

//#endif 


//#if -815087115 
elements.addAll(p.getProfileConfiguration().findByMetaType(
                            Model.getMetaTypes().getClassifier()));
//#endif 


//#if -1949997266 
removeAllElements();
//#endif 


//#if -1618291863 
addAll(elements);
//#endif 

} 

//#endif 


//#if -618142819 
protected boolean isValidElement(Object element)
    { 

//#if 1585230264 
return Model.getFacade().isAClassifier(element);
//#endif 

} 

//#endif 


//#if 1328658539 
protected Object getSelectedModelElement()
    { 

//#if 140688077 
if(getTarget() != null)//1
{ 

//#if -1347639082 
return Model.getFacade().getPowertype(getTarget());
//#endif 

} 

//#endif 


//#if 1502381375 
return null;
//#endif 

} 

//#endif 


//#if -660633396 
@Override
    protected void buildMinimalModelList()
    { 

//#if 1049178408 
Collection list = new ArrayList(1);
//#endif 


//#if -1088645919 
Object element = getSelectedModelElement();
//#endif 


//#if 1378036875 
if(element == null)//1
{ 

//#if 501340430 
element = " ";
//#endif 

} 

//#endif 


//#if -1209627774 
list.add(element);
//#endif 


//#if 911566410 
setElements(list);
//#endif 


//#if -945709899 
setModelInvalid();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

