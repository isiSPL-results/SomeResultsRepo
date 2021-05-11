
//#if -2027025778 
// Compilation Unit of /ActionClassDiagram.java 
 

//#if -229703201 
package org.argouml.uml.ui;
//#endif 


//#if -1458076069 
import org.apache.log4j.Logger;
//#endif 


//#if 389460430 
import org.argouml.model.Model;
//#endif 


//#if -1006727539 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1966316008 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if 2024933297 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 87489547 
public class ActionClassDiagram extends 
//#if 1554841290 
ActionAddDiagram
//#endif 

  { 

//#if 1869808509 
private static final Logger LOG =
        Logger.getLogger(ActionClassDiagram.class);
//#endif 


//#if 1480316557 
private static final long serialVersionUID = 2415943949021223859L;
//#endif 


//#if 280033901 

//#if -37493623 
@SuppressWarnings("deprecation")
//#endif 


    @Override
    public ArgoDiagram createDiagram(Object ns)
    { 

//#if 1456043340 
if(isValidNamespace(ns))//1
{ 

//#if -776156990 
return DiagramFactory.getInstance().createDiagram(
                       DiagramFactory.DiagramType.Class,
                       ns,
                       null);
//#endif 

} 

//#endif 


//#if 942287383 
LOG.error("No namespace as argument");
//#endif 


//#if 1415290541 
LOG.error(ns);
//#endif 


//#if 2096255282 
throw new IllegalArgumentException(
            "The argument " + ns + "is not a namespace.");
//#endif 

} 

//#endif 


//#if -1892636995 
public ActionClassDiagram()
    { 

//#if -1572164926 
super("action.class-diagram");
//#endif 

} 

//#endif 


//#if 1139996064 
public boolean isValidNamespace(Object handle)
    { 

//#if 935450902 
return Model.getFacade().isANamespace(handle);
//#endif 

} 

//#endif 


//#if -2026962528 
@Override
    public ArgoDiagram createDiagram(Object ns, DiagramSettings settings)
    { 

//#if -447816701 
if(isValidNamespace(ns))//1
{ 

//#if 1143778780 
return DiagramFactory.getInstance().create(
                       DiagramFactory.DiagramType.Class,
                       ns,
                       settings);
//#endif 

} 

//#endif 


//#if -1294669362 
LOG.error("No namespace as argument");
//#endif 


//#if -14509418 
LOG.error(ns);
//#endif 


//#if 1984462363 
throw new IllegalArgumentException(
            "The argument " + ns + "is not a namespace.");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

