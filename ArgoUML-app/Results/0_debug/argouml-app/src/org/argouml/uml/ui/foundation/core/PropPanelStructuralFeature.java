
//#if 394381849 
// Compilation Unit of /PropPanelStructuralFeature.java 
 

//#if 1024460541 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -2066151437 
import javax.swing.ImageIcon;
//#endif 


//#if -1689797227 
import javax.swing.JPanel;
//#endif 


//#if 1399632562 
import org.argouml.i18n.Translator;
//#endif 


//#if -861094463 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -343780101 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -441390933 
import org.argouml.uml.ui.UMLMultiplicityPanel;
//#endif 


//#if -341470737 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if -1037475448 
public class PropPanelStructuralFeature extends 
//#if -1071068085 
PropPanelFeature
//#endif 

  { 

//#if -645066728 
private JPanel multiplicityComboBox;
//#endif 


//#if -1018046826 
private UMLComboBox2 typeComboBox;
//#endif 


//#if -496806392 
private UMLRadioButtonPanel changeabilityRadioButtonPanel;
//#endif 


//#if -1519793155 
private UMLCheckBox2 targetScopeCheckBox;
//#endif 


//#if 4662203 
private static UMLStructuralFeatureTypeComboBoxModel typeComboBoxModel;
//#endif 


//#if -72206136 
public UMLRadioButtonPanel getChangeabilityRadioButtonPanel()
    { 

//#if -33325077 
if(changeabilityRadioButtonPanel == null)//1
{ 

//#if -1802299488 
changeabilityRadioButtonPanel =
                new UMLStructuralFeatureChangeabilityRadioButtonPanel(
                Translator.localize("label.changeability"),
                true);
//#endif 

} 

//#endif 


//#if 1115710960 
return changeabilityRadioButtonPanel;
//#endif 

} 

//#endif 


//#if -357508166 
public JPanel getMultiplicityComboBox()
    { 

//#if 553261268 
if(multiplicityComboBox == null)//1
{ 

//#if 1074400583 
multiplicityComboBox =
                new UMLMultiplicityPanel();
//#endif 

} 

//#endif 


//#if -1707332019 
return multiplicityComboBox;
//#endif 

} 

//#endif 


//#if -1957770610 
public UMLComboBox2 getTypeComboBox()
    { 

//#if 1254335678 
if(typeComboBox == null)//1
{ 

//#if -978861623 
if(typeComboBoxModel == null)//1
{ 

//#if -111920345 
typeComboBoxModel =
                    new UMLStructuralFeatureTypeComboBoxModel();
//#endif 

} 

//#endif 


//#if 406369483 
typeComboBox =
                new UMLComboBox2(
                typeComboBoxModel,
                ActionSetStructuralFeatureType.getInstance());
//#endif 

} 

//#endif 


//#if 473953825 
return typeComboBox;
//#endif 

} 

//#endif 


//#if -1542521710 
@Deprecated
    public UMLCheckBox2 getTargetScopeCheckBox()
    { 

//#if 224519980 
if(targetScopeCheckBox == null)//1
{ 

//#if -1588323271 
targetScopeCheckBox = new UMLStructuralFeatureTargetScopeCheckBox();
//#endif 

} 

//#endif 


//#if 1775605223 
return targetScopeCheckBox;
//#endif 

} 

//#endif 


//#if -647938060 
protected PropPanelStructuralFeature(String name, ImageIcon icon)
    { 

//#if -1159387046 
super(name, icon);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

