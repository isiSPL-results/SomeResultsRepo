// Compilation Unit of /ActionAddConcurrentRegion.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.Action;
import org.apache.log4j.Logger;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.model.StateMachinesFactory;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.state.StateDiagramGraphModel;
import org.argouml.uml.diagram.state.ui.FigCompositeState;
import org.argouml.uml.diagram.state.ui.FigConcurrentRegion;
import org.argouml.uml.diagram.state.ui.FigStateVertex;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.LayerDiagram;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.undo.UndoableAction;
public class ActionAddConcurrentRegion extends UndoableAction
  { 
private static final Logger LOG =
        Logger.getLogger(ActionAddConcurrentRegion.class);
public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
try //1
{ 
Fig f = TargetManager.getInstance().getFigTarget();
if(Model.getFacade().isAConcurrentRegion(f.getOwner()))//1
{ 
f = f.getEnclosingFig();
} 

final FigCompositeState figCompositeState = (FigCompositeState) f;
final List<FigConcurrentRegion> regionFigs =
                ((List<FigConcurrentRegion>) f.getEnclosedFigs().clone());
final Object umlCompositeState = figCompositeState.getOwner();
Editor editor = Globals.curEditor();
GraphModel gm = editor.getGraphModel();
LayerDiagram lay =
                ((LayerDiagram) editor.getLayerManager().getActiveLayer());
Rectangle rName =
                ((FigNodeModelElement) f).getNameFig().getBounds();
Rectangle rFig = f.getBounds();
if(!(gm instanceof MutableGraphModel))//1
{ 
return;
} 

StateDiagramGraphModel mgm = (StateDiagramGraphModel) gm;
final StateMachinesFactory factory =
                Model.getStateMachinesFactory();
if(!Model.getFacade().isConcurrent(umlCompositeState))//1
{ 
final Object umlRegion1 =
                    factory.buildCompositeState(umlCompositeState);
Rectangle bounds = new Rectangle(
                    f.getX() + FigConcurrentRegion.INSET_HORZ,
                    f.getY() + rName.height
                    + FigConcurrentRegion.INSET_VERT,
                    rFig.width - 2 * FigConcurrentRegion.INSET_HORZ,
                    rFig.height - rName.height
                    - 2 * FigConcurrentRegion.INSET_VERT);
DiagramSettings settings = figCompositeState.getSettings();
final FigConcurrentRegion firstRegionFig =
                    new FigConcurrentRegion(
                    umlRegion1, bounds, settings);
firstRegionFig.setLineColor(ArgoFig.INVISIBLE_LINE_COLOR);
firstRegionFig.setEnclosingFig(figCompositeState);
firstRegionFig.setLayer(lay);
lay.add(firstRegionFig);
if(mgm.canAddNode(umlRegion1))//1
{ 
mgm.getNodes().add(umlRegion1);
mgm.fireNodeAdded(umlRegion1);
} 

if(!regionFigs.isEmpty())//1
{ 
for (int i = 0; i < regionFigs.size(); i++) //1
{ 
FigStateVertex curFig = regionFigs.get(i);
curFig.setEnclosingFig(firstRegionFig);
firstRegionFig.addEnclosedFig(curFig);
curFig.redrawEnclosedFigs();
} 

} 

} 

final Object umlRegion2 =
                factory.buildCompositeState(umlCompositeState);
Rectangle bounds = new Rectangle(
                f.getX() + FigConcurrentRegion.INSET_HORZ,
                f.getY() + rFig.height - 1, //linewidth?
                rFig.width - 2 * FigConcurrentRegion.INSET_HORZ,
                126);
DiagramSettings settings = figCompositeState.getSettings();
final FigConcurrentRegion newRegionFig =
                new FigConcurrentRegion(umlRegion2, bounds, settings);
figCompositeState.setCompositeStateHeight(
                rFig.height + newRegionFig.getInitialHeight());
newRegionFig.setEnclosingFig(figCompositeState);
figCompositeState.addEnclosedFig(newRegionFig);
newRegionFig.setLayer(lay);
lay.add(newRegionFig);
editor.getSelectionManager().select(f);
if(mgm.canAddNode(umlRegion2))//1
{ 
mgm.getNodes().add(umlRegion2);
mgm.fireNodeAdded(umlRegion2);
} 

Model.getStateMachinesHelper().setConcurrent(
                umlCompositeState, true);
} 
catch (Exception ex) //1
{ 
LOG.error("Exception caught", ex);
} 


} 

public ActionAddConcurrentRegion()
    { 
super(Translator.localize("action.add-concurrent-region"),
              ResourceLoaderWrapper.lookupIcon(
                  "action.add-concurrent-region"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.add-concurrent-region"));
} 

public boolean isEnabled()
    { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getStateMachinesHelper().isTopState(target))//1
{ 
return false;
} 

return TargetManager.getInstance().getModelTargets().size() < 2;
} 

 } 


