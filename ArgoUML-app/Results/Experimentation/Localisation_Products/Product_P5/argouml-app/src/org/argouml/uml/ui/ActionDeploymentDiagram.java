package org.argouml.uml.ui;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramFactory;
public class ActionDeploymentDiagram extends ActionAddDiagram
  { 
private static final Logger LOG =
        Logger.getLogger(ActionDeploymentDiagram.class);
private static final long serialVersionUID = 9027235104963895167L;
public ArgoDiagram createDiagram(Object namespace)
    { 
if(!Model.getFacade().isANamespace(namespace))//1
{ 
LOG.error("No namespace as argument");
LOG.error(namespace);
throw new IllegalArgumentException(
                "The argument " + namespace
                + "is not a namespace.");
} 
return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.Deployment,
                   namespace,
                   null);
} 
public ActionDeploymentDiagram()
    { 
super("action.deployment-diagram");
} 
@Override
    protected Object findNamespace()
    { 
Object ns = super.findNamespace();
if(ns == null)//1
{ 
return ns;
} 
if(!Model.getFacade().isANamespace(ns))//1
{ 
return ns;
} 
while (!Model.getFacade().isAPackage(ns)) //1
{ 
Object candidate = Model.getFacade().getNamespace(ns);
if(!Model.getFacade().isANamespace(candidate))//1
{ 
return null;
} 
ns = candidate;
} 
return ns;
} 
public boolean isValidNamespace(Object namespace)
    { 
if(!Model.getFacade().isANamespace(namespace))//1
{ 
LOG.error("No namespace as argument");
LOG.error(namespace);
throw new IllegalArgumentException(
                "The argument " + namespace
                + "is not a namespace.");
} 
if(Model.getFacade().isAPackage(namespace))//1
{ 
return true;
} 
return false;
} 

 } 
