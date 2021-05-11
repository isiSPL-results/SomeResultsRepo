
//#if 438711316 
// Compilation Unit of /PropPanelSendAction.java 
 

//#if -852289158 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 1874435427 
import java.util.ArrayList;
//#endif 


//#if -682445730 
import java.util.Collection;
//#endif 


//#if 1741260574 
import java.util.List;
//#endif 


//#if -1093142717 
import javax.swing.JScrollPane;
//#endif 


//#if 682722701 
import org.argouml.i18n.Translator;
//#endif 


//#if -968801449 
import org.argouml.kernel.Project;
//#endif 


//#if 892440498 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1950686931 
import org.argouml.model.Model;
//#endif 


//#if -1646143231 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 505442097 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -672825426 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if 885219562 
public class PropPanelSendAction extends 
//#if -1874012853 
PropPanelAction
//#endif 

  { 

//#if 581697256 
private static final long serialVersionUID = -6002902665554123820L;
//#endif 


//#if 413982443 
public PropPanelSendAction()
    { 

//#if -1987096683 
super("label.send-action", lookupIcon("SendAction"));
//#endif 


//#if 913960723 
AbstractActionAddModelElement2 action =
            new ActionAddSendActionSignal();
//#endif 


//#if -789805842 
UMLMutableLinkedList list =
            new UMLMutableLinkedList(
            new UMLSendActionSignalListModel(), action,
            new ActionNewSignal(), null, true);
//#endif 


//#if 886704598 
list.setVisibleRowCount(2);
//#endif 


//#if -1629163 
JScrollPane signalScroll = new JScrollPane(list);
//#endif 


//#if -1280297601 
addFieldBefore(Translator.localize("label.signal"),
                       signalScroll,
                       argumentsScroll);
//#endif 

} 

//#endif 


//#if 1864286253 
@Override
    protected void addExtraActions()
    { 

//#if -507486490 
addAction(new ActionNewSignal());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1939591475 
class ActionAddSendActionSignal extends 
//#if 632766153 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -1885137231 
private Object choiceClass = Model.getMetaTypes().getSignal();
//#endif 


//#if 1060053596 
private static final long serialVersionUID = -6172250439307650139L;
//#endif 


//#if -532159673 
protected String getDialogTitle()
    { 

//#if -200921351 
return Translator.localize("dialog.title.add-signal");
//#endif 

} 

//#endif 


//#if -744033753 
@Override
    protected void doIt(Collection selected)
    { 

//#if -908641099 
if(selected != null && selected.size() >= 1)//1
{ 

//#if -704396050 
Model.getCommonBehaviorHelper().setSignal(
                getTarget(),
                selected.iterator().next());
//#endif 

} 
else
{ 

//#if 1800022913 
Model.getCommonBehaviorHelper().setSignal(getTarget(), null);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -138796330 
public ActionAddSendActionSignal()
    { 

//#if 1487509005 
super();
//#endif 


//#if 336835278 
setMultiSelect(false);
//#endif 

} 

//#endif 


//#if 962388630 
protected List getChoices()
    { 

//#if -192957708 
List ret = new ArrayList();
//#endif 


//#if -513692515 
if(getTarget() != null)//1
{ 

//#if -1827699191 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1300488432 
Object model = p.getRoot();
//#endif 


//#if 906316422 
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKindWithModel(model, choiceClass));
//#endif 

} 

//#endif 


//#if -1687306625 
return ret;
//#endif 

} 

//#endif 


//#if 1872406041 
protected List getSelected()
    { 

//#if 804057280 
List ret = new ArrayList();
//#endif 


//#if -1428538527 
Object signal = Model.getFacade().getSignal(getTarget());
//#endif 


//#if -1897240843 
if(signal != null)//1
{ 

//#if -206561418 
ret.add(signal);
//#endif 

} 

//#endif 


//#if -1965816525 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1872086415 
class UMLSendActionSignalListModel extends 
//#if -684177790 
UMLModelElementListModel2
//#endif 

  { 

//#if 788326451 
private static final long serialVersionUID = -8126377938452286169L;
//#endif 


//#if 2046620135 
public UMLSendActionSignalListModel()
    { 

//#if 464786537 
super("signal");
//#endif 

} 

//#endif 


//#if 926710371 
protected boolean isValidElement(Object elem)
    { 

//#if 144269621 
return Model.getFacade().isASignal(elem)
               && Model.getFacade().getSignal(getTarget()) == elem;
//#endif 

} 

//#endif 


//#if 580399088 
protected void buildModelList()
    { 

//#if -594031352 
removeAllElements();
//#endif 


//#if -622942902 
addElement(Model.getFacade().getSignal(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

