
//#if 27749238 
// Compilation Unit of /PropPanelGeneralization.java 
 

//#if -1067560706 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -632174005 
import javax.swing.JTextField;
//#endif 


//#if 193039795 
import org.argouml.i18n.Translator;
//#endif 


//#if 83569145 
import org.argouml.model.Model;
//#endif 


//#if -705805623 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 213397499 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -2017474692 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 1047291520 
import org.argouml.uml.ui.UMLTextField2;
//#endif 


//#if 1130805686 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -1090194002 
public class PropPanelGeneralization extends 
//#if 1492975664 
PropPanelRelationship
//#endif 

  { 

//#if -1426542453 
private static final long serialVersionUID = 2577361208291292256L;
//#endif 


//#if 2081691181 
private JTextField discriminatorTextField;
//#endif 


//#if -1205839224 
private static UMLDiscriminatorNameDocument discriminatorDocument =
        new UMLDiscriminatorNameDocument();
//#endif 


//#if -467058835 
@Override
    public void navigateUp()
    { 

//#if 1746105705 
Object target = getTarget();
//#endif 


//#if -807741428 
if(Model.getFacade().isAModelElement(target))//1
{ 

//#if 1697927192 
Object namespace = Model.getFacade().getNamespace(target);
//#endif 


//#if 1704408198 
if(namespace != null)//1
{ 

//#if -1881987402 
TargetManager.getInstance().setTarget(namespace);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1162601196 
public PropPanelGeneralization()
    { 

//#if 1827419422 
super("label.generalization", lookupIcon("Generalization"));
//#endif 


//#if -1905801538 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 893206102 
addField(Translator.localize("label.discriminator"),
                 getDiscriminatorTextField());
//#endif 


//#if -1684015332 
addField(Translator.localize("label.namespace"), getNamespaceSelector());
//#endif 


//#if -134318051 
addSeparator();
//#endif 


//#if 1607538216 
addField(Translator.localize("label.parent"),
                 getSingleRowScroll(new UMLGeneralizationParentListModel()));
//#endif 


//#if 1860175552 
addField(Translator.localize("label.child"),
                 getSingleRowScroll(new UMLGeneralizationChildListModel()));
//#endif 


//#if 1770312800 
addField(Translator.localize("label.powertype"),
                 new UMLComboBox2(new UMLGeneralizationPowertypeComboBoxModel(),
                                  ActionSetGeneralizationPowertype.getInstance()));
//#endif 


//#if -2047951317 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -2009599495 
addAction(new ActionNewStereotype());
//#endif 


//#if 610803328 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 1808878624 
protected JTextField getDiscriminatorTextField()
    { 

//#if -1921910453 
if(discriminatorTextField == null)//1
{ 

//#if -1875077396 
discriminatorTextField = new UMLTextField2(discriminatorDocument);
//#endif 

} 

//#endif 


//#if -891327814 
return discriminatorTextField;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

