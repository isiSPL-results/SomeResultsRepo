
//#if 1274209979 
// Compilation Unit of /PropPanelPartition.java 
 

//#if 515991527 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if 1871058791 
import java.util.ArrayList;
//#endif 


//#if -787121446 
import java.util.Collection;
//#endif 


//#if -2100176230 
import java.util.List;
//#endif 


//#if -2682243 
import javax.swing.JComponent;
//#endif 


//#if -1822471074 
import javax.swing.JList;
//#endif 


//#if -555061802 
import javax.swing.JPanel;
//#endif 


//#if -1341141177 
import javax.swing.JScrollPane;
//#endif 


//#if -1971995759 
import org.argouml.i18n.Translator;
//#endif 


//#if 1702688471 
import org.argouml.model.Model;
//#endif 


//#if 868217861 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 731874137 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -724139603 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 286576562 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -1276811621 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if 192662808 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 1984176860 
class UMLPartitionActivityGraphListModel extends 
//#if -1889061720 
UMLModelElementListModel2
//#endif 

  { 

//#if 800561942 
protected void buildModelList()
    { 

//#if -721959954 
removeAllElements();
//#endif 


//#if 1516724139 
addElement(Model.getFacade().getActivityGraph(getTarget()));
//#endif 

} 

//#endif 


//#if -819751094 
protected boolean isValidElement(Object element)
    { 

//#if -1818100850 
return Model.getFacade().getActivityGraph(getTarget()) == element;
//#endif 

} 

//#endif 


//#if 12314578 
public UMLPartitionActivityGraphListModel()
    { 

//#if 1596639719 
super("activityGraph");
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1639224358 
public class PropPanelPartition extends 
//#if 993318938 
PropPanelModelElement
//#endif 

  { 

//#if -510315170 
private JScrollPane contentsScroll;
//#endif 


//#if 183044562 
private JPanel activityGraphScroll;
//#endif 


//#if -1132552284 
private static UMLPartitionContentListModel contentListModel =
        new UMLPartitionContentListModel("contents");
//#endif 


//#if -974089678 
protected JComponent getContentsField()
    { 

//#if 23279432 
if(contentsScroll == null)//1
{ 

//#if 892500731 
JList contentList = new UMLMutableLinkedList(
                contentListModel,
                new ActionAddPartitionContent(),
                null);
//#endif 


//#if -1553790668 
contentsScroll = new JScrollPane(contentList);
//#endif 

} 

//#endif 


//#if -1500875445 
return contentsScroll;
//#endif 

} 

//#endif 


//#if 1404366980 
protected JPanel getActivityGraphField()
    { 

//#if 428252076 
return activityGraphScroll;
//#endif 

} 

//#endif 


//#if 823579757 
public PropPanelPartition()
    { 

//#if -2104954690 
super("label.partition-title",  lookupIcon("Partition"));
//#endif 


//#if 898107023 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if -1816585681 
activityGraphScroll =
            getSingleRowScroll(new UMLPartitionActivityGraphListModel());
//#endif 


//#if -1843748391 
addField(Translator.localize("label.activity-graph"),
                 getActivityGraphField());
//#endif 


//#if -859439634 
addSeparator();
//#endif 


//#if -1253040226 
addField(Translator.localize("label.contents"), getContentsField());
//#endif 


//#if 1350746108 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -1829574456 
addAction(new ActionNewStereotype());
//#endif 


//#if -347823471 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -64598692 
class ActionAddPartitionContent extends 
//#if 1205157180 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -497571174 
@Override
        protected void doIt(Collection selected)
        { 

//#if 2078205073 
Object partition = getTarget();
//#endif 


//#if 1643050075 
if(Model.getFacade().isAPartition(partition))//1
{ 

//#if 1602414490 
Model.getActivityGraphsHelper().setContents(
                    partition, selected);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1259611316 
public ActionAddPartitionContent()
        { 

//#if -368174618 
super();
//#endif 


//#if 257013678 
setMultiSelect(true);
//#endif 

} 

//#endif 


//#if 747099660 
protected List getSelected()
        { 

//#if 2138350170 
List ret = new ArrayList();
//#endif 


//#if 365874681 
ret.addAll(Model.getFacade().getContents(getTarget()));
//#endif 


//#if -1670790823 
return ret;
//#endif 

} 

//#endif 


//#if -320837565 
protected List getChoices()
        { 

//#if 1040493493 
List ret = new ArrayList();
//#endif 


//#if 1060369029 
if(Model.getFacade().isAPartition(getTarget()))//1
{ 

//#if -1964205840 
Object partition = getTarget();
//#endif 


//#if -1653933780 
Object ag = Model.getFacade().getActivityGraph(partition);
//#endif 


//#if -1200025231 
if(ag != null)//1
{ 

//#if 1010786654 
Object top = Model.getFacade().getTop(ag);
//#endif 


//#if 2127702408 
ret.addAll(Model.getFacade().getSubvertices(top));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1629577186 
return ret;
//#endif 

} 

//#endif 


//#if 32092980 
protected String getDialogTitle()
        { 

//#if -1061174468 
return Translator.localize("dialog.title.add-contents");
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#if -2030703838 
class UMLPartitionContentListModel extends 
//#if 149620195 
UMLModelElementListModel2
//#endif 

  { 

//#if 819297541 
protected boolean isValidElement(Object element)
    { 

//#if -405540547 
if(!Model.getFacade().isAModelElement(element))//1
{ 

//#if 161321315 
return false;
//#endif 

} 

//#endif 


//#if -1530717193 
Object partition = getTarget();
//#endif 


//#if 1481850392 
return Model.getFacade().getContents(partition).contains(element);
//#endif 

} 

//#endif 


//#if -1328679295 
public UMLPartitionContentListModel(String name)
    { 

//#if -705987956 
super(name);
//#endif 

} 

//#endif 


//#if -1272293679 
protected void buildModelList()
    { 

//#if -1744618498 
Object partition = getTarget();
//#endif 


//#if 1848631492 
setAllElements(Model.getFacade().getContents(partition));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

