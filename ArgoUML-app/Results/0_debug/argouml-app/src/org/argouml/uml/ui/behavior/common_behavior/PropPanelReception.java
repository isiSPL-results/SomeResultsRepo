
//#if -1042069946 
// Compilation Unit of /PropPanelReception.java 
 

//#if -977036478 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 1922786338 
import javax.swing.JPanel;
//#endif 


//#if 876144763 
import javax.swing.JScrollPane;
//#endif 


//#if 893852357 
import org.argouml.i18n.Translator;
//#endif 


//#if 1780125595 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if -308100211 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 1546017355 
import org.argouml.uml.ui.UMLTextArea2;
//#endif 


//#if -829245498 
import org.argouml.uml.ui.foundation.core.PropPanelFeature;
//#endif 


//#if 1877731317 
import org.argouml.uml.ui.foundation.core.UMLBehavioralFeatureQueryCheckBox;
//#endif 


//#if -524466187 
import org.argouml.uml.ui.foundation.core.UMLFeatureOwnerScopeCheckBox;
//#endif 


//#if 801869497 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementAbstractCheckBox;
//#endif 


//#if 1276550269 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementLeafCheckBox;
//#endif 


//#if -1331744903 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementRootCheckBox;
//#endif 


//#if 2066380132 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -31823861 
public class PropPanelReception extends 
//#if -1617682854 
PropPanelFeature
//#endif 

  { 

//#if -822324936 
private static final long serialVersionUID = -8572743081899344540L;
//#endif 


//#if 1156068603 
private JPanel modifiersPanel;
//#endif 


//#if -171654755 
public PropPanelReception()
    { 

//#if -1332837263 
super("label.reception", lookupIcon("Reception"));
//#endif 


//#if -1983807753 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if 1095186481 
addField(Translator.localize("label.owner"),
                 getOwnerScroll());
//#endif 


//#if 1642008438 
add(getVisibilityPanel());
//#endif 


//#if -826339771 
modifiersPanel = createBorderPanel(Translator.localize(
                                               "label.modifiers"));
//#endif 


//#if 181267874 
modifiersPanel.add(new UMLGeneralizableElementAbstractCheckBox());
//#endif 


//#if -1094756386 
modifiersPanel.add(new UMLGeneralizableElementLeafCheckBox());
//#endif 


//#if -267906206 
modifiersPanel.add(new UMLGeneralizableElementRootCheckBox());
//#endif 


//#if 678244518 
modifiersPanel.add(new UMLBehavioralFeatureQueryCheckBox());
//#endif 


//#if 1831051052 
modifiersPanel.add(new UMLFeatureOwnerScopeCheckBox());
//#endif 


//#if 1021841153 
add(modifiersPanel);
//#endif 


//#if -376904106 
addSeparator();
//#endif 


//#if -828749082 
addField(Translator.localize("label.signal"),
                 new UMLReceptionSignalComboBox(this,
                                                new UMLReceptionSignalComboBoxModel()));
//#endif 


//#if -240176181 
UMLTextArea2 specText = new UMLTextArea2(
            new UMLReceptionSpecificationDocument());
//#endif 


//#if -313858706 
specText.setLineWrap(true);
//#endif 


//#if 1431082164 
specText.setRows(5);
//#endif 


//#if 1180117052 
specText.setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 


//#if -621962409 
JScrollPane specificationScroll = new JScrollPane(specText);
//#endif 


//#if -1303125602 
addField(Translator.localize("label.specification"),
                 specificationScroll);
//#endif 


//#if -2025191324 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 988074336 
addAction(new ActionNewStereotype());
//#endif 


//#if -436947719 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

