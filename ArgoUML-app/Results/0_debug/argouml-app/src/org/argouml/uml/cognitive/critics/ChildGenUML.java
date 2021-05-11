
//#if -1376705062 
// Compilation Unit of /ChildGenUML.java 
 

//#if 1975041327 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -151680889 
import java.util.ArrayList;
//#endif 


//#if 932457914 
import java.util.Collection;
//#endif 


//#if -1158573943 
import java.util.Collections;
//#endif 


//#if 1509114391 
import java.util.Enumeration;
//#endif 


//#if 1363771690 
import java.util.Iterator;
//#endif 


//#if -1886898822 
import java.util.List;
//#endif 


//#if 1768926340 
import org.apache.log4j.Logger;
//#endif 


//#if 109135795 
import org.argouml.kernel.Project;
//#endif 


//#if -678504457 
import org.argouml.model.Model;
//#endif 


//#if -1702101586 
import org.argouml.util.IteratorEnumeration;
//#endif 


//#if 1794199205 
import org.argouml.util.SingleElementIterator;
//#endif 


//#if 53515688 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 1590771029 
import org.tigris.gef.util.ChildGenerator;
//#endif 


//#if -1246452337 
public class ChildGenUML implements 
//#if 930170669 
ChildGenerator
//#endif 

  { 

//#if -1023650368 
private static final Logger LOG = Logger.getLogger(ChildGenUML.class);
//#endif 


//#if 135367154 
public Iterator gen2(Object o)
    { 

//#if 1089776447 
if(LOG.isDebugEnabled())//1
{ 

//#if 2074288515 
if(o == null)//1
{ 

//#if 843971288 
LOG.debug("Object is null");
//#endif 

} 
else
{ 
} 

//#endif 

} 

//#endif 


//#if -1503942086 
if(o instanceof Project)//1
{ 

//#if -889578006 
Project p = (Project) o;
//#endif 


//#if 192638381 
Collection result = new ArrayList();
//#endif 


//#if -1681015951 
result.addAll(p.getUserDefinedModelList());
//#endif 


//#if -1796726481 
result.addAll(p.getDiagramList());
//#endif 


//#if -963314921 
return result.iterator();
//#endif 

} 

//#endif 


//#if 1838244596 
if(o instanceof Diagram)//1
{ 

//#if -1958047852 
Collection figs = ((Diagram) o).getLayer().getContents();
//#endif 


//#if 921513259 
if(figs != null)//1
{ 

//#if 787505694 
return figs.iterator();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -692740667 
if(Model.getFacade().isAPackage(o))//1
{ 

//#if 442454344 
Collection ownedElements =
                Model.getFacade().getOwnedElements(o);
//#endif 


//#if -1697763964 
if(ownedElements != null)//1
{ 

//#if 821688391 
return ownedElements.iterator();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -556315862 
if(Model.getFacade().isAElementImport(o))//1
{ 

//#if -1801446028 
Object me = Model.getFacade().getModelElement(o);
//#endif 


//#if -844159052 
if(me != null)//1
{ 

//#if 631575642 
return new SingleElementIterator(me);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1768201960 
if(Model.getFacade().isAClassifier(o))//1
{ 

//#if -463954759 
Collection result = new ArrayList();
//#endif 


//#if 816023698 
result.addAll(Model.getFacade().getFeatures(o));
//#endif 


//#if 154027968 
Collection sms = Model.getFacade().getBehaviors(o);
//#endif 


//#if 1617228337 
if(sms != null)//1
{ 

//#if -1477836549 
result.addAll(sms);
//#endif 

} 

//#endif 


//#if -2056784349 
return result.iterator();
//#endif 

} 

//#endif 


//#if 1283728554 
if(Model.getFacade().isAAssociation(o))//1
{ 

//#if 216211889 
List assocEnds = (List) Model.getFacade().getConnections(o);
//#endif 


//#if -358251501 
if(assocEnds != null)//1
{ 

//#if 993948952 
return assocEnds.iterator();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -188866253 
if(Model.getFacade().isAStateMachine(o))//1
{ 

//#if -1311232164 
Collection result = new ArrayList();
//#endif 


//#if -730601623 
Object top = Model.getStateMachinesHelper().getTop(o);
//#endif 


//#if 1449419728 
if(top != null)//1
{ 

//#if 140101730 
result.add(top);
//#endif 

} 

//#endif 


//#if -48326184 
result.addAll(Model.getFacade().getTransitions(o));
//#endif 


//#if -452338746 
return result.iterator();
//#endif 

} 

//#endif 


//#if -541424865 
if(Model.getFacade().isACompositeState(o))//1
{ 

//#if -635255722 
Collection substates = Model.getFacade().getSubvertices(o);
//#endif 


//#if 467033057 
if(substates != null)//1
{ 

//#if -2083182267 
return substates.iterator();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 91326788 
if(Model.getFacade().isAOperation(o))//1
{ 

//#if 1976205898 
Collection params = Model.getFacade().getParameters(o);
//#endif 


//#if -1756087440 
if(params != null)//1
{ 

//#if 594748960 
return params.iterator();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -386822794 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if 691259513 
Collection behavior = Model.getFacade().getBehaviors(o);
//#endif 


//#if -1995290450 
if(behavior != null)//1
{ 

//#if -2014087623 
return behavior.iterator();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1924925345 
if(Model.getFacade().isAUMLElement(o))//1
{ 

//#if -146407356 
Collection result = Model.getFacade().getModelElementContents(o);
//#endif 


//#if 1947303063 
return result.iterator();
//#endif 

} 

//#endif 


//#if -1072587532 
return Collections.emptySet().iterator();
//#endif 

} 

//#endif 


//#if 742339698 
@Deprecated
    public Enumeration gen(Object o)
    { 

//#if 1245807581 
return new IteratorEnumeration(gen2(o));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

