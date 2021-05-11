
//#if 1229102259 
// Compilation Unit of /ToDoItem.java 
 

//#if 80043481 
package org.argouml.cognitive;
//#endif 


//#if -903240848 
import java.io.Serializable;
//#endif 


//#if -532951702 
import javax.swing.Icon;
//#endif 


//#if -1460988768 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if 1594577229 
import org.argouml.cognitive.critics.WizardItem;
//#endif 


//#if -1902753540 
import org.argouml.util.CollectionUtil;
//#endif 


//#if -638749987 
public class ToDoItem implements 
//#if 759076841 
Serializable
//#endif 

, 
//#if -640649080 
WizardItem
//#endif 

  { 

//#if -150561045 
public static final int INTERRUPTIVE_PRIORITY = 9;
//#endif 


//#if 621047424 
public static final int HIGH_PRIORITY = 1;
//#endif 


//#if 1518365493 
public static final int MED_PRIORITY = 2;
//#endif 


//#if -2029495076 
public static final int LOW_PRIORITY = 3;
//#endif 


//#if -671995261 
private Poster thePoster;
//#endif 


//#if -197763488 
private String theHeadline;
//#endif 


//#if 2136108412 
private int thePriority;
//#endif 


//#if 816458662 
private String theDescription;
//#endif 


//#if -819599146 
private String theMoreInfoURL;
//#endif 


//#if -1044824153 
private ListSet theOffenders;
//#endif 


//#if -34949913 
private final Wizard theWizard;
//#endif 


//#if 406916610 
private String cachedExpandedHeadline;
//#endif 


//#if 1748418756 
private String cachedExpandedDescription;
//#endif 


//#if 994467445 
private static final long serialVersionUID = 3058660098451455153L;
//#endif 


//#if 1340840127 
public int getPriority()
    { 

//#if -1248183473 
return thePriority;
//#endif 

} 

//#endif 


//#if -198983968 
@Override
    public int hashCode()
    { 

//#if 2140507991 
int code = 0;
//#endif 


//#if -141037774 
code += getHeadline().hashCode();
//#endif 


//#if 1539459695 
if(getPoster() != null)//1
{ 

//#if -1132525551 
code += getPoster().hashCode();
//#endif 

} 

//#endif 


//#if 371543539 
return code;
//#endif 

} 

//#endif 


//#if -1292598506 
public ListSet getOffenders()
    { 

//#if 1172549969 
assert theOffenders != null;
//#endif 


//#if 1031517642 
return theOffenders;
//#endif 

} 

//#endif 


//#if -72430065 
public boolean stillValid(Designer d)
    { 

//#if -265091152 
if(thePoster == null)//1
{ 

//#if 2083731932 
return true;
//#endif 

} 

//#endif 


//#if -144065100 
if(theWizard != null && theWizard.isStarted()
                && !theWizard.isFinished())//1
{ 

//#if -529252746 
return true;
//#endif 

} 

//#endif 


//#if -507631282 
return thePoster.stillValid(this, d);
//#endif 

} 

//#endif 


//#if 123793604 
public void select()
    { 

//#if 431709378 
for (Object dm : getOffenders()) //1
{ 

//#if -885145995 
if(dm instanceof Highlightable)//1
{ 

//#if 629660448 
((Highlightable) dm).setHighlight(true);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 164549498 
public boolean containsKnowledgeType(String type)
    { 

//#if -492535772 
return getPoster().containsKnowledgeType(type);
//#endif 

} 

//#endif 


//#if -45170464 
@Deprecated
    public void setPriority(int p)
    { 

//#if 1794878725 
thePriority = p;
//#endif 

} 

//#endif 


//#if 398975752 
public int getProgress()
    { 

//#if 1617497328 
if(theWizard != null)//1
{ 

//#if 236626738 
return theWizard.getProgress();
//#endif 

} 

//#endif 


//#if -1284539985 
return 0;
//#endif 

} 

//#endif 


//#if 1571017598 
public void action()
    { 

//#if 1212560468 
deselect();
//#endif 


//#if 304712053 
select();
//#endif 

} 

//#endif 


//#if 1749455594 
private void checkOffs(ListSet offs)
    { 

//#if 445423175 
if(offs == null)//1
{ 

//#if 1015206007 
throw new IllegalArgumentException(
                "A ListSet of offenders must be supplied.");
//#endif 

} 

//#endif 


//#if 2075254631 
Object offender = CollectionUtil.getFirstItemOrNull(offs);
//#endif 


//#if 1718495352 
if(offender != null)//1
{ 

//#if 335425074 
checkArgument(offender);
//#endif 

} 

//#endif 


//#if -1578294525 
if(offs.size() >= 2)//1
{ 

//#if 595138892 
offender = offs.get(1);
//#endif 


//#if 741590477 
checkArgument(offender);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 646942084 
public boolean supports(Goal g)
    { 

//#if 1604654316 
return getPoster().supports(g);
//#endif 

} 

//#endif 


//#if -1715018146 
@Deprecated
    public void setDescription(String d)
    { 

//#if 103180048 
theDescription = d;
//#endif 


//#if -1907851809 
cachedExpandedDescription = null;
//#endif 

} 

//#endif 


//#if -212164444 
public Poster getPoster()
    { 

//#if -1157795851 
return thePoster;
//#endif 

} 

//#endif 


//#if -1581040178 
public void changed()
    { 

//#if -1280622464 
ToDoList list = Designer.theDesigner().getToDoList();
//#endif 


//#if -202614116 
list.fireToDoItemChanged(this);
//#endif 

} 

//#endif 


//#if 1750680518 
protected void checkArgument(Object dm)
    { 
} 

//#endif 


//#if 1421464714 
@Deprecated
    public void setHeadline(String h)
    { 

//#if 777233351 
theHeadline = h;
//#endif 


//#if 654639522 
cachedExpandedHeadline = null;
//#endif 

} 

//#endif 


//#if -55820919 
@Deprecated
    public void setOffenders(ListSet offenders)
    { 

//#if -2014639405 
theOffenders = offenders;
//#endif 

} 

//#endif 


//#if 2128612795 
public String getMoreInfoURL()
    { 

//#if 1500041347 
return theMoreInfoURL;
//#endif 

} 

//#endif 


//#if 30998262 
public ToDoItem(Critic c)
    { 

//#if 1414820792 
thePoster = c;
//#endif 


//#if 2085253780 
theHeadline = c.getHeadline();
//#endif 


//#if 721585379 
theOffenders = new ListSet();
//#endif 


//#if 1929639228 
thePriority = c.getPriority(null, null);
//#endif 


//#if -2100051688 
theDescription = c.getDescription(null, null);
//#endif 


//#if 1418197784 
theMoreInfoURL = c.getMoreInfoURL(null, null);
//#endif 


//#if -1877736398 
theWizard = c.makeWizard(this);
//#endif 

} 

//#endif 


//#if 1306797291 
public String getDescription()
    { 

//#if -529595343 
if(cachedExpandedDescription == null)//1
{ 

//#if 762835944 
cachedExpandedDescription =
                thePoster.expand(theDescription, theOffenders);
//#endif 

} 

//#endif 


//#if -356639402 
return cachedExpandedDescription;
//#endif 

} 

//#endif 


//#if 1214682757 
public void deselect()
    { 

//#if -1347758509 
for (Object dm : getOffenders()) //1
{ 

//#if -1756837659 
if(dm instanceof Highlightable)//1
{ 

//#if 1599300820 
((Highlightable) dm).setHighlight(false);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 948473174 
public Icon getClarifier()
    { 

//#if 19026570 
return thePoster.getClarifier();
//#endif 

} 

//#endif 


//#if -2143712967 
public ToDoItem(Critic c, Object dm, Designer dsgr)
    { 

//#if -847547620 
checkArgument(dm);
//#endif 


//#if 1402623509 
thePoster = c;
//#endif 


//#if 518536272 
theHeadline = c.getHeadline(dm, dsgr);
//#endif 


//#if -1920470199 
theOffenders = new ListSet(dm);
//#endif 


//#if 1801365456 
thePriority = c.getPriority(theOffenders, dsgr);
//#endif 


//#if 261790060 
theDescription = c.getDescription(theOffenders, dsgr);
//#endif 


//#if 1853150060 
theMoreInfoURL = c.getMoreInfoURL(theOffenders, dsgr);
//#endif 


//#if -1777498251 
theWizard = c.makeWizard(this);
//#endif 

} 

//#endif 


//#if 1753220730 
public void fixIt()
    { 

//#if -1684038286 
thePoster.fixIt(this, null);
//#endif 

} 

//#endif 


//#if -440569244 
public Wizard getWizard()
    { 

//#if -2078753021 
return theWizard;
//#endif 

} 

//#endif 


//#if -1409831450 
public ToDoItem(Poster poster, String h, int p, String d, String m)
    { 

//#if 1912134689 
thePoster = poster;
//#endif 


//#if -1448480711 
theHeadline = h;
//#endif 


//#if -803216592 
theOffenders = new ListSet();
//#endif 


//#if 253604705 
thePriority = p;
//#endif 


//#if 1402223099 
theDescription = d;
//#endif 


//#if 1108700226 
theMoreInfoURL = m;
//#endif 


//#if -2068767355 
theWizard = null;
//#endif 

} 

//#endif 


//#if -1313026070 
public ToDoItem(Poster poster, String h, int p, String d, String m,
                    ListSet offs)
    { 

//#if 1984063363 
checkOffs(offs);
//#endif 


//#if 524986142 
thePoster = poster;
//#endif 


//#if -1937551780 
theHeadline = h;
//#endif 


//#if 1090098676 
theOffenders = offs;
//#endif 


//#if -235466364 
thePriority = p;
//#endif 


//#if 15074552 
theDescription = d;
//#endif 


//#if -278448321 
theMoreInfoURL = m;
//#endif 


//#if -50101310 
theWizard = null;
//#endif 

} 

//#endif 


//#if 1901922566 
public boolean canFixIt()
    { 

//#if 1935113862 
return thePoster.canFixIt(this);
//#endif 

} 

//#endif 


//#if -1291825104 
public boolean supports(Decision d)
    { 

//#if 1498200204 
return getPoster().supports(d);
//#endif 

} 

//#endif 


//#if -536185691 
@Deprecated
    public void setMoreInfoURL(String m)
    { 

//#if -893986273 
theMoreInfoURL = m;
//#endif 

} 

//#endif 


//#if 1001478567 
public String getHeadline()
    { 

//#if 562441416 
if(cachedExpandedHeadline == null)//1
{ 

//#if 1865846573 
cachedExpandedHeadline =
                thePoster.expand(theHeadline, theOffenders);
//#endif 

} 

//#endif 


//#if 163581435 
return cachedExpandedHeadline;
//#endif 

} 

//#endif 


//#if 323765225 
@Override
    public String toString()
    { 

//#if -679202925 
return this.getClass().getName()
               + "(" + getHeadline() + ") on " + getOffenders().toString();
//#endif 

} 

//#endif 


//#if -849436763 
@Override
    public boolean equals(Object o)
    { 

//#if 730044902 
if(!(o instanceof ToDoItem))//1
{ 

//#if -1683116725 
return false;
//#endif 

} 

//#endif 


//#if 434903082 
ToDoItem i = (ToDoItem) o;
//#endif 


//#if 528593586 
if(!getHeadline().equals(i.getHeadline()))//1
{ 

//#if -1574629724 
return false;
//#endif 

} 

//#endif 


//#if -917108934 
if(!(getPoster() == (i.getPoster())))//1
{ 

//#if -146219201 
return false;
//#endif 

} 

//#endif 


//#if 1566833160 
if(!getOffenders().equals(i.getOffenders()))//1
{ 

//#if -1870102496 
return false;
//#endif 

} 

//#endif 


//#if 553640884 
return true;
//#endif 

} 

//#endif 


//#if 341750695 
public ToDoItem(Critic c, ListSet offs, Designer dsgr)
    { 

//#if -427189268 
checkOffs(offs);
//#endif 


//#if -667842415 
thePoster = c;
//#endif 


//#if 357185625 
theHeadline = c.getHeadline(offs, dsgr);
//#endif 


//#if -1136307171 
theOffenders = offs;
//#endif 


//#if -447171372 
thePriority = c.getPriority(theOffenders, dsgr);
//#endif 


//#if 716166000 
theDescription = c.getDescription(theOffenders, dsgr);
//#endif 


//#if -1987441296 
theMoreInfoURL = c.getMoreInfoURL(theOffenders, dsgr);
//#endif 


//#if -1490412423 
theWizard = c.makeWizard(this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

