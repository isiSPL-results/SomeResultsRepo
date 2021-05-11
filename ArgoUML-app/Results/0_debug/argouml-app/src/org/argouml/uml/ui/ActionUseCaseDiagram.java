
//#if -651116065 
// Compilation Unit of /ActionUseCaseDiagram.java 
 

//#if 469288776 
package org.argouml.uml.ui;
//#endif 


//#if -1273073852 
import org.apache.log4j.Logger;
//#endif 


//#if 574462647 
import org.argouml.model.Model;
//#endif 


//#if 1227514358 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -774148593 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if 327417498 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -191183997 
public class ActionUseCaseDiagram extends 
//#if 1209928527 
ActionAddDiagram
//#endif 

  { 

//#if 789948249 
private static final Logger LOG =
        Logger.getLogger(ActionUseCaseDiagram.class);
//#endif 


//#if -2083880317 
public ActionUseCaseDiagram()
    { 

//#if -2133045958 
super("action.usecase-diagram");
//#endif 

} 

//#endif 


//#if -1563214341 
public boolean isValidNamespace(Object handle)
    { 

//#if 1239644248 
return (Model.getFacade().isAPackage(handle)
                || Model.getFacade().isAClassifier(handle));
//#endif 

} 

//#endif 


//#if -487972849 

//#if -1518265404 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    public ArgoDiagram createDiagram(Object namespace)
    { 

//#if -1715240801 
if(!Model.getFacade().isANamespace(namespace))//1
{ 

//#if 718793436 
LOG.error("No namespace as argument");
//#endif 


//#if -966659172 
LOG.error(namespace);
//#endif 


//#if 1814037111 
throw new IllegalArgumentException(
                "The argument " + namespace + "is not a namespace.");
//#endif 

} 

//#endif 


//#if -1859350848 
return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.UseCase,
                   namespace,
                   null);
//#endif 

} 

//#endif 


//#if -1937124771 
@Override
    public ArgoDiagram createDiagram(Object namespace,
                                     DiagramSettings settings)
    { 

//#if -1670727690 
if(!Model.getFacade().isANamespace(namespace))//1
{ 

//#if -560776221 
LOG.error("No namespace as argument");
//#endif 


//#if 1405258979 
LOG.error(namespace);
//#endif 


//#if 1055922878 
throw new IllegalArgumentException(
                "The argument " + namespace + "is not a namespace.");
//#endif 

} 

//#endif 


//#if 315629892 
return DiagramFactory.getInstance().create(
                   DiagramFactory.DiagramType.UseCase,
                   namespace,
                   settings);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

