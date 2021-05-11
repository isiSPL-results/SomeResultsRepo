
//#if 1876386400 
// Compilation Unit of /PropPanelAction.java 
 

//#if 2036465067 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 1049075289 
import java.awt.event.ActionEvent;
//#endif 


//#if -338357041 
import javax.swing.Action;
//#endif 


//#if 1273993725 
import javax.swing.ImageIcon;
//#endif 


//#if 1472114633 
import javax.swing.JList;
//#endif 


//#if -1502119989 
import javax.swing.JPanel;
//#endif 


//#if -1772898702 
import javax.swing.JScrollPane;
//#endif 


//#if -1006351109 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1355552060 
import org.argouml.i18n.Translator;
//#endif 


//#if 1270930946 
import org.argouml.model.Model;
//#endif 


//#if -1233872864 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1606025323 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -1159824700 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 995366618 
import org.argouml.uml.ui.UMLExpressionBodyField;
//#endif 


//#if -1274418032 
import org.argouml.uml.ui.UMLExpressionLanguageField;
//#endif 


//#if 1000371835 
import org.argouml.uml.ui.UMLExpressionModel2;
//#endif 


//#if 365361797 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 2020275801 
import org.argouml.uml.ui.UMLRecurrenceExpressionModel;
//#endif 


//#if -1478820492 
import org.argouml.uml.ui.UMLScriptExpressionModel;
//#endif 


//#if -800042800 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if 1341273741 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 2031966483 
public abstract class PropPanelAction extends 
//#if -1341835582 
PropPanelModelElement
//#endif 

  { 

//#if -1259529189 
protected JScrollPane argumentsScroll;
//#endif 


//#if -273050112 
public void initialize()
    { 

//#if 589591647 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 261979143 
add(new UMLActionAsynchronousCheckBox());
//#endif 


//#if 689509027 
UMLExpressionModel2 scriptModel =
            new UMLScriptExpressionModel(
            this, "script");
//#endif 


//#if -1818940973 
JPanel scriptPanel = createBorderPanel(Translator
                                               .localize("label.script"));
//#endif 


//#if 704889759 
scriptPanel.add(new JScrollPane(new UMLExpressionBodyField(
                                            scriptModel, true)));
//#endif 


//#if -68819700 
scriptPanel.add(new UMLExpressionLanguageField(scriptModel,
                        false));
//#endif 


//#if 1949545164 
add(scriptPanel);
//#endif 


//#if 2073406548 
UMLExpressionModel2 recurrenceModel =
            new UMLRecurrenceExpressionModel(
            this, "recurrence");
//#endif 


//#if 453193075 
JPanel recurrencePanel = createBorderPanel(Translator
                                 .localize("label.recurrence"));
//#endif 


//#if 448864575 
recurrencePanel.add(new JScrollPane(new UMLExpressionBodyField(
                                                recurrenceModel, true)));
//#endif 


//#if -53408234 
recurrencePanel.add(new UMLExpressionLanguageField(
                                recurrenceModel, false));
//#endif 


//#if 1708655687 
add(recurrencePanel);
//#endif 


//#if -2059187266 
addSeparator();
//#endif 


//#if -1387934765 
JList argumentsList = new UMLLinkedList(
            new UMLActionArgumentListModel());
//#endif 


//#if -345493354 
argumentsList.setVisibleRowCount(5);
//#endif 


//#if 135215727 
argumentsScroll = new JScrollPane(argumentsList);
//#endif 


//#if 850477100 
addField(Translator.localize("label.arguments"),
                 argumentsScroll);
//#endif 


//#if -137048628 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 928175257 
addAction(new ActionCreateArgument());
//#endif 


//#if -2141233928 
addAction(new ActionNewStereotype());
//#endif 


//#if 1812747108 
addExtraActions();
//#endif 


//#if -2042788767 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 1145406109 
public PropPanelAction()
    { 

//#if 1510797954 
this("label.action", null);
//#endif 

} 

//#endif 


//#if 2088800511 
protected void addExtraActions()
    { 
} 

//#endif 


//#if 1122383584 
public PropPanelAction(String name, ImageIcon icon)
    { 

//#if -2000810872 
super(name, icon);
//#endif 


//#if -1364549805 
initialize();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 102015358 
class ActionCreateArgument extends 
//#if 1696186950 
AbstractActionNewModelElement
//#endif 

  { 

//#if -159655241 
private static final long serialVersionUID = -3455108052199995234L;
//#endif 


//#if -1794027474 
public ActionCreateArgument()
    { 

//#if 1334381052 
super("button.new-argument");
//#endif 


//#if -426713584 
putValue(Action.NAME,
                 Translator.localize("button.new-argument"));
//#endif 


//#if 839278829 
putValue(Action.SMALL_ICON,
                 ResourceLoaderWrapper.lookupIcon("NewParameter"));
//#endif 

} 

//#endif 


//#if 1388565430 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 508012561 
Object t = TargetManager.getInstance().getTarget();
//#endif 


//#if -1997681373 
if(Model.getFacade().isAAction(t))//1
{ 

//#if 1197239600 
Object argument = Model.getCommonBehaviorFactory().createArgument();
//#endif 


//#if -213826443 
Model.getCommonBehaviorHelper().addActualArgument(t, argument);
//#endif 


//#if -684087239 
TargetManager.getInstance().setTarget(argument);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

