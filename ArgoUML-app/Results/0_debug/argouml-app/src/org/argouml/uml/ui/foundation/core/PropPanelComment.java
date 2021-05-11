
//#if 809097632 
// Compilation Unit of /PropPanelComment.java 
 

//#if -244292762 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 993645466 
import java.awt.event.ActionEvent;
//#endif 


//#if -2137362223 
import javax.swing.JScrollPane;
//#endif 


//#if -362772453 
import org.argouml.i18n.Translator;
//#endif 


//#if -1804297483 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 906467425 
import org.argouml.model.Model;
//#endif 


//#if 1998225841 
import org.argouml.uml.ui.AbstractActionRemoveElement;
//#endif 


//#if -454693789 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -573629124 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -1200174681 
import org.argouml.uml.ui.UMLPlainTextDocument;
//#endif 


//#if -511890271 
import org.argouml.uml.ui.UMLTextArea2;
//#endif 


//#if 347754062 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -809701131 

//#if -294414056 
@UmlModelMutator
//#endif 

class ActionDeleteAnnotatedElement extends 
//#if -535646219 
AbstractActionRemoveElement
//#endif 

  { 

//#if 930801850 
public ActionDeleteAnnotatedElement()
    { 

//#if 1738880844 
super(Translator.localize("menu.popup.remove"));
//#endif 

} 

//#endif 


//#if 246663335 
@Override
    public void actionPerformed(ActionEvent arg0)
    { 

//#if 1616086233 
super.actionPerformed(arg0);
//#endif 


//#if -774642290 
Model.getCoreHelper().removeAnnotatedElement(
            getTarget(), getObjectToRemove());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 929623928 

//#if 1456046709 
@UmlModelMutator
//#endif 

class UMLCommentBodyDocument extends 
//#if -849600986 
UMLPlainTextDocument
//#endif 

  { 

//#if 2042134368 
protected void setProperty(String text)
    { 

//#if -2086564449 
Model.getCoreHelper().setBody(getTarget(), text);
//#endif 

} 

//#endif 


//#if -411606347 
protected String getProperty()
    { 

//#if 1117240891 
return (String) Model.getFacade().getBody(getTarget());
//#endif 

} 

//#endif 


//#if 990341146 
public UMLCommentBodyDocument()
    { 

//#if 360727886 
super("body");
//#endif 


//#if 900788001 
putProperty("filterNewlines", Boolean.FALSE);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -14967291 
public class PropPanelComment extends 
//#if -508643436 
PropPanelModelElement
//#endif 

  { 

//#if 178201966 
private static final long serialVersionUID = -8781239511498017147L;
//#endif 


//#if 465810792 
public PropPanelComment()
    { 

//#if 114289881 
super("label.comment", lookupIcon("Comment"));
//#endif 


//#if 478485855 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if 1695165426 
UMLMutableLinkedList umll = new UMLMutableLinkedList(
            new UMLCommentAnnotatedElementListModel(), null, null);
//#endif 


//#if -334621259 
umll.setDeleteAction(new ActionDeleteAnnotatedElement());
//#endif 


//#if -1377905607 
addField(Translator.localize("label.annotated-elements"),
                 new JScrollPane(umll));
//#endif 


//#if 737801406 
addSeparator();
//#endif 


//#if -958925245 
UMLTextArea2 text = new UMLTextArea2(new UMLCommentBodyDocument());
//#endif 


//#if -1989341679 
text.setLineWrap(true);
//#endif 


//#if -815690383 
text.setRows(5);
//#endif 


//#if 1656676282 
JScrollPane pane = new JScrollPane(text);
//#endif 


//#if -1281119820 
addField(Translator.localize("label.comment.body"), pane);
//#endif 


//#if -1314425140 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -1885580296 
addAction(new ActionNewStereotype());
//#endif 


//#if 261647713 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

