
//#if -890802653 
// Compilation Unit of /PropPanelAttribute.java 
 

//#if -59627718 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -845122180 
import java.util.List;
//#endif 


//#if -1723021384 
import javax.swing.JPanel;
//#endif 


//#if -2082188635 
import javax.swing.JScrollPane;
//#endif 


//#if -252032022 
import javax.swing.ScrollPaneConstants;
//#endif 


//#if -1887608849 
import org.argouml.i18n.Translator;
//#endif 


//#if 961641013 
import org.argouml.model.Model;
//#endif 


//#if -1513460425 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 1997168226 
import org.argouml.uml.ui.ActionNavigateUpNextDown;
//#endif 


//#if 1040732894 
import org.argouml.uml.ui.ActionNavigateUpPreviousDown;
//#endif 


//#if 628044627 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if -1318638515 
import org.argouml.uml.ui.UMLExpressionBodyField;
//#endif 


//#if 383717507 
import org.argouml.uml.ui.UMLExpressionLanguageField;
//#endif 


//#if 1330875880 
import org.argouml.uml.ui.UMLExpressionModel2;
//#endif 


//#if -516632042 
import org.argouml.uml.ui.UMLUserInterfaceContainer;
//#endif 


//#if -832284166 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -1235706770 
public class PropPanelAttribute extends 
//#if -1662586629 
PropPanelStructuralFeature
//#endif 

  { 

//#if 1335173249 
private static final long serialVersionUID = -5596689167193050170L;
//#endif 


//#if 2112780648 
public PropPanelAttribute()
    { 

//#if 906909976 
super("label.attribute", lookupIcon("Attribute"));
//#endif 


//#if -315018754 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if -435873545 
addField(Translator.localize("label.type"),
                 new UMLComboBoxNavigator(
                     Translator.localize("label.class.navigate.tooltip"),
                     getTypeComboBox()));
//#endif 


//#if -1009800902 
addField(Translator.localize("label.multiplicity"),
                 getMultiplicityComboBox());
//#endif 


//#if -1206286262 
addField(Translator.localize("label.owner"),
                 getOwnerScroll());
//#endif 


//#if 230160399 
add(getVisibilityPanel());
//#endif 


//#if -334797987 
addSeparator();
//#endif 


//#if 1531370382 
add(getChangeabilityRadioButtonPanel());
//#endif 


//#if -502230862 
JPanel modifiersPanel = createBorderPanel(
                                    Translator.localize("label.modifiers"));
//#endif 


//#if -768852359 
modifiersPanel.add(getOwnerScopeCheckbox());
//#endif 


//#if -715284902 
add(modifiersPanel);
//#endif 


//#if 539257023 
UMLExpressionModel2 initialModel = new UMLInitialValueExpressionModel(
            this, "initialValue");
//#endif 


//#if 1851529062 
JPanel initialPanel = createBorderPanel(Translator
                                                .localize("label.initial-value"));
//#endif 


//#if -560210481 
JScrollPane jsp = new JScrollPane(new UMLExpressionBodyField(
                                              initialModel, true));
//#endif 


//#if 2073884116 
jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//#endif 


//#if -2146293896 
jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
//#endif 


//#if -2028556931 
initialPanel.add(jsp);
//#endif 


//#if -838659887 
initialPanel.add(new UMLExpressionLanguageField(initialModel,
                         false));
//#endif 


//#if -2091778414 
add(initialPanel);
//#endif 


//#if -914445973 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -2055326707 
addAction(new ActionNavigateUpPreviousDown() {
            public List getFamily(Object parent) {
                if (Model.getFacade().isAAssociationEnd(parent)) {
                    return Model.getFacade().getQualifiers(parent);
                }
                return Model.getFacade().getAttributes(parent);
            }

            public Object getParent(Object child) {
                return Model.getFacade().getModelElementContainer(child);
            }
        });
//#endif 


//#if -638534903 
addAction(new ActionNavigateUpNextDown() {
            public List getFamily(Object parent) {
                if (Model.getFacade().isAAssociationEnd(parent)) {
                    return Model.getFacade().getQualifiers(parent);
                }
                return Model.getFacade().getAttributes(parent);
            }

            public Object getParent(Object child) {
                return Model.getFacade().getModelElementContainer(child);
            }
        });
//#endif 


//#if 514507802 
addAction(new ActionAddAttribute());
//#endif 


//#if -1503829236 
addAction(new ActionAddDataType());
//#endif 


//#if -1350033531 
addAction(new ActionAddEnumeration());
//#endif 


//#if 929730233 
addAction(new ActionNewStereotype());
//#endif 


//#if -187147840 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 1606829768 
private class UMLInitialValueExpressionModel extends 
//#if -800335728 
UMLExpressionModel2
//#endif 

  { 

//#if 1372015170 
public void setExpression(Object expression)
        { 

//#if -1138354420 
Object target = getTarget();
//#endif 


//#if -1470973513 
if(target == null)//1
{ 

//#if 948040725 
throw new IllegalStateException(
                    "There is no target for " + getContainer());
//#endif 

} 

//#endif 


//#if 170632969 
Model.getCoreHelper().setInitialValue(target, expression);
//#endif 

} 

//#endif 


//#if 1702066800 
public UMLInitialValueExpressionModel(
            UMLUserInterfaceContainer container,
            String propertyName)
        { 

//#if 55412224 
super(container, propertyName);
//#endif 

} 

//#endif 


//#if -1512869588 
public Object newExpression()
        { 

//#if -450305419 
return Model.getDataTypesFactory().createExpression("", "");
//#endif 

} 

//#endif 


//#if 1699378658 
public Object getExpression()
        { 

//#if 42994785 
Object target = getTarget();
//#endif 


//#if 761303756 
if(target == null)//1
{ 

//#if -895629875 
return null;
//#endif 

} 

//#endif 


//#if 1364935609 
return Model.getFacade().getInitialValue(target);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

