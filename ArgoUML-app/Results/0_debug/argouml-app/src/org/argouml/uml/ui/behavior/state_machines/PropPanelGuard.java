
//#if 524955844 
// Compilation Unit of /PropPanelGuard.java 
 

//#if 1538686264 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1139752226 
import javax.swing.JPanel;
//#endif 


//#if 876437311 
import javax.swing.JScrollPane;
//#endif 


//#if 2070867610 
import javax.swing.JTextArea;
//#endif 


//#if -155983009 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if 594752311 
import org.argouml.uml.ui.ActionNavigateTransition;
//#endif 


//#if 311690855 
import org.argouml.uml.ui.UMLExpressionBodyField;
//#endif 


//#if 1220145038 
import org.argouml.uml.ui.UMLExpressionExpressionModel;
//#endif 


//#if 58543517 
import org.argouml.uml.ui.UMLExpressionLanguageField;
//#endif 


//#if 1241545230 
import org.argouml.uml.ui.UMLExpressionModel2;
//#endif 


//#if 514569635 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if -1469632992 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -1710439267 
public class PropPanelGuard extends 
//#if 1124056521 
PropPanelModelElement
//#endif 

  { 

//#if -895285372 
private static final long serialVersionUID = 3698249606426850936L;
//#endif 


//#if 1945206425 
public PropPanelGuard()
    { 

//#if 1711916458 
super("label.guard", lookupIcon("Guard"));
//#endif 


//#if 1154850184 
addField("label.name", getNameTextField());
//#endif 


//#if -1900985823 
addField("label.transition", new JScrollPane(
                     getSingleRowScroll(new UMLGuardTransitionListModel())));
//#endif 


//#if 1246006415 
addSeparator();
//#endif 


//#if 202885819 
JPanel exprPanel = createBorderPanel("label.expression");
//#endif 


//#if 1821664043 
UMLExpressionModel2 expressionModel = new UMLExpressionExpressionModel(
            this, "expression");
//#endif 


//#if 379031144 
JTextArea ebf = new UMLExpressionBodyField(expressionModel, true);
//#endif 


//#if -747349918 
ebf.setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 


//#if 1113913290 
ebf.setRows(1);
//#endif 


//#if 640325966 
exprPanel.add(new JScrollPane(ebf));
//#endif 


//#if -1119463789 
exprPanel.add(new UMLExpressionLanguageField(expressionModel, true));
//#endif 


//#if -1376597133 
add(exprPanel);
//#endif 


//#if -1144294665 
addAction(new ActionNavigateTransition());
//#endif 


//#if -674006841 
addAction(new ActionNewStereotype());
//#endif 


//#if 741376882 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

