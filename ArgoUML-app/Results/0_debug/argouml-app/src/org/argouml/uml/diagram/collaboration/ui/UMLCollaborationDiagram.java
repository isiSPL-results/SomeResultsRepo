
//#if 1924086057 
// Compilation Unit of /UMLCollaborationDiagram.java 
 

//#if -596537996 
package org.argouml.uml.diagram.collaboration.ui;
//#endif 


//#if -721228876 
import java.awt.Point;
//#endif 


//#if 1276502837 
import java.awt.Rectangle;
//#endif 


//#if 1065600367 
import java.beans.PropertyVetoException;
//#endif 


//#if -916941686 
import java.util.Collection;
//#endif 


//#if -1974110662 
import java.util.HashSet;
//#endif 


//#if 932797434 
import java.util.Iterator;
//#endif 


//#if -857354102 
import javax.swing.Action;
//#endif 


//#if 2145915828 
import org.apache.log4j.Logger;
//#endif 


//#if -1190962207 
import org.argouml.i18n.Translator;
//#endif 


//#if -301514969 
import org.argouml.model.Model;
//#endif 


//#if 1238811402 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1824603432 
import org.argouml.uml.diagram.collaboration.CollabDiagramGraphModel;
//#endif 


//#if -1933035699 
import org.argouml.uml.diagram.static_structure.ui.FigComment;
//#endif 


//#if -567083334 
import org.argouml.uml.diagram.ui.ActionAddAssociationRole;
//#endif 


//#if 147401546 
import org.argouml.uml.diagram.ui.ActionAddMessage;
//#endif 


//#if -1162487455 
import org.argouml.uml.diagram.ui.ActionSetMode;
//#endif 


//#if 282354691 
import org.argouml.uml.diagram.ui.FigMessage;
//#endif 


//#if -1189507361 
import org.argouml.uml.diagram.ui.RadioAction;
//#endif 


//#if 2085646727 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if -745223890 
import org.argouml.util.ToolBarUtility;
//#endif 


//#if 723857246 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1179783141 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1468371994 
import org.tigris.gef.base.Layer;
//#endif 


//#if 1931279456 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if -125447632 
import org.tigris.gef.base.LayerPerspectiveMutable;
//#endif 


//#if 1224506083 
import org.tigris.gef.base.ModeCreatePolyEdge;
//#endif 


//#if 1434083155 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 496198174 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -2080843076 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -53191583 
public class UMLCollaborationDiagram extends 
//#if 1618043025 
UMLDiagram
//#endif 

  { 

//#if 771550974 
private static final Logger LOG =
        Logger.getLogger(UMLCollaborationDiagram.class);
//#endif 


//#if -1005552409 
private Action actionClassifierRole;
//#endif 


//#if -662557742 
private Action actionGeneralize;
//#endif 


//#if 1023745719 
private Action actionAssociation;
//#endif 


//#if -241262474 
private Action actionAggregation;
//#endif 


//#if -795568466 
private Action actionComposition;
//#endif 


//#if -686706451 
private Action actionUniAssociation;
//#endif 


//#if -1951714644 
private Action actionUniAggregation;
//#endif 


//#if 1788946660 
private Action actionUniComposition;
//#endif 


//#if -1671039406 
private Action actionDepend;
//#endif 


//#if -1658756495 
private Action actionMessage;
//#endif 


//#if 776845904 
private static final long serialVersionUID = 8081715986963837750L;
//#endif 


//#if -1771142719 
private Object[] getAssociationActions()
    { 

//#if -1976156213 
Object[][] actions = {
            {getActionAssociation(), getActionUniAssociation() },
            {getActionAggregation(), getActionUniAggregation() },
            {getActionComposition(), getActionUniComposition() },
        };
//#endif 


//#if 649001860 
ToolBarUtility.manageDefault(actions,
                                     "diagram.collaboration.association");
//#endif 


//#if 1915694961 
return actions;
//#endif 

} 

//#endif 


//#if 1004139345 
public int getNumMessages()
    { 

//#if -561470304 
Layer lay = getLayer();
//#endif 


//#if 1198900377 
Collection figs = lay.getContents();
//#endif 


//#if 832036652 
int res = 0;
//#endif 


//#if -923988058 
Iterator it = figs.iterator();
//#endif 


//#if -1010703211 
while (it.hasNext()) //1
{ 

//#if -2072139965 
Fig f = (Fig) it.next();
//#endif 


//#if 1584782995 
if(Model.getFacade().isAMessage(f.getOwner()))//1
{ 

//#if -2064676510 
res++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 373635926 
return res;
//#endif 

} 

//#endif 


//#if -1561124590 
@Override
    public Object getDependentElement()
    { 

//#if 810906450 
return getNamespace();
//#endif 

} 

//#endif 


//#if 388657054 
private Action getActionAggregation()
    { 

//#if 620363087 
if(actionAggregation == null)//1
{ 

//#if -790060319 
actionAggregation =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getAggregate(),
                    false,
                    "button.new-aggregation"));
//#endif 

} 

//#endif 


//#if 1214964542 
return actionAggregation;
//#endif 

} 

//#endif 


//#if 1390002733 
protected Action getActionUniAggregation()
    { 

//#if -667244156 
if(actionUniAggregation == null)//1
{ 

//#if 580522335 
actionUniAggregation =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getAggregate(),
                    true,
                    "button.new-uniaggregation"));
//#endif 

} 

