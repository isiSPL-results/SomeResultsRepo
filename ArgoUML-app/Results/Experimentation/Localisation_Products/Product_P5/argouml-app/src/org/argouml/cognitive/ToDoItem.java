package org.argouml.cognitive;
import java.io.Serializable;
import javax.swing.Icon;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.cognitive.critics.WizardItem;
import org.argouml.util.CollectionUtil;
public class ToDoItem implements Serializable
,WizardItem
  { 
public static final int INTERRUPTIVE_PRIORITY = 9;
public static final int HIGH_PRIORITY = 1;
public static final int MED_PRIORITY = 2;
public static final int LOW_PRIORITY = 3;
private Poster thePoster;
private String theHeadline;
private int thePriority;
private String theDescription;
private String theMoreInfoURL;
private ListSet theOffenders;
private final Wizard theWizard;
private String cachedExpandedHeadline;
private String cachedExpandedDescription;
private static final long serialVersionUID = 3058660098451455153L;
public int getPriority()
    { 
return thePriority;
} 
@Override
    public int hashCode()
    { 
int code = 0;
code += getHeadline().hashCode();
if(getPoster() != null)//1
{ 
code += getPoster().hashCode();
} 
return code;
} 
public ListSet getOffenders()
    { 
assert theOffenders != null;
return theOffenders;
} 
public boolean stillValid(Designer d)
    { 
if(thePoster == null)//1
{ 
return true;
} 
if(theWizard != null && theWizard.isStarted()
                && !theWizard.isFinished())//1
{ 
return true;
} 
return thePoster.stillValid(this, d);
} 
public void select()
    { 
for (Object dm : getOffenders()) //1
{ 
if(dm instanceof Highlightable)//1
{ 
((Highlightable) dm).setHighlight(true);
} 
} 
} 
public boolean containsKnowledgeType(String type)
    { 
return getPoster().containsKnowledgeType(type);
} 
@Deprecated
    public void setPriority(int p)
    { 
thePriority = p;
} 
public int getProgress()
    { 
if(theWizard != null)//1
{ 
return theWizard.getProgress();
} 
return 0;
} 
public void action()
    { 
deselect();
select();
} 
private void checkOffs(ListSet offs)
    { 
if(offs == null)//1
{ 
throw new IllegalArgumentException(
                "A ListSet of offenders must be supplied.");
} 
Object offender = CollectionUtil.getFirstItemOrNull(offs);
if(offender != null)//1
{ 
checkArgument(offender);
} 
if(offs.size() >= 2)//1
{ 
offender = offs.get(1);
checkArgument(offender);
} 
} 
public boolean supports(Goal g)
    { 
return getPoster().supports(g);
} 
@Deprecated
    public void setDescription(String d)
    { 
theDescription = d;
cachedExpandedDescription = null;
} 
public Poster getPoster()
    { 
return thePoster;
} 
public void changed()
    { 
ToDoList list = Designer.theDesigner().getToDoList();
list.fireToDoItemChanged(this);
} 
protected void checkArgument(Object dm)
    { 
} 
@Deprecated
    public void setHeadline(String h)
    { 
theHeadline = h;
cachedExpandedHeadline = null;
} 
@Deprecated
    public void setOffenders(ListSet offenders)
    { 
theOffenders = offenders;
} 
public String getMoreInfoURL()
    { 
return theMoreInfoURL;
} 
public ToDoItem(Critic c)
    { 
thePoster = c;
theHeadline = c.getHeadline();
theOffenders = new ListSet();
thePriority = c.getPriority(null, null);
theDescription = c.getDescription(null, null);
theMoreInfoURL = c.getMoreInfoURL(null, null);
theWizard = c.makeWizard(this);
} 
public String getDescription()
    { 
if(cachedExpandedDescription == null)//1
{ 
cachedExpandedDescription =
                thePoster.expand(theDescription, theOffenders);
} 
return cachedExpandedDescription;
} 
public void deselect()
    { 
for (Object dm : getOffenders()) //1
{ 
if(dm instanceof Highlightable)//1
{ 
((Highlightable) dm).setHighlight(false);
} 
} 
} 
public Icon getClarifier()
    { 
return thePoster.getClarifier();
} 
public ToDoItem(Critic c, Object dm, Designer dsgr)
    { 
checkArgument(dm);
thePoster = c;
theHeadline = c.getHeadline(dm, dsgr);
theOffenders = new ListSet(dm);
thePriority = c.getPriority(theOffenders, dsgr);
theDescription = c.getDescription(theOffenders, dsgr);
theMoreInfoURL = c.getMoreInfoURL(theOffenders, dsgr);
theWizard = c.makeWizard(this);
} 
public void fixIt()
    { 
thePoster.fixIt(this, null);
} 
public Wizard getWizard()
    { 
return theWizard;
} 
public ToDoItem(Poster poster, String h, int p, String d, String m)
    { 
thePoster = poster;
theHeadline = h;
theOffenders = new ListSet();
thePriority = p;
theDescription = d;
theMoreInfoURL = m;
theWizard = null;
} 
public ToDoItem(Poster poster, String h, int p, String d, String m,
                    ListSet offs)
    { 
checkOffs(offs);
thePoster = poster;
theHeadline = h;
theOffenders = offs;
thePriority = p;
theDescription = d;
theMoreInfoURL = m;
theWizard = null;
} 
public boolean canFixIt()
    { 
return thePoster.canFixIt(this);
} 
public boolean supports(Decision d)
    { 
return getPoster().supports(d);
} 
@Deprecated
    public void setMoreInfoURL(String m)
    { 
theMoreInfoURL = m;
} 
public String getHeadline()
    { 
if(cachedExpandedHeadline == null)//1
{ 
cachedExpandedHeadline =
                thePoster.expand(theHeadline, theOffenders);
} 
return cachedExpandedHeadline;
} 
@Override
    public String toString()
    { 
return this.getClass().getName()
               + "(" + getHeadline() + ") on " + getOffenders().toString();
} 
@Override
    public boolean equals(Object o)
    { 
if(!(o instanceof ToDoItem))//1
{ 
return false;
} 
ToDoItem i = (ToDoItem) o;
if(!getHeadline().equals(i.getHeadline()))//1
{ 
return false;
} 
if(!(getPoster() == (i.getPoster())))//1
{ 
return false;
} 
if(!getOffenders().equals(i.getOffenders()))//1
{ 
return false;
} 
return true;
} 
public ToDoItem(Critic c, ListSet offs, Designer dsgr)
    { 
checkOffs(offs);
thePoster = c;
theHeadline = c.getHeadline(offs, dsgr);
theOffenders = offs;
thePriority = c.getPriority(theOffenders, dsgr);
theDescription = c.getDescription(theOffenders, dsgr);
theMoreInfoURL = c.getMoreInfoURL(theOffenders, dsgr);
theWizard = c.makeWizard(this);
} 

 } 
