
//#if 1796814478 
// Compilation Unit of /Designer.java 
 

//#if 1518168935 
package org.argouml.cognitive;
//#endif 


//#if -387452581 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1022965581 
import java.beans.PropertyChangeListener;
//#endif 


//#if -621063098 
import java.beans.PropertyChangeSupport;
//#endif 


//#if 578501766 
import java.util.ArrayList;
//#endif 


//#if -1159990698 
import java.util.Enumeration;
//#endif 


//#if 213106203 
import java.util.List;
//#endif 


//#if 1596517798 
import java.util.Properties;
//#endif 


//#if 1536837083 
import javax.swing.Action;
//#endif 


//#if -1372021384 
import javax.swing.Icon;
//#endif 


//#if 854411523 
import org.apache.log4j.Logger;
//#endif 


//#if -1905959535 
import org.argouml.application.api.Argo;
//#endif 


//#if 1319670748 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1818796389 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if 1270597109 
import org.argouml.model.InvalidElementException;
//#endif 


//#if -954520714 
import org.tigris.gef.util.ChildGenerator;
//#endif 


//#if -2009939289 
import org.tigris.gef.util.EnumerationEmpty;
//#endif 


//#if 300272467 
public final class Designer implements 
//#if 549233832 
Poster
//#endif 

, 
//#if -395374664 
Runnable
//#endif 

