
//#if 712183806 
// Compilation Unit of /FigEdgeNote.java 
 

//#if -1400215863 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 1801754245 
import java.awt.event.MouseEvent;
//#endif 


//#if 150269550 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 74956122 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1504933040 
import org.apache.log4j.Logger;
//#endif 


//#if -1561680515 
import org.argouml.i18n.Translator;
//#endif 


//#if -1318296217 
import org.argouml.kernel.Project;
//#endif 


//#if 342603459 
import org.argouml.model.Model;
//#endif 


//#if 130526253 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if 1704706565 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 1173389990 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 768133417 
import org.argouml.uml.diagram.ui.ArgoFig;
//#endif 


//#if 505594439 
import org.argouml.uml.diagram.ui.ArgoFigUtil;
//#endif 


//#if 2098446119 
import org.argouml.util.IItemUID;
//#endif 


//#if -1262773346 
import org.argouml.util.ItemUID;
//#endif 


//#if -918258246 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1050099567 
import org.tigris.gef.presentation.FigEdgePoly;
//#endif 


//#if 1950009432 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1581198290 
public class FigEdgeNote extends 
//#if -1953532086 
FigEdgePoly
//#endif 

 implements 
//#if -283056408 
ArgoFig
//#endif 

, 
//#if -791060297 
IItemUID
//#endif 

