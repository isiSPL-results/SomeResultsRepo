package org.argouml.uml.cognitive.critics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.argouml.kernel.Project;
import org.argouml.model.Model;
import org.argouml.util.IteratorEnumeration;
import org.argouml.util.SingleElementIterator;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.util.ChildGenerator;
public class ChildGenUML implements ChildGenerator
  { 
public Iterator gen2(Object o)
    { 
if(o instanceof Project)//1
{ 
Project p = (Project) o;
Collection result = new ArrayList();
result.addAll(p.getUserDefinedModelList());
result.addAll(p.getDiagramList());
return result.iterator();
} 
if(o instanceof Diagram)//1
{ 
Collection figs = ((Diagram) o).getLayer().getContents();
if(figs != null)//1
{ 
return figs.iterator();
} 
} 
if(Model.getFacade().isAPackage(o))//1
{ 
Collection ownedElements =
                Model.getFacade().getOwnedElements(o);
if(ownedElements != null)//1
{ 
return ownedElements.iterator();
} 
} 
if(Model.getFacade().isAElementImport(o))//1
{ 
Object me = Model.getFacade().getModelElement(o);
if(me != null)//1
{ 
return new SingleElementIterator(me);
} 
} 
if(Model.getFacade().isAClassifier(o))//1
{ 
Collection result = new ArrayList();
result.addAll(Model.getFacade().getFeatures(o));
Collection sms = Model.getFacade().getBehaviors(o);
if(sms != null)//1
{ 
result.addAll(sms);
} 
return result.iterator();
} 
if(Model.getFacade().isAAssociation(o))//1
{ 
List assocEnds = (List) Model.getFacade().getConnections(o);
if(assocEnds != null)//1
{ 
return assocEnds.iterator();
} 
} 
if(Model.getFacade().isAStateMachine(o))//1
{ 
Collection result = new ArrayList();
Object top = Model.getStateMachinesHelper().getTop(o);
if(top != null)//1
{ 
result.add(top);
} 
result.addAll(Model.getFacade().getTransitions(o));
return result.iterator();
} 
if(Model.getFacade().isACompositeState(o))//1
{ 
Collection substates = Model.getFacade().getSubvertices(o);
if(substates != null)//1
{ 
return substates.iterator();
} 
} 
if(Model.getFacade().isAOperation(o))//1
{ 
Collection params = Model.getFacade().getParameters(o);
if(params != null)//1
{ 
return params.iterator();
} 
} 
if(Model.getFacade().isAModelElement(o))//1
{ 
Collection behavior = Model.getFacade().getBehaviors(o);
if(behavior != null)//1
{ 
return behavior.iterator();
} 
} 
if(Model.getFacade().isAUMLElement(o))//1
{ 
Collection result = Model.getFacade().getModelElementContents(o);
return result.iterator();
} 
return Collections.emptySet().iterator();
} 
@Deprecated
    public Enumeration gen(Object o)
    { 
return new IteratorEnumeration(gen2(o));
} 

 } 
