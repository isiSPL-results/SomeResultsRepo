
//#if -1521817140 
// Compilation Unit of /UMLClassifierParameterListModel.java 
 

//#if -1117396355 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -394499239 
import java.util.Collection;
//#endif 


//#if -1403333031 
import java.util.List;
//#endif 


//#if -1180057096 
import org.argouml.model.Model;
//#endif 


//#if 683632271 
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
//#endif 


//#if 1089108839 
public class UMLClassifierParameterListModel extends 
//#if 1838619250 
UMLModelElementOrderedListModel2
//#endif 

  { 

//#if 50390830 
protected void moveDown(int index)
    { 

//#if -1038223820 
Object clss = getTarget();
//#endif 


//#if -382832175 
Collection c = Model.getFacade().getParameters(clss);
//#endif 


//#if -62625127 
if(c instanceof List && index < c.size() - 1)//1
{ 

//#if -2127442733 
Object mem = ((List) c).get(index);
//#endif 


//#if -1732740527 
Model.getCoreHelper().removeParameter(clss, mem);
//#endif 


//#if 1765740134 
Model.getCoreHelper().addParameter(clss, index + 1, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -437127984 
@Override
    protected void moveToBottom(int index)
    { 

//#if 178608407 
Object clss = getTarget();
//#endif 


//#if 309549326 
Collection c = Model.getFacade().getParameters(clss);
//#endif 


//#if 411617814 
if(c instanceof List && index < c.size() - 1)//1
{ 

//#if 1082946607 
Object mem = ((List) c).get(index);
//#endif 


//#if 126744181 
Model.getCoreHelper().removeParameter(clss, mem);
//#endif 


//#if -174783203 
Model.getCoreHelper().addParameter(clss, c.size() - 1, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2131554892 
@Override
    protected void moveToTop(int index)
    { 

//#if 1807508034 
Object clss = getTarget();
//#endif 


//#if -2024084221 
Collection c = Model.getFacade().getParameters(clss);
//#endif 


//#if -839346556 
if(c instanceof List && index > 0)//1
{ 

//#if -1115417546 
Object mem = ((List) c).get(index);
//#endif 


//#if -993557170 
Model.getCoreHelper().removeParameter(clss, mem);
//#endif 


//#if -37577087 
Model.getCoreHelper().addParameter(clss, 0, mem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 540343895 
protected void buildModelList()
    { 

//#if 84446825 
if(getTarget() != null)//1
{ 

//#if 2132915614 
setAllElements(Model.getFacade().getParameters(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2051929270 
public UMLClassifierParameterListModel()
    { 

//#if -590528060 
super("parameter");
//#endif 

} 

//#endif 


//#if 1369200779 
protected boolean isValidElement(Object element)
    { 

//#if -1472807066 
return Model.getFacade().getParameters(getTarget()).contains(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

