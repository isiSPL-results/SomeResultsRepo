package org.argouml.cognitive.critics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
public abstract class Wizard implements java.io.Serializable
  { 
private List<JPanel> panels = new ArrayList<JPanel>();
private int step = 0;
private boolean finished = false;
private boolean started = false;
private WizardItem item = null;
public abstract void doAction(int oldStep);protected void removePanel(int s)
    { 
panels.remove(s);
} 
public void undoAction(int oldStep)
    { 
} 
public boolean isFinished()
    { 
return finished;
} 
public void back()
    { 
step--;
if(step < 0)//1
{ 
step = 0;
} 
undoAction(step);
if(item != null)//1
{ 
item.changed();
} 
} 
public void setToDoItem(WizardItem i)
    { 
item = i;
} 
public WizardItem getToDoItem()
    { 
return item;
} 
public int getProgress()
    { 
return step * 100 / getNumSteps();
} 
public void doAction()
    { 
doAction(step);
} 
public abstract int getNumSteps();public JPanel getCurrentPanel()
    { 
return getPanel(step);
} 
public void next()
    { 
doAction(step);
step++;
JPanel p = makePanel(step);
if(p != null)//1
{ 
panels.add(p);
} 
started = true;
if(item != null)//1
{ 
item.changed();
} 
} 
public void undoAction()
    { 
undoAction(step);
} 
public JPanel getPanel(int s)
    { 
if(s > 0 && s <= panels.size())//1
{ 
return panels.get(s - 1);
} 
return null;
} 
public void finish()
    { 
started = true;
int numSteps = getNumSteps();
for (int i = step; i <= numSteps; i++) //1
{ 
doAction(i);
if(item != null)//1
{ 
item.changed();
} 
} 
finished = true;
} 
public Wizard()
    { 
} 
protected int getStep()
    { 
return step;
} 
public boolean isStarted()
    { 
return started;
} 
public boolean canGoBack()
    { 
return step > 0;
} 
public boolean canGoNext()
    { 
return step < getNumSteps();
} 
public abstract JPanel makePanel(int newStep);public boolean canFinish()
    { 
return true;
} 

 } 
