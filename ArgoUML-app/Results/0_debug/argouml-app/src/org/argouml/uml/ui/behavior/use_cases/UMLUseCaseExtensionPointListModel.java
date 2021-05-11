
//#if 1669595205 
// Compilation Unit of /UMLUseCaseExtensionPointListModel.java 
 

//#if -1959761215 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if -119381097 
import java.util.ArrayList;
//#endif 


//#if -183244903 
import java.util.Collections;
//#endif 


//#if -1230851990 
import java.util.List;
//#endif 


//#if 309832455 
import org.argouml.model.Model;
//#endif 


//#if -1632357602 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if 70570486 
public class UMLUseCaseExtensionPointListModel extends 
//#if -962242870 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if -1518266124 
@Override
    protected void moveToTop(int index)
    { 

//#if 1896911461 
Object usecase = getTarget();
//#endif 


//#if -1209912206 
List c = new ArrayList(Model.getFacade().getExtensionPoints(usecase));
//#endif 


//#if -236527186 
if(index > 0)//1
{ 

//#if -1615912934 
Object mem1 = c.get(index);
//#endif 


//#if -322930830 
c.remove(mem1);
//#endif 


//#if 360891825 
c.add(0, mem1);
//#endif 


//#if 151562687 
Model.getUseCasesHelper().setExtensionPoints(usecase, c);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -605036289 
protected void buildModelList()
    { 

//#if 1107275321 
setAllElements(Model.getFacade().getExtensionPoints(getTarget()));
//#endif 

} 

//#endif 


//#if -862950104 
@Override
    protected void moveToBottom(int index)
    { 

//#if -542325580 
Object usecase = getTarget();
//#endif 


//#if 139570113 
List c = new ArrayList(Model.getFacade().getExtensionPoints(usecase));
//#endif 


//#if -1538848654 
if(index < c.size() - 1)//1
{ 

//#if 398937040 
Object mem1 = c.get(index);
//#endif 


//#if -2114705668 
c.remove(mem1);
//#endif 


//#if 1007873456 
c.add(c.size(), mem1);
//#endif 


//#if -720077451 
Model.getUseCasesHelper().setExtensionPoints(usecase, c);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1148338218 
protected void moveDown(int index)
    { 

//#if 1085390416 
Object usecase = getTarget();
//#endif 


//#if -1866213027 
List c = new ArrayList(Model.getFacade().getExtensionPoints(usecase));
//#endif 


//#if -273558442 
if(index < c.size() - 1)//1
{ 

//#if -1136443710 
Collections.swap(c, index, index + 1);
//#endif 


//#if 1012305089 
Model.getUseCasesHelper().setExtensionPoints(usecase, c);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 206050464 
protected boolean isValidElement(Object o)
    { 

//#if 85365005 
return Model.getFacade().getExtensionPoints(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if -682257102 
public UMLUseCaseExtensionPointListModel()
    { 

//#if 510099282 
super("extensionPoint");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

