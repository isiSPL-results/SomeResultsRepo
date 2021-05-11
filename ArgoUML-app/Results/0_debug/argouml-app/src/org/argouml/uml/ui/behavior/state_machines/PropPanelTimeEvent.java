
//#if 1602492831 
// Compilation Unit of /PropPanelTimeEvent.java 
 

//#if -2036777454 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 2079805636 
import javax.swing.JPanel;
//#endif 


//#if -1746824935 
import javax.swing.JScrollPane;
//#endif 


//#if 352662977 
import org.argouml.uml.ui.UMLExpressionBodyField;
//#endif 


//#if 11747319 
import org.argouml.uml.ui.UMLExpressionLanguageField;
//#endif 


//#if -1416947468 
import org.argouml.uml.ui.UMLExpressionModel2;
//#endif 


//#if -1589135843 
import org.argouml.uml.ui.UMLTimeExpressionModel;
//#endif 


//#if -1086718805 
public class PropPanelTimeEvent extends 
//#if 744056194 
PropPanelEvent
//#endif 

  { 

//#if 1992196145 
@Override
    public void initialize()
    { 

//#if -1119737811 
super.initialize();
//#endif 


//#if -478500715 
UMLExpressionModel2 whenModel = new UMLTimeExpressionModel(
            this, "when");
//#endif 


//#if 1206988705 
JPanel whenPanel = createBorderPanel("label.when");
//#endif 


//#if -1186899987 
whenPanel.add(new JScrollPane(new UMLExpressionBodyField(
                                          whenModel, true)));
//#endif 


//#if 423835708 
whenPanel.add(new UMLExpressionLanguageField(whenModel,
                      false));
//#endif 


//#if -618380757 
add(whenPanel);
//#endif 


//#if 1731976271 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 310600607 
public PropPanelTimeEvent()
    { 

//#if -931366354 
super("label.time.event", lookupIcon("TimeEvent"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

