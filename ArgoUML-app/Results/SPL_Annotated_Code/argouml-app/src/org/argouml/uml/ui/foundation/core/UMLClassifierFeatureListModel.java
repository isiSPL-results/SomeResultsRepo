// Compilation Unit of /UMLClassifierFeatureListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import java.util.List;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
public class UMLClassifierFeatureListModel extends UMLModelElementOrderedListModel2
  { 
@Override
    protected void moveToBottom(int index)
    { 
Object clss = getTarget();
List c = Model.getFacade().getFeatures(clss);
if(index < c.size() - 1)//1
{ 
Object mem = c.get(index);
Model.getCoreHelper().removeFeature(clss, mem);
Model.getCoreHelper().addFeature(clss, c.size(), mem);
} 

} 

protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getFeatures(getTarget()));
} 

} 

protected void moveDown(int index)
    { 
Object clss = getTarget();
List c = Model.getFacade().getFeatures(clss);
if(index < c.size() - 1)//1
{ 
Object mem = c.get(index);
Model.getCoreHelper().removeFeature(clss, mem);
Model.getCoreHelper().addFeature(clss, index + 1, mem);
} 

} 

protected boolean isValidElement(Object element)
    { 
return Model.getFacade().getFeatures(getTarget()).contains(element);
} 

public UMLClassifierFeatureListModel()
    { 
super("feature");
} 

@Override
    protected void moveToTop(int index)
    { 
Object clss = getTarget();
List c = Model.getFacade().getFeatures(clss);
if(index > 0)//1
{ 
Object mem = c.get(index);
Model.getCoreHelper().removeFeature(clss, mem);
Model.getCoreHelper().addFeature(clss, 0, mem);
} 

} 

 } 


