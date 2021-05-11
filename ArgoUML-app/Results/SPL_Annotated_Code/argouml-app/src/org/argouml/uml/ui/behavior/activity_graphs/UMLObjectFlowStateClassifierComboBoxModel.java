// Compilation Unit of /UMLObjectFlowStateClassifierComboBoxModel.java 
 
package org.argouml.uml.ui.behavior.activity_graphs;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collection;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.model.UmlChangeEvent;
import org.argouml.uml.ui.UMLComboBoxModel2;
public class UMLObjectFlowStateClassifierComboBoxModel extends UMLComboBoxModel2
  { 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAClassifier(o);
} 

public void modelChanged(UmlChangeEvent evt)
    { 
buildingModel = true;
buildModelList();
buildingModel = false;
setSelectedItem(getSelectedModelElement());
} 

public UMLObjectFlowStateClassifierComboBoxModel()
    { 
super("type", false);
} 

protected Object getSelectedModelElement()
    { 
if(getTarget() != null)//1
{ 
return Model.getFacade().getType(getTarget());
} 

return null;
} 

protected void buildModelList()
    { 
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
Collection newList =
            new ArrayList(Model.getCoreHelper().getAllClassifiers(model));
if(getTarget() != null)//1
{ 
Object type = Model.getFacade().getType(getTarget());
if(type != null)//1
if(!newList.contains(type))//1
{ 
newList.add(type);
} 


} 

setElements(newList);
} 

 } 


