
//#if 1524238293 
// Compilation Unit of /AbstractMessageNotationUml.java 
 

//#if 1940357367 
package org.argouml.notation.providers.uml;
//#endif 


//#if 2110791338 
import java.text.ParseException;
//#endif 


//#if 420190692 
import java.util.ArrayList;
//#endif 


//#if 1480607741 
import java.util.Collection;
//#endif 


//#if 2074955821 
import java.util.Iterator;
//#endif 


//#if -1059455491 
import java.util.List;
//#endif 


//#if -587653696 
import java.util.NoSuchElementException;
//#endif 


//#if 2098069388 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 733932873 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1949309621 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 79917326 
import org.argouml.i18n.Translator;
//#endif 


//#if 15406707 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -212667692 
import org.argouml.model.Model;
//#endif 


//#if 1732896461 
import org.argouml.notation.providers.MessageNotation;
//#endif 


//#if -1321077930 
import org.argouml.util.CustomSeparator;
//#endif 


//#if 1095027039 
import org.argouml.util.MyTokenizer;
//#endif 


//#if -2060204191 
import org.apache.log4j.Logger;
//#endif 


//#if 559018751 
public abstract class AbstractMessageNotationUml extends 
//#if -1710960076 
MessageNotation
//#endif 

  { 

//#if -642814185 
private final List<CustomSeparator> parameterCustomSep;
//#endif 


//#if -1166713626 
private static final Logger LOG =
        Logger.getLogger(AbstractMessageNotationUml.class);
//#endif 


//#if 1099311910 
protected String generateMessageNumber(Object umlMessage,
                                           Object umlPredecessor,
                                           int position)
    { 

//#if -1113725768 
Iterator it;
//#endif 


//#if -2139459788 
String activatorIntNo = "";
//#endif 


//#if 1774032977 
Object umlActivator;
//#endif 


//#if 1110480643 
int subpos = 0, submax = 1;
//#endif 


//#if 1188370883 
if(umlMessage == null)//1
{ 

//#if 1433922139 
return null;
//#endif 

} 

//#endif 


//#if 1355151322 
umlActivator = Model.getFacade().getActivator(umlMessage);
//#endif 


//#if -741675859 
if(umlActivator != null)//1
{ 

//#if 392546095 
activatorIntNo = generateMessageNumber(umlActivator);
//#endif 

} 

//#endif 


//#if 1984710753 
if(umlPredecessor != null)//1
{ 

//#if 133651670 
Collection c = Model.getFacade().getSuccessors(umlPredecessor);
//#endif 


//#if 1390292997 
submax = c.size();
//#endif 


//#if -2022085569 
it = c.iterator();
//#endif 


//#if 758321372 
while (it.hasNext() && it.next() != umlMessage) //1
{ 

//#if -1519587950 
subpos++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1762620363 
StringBuilder result = new StringBuilder(activatorIntNo);
//#endif 


//#if 1046347539 
if(activatorIntNo.length() > 0)//1
{ 

//#if 652967441 
result.append(".");
//#endif 

} 

//#endif 


//#if 37967746 
result.append(position);
//#endif 


//#if 1963426464 
if(submax > 1)//1
{ 

//#if -65723448 
result.append((char) ('a' + subpos));
//#endif 

} 

//#endif 


//#if 1648035447 
return result.toString();
//#endif 

} 

//#endif 


//#if 1237740410 
public AbstractMessageNotationUml(Object umlMessage)
    { 

//#if -404109660 
super(umlMessage);
//#endif 


//#if -2137441254 
parameterCustomSep = initParameterSeparators();
//#endif 

} 

//#endif 


//#if 787064583 
protected void handlePredecessors(Object umlMessage,
                                      List<List> predecessors, boolean hasPredecessors)
    throws ParseException
    { 

//#if -1966776552 
if(hasPredecessors)//1
{ 

//#if -1399006358 
Collection roots =
                findCandidateRoots(
                    Model.getFacade().getMessages(
                        Model.getFacade().getInteraction(umlMessage)),
                    null,
                    null);
//#endif 


//#if -1237555413 
List<Object> pre = new ArrayList<Object>();
//#endif 


//#if -801510299 
predfor://1

//#if -1181260220 
for (int i = 0; i < predecessors.size(); i++) //1
{ 

//#if 1458151379 
for (Object root : roots) //1
{ 

//#if -1632515145 
Object msg =
                        walkTree(root, predecessors.get(i));
//#endif 


//#if 168345042 
if(msg != null && msg != umlMessage)//1
{ 

//#if 1234133383 
if(isBadPreMsg(umlMessage, msg))//1
{ 

//#if 169287718 
String parseMsg = "parsing.error.message.one-pred";
//#endif 


//#if 38468074 
throw new ParseException(
                                Translator.localize(parseMsg), 0);
//#endif 

} 

//#endif 


//#if 1739155177 
pre.add(msg);
//#endif 


//#if 2138536850 
continue predfor;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 81779736 
String parseMsg = "parsing.error.message.pred-not-found";
//#endif 


//#if 1111164136 
throw new ParseException(Translator.localize(parseMsg), 0);
//#endif 

} 

//#endif 


//#endif 


//#if -454989853 
MsgPtr ptr = new MsgPtr();
//#endif 


//#if -1239674612 
recCountPredecessors(umlMessage, ptr);
//#endif 


//#if 1620919968 
if(ptr.message != null && !pre.contains(ptr.message))//1
{ 

//#if 292652675 
pre.add(ptr.message);
//#endif 

} 

//#endif 


//#if -1863573486 
Model.getCollaborationsHelper().setPredecessors(umlMessage, pre);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2118022454 
private List getOperation(Collection classifiers, String name, int params)
    throws ParseException
    { 

//#if -1602736739 
List<Object> operations = new ArrayList<Object>();
//#endif 


//#if -1228774946 
if(name == null || name.length() == 0)//1
{ 

//#if -1444418614 
return operations;
//#endif 

} 

//#endif 


//#if 377726162 
for (Object clf : classifiers) //1
{ 

//#if -416439207 
Collection oe = Model.getFacade().getFeatures(clf);
//#endif 


//#if -1546130055 
for (Object operation : oe) //1
{ 

//#if -1531751543 
if(!(Model.getFacade().isAOperation(operation)))//1
{ 

//#if -84278904 
continue;
//#endif 

} 

//#endif 


//#if -2017973208 
if(!name.equals(Model.getFacade().getName(operation)))//1
{ 

//#if -1546859895 
continue;
//#endif 

} 

//#endif 


//#if -126012796 
if(params != countParameters(operation))//1
{ 

//#if -2082506665 
continue;
//#endif 

} 

//#endif 


//#if 334658066 
operations.add(operation);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 403219584 
if(operations.size() > 0)//1
{ 

//#if -969893009 
return operations;
//#endif 

} 

//#endif 


//#if -1120506535 
Iterator it = classifiers.iterator();
//#endif 


//#if -1143393935 
if(it.hasNext())//1
{ 

//#if -1378666909 
StringBuilder expr = new StringBuilder(name + "(");
//#endif 


//#if 1255275798 
int i;
//#endif 


//#if -1515773928 
for (i = 0; i < params; i++) //1
{ 

//#if 738255877 
if(i > 0)//1
{ 

//#if 587531959 
expr.append(", ");
//#endif 

} 

//#endif 


//#if -618765282 
expr.append("param" + (i + 1));
//#endif 

} 

//#endif 


//#if -1876489363 
expr.append(")");
//#endif 


//#if 1616133857 
Object cls = it.next();
//#endif 


//#if -816163735 
Object returnType =
                ProjectManager.getManager()
                .getCurrentProject().getDefaultReturnType();
//#endif 


//#if 2084675372 
Object op = Model.getCoreFactory().buildOperation(cls, returnType);
//#endif 


//#if -1997564481 
new OperationNotationUml(op).parseOperation(
                expr.toString(), op);
//#endif 


//#if -1863394831 
operations.add(op);
//#endif 

} 

//#endif 


//#if 384089778 
return operations;
//#endif 

} 

//#endif 


//#if -1767528223 
protected StringBuilder fillBlankVariableName(Object umlMessage,
            StringBuilder varname, boolean mayDeleteExpr)
    { 

//#if 728069411 
if(varname == null)//1
{ 

//#if -117762894 
Object script = Model.getFacade().getScript(
                                Model.getFacade().getAction(umlMessage));
//#endif 


//#if 1049930465 
if(!mayDeleteExpr && script != null)//1
{ 

//#if 2024187985 
String body =
                    (String) Model.getFacade().getBody(script);
//#endif 


//#if -1924011357 
int idx = body.indexOf(":=");
//#endif 


//#if -579852570 
if(idx < 0)//1
{ 

//#if -72317060 
idx = body.indexOf("=");
//#endif 

} 

//#endif 


//#if 1357911727 
if(idx >= 0)//1
{ 

//#if 115224820 
varname = new StringBuilder(body.substring(0, idx));
//#endif 

} 
else
{ 

//#if -852910591 
varname = new StringBuilder();
//#endif 

} 

//#endif 

} 
else
{ 

//#if 166990417 
varname = new StringBuilder();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1039532230 
return varname;
//#endif 

} 

//#endif 


//#if 105809741 
private String generateMessageNumber(Object message)
    { 

//#if -772253704 
MsgPtr ptr = new MsgPtr();
//#endif 


//#if -2104383777 
int pos = recCountPredecessors(message, ptr) + 1;
//#endif 


//#if 1841168176 
return generateMessageNumber(message, ptr.message, pos);
//#endif 

} 

//#endif 


//#if -1189594022 
private Collection findCandidateRoots(Collection c, Object a, Object veto)
    { 

//#if 155569311 
List<Object> candidates = new ArrayList<Object>();
//#endif 


//#if -1419616433 
for (Object message : c) //1
{ 

//#if 654891306 
if(message == veto)//1
{ 

//#if -1753920933 
continue;
//#endif 

} 

//#endif 


//#if 954827635 
if(Model.getFacade().getActivator(message) != a)//1
{ 

//#if 2115826164 
continue;
//#endif 

} 

//#endif 


//#if 617630102 
Collection predecessors =
                Model.getFacade().getPredecessors(message);
//#endif 


//#if -1275509379 
boolean isCandidate = true;
//#endif 


//#if 1475331997 
for (Object predecessor : predecessors) //1
{ 

//#if -946567738 
if(Model.getFacade().getActivator(predecessor) == a)//1
{ 

//#if 112649854 
isCandidate = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1405974802 
if(isCandidate)//1
{ 

//#if 1533827231 
candidates.add(message);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 746199920 
return candidates;
//#endif 

} 

//#endif 


//#if -802077553 
protected String toString(final Object umlMessage,
                              boolean showSequenceNumbers)
    { 

//#if -936475295 
Iterator it;
//#endif 


//#if 1085261596 
Collection umlPredecessors;
//#endif 


//#if -542151407 
Object umlAction;
//#endif 


//#if -1965326342 
Object umlActivator;
//#endif 


//#if 1029271611 
MsgPtr ptr;
//#endif 


//#if -486992321 
int lpn;
//#endif 


//#if -1207687322 
StringBuilder predecessors = new StringBuilder();
//#endif 


//#if -767782592 
String number;
//#endif 


//#if -66209818 
String action = "";
//#endif 


//#if 1375012076 
if(umlMessage == null)//1
{ 

//#if 1513910009 
return "";
//#endif 

} 

//#endif 


//#if -1685298563 
ptr = new MsgPtr();
//#endif 


//#if -1290067348 
lpn = recCountPredecessors(umlMessage, ptr) + 1;
//#endif 


//#if 1487263185 
umlActivator = Model.getFacade().getActivator(umlMessage);
//#endif 


//#if 351568719 
umlPredecessors = Model.getFacade().getPredecessors(umlMessage);
//#endif 


//#if -1459078151 
it = (umlPredecessors != null) ? umlPredecessors.iterator() : null;
//#endif 


//#if -725796661 
if(it != null && it.hasNext())//1
{ 

//#if -818134708 
MsgPtr ptr2 = new MsgPtr();
//#endif 


//#if 1056803264 
int precnt = 0;
//#endif 


//#if -1041092169 
while (it.hasNext()) //1
{ 

//#if -1363841772 
Object msg = /*(MMessage)*/ it.next();
//#endif 


//#if 451772103 
int mpn = recCountPredecessors(msg, ptr2) + 1;
//#endif 


//#if -260292767 
if(mpn == lpn - 1
                        && umlActivator == Model.getFacade().getActivator(msg)
                        && Model.getFacade().getPredecessors(msg).size() < 2
                        && (ptr2.message == null
                            || countSuccessors(ptr2.message) < 2))//1
{ 

//#if -1126327455 
continue;
//#endif 

} 

//#endif 


//#if 513044712 
if(predecessors.length() > 0)//1
{ 

//#if -36379550 
predecessors.append(", ");
//#endif 

} 

//#endif 


//#if 1218661071 
predecessors.append(
                    generateMessageNumber(msg, ptr2.message, mpn));
//#endif 


//#if 1494894407 
precnt++;
//#endif 

} 

//#endif 


//#if 1717191486 
if(precnt > 0)//1
{ 

//#if 812257172 
predecessors.append(" / ");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 914498238 
number = generateMessageNumber(umlMessage, ptr.message, lpn);
//#endif 


//#if -1023226953 
umlAction = Model.getFacade().getAction(umlMessage);
//#endif 


//#if -1059233461 
if(umlAction != null)//1
{ 

//#if -548855497 
if(Model.getFacade().getRecurrence(umlAction) != null)//1
{ 

//#if 705848203 
number = generateRecurrence(
                             Model.getFacade().getRecurrence(umlAction))
                         + " "
                         + number;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1840016706 
action = NotationUtilityUml.generateActionSequence(umlAction);
//#endif 


//#if 1462715141 
if("".equals(action) || action.trim().startsWith("("))//1
{ 

//#if -1484603836 
action = getInitiatorOfAction(umlAction);
//#endif 


//#if -1054027118 
if("".equals(action))//1
{ 

//#if 20059472 
String n = Model.getFacade().getName(umlMessage);
//#endif 


//#if 1814434736 
if(n != null)//1
{ 

//#if -1528779032 
action = n;
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -163900336 
if(!action.endsWith(")"))//1
{ 

//#if 805284850 
action = action + "()";
//#endif 

} 

//#endif 


//#endif 


//#if 30087357 
if(!showSequenceNumbers)//1
{ 

//#if 1155281328 
return action;
//#endif 

} 

//#endif 


//#if -105339726 
return predecessors + number + " : " + action;
//#endif 

} 

//#endif 


//#if -4483292 
protected void handleGuard(Object umlMessage, StringBuilder guard,
                               boolean parallell, boolean iterative)
    { 

//#if -480767455 
if(guard != null)//1
{ 

//#if 902223597 
guard = new StringBuilder("[" + guard.toString().trim() + "]");
//#endif 


//#if 1373573590 
if(iterative)//1
{ 

//#if 479190450 
if(parallell)//1
{ 

//#if -1975006385 
guard = guard.insert(0, "*//");
//#endif 

} 
else
{ 

//#if 1094740757 
guard = guard.insert(0, "*");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1666154426 
Object expr =
                Model.getDataTypesFactory().createIterationExpression(
                    getExpressionLanguage(), guard.toString());
//#endif 


//#if -1776529330 
Model.getCommonBehaviorHelper().setRecurrence(
                Model.getFacade().getAction(umlMessage), expr);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1971202279 
protected int recCountPredecessors(Object umlMessage, MsgPtr ptr)
    { 

//#if 643751960 
int pre = 0;
//#endif 


//#if -895695472 
int local = 0;
//#endif 


//#if -1517860567 
Object/*MMessage*/ maxmsg = null;
//#endif 


//#if -213193215 
Object activator;
//#endif 


//#if 780740113 
if(umlMessage == null)//1
{ 

//#if 1476154044 
ptr.message = null;
//#endif 


//#if -1019741187 
return 0;
//#endif 

} 

//#endif 


//#if 222838792 
activator = Model.getFacade().getActivator(umlMessage);
//#endif 


//#if 69935209 
for (Object predecessor
                : Model.getFacade().getPredecessors(umlMessage)) //1
{ 

//#if 1557984278 
if(Model.getFacade().getActivator(predecessor)
                    != activator)//1
{ 

//#if 1299534401 
continue;
//#endif 

} 

//#endif 


//#if 1720449064 
int p = recCountPredecessors(predecessor, null) + 1;
//#endif 


//#if 1543791585 
if(p > pre)//1
{ 

//#if -216450933 
pre = p;
//#endif 


//#if 1715874060 
maxmsg = predecessor;
//#endif 

} 

//#endif 


//#if 1877484575 
local++;
//#endif 

} 

//#endif 


//#if -2023393782 
if(ptr != null)//1
{ 

//#if -1141919532 
ptr.message = maxmsg;
//#endif 

} 

//#endif 


//#if 551943958 
return Math.max(pre, local);
//#endif 

} 

//#endif 


//#if -1976227979 
private void insertSuccessor(Object m, Object s, int p)
    { 

//#if -1087473070 
List<Object> successors =
            new ArrayList<Object>(Model.getFacade().getSuccessors(m));
//#endif 


//#if 655174448 
if(successors.size() > p)//1
{ 

//#if 858044232 
successors.add(p, s);
//#endif 

} 
else
{ 

//#if 1532523622 
successors.add(s);
//#endif 

} 

//#endif 


//#if 1812651861 
Model.getCollaborationsHelper().setSuccessors(m, successors);
//#endif 

} 

//#endif 


//#if -1661290038 
protected boolean handleFunctionName(Object umlMessage, String fname,
                                         StringBuilder varname, boolean refindOperation)
    { 

//#if -208421533 
if(fname != null)//1
{ 

//#if 1789382062 
String expr = fname.trim();
//#endif 


//#if -1770292834 
if(varname.length() > 0)//1
{ 

//#if 394686547 
expr = varname.toString().trim() + " := " + expr;
//#endif 

} 

//#endif 


//#if 1458820769 
Object action = Model.getFacade().getAction(umlMessage);
//#endif 


//#if -1700291214 
assert action != null;
//#endif 


//#if 2096170266 
Object script = Model.getFacade().getScript(action);
//#endif 


//#if 1626050915 
if(script == null
                    || !expr.equals(Model.getFacade().getBody(script)))//1
{ 

//#if -1324938654 
Object newActionExpression =
                    Model.getDataTypesFactory()
                    .createActionExpression(
                        getExpressionLanguage(),
                        expr.trim());
//#endif 


//#if 537195166 
Model.getCommonBehaviorHelper().setScript(
                    action, newActionExpression);
//#endif 


//#if -2135788221 
refindOperation = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1680091038 
return refindOperation;
//#endif 

} 

//#endif 


//#if -549432967 
protected List<CustomSeparator> initParameterSeparators()
    { 

//#if -1108661432 
List<CustomSeparator> separators = new ArrayList<CustomSeparator>();
//#endif 


//#if 1647160323 
separators.add(MyTokenizer.SINGLE_QUOTED_SEPARATOR);
//#endif 


//#if -232714790 
separators.add(MyTokenizer.DOUBLE_QUOTED_SEPARATOR);
//#endif 


//#if -941601782 
separators.add(MyTokenizer.PAREN_EXPR_STRING_SEPARATOR);
//#endif 


//#if 1241679751 
return separators;
//#endif 

} 

//#endif 


//#if -1915362209 
private void printDebugInfo(String s, String fname, StringBuilder guard,
                                String paramExpr, StringBuilder varname, List<List> predecessors,
                                List<Integer> seqno, boolean parallell, boolean iterative)
    { 

//#if 1452833142 
if(LOG.isDebugEnabled())//1
{ 

//#if 1137926483 
StringBuffer buf = new StringBuffer();
//#endif 


//#if 964739529 
buf.append("ParseMessage: " + s + "\n");
//#endif 


//#if 1295339971 
buf.append("Message: ");
//#endif 


//#if -258443366 
for (int i = 0; seqno != null && i + 1 < seqno.size(); i += 2) //1
{ 

//#if -397685904 
if(i > 0)//1
{ 

//#if -590585309 
buf.append(", ");
//#endif 

} 

//#endif 


//#if -2060333733 
buf.append(seqno.get(i) + " (" + seqno.get(i + 1) + ")");
//#endif 

} 

//#endif 


//#if -1997208444 
buf.append("\n");
//#endif 


//#if -2068475104 
buf.append("predecessors: " + predecessors.size() + "\n");
//#endif 


//#if 50188841 
for (int i = 0; i < predecessors.size(); i++) //1
{ 

//#if 1143890935 
int j;
//#endif 


//#if 1896985619 
List v = predecessors.get(i);
//#endif 


//#if -374324821 
buf.append("    Predecessor: ");
//#endif 


//#if 946211040 
for (j = 0; v != null && j + 1 < v.size(); j += 2) //1
{ 

//#if 2013176 
if(j > 0)//1
{ 

//#if 131002631 
buf.append(", ");
//#endif 

} 

//#endif 


//#if 1025509634 
buf.append(v.get(j) + " (" + v.get(j + 1) + ")");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1701364385 
buf.append("guard: " + guard + " it: " + iterative + " pl: "
                       + parallell + "\n");
//#endif 


//#if -1416783725 
buf.append(varname + " := " + fname + " ( " + paramExpr + " )"
                       + "\n");
//#endif 


//#if 223318551 
LOG.debug(buf);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 90720171 
public String getParsingHelp()
    { 

//#if 412037338 
return "parsing.help.fig-message";
//#endif 

} 

//#endif 


//#if 1826306275 
protected void parseMessage(Object umlMessage, String s)
    throws ParseException
    { 

//#if 1067337673 
String fname = null;
//#endif 


//#if -689606720 
StringBuilder guard = null;
//#endif 


//#if -1244625222 
String paramExpr = null;
//#endif 


//#if 866612641 
String token;
//#endif 


//#if -1492926323 
StringBuilder varname = null;
//#endif 


//#if 313242460 
List<List> predecessors = new ArrayList<List>();
//#endif 


//#if -1135740729 
List<Integer> seqno = null;
//#endif 


//#if -1195354692 
List<Integer> currentseq = new ArrayList<Integer>();
//#endif 


//#if -1330135592 
boolean mustBePre = false;
//#endif 


//#if -458717028 
boolean mustBeSeq = false;
//#endif 


//#if 2007740842 
boolean parallell = false;
//#endif 


//#if 1838485570 
boolean iterative = false;
//#endif 


//#if -639126934 
boolean mayDeleteExpr = false;
//#endif 


//#if -1507989420 
boolean refindOperation = false;
//#endif 


//#if 2058486347 
boolean hasPredecessors = false;
//#endif 


//#if -169330438 
currentseq.add(null);
//#endif 


//#if 2063541016 
currentseq.add(null);
//#endif 


//#if -1297492476 
try //1
{ 

//#if -625048445 
MyTokenizer st = new MyTokenizer(s, " ,\t,*,[,],.,:,=,/,\\,",
                                             MyTokenizer.PAREN_EXPR_STRING_SEPARATOR);
//#endif 


//#if -1816263369 
while (st.hasMoreTokens()) //1
{ 

//#if -790849986 
token = st.nextToken();
//#endif 


//#if -1978070126 
if(" ".equals(token) || "\t".equals(token))//1
{ 

//#if -1972598236 
if(currentseq == null)//1
{ 

//#if -431232111 
if(varname != null && fname == null)//1
{ 

//#if -1151935575 
varname.append(token);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -52994317 
if("[".equals(token))//1
{ 

//#if -209934275 
if(mustBePre)//1
{ 

//#if -141402308 
String msg = "parsing.error.message.pred-unqualified";
//#endif 


//#if -1907259024 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -484965542 
mustBeSeq = true;
//#endif 


//#if 495670286 
if(guard != null)//1
{ 

//#if -56117490 
String msg = "parsing.error.message.several-specs";
//#endif 


//#if -295394678 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 167025487 
guard = new StringBuilder();
//#endif 


//#if 413130390 
while (true) //1
{ 

//#if 968505421 
token = st.nextToken();
//#endif 


//#if 1601534975 
if("]".equals(token))//1
{ 

//#if 2037227833 
break;

//#endif 

} 

//#endif 


//#if -1234966442 
guard.append(token);
//#endif 

} 

//#endif 

} 
else

//#if 2091655441 
if("*".equals(token))//1
{ 

//#if -1466547105 
if(mustBePre)//1
{ 

//#if -1712261618 
String msg = "parsing.error.message.pred-unqualified";
//#endif 


//#if -304271138 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -802596104 
mustBeSeq = true;
//#endif 


//#if -1970934511 
if(currentseq != null)//1
{ 

//#if -1955417268 
iterative = true;
//#endif 

} 

//#endif 

} 
else

//#if 909935 
if(".".equals(token))//1
{ 

//#if -842034130 
if(currentseq == null)//1
{ 

//#if 287889607 
String msg = "parsing.error.message.unexpected-dot";
//#endif 


//#if 1535986843 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -2043544574 
if(currentseq.get(currentseq.size() - 2) != null
                            || currentseq.get(currentseq.size() - 1) != null)//1
{ 

//#if -1147056147 
currentseq.add(null);
//#endif 


//#if -1189821627 
currentseq.add(null);
//#endif 

} 

//#endif 

} 
else

//#if 602386955 
if(":".equals(token))//1
{ 

//#if 1399184757 
if(st.hasMoreTokens())//1
{ 

//#if 1597568610 
String t = st.nextToken();
//#endif 


//#if -201194439 
if("=".equals(t))//1
{ 

//#if -632688529 
st.putToken(":=");
//#endif 


//#if 1597302821 
continue;
//#endif 

} 

//#endif 


//#if 1683847856 
st.putToken(t);
//#endif 

} 

//#endif 


//#if -1919097553 
if(mustBePre)//1
{ 

//#if -2006834887 
String msg = "parsing.error.message.pred-colon";
//#endif 


//#if 387731599 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 901759553 
if(currentseq != null)//1
{ 

//#if 1830389191 
if(currentseq.size() > 2
                                && currentseq.get(currentseq.size() - 2) == null
                                && currentseq.get(currentseq.size() - 1) == null)//1
{ 

//#if 1148549354 
currentseq.remove(currentseq.size() - 1);
//#endif 


//#if -1570595544 
currentseq.remove(currentseq.size() - 1);
//#endif 

} 

//#endif 


//#if 143832557 
seqno = currentseq;
//#endif 


//#if -1537221784 
currentseq = null;
//#endif 


//#if 595926538 
mayDeleteExpr = true;
//#endif 

} 

//#endif 

} 
else

//#if -777328355 
if("/".equals(token))//1
{ 

//#if 808320053 
if(st.hasMoreTokens())//1
{ 

//#if -1628451206 
String t = st.nextToken();
//#endif 


//#if -1769619217 
if("/".equals(t))//1
{ 

//#if -1259571684 
st.putToken("//");
//#endif 


//#if -533240965 
continue;
//#endif 

} 

//#endif 


//#if 1226435272 
st.putToken(t);
//#endif 

} 

//#endif 


//#if 1717565995 
if(mustBeSeq)//1
{ 

//#if 155568613 
String msg = "parsing.error.message.sequence-slash";
//#endif 


//#if -137818399 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 483843481 
mustBePre = false;
//#endif 


//#if 1581182696 
mustBeSeq = true;
//#endif 


//#if -392656393 
if(currentseq.size() > 2
                            && currentseq.get(currentseq.size() - 2) == null
                            && currentseq.get(currentseq.size() - 1) == null)//1
{ 

//#if -1771926757 
currentseq.remove(currentseq.size() - 1);
//#endif 


//#if 1973064023 
currentseq.remove(currentseq.size() - 1);
//#endif 

} 

//#endif 


//#if 1266887865 
if(currentseq.get(currentseq.size() - 2) != null
                            || currentseq.get(currentseq.size() - 1) != null)//1
{ 

//#if 678470138 
predecessors.add(currentseq);
//#endif 


//#if 765126019 
currentseq = new ArrayList<Integer>();
//#endif 


//#if 426623743 
currentseq.add(null);
//#endif 


//#if 739745523 
currentseq.add(null);
//#endif 

} 

//#endif 


//#if -1533136871 
hasPredecessors = true;
//#endif 

} 
else

//#if 95416570 
if("//".equals(token))//1
{ 

//#if 67544998 
if(mustBePre)//1
{ 

//#if -129325694 
String msg = "parsing.error.message.pred-parallelized";
//#endif 


//#if 2057467330 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -1861487919 
mustBeSeq = true;
//#endif 


//#if 1424202730 
if(currentseq != null)//1
{ 

//#if -1952390832 
parallell = true;
//#endif 

} 

//#endif 

} 
else

//#if 11183025 
if(",".equals(token))//1
{ 

//#if 1253389538 
if(currentseq != null)//1
{ 

//#if 1312389850 
if(mustBeSeq)//1
{ 

//#if -272709030 
String msg = "parsing.error.message.many-numbers";
//#endif 


//#if -886336233 
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 985812893 
mustBePre = true;
//#endif 


//#if 481203878 
if(currentseq.size() > 2
                                && currentseq.get(currentseq.size() - 2) == null
                                && currentseq.get(currentseq.size() - 1) == null)//1
{ 

//#if -979238141 
currentseq.remove(currentseq.size() - 1);
//#endif 


//#if -1065537425 
currentseq.remove(currentseq.size() - 1);
//#endif 

} 

//#endif 


//#if 1049735338 
if(currentseq.get(currentseq.size() - 2) != null
                                || currentseq.get(currentseq.size() - 1) != null)//1
{ 

//#if 773058073 
predecessors.add(currentseq);
//#endif 


//#if -294232478 
currentseq = new ArrayList<Integer>();
//#endif 


//#if 1137876510 
currentseq.add(null);
//#endif 


//#if -1697711244 
currentseq.add(null);
//#endif 

} 

//#endif 


//#if 1398064330 
hasPredecessors = true;
//#endif 

} 
else
{ 

//#if 171299576 
if(varname == null && fname != null)//1
{ 

//#if 592361999 
varname = new StringBuilder(fname + token);
//#endif 


//#if -238003849 
fname = null;
//#endif 

} 
else

//#if 1858579465 
if(varname != null && fname == null)//1
{ 

//#if 2074690205 
varname.append(token);
//#endif 

} 
else
{ 

//#if -895434084 
String msg = "parsing.error.message.found-comma";
//#endif 


//#if 1014358869 
throw new ParseException(
                                Translator.localize(msg),
                                st.getTokenIndex());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 
else

//#if -562190018 
if("=".equals(token) || ":=".equals(token))//1
{ 

//#if -1936885693 
if(currentseq == null)//1
{ 

//#if -524875371 
if(varname == null)//1
{ 

//#if -346452939 
varname = new StringBuilder(fname);
//#endif 


//#if 600819978 
fname = "";
//#endif 

} 
else
{ 

//#if 1350814585 
fname = "";
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -519839731 
if(currentseq == null)//1
{ 

//#if -20918032 
if(paramExpr == null && token.charAt(0) == '(')//1
{ 

//#if 21301860 
if(token.charAt(token.length() - 1) != ')')//1
{ 

//#if -552328283 
String msg =
                                "parsing.error.message.malformed-parameters";
//#endif 


//#if -2092246260 
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -1016505691 
if(fname == null || "".equals(fname))//1
{ 

//#if -1227405746 
String msg =
                                "parsing.error.message.function-not-found";
//#endif 


//#if -416138886 
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -1409977101 
if(varname == null)//1
{ 

//#if 1845682704 
varname = new StringBuilder();
//#endif 

} 

//#endif 


//#if -429937935 
paramExpr = token.substring(1, token.length() - 1);
//#endif 

} 
else

//#if -962596708 
if(varname != null && fname == null)//1
{ 

//#if -1788953810 
varname.append(token);
//#endif 

} 
else

//#if 1249017714 
if(fname == null || fname.length() == 0)//1
{ 

//#if -151451476 
fname = token;
//#endif 

} 
else
{ 

//#if -1392082327 
String msg = "parsing.error.message.unexpected-token";
//#endif 


//#if -49016591 
Object[] parseExcArgs = {token};
//#endif 


//#if -117977683 
throw new ParseException(
                            Translator.localize(msg, parseExcArgs),
                            st.getTokenIndex());
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 
else
{ 

//#if 1185990378 
boolean hasVal =
                        currentseq.get(currentseq.size() - 2) != null;
//#endif 


//#if -848226263 
boolean hasOrd =
                        currentseq.get(currentseq.size() - 1) != null;
//#endif 


//#if -689684425 
boolean assigned = false;
//#endif 


//#if -2084317980 
int bp = findMsgOrderBreak(token);
//#endif 


//#if 1037622668 
if(!hasVal && !assigned && bp == token.length())//1
{ 

//#if 1537872045 
try //1
{ 

//#if 1954554524 
currentseq.set(
                                currentseq.size() - 2, Integer.valueOf(
                                    token));
//#endif 


//#if 1804980255 
assigned = true;
//#endif 

} 

//#if 1348005497 
catch (NumberFormatException nfe) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if -1755061968 
if(!hasOrd && !assigned && bp == 0)//1
{ 

//#if -1605552736 
try //1
{ 

//#if -1181404585 
currentseq.set(
                                currentseq.size() - 1, Integer.valueOf(
                                    parseMsgOrder(token)));
//#endif 


//#if 975521934 
assigned = true;
//#endif 

} 

//#if 423700306 
catch (NumberFormatException nfe) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if 523827286 
if(!hasVal && !hasOrd && !assigned && bp > 0
                            && bp < token.length())//1
{ 

//#if -994089197 
Integer nbr, ord;
//#endif 


//#if -1337760439 
try //1
{ 

//#if -548140671 
nbr = Integer.valueOf(token.substring(0, bp));
//#endif 


//#if 1995238645 
ord = Integer.valueOf(
                                      parseMsgOrder(token.substring(bp)));
//#endif 


//#if 1021326234 
currentseq.set(currentseq.size() - 2, nbr);
//#endif 


//#if 135209276 
currentseq.set(currentseq.size() - 1, ord);
//#endif 


//#if -1425488685 
assigned = true;
//#endif 

} 

//#if 1192703215 
catch (NumberFormatException nfe) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if -1696825052 
if(!assigned)//1
{ 

//#if 557388158 
String msg = "parsing.error.message.unexpected-token";
//#endif 


//#if 1007885766 
Object[] parseExcArgs = {token};
//#endif 


//#if 1218349570 
throw new ParseException(
                            Translator.localize(msg, parseExcArgs),
                            st.getTokenIndex());
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#if -588595417 
catch (NoSuchElementException nsee) //1
{ 

//#if 790723564 
String msg = "parsing.error.message.unexpected-end-message";
//#endif 


//#if -1177623455 
throw new ParseException(Translator.localize(msg), s.length());
//#endif 

} 

//#endif 


//#if 1822580720 
catch (ParseException pre) //1
{ 

//#if 1135257242 
throw pre;
//#endif 

} 

//#endif 


//#endif 


//#if -742622453 
List<String> args = parseArguments(paramExpr, mayDeleteExpr);
//#endif 


//#if 239999631 
printDebugInfo(s, fname, guard, paramExpr, varname, predecessors,
                       seqno, parallell, iterative);
//#endif 


//#if 1690983735 
buildAction(umlMessage);
//#endif 


//#if 730945745 
handleGuard(umlMessage, guard, parallell, iterative);
//#endif 


//#if 2025712529 
fname = fillBlankFunctionName(umlMessage, fname, mayDeleteExpr);
//#endif 


//#if 792517837 
varname = fillBlankVariableName(umlMessage, varname, mayDeleteExpr);
//#endif 


//#if -319854548 
refindOperation = handleFunctionName(umlMessage, fname, varname,
                                             refindOperation);
//#endif 


//#if -949337267 
refindOperation = handleArguments(umlMessage, args, refindOperation);
//#endif 


//#if -868712562 
refindOperation = handleSequenceNumber(umlMessage, seqno,
                                               refindOperation);
//#endif 


//#if -1155241040 
handleOperation(umlMessage, fname, refindOperation);
//#endif 


//#if -1341176827 
handlePredecessors(umlMessage, predecessors, hasPredecessors);
//#endif 

} 

//#endif 


//#if -1237388984 
private String getExpressionLanguage()
    { 

//#if 916314121 
return "";
//#endif 

} 

//#endif 


//#if -2022881116 
protected String fillBlankFunctionName(Object umlMessage, String fname,
                                           boolean mayDeleteExpr)
    { 

//#if 1719884643 
if(fname == null)//1
{ 

//#if -97199397 
Object script = Model.getFacade().getScript(
                                Model.getFacade().getAction(umlMessage));
//#endif 


//#if 306189272 
if(!mayDeleteExpr && script != null)//1
{ 

//#if 652298943 
String body =
                    (String) Model.getFacade().getBody(script);
//#endif 


//#if 1970234613 
int idx = body.indexOf(":=");
//#endif 


//#if -73384163 
if(idx >= 0)//1
{ 

//#if -1290675035 
idx++;
//#endif 

} 
else
{ 

//#if 1876740689 
idx = body.indexOf("=");
//#endif 

} 

//#endif 


//#if -49169804 
if(idx >= 0)//2
{ 

//#if 1646576822 
fname = body.substring(idx + 1);
//#endif 

} 
else
{ 

//#if 709950025 
fname = body;
//#endif 

} 

//#endif 

} 
else
{ 

//#if 25593279 
fname = "";
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1241101736 
return fname;
//#endif 

} 

//#endif 


//#if 983061216 
public void parse(final Object umlMessage, final String text)
    { 

//#if 2111587188 
try //1
{ 

//#if -2128444091 
parseMessage(umlMessage, text);
//#endif 

} 

//#if 636803618 
catch (ParseException pe) //1
{ 

//#if -949166695 
final String msg = "statusmsg.bar.error.parsing.message";
//#endif 


//#if 363494038 
final Object[] args = {pe.getLocalizedMessage(),
                                   Integer.valueOf(pe.getErrorOffset()),
                                  };
//#endif 


//#if 1417286239 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -579823922 
private boolean hasMsgWithActivator(Object r, Object m)
    { 

//#if -697312595 
Iterator it = Model.getFacade().getSentMessages(r).iterator();
//#endif 


//#if -915819098 
while (it.hasNext()) //1
{ 

//#if 1329771084 
if(Model.getFacade().getActivator(it.next()) == m)//1
{ 

//#if 1629945177 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1967434436 
return false;
//#endif 

} 

//#endif 


//#if 1393058664 
private Collection<Object> filterWithActivator(Collection c,
            Object/*MMessage*/a)
    { 

//#if -2073716050 
List<Object> v = new ArrayList<Object>();
//#endif 


//#if 1639827786 
for (Object msg : c) //1
{ 

//#if -2005327891 
if(Model.getFacade().getActivator(msg) == a)//1
{ 

//#if 1800567690 
v.add(msg);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -883520385 
return v;
//#endif 

} 

//#endif 


//#if 1702240752 
private boolean compareMsgNumbers(String n1, String n2)
    { 

//#if -356808056 
return isMsgNumberStartOf(n1, n2) && isMsgNumberStartOf(n2, n1);
//#endif 

} 

//#endif 


//#if -1839003998 
private static int parseMsgOrder(String s)
    { 

//#if 456355948 
int i, t;
//#endif 


//#if 456757460 
int v = 0;
//#endif 


//#if -739448733 
t = s.length();
//#endif 


//#if 656745516 
for (i = 0; i < t; i++) //1
{ 

//#if -517644530 
char c = s.charAt(i);
//#endif 


//#if -1543365231 
if(c < 'a' || c > 'z')//1
{ 

//#if -210701208 
throw new NumberFormatException();
//#endif 

} 

//#endif 


//#if 1814409429 
v *= 26;
//#endif 


//#if -250262407 
v += c - 'a';
//#endif 

} 

//#endif 


//#if 383121538 
return v;
//#endif 

} 

//#endif 


//#if -1943933753 
private Object walk(Object/* MMessage */r, int steps, boolean strict)
    { 

//#if 769485288 
Object/* MMessage */act = Model.getFacade().getActivator(r);
//#endif 


//#if 1703256867 
while (steps > 0) //1
{ 

//#if 1687649633 
Iterator it = Model.getFacade().getSuccessors(r).iterator();
//#endif 


//#if -1638749007 
do{ 

//#if 1537745425 
if(!it.hasNext())//1
{ 

//#if -1449072394 
return (strict ? null : r);
//#endif 

} 

//#endif 


//#if 629096446 
r = /* (MMessage) */it.next();
//#endif 

} 
 while (Model.getFacade().getActivator(r) != act);//1

//#endif 


//#if -651637581 
steps--;
//#endif 

} 

//#endif 


//#if 1369387680 
return r;
//#endif 

} 

//#endif 


//#if -1846330557 
protected int countSuccessors(Object message)
    { 

//#if -649114750 
int count = 0;
//#endif 


//#if 1049913929 
final Object activator = Model.getFacade().getActivator(message);
//#endif 


//#if -1255774800 
final Collection successors = Model.getFacade().getSuccessors(message);
//#endif 


//#if -377151811 
if(successors != null)//1
{ 

//#if -1256582122 
for (Object suc : successors) //1
{ 

//#if 557433911 
if(Model.getFacade().getActivator(suc) != activator)//1
{ 

//#if -1276630446 
continue;
//#endif 

} 

//#endif 


//#if -776601230 
count++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2030371458 
return count;
//#endif 

} 

//#endif 


//#if -354336792 
protected boolean handleSequenceNumber(Object umlMessage,
                                           List<Integer> seqno, boolean refindOperation) throws ParseException
    { 

//#if 649588297 
int i;
//#endif 


//#if -300468232 
if(seqno != null)//1
{ 

//#if 204229551 
Object/* MMessage */root;
//#endif 


//#if -793825099 
StringBuilder pname = new StringBuilder();
//#endif 


//#if 1142835634 
StringBuilder mname = new StringBuilder();
//#endif 


//#if 1662777791 
String gname = generateMessageNumber(umlMessage);
//#endif 


//#if -933196510 
boolean swapRoles = false;
//#endif 


//#if -1605252545 
int majval = 0;
//#endif 


//#if -676747291 
if(seqno.get(seqno.size() - 2) != null)//1
{ 

//#if -416421276 
majval =
                    Math.max((seqno.get(seqno.size() - 2)).intValue()
                             - 1,
                             0);
//#endif 

} 

//#endif 


//#if -1292624325 
int minval = 0;
//#endif 


//#if -805830010 
if(seqno.get(seqno.size() - 1) != null)//1
{ 

//#if 1270931253 
minval =
                    Math.max((seqno.get(seqno.size() - 1)).intValue(),
                             0);
//#endif 

} 

//#endif 


//#if 1270712302 
for (i = 0; i + 1 < seqno.size(); i += 2) //1
{ 

//#if -254811856 
int bv = 1;
//#endif 


//#if -645628022 
if(seqno.get(i) != null)//1
{ 

//#if -1567141306 
bv = Math.max((seqno.get(i)).intValue(), 1);
//#endif 

} 

//#endif 


//#if -239112030 
int sv = 0;
//#endif 


//#if 2032001252 
if(seqno.get(i + 1) != null)//1
{ 

//#if 967291910 
sv = Math.max((seqno.get(i + 1)).intValue(), 0);
//#endif 

} 

//#endif 


//#if -1788818620 
if(i > 0)//1
{ 

//#if -1806405763 
mname.append(".");
//#endif 

} 

//#endif 


//#if 1047579155 
mname.append(Integer.toString(bv) + (char) ('a' + sv));
//#endif 


//#if 684126882 
if(i + 3 < seqno.size())//1
{ 

//#if -1619908980 
if(i > 0)//1
{ 

//#if 1118041510 
pname.append(".");
//#endif 

} 

//#endif 


//#if 1960062904 
pname.append(Integer.toString(bv) + (char) ('a' + sv));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 723912010 
root = null;
//#endif 


//#if 1445638926 
if(pname.length() > 0)//1
{ 

//#if -727248375 
root = findMsg(Model.getFacade().getSender(umlMessage),
                               pname.toString());
//#endif 


//#if -810992829 
if(root == null)//1
{ 

//#if 1891143372 
root = findMsg(Model.getFacade().getReceiver(umlMessage),
                                   pname.toString());
//#endif 


//#if 1064957468 
if(root != null)//1
{ 

//#if 1254158921 
swapRoles = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if 103816990 
if(!hasMsgWithActivator(Model.getFacade().getSender(umlMessage),
                                            null)
                       && hasMsgWithActivator(Model.getFacade().getReceiver(umlMessage),
                                              null))//1
{ 

//#if 491568041 
swapRoles = true;
//#endif 

} 

//#endif 


//#endif 


//#if 1869536915 
if(compareMsgNumbers(mname.toString(), gname.toString()))//1
{ 
} 
else

//#if -1772670082 
if(isMsgNumberStartOf(gname.toString(), mname.toString()))//1
{ 

//#if -1121394670 
String msg = "parsing.error.message.subtree-rooted-self";
//#endif 


//#if 862523403 
throw new ParseException(Translator.localize(msg), 0);
//#endif 

} 
else

//#if -2015925707 
if(Model.getFacade().getPredecessors(umlMessage).size() > 1
                       && Model.getFacade().getSuccessors(umlMessage).size() > 1)//1
{ 

//#if 15277215 
String msg = "parsing.error.message.start-end-many-threads";
//#endif 


//#if -1368908375 
throw new ParseException(Translator.localize(msg), 0);
//#endif 

} 
else

//#if 990739511 
if(root == null && pname.length() > 0)//1
{ 

//#if -974601493 
String msg = "parsing.error.message.activator-not-found";
//#endif 


//#if 462476505 
throw new ParseException(Translator.localize(msg), 0);
//#endif 

} 
else

//#if 127317359 
if(swapRoles
                       && Model.getFacade().getActivatedMessages(umlMessage).size() > 0
                       && (Model.getFacade().getSender(umlMessage)
                           != Model.getFacade().getReceiver(umlMessage)))//1
{ 

//#if 1013181030 
String msg = "parsing.error.message.reverse-direction-message";
//#endif 


//#if -402470404 
throw new ParseException(Translator.localize(msg), 0);
//#endif 

} 
else
{ 

//#if 96645553 
Collection c = new ArrayList(
                    Model.getFacade().getPredecessors(umlMessage));
//#endif 


//#if -1713662060 
Collection c2 = new ArrayList(
                    Model.getFacade().getSuccessors(umlMessage));
//#endif 


//#if 816595798 
Iterator it;
//#endif 


//#if -508885741 
it = c2.iterator();
//#endif 


//#if -1811681322 
while (it.hasNext()) //1
{ 

//#if -1865043376 
Model.getCollaborationsHelper().removeSuccessor(umlMessage,
                            it.next());
//#endif 

} 

//#endif 


//#if -1588316613 
it = c.iterator();
//#endif 


//#if -1239145701 
while (it.hasNext()) //2
{ 

//#if -1051295294 
Iterator it2 = c2.iterator();
//#endif 


//#if -1315962219 
Object pre = /* (MMessage) */it.next();
//#endif 


//#if -1340550224 
Model.getCollaborationsHelper().removePredecessor(umlMessage, pre);
//#endif 


//#if -2081793657 
while (it2.hasNext()) //1
{ 

//#if -652432040 
Model.getCollaborationsHelper().addPredecessor(
                            it2.next(), pre);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1477263492 
Model.getCollaborationsHelper().setActivator(umlMessage, root);
//#endif 


//#if -983862541 
if(swapRoles)//1
{ 

//#if 1030676969 
Object/* MClassifierRole */r =
                        Model.getFacade().getSender(umlMessage);
//#endif 


//#if -1415850256 
Model.getCollaborationsHelper().setSender(umlMessage,
                            Model.getFacade().getReceiver(umlMessage));
//#endif 


//#if -1150455416 
Model.getCommonBehaviorHelper().setReceiver(umlMessage, r);
//#endif 

} 

//#endif 


//#if 1709464624 
if(root == null)//1
{ 

//#if 1791665779 
c =
                        filterWithActivator(
                            Model.getFacade().getSentMessages(
                                Model.getFacade().getSender(umlMessage)),
                            null);
//#endif 

} 
else
{ 

//#if 932938388 
c = Model.getFacade().getActivatedMessages(root);
//#endif 

} 

//#endif 


//#if 1744141991 
c2 = findCandidateRoots(c, root, umlMessage);
//#endif 


//#if 1019491423 
it = c2.iterator();
//#endif 


//#if -1073093651 
if(majval <= 0)//1
{ 

//#if 194765621 
while (it.hasNext()) //1
{ 

//#if 96121728 
Model.getCollaborationsHelper().addSuccessor(umlMessage,
                                /* (MMessage) */it.next());
//#endif 

} 

//#endif 

} 
else

//#if -2055968402 
if(it.hasNext())//1
{ 

//#if 1602821649 
Object/* MMessage */pre =
                        walk(/* (MMessage) */it.next(), majval - 1, false);
//#endif 


//#if 234872033 
Object/* MMessage */post = successor(pre, minval);
//#endif 


//#if -1635432441 
if(post != null)//1
{ 

//#if 2134892778 
Model.getCollaborationsHelper()
                        .removePredecessor(post, pre);
//#endif 


//#if -808214833 
Model.getCollaborationsHelper()
                        .addPredecessor(post, umlMessage);
//#endif 

} 

//#endif 


//#if 977989927 
insertSuccessor(pre, umlMessage, minval);
//#endif 

} 

//#endif 


//#endif 


//#if -2041905249 
refindOperation = true;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 1694373960 
return refindOperation;
//#endif 

} 

//#endif 


//#if -698009034 
private int countParameters(Object bf)
    { 

//#if 1117831108 
int count = 0;
//#endif 


//#if -1278243728 
for (Object parameter : Model.getFacade().getParameters(bf)) //1
{ 

//#if 870202310 
if(!Model.getFacade().isReturn(parameter))//1
{ 

//#if 1624013203 
count++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 971118208 
return count;
//#endif 

} 

//#endif 


//#if -818202540 
protected List<String> parseArguments(String paramExpr,
                                          boolean mayDeleteExpr)
    { 

//#if -1484803578 
String token;
//#endif 


//#if -1286652810 
List<String> args = null;
//#endif 


//#if 1143259733 
if(paramExpr != null)//1
{ 

//#if 1546127255 
MyTokenizer st = new MyTokenizer(paramExpr, "\\,",
                                             parameterCustomSep);
//#endif 


//#if 1664850587 
args = new ArrayList<String>();
//#endif 


//#if 965748517 
while (st.hasMoreTokens()) //1
{ 

//#if 654486380 
token = st.nextToken();
//#endif 


//#if -343394223 
if(",".equals(token))//1
{ 

//#if 1259458355 
if(args.size() == 0)//1
{ 

//#if -1504345715 
args.add(null);
//#endif 

} 

//#endif 


//#if -1603155756 
args.add(null);
//#endif 

} 
else
{ 

//#if -1182130719 
if(args.size() == 0)//1
{ 

//#if -1897147186 
if(token.trim().length() == 0)//1
{ 

//#if 676916524 
continue;
//#endif 

} 

//#endif 


//#if -647512167 
args.add(null);
//#endif 

} 

//#endif 


//#if -588162387 
String arg = args.get(args.size() - 1);
//#endif 


//#if 676163333 
if(arg != null)//1
{ 

//#if -1807639665 
arg = arg + token;
//#endif 

} 
else
{ 

//#if -2004501341 
arg = token;
//#endif 

} 

//#endif 


//#if 631567051 
args.set(args.size() - 1, arg);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if 1074027874 
if(mayDeleteExpr)//1
{ 

//#if 1547486940 
args = new ArrayList<String>();
//#endif 

} 

//#endif 


//#endif 


//#if -1154953157 
return args;
//#endif 

} 

//#endif 


//#if 888840641 
private boolean isPredecessorMsg(Object pre, Object suc, int md)
    { 

//#if 236503800 
Iterator it = Model.getFacade().getPredecessors(suc).iterator();
//#endif 


//#if 1482668326 
while (it.hasNext()) //1
{ 

//#if 704684498 
Object m = /* (MMessage) */it.next();
//#endif 


//#if -1803737455 
if(m == pre)//1
{ 

//#if 1514343389 
return true;
//#endif 

} 

//#endif 


//#if 671641540 
if(md > 0 && isPredecessorMsg(pre, m, md - 1))//1
{ 

//#if -349372071 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 197201476 
return false;
//#endif 

} 

//#endif 


//#if -160567364 
protected String generateRecurrence(Object expr)
    { 

//#if -350945927 
if(expr == null)//1
{ 

//#if 1049020524 
return "";
//#endif 

} 

//#endif 


//#if -50735620 
return Model.getFacade().getBody(expr).toString();
//#endif 

} 

//#endif 


//#if 856009974 
protected String getInitiatorOfAction(Object umlAction)
    { 

//#if 2044891244 
String result = "";
//#endif 


//#if 1368825809 
if(Model.getFacade().isACallAction(umlAction))//1
{ 

//#if -655433332 
Object umlOperation = Model.getFacade().getOperation(umlAction);
//#endif 


//#if 1061740333 
if(Model.getFacade().isAOperation(umlOperation))//1
{ 

//#if 457906773 
StringBuilder sb = new StringBuilder(
                    Model.getFacade().getName(umlOperation));
//#endif 


//#if -938681275 
if(sb.length() > 0)//1
{ 

//#if 1208947792 
sb.append("()");
//#endif 


//#if -259168385 
result = sb.toString();
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -667809763 
if(Model.getFacade().isASendAction(umlAction))//1
{ 

//#if -1637367601 
Object umlSignal = Model.getFacade().getSignal(umlAction);
//#endif 


//#if 787881002 
if(Model.getFacade().isASignal(umlSignal))//1
{ 

//#if -1339651199 
String n = Model.getFacade().getName(umlSignal);
//#endif 


//#if -1290847982 
if(n != null)//1
{ 

//#if -217663537 
result = n;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#if 1643344718 
return result;
//#endif 

} 

//#endif 


//#if -348550074 
protected void buildAction(Object umlMessage)
    { 

//#if -483561206 
if(Model.getFacade().getAction(umlMessage) == null)//1
{ 

//#if 983735599 
Object a = Model.getCommonBehaviorFactory()
                       .createCallAction();
//#endif 


//#if -799039407 
Model.getCoreHelper().addOwnedElement(Model.getFacade().getContext(
                    Model.getFacade().getInteraction(umlMessage)), a);
//#endif 


//#if -1736900955 
Model.getCollaborationsHelper().setAction(umlMessage, a);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -242235705 
protected boolean handleArguments(Object umlMessage, List<String> args,
                                      boolean refindOperation)
    { 

//#if -633664516 
if(args != null)//1
{ 

//#if 120917797 
Collection c = new ArrayList(
                Model.getFacade().getActualArguments(
                    Model.getFacade().getAction(umlMessage)));
//#endif 


//#if -174295900 
Iterator it = c.iterator();
//#endif 


//#if -978602829 
int ii;
//#endif 


//#if 71194378 
for (ii = 0; ii < args.size(); ii++) //1
{ 

//#if 226523134 
Object umlArgument = (it.hasNext() ? it.next() : null);
//#endif 


//#if 1687846144 
if(umlArgument == null)//1
{ 

//#if -592840550 
umlArgument = Model.getCommonBehaviorFactory()
                                  .createArgument();
//#endif 


//#if 1588667268 
Model.getCommonBehaviorHelper().addActualArgument(
                        Model.getFacade().getAction(umlMessage), umlArgument);
//#endif 


//#if 609230189 
refindOperation = true;
//#endif 

} 

//#endif 


//#if 1942102337 
if(Model.getFacade().getValue(umlArgument) == null
                        || !args.get(ii).equals(
                            Model.getFacade().getBody(
                                Model.getFacade().getValue(umlArgument))))//1
{ 

//#if 60069147 
String value = (args.get(ii) != null ? args.get(ii)
                                    : "");
//#endif 


//#if -1478974534 
Object umlExpression =
                        Model.getDataTypesFactory().createExpression(
                            getExpressionLanguage(),
                            value.trim());
//#endif 


//#if -1729616773 
Model.getCommonBehaviorHelper().setValue(umlArgument, umlExpression);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1096522639 
while (it.hasNext()) //1
{ 

//#if -1960348820 
Model.getCommonBehaviorHelper()
                .removeActualArgument(Model.getFacade().getAction(umlMessage),
                                      it.next());
//#endif 


//#if 1141134700 
refindOperation = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1364849177 
return refindOperation;
//#endif 

} 

//#endif 


//#if 758270351 
private Object walkTree(Object root, List path)
    { 

//#if 104767733 
int i;
//#endif 


//#if 847381414 
for (i = 0; i + 1 < path.size(); i += 2) //1
{ 

//#if -1936092931 
int bv = 0;
//#endif 


//#if 937222003 
if(path.get(i) != null)//1
{ 

//#if -669404737 
bv = Math.max(((Integer) path.get(i)).intValue() - 1, 0);
//#endif 

} 

//#endif 


//#if -1920393074 
int sv = 0;
//#endif 


//#if -1562514803 
if(path.get(i + 1) != null)//1
{ 

//#if 670805707 
sv = Math.max(((Integer) path.get(i + 1)).intValue(), 0);
//#endif 

} 

//#endif 


//#if 2091923654 
root = walk(root, bv - 1, true);
//#endif 


//#if 49303204 
if(root == null)//1
{ 

//#if -2132651338 
return null;
//#endif 

} 

//#endif 


//#if 499143905 
if(bv > 0)//1
{ 

//#if 1270406642 
root = successor(root, sv);
//#endif 


//#if -1337656980 
if(root == null)//1
{ 

//#if -438155403 
return null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -358277291 
if(i + 3 < path.size())//1
{ 

//#if 1424887403 
Iterator it =
                    findCandidateRoots(
                        Model.getFacade().getActivatedMessages(root),
                        root,
                        null).iterator();
//#endif 


//#if -1585551429 
if(!it.hasNext())//1
{ 

//#if 1387925193 
return null;
//#endif 

} 

//#endif 


//#if 1323637396 
root = /* (MMessage) */it.next();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 147269949 
return root;
//#endif 

} 

//#endif 


//#if -1458601681 
protected void handleOperation(Object umlMessage, String fname,
                                   boolean refindOperation) throws ParseException
    { 

//#if -630648934 
if(fname != null && refindOperation)//1
{ 

//#if 2120504885 
Object role = Model.getFacade().getReceiver(umlMessage);
//#endif 


//#if 228884967 
List ops =
                getOperation(
                    Model.getFacade().getBases(role),
                    fname.trim(),
                    Model.getFacade().getActualArguments(
                        Model.getFacade().getAction(umlMessage)).size());
//#endif 


//#if -281117680 
Object callAction = Model.getFacade().getAction(umlMessage);
//#endif 


//#if -388103024 
if(Model.getFacade().isACallAction(callAction))//1
{ 

//#if 1439430287 
if(ops.size() > 0)//1
{ 

//#if 2023621871 
Model.getCommonBehaviorHelper().setOperation(callAction,
                            ops.get(0));
//#endif 

} 
else
{ 

//#if -478150123 
Model.getCommonBehaviorHelper().setOperation(
                        callAction, null);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1389209065 
private static int findMsgOrderBreak(String s)
    { 

//#if -550872735 
int i, t;
//#endif 


//#if -1922267752 
t = s.length();
//#endif 


//#if -1419426399 
for (i = 0; i < t; i++) //1
{ 

//#if -342307574 
char c = s.charAt(i);
//#endif 


//#if -771936251 
if(c < '0' || c > '9')//1
{ 

//#if -1348165602 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -776196966 
return i;
//#endif 

} 

//#endif 


//#if 885526673 
private boolean isMsgNumberStartOf(String n1, String n2)
    { 

//#if 579325883 
int i, j, len, jlen;
//#endif 


//#if 2004526535 
len = n1.length();
//#endif 


//#if 807473606 
jlen = n2.length();
//#endif 


//#if -1317892107 
i = 0;
//#endif 


//#if -1317862316 
j = 0;
//#endif 


//#if -1698455001 
for (; i < len;) //1
{ 

//#if -1604470058 
int ibv, isv;
//#endif 


//#if 138370068 
int jbv, jsv;
//#endif 


//#if -1553274142 
ibv = 0;
//#endif 


//#if 1096990995 
for (; i < len; i++) //1
{ 

//#if 1332859269 
char c = n1.charAt(i);
//#endif 


//#if -819397930 
if(c < '0' || c > '9')//1
{ 

//#if 413229868 
break;

//#endif 

} 

//#endif 


//#if -63876162 
ibv *= 10;
//#endif 


//#if -1388248412 
ibv += c - '0';
//#endif 

} 

//#endif 


//#if -1537574285 
isv = 0;
//#endif 


//#if 52653246 
for (; i < len; i++) //2
{ 

//#if -506918749 
char c = n1.charAt(i);
//#endif 


//#if 2004840708 
if(c < 'a' || c > 'z')//1
{ 

//#if -2088077867 
break;

//#endif 

} 

//#endif 


//#if -507554004 
isv *= 26;
//#endif 


//#if 880374466 
isv += c - 'a';
//#endif 

} 

//#endif 


//#if -1524644991 
jbv = 0;
//#endif 


//#if 487186489 
for (; j < jlen; j++) //1
{ 

//#if 900047509 
char c = n2.charAt(j);
//#endif 


//#if -1381293370 
if(c < '0' || c > '9')//1
{ 

//#if 1276466775 
break;

//#endif 

} 

//#endif 


//#if -749080915 
jbv *= 10;
//#endif 


//#if -343487147 
jbv += c - '0';
//#endif 

} 

//#endif 


//#if -1508945134 
jsv = 0;
//#endif 


//#if 1078277080 
for (; j < jlen; j++) //2
{ 

//#if -8776593 
char c = n2.charAt(j);
//#endif 


//#if -1921068112 
if(c < 'a' || c > 'z')//1
{ 

//#if -1493365061 
break;

//#endif 

} 

//#endif 


//#if 132388063 
jsv *= 26;
//#endif 


//#if 34665519 
jsv += c - 'a';
//#endif 

} 

//#endif 


//#if -1623622906 
if(ibv != jbv || isv != jsv)//1
{ 

//#if 1087358961 
return false;
//#endif 

} 

//#endif 


//#if -1102554070 
if(i < len && n1.charAt(i) != '.')//1
{ 

//#if 1562248563 
return false;
//#endif 

} 

//#endif 


//#if 565925641 
i++;
//#endif 


//#if 1873795847 
if(j < jlen && n2.charAt(j) != '.')//1
{ 

//#if 823738410 
return false;
//#endif 

} 

//#endif 


//#if 565955432 
j++;
//#endif 

} 

//#endif 


//#if 6804103 
return true;
//#endif 

} 

//#endif 


//#if -729234993 
private Object successor(Object/* MMessage */r, int steps)
    { 

//#if 424684373 
Iterator it = Model.getFacade().getSuccessors(r).iterator();
//#endif 


//#if -211407852 
while (it.hasNext() && steps > 0) //1
{ 

//#if 570874766 
it.next();
//#endif 


//#if 1544057438 
steps--;
//#endif 

} 

//#endif 


//#if -880092397 
if(it.hasNext())//1
{ 

//#if -482035094 
return /* (MMessage) */it.next();
//#endif 

} 

//#endif 


//#if -1220667815 
return null;
//#endif 

} 

//#endif 


//#if -696153089 
private boolean isBadPreMsg(Object ans, Object chld)
    { 

//#if -1119797782 
while (chld != null) //1
{ 

//#if 1102966017 
if(ans == chld)//1
{ 

//#if -1368482119 
return true;
//#endif 

} 

//#endif 


//#if 186460941 
if(isPredecessorMsg(ans, chld, 100))//1
{ 

//#if 250327660 
return true;
//#endif 

} 

//#endif 


//#if -1522650793 
chld = Model.getFacade().getActivator(chld);
//#endif 

} 

//#endif 


//#if -1967073645 
return false;
//#endif 

} 

//#endif 


//#if -1309293112 
private Object findMsg(Object/* MClassifierRole */r, String n)
    { 

//#if 701383179 
Collection c = Model.getFacade().getReceivedMessages(r);
//#endif 


//#if -1289462345 
Iterator it = c.iterator();
//#endif 


//#if 153712196 
while (it.hasNext()) //1
{ 

//#if -1039987361 
Object msg = /* (MMessage) */it.next();
//#endif 


//#if -1212846863 
String gname = generateMessageNumber(msg);
//#endif 


//#if 310971753 
if(compareMsgNumbers(gname, n))//1
{ 

//#if 478258077 
return msg;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -789337878 
return null;
//#endif 

} 

//#endif 


//#if 743731230 
protected static class MsgPtr  { 

//#if 680446723 
Object message;
//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

