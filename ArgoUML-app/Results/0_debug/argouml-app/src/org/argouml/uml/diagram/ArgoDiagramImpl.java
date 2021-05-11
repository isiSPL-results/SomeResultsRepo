
//#if -1868163371 
// Compilation Unit of /ArgoDiagramImpl.java 
 

//#if -738231664 
package org.argouml.uml.diagram;
//#endif 


//#if -735830909 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -874816731 
import java.beans.PropertyChangeListener;
//#endif 


//#if -971892184 
import java.beans.PropertyVetoException;
//#endif 


//#if 1729724246 
import java.beans.VetoableChangeListener;
//#endif 


//#if 908753502 
import java.util.ArrayList;
//#endif 


//#if 1397979251 
import java.util.Iterator;
//#endif 


//#if -1380239037 
import java.util.List;
//#endif 


//#if 1050270427 
import org.apache.log4j.Logger;
//#endif 


//#if -1390253569 
import org.argouml.application.events.ArgoDiagramAppearanceEvent;
//#endif 


//#if -939738030 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 1051183427 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 287402748 
import org.argouml.application.events.ArgoNotationEvent;
//#endif 


//#if 1042802172 
import org.argouml.kernel.Project;
//#endif 


//#if -1592616595 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1230332690 
import org.argouml.model.CoreHelper;
//#endif 


//#if 1503765373 
import org.argouml.model.DeleteInstanceEvent;
//#endif 


//#if 1300795853 
import org.argouml.model.InvalidElementException;
//#endif 


//#if -1397160370 
import org.argouml.model.Model;
//#endif 


//#if 537822333 
import org.argouml.model.ModelManagementHelper;
//#endif 


//#if 1695594754 
import org.argouml.uml.diagram.activity.ui.FigPool;
//#endif 


//#if 2029472582 
import org.argouml.uml.diagram.static_structure.ui.FigComment;
//#endif 


//#if 1389946046 
import org.argouml.uml.diagram.ui.ArgoFig;
//#endif 


//#if -1030014155 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if 1011241744 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if -709662373 
import org.argouml.util.EnumerationIterator;
//#endif 


//#if 927684594 
import org.argouml.util.IItemUID;
//#endif 


//#if 639122803 
import org.argouml.util.ItemUID;
//#endif 


//#if -1067597697 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 2103165655 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1399829351 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -1679683718 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 1027134234 
import org.tigris.gef.graph.MutableGraphSupport;
//#endif 


//#if 1677398597 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -257272056 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 684943858 
import org.tigris.gef.presentation.FigGroup;
//#endif 


//#if -248635549 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -855488714 
import org.tigris.gef.undo.UndoManager;
//#endif 


//#if 2057383010 
public abstract class ArgoDiagramImpl extends 
//#if 2031305490 
Diagram
//#endif 

 implements 
//#if -1804835430 
PropertyChangeListener
//#endif 

, 
//#if -1582270647 
VetoableChangeListener
//#endif 

, 
//#if -2062427015 
ArgoDiagram
//#endif 