//#endif 


//#if 287848229 
return actionUniAggregation;
//#endif 

} 

//#endif 


//#if -1351398206 
public void setNamespace(Object handle)
    { 

//#if -744317359 
if(!Model.getFacade().isANamespace(handle))//1
{ 

//#if 1642875241 
LOG.error(
                "Illegal argument. Object " + handle + " is not a namespace");
//#endif 


//#if 1686926597 
throw new IllegalArgumentException(
                "Illegal argument. Object " + handle + " is not a namespace");
//#endif 

} 

//#endif 


//#if 1613001730 
super.setNamespace(handle);
//#endif 


//#if 1729732313 
CollabDiagramGraphModel gm = createGraphModel();
//#endif 


//#if 1483694763 
gm.setCollaboration(handle);
//#endif 


//#if -35655423 
LayerPerspective lay =
            new LayerPerspectiveMutable(Model.getFacade().getName(handle), gm);
//#endif 


//#if -1391515054 
CollabDiagramRenderer rend = new CollabDiagramRenderer();
//#endif 


//#if -1056999820 
lay.setGraphNodeRenderer(rend);
//#endif 


//#if 96135513 
lay.setGraphEdgeRenderer(rend);
//#endif 


//#if -1433544111 
setLayer(lay);
//#endif 

} 

//#endif 


