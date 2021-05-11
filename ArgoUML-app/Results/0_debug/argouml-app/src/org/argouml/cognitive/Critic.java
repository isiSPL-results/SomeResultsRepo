
//#if 2060689114 
// Compilation Unit of /Critic.java 
 

//#if -1066092721 
package org.argouml.cognitive;
//#endif 


//#if 1504502374 
import java.io.Serializable;
//#endif 


//#if -1683900002 
import java.util.ArrayList;
//#endif 


//#if -1546160671 
import java.util.HashSet;
//#endif 


//#if 1138861525 
import java.util.Hashtable;
//#endif 


//#if 1611231747 
import java.util.List;
//#endif 


//#if -1053774466 
import java.util.Observable;
//#endif 


//#if 329274547 
import java.util.Set;
//#endif 


//#if -2098137248 
import javax.swing.Icon;
//#endif 


//#if -1948288485 
import org.apache.log4j.Logger;
//#endif 


//#if 101282805 
import org.argouml.application.helpers.ApplicationVersion;
//#endif 


//#if 209278855 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1590085773 
import org.argouml.cognitive.critics.SnoozeOrder;
//#endif 


//#if 2037229462 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -1761241868 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1835424125 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if -960129490 
public class Critic extends 
//#if -1471914980 
Observable
//#endif 

 implements 
//#if -1326925658 
Poster
//#endif 

