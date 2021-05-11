
//#if -518397476 
// Compilation Unit of /ActionDeleteModelElements.java 
 

//#if -1187237221 
package org.argouml.uml.ui;
//#endif 


//#if -917148124 
import java.awt.Component;
//#endif 


//#if 60571513 
import java.awt.KeyboardFocusManager;
//#endif 


//#if -1452053807 
import java.awt.event.ActionEvent;
//#endif 


//#if -1475300440 
import java.text.MessageFormat;
//#endif 


//#if -1097537657 
import java.util.List;
//#endif 


//#if 2091964743 
import javax.swing.Action;
//#endif 


//#if 142484562 
import javax.swing.JOptionPane;
//#endif 


//#if 1042367417 
import javax.swing.JTable;
//#endif 


//#if -1698334372 
import javax.swing.table.TableCellEditor;
//#endif 


//#if -532285161 
import org.apache.log4j.Logger;
//#endif 


//#if 1377072515 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1129961412 
import org.argouml.i18n.Translator;
//#endif 


//#if 985288256 
import org.argouml.kernel.Project;
//#endif 


//#if -833938263 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -237302996 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -2020075255 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 1315251338 
import org.argouml.model.Model;
//#endif 


//#if -1206124085 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -1195503395 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 401110168 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 101381196 
import org.argouml.uml.CommentEdge;
//#endif 


//#if 659212105 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1426229120 
import org.argouml.util.ArgoFrame;
//#endif 


//#if 2045651739 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1141140478 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1588802689 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -962830553 
import org.tigris.gef.presentation.FigTextEditor;
//#endif 


//#if -978038681 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1239299905 

//#if 1087591232 
@UmlModelMutator
//#endif 