//#if 2045836134 
@Override
    public boolean doesAccept(Object objectToAccept)
    { 

//#if 158473513 
if(Model.getFacade().isAClassifierRole(objectToAccept))//1
{ 

//#if 1705984491 
return true;
//#endif 

} 
else

//#if 707802729 
if(Model.getFacade().isAMessage(objectToAccept))//1
{ 

//#if 37137152 
return true;
//#endif 

} 
else

//#if 241044922 
if(Model.getFacade().isAComment(objectToAccept))//1
{ 

//#if 1126869566 
return true;
//#endif 

} 
else

//#if -42402038 
if(Model.getFacade().isAClassifier(objectToAccept))//1
{ 

//#if -1093255575 
return true;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if -1221576471 
return false;
//#endif 

} 

//#endif 


//#if 388520618 
@Override
    public String getInstructions(Object droppedObject)
    { 

//#if -830535608 
if(Model.getFacade().isAClassifierRole(droppedObject))//1
{ 

//#if 248426734 
return super.getInstructions(droppedObject);
//#endif 

} 
else

//#if -101910208 
if(Model.getFacade().isAClassifier(droppedObject))//1
{ 

//#if -901052730 
return Translator.localize(
                       "misc.message.click-on-diagram-to-add-as-cr",
                       new Object[] {Model.getFacade().toString(droppedObject)});
//#endif 

} 

//#endif 


//#endif 


//#if -562515952 
return super.getInstructions(droppedObject);
//#endif 

} 

//#endif 


//#if 747407368 
private CollabDiagramGraphModel createGraphModel()
    { 

//#if -2107461315 
if((getGraphModel() instanceof CollabDiagramGraphModel))//1
{ 

//#if -1000936794 
return (CollabDiagramGraphModel) getGraphModel();
//#endif 

} 
else
{ 

//#if 433652535 
return new CollabDiagramGraphModel();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1631373251 
protected Object[] getUmlActions()
    { 

//#if 1913329384 
Object[] actions = {
            getActionClassifierRole(),
            null,
            getAssociationActions(),
            getActionGeneralize(),
            getActionDepend(),
            null,
            getActionMessage(), //this one behaves differently, hence seperated!
        };
//#endif 


//#if 1963425832 
return actions;
//#endif 

} 

//#endif 


//#if -1369751481 
protected Action getActionDepend()
    { 

//#if 279014517 
if(actionDepend == null)//1
{ 

//#if -978382984 
actionDepend =
                new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getDependency(),
                    "button.new-dependency"));
//#endif 

} 

//#endif 


//#if 285882082 
return actionDepend;
//#endif 

} 

//#endif 


//#if 626404674 
private Object makeNewCR(Object base)
    { 

//#if -972106096 
Object node = null;
//#endif 


//#if 1218183169 
Editor ce = Globals.curEditor();
//#endif 


//#if -1819781583 
GraphModel gm = ce.getGraphModel();
//#endif 


//#if 397470500 
if(gm instanceof CollabDiagramGraphModel)//1
{ 

//#if 2045111294 
Object collaboration =
                ((CollabDiagramGraphModel) gm).getHomeModel();
//#endif 


//#if -124590833 
node =
                Model.getCollaborationsFactory().buildClassifierRole(
                    collaboration);
//#endif 

} 

//#endif 


//#if 1899079455 
Model.getCollaborationsHelper().addBase(node, base);
//#endif 


//#if -262769583 
return node;
//#endif 

} 

//#endif 


//#if -377960202 
public void postLoad()
    { 

//#if 136581063 
super.postLoad();
//#endif 


//#if -832357882 
if(getNamespace() == null)//1
{ 

//#if 988403983 
throw new IllegalStateException(
                "The namespace of the collaboration diagram is not set");
//#endif 

} 

//#endif 


//#if -524037193 
Collection messages;
//#endif 


//#if 541224724 
Iterator msgIterator;
//#endif 


//#if 620483679 
Collection ownedElements =
            Model.getFacade().getOwnedElements(getNamespace());
//#endif 


//#if -23475767 
Iterator oeIterator = ownedElements.iterator();
//#endif 


//#if -1110088625 
Layer lay = getLayer();
//#endif 


//#if -34180355 
while (oeIterator.hasNext()) //1
{ 

//#if 1808777670 
Object me = oeIterator.next();
//#endif 


//#if -722470207 
if(Model.getFacade().isAAssociationRole(me))//1
{ 

//#if 1497769985 
messages = Model.getFacade().getMessages(me);
//#endif 


//#if 654278010 
msgIterator = messages.iterator();
//#endif 


//#if 716525054 
while (msgIterator.hasNext()) //1
{ 

//#if -29989360 
Object message = msgIterator.next();
//#endif 


//#if 1605306660 
FigMessage figMessage =
                        (FigMessage) lay.presentationFor(message);
//#endif 


//#if 589895894 
if(figMessage != null)//1
{ 

//#if 1977082912 
figMessage.addPathItemToFigAssociationRole(lay);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -667129597 
private Action getActionMessage()
    { 

//#if 976361563 
if(actionMessage == null)//1
{ 

//#if -1963218234 
actionMessage = ActionAddMessage.getTargetFollower();
//#endif 

} 

//#endif 


//#if -1845784672 
return actionMessage;
//#endif 

} 

//#endif 


//#if 2141082769 
protected Action getActionComposition()
    { 

//#if 727860535 
if(actionComposition == null)//1
{ 

//#if -434750230 
actionComposition =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getComposite(),
                    false,
                    "button.new-composition"));
//#endif 

} 

//#endif 


//#if -484478826 
return actionComposition;
//#endif 

} 

//#endif 


//#if 968897607 
protected Action getActionGeneralize()
    { 

//#if 1263345448 
if(actionGeneralize == null)//1
{ 

//#if 1725656574 
actionGeneralize =
                new RadioAction(
                new ActionSetMode(
                    ModeCreatePolyEdge.class,
                    "edgeClass",
                    Model.getMetaTypes().getGeneralization(),
                    "button.new-generalization"));
//#endif 

} 

//#endif 


//#if 2035950933 
return actionGeneralize;
//#endif 

} 

//#endif 


//#if 1950551052 
protected Action getActionUniAssociation()
    { 

//#if -1075150440 
if(actionUniAssociation  == null)//1
{ 

//#if -23593579 
actionUniAssociation =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getNone(),
                    true,
                    "button.new-uniassociation"));
//#endif 

} 

//#endif 


//#if -294068645 
return actionUniAssociation;
//#endif 

} 

//#endif 


//#if 1386386165 
protected Action getActionUniComposition()
    { 

//#if -774807962 
if(actionUniComposition == null)//1
{ 

//#if -1144716740 
actionUniComposition =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getComposite(),
                    true,
                    "button.new-unicomposition"));
//#endif 

} 

//#endif 


//#if -1984498441 
return actionUniComposition;
//#endif 

} 

//#endif 


//#if 55753115 
public void encloserChanged(FigNode enclosed,
                                FigNode oldEncloser, FigNode newEncloser)
    { 
} 

//#endif 


//#if 665428601 
@Deprecated
    public UMLCollaborationDiagram()
    { 

//#if -1985345785 
try //1
{ 

//#if -935044776 
setName(getNewDiagramName());
//#endif 

} 

//#if 1927953974 
catch (PropertyVetoException pve) //1
{ 
} 

//#endif 


//#endif 


//#if -1193242714 
setGraphModel(createGraphModel());
//#endif 

} 

