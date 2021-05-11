
//#if -1861548341 
// Compilation Unit of /UMLClassifierFeatureListModel.java 
 

//#if -709434684 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1343072334 
import java.util.List;
//#endif 


//#if -1082411841 
import org.argouml.model.Model;
//#endif 


//#if -567478058 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if 1548072449 
public class UMLClassifierFeatureListModel extends 
//#if 398775683 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if 1091739233 
@Override
    protected void moveToBottom(int index)
    { 

//#if 1993335633 
Object clss = getTarget();
//#endif 


//#if -1893038367 
List c = Model.getFacade().getFeatures(clss);
//#endif 


//#if 2049026039 
if(index < c.size() - 1)//1
{ 

//#if 45332918 
Object mem = c.get(index);
//#endif 


//#if -1388886989 
Model.getCoreHelper().removeFeature(clss, mem);
//#endif 


//#if 1485350513 
Model.getCoreHelper().addFeature(clss, c.size(), mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1978497818 
protected void buildModelList()
    { 

//#if 308005559 
if(getTarget() != null)//1
{ 

//#if 1326468904 
setAllElements(Model.getFacade().getFeatures(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1805059581 
protected void moveDown(int index)
    { 

//#if -350640829 
Object clss = getTarget();
//#endif 


//#if -1243886673 
List c = Model.getFacade().getFeatures(clss);
//#endif 


//#if -294950423 
if(index < c.size() - 1)//1
{ 

//#if 2015362872 
Object mem = c.get(index);
//#endif 


//#if 1117252721 
Model.getCoreHelper().removeFeature(clss, mem);
//#endif 


//#if -603141172 
Model.getCoreHelper().addFeature(clss, index + 1, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1519444250 
protected boolean isValidElement(Object element)
    { 

//#if -1362458292 
return Model.getFacade().getFeatures(getTarget()).contains(element);
//#endif 

} 

//#endif 


//#if 1669812012 
public UMLClassifierFeatureListModel()
    { 

//#if -1857603579 
super("feature");
//#endif 

} 

//#endif 


//#if -704505253 
@Override
    protected void moveToTop(int index)
    { 

//#if 3976136 
Object clss = getTarget();
//#endif 


//#if -235707126 
List c = Model.getFacade().getFeatures(clss);
//#endif 


//#if -1404485887 
if(index > 0)//1
{ 

//#if -503308734 
Object mem = c.get(index);
//#endif 


//#if -988511705 
Model.getCoreHelper().removeFeature(clss, mem);
//#endif 


//#if 439720590 
Model.getCoreHelper().addFeature(clss, 0, mem);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