, 
//#if 876676405 
IItemUID
//#endif 

  { 

//#if -1447687515 
private ItemUID id;
//#endif 


//#if 309563929 
private Project project;
//#endif 


//#if -143340756 
protected Object namespace;
//#endif 


//#if -572935900 
private DiagramSettings settings;
//#endif 


//#if -1120996955 
private static final Logger LOG = Logger.getLogger(ArgoDiagramImpl.class);
//#endif 


//#if 493378670 
static final long serialVersionUID = -401219134410459387L;
//#endif 


//#if -698582178 
public void vetoableChange(PropertyChangeEvent evt)
    throws PropertyVetoException
    { 

//#if -760168165 
if("name".equals(evt.getPropertyName()))//1
{ 

//#if -533384544 
if(project != null)//1
{ 

//#if -1187030414 
if(!project.isValidDiagramName((String) evt.getNewValue()))//1
{ 

//#if -454109931 
throw new PropertyVetoException("Invalid name", evt);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1619554253 
public Project getProject()
    { 

//#if -2082678271 
return project;
//#endif 

} 

//#endif 


//#if -1022648535 
public String repair()
    { 

//#if -371758980 
StringBuffer report = new StringBuffer(500);
//#endif 


//#if 996724101 
boolean faultFixed;
//#endif 


//#if -2131842158 
do{ 

//#if -1939939288 
faultFixed = false;
//#endif 


//#if -796091408 
List<Fig> figs = new ArrayList<Fig>(getLayer().getContentsNoEdges());
//#endif 


//#if -1290717899 
for (Fig f : figs) //1
{ 

//#if 578287041 
if(repairFig(f, report))//1
{ 

//#if -572784408 
faultFixed = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1502967429 
figs = new ArrayList<Fig>(getLayer().getContentsEdgesOnly());
//#endif 


//#if 1065348444 
for (Fig f : figs) //2
{ 

//#if 1812613732 
if(repairFig(f, report))//1
{ 

//#if 2081147491 
faultFixed = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 
 while (faultFixed);//1

//#endif 


//#if 1869618312 
return report.toString();
//#endif 

} 

//#endif 


//#if 616027195 
public void notationRemoved(ArgoNotationEvent e)
    { 
} 

//#endif 


//#if 1857368408 
public void diagramFontChanged(ArgoDiagramAppearanceEvent e)
    { 

//#if 512235208 
renderingChanged();
//#endif 

} 

//#endif 


//#if -1217795937 
public void setProject(Project p)
    { 

//#if 1472263994 
project = p;
//#endif 

} 

//#endif 


//#if -1893995857 
public Object getNamespace()
    { 

//#if 1922279593 
return namespace;
//#endif 

} 

//#endif 


//#if -1291642836 
public abstract void encloserChanged(
        FigNode enclosed, FigNode oldEncloser, FigNode newEncloser);
//#endif 


//#if 1357925063 
public void renderingChanged()
    { 

//#if 1682106691 
for (Object fig : getLayer().getContents()) //1
{ 

//#if 1164277689 
try //1
{ 

//#if 1281289011 
if(fig instanceof ArgoFig)//1
{ 

//#if 1131134364 
((ArgoFig) fig).renderingChanged();
//#endif 

} 
else
{ 

//#if -1636452031 
LOG.warn("Diagram " + getName() + " contains non-ArgoFig "
                             + fig);
//#endif 

} 

//#endif 

} 

//#if 1935963091 
catch (InvalidElementException e) //1
{ 

//#if -1821869985 
LOG.error("Tried to refresh deleted element ", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 88308387 
damage();
//#endif 

} 

//#endif 


//#if -166603557 
public void notationAdded(ArgoNotationEvent e)
    { 
} 

//#endif 


//#if 1967967099 
public ItemUID getItemUID()
    { 

//#if 2096166707 
return id;
//#endif 

} 

//#endif 


//#if -1278013216 
@Deprecated
    public ArgoDiagramImpl()
    { 

//#if 381372964 
super();
//#endif 


//#if -549111511 
getLayer().getGraphModel().removeGraphEventListener(getLayer());
//#endif 


//#if -2059831083 
constructorInit();
//#endif 

} 

//#endif 


//#if 654045162 
public void notationProviderAdded(ArgoNotationEvent e)
    { 
} 

//#endif 


//#if -139253573 
public Iterator<Fig> getFigIterator()
    { 

//#if 830521076 
return new EnumerationIterator(elements());
//#endif 

} 

//#endif 


//#if 869749323 
public Object getDependentElement()
    { 

//#if 1296223459 
return null;
//#endif 

} 

//#endif 


//#if 506369706 
private String figDescription(Fig f)
    { 

//#if 1961851808 
String description = "\n" + f.getClass().getName();
//#endif 


//#if -603018887 
if(f instanceof FigComment)//1
{ 

//#if -1334962743 
description += " \"" + ((FigComment) f).getBody() + "\"";
//#endif 

} 
else

//#if -430063378 
if(f instanceof FigNodeModelElement)//1
{ 

//#if 1208693005 
description += " \"" + ((FigNodeModelElement) f).getName() + "\"";
//#endif 

} 
else

//#if -1747730838 
if(f instanceof FigEdgeModelElement)//1
{ 

//#if -1082894437 
FigEdgeModelElement fe = (FigEdgeModelElement) f;
//#endif 


//#if -1397032743 
description += " \"" + fe.getName() + "\"";
//#endif 


//#if -42228798 
String source;
//#endif 


//#if -111317418 
if(fe.getSourceFigNode() == null)//1
{ 

//#if -1984805373 
source = "(null)";
//#endif 

} 
else
{ 

//#if 225808305 
source =
                    ((FigNodeModelElement) fe.getSourceFigNode()).getName();
//#endif 

} 

//#endif 


//#if 754517659 
String dest;
//#endif 


//#if 1469087535 
if(fe.getDestFigNode() == null)//1
{ 

//#if -1091481137 
dest = "(null)";
//#endif 

} 
else
{ 

//#if 1621961663 
dest = ((FigNodeModelElement) fe.getDestFigNode()).getName();
//#endif 

} 

//#endif 


//#if -1050417314 
description += " [" + source + "=>" + dest + "]";
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -1930787233 
return description + "\n";
//#endif 

} 

//#endif 


//#if -1014536310 
public void notationProviderRemoved(ArgoNotationEvent e)
    { 
} 

//#endif 


//#if 1196862607 
public void notationChanged(ArgoNotationEvent e)
    { 

//#if -1513297229 
renderingChanged();
//#endif 

} 

//#endif 


//#if -546106527 
public ArgoDiagramImpl(String name, GraphModel graphModel,
                           LayerPerspective layer)
    { 

//#if 1996282151 
super(name, graphModel, layer);
//#endif 


//#if -700054315 
try //1
{ 

//#if 1076069278 
setName(name);
//#endif 

} 

//#if 1512290806 
catch (PropertyVetoException pve) //1
{ 
} 

//#endif 


//#endif 


//#if -419789169 
constructorInit();
//#endif 

} 

//#endif 


//#if 1756066310 
public void setDiagramSettings(DiagramSettings newSettings)
    { 

//#if 1449083009 
settings = newSettings;
//#endif 

} 

//#endif 


//#if 600305204 
public void setNamespace(Object ns)
    { 

//#if 1450290369 
if(!Model.getFacade().isANamespace(ns))//1
{ 

//#if 488984817 
LOG.error("Not a namespace");
//#endif 


//#if -18633585 
LOG.error(ns);
//#endif 


//#if 1602124581 
throw new IllegalArgumentException("Given object not a namespace");
//#endif 

} 

//#endif 


//#if 143070068 
if((namespace != null) && (namespace != ns))//1
{ 

//#if -391961877 
Model.getPump().removeModelEventListener(this, namespace);
//#endif 

} 

//#endif 


//#if 910952209 
Object oldNs = namespace;
//#endif 


//#if 1346821939 
namespace = ns;
//#endif 


//#if 258887252 
firePropertyChange(NAMESPACE_KEY, oldNs, ns);
//#endif 


//#if -988023434 
Model.getPump().addModelEventListener(this, namespace, "remove");
//#endif 

} 

//#endif 


//#if -982465599 
public List presentationsFor(Object obj)
    { 

//#if 1425422003 
List<Fig> presentations = new ArrayList<Fig>();
//#endif 


//#if 1346765809 
int figCount = getLayer().getContents().size();
//#endif 


//#if -708505914 
for (int figIndex = 0; figIndex < figCount; ++figIndex) //1
{ 

//#if 504355694 
Fig fig = (Fig) getLayer().getContents().get(figIndex);
//#endif 


//#if -2114180945 
if(fig.getOwner() == obj)//1
{ 

//#if -1438014772 
presentations.add(fig);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 898154230 
return presentations;
//#endif 

} 

//#endif 


//#if -2098684914 
public void setItemUID(ItemUID i)
    { 

//#if -444801812 
id = i;
//#endif 

} 

//#endif 


//#if -1614929723 
@Deprecated
    public ArgoDiagramImpl(String diagramName)
    { 

//#if -980693895 
super(diagramName);
//#endif 


//#if -546327744 
try //1
{ 

//#if 663532196 
setName(diagramName);
//#endif 

} 

//#if 197766413 
catch (PropertyVetoException pve) //1
{ 
} 

//#endif 


//#endif 


//#if 970124410 
constructorInit();
//#endif 

} 

//#endif 


//#if 760695570 
public String getVetoMessage(String propertyName)
    { 

//#if 1964005336 
if(propertyName.equals("name"))//1
{ 

//#if 127284497 
return "Name of diagram may not exist already";
//#endif 

} 

//#endif 


//#if 875424706 
return null;
//#endif 

} 

//#endif 


//#if 27267317 
private void constructorInit()
    { 

//#if -166995867 
Project project = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1827849457 
if(project != null)//1
{ 

//#if 1663529075 
settings = project.getProjectSettings().getDefaultDiagramSettings();
//#endif 

} 

//#endif 


//#if -655976830 
if(!(UndoManager.getInstance() instanceof DiagramUndoManager))//1
{ 

//#if -929745978 
UndoManager.setInstance(new DiagramUndoManager());
//#endif 


//#if -1212037747 
LOG.info("Setting Diagram undo manager");
//#endif 

} 
else
{ 

//#if 1160995258 
LOG.info("Diagram undo manager already set");
//#endif 

} 

//#endif 


//#if 522673062 
ArgoEventPump.addListener(ArgoEventTypes.ANY_NOTATION_EVENT, this);
//#endif 


//#if 2090269240 
ArgoEventPump.addListener(
            ArgoEventTypes.ANY_DIAGRAM_APPEARANCE_EVENT, this);
//#endif 


//#if -1115809401 
addVetoableChangeListener(this);
//#endif 

} 

//#endif 


//#if 426871688 
public String toString()
    { 

//#if 1474857050 
return "Diagram: " + getName();
//#endif 

} 

//#endif 


//#if 2003302783 
public Fig getContainingFig(Object obj)
    { 

//#if -1566819349 
Fig fig = super.presentationFor(obj);
//#endif 


//#if 1931524112 
if(fig == null && Model.getFacade().isAUMLElement(obj))//1
{ 

//#if -23033578 
if(Model.getFacade().isAOperation(obj)
                    || Model.getFacade().isAReception(obj)
                    || Model.getFacade().isAAttribute(obj))//1
{ 

//#if -1531086182 
return presentationFor(Model.getFacade().getOwner(obj));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2015503474 
return fig;
//#endif 

} 

//#endif 


//#if -1511182482 
public void damage()
    { 

//#if 630962090 
if(getLayer() != null && getLayer().getEditors() != null)//1
{ 

//#if -1503525980 
Iterator it = getLayer().getEditors().iterator();
//#endif 


//#if -1887913007 
while (it.hasNext()) //1
{ 

//#if -229360782 
((Editor) it.next()).damageAll();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1222710151 
public Object getOwner()
    { 

//#if 1181394448 
return getNamespace();
//#endif 

} 

//#endif 


//#if -1621377999 
private boolean repairFig(Fig f, StringBuffer report)
    { 

//#if -728219931 
LOG.info("Checking " + figDescription(f) + f.getOwner());
//#endif 


//#if -1886941605 
boolean faultFixed = false;
//#endif 


//#if -462055232 
String figDescription = null;
//#endif 


//#if 1371073824 
if(!getLayer().equals(f.getLayer()))//1
{ 

//#if -1458578218 
if(figDescription == null)//1
{ 

//#if 400689618 
figDescription = figDescription(f);
//#endif 


//#if 844049753 
report.append(figDescription);
//#endif 

} 

//#endif 


//#if -1440671582 
if(f.getLayer() == null)//1
{ 

//#if -271833442 
report.append("-- Fixed: layer was null\n");
//#endif 

} 
else
{ 

//#if -2144304357 
report.append("-- Fixed: refered to wrong layer\n");
//#endif 

} 

//#endif 


//#if 1144748318 
faultFixed = true;
//#endif 


//#if 1881215395 
f.setLayer(getLayer());
//#endif 

} 

//#endif 


//#if 1822269459 
if(!f.isVisible())//1
{ 

//#if -596781758 
if(figDescription == null)//1
{ 

//#if 2051997016 
figDescription = figDescription(f);
//#endif 


//#if -1527490669 
report.append(figDescription);
//#endif 

} 

//#endif 


//#if 1737439267 
report.append("-- Fixed: a Fig must be visible\n");
//#endif 


//#if 375688242 
faultFixed = true;
//#endif 


//#if 583660352 
f.setVisible(true);
//#endif 

} 

//#endif 


//#if 103155106 
if(f instanceof FigEdge)//1
{ 

//#if 1969473259 
FigEdge fe = (FigEdge) f;
//#endif 


//#if -163983935 
FigNode destFig = fe.getDestFigNode();
//#endif 


//#if -2094824653 
FigNode sourceFig = fe.getSourceFigNode();
//#endif 


//#if 1505627459 
if(destFig == null)//1
{ 

//#if -395007373 
if(figDescription == null)//1
{ 

//#if -1899560602 
figDescription = figDescription(f);
//#endif 


//#if 1974697541 
report.append(figDescription);
//#endif 

} 

//#endif 


//#if -13694047 
faultFixed = true;
//#endif 


//#if -899418795 
report.append("-- Removed: as it has no dest Fig\n");
//#endif 


//#if -871527364 
f.removeFromDiagram();
//#endif 

} 
else

//#if -1866277837 
if(sourceFig == null)//1
{ 

//#if -22767823 
if(figDescription == null)//1
{ 

//#if -1603090390 
figDescription = figDescription(f);
//#endif 


//#if 1197919745 
report.append(figDescription);
//#endif 

} 

//#endif 


//#if -101471837 
faultFixed = true;
//#endif 


//#if -558384496 
report.append("-- Removed: as it has no source Fig\n");
//#endif 


//#if 640688318 
f.removeFromDiagram();
//#endif 

} 
else

//#if 58830303 
if(sourceFig.getOwner() == null)//1
{ 

//#if -1937246729 
if(figDescription == null)//1
{ 

//#if -1878605282 
figDescription = figDescription(f);
//#endif 


//#if 1650604173 
report.append(figDescription);
//#endif 

} 

//#endif 


//#if 1639434909 
faultFixed = true;
//#endif 


//#if -529654678 
report.append("-- Removed: as its source Fig has no owner\n");
//#endif 


//#if 456269368 
f.removeFromDiagram();
//#endif 

} 
else

//#if 937028448 
if(destFig.getOwner() == null)//1
{ 

//#if 1997684657 
if(figDescription == null)//1
{ 

//#if -277004703 
figDescription = figDescription(f);
//#endif 


//#if 817355562 
report.append(figDescription);
//#endif 

} 

//#endif 


//#if -310750941 
faultFixed = true;
//#endif 


//#if 801451173 
report.append(
                    "-- Removed: as its destination Fig has no owner\n");
//#endif 


//#if -2131023810 
f.removeFromDiagram();
//#endif 

} 
else

//#if -1047656086 
if(Model.getUmlFactory().isRemoved(
                           sourceFig.getOwner()))//1
{ 

//#if 1690282706 
if(figDescription == null)//1
{ 

//#if 1068504173 
figDescription = figDescription(f);
//#endif 


//#if 937926814 
report.append(figDescription);
//#endif 

} 

//#endif 


//#if 216043682 
faultFixed = true;
//#endif 


//#if -982281880 
report.append("-- Removed: as its source Figs owner is no "
                              + "longer in the repository\n");
//#endif 


//#if -491942787 
f.removeFromDiagram();
//#endif 

} 
else

//#if -990401686 
if(Model.getUmlFactory().isRemoved(
                           destFig.getOwner()))//1
{ 

//#if -1145382716 
if(figDescription == null)//1
{ 

//#if 1071754854 
figDescription = figDescription(f);
//#endif 


//#if 1231024453 
report.append(figDescription);
//#endif 

} 

//#endif 


//#if 1792452080 
faultFixed = true;
//#endif 


//#if 1028815399 
report.append("-- Removed: as its destination Figs owner "
                              + "is no longer in the repository\n");
//#endif 


//#if 1898311499 
f.removeFromDiagram();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 
else

//#if -364232384 
if((f instanceof FigNode || f instanceof FigEdge)
                   && f.getOwner() == null



                   && !(f instanceof FigPool))//1
{ 

//#if 269050911 
if(figDescription == null)//1
{ 

//#if 566759846 
figDescription = figDescription(f);
//#endif 


//#if -1685694971 
report.append(figDescription);
//#endif 

} 

//#endif 


//#if -204626571 
faultFixed = true;
//#endif 


//#if -2136541040 
report.append("-- Removed: owner was null\n");
//#endif 


//#if -1170311408 
f.removeFromDiagram();
//#endif 

} 
else

//#if 304522914 
if((f instanceof FigNode || f instanceof FigEdge)
                   &&  Model.getFacade().isAUMLElement(f.getOwner())
                   &&  Model.getUmlFactory().isRemoved(f.getOwner()))//1
{ 

//#if -356293595 
if(figDescription == null)//1
{ 

//#if -1576391589 
figDescription = figDescription(f);
//#endif 


//#if -1900003472 
report.append(figDescription);
//#endif 

} 

//#endif 


//#if 1251175727 
faultFixed = true;
//#endif 


//#if -497353596 
report.append(
                "-- Removed: model element no longer in the repository\n");
//#endif 


//#if -1868952758 
f.removeFromDiagram();
//#endif 

} 
else

//#if -144415178 
if(f instanceof FigGroup && !(f instanceof FigNode))//1
{ 

//#if 659328144 
if(figDescription == null)//1
{ 

//#if -580211423 
figDescription = figDescription(f);
//#endif 


//#if 1235149930 
report.append(figDescription);
//#endif 

} 

//#endif 


//#if -741385820 
faultFixed = true;
//#endif 


//#if 1905870132 
report.append(
                "-- Removed: a FigGroup should not be on the diagram\n");
//#endif 


//#if 1835928575 
f.removeFromDiagram();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 1085879961 
return faultFixed;
//#endif 

} 

//#endif 


//#if 681749315 
public void remove()
    { 

//#if -1732867224 
List<Fig> contents = new ArrayList<Fig>(getLayer().getContents());
//#endif 


//#if 1906376693 
int size = contents.size();
//#endif 


//#if 507594454 
for (int i = 0; i < size; ++i) //1
{ 

//#if -1505804620 
Fig f = contents.get(i);
//#endif 


//#if -1614235111 
f.removeFromDiagram();
//#endif 

} 

//#endif 


//#if 1315369080 
firePropertyChange("remove", null, null);
//#endif 


//#if -2035478784 
super.remove();
//#endif 

} 

//#endif 


//#if 513893342 
public void setName(String n) throws PropertyVetoException
    { 

//#if 2051482933 
super.setName(n);
//#endif 


//#if -581498272 
MutableGraphSupport.enableSaveAction();
//#endif 

} 

//#endif 


//#if 1048486838 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if 1340951743 
if((evt.getSource() == namespace)
                && (evt instanceof DeleteInstanceEvent)
                && "remove".equals(evt.getPropertyName()))//1
{ 

//#if 1770647508 
Model.getPump().removeModelEventListener(this, namespace, "remove");
//#endif 


//#if 1769487400 
if(getProject() != null)//1
{ 

//#if 1277015021 
getProject().moveToTrash(this);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -86320860 
public List getNodes()
    { 

//#if 1056998759 
if(getGraphModel() != null)//1
{ 

//#if 1746837423 
return getGraphModel().getNodes();
//#endif 

} 

//#endif 


//#if -287896313 
return super.getNodes();
//#endif 

} 

//#endif 


//#if -2073121939 
public DiagramSettings getDiagramSettings()
    { 

//#if 1932644846 
return settings;
//#endif 

} 

//#endif 


//#if 540780207 
public void setModelElementNamespace(Object modelElement, Object ns)
    { 

//#if -1409268232 
if(modelElement == null)//1
{ 

//#if -1825080025 
return;
//#endif 

} 

//#endif 


//#if -1986114262 
if(ns == null)//1
{ 

//#if 559117429 
if(getNamespace() != null)//1
{ 

//#if -1574636251 
ns = getNamespace();
//#endif 

} 
else
{ 

//#if 1192029205 
ns = getProject().getRoot();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -860433081 
if(ns == null)//2
{ 

//#if 1951734259 
return;
//#endif 

} 

//#endif 


//#if 647806872 
if(Model.getFacade().getNamespace(modelElement) == ns)//1
{ 

//#if 1740947711 
return;
//#endif 

} 

//#endif 


//#if -1790435990 
CoreHelper coreHelper = Model.getCoreHelper();
//#endif 


//#if -955481850 
ModelManagementHelper modelHelper = Model.getModelManagementHelper();
//#endif 


//#if 106820926 
if(!modelHelper.isCyclicOwnership(ns, modelElement)
                && coreHelper.isValidNamespace(modelElement, ns))//1
{ 

//#if 696895783 
coreHelper.setModelElementContainer(modelElement, ns);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 203930505 
public List getEdges()
    { 

//#if 35589195 
if(getGraphModel() != null)//1
{ 

//#if 1071195394 
return getGraphModel().getEdges();
//#endif 

} 

//#endif 


//#if 1530933726 
return super.getEdges();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

