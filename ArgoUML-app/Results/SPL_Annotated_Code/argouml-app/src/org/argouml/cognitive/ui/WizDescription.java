// Compilation Unit of /WizDescription.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.BorderLayout;
//#endif 


//#if COGNITIVE 
import java.text.MessageFormat;
//#endif 


//#if COGNITIVE 
import javax.swing.JScrollPane;
//#endif 


//#if COGNITIVE 
import javax.swing.JTextArea;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Decision;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Goal;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.model.Model;
//#endif 


//#if COGNITIVE 
public class WizDescription extends WizStep
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG = Logger.getLogger(WizDescription.class);
//#endif 

private JTextArea description = new JTextArea();
private static final long serialVersionUID = 2545592446694112088L;
public WizDescription()
    { 
super();

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.info("making WizDescription");
//#endif 

description.setLineWrap(true);
description.setWrapStyleWord(true);
getMainPanel().setLayout(new BorderLayout());
getMainPanel().add(new JScrollPane(description), BorderLayout.CENTER);
} 

public void setTarget(Object item)
    { 
String message = "";
super.setTarget(item);
Object target = item;
if(target == null)//1
{ 
description.setEditable(false);
description.setText(
                Translator.localize("message.item.no-item-selected"));
} 
else

//#if COGNITIVE 
if(target instanceof ToDoItem)//1
{ 
ToDoItem tdi = (ToDoItem) target;
description.setEditable(false);
description.setEnabled(true);
description.setText(tdi.getDescription());
description.setCaretPosition(0);
} 
else

//#if COGNITIVE 
if(target instanceof PriorityNode)//1
{ 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-priority"),
                    new Object [] {
                        target.toString(),
                    });
description.setEditable(false);
description.setText(message);
return;
} 
else

//#if COGNITIVE 
if(target instanceof Critic)//1
{ 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-critic"),
                    new Object [] {
                        target.toString(),
                    });
description.setEditable(false);
description.setText(message);
return;
} 
else

//#if COGNITIVE 
if(Model.getFacade().isAUMLElement(target))//1
{ 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-model"),
                    new Object [] {
                        Model.getFacade().toString(target),
                    });
description.setEditable(false);
description.setText(message);
return;
} 
else

//#if COGNITIVE 
if(target instanceof Decision)//1
{ 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-decision"),
                    new Object [] {
                        Model.getFacade().toString(target),
                    });
description.setText(message);
return;
} 
else

//#if COGNITIVE 
if(target instanceof Goal)//1
{ 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-goal"),
                    new Object [] {
                        Model.getFacade().toString(target),
                    });
description.setText(message);
return;
} 
else

//#if COGNITIVE 
if(target instanceof KnowledgeTypeNode)//1
{ 
message =
                MessageFormat.format(
                    Translator.localize("message.item.branch-knowledge"),
                    new Object [] {
                        Model.getFacade().toString(target),
                    });
description.setText(message);
return;
} 
else
{ 
description.setText("");
return;
} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


} 

 } 

//#endif 


