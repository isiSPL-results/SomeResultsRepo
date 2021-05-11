
//#if 1625788823 
// Compilation Unit of /UMLActionArgumentListModel.java 
 

//#if -2109322454 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -1160131378 
import java.util.List;
//#endif 


//#if 1362116387 
import org.argouml.model.Model;
//#endif 


//#if -834419398 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if -989736599 
public class UMLActionArgumentListModel extends 
//#if 373348341 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if 1808333443 
private static final long serialVersionUID = -3265997785192090331L;
//#endif 


//#if -1577810477 
@Override
    protected void moveToBottom(int index)
    { 

//#if -1371410460 
Object clss = getTarget();
//#endif 


//#if 1129124755 
List c = Model.getFacade().getActualArguments(clss);
//#endif 


//#if -1315720054 
if(index < c.size() - 1)//1
{ 

//#if 1177444636 
Object mem = c.get(index);
//#endif 


//#if 499107752 
Model.getCommonBehaviorHelper().removeActualArgument(clss, mem);
//#endif 


//#if -132976002 
Model.getCommonBehaviorHelper().addActualArgument(clss,
                    c.size() - 1, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1908467636 
protected void buildModelList()
    { 

//#if 217518835 
if(getTarget() != null)//1
{ 

//#if -1524685203 
setAllElements(Model.getFacade().getActualArguments(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 557313355 
protected void moveDown(int index)
    { 

//#if -97614114 
Object clss = getTarget();
//#endif 


//#if -1187740147 
List c = Model.getFacade().getActualArguments(clss);
//#endif 


//#if -41923708 
if(index < c.size() - 1)//1
{ 

//#if -1207093567 
Object mem = c.get(index);
//#endif 


//#if -1063168947 
Model.getCommonBehaviorHelper().removeActualArgument(clss, mem);
//#endif 


//#if -136441476 
Model.getCommonBehaviorHelper().addActualArgument(clss, index + 1,
                    mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1097025495 
@Override
    protected void moveToTop(int index)
    { 

//#if -471727440 
Object clss = getTarget();
//#endif 


//#if 280231775 
List c = Model.getFacade().getActualArguments(clss);
//#endif 


//#if -1841102055 
if(index > 0)//1
{ 

//#if 1674726798 
Object mem = c.get(index);
//#endif 


//#if -480585190 
Model.getCommonBehaviorHelper().removeActualArgument(clss, mem);
//#endif 


//#if -1543367353 
Model.getCommonBehaviorHelper().addActualArgument(clss, 0, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -915914794 
public UMLActionArgumentListModel()
    { 

//#if -2106819663 
super("actualArgument");
//#endif 

} 

//#endif 


//#if 367781864 
protected boolean isValidElement(Object element)
    { 

//#if -148122468 
return Model.getFacade().isAArgument(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