public class ActionDeleteModelElements extends 
//#if -2126705177 
UndoableAction
//#endif 

  { 

//#if -309319958 
private static final long serialVersionUID = -5728400220151823726L;
//#endif 


//#if 2060611051 
private static ActionDeleteModelElements targetFollower;
//#endif 


//#if 10934556 
private static final Logger LOG =
        Logger.getLogger(ActionDeleteModelElements.class);
//#endif 


//#if 1997223825 
public static ActionDeleteModelElements getTargetFollower()
    { 

//#if 1784354973 
if(targetFollower == null)//1
{ 

//#if -1840034528 
targetFollower  = new ActionDeleteModelElements();
//#endif 


//#if -1289417821 
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


//#if 2017841084 
targetFollower.setEnabled(targetFollower.shouldBeEnabled());
//#endif 

} 

//#endif 


//#if -881450288 
return targetFollower;
//#endif 

} 

//#endif 


//#if -641256811 
protected static boolean sureRemoveModelElement(Object me)
    { 

//#if 1468835523 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1639532608 
int count = p.getPresentationCountFor(me);
//#endif 


//#if 1300885164 
boolean doAsk = false;
//#endif 


//#if 1942560067 
String confirmStr = "";
//#endif 


//#if -936286814 
if(count > 1)//1
{ 

//#if 2111774693 
confirmStr += Translator.localize(
                              "optionpane.remove-from-model-will-remove-from-diagrams");
//#endif 


//#if -836322477 
doAsk = true;
//#endif 

} 

//#endif 


//#if 728104541 
if(!doAsk)//1
{ 

//#if -843254044 
return true;
//#endif 

} 

//#endif 


//#if 890232913 
String name = Model.getFacade().getName(me);
//#endif 


//#if -1602907471 
if(name == null || name.equals(""))//1
{ 

//#if 330425395 
name = Translator.localize(
                       "optionpane.remove-from-model-anon-element-name");
//#endif 

} 

//#endif 


//#if 1017535038 
confirmStr =
            MessageFormat.format(Translator.localize(
                                     "optionpane.remove-from-model-confirm-delete"),
                                 new Object[] {
                                     name, confirmStr,
                                 });
//#endif 


//#if 1259911305 
int response =
            JOptionPane.showConfirmDialog(
                ArgoFrame.getInstance(),
                confirmStr,
                Translator.localize(
                    "optionpane.remove-from-model-confirm-delete-title"),
                JOptionPane.YES_NO_OPTION);
//#endif 


//#if -2092165604 
return (response == JOptionPane.YES_OPTION);
//#endif 

} 

//#endif 


//#if 234361664 
public boolean shouldBeEnabled()
    { 

//#if -560965927 
List targets = TargetManager.getInstance().getTargets();
//#endif 


//#if -601050873 
for (Object target : targets) //1
{ 

//#if -1442344208 
if(Model.getFacade().isAModelElement(target)
                    && Model.getModelManagementHelper().isReadOnly(target))//1
{ 

//#if -1447310336 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1268250272 
int size = 0;
//#endif 


//#if 942086014 
try //1
{ 

//#if 475905213 
Editor ce = Globals.curEditor();
//#endif 


//#if -1458985147 
List<Fig> figs = ce.getSelectionManager().getFigs();
//#endif 


//#if -433308198 
size = figs.size();
//#endif 

} 

//#if 653655111 
catch (Exception e) //1
{ 
} 

//#endif 


//#endif 


//#if -1491722594 
if(size > 0)//1
{ 

//#if -1987383619 
return true;
//#endif 

} 

//#endif 


//#if 689014284 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if 836924354 
if(target instanceof ArgoDiagram)//1
{ 

//#if -1332519678 
return (ProjectManager.getManager().getCurrentProject()
                    .getDiagramList().size() > 1);
//#endif 

} 

//#endif 


//#if 1781641740 
if(Model.getFacade().isAModel(target)
                // we cannot delete the model itself
                && target.equals(ProjectManager.getManager().getCurrentProject()
                                 .getModel()))//1
{ 

//#if -1500115130 
return false;
//#endif 

} 

//#endif 


//#if -1509904924 
if(Model.getFacade().isAAssociationEnd(target))//1
{ 

//#if 939409763 
return Model.getFacade().getOtherAssociationEnds(target).size() > 1;
//#endif 

} 

//#endif 


//#if 1927454030 
if(Model.getStateMachinesHelper().isTopState(target))//1
{ 

//#if -64040960 
return false;
//#endif 

} 

//#endif 


//#if -675382481 
return target != null;
//#endif 

} 

//#endif 


//#if 574556559 
public void actionPerformed(ActionEvent ae)
    { 

//#if 991964268 
super.actionPerformed(ae);
//#endif 


//#if 734369008 
KeyboardFocusManager focusManager =
            KeyboardFocusManager.getCurrentKeyboardFocusManager();
//#endif 


//#if -559499912 
Component focusOwner = focusManager.getFocusOwner();
//#endif 


//#if 895128569 
if(focusOwner instanceof FigTextEditor)//1
{ 

//#if -999912211 
((FigTextEditor) focusOwner).endEditing();
//#endif 

} 
else

//#if 571885097 
if(focusOwner instanceof JTable)//1
{ 

//#if 1540439628 
JTable table = (JTable) focusOwner;
//#endif 


//#if -1830381808 
if(table.isEditing())//1
{ 

//#if 1091687922 
TableCellEditor ce = table.getCellEditor();
//#endif 


//#if 929836985 
if(ce != null)//1
{ 

//#if -625953900 
ce.cancelCellEditing();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#if -1974964639 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -957420600 
Object[] targets = TargetManager.getInstance().getTargets().toArray();
//#endif 


//#if -1911695353 
TargetManager.getInstance().setTarget(null);
//#endif 


//#if -1504830612 
Object target = null;
//#endif 


//#if 1661327044 
for (int i = targets.length - 1; i >= 0; i--) //1
{ 

//#if 1478734862 
target = targets[i];
//#endif 


//#if 808624546 
try //1
{ 

//#if -1235519644 
if(sureRemove(target))//1
{ 

//#if 1901254542 
if(target instanceof Fig)//1
{ 

//#if -1334325386 
Object owner = ((Fig) target).getOwner();
//#endif 


//#if 823275414 
if(owner != null)//1
{ 

//#if 958835233 
target = owner;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1073327417 
p.moveToTrash(target);
//#endif 

} 

//#endif 

} 

//#if -1587813809 
catch (InvalidElementException e) //1
{ 

//#if 903499634 
LOG.debug("Model element deleted twice - ignoring 2nd delete");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 850981316 
public ActionDeleteModelElements()
    { 

//#if 1635328947 
super(Translator.localize("action.delete-from-model"),
              ResourceLoaderWrapper.lookupIcon("action.delete-from-model"));
//#endif 


//#if 668998309 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.delete-from-model"));
//#endif 


//#if -835521024 
putValue(Action.SMALL_ICON,
                 ResourceLoaderWrapper.lookupIcon("Delete"));
//#endif 

} 

//#endif 


//#if -500743960 
public static boolean sureRemove(Object target)
    { 

//#if -1127099268 
boolean sure = false;
//#endif 


//#if 73869177 
if(Model.getFacade().isAModelElement(target))//1
{ 

//#if -1015990955 
sure = sureRemoveModelElement(target);
//#endif 

} 
else

//#if 1457234524 
if(Model.getFacade().isAUMLElement(target))//1
{ 

//#if -116467455 
sure = true;
//#endif 

} 
else

//#if -1103498429 
if(target instanceof ArgoDiagram)//1
{ 

//#if 596610334 
ArgoDiagram diagram = (ArgoDiagram) target;
//#endif 


//#if -1218379380 
if(diagram.getNodes().size() + diagram.getEdges().size() != 0)//1
{ 

//#if 2066348375 
String confirmStr =
                    MessageFormat.format(Translator.localize(
                                             "optionpane.remove-from-model-confirm-delete"),
                                         new Object[] {
                                             diagram.getName(), "",
                                         });
//#endif 


//#if -1223162988 
String text =
                    Translator.localize(
                        "optionpane.remove-from-model-confirm-delete-title");
//#endif 


//#if -994917283 
int response =
                    JOptionPane.showConfirmDialog(ArgoFrame.getInstance(),
                                                  confirmStr,
                                                  text,
                                                  JOptionPane.YES_NO_OPTION);
//#endif 


//#if -807462655 
sure = (response == JOptionPane.YES_OPTION);
//#endif 

} 
else
{ 

//#if 1498581263 
sure = true;
//#endif 

} 

//#endif 

} 
else

//#if 904729180 
if(target instanceof Fig)//1
{ 

//#if -1471557126 
if(Model.getFacade().isAModelElement(((Fig) target).getOwner()))//1
{ 

//#if 2070762028 
sure = sureRemoveModelElement(((Fig) target).getOwner());
//#endif 

} 
else
{ 

//#if -806349814 
sure = true;
//#endif 

} 

//#endif 

} 
else

//#if -1507250524 
if(target instanceof CommentEdge)//1
{ 

//#if -815340168 
sure = true;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if -1327439182 
return sure;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

