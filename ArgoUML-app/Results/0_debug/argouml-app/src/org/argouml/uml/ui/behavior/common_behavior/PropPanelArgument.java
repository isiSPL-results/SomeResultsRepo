
//#if 815014267 
// Compilation Unit of /PropPanelArgument.java 
 

//#if 1742912536 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -1360646683 
import javax.swing.JScrollPane;
//#endif 


//#if 52899520 
import javax.swing.JTextArea;
//#endif 


//#if 1671404335 
import org.argouml.i18n.Translator;
//#endif 


//#if 1683266949 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if -1133739620 
import org.argouml.uml.ui.ActionNavigateAction;
//#endif 


//#if -1436502131 
import org.argouml.uml.ui.UMLExpressionBodyField;
//#endif 


//#if -525685708 
import org.argouml.uml.ui.UMLExpressionExpressionModel;
//#endif 


//#if -1784611901 
import org.argouml.uml.ui.UMLExpressionLanguageField;
//#endif 


//#if -814232920 
import org.argouml.uml.ui.UMLExpressionModel2;
//#endif 


//#if -881994819 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if 2013238763 
public class PropPanelArgument extends 
//#if 273031671 
PropPanelModelElement
//#endif 

  { 

//#if -1041184831 
private static final long serialVersionUID = 6737211630130267264L;
//#endif 


//#if 1547961497 
public PropPanelArgument()
    { 

//#if 19036940 
super("label.argument", lookupIcon("Argument"));
//#endif 


//#if -1371162454 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if -827912079 
UMLExpressionModel2 expressionModel =
            new UMLExpressionExpressionModel(
            this, "expression");
//#endif 


//#if -4657566 
JTextArea ebf = new UMLExpressionBodyField(expressionModel, true);
//#endif 


//#if 487199016 
ebf.setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 


//#if 1549329606 
ebf.setRows(3);
//#endif 


//#if -346981800 
addField(Translator.localize("label.value"),
                 new JScrollPane(ebf));
//#endif 


//#if -130795454 
addField(Translator.localize("label.language"),
                 new UMLExpressionLanguageField(expressionModel, true));
//#endif 


//#if -46544686 
addAction(new ActionNavigateAction());
//#endif 


//#if 2038451052 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