, 
//#if -86217320 
Serializable
//#endif 

  { 

//#if 1634915817 
private static final Logger LOG = Logger.getLogger(Critic.class);
//#endif 


//#if 184662704 
public static final boolean PROBLEM_FOUND = true;
//#endif 


//#if -977548142 
public static final boolean NO_PROBLEM = false;
//#endif 


//#if 1104029635 
private static final String ENABLED = "enabled";
//#endif 


//#if 1318669464 
private static final String SNOOZE_ORDER = "snoozeOrder";
//#endif 


//#if -198808549 
public static final String KT_DESIGNERS =
        Translator.localize("misc.knowledge.designers");
//#endif 


//#if -1231806551 
public static final String KT_CORRECTNESS =
        Translator.localize("misc.knowledge.correctness");
//#endif 


//#if 1665686107 
public static final String KT_COMPLETENESS =
        Translator.localize("misc.knowledge.completeness");
//#endif 


//#if -1333247429 
public static final String KT_CONSISTENCY =
        Translator.localize("misc.knowledge.consistency");
//#endif 


//#if -1750693701 
public static final String KT_SYNTAX =
        Translator.localize("misc.knowledge.syntax");
//#endif 


//#if -560420975 
public static final String KT_SEMANTICS =
        Translator.localize("misc.knowledge.semantics");
//#endif 


//#if -1510089541 
public static final String KT_OPTIMIZATION =
        Translator.localize("misc.knowledge.optimization");
//#endif 


//#if -1881746149 
public static final String KT_PRESENTATION =
        Translator.localize("misc.knowledge.presentation");
//#endif 


//#if -785324133 
public static final String KT_ORGANIZATIONAL =
        Translator.localize("misc.knowledge.organizational");
//#endif 


//#if -1434501492 
public static final String KT_EXPERIENCIAL =
        Translator.localize("misc.knowledge.experiential");
//#endif 


//#if -1579718821 
public static final String KT_TOOL =
        Translator.localize("misc.knowledge.tool");
//#endif 


//#if 1715801714 
private int priority;
//#endif 


//#if 1779304748 
private String headline;
//#endif 


//#if -1525220006 
private String description;
//#endif 


//#if 1133689482 
private String moreInfoURL;
//#endif 


//#if 141068561 
@Deprecated
    private Hashtable<String, Object> args = new Hashtable<String, Object>();
//#endif 


//#if -1386116543 
public static final Icon DEFAULT_CLARIFIER =
        ResourceLoaderWrapper
        .lookupIconResource("PostIt0");
//#endif 


//#if 1319190331 
private Icon clarifier = DEFAULT_CLARIFIER;
//#endif 


//#if -1809010234 
private String decisionCategory;
//#endif 


//#if 1981750391 
private List<Decision> supportedDecisions = new ArrayList<Decision>();
//#endif 


//#if -2045116480 
private List<Goal> supportedGoals = new ArrayList<Goal>();
//#endif 


//#if 332773170 
private String criticType;
//#endif 


//#if 235839006 
private boolean isActive = true;
//#endif 


//#if 1226910529 
private Hashtable<String, Object> controlRecs =
        new Hashtable<String, Object>();
//#endif 


//#if 1341443310 
private ListSet<String> knowledgeTypes = new ListSet<String>();
//#endif 


//#if 879887200 
private long triggerMask = 0L;
//#endif 


//#if 1468029780 
public void initWizard(Wizard w)
    { 
} 

//#endif 


//#if -706577047 
public boolean containsKnowledgeType(String type)
    { 

//#if 589950650 
return knowledgeTypes.contains(type);
//#endif 

} 

//#endif 


//#if 1960082253 
public String getMoreInfoURL(ListSet offenders, Designer dsgr)
    { 

//#if 1877472105 
return moreInfoURL;
//#endif 

} 

//#endif 


//#if 292764782 
public void setDescription(String d)
    { 

//#if 1632353675 
description = d;
//#endif 

} 

//#endif 


//#if -2002996089 
public void addSupportedGoal(Goal g)
    { 

//#if 14754955 
supportedGoals.add(g);
//#endif 

} 

//#endif 


//#if -322509341 
public void addKnowledgeType(String type)
    { 

//#if -1992435520 
knowledgeTypes.add(type);
//#endif 

} 

//#endif 


//#if 458846285 
public Object getControlRec(String name)
    { 

//#if -1162204672 
return controlRecs.get(name);
//#endif 

} 

//#endif 


//#if -1182656684 
public void fixIt(ToDoItem item, Object arg)
    { 
} 

//#endif 


//#if 1894873183 
public boolean supports(Decision d)
    { 

//#if -401616108 
return supportedDecisions.contains(d);
//#endif 

} 

//#endif 


//#if -1651648038 
@Override
    public String toString()
    { 

//#if -2056158321 
return getHeadline();
//#endif 

} 

//#endif 


//#if -330128022 
public String getMoreInfoURL()
    { 

//#if 1294957764 
return getMoreInfoURL(null, null);
//#endif 

} 

//#endif 


//#if 433895723 
public boolean canFixIt(ToDoItem item)
    { 

//#if 557051572 
return false;
//#endif 

} 

//#endif 


//#if 1477342817 
public ConfigurationKey getCriticKey()
    { 

//#if -892960988 
return Configuration.makeKey("critic",
                                     getCriticCategory(),
                                     getCriticName());
//#endif 

} 

//#endif 


//#if -549219273 
public Critic()
    { 

//#if -2098243554 
if(Configuration.getBoolean(getCriticKey(), true))//1
{ 

//#if -1505470747 
addControlRec(ENABLED, Boolean.TRUE);
//#endif 


//#if 89172480 
isActive = true;
//#endif 

} 
else
{ 

//#if 404203078 
addControlRec(ENABLED, Boolean.FALSE);
//#endif 


//#if -1528978277 
isActive = false;
//#endif 

} 

//#endif 


//#if -708912320 
addControlRec(SNOOZE_ORDER, new SnoozeOrder());
//#endif 


//#if 1044912681 
criticType = "correctness";
//#endif 


//#if -894974439 
knowledgeTypes.add(KT_CORRECTNESS);
//#endif 


//#if 837609616 
decisionCategory = "Checking";
//#endif 


//#if 758127776 
moreInfoURL = defaultMoreInfoURL();
//#endif 


//#if -1041066348 
description = Translator.localize("misc.critic.no-description");
//#endif 


//#if 290352685 
headline = Translator.messageFormat("misc.critic.default-headline",
                                            new Object[] {getClass().getName()});
//#endif 


//#if 838388714 
priority = ToDoItem.MED_PRIORITY;
//#endif 

} 

//#endif 


//#if -1127561679 
public String getHeadline(Object dm, Designer dsgr)
    { 

//#if -931746224 
return getHeadline();
//#endif 

} 

//#endif 


//#if 1782113008 
public void setPriority(int p)
    { 

//#if 1329406341 
priority = p;
//#endif 

} 

//#endif 


//#if -2020628817 
public boolean isSnoozed()
    { 

//#if 901305996 
return snoozeOrder().getSnoozed();
//#endif 

} 

//#endif 


//#if 96161181 
public void snooze()
    { 

//#if 1487455784 
snoozeOrder().snooze();
//#endif 

} 

//#endif 


//#if 170892020 
public boolean isRelevantToGoals(Designer dsgr)
    { 

//#if 299985565 
return true;
//#endif 

} 

//#endif 


//#if -1922466102 
public void addSupportedDecision(Decision d)
    { 

//#if 1774356254 
supportedDecisions.add(d);
//#endif 

} 

//#endif 


//#if -1827458942 
public Class getWizardClass(ToDoItem item)
    { 

//#if 637327522 
return null;
//#endif 

} 

//#endif 


//#if -1834986363 
public Icon getClarifier()
    { 

//#if -35969223 
return clarifier;
//#endif 

} 

//#endif 


//#if 1950249503 
public ListSet<String> getKnowledgeTypes()
    { 

//#if 1557128013 
return knowledgeTypes;
//#endif 

} 

//#endif 


//#if -1181523306 
public static int reasonCodeFor(String s)
    { 

//#if 1357386937 
return 1 << (s.hashCode() % 62);
//#endif 

} 

//#endif 


//#if 1940770586 
public List<Decision> getSupportedDecisions()
    { 

//#if -2003266884 
return supportedDecisions;
//#endif 

} 

//#endif 


//#if -1906745426 
public int getPriority()
    { 

//#if 334550428 
return priority;
//#endif 

} 

//#endif 


//#if -1102743777 
public String getHeadline(ListSet offenders, Designer dsgr)
    { 

//#if -128094336 
return getHeadline(offenders.get(0), dsgr);
//#endif 

} 

//#endif 


//#if -985825866 
public void unsnooze()
    { 

//#if 693717654 
snoozeOrder().unsnooze();
//#endif 

} 

//#endif 


//#if -882542503 
public void setEnabled(boolean e)
    { 

//#if 259739390 
Boolean enabledBool = e ? Boolean.TRUE : Boolean.FALSE;
//#endif 


//#if 187445488 
addControlRec(ENABLED, enabledBool);
//#endif 

} 

//#endif 


//#if -818299109 
public Wizard makeWizard(ToDoItem item)
    { 

//#if -2054217682 
Class wizClass = getWizardClass(item);
//#endif 


//#if 247336243 
if(wizClass != null)//1
{ 

//#if -116915044 
try //1
{ 

//#if -1772963051 
Wizard w = (Wizard) wizClass.newInstance();
//#endif 


//#if 1054546832 
w.setToDoItem(item);
//#endif 


//#if 1815017379 
initWizard(w);
//#endif 


//#if -1015996197 
return w;
//#endif 

} 

//#if 2052837862 
catch (IllegalAccessException illEx) //1
{ 

//#if 449628792 
LOG.error("Could not access wizard: ", illEx);
//#endif 

} 

//#endif 


//#if 536652556 
catch (InstantiationException instEx) //1
{ 

//#if -581231323 
LOG.error("Could not instantiate wizard: ", instEx);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 212055473 
return null;
//#endif 

} 

//#endif 


//#if 1179948154 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -877327979 
if(!isActive())//1
{ 

//#if 431193743 
LOG.warn("got to stillvalid while not active");
//#endif 


//#if 1868247836 
return false;
//#endif 

} 

//#endif 


//#if -1666647780 
if(i.getOffenders().size() != 1)//1
{ 

//#if 1715944646 
return true;
//#endif 

} 

//#endif 


//#if 830437924 
if(predicate(i.getOffenders().get(0), dsgr))//1
{ 

//#if 1507364898 
ToDoItem item = toDoItem(i.getOffenders().get(0), dsgr);
//#endif 


//#if 782428381 
return (item.equals(i));
//#endif 

} 

//#endif 


//#if -1510877298 
return false;
//#endif 

} 

//#endif 


//#if -2146617044 
public void setKnowledgeTypes(ListSet<String> kt)
    { 

//#if -295566716 
knowledgeTypes = kt;
//#endif 

} 

//#endif 


//#if -926942255 
public final String defaultMoreInfoURL()
    { 

//#if 1248674401 
String clsName = getClass().getName();
//#endif 


//#if -1646041189 
clsName = clsName.substring(clsName.lastIndexOf(".") + 1);
//#endif 


//#if 1072391747 
return ApplicationVersion.getManualForCritic()
               + clsName;
//#endif 

} 

//#endif 


//#if 1478226461 
public String getDescription(ListSet offenders, Designer dsgr)
    { 

//#if -1166568194 
return description;
//#endif 

} 

//#endif 


//#if 1377928628 
public String getDescriptionTemplate()
    { 

//#if -272152381 
return description;
//#endif 

} 

//#endif 


//#if -189361513 
public boolean isActive()
    { 

//#if 1188481654 
return isActive;
//#endif 

} 

//#endif 


//#if -1391409971 
public boolean matchReason(long patternCode)
    { 

//#if -798587756 
return (triggerMask == 0) || ((triggerMask & patternCode) != 0);
//#endif 

} 

//#endif 


//#if 1752375212 
protected void setDecisionCategory(String c)
    { 

//#if 814730185 
decisionCategory = c;
//#endif 

} 

//#endif 


//#if 106999802 
public void setKnowledgeTypes(String t1)
    { 

//#if -1806297831 
knowledgeTypes = new ListSet<String>();
//#endif 


//#if -227754358 
addKnowledgeType(t1);
//#endif 

} 

//#endif 


//#if 2093323129 
public void setKnowledgeTypes(String t1, String t2, String t3)
    { 

//#if 1340975711 
knowledgeTypes = new ListSet<String>();
//#endif 


//#if 1715602948 
addKnowledgeType(t1);
//#endif 


//#if 1715603909 
addKnowledgeType(t2);
//#endif 


//#if 1715604870 
addKnowledgeType(t3);
//#endif 

} 

//#endif 


//#if -1811798733 
public boolean supports(Goal g)
    { 

//#if -1336122694 
return supportedGoals.contains(g);
//#endif 

} 

//#endif 


//#if 339795415 
public boolean predicate(Object dm, Designer dsgr)
    { 

//#if -433817387 
return false;
//#endif 

} 

//#endif 


//#if -305071069 
public String getCriticName()
    { 

//#if 1526561062 
return getClass().getName()
               .substring(getClass().getName().lastIndexOf(".") + 1);
//#endif 

} 

//#endif 


//#if 985414398 
public String getDecisionCategory()
    { 

//#if -332493008 
return decisionCategory;
//#endif 

} 

//#endif 


//#if 784202715 
@Deprecated
    protected void setArg(String name, Object value)
    { 

//#if -1730547423 
args.put(name, value);
//#endif 

} 

//#endif 


//#if -1090239696 
public String expand(String desc, ListSet offs)
    { 

//#if 2140009357 
return desc;
//#endif 

} 

//#endif 


//#if -1530993727 
public void postItem(ToDoItem item, Object dm, Designer dsgr)
    { 

//#if -1172891946 
if(dm instanceof Offender)//1
{ 

//#if 383820274 
((Offender) dm).inform(item);
//#endif 

} 

//#endif 


//#if -1218605317 
dsgr.inform(item);
//#endif 

} 

//#endif 


//#if 1874198880 
public void critique(Object dm, Designer dsgr)
    { 

//#if 469401964 
if(predicate(dm, dsgr))//1
{ 

//#if -947019414 
ToDoItem item = toDoItem(dm, dsgr);
//#endif 


//#if 1103423140 
postItem(item, dm, dsgr);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -441139552 
public void beActive()
    { 

//#if -254689215 
if(!isActive)//1
{ 

//#if -1822153805 
Configuration.setBoolean(getCriticKey(), true);
//#endif 


//#if 225044391 
isActive = true;
//#endif 


//#if -1926058815 
setChanged();
//#endif 


//#if 657839723 
notifyObservers(this);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1883639282 
public boolean isEnabled()
    { 

//#if -1799394612 
if(this.getCriticName() != null
                && this.getCriticName().equals("CrNoGuard"))//1
{ 

//#if -841883691 
System.currentTimeMillis();
//#endif 

} 

//#endif 


//#if 2122987945 
return  ((Boolean) getControlRec(ENABLED)).booleanValue();
//#endif 

} 

//#endif 


//#if 1977204026 
public List<Goal> getSupportedGoals()
    { 

//#if 108628729 
return supportedGoals;
//#endif 

} 

//#endif 


//#if 720827147 
public boolean isRelevantToDecisions(Designer dsgr)
    { 

//#if 422169131 
for (Decision d : getSupportedDecisions()) //1
{ 

//#if -354821386 
if(d.getPriority() > 0 && d.getPriority() <= getPriority())//1
{ 

//#if 1837631988 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1321585684 
return false;
//#endif 

} 

//#endif 


//#if -1211567656 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1077294081 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -759194425 
return ret;
//#endif 

} 

//#endif 


//#if -111042286 
public String getCriticType()
    { 

//#if 243594937 
return criticType;
//#endif 

} 

//#endif 


//#if 106536193 
@Deprecated
    public void setArgs(Hashtable<String, Object> h)
    { 

//#if -1740717668 
args = h;
//#endif 

} 

//#endif 


//#if 1452487813 
public void beInactive()
    { 

//#if -2094568956 
if(isActive)//1
{ 

//#if 1364080503 
Configuration.setBoolean(getCriticKey(), false);
//#endif 


//#if 104855411 
isActive = false;
//#endif 


//#if -1472440842 
setChanged();
//#endif 


//#if 1965996246 
notifyObservers(this);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 211623537 
@Deprecated
    public Hashtable<String, Object> getArgs()
    { 

//#if -1588631508 
return args;
//#endif 

} 

//#endif 


//#if 277577773 
public long getTriggerMask()
    { 

//#if 422803912 
return triggerMask;
//#endif 

} 

//#endif 


//#if 613578840 
public String getHeadline()
    { 

//#if 996736939 
return headline;
//#endif 

} 

//#endif 


//#if -2015887180 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if -1253176876 
return new ToDoItem(this, dm, dsgr);
//#endif 

} 

//#endif 


//#if 447619960 
@Deprecated
    protected Object getArg(String name)
    { 

//#if -1308969493 
return args.get(name);
//#endif 

} 

//#endif 


//#if -1155688567 
public int getPriority(ListSet offenders, Designer dsgr)
    { 

//#if 350607260 
return priority;
//#endif 

} 

//#endif 


//#if -997511229 
public SnoozeOrder snoozeOrder()
    { 

//#if 468960266 
return (SnoozeOrder) getControlRec(SNOOZE_ORDER);
//#endif 

} 

//#endif 


//#if 1471597237 
public void setMoreInfoURL(String m)
    { 

//#if -1231684520 
moreInfoURL = m;
//#endif 

} 

//#endif 


//#if -687097734 
public void setHeadline(String h)
    { 

//#if 751694066 
headline = h;
//#endif 

} 

//#endif 


//#if 850604157 
public void setKnowledgeTypes(String t1, String t2)
    { 

//#if 632886037 
knowledgeTypes = new ListSet<String>();
//#endif 


//#if -1249572850 
addKnowledgeType(t1);
//#endif 


//#if -1249571889 
addKnowledgeType(t2);
//#endif 

} 

//#endif 


//#if 1678801372 
public Object addControlRec(String name, Object controlData)
    { 

//#if -144810860 
return controlRecs.put(name, controlData);
//#endif 

} 

//#endif 


//#if 779217494 
public String getCriticCategory()
    { 

//#if 1623688526 
return Translator.localize("misc.critic.unclassified");
//#endif 

} 

//#endif 


//#if -787405758 
public void addTrigger(String s)
    { 

//#if -994645764 
int newCode = reasonCodeFor(s);
//#endif 


//#if -1079722707 
triggerMask |= newCode;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

