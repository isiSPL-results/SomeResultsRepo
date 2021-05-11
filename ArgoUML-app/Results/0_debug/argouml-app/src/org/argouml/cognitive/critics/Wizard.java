
//#if -552379721 
// Compilation Unit of /Wizard.java 
 

//#if -578016979 
package org.argouml.cognitive.critics;
//#endif 


//#if -1502299473 
import java.util.ArrayList;
//#endif 


//#if -1542698414 
import java.util.List;
//#endif 


//#if -109690482 
import javax.swing.JPanel;
//#endif 


//#if -519307118 
public abstract class Wizard implements 
//#if -194711991 
java.io.Serializable
//#endif 

  { 

//#if 1035535816 
private List<JPanel> panels = new ArrayList<JPanel>();
//#endif 


//#if 532076866 
private int step = 0;
//#endif 


//#if 1480677360 
private boolean finished = false;
//#endif 


//#if 1597049351 
private boolean started = false;
//#endif 


//#if 178404637 
private WizardItem item = null;
//#endif 


//#if -425338965 
public abstract void doAction(int oldStep);
//#endif 


//#if 122253481 
protected void removePanel(int s)
    { 

//#if 212050104 
panels.remove(s);
//#endif 

} 

//#endif 


//#if -1338540574 
public void undoAction(int oldStep)
    { 
} 

//#endif 


//#if 334189678 
public boolean isFinished()
    { 

//#if 203515669 
return finished;
//#endif 

} 

//#endif 


//#if 1803131411 
public void back()
    { 

//#if -579012184 
step--;
//#endif 


//#if 1371467852 
if(step < 0)//1
{ 

//#if -1546362066 
step = 0;
//#endif 

} 

//#endif 


//#if 211101637 
undoAction(step);
//#endif 


//#if -1855433566 
if(item != null)//1
{ 

//#if 183235689 
item.changed();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1329699510 
public void setToDoItem(WizardItem i)
    { 

//#if -543841478 
item = i;
//#endif 

} 

//#endif 


//#if 762250971 
public WizardItem getToDoItem()
    { 

//#if 508131507 
return item;
//#endif 

} 

//#endif 


//#if -1019286932 
public int getProgress()
    { 

//#if -775290388 
return step * 100 / getNumSteps();
//#endif 

} 

//#endif 


//#if -1731607603 
public void doAction()
    { 

//#if 763018754 
doAction(step);
//#endif 

} 

//#endif 


//#if -1541139550 
public abstract int getNumSteps();
//#endif 


//#if 400071857 
public JPanel getCurrentPanel()
    { 

//#if -1045639002 
return getPanel(step);
//#endif 

} 

//#endif 


//#if -2143957729 
public void next()
    { 

//#if -1521640634 
doAction(step);
//#endif 


//#if -1291483280 
step++;
//#endif 


//#if 1743402518 
JPanel p = makePanel(step);
//#endif 


//#if -893999441 
if(p != null)//1
{ 

//#if 867430034 
panels.add(p);
//#endif 

} 

//#endif 


//#if 1985311794 
started = true;
//#endif 


//#if 1383702570 
if(item != null)//1
{ 

//#if -746316224 
item.changed();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -307185562 
public void undoAction()
    { 

//#if 428647453 
undoAction(step);
//#endif 

} 

//#endif 


//#if 1491618268 
public JPanel getPanel(int s)
    { 

//#if 155712839 
if(s > 0 && s <= panels.size())//1
{ 

//#if -1335531597 
return panels.get(s - 1);
//#endif 

} 

//#endif 


//#if -50016468 
return null;
//#endif 

} 

//#endif 


//#if -855762945 
public void finish()
    { 

//#if 396623189 
started = true;
//#endif 


//#if -478760500 
int numSteps = getNumSteps();
//#endif 


//#if 253316570 
for (int i = step; i <= numSteps; i++) //1
{ 

//#if 391393331 
doAction(i);
//#endif 


//#if 1126114826 
if(item != null)//1
{ 

//#if 2046413258 
item.changed();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 782950014 
finished = true;
//#endif 

} 

//#endif 


//#if 1607812323 
public Wizard()
    { 
} 

//#endif 


//#if 1470233588 
protected int getStep()
    { 

//#if -777354103 
return step;
//#endif 

} 

//#endif 


//#if 1724148327 
public boolean isStarted()
    { 

//#if 181323981 
return started;
//#endif 

} 

//#endif 


//#if -1367135665 
public boolean canGoBack()
    { 

//#if 1821048210 
return step > 0;
//#endif 

} 

//#endif 


//#if -1019257509 
public boolean canGoNext()
    { 

//#if 2004405111 
return step < getNumSteps();
//#endif 

} 

//#endif 


//#if 2025875495 
public abstract JPanel makePanel(int newStep);
//#endif 


//#if 1422511091 
public boolean canFinish()
    { 

//#if 1050779552 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

