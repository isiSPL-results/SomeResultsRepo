
//#if 1358818405 
// Compilation Unit of /ActionNavigability.java 
 

//#if -1675681778 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1262102531 
import java.awt.event.ActionEvent;
//#endif 


//#if -1902581639 
import javax.swing.Action;
//#endif 


//#if -630538030 
import org.argouml.i18n.Translator;
//#endif 


//#if 461423768 
import org.argouml.model.Model;
//#endif 


//#if -1127498855 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1200248911 
public class ActionNavigability extends 
//#if 763995768 
UndoableAction
//#endif 

  { 

//#if -804582375 
public static final int BIDIRECTIONAL = 0;
//#endif 


//#if 1832195189 
public static final int STARTTOEND = 1;
//#endif 


//#if -1881807450 
public static final int ENDTOSTART = 2;
//#endif 


//#if -1776520894 
private int nav = BIDIRECTIONAL;
//#endif 


//#if 1119343088 
private Object assocStart;
//#endif 


//#if -437246377 
private Object assocEnd;
//#endif 


//#if 1726449899 
public static ActionNavigability newActionNavigability(Object assocStart,
            Object assocEnd,
            int nav)
    { 

//#if 1422701887 
return new ActionNavigability(getDescription(assocStart, assocEnd, nav),
                                      assocStart,
                                      assocEnd,
                                      nav);
//#endif 

} 

//#endif 


//#if -1190297475 
protected ActionNavigability(String label,
                                 Object theAssociationStart,
                                 Object theAssociationEnd,
                                 int theNavigability)
    { 

//#if -605695683 
super(label, null);
//#endif 


//#if -1569397950 
putValue(Action.SHORT_DESCRIPTION, label);
//#endif 


//#if 458300876 
this.nav = theNavigability;
//#endif 


//#if -655097592 
this.assocStart = theAssociationStart;
//#endif 


//#if 1149596502 
this.assocEnd = theAssociationEnd;
//#endif 

} 

//#endif 


//#if -1187778499 
public boolean isEnabled()
    { 

//#if -1787775662 
return true;
//#endif 

} 

//#endif 


//#if -2087294902 
private static String getDescription(Object assocStart,
                                         Object assocEnd,
                                         int nav)
    { 

//#if -1720008815 
String startName =
            Model.getFacade().getName(Model.getFacade().getType(assocStart));
//#endif 


//#if -385746959 
String endName =
            Model.getFacade().getName(Model.getFacade().getType(assocEnd));
//#endif 


//#if 107781390 
if(startName == null || startName.length() == 0)//1
{ 

//#if -1570174581 
startName = Translator.localize("action.navigation.anon");
//#endif 

} 

//#endif 


//#if 1219368942 
if(endName == null || endName.length() == 0)//1
{ 

//#if -226167100 
endName = Translator.localize("action.navigation.anon");
//#endif 

} 

//#endif 


//#if 1708568663 
if(nav == STARTTOEND)//1
{ 

//#if -713489066 
return Translator.messageFormat(
                       "action.navigation.from-to",
                       new Object[] {
                           startName,
                           endName,
                       }
                   );
//#endif 

} 
else

//#if 1997644886 
if(nav == ENDTOSTART)//1
{ 

//#if -20268281 
return Translator.messageFormat(
                       "action.navigation.from-to",
                       new Object[] {
                           endName,
                           startName,
                       }
                   );
//#endif 

} 
else
{ 

//#if 400488343 
return Translator.localize("action.navigation.bidirectional");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1617436384 
public void actionPerformed(ActionEvent ae)
    { 

//#if 1383343869 
super.actionPerformed(ae);
//#endif 


//#if -1699594081 
Model.getCoreHelper().setNavigable(assocStart,
                                           (nav == BIDIRECTIONAL || nav == ENDTOSTART));
//#endif 


//#if 351721542 
Model.getCoreHelper().setNavigable(assocEnd,
                                           (nav == BIDIRECTIONAL || nav == STARTTOEND));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

