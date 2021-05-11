
//#if 393974729 
// Compilation Unit of /PropPanelChangeEvent.java 
 

//#if -1869916425 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1470363585 
import javax.swing.JPanel;
//#endif 


//#if -1564782978 
import javax.swing.JScrollPane;
//#endif 


//#if 1778533350 
import org.argouml.uml.ui.UMLExpressionBodyField;
//#endif 


//#if 1451406236 
import org.argouml.uml.ui.UMLExpressionLanguageField;
//#endif 


//#if 585909487 
import org.argouml.uml.ui.UMLExpressionModel2;
//#endif 


//#if -317095581 
public class PropPanelChangeEvent extends 
//#if -1162903865 
PropPanelEvent
//#endif 

  { 

//#if -644908660 
@Override
    public void initialize()
    { 

//#if -1279125907 
super.initialize();
//#endif 


//#if -547830226 
UMLExpressionModel2 changeModel = new UMLChangeExpressionModel(
            this, "changeExpression");
//#endif 


//#if 414120161 
JPanel changePanel = createBorderPanel("label.change");
//#endif 


//#if -149750419 
changePanel.add(new JScrollPane(new UMLExpressionBodyField(
                                            changeModel, true)));
//#endif 


//#if 1985804072 
changePanel.add(new UMLExpressionLanguageField(changeModel,
                        false));
//#endif 


//#if 1267212149 
add(changePanel);
//#endif 


//#if 1649867407 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -581293663 
public PropPanelChangeEvent()
    { 

//#if -651011738 
super("label.change.event", lookupIcon("ChangeEvent"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

