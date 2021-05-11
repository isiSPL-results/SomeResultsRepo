
//#if -1284098990 
// Compilation Unit of /WizDescription.java 
 

//#if -19586149 
package org.argouml.cognitive.ui;
//#endif 


//#if -61235591 
import java.awt.BorderLayout;
//#endif 


//#if -1529565150 
import java.text.MessageFormat;
//#endif 


//#if -1782843020 
import javax.swing.JScrollPane;
//#endif 


//#if -859270641 
import javax.swing.JTextArea;
//#endif 


//#if -586549871 
import org.apache.log4j.Logger;
//#endif 


//#if -388030106 
import org.argouml.cognitive.Critic;
//#endif 


//#if 735529790 
import org.argouml.cognitive.Decision;
//#endif 


//#if 110455399 
import org.argouml.cognitive.Goal;
//#endif 


//#if 519758369 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 745614592 
import org.argouml.cognitive.Translator;
//#endif 


//#if 1260986628 
import org.argouml.model.Model;
//#endif 


//#if -208693896 
public class WizDescription extends 
//#if 1054394434 
WizStep
//#endif 

  { 

//#if -1083872112 
private static final Logger LOG = Logger.getLogger(WizDescription.class);
//#endif 


//#if -727793374 
private JTextArea description = new JTextArea();
//#endif 


//#if -2013036972 
private static final long serialVersionUID = 2545592446694112088L;
//#endif 


//#if 556322864 
public WizDescription()
    { 

//#if -1931544027 
super();
//#endif 


//#if 531702685 
LOG.info("making WizDescription");
//#endif 


//#if -1251765408 
description.setLineWrap(true);
//#endif 


//#if 544336065 
description.setWrapStyleWord(true);
//#endif 


//#if 1965492283 
getMainPanel().setLayout(new BorderLayout());
//#endif 


//#if 264463056 
getMainPanel().add(new JScrollPane(description), BorderLayout.CENTER);
//#endif 

} 

//#endif 


//#if 1909395 
public void setTarget(Object item)
    { 

//#if 48798152 
String message = "";
//#endif 


//#if -2016776999 
super.setTarget(item);
//#endif 


//#if -1738223065 
Object target = item;
//#endif 


//#if 1928039071 
if(target == null)//1
{ 

//#if 1222823018 
description.setEditable(false);
//#endif 


//#if -2000891359 
description.setText(
                Translator.localize("message.item.no-item-selected"));
//#endif 

} 
else

//#if -2002849017 
if(target instanceof ToDoItem)//1
{ 

//#if 1443986530 
ToDoItem tdi = (ToDoItem) target;
//#endif 


//#if -758143714 
description.setEditable(false);
//#endif 


//#if 196948116 
description.setEnabled(true);
//#endif 


//#if -993334340 
description.setText(tdi.getDescription());
//#endif 


//#if 1902159705 
description.setCaretPosition(0);
//#endif 

} 
else

//#if -1385863248 
if(target instanceof PriorityNode)//1
{ 

//#if -1198108193 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-priority"),
                    new Object [] {
                        target.toString(),
                    });
//#endif 


//#if 2074979191 
description.setEditable(false);
//#endif 


//#if -291230876 
description.setText(message);
//#endif 


//#if 990091297 
return;
//#endif 

} 
else

//#if 1305700599 
if(target instanceof Critic)//1
{ 

//#if -486981657 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-critic"),
                    new Object [] {
                        target.toString(),
                    });
//#endif 


//#if -1077789569 
description.setEditable(false);
//#endif 


//#if 54091372 
description.setText(message);
//#endif 


//#if 1212203305 
return;
//#endif 

} 
else

//#if 1281440751 
if(Model.getFacade().isAUMLElement(target))//1
{ 

//#if 990665295 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-model"),
                    new Object [] {
                        Model.getFacade().toString(target),
                    });
//#endif 


//#if 201261356 
description.setEditable(false);
//#endif 


//#if 323578457 
description.setText(message);
//#endif 


//#if 848985302 
return;
//#endif 

} 
else

//#if -1368673457 
if(target instanceof Decision)//1
{ 

//#if 210963372 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-decision"),
                    new Object [] {
                        Model.getFacade().toString(target),
                    });
//#endif 


//#if -1708814151 
description.setText(message);
//#endif 


//#if -837571786 
return;
//#endif 

} 
else

//#if -961637394 
if(target instanceof Goal)//1
{ 

//#if 1547231949 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-goal"),
                    new Object [] {
                        Model.getFacade().toString(target),
                    });
//#endif 


//#if 1147190449 
description.setText(message);
//#endif 


//#if -533192402 
return;
//#endif 

} 
else

//#if 1109831317 
if(target instanceof KnowledgeTypeNode)//1
{ 

//#if -1811303876 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-knowledge"),
                    new Object [] {
                        Model.getFacade().toString(target),
                    });
//#endif 


//#if 609545847 
description.setText(message);
//#endif 


//#if 1190128500 
return;
//#endif 

} 
else
{ 

//#if -2014655294 
description.setText("");
//#endif 


//#if 1958849702 
return;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

