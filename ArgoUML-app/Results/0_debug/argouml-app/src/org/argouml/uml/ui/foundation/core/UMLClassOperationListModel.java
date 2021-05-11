
//#if -871923556 
// Compilation Unit of /UMLClassOperationListModel.java 
 

//#if 201489087 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -996845353 
import java.util.List;
//#endif 


//#if -901305030 
import org.argouml.model.Model;
//#endif 


//#if 1727478481 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if -1701488842 
public class UMLClassOperationListModel extends 
//#if 519147619 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if 1019845499 
@Override
    protected void moveToTop(int index)
    { 

//#if 2082963084 
Object clss = getTarget();
//#endif 


//#if 1258310036 
List c = Model.getFacade().getOperationsAndReceptions(clss);
//#endif 


//#if 2014674877 
if(index > 0)//1
{ 

//#if 1412067807 
Object mem1 = c.get(index);
//#endif 


//#if 1664316338 
Model.getCoreHelper().removeFeature(clss, mem1);
//#endif 


//#if 818811363 
Model.getCoreHelper().addFeature(clss, 0, mem1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 242644388 
protected void moveDown(int index1)
    { 

//#if 174822517 
int index2 = index1 + 1;
//#endif 


//#if 624111413 
Object clss = getTarget();
//#endif 


//#if -633958403 
List c = Model.getFacade().getOperationsAndReceptions(clss);
//#endif 


//#if -2043174082 
if(index1 < c.size() - 1)//1
{ 

//#if -1336695846 
Object op1 = c.get(index1);
//#endif 


//#if -1847229062 
Object op2 = c.get(index2);
//#endif 


//#if -939990841 
List f = Model.getFacade().getFeatures(clss);
//#endif 


//#if -2076641057 
index2 = f.indexOf(op2);
//#endif 


//#if -566934972 
Model.getCoreHelper().removeFeature(clss, op1);
//#endif 


//#if 1628399221 
Model.getCoreHelper().addFeature(clss, index2, op1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1909989496 
public UMLClassOperationListModel()
    { 

//#if -1325599945 
super("feature");
//#endif 

} 

//#endif 


//#if 561173050 
protected boolean isValidElement(Object element)
    { 

//#if -371975898 
return (Model.getFacade().getOperationsAndReceptions(getTarget())
                .contains(element));
//#endif 

} 

//#endif 


//#if 138065414 
protected void buildModelList()
    { 

//#if 76351024 
if(getTarget() != null)//1
{ 

//#if -1468275047 
List opsAndReceps =
                Model.getFacade().getOperationsAndReceptions(getTarget());
//#endif 


//#if 164851467 
setAllElements(opsAndReceps);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -878835391 
@Override
    protected void moveToBottom(int index)
    { 

//#if 505193535 
Object clss = getTarget();
//#endif 


//#if 1828340359 
List c = Model.getFacade().getOperationsAndReceptions(clss);
//#endif 


//#if 560883941 
if(index < c.size() - 1)//1
{ 

//#if 1833414627 
Object mem1 = c.get(index);
//#endif 


//#if -1441353426 
Model.getCoreHelper().removeFeature(clss, mem1);
//#endif 


//#if 1405768204 
Model.getCoreHelper().addFeature(clss, c.size() - 1, mem1);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

