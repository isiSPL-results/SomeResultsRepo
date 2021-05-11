
//#if 214183384 
// Compilation Unit of /PropPanelCritic.java 
 

//#if -685166010 
package org.argouml.profile.internal.ui;
//#endif 


//#if 1548078080 
import java.util.Collection;
//#endif 


//#if 821016492 
import javax.swing.ImageIcon;
//#endif 


//#if -1185941108 
import javax.swing.JLabel;
//#endif 


//#if -427322308 
import javax.swing.JTextArea;
//#endif 


//#if -227243693 
import javax.swing.JTextField;
//#endif 


//#if 791593625 
import org.argouml.cognitive.Critic;
//#endif 


//#if 60055162 
import org.argouml.profile.internal.ocl.CrOCL;
//#endif 


//#if -1587565280 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if 528185246 
public class PropPanelCritic extends 
//#if 1505899488 
PropPanel
//#endif 

  { 

//#if 1270897884 
private JTextField criticClass;
//#endif 


//#if 1400240427 
private JTextField name;
//#endif 


//#if -193083006 
private JTextField headline;
//#endif 


//#if -1755555918 
private JTextField priority;
//#endif 


//#if 791897057 
private JTextArea description;
//#endif 


//#if -1709203387 
private JTextArea ocl;
//#endif 


//#if -354106285 
private JLabel oclLabel;
//#endif 


//#if 1289280662 
private JTextField supportedDecision;
//#endif 


//#if 82160296 
private JTextField knowledgeType;
//#endif 


//#if -939325900 
private String colToString(Collection set)
    { 

//#if 684072373 
String r = "";
//#endif 


//#if 1084342718 
int count = 0;
//#endif 


//#if -1827452993 
for (Object obj : set) //1
{ 

//#if -1705514562 
if(count > 0)//1
{ 

//#if 2096733657 
r += ", ";
//#endif 

} 

//#endif 


//#if 254964296 
r += obj;
//#endif 


//#if 1216955820 
++count;
//#endif 

} 

//#endif 


//#if -493814333 
return r;
//#endif 

} 

//#endif 


//#if 1566130668 
public PropPanelCritic()
    { 

//#if -105507130 
super("", (ImageIcon) null);
//#endif 


//#if 1901044671 
criticClass = new JTextField();
//#endif 


//#if -799540016 
addField("label.class", criticClass);
//#endif 


//#if 1889527610 
criticClass.setEditable(false);
//#endif 


//#if 129302522 
name = new JTextField();
//#endif 


//#if 1881605390 
addField("label.name", name);
//#endif 


//#if 772267295 
name.setEditable(false);
//#endif 


//#if -2122905775 
headline = new JTextField();
//#endif 


//#if 835332448 
addField("label.headline", headline);
//#endif 


//#if 1213989480 
headline.setEditable(false);
//#endif 


//#if -639142150 
description = new JTextArea(5, 30);
//#endif 


//#if 1347133796 
addField("label.description", description);
//#endif 


//#if 1073087954 
description.setEditable(false);
//#endif 


//#if 1454257705 
description.setLineWrap(true);
//#endif 


//#if 22230401 
priority = new JTextField();
//#endif 


//#if 1814631680 
addField("label.priority", priority);
//#endif 


//#if 2147411512 
priority.setEditable(false);
//#endif 


//#if -1640826090 
ocl = new JTextArea(5, 30);
//#endif 


//#if -1725198937 
oclLabel = addField("label.ocl", ocl);
//#endif 


//#if 71404014 
ocl.setEditable(false);
//#endif 


//#if -1626095987 
ocl.setLineWrap(true);
//#endif 


//#if -345225223 
supportedDecision = new JTextField();
//#endif 


//#if 430422586 
addField("label.decision", supportedDecision);
//#endif 


//#if -1146412864 
supportedDecision.setEditable(false);
//#endif 


//#if -104802549 
knowledgeType = new JTextField();
//#endif 


//#if 1586691524 
addField("label.knowledge_types", knowledgeType);
//#endif 


//#if 1574985838 
knowledgeType.setEditable(false);
//#endif 

} 

//#endif 


//#if -538626297 
public void setTarget(Object t)
    { 

//#if -2059563405 
super.setTarget(t);
//#endif 


//#if 728193299 
criticClass.setText(getTarget().getClass().getCanonicalName());
//#endif 


//#if 1250968121 
Critic c = (Critic) getTarget();
//#endif 


//#if 169580012 
name.setText(c.getCriticName());
//#endif 


//#if 1675919146 
headline.setText(c.getHeadline());
//#endif 


//#if 2012165972 
description.setText(c.getDescriptionTemplate());
//#endif 


//#if 241412965 
supportedDecision.setText("" + colToString(c.getSupportedDecisions()));
//#endif 


//#if -52893726 
if(c instanceof CrOCL)//1
{ 

//#if 2051262606 
oclLabel.setVisible(true);
//#endif 


//#if 208058842 
ocl.setVisible(true);
//#endif 


//#if -1563347258 
ocl.setText(((CrOCL) c).getOCL());
//#endif 

} 
else
{ 

//#if 2012091011 
oclLabel.setVisible(false);
//#endif 


//#if -448926657 
ocl.setVisible(false);
//#endif 

} 

//#endif 


//#if -439263057 
priority.setText("" + c.getPriority());
//#endif 


//#if 961052097 
knowledgeType.setText("" + colToString(c.getKnowledgeTypes()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

