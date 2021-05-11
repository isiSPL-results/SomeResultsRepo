
//#if 433828163 
// Compilation Unit of /PropPanelLink.java 
 

//#if 1494155696 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -1750267490 
import java.awt.event.ActionEvent;
//#endif 


//#if -595315948 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 953966228 
import java.util.Collection;
//#endif 


//#if -287115152 
import java.util.HashSet;
//#endif 


//#if 1690050692 
import java.util.Iterator;
//#endif 


//#if -100100844 
import javax.swing.Action;
//#endif 


//#if 1893367429 
import javax.swing.JComboBox;
//#endif 


//#if -1854672969 
import javax.swing.JComponent;
//#endif 


//#if 648516324 
import javax.swing.JList;
//#endif 


//#if 1376688461 
import javax.swing.JScrollPane;
//#endif 


//#if 475271831 
import org.argouml.i18n.Translator;
//#endif 


//#if 125550813 
import org.argouml.model.Model;
//#endif 


//#if 1884934490 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1822598561 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if 809319008 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -42125989 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if -1043912197 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if -1140974070 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -104584990 
import org.argouml.uml.ui.UMLSearchableComboBox;
//#endif 


//#if 1227257173 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if 607620690 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 1648153140 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -751777904 
public class PropPanelLink extends 
//#if -751173272 
PropPanelModelElement
//#endif 

  { 

//#if 1789535979 
private JComboBox associationSelector;
//#endif 


//#if -1401187599 
private UMLLinkAssociationComboBoxModel associationComboBoxModel =
        new UMLLinkAssociationComboBoxModel();
//#endif 


//#if 931147746 
private static final long serialVersionUID = 8861148331491989705L;
//#endif 


//#if -1537584704 
protected JComponent getAssociationSelector()
    { 

//#if 1942101060 
if(associationSelector == null)//1
{ 

//#if 167077931 
associationSelector =
                new UMLSearchableComboBox(
                associationComboBoxModel,
                new ActionSetLinkAssociation(), true);
//#endif 

} 

//#endif 


//#if -502495393 
return new UMLComboBoxNavigator(
                   Translator.localize("label.association.navigate.tooltip"),
                   associationSelector);
//#endif 

} 

//#endif 


//#if 1506549639 
public PropPanelLink()
    { 

//#if 131498949 
super("label.link", lookupIcon("Link"));
//#endif 


//#if -1849984983 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if -2020233711 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 858382801 
addField(Translator.localize("label.association"),
                 getAssociationSelector());
//#endif 


//#if -1679766648 
addSeparator();
//#endif 


//#if -907393892 
JList connectionList =
            new UMLLinkedList(new UMLLinkConnectionListModel());
//#endif 


//#if 427272918 
JScrollPane connectionScroll = new JScrollPane(connectionList);
//#endif 


//#if 1946401277 
addField(Translator.localize("label.connections"),
                 connectionScroll);
//#endif 


//#if 1303506150 
addAction(new ActionNavigateNamespace());
//#endif 


//#if 452755310 
addAction(new ActionNewStereotype());
//#endif 


//#if 116562603 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1375153073 
class ActionSetLinkAssociation extends 
//#if -684324546 
UndoableAction
//#endif 

  { 

//#if 1309948241 
private static final long serialVersionUID = 6168167355078835252L;
//#endif 


//#if -2068908465 
public ActionSetLinkAssociation()
    { 

//#if 871376121 
super(Translator.localize("Set"), null);
//#endif 


//#if 828673462 
putValue(Action.SHORT_DESCRIPTION, Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if 437425483 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 713827127 
super.actionPerformed(e);
//#endif 


//#if -1245567706 
Object source = e.getSource();
//#endif 


//#if -646870573 
Object oldAssoc = null;
//#endif 


//#if 70113466 
Object newAssoc = null;
//#endif 


//#if 284830111 
Object link = null;
//#endif 


//#if 744390124 
if(source instanceof UMLComboBox2)//1
{ 

//#if -327645999 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if -1063846497 
Object o = box.getTarget();
//#endif 


//#if 109849290 
if(Model.getFacade().isALink(o))//1
{ 

//#if -535679789 
link = o;
//#endif 


//#if -1676941255 
oldAssoc = Model.getFacade().getAssociation(o);
//#endif 

} 

//#endif 


//#if 847117923 
Object n = box.getSelectedItem();
//#endif 


//#if 569725712 
if(Model.getFacade().isAAssociation(n))//1
{ 

//#if 512733172 
newAssoc = n;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -279528488 
if(newAssoc != oldAssoc && link != null && newAssoc != null)//1
{ 

//#if 1967066179 
Model.getCoreHelper().setAssociation(link, newAssoc);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -691862715 
class UMLLinkAssociationComboBoxModel extends 
//#if -1462105134 
UMLComboBoxModel2
//#endif 

  { 

//#if -780939461 
private static final long serialVersionUID = 3232437122889409351L;
//#endif 


//#if 1287114164 
protected void buildModelList()
    { 

//#if 294842295 
Collection linkEnds;
//#endif 


//#if 1110653453 
Collection associations = new HashSet();
//#endif 


//#if 1733945487 
Object t = getTarget();
//#endif 


//#if -1416252083 
if(Model.getFacade().isALink(t))//1
{ 

//#if 483301606 
linkEnds = Model.getFacade().getConnections(t);
//#endif 


//#if 1147370205 
Iterator ile = linkEnds.iterator();
//#endif 


//#if 347014223 
while (ile.hasNext()) //1
{ 

//#if -615975701 
Object instance = Model.getFacade().getInstance(ile.next());
//#endif 


//#if -1705059542 
Collection c = Model.getFacade().getClassifiers(instance);
//#endif 


//#if 405827675 
Iterator ic = c.iterator();
//#endif 


//#if -909950424 
while (ic.hasNext()) //1
{ 

//#if 1906307658 
Object classifier = ic.next();
//#endif 


//#if -428942815 
Collection ae =
                        Model.getFacade().getAssociationEnds(classifier);
//#endif 


//#if 467125350 
Iterator iae = ae.iterator();
//#endif 


//#if 1394799672 
while (iae.hasNext()) //1
{ 

//#if -1181050097 
Object associationEnd = iae.next();
//#endif 


//#if -1501295105 
Object association =
                            Model.getFacade().getAssociation(associationEnd);
//#endif 


//#if 998412253 
associations.add(association);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1480336249 
setElements(associations);
//#endif 

} 

//#endif 


//#if -763734728 
@Override
    public void modelChanged(UmlChangeEvent evt)
    { 

//#if -83161242 
Object t = getTarget();
//#endif 


//#if -378461052 
if(t != null
                && evt.getSource() == t
                && evt.getNewValue() != null)//1
{ 

//#if -1041237217 
buildModelList();
//#endif 


//#if -2079945635 
setSelectedItem(getSelectedModelElement());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1744326985 
public UMLLinkAssociationComboBoxModel()
    { 

//#if 1472125197 
super("assocation", true);
//#endif 

} 

//#endif 


//#if -1966382315 
protected boolean isValidElement(Object o)
    { 

//#if 907207720 
return Model.getFacade().isAAssociation(o);
//#endif 

} 

//#endif 


//#if 1803963200 
protected Object getSelectedModelElement()
    { 

//#if 612625312 
if(Model.getFacade().isALink(getTarget()))//1
{ 

//#if -265503521 
return Model.getFacade().getAssociation(getTarget());
//#endif 

} 

//#endif 


//#if -1190279273 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

