// Compilation Unit of /PropPanelCritic.java 
 

//#if COGNITIVE 
package org.argouml.profile.internal.ui;
//#endif 


//#if COGNITIVE 
import java.util.Collection;
//#endif 


//#if COGNITIVE 
import javax.swing.ImageIcon;
//#endif 


//#if COGNITIVE 
import javax.swing.JLabel;
//#endif 


//#if COGNITIVE 
import javax.swing.JTextArea;
//#endif 


//#if COGNITIVE 
import javax.swing.JTextField;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 


//#if COGNITIVE 
import org.argouml.profile.internal.ocl.CrOCL;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if COGNITIVE 
public class PropPanelCritic extends PropPanel
  { 
private JTextField criticClass;
private JTextField name;
private JTextField headline;
private JTextField priority;
private JTextArea description;
private JTextArea ocl;
private JLabel oclLabel;
private JTextField supportedDecision;
private JTextField knowledgeType;
private String colToString(Collection set)
    { 
String r = "";
int count = 0;
for (Object obj : set) //1
{ 
if(count > 0)//1
{ 
r += ", ";
} 

r += obj;
++count;
} 

return r;
} 

public PropPanelCritic()
    { 
super("", (ImageIcon) null);
criticClass = new JTextField();
addField("label.class", criticClass);
criticClass.setEditable(false);
name = new JTextField();
addField("label.name", name);
name.setEditable(false);
headline = new JTextField();
addField("label.headline", headline);
headline.setEditable(false);
description = new JTextArea(5, 30);
addField("label.description", description);
description.setEditable(false);
description.setLineWrap(true);
priority = new JTextField();
addField("label.priority", priority);
priority.setEditable(false);
ocl = new JTextArea(5, 30);
oclLabel = addField("label.ocl", ocl);
ocl.setEditable(false);
ocl.setLineWrap(true);
supportedDecision = new JTextField();
addField("label.decision", supportedDecision);
supportedDecision.setEditable(false);
knowledgeType = new JTextField();
addField("label.knowledge_types", knowledgeType);
knowledgeType.setEditable(false);
} 

public void setTarget(Object t)
    { 
super.setTarget(t);
criticClass.setText(getTarget().getClass().getCanonicalName());
Critic c = (Critic) getTarget();
name.setText(c.getCriticName());
headline.setText(c.getHeadline());
description.setText(c.getDescriptionTemplate());
supportedDecision.setText("" + colToString(c.getSupportedDecisions()));
if(c instanceof CrOCL)//1
{ 
oclLabel.setVisible(true);
ocl.setVisible(true);
ocl.setText(((CrOCL) c).getOCL());
} 
else
{ 
oclLabel.setVisible(false);
ocl.setVisible(false);
} 

priority.setText("" + c.getPriority());
knowledgeType.setText("" + colToString(c.getKnowledgeTypes()));
} 

 } 

//#endif 


