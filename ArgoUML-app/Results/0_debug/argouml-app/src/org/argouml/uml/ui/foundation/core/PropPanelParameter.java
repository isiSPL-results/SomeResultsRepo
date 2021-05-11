
//#if 1865656558 
// Compilation Unit of /PropPanelParameter.java 
 

//#if 2044311973 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1520314831 
import java.util.List;
//#endif 


//#if -78330387 
import javax.swing.JPanel;
//#endif 


//#if 396094864 
import javax.swing.JScrollPane;
//#endif 


//#if -154694310 
import org.argouml.i18n.Translator;
//#endif 


//#if -855042784 
import org.argouml.model.Model;
//#endif 


//#if -902684606 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -734009246 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -1655024179 
import org.argouml.uml.ui.ActionNavigateUpNextDown;
//#endif 


//#if 1130929353 
import org.argouml.uml.ui.ActionNavigateUpPreviousDown;
//#endif 


//#if 1528798115 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -1349254536 
import org.argouml.uml.ui.UMLExpressionBodyField;
//#endif 


//#if -384902866 
import org.argouml.uml.ui.UMLExpressionLanguageField;
//#endif 


//#if -954507363 
import org.argouml.uml.ui.UMLExpressionModel2;
//#endif 


//#if -2065446901 
import org.argouml.uml.ui.UMLUserInterfaceContainer;
//#endif 


//#if -2077222993 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 364415710 
class UMLDefaultValueExpressionModel extends 
//#if -1205002842 
UMLExpressionModel2
//#endif 

  { 

//#if 1769601752 
public void setExpression(Object expression)
    { 

//#if -1644618878 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if -558935207 
if(target == null)//1
{ 

//#if 1181522668 
throw new IllegalStateException(
                "There is no target for " + getContainer());
//#endif 

} 

//#endif 


//#if -1192730930 
Model.getCoreHelper().setDefaultValue(target, expression);
//#endif 

} 

//#endif 


//#if -89640343 
public UMLDefaultValueExpressionModel(UMLUserInterfaceContainer container,
                                          String propertyName)
    { 

//#if -1799237560 
super(container, propertyName);
//#endif 

} 

//#endif 


//#if 1283539010 
public Object newExpression()
    { 

//#if 515843729 
return Model.getDataTypesFactory().createExpression("", "");
//#endif 

} 

//#endif 


//#if 200819960 
public Object getExpression()
    { 

//#if -2125771754 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if 1058531565 
if(target == null)//1
{ 

//#if -358692098 
return null;
//#endif 

} 

//#endif 


//#if -1954296459 
return Model.getFacade().getDefaultValue(target);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 785613104 
public class PropPanelParameter extends 
//#if 810281603 
PropPanelModelElement
//#endif 

  { 

//#if -424890596 
private static final long serialVersionUID = -1207518946939283220L;
//#endif 


//#if -1406143887 
private JPanel behFeatureScroll;
//#endif 


//#if 569611658 
private static UMLParameterBehavioralFeatListModel behFeatureModel;
//#endif 


//#if 1101547683 
public PropPanelParameter()
    { 

//#if -133513896 
super("label.parameter", lookupIcon("Parameter"));
//#endif 


//#if -631726882 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 1914932976 
addField(Translator.localize("label.owner"),
                 getBehavioralFeatureScroll());
//#endif 


//#if 411045437 
addSeparator();
//#endif 


//#if -760339889 
addField(Translator.localize("label.type"),
                 new UMLComboBox2(new UMLParameterTypeComboBoxModel(),
                                  ActionSetParameterType.getInstance()));
//#endif 


//#if -265196932 
UMLExpressionModel2 defaultModel = new UMLDefaultValueExpressionModel(
            this, "defaultValue");
//#endif 


//#if -2072327173 
JPanel defaultPanel = createBorderPanel(Translator
                                                .localize("label.parameter.default-value"));
//#endif 


//#if -1616838632 
defaultPanel.add(new JScrollPane(new UMLExpressionBodyField(
                                             defaultModel, true)));
//#endif 


//#if -1162083247 
defaultPanel.add(new UMLExpressionLanguageField(defaultModel,
                         false));
//#endif 


//#if 24642069 
add(defaultPanel);
//#endif 


//#if -2138569761 
add(new UMLParameterDirectionKindRadioButtonPanel(
                Translator.localize("label.parameter.kind"), true));
//#endif 


//#if -2054171573 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -1521320638 
addAction(new ActionNavigateUpPreviousDown() {
            public List getFamily(Object parent) {
                return Model.getFacade().getParametersList(parent);
            }

            public Object getParent(Object child) {
                return Model.getFacade().getModelElementContainer(child);
            }

            public boolean isEnabled() {
                return (Model.getFacade().isABehavioralFeature(getTarget())
                        || Model.getFacade().isAEvent(getTarget())
                       ) && super.isEnabled();
            }
        });
//#endif 


//#if 450648774 
addAction(new ActionNavigateUpNextDown() {
            public List getFamily(Object parent) {
                return Model.getFacade().getParametersList(parent);
            }

            public Object getParent(Object child) {
                return Model.getFacade().getModelElementContainer(child);
            }

            public boolean isEnabled() {
                return (Model.getFacade().isABehavioralFeature(getTarget())
                        || Model.getFacade().isAEvent(getTarget())
                       ) && super.isEnabled();
            }
        });
//#endif 


//#if -210198808 
addAction(new ActionNewParameter());
//#endif 


//#if 1130368044 
addAction(new ActionAddDataType());
//#endif 


//#if 673669733 
addAction(new ActionAddEnumeration());
//#endif 


//#if -1637388327 
addAction(new ActionNewStereotype());
//#endif 


//#if -1697088352 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -2137912379 
public JPanel getBehavioralFeatureScroll()
    { 

//#if 1205086522 
if(behFeatureScroll == null)//1
{ 

//#if 1004822240 
if(behFeatureModel == null)//1
{ 

//#if -1825177522 
behFeatureModel = new UMLParameterBehavioralFeatListModel();
//#endif 

} 

//#endif 


//#if 409252742 
behFeatureScroll = getSingleRowScroll(behFeatureModel);
//#endif 

} 

//#endif 


//#if -567906001 
return behFeatureScroll;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

