
//#if 148318753 
// Compilation Unit of /SelectionEnumeration.java 
 

//#if 938816899 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 786163657 
import org.argouml.model.Model;
//#endif 


//#if 109988032 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 179932355 
class SelectionEnumeration extends 
//#if 369040898 
SelectionDataType
//#endif 

  { 

//#if -1230922303 
private static String[] instructions = {
        "Add a super-enumeration",
        "Add a sub-enumeration",
        null,
        null,
        null,
        "Move object(s)",
    };
//#endif 


//#if 397242291 
@Override
    protected Object getNewNodeType(int index)
    { 

//#if -598335200 
return Model.getMetaTypes().getEnumeration();
//#endif 

} 

//#endif 


//#if -1042901583 
public SelectionEnumeration(Fig f)
    { 

//#if -1129192503 
super(f);
//#endif 

} 

//#endif 


//#if -697042079 
@Override
    protected String getInstructions(int i)
    { 

//#if 1341130253 
return instructions[ i - 10];
//#endif 

} 

//#endif 


//#if -1911526823 
@Override
    protected Object getNewNode(int index)
    { 

//#if 266775495 
Object ns = Model.getFacade().getNamespace(getContent().getOwner());
//#endif 


//#if -895971412 
return Model.getCoreFactory().buildEnumeration("", ns);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

