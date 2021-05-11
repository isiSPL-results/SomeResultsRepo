
//#if -562502521 
// Compilation Unit of /UMLClassAttributeListModel.java 
 

//#if 10374623 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1648897609 
import java.util.List;
//#endif 


//#if 1152299098 
import org.argouml.model.Model;
//#endif 


//#if -590819855 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if -695122303 
public class UMLClassAttributeListModel extends 
//#if -1878508169 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if 2035660885 
@Override
    protected void moveToBottom(int index)
    { 

//#if -791063555 
Object clss = getTarget();
//#endif 


//#if -1769731941 
List c = Model.getFacade().getAttributes(clss);
//#endif 


//#if -735373149 
if(index < c.size() - 1)//1
{ 

//#if -360571298 
Object mem1 = c.get(index);
//#endif 


//#if -1413470125 
Model.getCoreHelper().removeFeature(clss, mem1);
//#endif 


//#if -638528463 
Model.getCoreHelper().addFeature(clss, c.size() - 1, mem1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2139955896 
protected void moveDown(int index1)
    { 

//#if 1985593403 
int index2 = index1 + 1;
//#endif 


//#if 1392117755 
Object clss = getTarget();
//#endif 


//#if -1567596707 
List c = Model.getFacade().getAttributes(clss);
//#endif 


//#if 290186040 
if(index1 < c.size() - 1)//1
{ 

//#if -493717566 
Object mem1 = c.get(index1);
//#endif 


//#if -1004250782 
Object mem2 = c.get(index2);
//#endif 


//#if 2129290741 
List f = Model.getFacade().getFeatures(clss);
//#endif 


//#if 535821957 
index2 = f.indexOf(mem2);
//#endif 


//#if 524434526 
Model.getCoreHelper().removeFeature(clss, mem1);
//#endif 


//#if 1377469773 
Model.getCoreHelper().addFeature(clss, index2, mem1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 716244390 
protected boolean isValidElement(Object element)
    { 

//#if 1631434686 
return (Model.getFacade().getAttributes(getTarget()).contains(element));
//#endif 

} 

//#endif 


//#if 1537369319 
@Override
    protected void moveToTop(int index)
    { 

//#if -184468073 
Object clss = getTarget();
//#endif 


//#if 67765057 
List c = Model.getFacade().getAttributes(clss);
//#endif 


//#if -1600808878 
if(index > 0)//1
{ 

//#if -1035526011 
Object mem1 = c.get(index);
//#endif 


//#if 1303751244 
Model.getCoreHelper().removeFeature(clss, mem1);
//#endif 


//#if -1271029751 
Model.getCoreHelper().addFeature(clss, 0, mem1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 574964082 
protected void buildModelList()
    { 

//#if -33510427 
if(getTarget() != null)//1
{ 

//#if 599985852 
setAllElements(Model.getFacade().getAttributes(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -646258873 
public UMLClassAttributeListModel()
    { 

//#if -1024823958 
super("feature");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

