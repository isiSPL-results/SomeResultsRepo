
//#if 1072316754 
// Compilation Unit of /ActionDeploymentDiagram.java 
 

//#if -2090461790 
package org.argouml.uml.ui;
//#endif 


//#if -316079970 
import org.apache.log4j.Logger;
//#endif 


//#if 1531456529 
import org.argouml.model.Model;
//#endif 


//#if 1408482384 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 260357493 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if -1876138687 
public class ActionDeploymentDiagram extends 
//#if -1801084358 
ActionAddDiagram
//#endif 

  { 

//#if 1981063860 
private static final Logger LOG =
        Logger.getLogger(ActionDeploymentDiagram.class);
//#endif 


//#if 1463216296 
private static final long serialVersionUID = 9027235104963895167L;
//#endif 


//#if 762335965 
public ArgoDiagram createDiagram(Object namespace)
    { 

//#if -1215194744 
if(!Model.getFacade().isANamespace(namespace))//1
{ 

//#if -1211002466 
LOG.error("No namespace as argument");
//#endif 


//#if 461747678 
LOG.error(namespace);
//#endif 


//#if -616556871 
throw new IllegalArgumentException(
                "The argument " + namespace
                + "is not a namespace.");
//#endif 

} 

//#endif 


//#if 253128281 
return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.Deployment,
                   namespace,
                   null);
//#endif 

} 

//#endif 


//#if 1458524862 
public ActionDeploymentDiagram()
    { 

//#if -2130628233 
super("action.deployment-diagram");
//#endif 

} 

//#endif 


//#if 1810587792 
@Override
    protected Object findNamespace()
    { 

//#if -1569435239 
Object ns = super.findNamespace();
//#endif 


//#if 783131476 
if(ns == null)//1
{ 

//#if 1479264176 
return ns;
//#endif 

} 

//#endif 


//#if -2014351765 
if(!Model.getFacade().isANamespace(ns))//1
{ 

//#if 1027873191 
return ns;
//#endif 

} 

//#endif 


//#if 1002506804 
while (!Model.getFacade().isAPackage(ns)) //1
{ 

//#if -1638447981 
Object candidate = Model.getFacade().getNamespace(ns);
//#endif 


//#if 1262947694 
if(!Model.getFacade().isANamespace(candidate))//1
{ 

//#if 2099406458 
return null;
//#endif 

} 

//#endif 


//#if 1587057668 
ns = candidate;
//#endif 

} 

//#endif 


//#if -695317989 
return ns;
//#endif 

} 

//#endif 


//#if 892092063 
public boolean isValidNamespace(Object namespace)
    { 

//#if 1176337724 
if(!Model.getFacade().isANamespace(namespace))//1
{ 

//#if -791143278 
LOG.error("No namespace as argument");
//#endif 


//#if -1109935150 
LOG.error(namespace);
//#endif 


//#if 349679789 
throw new IllegalArgumentException(
                "The argument " + namespace
                + "is not a namespace.");
//#endif 

} 

//#endif 


//#if 661670152 
if(Model.getFacade().isAPackage(namespace))//1
{ 

//#if -2001799017 
return true;
//#endif 

} 

//#endif 


//#if 475766254 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