, 
//#if -313233644 
PropertyChangeListener
//#endif 

  { 

//#if -2133132066 
private static final Logger LOG = Logger.getLogger(Designer.class);
//#endif 


//#if -1776730948 
private static Designer theDesignerSingleton = new Designer();
//#endif 


//#if -915314073 
private static boolean userWorking;
//#endif 


//#if -1349042366 
private static List<Decision> unspecifiedDecision;
//#endif 


//#if -611261932 
private static List<Goal> unspecifiedGoal;
//#endif 


//#if 2043525404 
private static Action saveAction;
//#endif 


//#if 689355146 
public static final ConfigurationKey AUTO_CRITIQUE =
        Configuration.makeKey("cognitive", "autocritique");
//#endif 


//#if 1880265771 
private ToDoList toDoList;
//#endif 


//#if -623897530 
private Properties prefs;
//#endif 


//#if 2029859756 
private String designerName;
//#endif 


//#if -1999007575 
private DecisionModel decisions;
//#endif 


//#if 428457225 
private GoalModel goals;
//#endif 


//#if -658179991 
private Agency agency;
//#endif 


//#if -1501773155 
private Icon clarifier;
//#endif 


//#if -140489469 
private Thread critiquerThread;
//#endif 


//#if -1769575072 
private int critiquingInterval;
//#endif 


//#if 1164261317 
private int critiqueCPUPercent;
//#endif 


//#if -1106418514 
private List<Object> hotQueue;
//#endif 


//#if -2094128177 
private List<Long> hotReasonQueue;
//#endif 


//#if -350373374 
private List<Object> addQueue;
//#endif 


//#if 1903569443 
private List<Long> addReasonQueue;
//#endif 


//#if -234577193 
private List<Object> removeQueue;
//#endif 


//#if -905876309 
private static int longestAdd;
//#endif 


//#if -905656705 
private static int longestHot;
//#endif 


//#if -184099240 
private List<Object> warmQueue;
//#endif 


//#if 94848837 
private ChildGenerator childGenerator;
//#endif 


//#if -662793099 
private static Object critiquingRoot;
//#endif 


//#if 1621811985 
private long critiqueDuration;
//#endif 


//#if 583799575 
private int critiqueLock;
//#endif 


//#if -1408763121 
private static PropertyChangeSupport pcs;
//#endif 


//#if -1274774957 
public static final String MODEL_TODOITEM_ADDED =
        "MODEL_TODOITEM_ADDED";
//#endif 


//#if -1110963099 
public static final String MODEL_TODOITEM_DISMISSED =
        "MODEL_TODOITEM_DISMISSED";
//#endif 


//#if -1910524284 
private static final long serialVersionUID = -3647853023882216454L;
//#endif 


//#if -1098960110 
static
    {
        unspecifiedDecision = new ArrayList<Decision>();
        unspecifiedDecision.add(Decision.UNSPEC);
        unspecifiedGoal = new ArrayList<Goal>();
        unspecifiedGoal.add(Goal.getUnspecifiedGoal());
    }
//#endif 


//#if -1367759767 
public boolean canFixIt(ToDoItem item)
    { 

//#if -144248519 
return false;
//#endif 

} 

//#endif 


//#if -1966047596 
public void run()
    { 

//#if -1640287096 
try //1
{ 

//#if -532392083 
while (true) //1
{ 

//#if 190175337 
long critiqueStartTime;
//#endif 


//#if 1735118102 
long cutoffTime;
//#endif 


//#if -103523787 
int minWarmElements = 5;
//#endif 


//#if 520577274 
int size;
//#endif 


//#if 453843947 
synchronized (this) //1
{ 

//#if -242805577 
while (!Configuration.getBoolean(
                                Designer.AUTO_CRITIQUE, true)) //1
{ 

//#if 374409990 
try //1
{ 

//#if -1645935422 
this.wait();
//#endif 

} 

//#if -1368720905 
catch (InterruptedException ignore) //1
{ 

//#if 1872468660 
LOG.error("InterruptedException!!!", ignore);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -43698542 
if(critiquingRoot != null
//                      && getAutoCritique()
                        && critiqueLock <= 0)//1
{ 

//#if -1495685463 
synchronized (this) //1
{ 

//#if 663600217 
critiqueStartTime = System.currentTimeMillis();
//#endif 


//#if -1599137663 
cutoffTime = critiqueStartTime + 3000;
//#endif 


//#if -2138942173 
size = addQueue.size();
//#endif 


//#if -1496841147 
for (int i = 0; i < size; i++) //1
{ 

//#if 1145465623 
hotQueue.add(addQueue.get(i));
//#endif 


//#if -1119100585 
hotReasonQueue.add(addReasonQueue.get(i));
//#endif 

} 

//#endif 


//#if 622251831 
addQueue.clear();
//#endif 


//#if 866068699 
addReasonQueue.clear();
//#endif 


//#if 866882073 
longestHot = Math.max(longestHot, hotQueue.size());
//#endif 


//#if 373094141 
agency.determineActiveCritics(this);
//#endif 


//#if 1771492539 
while (hotQueue.size() > 0) //1
{ 

//#if -450633561 
Object dm = hotQueue.get(0);
//#endif 


//#if -2141065890 
Long reasonCode =
                                hotReasonQueue.get(0);
//#endif 


//#if 134172500 
hotQueue.remove(0);
//#endif 


//#if -1762769160 
hotReasonQueue.remove(0);
//#endif 


//#if 123644684 
Agency.applyAllCritics(dm, theDesigner(),
                                                   reasonCode.longValue());
//#endif 

} 

//#endif 


//#if -784133040 
size = removeQueue.size();
//#endif 


//#if -2044066740 
for (int i = 0; i < size; i++) //2
{ 

//#if -86341397 
warmQueue.remove(removeQueue.get(i));
//#endif 

} 

//#endif 


//#if 1082969666 
removeQueue.clear();
//#endif 


//#if -365519203 
if(warmQueue.size() == 0)//1
{ 

//#if 218335376 
warmQueue.add(critiquingRoot);
//#endif 

} 

//#endif 


//#if 1434206482 
while (warmQueue.size() > 0
                                && (System.currentTimeMillis() < cutoffTime
                                    || minWarmElements > 0)) //1
{ 

//#if -1970500764 
if(minWarmElements > 0)//1
{ 

//#if -531574306 
minWarmElements--;
//#endif 

} 

//#endif 


//#if -1601045152 
Object dm = warmQueue.get(0);
//#endif 


//#if 1594403143 
warmQueue.remove(0);
//#endif 


//#if 29688797 
try //1
{ 

//#if 1457878431 
Agency.applyAllCritics(dm, theDesigner());
//#endif 


//#if -1662573844 
java.util.Enumeration subDMs =
                                    childGenerator.gen(dm);
//#endif 


//#if 1219497460 
while (subDMs.hasMoreElements()) //1
{ 

//#if 922747547 
Object nextDM = subDMs.nextElement();
//#endif 


//#if 1770418657 
if(!(warmQueue.contains(nextDM)))//1
{ 

//#if -947815306 
warmQueue.add(nextDM);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if 623574006 
catch (InvalidElementException e) //1
{ 

//#if 42692940 
LOG.warn("Element " + dm
                                         + "caused an InvalidElementException.  "
                                         + "Ignoring for this pass.");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if -208295986 
critiqueStartTime = System.currentTimeMillis();
//#endif 

} 

//#endif 


//#if 965147413 
critiqueDuration =
                    System.currentTimeMillis() - critiqueStartTime;
//#endif 


//#if -122578177 
long cycleDuration =
                    (critiqueDuration * 100) / critiqueCPUPercent;
//#endif 


//#if -1695602013 
long sleepDuration =
                    Math.min(cycleDuration - critiqueDuration, 3000);
//#endif 


//#if -2041288197 
sleepDuration = Math.max(sleepDuration, 1000);
//#endif 


//#if 406718478 
LOG.debug("sleepDuration= " + sleepDuration);
//#endif 


//#if -1910926939 
try //1
{ 

//#if -1840998953 
Thread.sleep(sleepDuration);
//#endif 

} 

//#if -271484054 
catch (InterruptedException ignore) //1
{ 

//#if -1789685748 
LOG.error("InterruptedException!!!", ignore);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#if 1399861045 
catch (Exception e) //1
{ 

//#if -1095511471 
LOG.error("Critic thread killed by exception", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2038916110 
public void setAutoCritique(boolean b)
    { 

//#if -157688466 
Configuration.setBoolean(Designer.AUTO_CRITIQUE, b);
//#endif 


//#if 579316631 
synchronized (this) //1
{ 

//#if -2082864414 
if(b)//1
{ 

//#if 1216576188 
this.notifyAll();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2041292765 
public void setClarifier(Icon clar)
    { 

//#if 1099543194 
clarifier = clar;
//#endif 

} 

//#endif 


//#if 1724030040 
public List<Decision> getSupportedDecisions()
    { 

//#if -1139311421 
return unspecifiedDecision;
//#endif 

} 

//#endif 


//#if 2006630251 
public boolean containsKnowledgeType(String type)
    { 

//#if 988056020 
return type.equals("Designer's");
//#endif 

} 

//#endif 


//#if -1940246593 
public void determineActiveCritics()
    { 

//#if -462721460 
agency.determineActiveCritics(this);
//#endif 

} 

//#endif 


//#if -1619198957 
public ChildGenerator getChildGenerator()
    { 

//#if -1173800137 
return childGenerator;
//#endif 

} 

//#endif 


//#if 1017627614 
public void stopDesiring(String goal)
    { 

//#if -1891614408 
goals.stopDesiring(goal);
//#endif 

} 

//#endif 


//#if 323897522 
public Properties getPrefs()
    { 

//#if 1091780911 
return prefs;
//#endif 

} 

//#endif 


//#if 1549134862 
public boolean isConsidering(Decision d)
    { 

//#if 1653546015 
return d.getPriority() > 0;
//#endif 

} 

//#endif 


//#if -531734829 
public Agency getAgency()
    { 

//#if -1465653825 
return agency;
//#endif 

} 

//#endif 


//#if -274456671 
public void propertyChange(PropertyChangeEvent pce)
    { 

//#if 1239892943 
if(pce.getPropertyName().equals(Argo.KEY_USER_FULLNAME.getKey()))//1
{ 

//#if -182811150 
designerName = pce.getNewValue().toString();
//#endif 

} 
else
{ 

//#if 117885696 
critiqueASAP(pce.getSource(), pce.getPropertyName());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 488146401 
public boolean supports(Decision d)
    { 

//#if -493864327 
return d == Decision.UNSPEC;
//#endif 

} 

//#endif 


//#if -225490523 
public void setDesignerName(String name)
    { 

//#if -2054108695 
designerName = name;
//#endif 

} 

//#endif 


//#if 104174119 
public void setChildGenerator(ChildGenerator cg)
    { 

//#if 608684278 
childGenerator = cg;
//#endif 

} 

//#endif 


//#if 774378711 
public void setGoalPriority(String goal, int priority)
    { 

//#if 1000174985 
goals.setGoalPriority(goal, priority);
//#endif 

} 

//#endif 


//#if 1219784499 
public ToDoList getToDoList()
    { 

//#if -1698784162 
return toDoList;
//#endif 

} 

//#endif 


//#if -498964094 
public static void addListener(PropertyChangeListener pcl)
    { 

//#if -1979841287 
if(pcs == null)//1
{ 

//#if -2129971127 
pcs = new PropertyChangeSupport(theDesigner());
//#endif 

} 

//#endif 


//#if -988306634 
LOG.debug("addPropertyChangeListener(" + pcl + ")");
//#endif 


//#if 752541690 
pcs.addPropertyChangeListener(pcl);
//#endif 

} 

//#endif 


//#if 1531497497 
public synchronized void critiqueASAP(Object dm, String reason)
    { 

//#if 51597844 
long rCode = Critic.reasonCodeFor(reason);
//#endif 


//#if -1001788090 
if(!userWorking)//1
{ 

//#if -732682729 
return;
//#endif 

} 

//#endif 


//#if -784126659 
if("remove".equals(reason))//1
{ 

//#if 22672749 
return;
//#endif 

} 

//#endif 


//#if 41886810 
LOG.debug("critiqueASAP:" + dm);
//#endif 


//#if 659486432 
int addQueueIndex = addQueue.indexOf(dm);
//#endif 


//#if -1143794667 
if(addQueueIndex == -1)//1
{ 

//#if 2141156262 
addQueue.add(dm);
//#endif 


//#if -2095961928 
Long reasonCodeObj = new Long(rCode);
//#endif 


//#if 905132777 
addReasonQueue.add(reasonCodeObj);
//#endif 

} 
else
{ 

//#if -99027179 
Long reasonCodeObj =
                addReasonQueue.get(addQueueIndex);
//#endif 


//#if 585122712 
long rc = reasonCodeObj.longValue() | rCode;
//#endif 


//#if 706040168 
Long newReasonCodeObj = new Long(rc);
//#endif 


//#if -644796152 
addReasonQueue.set(addQueueIndex, newReasonCodeObj);
//#endif 

} 

//#endif 


//#if -1597797419 
removeQueue.add(dm);
//#endif 


//#if -609986829 
longestAdd = Math.max(longestAdd, addQueue.size());
//#endif 

} 

//#endif 


//#if -2122629576 
public void unsnooze()
    { 
} 

//#endif 


//#if -2051594761 
public static Object getCritiquingRoot()
    { 

//#if -1320319414 
synchronized (theDesigner()) //1
{ 

//#if -462942927 
return critiquingRoot;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2128215033 
public Icon getClarifier()
    { 

//#if 1783066396 
return clarifier;
//#endif 

} 

//#endif 


//#if -1826933870 
public void fixIt(ToDoItem item, Object arg) { 
} 

//#endif 


//#if 249367905 
public DecisionModel getDecisionModel()
    { 

//#if -567548248 
return decisions;
//#endif 

} 

//#endif 


//#if -311553000 
@Override
    public String toString()
    { 

//#if 446681940 
return getDesignerName();
//#endif 

} 

//#endif 


//#if 1631601589 
public boolean supports(Goal g)
    { 

//#if 1429687988 
return true;
//#endif 

} 

//#endif 


//#if -305136185 
public static boolean isUserWorking()
    { 

//#if 2052107447 
return userWorking;
//#endif 

} 

//#endif 


//#if -760640836 
public static void removeListener(PropertyChangeListener p)
    { 

//#if 952380179 
if(pcs != null)//1
{ 

//#if 408041907 
LOG.debug("removePropertyChangeListener()");
//#endif 


//#if -165594939 
pcs.removePropertyChangeListener(p);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1071207769 
public static void enableCritiquing()
    { 

//#if 605958966 
synchronized (theDesigner()) //1
{ 

//#if 1535830365 
theDesigner().critiqueLock--;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1023656570 
public boolean hasGoal(String goal)
    { 

//#if -1901110538 
return goals.hasGoal(goal);
//#endif 

} 

//#endif 


//#if 162255383 
public static void clearCritiquing()
    { 

//#if 1880488636 
synchronized (theDesigner()) //1
{ 

//#if -1238490004 
theDesigner().toDoList.removeAllElements();
//#endif 


//#if -51662733 
theDesigner().hotQueue.clear();
//#endif 


//#if -1669518057 
theDesigner().hotReasonQueue.clear();
//#endif 


//#if 2034987463 
theDesigner().addQueue.clear();
//#endif 


//#if 64200555 
theDesigner().addReasonQueue.clear();
//#endif 


//#if 1505649074 
theDesigner().removeQueue.clear();
//#endif 


//#if 1608257267 
theDesigner().warmQueue.clear();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 942130140 
public boolean stillValid(ToDoItem i, Designer d)
    { 

//#if -69119906 
return true;
//#endif 

} 

//#endif 


//#if 244593686 
public void inform(ToDoItem item)
    { 

//#if -1919277717 
toDoList.addElement(item);
//#endif 

} 

//#endif 


//#if 669969792 
public static Designer theDesigner()
    { 

//#if 417136362 
return theDesignerSingleton;
//#endif 

} 

//#endif 


//#if -1341257484 
private Designer()
    { 

//#if -746142918 
decisions = new DecisionModel();
//#endif 


//#if -1128791782 
goals = new GoalModel();
//#endif 


//#if 9596608 
agency = new Agency();
//#endif 


//#if 1772865985 
prefs = new Properties();
//#endif 


//#if 19822786 
toDoList = new ToDoList();
//#endif 


//#if 628860787 
toDoList.spawnValidityChecker(this);
//#endif 


//#if 261674364 
userWorking = false;
//#endif 


//#if 839680327 
critiquingInterval = 8000;
//#endif 


//#if 1821171579 
critiqueCPUPercent = 10;
//#endif 


//#if 1858100884 
hotQueue = new ArrayList<Object>();
//#endif 


//#if 365140141 
hotReasonQueue = new ArrayList<Long>();
//#endif 


//#if -995931456 
addQueue = new ArrayList<Object>();
//#endif 


//#if -1430483239 
addReasonQueue = new ArrayList<Long>();
//#endif 


//#if 1292680643 
removeQueue = new ArrayList<Object>();
//#endif 


//#if 2080027044 
longestAdd = 0;
//#endif 


//#if -2003900808 
longestHot = 0;
//#endif 


//#if 1416925218 
warmQueue = new ArrayList<Object>();
//#endif 


//#if -544779523 
childGenerator = new EmptyChildGenerator();
//#endif 


//#if 1522434814 
critiqueLock = 0;
//#endif 

} 

//#endif 


//#if -812348937 
public void setDecisionPriority(String decision, int priority)
    { 

//#if 1313551731 
decisions.setDecisionPriority(decision, priority);
//#endif 

} 

//#endif 


//#if -320718595 
public void spawnCritiquer(Object root)
    { 

//#if 898721402 
critiquerThread = new Thread(this, "CritiquingThread");
//#endif 


//#if -954075230 
critiquerThread.setDaemon(true);
//#endif 


//#if -397336027 
critiquerThread.setPriority(Thread.currentThread().getPriority() - 1);
//#endif 


//#if 1513249336 
critiquerThread.start();
//#endif 


//#if -320929175 
critiquingRoot = root;
//#endif 

} 

//#endif 


//#if -2052238785 
public static void setCritiquingRoot(Object d)
    { 

//#if 1190777326 
synchronized (theDesigner()) //1
{ 

//#if 430306429 
critiquingRoot = d;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1399090893 
public GoalModel getGoalModel()
    { 

//#if 737778236 
return goals;
//#endif 

} 

//#endif 


//#if -818153068 
public boolean getAutoCritique()
    { 

//#if 388043281 
return Configuration.getBoolean(Designer.AUTO_CRITIQUE, true);
//#endif 

} 

//#endif 


//#if -571821824 
public int getCritiquingInterval()
    { 

//#if -962914502 
return critiquingInterval;
//#endif 

} 

//#endif 


//#if 1999877748 
public static void setSaveAction(Action theSaveAction)
    { 

//#if -1591097643 
saveAction = theSaveAction;
//#endif 

} 

//#endif 


//#if -1993675570 
public void startDesiring(String goal)
    { 

//#if -776211286 
goals.startDesiring(goal);
//#endif 

} 

//#endif 


//#if -1182672105 
public List<Goal> getGoalList()
    { 

//#if 1290429761 
return goals.getGoalList();
//#endif 

} 

//#endif 


//#if 1581249112 
public String getDesignerName()
    { 

//#if 12966592 
return designerName;
//#endif 

} 

//#endif 


//#if -648631198 
public static void setUserWorking(boolean working)
    { 

//#if -660272997 
userWorking = working;
//#endif 

} 

//#endif 


//#if -321007694 
public static void disableCritiquing()
    { 

//#if -33480694 
synchronized (theDesigner()) //1
{ 

//#if 96439396 
theDesigner().critiqueLock++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1319638555 
public void setCritiquingInterval(int i)
    { 

//#if 1768362012 
critiquingInterval = i;
//#endif 

} 

//#endif 


//#if 186838197 
public static void firePropertyChange(String property, Object oldValue,
                                          Object newValue)
    { 

//#if -1875006877 
if(pcs != null)//1
{ 

//#if 267393814 
pcs.firePropertyChange(property, oldValue, newValue);
//#endif 

} 

//#endif 


//#if 1862408615 
if(MODEL_TODOITEM_ADDED.equals(property)
                || MODEL_TODOITEM_DISMISSED.equals(property))//1
{ 

//#if -1208843483 
if(saveAction != null)//1
{ 

//#if 1740464658 
saveAction.setEnabled(true);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2010837420 
public void critique(Object des)
    { 

//#if -1294783918 
Agency.applyAllCritics(des, this);
//#endif 

} 

//#endif 


//#if -543041998 
public String expand(String desc, ListSet offs)
    { 

//#if -1198150525 
return desc;
//#endif 

} 

//#endif 


//#if 175548536 
public List<Goal> getSupportedGoals()
    { 

//#if -190458499 
return unspecifiedGoal;
//#endif 

} 

//#endif 


//#if -1416695171 
public void removeToDoItems(ToDoList list)
    { 

//#if -1512268595 
toDoList.removeAll(list);
//#endif 

} 

//#endif 


//#if -132954465 
public void snooze()
    { 
} 

//#endif 


//#if 409773525 
static class EmptyChildGenerator implements 
//#if -2120892359 
ChildGenerator
//#endif 

  { 

//#if -403770995 
private static final long serialVersionUID = 7599621170029351645L;
//#endif 


//#if -2139731987 
public Enumeration gen(Object o)
        { 

//#if -1571460812 
return EnumerationEmpty.theInstance();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

