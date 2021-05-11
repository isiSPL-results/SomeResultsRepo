package org.argouml.uml.diagram.ui;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.tigris.gef.undo.UndoableAction;
public class ActionNavigability extends UndoableAction
  { 
public static final int BIDIRECTIONAL = 0;
public static final int STARTTOEND = 1;
public static final int ENDTOSTART = 2;
private int nav = BIDIRECTIONAL;
private Object assocStart;
private Object assocEnd;
public static ActionNavigability newActionNavigability(Object assocStart,
            Object assocEnd,
            int nav)
    { 
return new ActionNavigability(getDescription(assocStart, assocEnd, nav),
                                      assocStart,
                                      assocEnd,
                                      nav);
} 
protected ActionNavigability(String label,
                                 Object theAssociationStart,
                                 Object theAssociationEnd,
                                 int theNavigability)
    { 
super(label, null);
putValue(Action.SHORT_DESCRIPTION, label);
this.nav = theNavigability;
this.assocStart = theAssociationStart;
this.assocEnd = theAssociationEnd;
} 
public boolean isEnabled()
    { 
return true;
} 
private static String getDescription(Object assocStart,
                                         Object assocEnd,
                                         int nav)
    { 
String startName =
            Model.getFacade().getName(Model.getFacade().getType(assocStart));
String endName =
            Model.getFacade().getName(Model.getFacade().getType(assocEnd));
if(startName == null || startName.length() == 0)//1
{ 
startName = Translator.localize("action.navigation.anon");
} 
if(endName == null || endName.length() == 0)//1
{ 
endName = Translator.localize("action.navigation.anon");
} 
if(nav == STARTTOEND)//1
{ 
return Translator.messageFormat(
                       "action.navigation.from-to",
                       new Object[] {
                           startName,
                           endName,
                       }
                   );
} 
else
if(nav == ENDTOSTART)//1
{ 
return Translator.messageFormat(
                       "action.navigation.from-to",
                       new Object[] {
                           endName,
                           startName,
                       }
                   );
} 
else
{ 
return Translator.localize("action.navigation.bidirectional");
} 
} 
public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
Model.getCoreHelper().setNavigable(assocStart,
                                           (nav == BIDIRECTIONAL || nav == ENDTOSTART));
Model.getCoreHelper().setNavigable(assocEnd,
                                           (nav == BIDIRECTIONAL || nav == STARTTOEND));
} 

 } 
