
//#if -139274447 
// Compilation Unit of /PropPanelConstraint.java 
 

//#if 1625228464 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -834064101 
import javax.swing.JScrollPane;
//#endif 


//#if 1187124069 
import org.argouml.i18n.Translator;
//#endif 


//#if -2085201749 
import org.argouml.model.Model;
//#endif 


//#if -1290566611 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 1171680764 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -1581271567 
import org.argouml.uml.ui.UMLPlainTextDocument;
//#endif 


//#if -801897749 
import org.argouml.uml.ui.UMLTextArea2;
//#endif 


//#if -616146748 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 42305416 
class UMLConstraintBodyDocument extends 
//#if -1033650851 
UMLPlainTextDocument
//#endif 

  { 

//#if 1444991127 
protected void setProperty(String text)
    { 
} 

//#endif 


//#if 1132864935 
public UMLConstraintBodyDocument()
    { 

//#if 2135235745 
super("body");
//#endif 

} 

//#endif 


//#if 1092868844 
protected String getProperty()
    { 

//#if 944833070 
return (String) Model.getFacade().getBody(
                   Model.getFacade().getBody(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 999898305 
public class PropPanelConstraint extends 
//#if -1289726054 
PropPanelModelElement
//#endif 

  { 

//#if 782493370 
private static final long serialVersionUID = -7621484706045787046L;
//#endif 


//#if -1846933412 
public PropPanelConstraint()
    { 

//#if 346585245 
super("label.constraint", lookupIcon("Constraint"));
//#endif 


//#if 1353233531 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if 1298397338 
addField(Translator.localize("label.constrained-elements"),
                 new JScrollPane(new UMLLinkedList(
                                     new UMLConstraintConstrainedElementListModel())));
//#endif 


//#if -483740710 
addSeparator();
//#endif 


//#if 378995317 
UMLTextArea2 text = new UMLTextArea2(new UMLConstraintBodyDocument());
//#endif 


//#if 1196469070 
text.setEditable(false);
//#endif 


//#if -2073952952 
text.setLineWrap(false);
//#endif 


//#if -28790315 
text.setRows(5);
//#endif 


//#if -1263328810 
JScrollPane pane = new JScrollPane(text);
//#endif 


//#if 168437706 
addField(Translator.localize("label.constraint.body"), pane);
//#endif 


//#if 1639237096 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -1287037348 
addAction(new ActionNewStereotype());
//#endif 


//#if -82932867 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