, 
//#if -415926884 
PropertyChangeListener
//#endif 

  { 

//#if 1030427168 
private static final Logger LOG = Logger.getLogger(FigEdgeNote.class);
//#endif 


//#if -986615237 
private Object comment;
//#endif 


//#if -1246212136 
private Object annotatedElement;
//#endif 


//#if 483754850 
private DiagramSettings settings;
//#endif 


//#if 286285467 
private ItemUID itemUid;
//#endif 


//#if 1665773396 
@Override
    public void setSourceFigNode(FigNode fn)
    { 

//#if -1178885058 
if(fn != null && Model.getFacade().isAComment(fn.getOwner()))//1
{ 

//#if 321244132 
Object oldComment = comment;
//#endif 


//#if -1868364912 
if(oldComment != null)//1
{ 

//#if -1299149017 
removeElementListener(oldComment);
//#endif 

} 

//#endif 


//#if 85124531 
comment = fn.getOwner();
//#endif 


//#if -1941810435 
if(comment != null)//1
{ 

//#if 2121322185 
addElementListener(comment);
//#endif 

} 

//#endif 


//#if 2040837716 
((CommentEdge) getOwner()).setComment(comment);
//#endif 

} 
else

//#if -134624524 
if(fn != null
                   && !Model.getFacade().isAComment(fn.getOwner()))//1
{ 

//#if -1619921628 
annotatedElement = fn.getOwner();
//#endif 


//#if -126196428 
((CommentEdge) getOwner()).setAnnotatedElement(annotatedElement);
//#endif 

} 

//#endif 


//#endif 


//#if -2000015971 
super.setSourceFigNode(fn);
//#endif 

} 

//#endif 


//#if 1406105448 
protected Object getSource()
    { 

//#if -732295702 
Object theOwner = getOwner();
//#endif 


//#if -1073406737 
if(theOwner != null)//1
{ 

//#if -727144467 
return ((CommentEdge) theOwner).getSource();
//#endif 

} 

//#endif 


//#if 1274887707 
return null;
//#endif 

} 

//#endif 


//#if 1571168259 
protected Object getDestination()
    { 

//#if 654420280 
Object theOwner = getOwner();
//#endif 


//#if 555821281 
if(theOwner != null)//1
{ 

//#if 827922689 
return ((CommentEdge) theOwner).getDestination();
//#endif 

} 

//#endif 


//#if -1563938675 
return null;
//#endif 

} 

//#endif 


//#if 1298580226 
@Override
    public void propertyChange(PropertyChangeEvent pve)
    { 

//#if -1887238608 
modelChanged(pve);
//#endif 

} 

//#endif 


//#if -322701858 
public void setItemUID(ItemUID newId)
    { 

//#if -1827388763 
itemUid = newId;
//#endif 

} 

//#endif 


//#if -2021635032 
public void setSettings(DiagramSettings theSettings)
    { 

//#if 1244556514 
settings = theSettings;
//#endif 

} 

//#endif 


//#if -264052656 
public DiagramSettings getSettings()
    { 

//#if 2029403408 
return settings;
//#endif 

} 

//#endif 


//#if -709745871 
private void addElementListener(Object element)
    { 

//#if 634077777 
Model.getPump().addModelEventListener(this, element);
//#endif 

} 

//#endif 


//#if -1803323826 
@Override
    public final void removeFromDiagram()
    { 

//#if -185175020 
Object o = getOwner();
//#endif 


//#if -1385119445 
if(o != null)//1
{ 

//#if -146541400 
removeElementListener(o);
//#endif 

} 

//#endif 


//#if 2052021348 
super.removeFromDiagram();
//#endif 


//#if 1099201743 
damage();
//#endif 

} 

//#endif 


//#if -1520065692 

//#if -491671484 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public Project getProject()
    { 

//#if 1649855676 
return ArgoFigUtil.getProject(this);
//#endif 

} 

//#endif 


//#if 1611227845 

//#if 114467996 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public void setProject(Project project)
    { 
} 

//#endif 


//#if 1227531321 
public ItemUID getItemUID()
    { 

//#if -806366185 
return itemUid;
//#endif 

} 

//#endif 


//#if -803334995 
@Override
    public String getTipString(MouseEvent me)
    { 

//#if -545889076 
return "Comment Edge";
//#endif 

} 

//#endif 


//#if 1915243515 
protected void modelChanged(PropertyChangeEvent e)
    { 

//#if -2102312011 
if(e instanceof RemoveAssociationEvent
                && e.getOldValue() == annotatedElement)//1
{ 

//#if 1836504908 
removeFromDiagram();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2078793019 
public FigEdgeNote(Object element, DiagramSettings theSettings)
    { 

//#if 1930636454 
super();
//#endif 


//#if 1053804858 
settings = theSettings;
//#endif 


//#if -1600223069 
if(element != null)//1
{ 

//#if 393142299 
setOwner(element);
//#endif 

} 
else
{ 

//#if -1476882669 
setOwner(new CommentEdge());
//#endif 

} 

//#endif 


//#if -907984588 
setBetweenNearestPoints(true);
//#endif 


//#if -2067915955 
getFig().setLineWidth(LINE_WIDTH);
//#endif 


//#if 1118596429 
getFig().setDashed(true);
//#endif 

} 

//#endif 


//#if -1148264165 
@Override
    public void setDestFigNode(FigNode fn)
    { 

//#if 803240094 
if(fn != null && Model.getFacade().isAComment(fn.getOwner()))//1
{ 

//#if 586954904 
Object oldComment = comment;
//#endif 


//#if -455799484 
if(oldComment != null)//1
{ 

//#if -1696819189 
removeElementListener(oldComment);
//#endif 

} 

//#endif 


//#if 1516164479 
comment = fn.getOwner();
//#endif 


//#if 589284809 
if(comment != null)//1
{ 

//#if 196318593 
addElementListener(comment);
//#endif 

} 

//#endif 


//#if -867106272 
((CommentEdge) getOwner()).setComment(comment);
//#endif 

} 
else

//#if -1518572088 
if(fn != null
                   && !Model.getFacade().isAComment(fn.getOwner()))//1
{ 

//#if 734970226 
annotatedElement = fn.getOwner();
//#endif 


//#if 1469373094 
((CommentEdge) getOwner()).setAnnotatedElement(annotatedElement);
//#endif 

} 

//#endif 


//#endif 


//#if 1864207044 
super.setDestFigNode(fn);
//#endif 

} 

//#endif 


//#if 1987694921 
public void renderingChanged()
    { 
} 

//#endif 


//#if 369835708 
private void removeElementListener(Object element)
    { 

//#if 266306492 
Model.getPump().removeModelEventListener(this, element);
//#endif 

} 

//#endif 


//#if 2010170823 
@Override
    public void setFig(Fig f)
    { 

//#if -1509331109 
LOG.info("Setting the internal fig to " + f);
//#endif 


//#if -940088992 
super.setFig(f);
//#endif 


//#if 526037145 
getFig().setDashed(true);
//#endif 

} 

//#endif 


//#if 5760656 
@Override
    public String toString()
    { 

//#if 805690863 
return Translator.localize("misc.comment-edge");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

