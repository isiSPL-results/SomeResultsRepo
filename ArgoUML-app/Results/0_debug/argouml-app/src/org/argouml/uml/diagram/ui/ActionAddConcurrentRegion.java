
//#if 757254347 
// Compilation Unit of /ActionAddConcurrentRegion.java 
 

//#if 1951455149 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1564515163 
import java.awt.Rectangle;
//#endif 


//#if 1379106948 
import java.awt.event.ActionEvent;
//#endif 


//#if -1508265542 
import java.util.List;
//#endif 


//#if 596595194 
import javax.swing.Action;
//#endif 


//#if -886704060 
import org.apache.log4j.Logger;
//#endif 


//#if -1189648400 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1298368399 
import org.argouml.i18n.Translator;
//#endif 


//#if 960832439 
import org.argouml.model.Model;
//#endif 


//#if -1007681495 
import org.argouml.model.StateMachinesFactory;
//#endif 


//#if -1767586741 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 609847194 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1617246668 
import org.argouml.uml.diagram.state.StateDiagramGraphModel;
//#endif 


//#if 666732789 
import org.argouml.uml.diagram.state.ui.FigCompositeState;
//#endif 


//#if 623778516 
import org.argouml.uml.diagram.state.ui.FigConcurrentRegion;
//#endif 


//#if 1323440642 
import org.argouml.uml.diagram.state.ui.FigStateVertex;
//#endif 


//#if 581845198 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1287189333 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1277399399 
import org.tigris.gef.base.LayerDiagram;
//#endif 