//#endif 


//#if 706046230 
public String getLabelName()
    { 

//#if 1216368355 
return Translator.localize("label.collaboration-diagram");
//#endif 

} 

//#endif 


//#if -1737216899 
private FigClassifierRole makeNewFigCR(Object classifierRole,
                                           Point location)
    { 

//#if -193133083 
if(classifierRole != null)//1
{ 

//#if 1297438681 
FigClassifierRole newCR = new FigClassifierRole(classifierRole,
                    new Rectangle(location), getDiagramSettings());
//#endif 


//#if -999512186 
getGraphModel().getNodes().add(newCR.getOwner());
//#endif 


//#if 256805506 
return newCR;
//#endif 

} 

//#endif 


//#if -1045408932 
return null;
//#endif 

} 

//#endif 


//#if -725763258 
@Override
    public FigNode drop(Object droppedObject, Point location)
    { 

//#if 58472237 
FigNode figNode = null;
//#endif 


//#if 1225563983 
GraphModel gm = getGraphModel();
//#endif 


//#if -897941384 
Layer lay = Globals.curEditor().getLayerManager().getActiveLayer();
//#endif 


//#if 51248549 
Rectangle bounds = null;
//#endif 


//#if -168789611 
if(location != null)//1
{ 

//#if 1629175302 
bounds = new Rectangle(location.x, location.y, 0, 0);
//#endif 

} 

//#endif 


//#if 441874208 
DiagramSettings settings = getDiagramSettings();
//#endif 


//#if -2080776253 
if(Model.getFacade().isAClassifierRole(droppedObject))//1
{ 

//#if -518771002 
figNode = new FigClassifierRole(droppedObject, bounds, settings);
//#endif 

} 
else

//#if -862909510 
if(Model.getFacade().isAMessage(droppedObject))//1
{ 

//#if -444854168 
figNode = new FigMessage(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1792952126 
if(Model.getFacade().isAComment(droppedObject))//1
{ 

//#if 633133003 
figNode = new FigComment(droppedObject, bounds, settings);
//#endif 

} 
else

//#if 1522900411 
if(Model.getFacade().isAClassifierRole(droppedObject))//1
{ 

//#if -978015081 
figNode = makeNewFigCR(droppedObject, location);
//#endif 

} 
else

//#if -1386960016 
if(Model.getFacade().isAClassifier(droppedObject))//1
{ 

//#if -122289160 
figNode = makeNewFigCR(makeNewCR(droppedObject), location);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -938207876 
if(figNode != null)//1
{ 

//#if -964237215 
LOG.debug("Dropped object " + droppedObject + " converted to "
                      + figNode);
//#endif 

} 
else
{ 

//#if -1851465752 
LOG.debug("Dropped object NOT added " + droppedObject);
//#endif 

} 

//#endif 


//#if -279298341 
return figNode;
//#endif 

} 

//#endif 


//#if -1589719640 
protected Action getActionAssociation()
    { 

//#if -181857195 
if(actionAssociation == null)//1
{ 

//#if 1297902368 
actionAssociation =
                new RadioAction(
                new ActionAddAssociationRole(
                    Model.getAggregationKind().getNone(),
                    false,
                    "button.new-associationrole",
                    "Association"));
//#endif 

} 

//#endif 


//#if 847865574 
return actionAssociation;
//#endif 

} 

//#endif 


//#if 307874810 
public boolean isRelocationAllowed(Object base)
    { 

//#if -945954558 
return false;
//#endif 

} 

//#endif 


//#if 1410439189 

//#if -1112991991 
@SuppressWarnings("unchecked")
//#endif 


    public Collection getRelocationCandidates(Object root)
    { 

//#if 1793373739 
Collection c =  new HashSet();
//#endif 


//#if 1445680101 
c.add(getOwner());
//#endif 


//#if -723517109 
return c;
//#endif 

} 

//#endif 


//#if -1800853677 
@Deprecated
    public UMLCollaborationDiagram(Object collaboration)
    { 

//#if -295062383 
this();
//#endif 


//#if -1197069133 
setNamespace(collaboration);
//#endif 

} 

//#endif 


//#if -897726627 
private Action getActionClassifierRole()
    { 

//#if 1496978641 
if(actionClassifierRole == null)//1
{ 

//#if 6117033 
actionClassifierRole =
                new RadioAction(new ActionAddClassifierRole());
//#endif 

} 

//#endif 


//#if 1491427976 
return actionClassifierRole;
//#endif 

} 

//#endif 


//#if 1370226403 
public boolean relocate(Object base)
    { 

//#if 883709248 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

