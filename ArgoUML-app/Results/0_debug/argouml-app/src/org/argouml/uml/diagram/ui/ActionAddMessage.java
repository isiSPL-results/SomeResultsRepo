
//#if -61609223 
// Compilation Unit of /ActionAddMessage.java 
 

//#if -101879221 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -211150298 
import java.awt.event.ActionEvent;
//#endif 


//#if -1056789092 
import javax.swing.Action;
//#endif 


//#if 1473239310 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 943264527 
import org.argouml.i18n.Translator;
//#endif 


//#if 1763949909 
import org.argouml.model.Model;
//#endif 


//#if 789493856 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -678734296 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -1660429843 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1008412048 
import org.tigris.gef.base.Editor;
//#endif 


//#if 954443593 
import org.tigris.gef.base.Globals;
//#endif 


//#if 2105229000 
import org.tigris.gef.base.Layer;
//#endif 


//#if 1199886209 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1114390585 
import org.tigris.gef.graph.GraphNodeRenderer;
//#endif 


//#if -1915517974 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1136338244 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1157776945 
public class ActionAddMessage extends 
//#if -1966553721 
UndoableAction
//#endif 

  { 

//#if 2130938098 
private static ActionAddMessage targetFollower;
//#endif 


//#if -911312593 
public void actionPerformed(ActionEvent ae)
    { 

//#if -1497829087 
super.actionPerformed(ae);
//#endif 


//#if -1389466065 
Object target =  TargetManager.getInstance().getModelTarget();
//#endif 


//#if -1966596895 
if(!(Model.getFacade().isAAssociationRole(target))
                && Model.getFacade().isACollaboration(Model.getFacade()
                        .getNamespace(target)))//1
{ 

//#if -2134854739 
return;
//#endif 

} 

//#endif 


//#if -1518290833 
this.addMessage(target);
//#endif 

} 

//#endif 


//#if 2036370144 
public boolean shouldBeEnabled()
    { 

//#if -1806534444 
Object target =  TargetManager.getInstance().getModelTarget();
//#endif 


//#if -495067974 
return Model.getFacade().isAAssociationRole(target);
//#endif 

} 

//#endif 


//#if -2033487217 
private void addMessage(Object associationrole)
    { 

//#if 440212257 
Object collaboration = Model.getFacade().getNamespace(associationrole);
//#endif 


//#if -1444466818 
Object message =
            Model.getCollaborationsFactory()
            .buildMessage(collaboration, associationrole);
//#endif 


//#if 562686226 
Editor e = Globals.curEditor();
//#endif 


//#if 1440749772 
GraphModel gm = e.getGraphModel();
//#endif 


//#if 1816851609 
Layer lay = e.getLayerManager().getActiveLayer();
//#endif 


//#if -132947117 
GraphNodeRenderer gr = e.getGraphNodeRenderer();
//#endif 


//#if 2048018966 
FigNode figMsg = gr.getFigNodeFor(gm, lay, message, null);
//#endif 


//#if 391662703 
((FigMessage) figMsg).addPathItemToFigAssociationRole(lay);
//#endif 


//#if 813201926 
gm.getNodes().add(message);
//#endif 


//#if -158680498 
TargetManager.getInstance().setTarget(message);
//#endif 

} 

//#endif 


//#if 1899860096 
public static ActionAddMessage getTargetFollower()
    { 

//#if -250232838 
if(targetFollower == null)//1
{ 

//#if 1023109056 
targetFollower  = new ActionAddMessage();
//#endif 


//#if -1477328932 
TargetManager.getInstance().addTargetListener(new TargetListener() {
                public void targetAdded(TargetEvent e) {
                    setTarget();
                }
                public void targetRemoved(TargetEvent e) {
                    setTarget();
                }

                public void targetSet(TargetEvent e) {
                    setTarget();
                }
                private void setTarget() {
                    targetFollower.setEnabled(targetFollower.shouldBeEnabled());
                }
            });
//#endif 


//#if -2093608459 
targetFollower.setEnabled(targetFollower.shouldBeEnabled());
//#endif 

} 

//#endif 


//#if 2141508589 
return targetFollower;
//#endif 

} 

//#endif 


//#if -1503350567 
public ActionAddMessage()
    { 

//#if -1879953811 
super(Translator.localize("action.add-message"),
              ResourceLoaderWrapper.lookupIcon("action.add-message"));
//#endif 


//#if -1717302530 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.add-message"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

