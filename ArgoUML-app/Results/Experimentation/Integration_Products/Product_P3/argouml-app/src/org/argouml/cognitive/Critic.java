package org.argouml.cognitive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import javax.swing.Icon;
import org.argouml.application.helpers.ApplicationVersion;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.cognitive.critics.SnoozeOrder;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.configuration.Configuration;
import org.argouml.configuration.ConfigurationKey;
public class Critic extends Observable
 implements Poster
,Serializable
  { 
public static final boolean PROBLEM_FOUND = true;
public static final boolean NO_PROBLEM = false;
private static final String ENABLED = "enabled";
private static final String SNOOZE_ORDER = "snoozeOrder";
public static final String KT_DESIGNERS =
        Translator.localize("misc.knowledge.designers");
public static final String KT_CORRECTNESS =
        Translator.localize("misc.knowledge.correctness");
public static final String KT_COMPLETENESS =
        Translator.localize("misc.knowledge.completeness");
public static final String KT_CONSISTENCY =
        Translator.localize("misc.knowledge.consistency");
public static final String KT_SYNTAX =
        Translator.localize("misc.knowledge.syntax");
public static final String KT_SEMANTICS =
        Translator.localize("misc.knowledge.semantics");
public static final String KT_OPTIMIZATION =
        Translator.localize("misc.knowledge.optimization");
public static final String KT_PRESENTATION =
        Translator.localize("misc.knowledge.presentation");
public static final String KT_ORGANIZATIONAL =
        Translator.localize("misc.knowledge.organizational");
public static final String KT_EXPERIENCIAL =
        Translator.localize("misc.knowledge.experiential");
public static final String KT_TOOL =
        Translator.localize("misc.knowledge.tool");
private int priority;
private String headline;
private String description;
private String moreInfoURL;
@Deprecated
    private Hashtable<String, Object> args = new Hashtable<String, Object>();
public static final Icon DEFAULT_CLARIFIER =
        ResourceLoaderWrapper
        .lookupIconResource("PostIt0");
private Icon clarifier = DEFAULT_CLARIFIER;
private String decisionCategory;
private List<Decision> supportedDecisions = new ArrayList<Decision>();
private List<Goal> supportedGoals = new ArrayList<Goal>();
private String criticType;
private boolean isActive = true;
private Hashtable<String, Object> controlRecs =
        new Hashtable<String, Object>();
private ListSet<String> knowledgeTypes = new ListSet<String>();
private long triggerMask = 0L;
public void initWizard(Wizard w)
    { 
} 
public boolean containsKnowledgeType(String type)
    { 
return knowledgeTypes.contains(type);
} 
public String getMoreInfoURL(ListSet offenders, Designer dsgr)
    { 
return moreInfoURL;
} 
public void setDescription(String d)
    { 
description = d;
} 
public void addSupportedGoal(Goal g)
    { 
supportedGoals.add(g);
} 
public void addKnowledgeType(String type)
    { 
knowledgeTypes.add(type);
} 
public Object getControlRec(String name)
    { 
return controlRecs.get(name);
} 
public void fixIt(ToDoItem item, Object arg)
    { 
} 
public boolean supports(Decision d)
    { 
return supportedDecisions.contains(d);
} 
@Override
    public String toString()
    { 
return getHeadline();
} 
public String getMoreInfoURL()
    { 
return getMoreInfoURL(null, null);
} 
public boolean canFixIt(ToDoItem item)
    { 
return false;
} 
public ConfigurationKey getCriticKey()
    { 
return Configuration.makeKey("critic",
                                     getCriticCategory(),
                                     getCriticName());
} 
public Critic()
    { 
if(Configuration.getBoolean(getCriticKey(), true))//1
{ 
addControlRec(ENABLED, Boolean.TRUE);
isActive = true;
} 
else
{ 
addControlRec(ENABLED, Boolean.FALSE);
isActive = false;
} 
addControlRec(SNOOZE_ORDER, new SnoozeOrder());
criticType = "correctness";
knowledgeTypes.add(KT_CORRECTNESS);
decisionCategory = "Checking";
moreInfoURL = defaultMoreInfoURL();
description = Translator.localize("misc.critic.no-description");
headline = Translator.messageFormat("misc.critic.default-headline",
                                            new Object[] {getClass().getName()});
priority = ToDoItem.MED_PRIORITY;
} 
public String getHeadline(Object dm, Designer dsgr)
    { 
return getHeadline();
} 
public void setPriority(int p)
    { 
priority = p;
} 
public boolean isSnoozed()
    { 
return snoozeOrder().getSnoozed();
} 
public void snooze()
    { 
snoozeOrder().snooze();
} 
public boolean isRelevantToGoals(Designer dsgr)
    { 
return true;
} 
public void addSupportedDecision(Decision d)
    { 
supportedDecisions.add(d);
} 
public Class getWizardClass(ToDoItem item)
    { 
return null;
} 
public Icon getClarifier()
    { 
return clarifier;
} 
public ListSet<String> getKnowledgeTypes()
    { 
return knowledgeTypes;
} 
public static int reasonCodeFor(String s)
    { 
return 1 << (s.hashCode() % 62);
} 
public List<Decision> getSupportedDecisions()
    { 
return supportedDecisions;
} 
public int getPriority()
    { 
return priority;
} 
public String getHeadline(ListSet offenders, Designer dsgr)
    { 
return getHeadline(offenders.get(0), dsgr);
} 
public void unsnooze()
    { 
snoozeOrder().unsnooze();
} 
public void setEnabled(boolean e)
    { 
Boolean enabledBool = e ? Boolean.TRUE : Boolean.FALSE;
addControlRec(ENABLED, enabledBool);
} 
public Wizard makeWizard(ToDoItem item)
    { 
Class wizClass = getWizardClass(item);
if(wizClass != null)//1
{ 
try//1
{ 
Wizard w = (Wizard) wizClass.newInstance();
w.setToDoItem(item);
initWizard(w);
return w;
} 
catch (IllegalAccessException illEx) //1
{ 
} 
catch (InstantiationException instEx) //1
{ 
} 
} 
return null;
} 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 
if(!isActive())//1
{ 
return false;
} 
if(i.getOffenders().size() != 1)//1
{ 
return true;
} 
if(predicate(i.getOffenders().get(0), dsgr))//1
{ 
ToDoItem item = toDoItem(i.getOffenders().get(0), dsgr);
return (item.equals(i));
} 
return false;
} 
public void setKnowledgeTypes(ListSet<String> kt)
    { 
knowledgeTypes = kt;
} 
public final String defaultMoreInfoURL()
    { 
String clsName = getClass().getName();
clsName = clsName.substring(clsName.lastIndexOf(".") + 1);
return ApplicationVersion.getManualForCritic()
               + clsName;
} 
public String getDescription(ListSet offenders, Designer dsgr)
    { 
return description;
} 
public String getDescriptionTemplate()
    { 
return description;
} 
public boolean isActive()
    { 
return isActive;
} 
public boolean matchReason(long patternCode)
    { 
return (triggerMask == 0) || ((triggerMask & patternCode) != 0);
} 
protected void setDecisionCategory(String c)
    { 
decisionCategory = c;
} 
public void setKnowledgeTypes(String t1)
    { 
knowledgeTypes = new ListSet<String>();
addKnowledgeType(t1);
} 
public void setKnowledgeTypes(String t1, String t2, String t3)
    { 
knowledgeTypes = new ListSet<String>();
addKnowledgeType(t1);
addKnowledgeType(t2);
addKnowledgeType(t3);
} 
public boolean supports(Goal g)
    { 
return supportedGoals.contains(g);
} 
public boolean predicate(Object dm, Designer dsgr)
    { 
return false;
} 
public String getCriticName()
    { 
return getClass().getName()
               .substring(getClass().getName().lastIndexOf(".") + 1);
} 
public String getDecisionCategory()
    { 
return decisionCategory;
} 
@Deprecated
    protected void setArg(String name, Object value)
    { 
args.put(name, value);
} 
public String expand(String desc, ListSet offs)
    { 
return desc;
} 
public void postItem(ToDoItem item, Object dm, Designer dsgr)
    { 
if(dm instanceof Offender)//1
{ 
((Offender) dm).inform(item);
} 
dsgr.inform(item);
} 
public void critique(Object dm, Designer dsgr)
    { 
if(predicate(dm, dsgr))//1
{ 
ToDoItem item = toDoItem(dm, dsgr);
postItem(item, dm, dsgr);
} 
} 
public void beActive()
    { 
if(!isActive)//1
{ 
Configuration.setBoolean(getCriticKey(), true);
isActive = true;
setChanged();
notifyObservers(this);
} 
} 
public boolean isEnabled()
    { 
if(this.getCriticName() != null
                && this.getCriticName().equals("CrNoGuard"))//1
{ 
System.currentTimeMillis();
} 
return  ((Boolean) getControlRec(ENABLED)).booleanValue();
} 
public List<Goal> getSupportedGoals()
    { 
return supportedGoals;
} 
public boolean isRelevantToDecisions(Designer dsgr)
    { 
for (Decision d : getSupportedDecisions()) //1
{ 
if(d.getPriority() > 0 && d.getPriority() <= getPriority())//1
{ 
return true;
} 
} 
return false;
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
return ret;
} 
public String getCriticType()
    { 
return criticType;
} 
@Deprecated
    public void setArgs(Hashtable<String, Object> h)
    { 
args = h;
} 
public void beInactive()
    { 
if(isActive)//1
{ 
Configuration.setBoolean(getCriticKey(), false);
isActive = false;
setChanged();
notifyObservers(this);
} 
} 
@Deprecated
    public Hashtable<String, Object> getArgs()
    { 
return args;
} 
public long getTriggerMask()
    { 
return triggerMask;
} 
public String getHeadline()
    { 
return headline;
} 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
return new ToDoItem(this, dm, dsgr);
} 
@Deprecated
    protected Object getArg(String name)
    { 
return args.get(name);
} 
public int getPriority(ListSet offenders, Designer dsgr)
    { 
return priority;
} 
public SnoozeOrder snoozeOrder()
    { 
return (SnoozeOrder) getControlRec(SNOOZE_ORDER);
} 
public void setMoreInfoURL(String m)
    { 
moreInfoURL = m;
} 
public void setHeadline(String h)
    { 
headline = h;
} 
public void setKnowledgeTypes(String t1, String t2)
    { 
knowledgeTypes = new ListSet<String>();
addKnowledgeType(t1);
addKnowledgeType(t2);
} 
public Object addControlRec(String name, Object controlData)
    { 
return controlRecs.put(name, controlData);
} 
public String getCriticCategory()
    { 
return Translator.localize("misc.critic.unclassified");
} 
public void addTrigger(String s)
    { 
int newCode = reasonCodeFor(s);
triggerMask |= newCode;
} 

 } 