//#if 1829942243 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1366498825 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 892057262 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -144112870 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -814813275 
public class ActionAddConcurrentRegion extends 
//#if 1572656056 
UndoableAction
//#endif 

  { 

//#if -220447004 
private static final Logger LOG =
        Logger.getLogger(ActionAddConcurrentRegion.class);
//#endif 


//#if 2064727072 
public void actionPerformed(ActionEvent ae)
    { 

//#if -1029342804 
super.actionPerformed(ae);
//#endif 


//#if -1520100421 
try //1
{ 

//#if 969274971 
Fig f = TargetManager.getInstance().getFigTarget();
//#endif 


//#if 1061560839 
if(Model.getFacade().isAConcurrentRegion(f.getOwner()))//1
{ 

//#if -624158495 
f = f.getEnclosingFig();
//#endif 

} 

//#endif 


//#if -1497828062 
final FigCompositeState figCompositeState = (FigCompositeState) f;
//#endif 


//#if 1029619205 
final List<FigConcurrentRegion> regionFigs =
                ((List<FigConcurrentRegion>) f.getEnclosedFigs().clone());
//#endif 


//#if 1339719864 
final Object umlCompositeState = figCompositeState.getOwner();
//#endif 


//#if 1222668831 
Editor editor = Globals.curEditor();
//#endif 


//#if 1718845981 
GraphModel gm = editor.getGraphModel();
//#endif 


//#if 2017641319 
LayerDiagram lay =
                ((LayerDiagram) editor.getLayerManager().getActiveLayer());
//#endif 


//#if -167062850 
Rectangle rName =
                ((FigNodeModelElement) f).getNameFig().getBounds();
//#endif 


//#if -274536382 
Rectangle rFig = f.getBounds();
//#endif 


//#if 473893477 
if(!(gm instanceof MutableGraphModel))//1
{ 

//#if 1397041649 
return;
//#endif 

} 

//#endif 


//#if -1045872421 
StateDiagramGraphModel mgm = (StateDiagramGraphModel) gm;
//#endif 


//#if -2053969693 
final StateMachinesFactory factory =
                Model.getStateMachinesFactory();
//#endif 


//#if -1948480205 
if(!Model.getFacade().isConcurrent(umlCompositeState))//1
{ 

//#if 1261804878 
final Object umlRegion1 =
                    factory.buildCompositeState(umlCompositeState);
//#endif 


//#if -384266547 
Rectangle bounds = new Rectangle(
                    f.getX() + FigConcurrentRegion.INSET_HORZ,
                    f.getY() + rName.height
                    + FigConcurrentRegion.INSET_VERT,
                    rFig.width - 2 * FigConcurrentRegion.INSET_HORZ,
                    rFig.height - rName.height
                    - 2 * FigConcurrentRegion.INSET_VERT);
//#endif 


//#if 292116660 
DiagramSettings settings = figCompositeState.getSettings();
//#endif 


//#if 692861517 
final FigConcurrentRegion firstRegionFig =
                    new FigConcurrentRegion(
                    umlRegion1, bounds, settings);
//#endif 


//#if -1900231525 
firstRegionFig.setLineColor(ArgoFig.INVISIBLE_LINE_COLOR);
//#endif 


//#if 1458532531 
firstRegionFig.setEnclosingFig(figCompositeState);
//#endif 


//#if 1453713180 
firstRegionFig.setLayer(lay);
//#endif 


//#if 1767174226 
lay.add(firstRegionFig);
//#endif 


//#if 138702570 
if(mgm.canAddNode(umlRegion1))//1
{ 

//#if 1727003793 
mgm.getNodes().add(umlRegion1);
//#endif 


//#if -2122430850 
mgm.fireNodeAdded(umlRegion1);
//#endif 

} 

//#endif 


//#if -1045952890 
if(!regionFigs.isEmpty())//1
{ 

//#if 1585237584 
for (int i = 0; i < regionFigs.size(); i++) //1
{ 

//#if 1359587699 
FigStateVertex curFig = regionFigs.get(i);
//#endif 


//#if 187780151 
curFig.setEnclosingFig(firstRegionFig);
//#endif 


//#if -107720747 
firstRegionFig.addEnclosedFig(curFig);
//#endif 


//#if 704739944 
curFig.redrawEnclosedFigs();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -720174833 
final Object umlRegion2 =
                factory.buildCompositeState(umlCompositeState);
//#endif 


//#if -1374327934 
Rectangle bounds = new Rectangle(
                f.getX() + FigConcurrentRegion.INSET_HORZ,
                f.getY() + rFig.height - 1, //linewidth?
                rFig.width - 2 * FigConcurrentRegion.INSET_HORZ,
                126);
//#endif 


//#if -1041189132 
DiagramSettings settings = figCompositeState.getSettings();
//#endif 


//#if 314209118 
final FigConcurrentRegion newRegionFig =
                new FigConcurrentRegion(umlRegion2, bounds, settings);
//#endif 


//#if -1498371238 
figCompositeState.setCompositeStateHeight(
                rFig.height + newRegionFig.getInitialHeight());
//#endif 


//#if 282604995 
newRegionFig.setEnclosingFig(figCompositeState);
//#endif 


//#if 28151245 
figCompositeState.addEnclosedFig(newRegionFig);
//#endif 


//#if 1838815244 
newRegionFig.setLayer(lay);
//#endif 


//#if 378679714 
lay.add(newRegionFig);
//#endif 


//#if 42919124 
editor.getSelectionManager().select(f);
//#endif 


//#if -766578359 
if(mgm.canAddNode(umlRegion2))//1
{ 

//#if 503546268 
mgm.getNodes().add(umlRegion2);
//#endif 


//#if -1330612299 
mgm.fireNodeAdded(umlRegion2);
//#endif 

} 

//#endif 


//#if 1882059777 
Model.getStateMachinesHelper().setConcurrent(
                umlCompositeState, true);
//#endif 

} 

//#if 775973420 
catch (Exception ex) //1
{ 

//#if -1524888223 
LOG.error("Exception caught", ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1656536458 
public ActionAddConcurrentRegion()
    { 

//#if 1780696032 
super(Translator.localize("action.add-concurrent-region"),
              ResourceLoaderWrapper.lookupIcon(
                  "action.add-concurrent-region"));
//#endif 


//#if -549961202 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.add-concurrent-region"));
//#endif 

} 

//#endif 


//#if -230716035 
public boolean isEnabled()
    { 

//#if -457567618 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -654253809 
if(Model.getStateMachinesHelper().isTopState(target))//1
{ 

//#if 1638822548 
return false;
//#endif 

} 

//#endif 


//#if -2078216456 
return TargetManager.getInstance().getModelTargets().size() < 2;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

