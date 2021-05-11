package org.argouml.uml.ui.foundation.core;
import javax.swing.JTextField;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.ActionNavigateContainerElement;
import org.argouml.uml.ui.UMLComboBox2;
import org.argouml.uml.ui.UMLTextField2;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
public class PropPanelGeneralization extends PropPanelRelationship
  { 
private static final long serialVersionUID = 2577361208291292256L;
private JTextField discriminatorTextField;
private static UMLDiscriminatorNameDocument discriminatorDocument =
        new UMLDiscriminatorNameDocument();
@Override
    public void navigateUp()
    { 
Object target = getTarget();
if(Model.getFacade().isAModelElement(target))//1
{ 
Object namespace = Model.getFacade().getNamespace(target);
if(namespace != null)//1
{ 
TargetManager.getInstance().setTarget(namespace);
} 
} 
} 
public PropPanelGeneralization()
    { 
super("label.generalization", lookupIcon("Generalization"));
addField(Translator.localize("label.name"), getNameTextField());
addField(Translator.localize("label.discriminator"),
                 getDiscriminatorTextField());
addField(Translator.localize("label.namespace"), getNamespaceSelector());
addSeparator();
addField(Translator.localize("label.parent"),
                 getSingleRowScroll(new UMLGeneralizationParentListModel()));
addField(Translator.localize("label.child"),
                 getSingleRowScroll(new UMLGeneralizationChildListModel()));
addField(Translator.localize("label.powertype"),
                 new UMLComboBox2(new UMLGeneralizationPowertypeComboBoxModel(),
                                  ActionSetGeneralizationPowertype.getInstance()));
addAction(new ActionNavigateContainerElement());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 
protected JTextField getDiscriminatorTextField()
    { 
if(discriminatorTextField == null)//1
{ 
discriminatorTextField = new UMLTextField2(discriminatorDocument);
} 
return discriminatorTextField;
} 

 } 
