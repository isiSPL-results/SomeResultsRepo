// Compilation Unit of /ChildGenUML.java 
 

//#if COGNITIVE 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.Collection;
//#endif 


//#if COGNITIVE 
import java.util.Collections;
//#endif 


//#if COGNITIVE 
import java.util.Enumeration;
//#endif 


//#if COGNITIVE 
import java.util.Iterator;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.kernel.Project;
//#endif 


//#if COGNITIVE 
import org.argouml.model.Model;
//#endif 


//#if COGNITIVE 
import org.argouml.util.IteratorEnumeration;
//#endif 


//#if COGNITIVE 
import org.argouml.util.SingleElementIterator;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.base.Diagram;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.util.ChildGenerator;
//#endif 


//#if COGNITIVE 
public class ChildGenUML implements ChildGenerator
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG = Logger.getLogger(ChildGenUML.class);
//#endif 

public Iterator gen2(Object o)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
if(LOG.isDebugEnabled())//1
{ 
if(o == null)//1
{ 
LOG.debug("Object is null");
} 
else
{ 
} 

} 

//#endif 

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

//#endif 


