package org.argouml.uml.ui;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramFactory;
import org.argouml.uml.diagram.DiagramSettings;
public class ActionUseCaseDiagram extends ActionAddDiagram
  { 
private static final Logger LOG =
        Logger.getLogger(ActionUseCaseDiagram.class);
public ActionUseCaseDiagram()
    { 
super("action.usecase-diagram");
} 
public boolean isValidNamespace(Object handle)
    { 
return (Model.getFacade().isAPackage(handle)
                || Model.getFacade().isAClassifier(handle));
} 
@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public ArgoDiagram createDiagram(Object namespace)
    { 
if(!Model.getFacade().isANamespace(namespace))//1
{ 
LOG.error("No namespace as argument");
LOG.error(namespace);
throw new IllegalArgumentException(
                "The argument " + namespace + "is not a namespace.");
} 
return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.UseCase,
                   namespace,
                   null);
} 
@Override
    public ArgoDiagram createDiagram(Object namespace,
                                     DiagramSettings settings)
    { 
if(!Model.getFacade().isANamespace(namespace))//1
{ 
LOG.error("No namespace as argument");
LOG.error(namespace);
throw new IllegalArgumentException(
                "The argument " + namespace + "is not a namespace.");
} 
return DiagramFactory.getInstance().create(
                   DiagramFactory.DiagramType.UseCase,
                   namespace,
                   settings);
} 

 } 
