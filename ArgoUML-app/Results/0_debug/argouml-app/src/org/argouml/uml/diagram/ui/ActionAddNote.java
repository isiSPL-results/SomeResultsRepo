
//#if -95754572 
// Compilation Unit of /ActionAddNote.java 
 

//#if -1182906286 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1098255455 
import java.awt.Point;
//#endif 


//#if 325236320 
import java.awt.Rectangle;
//#endif 


//#if 1693640511 
import java.awt.event.ActionEvent;
//#endif 


//#if -256030475 
import java.util.Collection;
//#endif 


//#if -18469083 
import java.util.Iterator;
//#endif 


//#if -1808620619 
import javax.swing.Action;
//#endif 


//#if 412656725 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -137762538 
import org.argouml.i18n.Translator;
//#endif 


//#if -1719256678 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 774287068 
import org.argouml.model.Model;
//#endif 


//#if 1940499255 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if -437431034 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1166342754 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 1963288219 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1405084355 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 152635442 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 1328958675 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -7759210 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 877297 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 2732647 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if 1834974933 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1851462159 

//#if 1370289058 
@UmlModelMutator
//#endif 

public class ActionAddNote extends 
//#if 1936154313 
UndoableAction
//#endif 

  { 

//#if -1271343967 
private static final int DEFAULT_POS = 20;
//#endif 


//#if -488345584 
private static final int DISTANCE = 80;
//#endif 


//#if -1696328219 
private static final long serialVersionUID = 6502515091619480472L;
//#endif 


//#if -150985331 
private Point calculateLocation(
        ArgoDiagram diagram, Object firstTarget, Fig noteFig)
    { 

//#if 868727701 
Point point = new Point(DEFAULT_POS, DEFAULT_POS);
//#endif 


//#if -179648409 
if(firstTarget == null)//1
{ 

//#if 1311489477 
return point;
//#endif 

} 

//#endif 


//#if 1415572469 
Fig elemFig = diagram.presentationFor(firstTarget);
//#endif 


//#if -1427390341 
if(elemFig == null)//1
{ 

//#if 312006808 
return point;
//#endif 

} 

//#endif 


//#if 1866136580 
if(elemFig instanceof FigEdgeModelElement)//1
{ 

//#if 1739632126 
elemFig = ((FigEdgeModelElement) elemFig).getEdgePort();
//#endif 

} 

//#endif 


//#if -295491306 
if(elemFig instanceof FigNode)//1
{ 

//#if 1593552545 
point.x = elemFig.getX() + elemFig.getWidth() + DISTANCE;
//#endif 


//#if -284754484 
point.y = elemFig.getY();
//#endif 


//#if -1693369919 
Rectangle drawingArea =
                ProjectBrowser.getInstance().getEditorPane().getBounds();
//#endif 


//#if -1862000813 
if(point.x + noteFig.getWidth() > drawingArea.getX())//1
{ 

//#if -1027252534 
point.x = elemFig.getX() - noteFig.getWidth() - DISTANCE;
//#endif 


//#if -862647488 
if(point.x >= 0)//1
{ 

//#if -1670452447 
return point;
//#endif 

} 

//#endif 


//#if 858073586 
point.x = elemFig.getX();
//#endif 


//#if 1433470391 
point.y = elemFig.getY() - noteFig.getHeight() - DISTANCE;
//#endif 


//#if 880162847 
if(point.y >= 0)//1
{ 

//#if 979748371 
return point;
//#endif 

} 

//#endif 


//#if -666023106 
point.y = elemFig.getY() + elemFig.getHeight() + DISTANCE;
//#endif 


//#if -626338474 
if(point.y + noteFig.getHeight() > drawingArea.getHeight())//1
{ 

//#if -1688878479 
return new Point(0, 0);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -6251331 
return point;
//#endif 

} 

//#endif 


//#if -226872557 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if -716951633 
super.actionPerformed(ae);
//#endif 


//#if -1269304896 
Collection targets = TargetManager.getInstance().getModelTargets();
//#endif 


//#if -646578577 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if -1307778033 
Object comment =
            Model.getCoreFactory().buildComment(null,
                                                diagram.getNamespace());
//#endif 


//#if -512923439 
MutableGraphModel mgm = (MutableGraphModel) diagram.getGraphModel();
//#endif 


//#if -1125144047 
Object firstTarget = null;
//#endif 


//#if 1543849078 
Iterator i = targets.iterator();
//#endif 


//#if 2103491762 
while (i.hasNext()) //1
{ 

//#if 1747137103 
Object obj = i.next();
//#endif 


//#if -159463420 
Fig destFig = diagram.presentationFor(obj);
//#endif 


//#if -1566325141 
if(destFig instanceof FigEdgeModelElement)//1
{ 

//#if 1247184212 
FigEdgeModelElement destEdge = (FigEdgeModelElement) destFig;
//#endif 


//#if 1055615639 
destEdge.makeEdgePort();
//#endif 


//#if 1040384226 
destFig = destEdge.getEdgePort();
//#endif 


//#if 50335385 
destEdge.calcBounds();
//#endif 

} 

//#endif 


//#if -1729104072 
if(Model.getFacade().isAModelElement(obj)
                    && (!(Model.getFacade().isAComment(obj))))//1
{ 

//#if -1119124077 
if(firstTarget == null)//1
{ 

//#if -1530109925 
firstTarget = obj;
//#endif 

} 

//#endif 


//#if -1694189912 
if(!Model.getFacade().getAnnotatedElements(comment)
                        .contains(obj))//1
{ 

//#if 1117156500 
Model.getCoreHelper().addAnnotatedElement(comment, obj);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 901872777 
mgm.addNode(comment);
//#endif 


//#if -508360042 
Fig noteFig = diagram.presentationFor(comment);
//#endif 


//#if -371504263 
i = Model.getFacade().getAnnotatedElements(comment).iterator();
//#endif 


//#if 1550309567 
while (i.hasNext()) //2
{ 

//#if -328563012 
Object obj = i.next();
//#endif 


//#if 1586013211 
if(diagram.presentationFor(obj) != null)//1
{ 

//#if 1048163579 
CommentEdge commentEdge = new CommentEdge(comment, obj);
//#endif 


//#if -1874668457 
mgm.addEdge(commentEdge);
//#endif 


//#if -1849833191 
FigEdge fe = (FigEdge) diagram.presentationFor(commentEdge);
//#endif 


//#if -318109303 
FigPoly fp = (FigPoly) fe.getFig();
//#endif 


//#if 107906207 
fp.setComplete(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1578111215 
noteFig.setLocation(calculateLocation(diagram, firstTarget, noteFig));
//#endif 


//#if 399364093 
TargetManager.getInstance().setTarget(noteFig.getOwner());
//#endif 

} 

//#endif 


//#if -699557632 
public ActionAddNote()
    { 

//#if 1834487555 
super(Translator.localize("action.new-comment"),
              ResourceLoaderWrapper.lookupIcon("action.new-comment"));
//#endif 


//#if -1217711329 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.new-comment"));
//#endif 


//#if -971725711 
putValue(Action.SMALL_ICON, ResourceLoaderWrapper
                 .lookupIconResource("New Note"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

