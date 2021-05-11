// Compilation Unit of /PropPanelLink.java 
 
package org.argouml.uml.ui.behavior.common_behavior;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.model.UmlChangeEvent;
import org.argouml.uml.ui.ActionNavigateNamespace;
import org.argouml.uml.ui.UMLComboBox2;
import org.argouml.uml.ui.UMLComboBoxModel2;
import org.argouml.uml.ui.UMLComboBoxNavigator;
import org.argouml.uml.ui.UMLLinkedList;
import org.argouml.uml.ui.UMLSearchableComboBox;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
import org.tigris.gef.undo.UndoableAction;
public class PropPanelLink extends PropPanelModelElement
  { 
private JComboBox associationSelector;
private UMLLinkAssociationComboBoxModel associationComboBoxModel =
        new UMLLinkAssociationComboBoxModel();
private static final long serialVersionUID = 8861148331491989705L;
protected JComponent getAssociationSelector()
    { 
if(associationSelector == null)//1
{ 
associationSelector =
                new UMLSearchableComboBox(
                associationComboBoxModel,
                new ActionSetLinkAssociation(), true);
} 

return new UMLComboBoxNavigator(
                   Translator.localize("label.association.navigate.tooltip"),
                   associationSelector);
} 

public PropPanelLink()
    { 
super("label.link", lookupIcon("Link"));
addField(Translator.localize("label.name"),
                 getNameTextField());
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
addField(Translator.localize("label.association"),
                 getAssociationSelector());
addSeparator();
JList connectionList =
            new UMLLinkedList(new UMLLinkConnectionListModel());
JScrollPane connectionScroll = new JScrollPane(connectionList);
addField(Translator.localize("label.connections"),
                 connectionScroll);
addAction(new ActionNavigateNamespace());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 

 } 

class ActionSetLinkAssociation extends UndoableAction
  { 
private static final long serialVersionUID = 6168167355078835252L;
public ActionSetLinkAssociation()
    { 
super(Translator.localize("Set"), null);
putValue(Action.SHORT_DESCRIPTION, Translator.localize("Set"));
} 

@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object source = e.getSource();
Object oldAssoc = null;
Object newAssoc = null;
Object link = null;
if(source instanceof UMLComboBox2)//1
{ 
UMLComboBox2 box = (UMLComboBox2) source;
Object o = box.getTarget();
if(Model.getFacade().isALink(o))//1
{ 
link = o;
oldAssoc = Model.getFacade().getAssociation(o);
} 

Object n = box.getSelectedItem();
if(Model.getFacade().isAAssociation(n))//1
{ 
newAssoc = n;
} 

} 

if(newAssoc != oldAssoc && link != null && newAssoc != null)//1
{ 
Model.getCoreHelper().setAssociation(link, newAssoc);
} 

} 

 } 

class UMLLinkAssociationComboBoxModel extends UMLComboBoxModel2
  { 
private static final long serialVersionUID = 3232437122889409351L;
protected void buildModelList()
    { 
Collection linkEnds;
Collection associations = new HashSet();
Object t = getTarget();
if(Model.getFacade().isALink(t))//1
{ 
linkEnds = Model.getFacade().getConnections(t);
Iterator ile = linkEnds.iterator();
while (ile.hasNext()) //1
{ 
Object instance = Model.getFacade().getInstance(ile.next());
Collection c = Model.getFacade().getClassifiers(instance);
Iterator ic = c.iterator();
while (ic.hasNext()) //1
{ 
Object classifier = ic.next();
Collection ae =
                        Model.getFacade().getAssociationEnds(classifier);
Iterator iae = ae.iterator();
while (iae.hasNext()) //1
{ 
Object associationEnd = iae.next();
Object association =
                            Model.getFacade().getAssociation(associationEnd);
associations.add(association);
} 

} 

} 

} 

setElements(associations);
} 

@Override
    public void modelChanged(UmlChangeEvent evt)
    { 
Object t = getTarget();
if(t != null
                && evt.getSource() == t
                && evt.getNewValue() != null)//1
{ 
buildModelList();
setSelectedItem(getSelectedModelElement());
} 

} 

public UMLLinkAssociationComboBoxModel()
    { 
super("assocation", true);
} 

protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAAssociation(o);
} 

protected Object getSelectedModelElement()
    { 
if(Model.getFacade().isALink(getTarget()))//1
{ 
return Model.getFacade().getAssociation(getTarget());
} 

return null;
} 

 } 


