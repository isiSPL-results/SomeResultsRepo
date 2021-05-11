// Compilation Unit of /PropPanelStructuralFeature.java 
 
package org.argouml.uml.ui.foundation.core;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.argouml.i18n.Translator;
import org.argouml.uml.ui.UMLCheckBox2;
import org.argouml.uml.ui.UMLComboBox2;
import org.argouml.uml.ui.UMLMultiplicityPanel;
import org.argouml.uml.ui.UMLRadioButtonPanel;
public class PropPanelStructuralFeature extends PropPanelFeature
  { 
private JPanel multiplicityComboBox;
private UMLComboBox2 typeComboBox;
private UMLRadioButtonPanel changeabilityRadioButtonPanel;
private UMLCheckBox2 targetScopeCheckBox;
private static UMLStructuralFeatureTypeComboBoxModel typeComboBoxModel;
public UMLRadioButtonPanel getChangeabilityRadioButtonPanel()
    { 
if(changeabilityRadioButtonPanel == null)//1
{ 
changeabilityRadioButtonPanel =
                new UMLStructuralFeatureChangeabilityRadioButtonPanel(
                Translator.localize("label.changeability"),
                true);
} 

return changeabilityRadioButtonPanel;
} 

public JPanel getMultiplicityComboBox()
    { 
if(multiplicityComboBox == null)//1
{ 
multiplicityComboBox =
                new UMLMultiplicityPanel();
} 

return multiplicityComboBox;
} 

public UMLComboBox2 getTypeComboBox()
    { 
if(typeComboBox == null)//1
{ 
if(typeComboBoxModel == null)//1
{ 
typeComboBoxModel =
                    new UMLStructuralFeatureTypeComboBoxModel();
} 

typeComboBox =
                new UMLComboBox2(
                typeComboBoxModel,
                ActionSetStructuralFeatureType.getInstance());
} 

return typeComboBox;
} 

@Deprecated
    public UMLCheckBox2 getTargetScopeCheckBox()
    { 
if(targetScopeCheckBox == null)//1
{ 
targetScopeCheckBox = new UMLStructuralFeatureTargetScopeCheckBox();
} 

return targetScopeCheckBox;
} 

protected PropPanelStructuralFeature(String name, ImageIcon icon)
    { 
super(name, icon);
} 

 } 


