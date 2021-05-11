// Compilation Unit of /PropPanelClassifier.java 
 
package org.argouml.uml.ui.foundation.core;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.argouml.i18n.Translator;
import org.argouml.uml.ui.ScrollList;
import org.argouml.uml.ui.UMLDerivedCheckBox;
import org.argouml.uml.ui.behavior.common_behavior.ActionNewReception;
public abstract class PropPanelClassifier extends PropPanelNamespace
  { 
private JPanel modifiersPanel;
private ActionNewReception actionNewReception = new ActionNewReception();
private JScrollPane generalizationScroll;
private JScrollPane specializationScroll;
private JScrollPane featureScroll;
private JScrollPane createActionScroll;
private JScrollPane powerTypeRangeScroll;
private JScrollPane associationEndScroll;
private JScrollPane attributeScroll;
private JScrollPane operationScroll;
private static UMLGeneralizableElementGeneralizationListModel
    generalizationListModel =
        new UMLGeneralizableElementGeneralizationListModel();
private static UMLGeneralizableElementSpecializationListModel
    specializationListModel =
        new UMLGeneralizableElementSpecializationListModel();
private static UMLClassifierFeatureListModel featureListModel =
        new UMLClassifierFeatureListModel();
private static UMLClassifierCreateActionListModel createActionListModel =
        new UMLClassifierCreateActionListModel();
private static UMLClassifierPowertypeRangeListModel
    powertypeRangeListModel =
        new UMLClassifierPowertypeRangeListModel();
private static UMLClassifierAssociationEndListModel
    associationEndListModel =
        new UMLClassifierAssociationEndListModel();
private static UMLClassAttributeListModel attributeListModel =
        new UMLClassAttributeListModel();
private static UMLClassOperationListModel operationListModel =
        new UMLClassOperationListModel();
public JScrollPane getFeatureScroll()
    { 
if(featureScroll == null)//1
{ 
featureScroll = new ScrollList(featureListModel, true, false);
} 

return featureScroll;
} 

protected ActionNewReception getActionNewReception()
    { 
return actionNewReception;
} 

public JScrollPane getAttributeScroll()
    { 
if(attributeScroll == null)//1
{ 
attributeScroll = new ScrollList(attributeListModel, true, false);
} 

return attributeScroll;
} 

public JScrollPane getOperationScroll()
    { 
if(operationScroll == null)//1
{ 
operationScroll = new ScrollList(operationListModel, true, false);
} 

return operationScroll;
} 

public JScrollPane getGeneralizationScroll()
    { 
if(generalizationScroll == null)//1
{ 
generalizationScroll = new ScrollList(generalizationListModel);
} 

return generalizationScroll;
} 

private void initialize()
    { 
modifiersPanel =
            createBorderPanel(Translator.localize("label.modifiers"));
modifiersPanel.add(new UMLGeneralizableElementAbstractCheckBox());
modifiersPanel.add(new UMLGeneralizableElementLeafCheckBox());
modifiersPanel.add(new UMLGeneralizableElementRootCheckBox());
modifiersPanel.add(new UMLDerivedCheckBox());
} 

public PropPanelClassifier(String name, ImageIcon icon)
    { 
super(name, icon);
initialize();
} 

public JScrollPane getCreateActionScroll()
    { 
if(createActionScroll == null)//1
{ 
createActionScroll = new ScrollList(createActionListModel);
} 

return createActionScroll;
} 

public JScrollPane getAssociationEndScroll()
    { 
if(associationEndScroll == null)//1
{ 
associationEndScroll = new ScrollList(associationEndListModel);
} 

return associationEndScroll;
} 

public JScrollPane getPowerTypeRangeScroll()
    { 
if(powerTypeRangeScroll == null)//1
{ 
powerTypeRangeScroll = new ScrollList(powertypeRangeListModel);
} 

return powerTypeRangeScroll;
} 

protected JPanel getModifiersPanel()
    { 
return modifiersPanel;
} 

public JScrollPane getSpecializationScroll()
    { 
if(specializationScroll == null)//1
{ 
specializationScroll = new ScrollList(specializationListModel);
} 

return specializationScroll;
} 

 } 


