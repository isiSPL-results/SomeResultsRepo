
//#if -1346260313 
// Compilation Unit of /UMLExtendExtensionPointListModel.java 
 

//#if 1853009205 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 1924927198 
import java.util.List;
//#endif 


//#if -1957736685 
import org.argouml.model.Model;
//#endif 


//#if 489458986 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if -447204735 
public class UMLExtendExtensionPointListModel extends 
//#if -970503334 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if -1247006565 
protected void moveDown(int index1)
    { 

//#if 1544181994 
int index2 = index1 + 1;
//#endif 


//#if -1091412615 
Object extend = getTarget();
//#endif 


//#if 1920142381 
List c = (List) Model.getFacade().getExtensionPoints(extend);
//#endif 


//#if 1798425970 
Object mem1 = c.get(index1);
//#endif 


//#if 174949885 
Model.getUseCasesHelper().removeExtensionPoint(extend, mem1);
//#endif 


//#if 1055948590 
Model.getUseCasesHelper().addExtensionPoint(extend, index2, mem1);
//#endif 

} 

//#endif 


//#if 787789423 
protected void buildModelList()
    { 

//#if -282439361 
setAllElements(Model.getFacade().getExtensionPoints(getTarget()));
//#endif 

} 

//#endif 


//#if -264157596 
@Override
    protected void moveToTop(int index)
    { 

//#if 1826923513 
Object extend = getTarget();
//#endif 


//#if -1045736787 
List c = (List) Model.getFacade().getExtensionPoints(extend);
//#endif 


//#if -1363538721 
if(index > 0)//1
{ 

//#if -60741838 
Object mem1 = c.get(index);
//#endif 


//#if 573461164 
Model.getUseCasesHelper().removeExtensionPoint(extend, mem1);
//#endif 


//#if 737444519 
Model.getUseCasesHelper().addExtensionPoint(extend, 0, mem1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1636300360 
@Override
    protected void moveToBottom(int index)
    { 

//#if 908824434 
Object extend = getTarget();
//#endif 


//#if 2004752934 
List c = (List) Model.getFacade().getExtensionPoints(extend);
//#endif 


//#if -1389243895 
if(index < c.size() - 1)//1
{ 

//#if 1570018577 
Object mem1 = c.get(index);
//#endif 


//#if -1172275957 
Model.getUseCasesHelper().removeExtensionPoint(extend, mem1);
//#endif 


//#if -1679747313 
Model.getUseCasesHelper().addExtensionPoint(extend, c.size(), mem1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -686498288 
protected boolean isValidElement(Object o)
    { 

//#if -299489008 
return Model.getFacade().isAExtensionPoint(o)
               && Model.getFacade().getExtensionPoints(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if -1815513533 
public UMLExtendExtensionPointListModel()
    { 

//#if -671640579 
super("extensionPoint");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

