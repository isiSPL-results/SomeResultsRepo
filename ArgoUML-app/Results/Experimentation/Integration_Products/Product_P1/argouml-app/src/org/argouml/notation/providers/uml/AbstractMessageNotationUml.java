package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.notation.providers.MessageNotation;
import org.argouml.util.CustomSeparator;
import org.argouml.util.MyTokenizer;
public abstract class AbstractMessageNotationUml extends MessageNotation
  { 
private final List<CustomSeparator> parameterCustomSep;
protected String generateMessageNumber(Object umlMessage,
                                           Object umlPredecessor,
                                           int position)
    { 
Iterator it;
String activatorIntNo = "";
Object umlActivator;
int subpos = 0, submax = 1;
if(umlMessage == null)//1
{ 
return null;
} 
umlActivator = Model.getFacade().getActivator(umlMessage);
if(umlActivator != null)//1
{ 
activatorIntNo = generateMessageNumber(umlActivator);
} 
if(umlPredecessor != null)//1
{ 
Collection c = Model.getFacade().getSuccessors(umlPredecessor);
submax = c.size();
it = c.iterator();
while (it.hasNext() && it.next() != umlMessage) //1
{ 
subpos++;
} 
} 
StringBuilder result = new StringBuilder(activatorIntNo);
if(activatorIntNo.length() > 0)//1
{ 
result.append(".");
} 
result.append(position);
if(submax > 1)//1
{ 
result.append((char) ('a' + subpos));
} 
return result.toString();
} 
public AbstractMessageNotationUml(Object umlMessage)
    { 
super(umlMessage);
parameterCustomSep = initParameterSeparators();
} 
protected void handlePredecessors(Object umlMessage,
                                      List<List> predecessors, boolean hasPredecessors)
    throws ParseException
    { 
if(hasPredecessors)//1
{ 
Collection roots =
                findCandidateRoots(
                    Model.getFacade().getMessages(
                        Model.getFacade().getInteraction(umlMessage)),
                    null,
                    null);
List<Object> pre = new ArrayList<Object>();
predfor://1
for (int i = 0; i < predecessors.size(); i++) //1
{ 
for (Object root : roots) //1
{ 
Object msg =
                        walkTree(root, predecessors.get(i));
if(msg != null && msg != umlMessage)//1
{ 
if(isBadPreMsg(umlMessage, msg))//1
{ 
String parseMsg = "parsing.error.message.one-pred";
throw new ParseException(
                                Translator.localize(parseMsg), 0);
} 
pre.add(msg);
continue predfor;
} 
} 
String parseMsg = "parsing.error.message.pred-not-found";
throw new ParseException(Translator.localize(parseMsg), 0);
} 
MsgPtr ptr = new MsgPtr();
recCountPredecessors(umlMessage, ptr);
if(ptr.message != null && !pre.contains(ptr.message))//1
{ 
pre.add(ptr.message);
} 
} 
} 
private List getOperation(Collection classifiers, String name, int params)
    throws ParseException
    { 
List<Object> operations = new ArrayList<Object>();
if(name == null || name.length() == 0)//1
{ 
return operations;
} 
for (Object clf : classifiers) //1
{ 
Collection oe = Model.getFacade().getFeatures(clf);
for (Object operation : oe) //1
{ 
if(!(Model.getFacade().isAOperation(operation)))//1
{ 
continue;
} 
if(!name.equals(Model.getFacade().getName(operation)))//1
{ 
continue;
} 
if(params != countParameters(operation))//1
{ 
continue;
} 
operations.add(operation);
} 
} 
if(operations.size() > 0)//1
{ 
return operations;
} 
Iterator it = classifiers.iterator();
if(it.hasNext())//1
{ 
StringBuilder expr = new StringBuilder(name + "(");
int i;
for (i = 0; i < params; i++) //1
{ 
if(i > 0)//1
{ 
expr.append(", ");
} 
expr.append("param" + (i + 1));
} 
expr.append(")");
Object cls = it.next();
Object returnType =
                ProjectManager.getManager()
                .getCurrentProject().getDefaultReturnType();
Object op = Model.getCoreFactory().buildOperation(cls, returnType);
new OperationNotationUml(op).parseOperation(
                expr.toString(), op);
operations.add(op);
} 
return operations;
} 
protected StringBuilder fillBlankVariableName(Object umlMessage,
            StringBuilder varname, boolean mayDeleteExpr)
    { 
if(varname == null)//1
{ 
Object script = Model.getFacade().getScript(
                                Model.getFacade().getAction(umlMessage));
if(!mayDeleteExpr && script != null)//1
{ 
String body =
                    (String) Model.getFacade().getBody(script);
int idx = body.indexOf(":=");
if(idx < 0)//1
{ 
idx = body.indexOf("=");
} 
if(idx >= 0)//1
{ 
varname = new StringBuilder(body.substring(0, idx));
} 
else
{ 
varname = new StringBuilder();
} 
} 
else
{ 
varname = new StringBuilder();
} 
} 
return varname;
} 
private String generateMessageNumber(Object message)
    { 
MsgPtr ptr = new MsgPtr();
int pos = recCountPredecessors(message, ptr) + 1;
return generateMessageNumber(message, ptr.message, pos);
} 
private Collection findCandidateRoots(Collection c, Object a, Object veto)
    { 
List<Object> candidates = new ArrayList<Object>();
for (Object message : c) //1
{ 
if(message == veto)//1
{ 
continue;
} 
if(Model.getFacade().getActivator(message) != a)//1
{ 
continue;
} 
Collection predecessors =
                Model.getFacade().getPredecessors(message);
boolean isCandidate = true;
for (Object predecessor : predecessors) //1
{ 
if(Model.getFacade().getActivator(predecessor) == a)//1
{ 
isCandidate = false;
} 
} 
if(isCandidate)//1
{ 
candidates.add(message);
} 
} 
return candidates;
} 
protected String toString(final Object umlMessage,
                              boolean showSequenceNumbers)
    { 
Iterator it;
Collection umlPredecessors;
Object umlAction;
Object umlActivator;
MsgPtr ptr;
int lpn;
StringBuilder predecessors = new StringBuilder();
String number;
String action = "";
if(umlMessage == null)//1
{ 
return "";
} 
ptr = new MsgPtr();
lpn = recCountPredecessors(umlMessage, ptr) + 1;
umlActivator = Model.getFacade().getActivator(umlMessage);
umlPredecessors = Model.getFacade().getPredecessors(umlMessage);
it = (umlPredecessors != null) ? umlPredecessors.iterator() : null;
if(it != null && it.hasNext())//1
{ 
MsgPtr ptr2 = new MsgPtr();
int precnt = 0;
while (it.hasNext()) //1
{ 
Object msg = /*(MMessage)*/ it.next();
int mpn = recCountPredecessors(msg, ptr2) + 1;
if(mpn == lpn - 1
                        && umlActivator == Model.getFacade().getActivator(msg)
                        && Model.getFacade().getPredecessors(msg).size() < 2
                        && (ptr2.message == null
                            || countSuccessors(ptr2.message) < 2))//1
{ 
continue;
} 
if(predecessors.length() > 0)//1
{ 
predecessors.append(", ");
} 
predecessors.append(
                    generateMessageNumber(msg, ptr2.message, mpn));
precnt++;
} 
if(precnt > 0)//1
{ 
predecessors.append(" / ");
} 
} 
number = generateMessageNumber(umlMessage, ptr.message, lpn);
umlAction = Model.getFacade().getAction(umlMessage);
if(umlAction != null)//1
{ 
if(Model.getFacade().getRecurrence(umlAction) != null)//1
{ 
number = generateRecurrence(
                             Model.getFacade().getRecurrence(umlAction))
                         + " "
                         + number;
} 
} 
action = NotationUtilityUml.generateActionSequence(umlAction);
if("".equals(action) || action.trim().startsWith("("))//1
{ 
action = getInitiatorOfAction(umlAction);
if("".equals(action))//1
{ 
String n = Model.getFacade().getName(umlMessage);
if(n != null)//1
{ 
action = n;
} 
} 
} 
else
if(!action.endsWith(")"))//1
{ 
action = action + "()";
} 
if(!showSequenceNumbers)//1
{ 
return action;
} 
return predecessors + number + " : " + action;
} 
protected void handleGuard(Object umlMessage, StringBuilder guard,
                               boolean parallell, boolean iterative)
    { 
if(guard != null)//1
{ 
guard = new StringBuilder("[" + guard.toString().trim() + "]");
if(iterative)//1
{ 
if(parallell)//1
{ 
guard = guard.insert(0, "*//");
} 
else
{ 
guard = guard.insert(0, "*");
} 
} 
Object expr =
                Model.getDataTypesFactory().createIterationExpression(
                    getExpressionLanguage(), guard.toString());
Model.getCommonBehaviorHelper().setRecurrence(
                Model.getFacade().getAction(umlMessage), expr);
} 
} 
protected int recCountPredecessors(Object umlMessage, MsgPtr ptr)
    { 
int pre = 0;
int local = 0;
Object/*MMessage*/ maxmsg = null;
Object activator;
if(umlMessage == null)//1
{ 
ptr.message = null;
return 0;
} 
activator = Model.getFacade().getActivator(umlMessage);
for (Object predecessor
                : Model.getFacade().getPredecessors(umlMessage)) //1
{ 
if(Model.getFacade().getActivator(predecessor)
                    != activator)//1
{ 
continue;
} 
int p = recCountPredecessors(predecessor, null) + 1;
if(p > pre)//1
{ 
pre = p;
maxmsg = predecessor;
} 
local++;
} 
if(ptr != null)//1
{ 
ptr.message = maxmsg;
} 
return Math.max(pre, local);
} 
private void insertSuccessor(Object m, Object s, int p)
    { 
List<Object> successors =
            new ArrayList<Object>(Model.getFacade().getSuccessors(m));
if(successors.size() > p)//1
{ 
successors.add(p, s);
} 
else
{ 
successors.add(s);
} 
} 
protected boolean handleFunctionName(Object umlMessage, String fname,
                                         StringBuilder varname, boolean refindOperation)
    { 
if(fname != null)//1
{ 
String expr = fname.trim();
if(varname.length() > 0)//1
{ 
expr = varname.toString().trim() + " := " + expr;
} 
Object action = Model.getFacade().getAction(umlMessage);
assert action != null;
Object script = Model.getFacade().getScript(action);
if(script == null
                    || !expr.equals(Model.getFacade().getBody(script)))//1
{ 
Object newActionExpression =
                    Model.getDataTypesFactory()
                    .createActionExpression(
                        getExpressionLanguage(),
                        expr.trim());
Model.getCommonBehaviorHelper().setScript(
                    action, newActionExpression);
refindOperation = true;
} 
} 
return refindOperation;
} 
protected List<CustomSeparator> initParameterSeparators()
    { 
List<CustomSeparator> separators = new ArrayList<CustomSeparator>();
separators.add(MyTokenizer.SINGLE_QUOTED_SEPARATOR);
separators.add(MyTokenizer.DOUBLE_QUOTED_SEPARATOR);
separators.add(MyTokenizer.PAREN_EXPR_STRING_SEPARATOR);
return separators;
} 
public String getParsingHelp()
    { 
return "parsing.help.fig-message";
} 
protected void parseMessage(Object umlMessage, String s)
    throws ParseException
    { 
String fname = null;
StringBuilder guard = null;
String paramExpr = null;
String token;
StringBuilder varname = null;
List<List> predecessors = new ArrayList<List>();
List<Integer> seqno = null;
List<Integer> currentseq = new ArrayList<Integer>();
boolean mustBePre = false;
boolean mustBeSeq = false;
boolean parallell = false;
boolean iterative = false;
boolean mayDeleteExpr = false;
boolean refindOperation = false;
boolean hasPredecessors = false;
currentseq.add(null);
currentseq.add(null);
try//1
{ 
MyTokenizer st = new MyTokenizer(s, " ,\t,*,[,],.,:,=,/,\\,",
                                             MyTokenizer.PAREN_EXPR_STRING_SEPARATOR);
while (st.hasMoreTokens()) //1
{ 
token = st.nextToken();
if(" ".equals(token) || "\t".equals(token))//1
{ 
if(currentseq == null)//1
{ 
if(varname != null && fname == null)//1
{ 
varname.append(token);
} 
} 
} 
else
if("[".equals(token))//1
{ 
if(mustBePre)//1
{ 
String msg = "parsing.error.message.pred-unqualified";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 
mustBeSeq = true;
if(guard != null)//1
{ 
String msg = "parsing.error.message.several-specs";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 
guard = new StringBuilder();
while (true) //1
{ 
token = st.nextToken();
if("]".equals(token))//1
{ 
break;

} 
guard.append(token);
} 
} 
else
if("*".equals(token))//1
{ 
if(mustBePre)//1
{ 
String msg = "parsing.error.message.pred-unqualified";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 
mustBeSeq = true;
if(currentseq != null)//1
{ 
iterative = true;
} 
} 
else
if(".".equals(token))//1
{ 
if(currentseq == null)//1
{ 
String msg = "parsing.error.message.unexpected-dot";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 
if(currentseq.get(currentseq.size() - 2) != null
                            || currentseq.get(currentseq.size() - 1) != null)//1
{ 
currentseq.add(null);
currentseq.add(null);
} 
} 
else
if(":".equals(token))//1
{ 
if(st.hasMoreTokens())//1
{ 
String t = st.nextToken();
if("=".equals(t))//1
{ 
st.putToken(":=");
continue;
} 
st.putToken(t);
} 
if(mustBePre)//1
{ 
String msg = "parsing.error.message.pred-colon";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 
if(currentseq != null)//1
{ 
if(currentseq.size() > 2
                                && currentseq.get(currentseq.size() - 2) == null
                                && currentseq.get(currentseq.size() - 1) == null)//1
{ 
currentseq.remove(currentseq.size() - 1);
currentseq.remove(currentseq.size() - 1);
} 
seqno = currentseq;
currentseq = null;
mayDeleteExpr = true;
} 
} 
else
if("/".equals(token))//1
{ 
if(st.hasMoreTokens())//1
{ 
String t = st.nextToken();
if("/".equals(t))//1
{ 
st.putToken("//");
continue;
} 
st.putToken(t);
} 
if(mustBeSeq)//1
{ 
String msg = "parsing.error.message.sequence-slash";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 
mustBePre = false;
mustBeSeq = true;
if(currentseq.size() > 2
                            && currentseq.get(currentseq.size() - 2) == null
                            && currentseq.get(currentseq.size() - 1) == null)//1
{ 
currentseq.remove(currentseq.size() - 1);
currentseq.remove(currentseq.size() - 1);
} 
if(currentseq.get(currentseq.size() - 2) != null
                            || currentseq.get(currentseq.size() - 1) != null)//1
{ 
predecessors.add(currentseq);
currentseq = new ArrayList<Integer>();
currentseq.add(null);
currentseq.add(null);
} 
hasPredecessors = true;
} 
else
if("//".equals(token))//1
{ 
if(mustBePre)//1
{ 
String msg = "parsing.error.message.pred-parallelized";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 
mustBeSeq = true;
if(currentseq != null)//1
{ 
parallell = true;
} 
} 
else
if(",".equals(token))//1
{ 
if(currentseq != null)//1
{ 
if(mustBeSeq)//1
{ 
String msg = "parsing.error.message.many-numbers";
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
} 
mustBePre = true;
if(currentseq.size() > 2
                                && currentseq.get(currentseq.size() - 2) == null
                                && currentseq.get(currentseq.size() - 1) == null)//1
{ 
currentseq.remove(currentseq.size() - 1);
currentseq.remove(currentseq.size() - 1);
} 
if(currentseq.get(currentseq.size() - 2) != null
                                || currentseq.get(currentseq.size() - 1) != null)//1
{ 
predecessors.add(currentseq);
currentseq = new ArrayList<Integer>();
currentseq.add(null);
currentseq.add(null);
} 
hasPredecessors = true;
} 
else
{ 
if(varname == null && fname != null)//1
{ 
varname = new StringBuilder(fname + token);
fname = null;
} 
else
if(varname != null && fname == null)//1
{ 
varname.append(token);
} 
else
{ 
String msg = "parsing.error.message.found-comma";
throw new ParseException(
                                Translator.localize(msg),
                                st.getTokenIndex());
} 
} 
} 
else
if("=".equals(token) || ":=".equals(token))//1
{ 
if(currentseq == null)//1
{ 
if(varname == null)//1
{ 
varname = new StringBuilder(fname);
fname = "";
} 
else
{ 
fname = "";
} 
} 
} 
else
if(currentseq == null)//1
{ 
if(paramExpr == null && token.charAt(0) == '(')//1
{ 
if(token.charAt(token.length() - 1) != ')')//1
{ 
String msg =
                                "parsing.error.message.malformed-parameters";
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
} 
if(fname == null || "".equals(fname))//1
{ 
String msg =
                                "parsing.error.message.function-not-found";
throw new ParseException(Translator.localize(msg),
                                                     st.getTokenIndex());
} 
if(varname == null)//1
{ 
varname = new StringBuilder();
} 
paramExpr = token.substring(1, token.length() - 1);
} 
else
if(varname != null && fname == null)//1
{ 
varname.append(token);
} 
else
if(fname == null || fname.length() == 0)//1
{ 
fname = token;
} 
else
{ 
String msg = "parsing.error.message.unexpected-token";
Object[] parseExcArgs = {token};
throw new ParseException(
                            Translator.localize(msg, parseExcArgs),
                            st.getTokenIndex());
} 
} 
else
{ 
boolean hasVal =
                        currentseq.get(currentseq.size() - 2) != null;
boolean hasOrd =
                        currentseq.get(currentseq.size() - 1) != null;
boolean assigned = false;
int bp = findMsgOrderBreak(token);
if(!hasVal && !assigned && bp == token.length())//1
{ 
try//1
{ 
currentseq.set(
                                currentseq.size() - 2, Integer.valueOf(
                                    token));
assigned = true;
} 
catch (NumberFormatException nfe) //1
{ 
} 
} 
if(!hasOrd && !assigned && bp == 0)//1
{ 
try//1
{ 
currentseq.set(
                                currentseq.size() - 1, Integer.valueOf(
                                    parseMsgOrder(token)));
assigned = true;
} 
catch (NumberFormatException nfe) //1
{ 
} 
} 
if(!hasVal && !hasOrd && !assigned && bp > 0
                            && bp < token.length())//1
{ 
Integer nbr, ord;
try//1
{ 
nbr = Integer.valueOf(token.substring(0, bp));
ord = Integer.valueOf(
                                      parseMsgOrder(token.substring(bp)));
currentseq.set(currentseq.size() - 2, nbr);
currentseq.set(currentseq.size() - 1, ord);
assigned = true;
} 
catch (NumberFormatException nfe) //1
{ 
} 
} 
if(!assigned)//1
{ 
String msg = "parsing.error.message.unexpected-token";
Object[] parseExcArgs = {token};
throw new ParseException(
                            Translator.localize(msg, parseExcArgs),
                            st.getTokenIndex());
} 
} 
} 
} 
catch (NoSuchElementException nsee) //1
{ 
String msg = "parsing.error.message.unexpected-end-message";
throw new ParseException(Translator.localize(msg), s.length());
} 
catch (ParseException pre) //1
{ 
throw pre;
} 
List<String> args = parseArguments(paramExpr, mayDeleteExpr);
buildAction(umlMessage);
handleGuard(umlMessage, guard, parallell, iterative);
fname = fillBlankFunctionName(umlMessage, fname, mayDeleteExpr);
varname = fillBlankVariableName(umlMessage, varname, mayDeleteExpr);
refindOperation = handleFunctionName(umlMessage, fname, varname,
                                             refindOperation);
refindOperation = handleArguments(umlMessage, args, refindOperation);
refindOperation = handleSequenceNumber(umlMessage, seqno,
                                               refindOperation);
handleOperation(umlMessage, fname, refindOperation);
handlePredecessors(umlMessage, predecessors, hasPredecessors);
} 
private String getExpressionLanguage()
    { 
return "";
} 
protected String fillBlankFunctionName(Object umlMessage, String fname,
                                           boolean mayDeleteExpr)
    { 
if(fname == null)//1
{ 
Object script = Model.getFacade().getScript(
                                Model.getFacade().getAction(umlMessage));
if(!mayDeleteExpr && script != null)//1
{ 
String body =
                    (String) Model.getFacade().getBody(script);
int idx = body.indexOf(":=");
if(idx >= 0)//1
{ 
idx++;
} 
else
{ 
idx = body.indexOf("=");
} 
if(idx >= 0)//2
{ 
fname = body.substring(idx + 1);
} 
else
{ 
fname = body;
} 
} 
else
{ 
fname = "";
} 
} 
return fname;
} 
public void parse(final Object umlMessage, final String text)
    { 
try//1
{ 
parseMessage(umlMessage, text);
} 
catch (ParseException pe) //1
{ 
final String msg = "statusmsg.bar.error.parsing.message";
final Object[] args = {pe.getLocalizedMessage(),
                                   Integer.valueOf(pe.getErrorOffset()),
                                  };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 
} 
private boolean hasMsgWithActivator(Object r, Object m)
    { 
Iterator it = Model.getFacade().getSentMessages(r).iterator();
while (it.hasNext()) //1
{ 
if(Model.getFacade().getActivator(it.next()) == m)//1
{ 
return true;
} 
} 
return false;
} 
private Collection<Object> filterWithActivator(Collection c,
            Object/*MMessage*/a)
    { 
List<Object> v = new ArrayList<Object>();
for (Object msg : c) //1
{ 
if(Model.getFacade().getActivator(msg) == a)//1
{ 
v.add(msg);
} 
} 
return v;
} 
private boolean compareMsgNumbers(String n1, String n2)
    { 
return isMsgNumberStartOf(n1, n2) && isMsgNumberStartOf(n2, n1);
} 
private static int parseMsgOrder(String s)
    { 
int i, t;
int v = 0;
t = s.length();
for (i = 0; i < t; i++) //1
{ 
char c = s.charAt(i);
if(c < 'a' || c > 'z')//1
{ 
throw new NumberFormatException();
} 
v *= 26;
v += c - 'a';
} 
return v;
} 
private Object walk(Object/* MMessage */r, int steps, boolean strict)
    { 
Object/* MMessage */act = Model.getFacade().getActivator(r);
while (steps > 0) //1
{ 
Iterator it = Model.getFacade().getSuccessors(r).iterator();
do{ 
if(!it.hasNext())//1
{ 
return (strict ? null : r);
} 
r = /* (MMessage) */it.next();
} 
 while (Model.getFacade().getActivator(r) != act);//1
steps--;
} 
return r;
} 
protected int countSuccessors(Object message)
    { 
int count = 0;
final Object activator = Model.getFacade().getActivator(message);
final Collection successors = Model.getFacade().getSuccessors(message);
if(successors != null)//1
{ 
for (Object suc : successors) //1
{ 
if(Model.getFacade().getActivator(suc) != activator)//1
{ 
continue;
} 
count++;
} 
} 
return count;
} 
protected boolean handleSequenceNumber(Object umlMessage,
                                           List<Integer> seqno, boolean refindOperation) throws ParseException
    { 
int i;
if(seqno != null)//1
{ 
Object/* MMessage */root;
StringBuilder pname = new StringBuilder();
StringBuilder mname = new StringBuilder();
String gname = generateMessageNumber(umlMessage);
boolean swapRoles = false;
int majval = 0;
if(seqno.get(seqno.size() - 2) != null)//1
{ 
majval =
                    Math.max((seqno.get(seqno.size() - 2)).intValue()
                             - 1,
                             0);
} 
int minval = 0;
if(seqno.get(seqno.size() - 1) != null)//1
{ 
minval =
                    Math.max((seqno.get(seqno.size() - 1)).intValue(),
                             0);
} 
for (i = 0; i + 1 < seqno.size(); i += 2) //1
{ 
int bv = 1;
if(seqno.get(i) != null)//1
{ 
bv = Math.max((seqno.get(i)).intValue(), 1);
} 
int sv = 0;
if(seqno.get(i + 1) != null)//1
{ 
sv = Math.max((seqno.get(i + 1)).intValue(), 0);
} 
if(i > 0)//1
{ 
mname.append(".");
} 
mname.append(Integer.toString(bv) + (char) ('a' + sv));
if(i + 3 < seqno.size())//1
{ 
if(i > 0)//1
{ 
pname.append(".");
} 
pname.append(Integer.toString(bv) + (char) ('a' + sv));
} 
} 
root = null;
if(pname.length() > 0)//1
{ 
root = findMsg(Model.getFacade().getSender(umlMessage),
                               pname.toString());
if(root == null)//1
{ 
root = findMsg(Model.getFacade().getReceiver(umlMessage),
                                   pname.toString());
if(root != null)//1
{ 
swapRoles = true;
} 
} 
} 
else
if(!hasMsgWithActivator(Model.getFacade().getSender(umlMessage),
                                            null)
                       && hasMsgWithActivator(Model.getFacade().getReceiver(umlMessage),
                                              null))//1
{ 
swapRoles = true;
} 
if(compareMsgNumbers(mname.toString(), gname.toString()))//1
{ 
} 
else
if(isMsgNumberStartOf(gname.toString(), mname.toString()))//1
{ 
String msg = "parsing.error.message.subtree-rooted-self";
throw new ParseException(Translator.localize(msg), 0);
} 
else
if(Model.getFacade().getPredecessors(umlMessage).size() > 1
                       && Model.getFacade().getSuccessors(umlMessage).size() > 1)//1
{ 
String msg = "parsing.error.message.start-end-many-threads";
throw new ParseException(Translator.localize(msg), 0);
} 
else
if(root == null && pname.length() > 0)//1
{ 
String msg = "parsing.error.message.activator-not-found";
throw new ParseException(Translator.localize(msg), 0);
} 
else
if(swapRoles
                       && Model.getFacade().getActivatedMessages(umlMessage).size() > 0
                       && (Model.getFacade().getSender(umlMessage)
                           != Model.getFacade().getReceiver(umlMessage)))//1
{ 
String msg = "parsing.error.message.reverse-direction-message";
throw new ParseException(Translator.localize(msg), 0);
} 
} 
return refindOperation;
} 
private int countParameters(Object bf)
    { 
int count = 0;
for (Object parameter : Model.getFacade().getParameters(bf)) //1
{ 
if(!Model.getFacade().isReturn(parameter))//1
{ 
count++;
} 
} 
return count;
} 
protected List<String> parseArguments(String paramExpr,
                                          boolean mayDeleteExpr)
    { 
String token;
List<String> args = null;
if(paramExpr != null)//1
{ 
MyTokenizer st = new MyTokenizer(paramExpr, "\\,",
                                             parameterCustomSep);
args = new ArrayList<String>();
while (st.hasMoreTokens()) //1
{ 
token = st.nextToken();
if(",".equals(token))//1
{ 
if(args.size() == 0)//1
{ 
args.add(null);
} 
args.add(null);
} 
else
{ 
if(args.size() == 0)//1
{ 
if(token.trim().length() == 0)//1
{ 
continue;
} 
args.add(null);
} 
String arg = args.get(args.size() - 1);
if(arg != null)//1
{ 
arg = arg + token;
} 
else
{ 
arg = token;
} 
args.set(args.size() - 1, arg);
} 
} 
} 
else
if(mayDeleteExpr)//1
{ 
args = new ArrayList<String>();
} 
return args;
} 
private boolean isPredecessorMsg(Object pre, Object suc, int md)
    { 
Iterator it = Model.getFacade().getPredecessors(suc).iterator();
while (it.hasNext()) //1
{ 
Object m = /* (MMessage) */it.next();
if(m == pre)//1
{ 
return true;
} 
if(md > 0 && isPredecessorMsg(pre, m, md - 1))//1
{ 
return true;
} 
} 
return false;
} 
protected String generateRecurrence(Object expr)
    { 
if(expr == null)//1
{ 
return "";
} 
return Model.getFacade().getBody(expr).toString();
} 
protected String getInitiatorOfAction(Object umlAction)
    { 
String result = "";
if(Model.getFacade().isACallAction(umlAction))//1
{ 
Object umlOperation = Model.getFacade().getOperation(umlAction);
if(Model.getFacade().isAOperation(umlOperation))//1
{ 
StringBuilder sb = new StringBuilder(
                    Model.getFacade().getName(umlOperation));
if(sb.length() > 0)//1
{ 
sb.append("()");
result = sb.toString();
} 
} 
} 
else
if(Model.getFacade().isASendAction(umlAction))//1
{ 
Object umlSignal = Model.getFacade().getSignal(umlAction);
if(Model.getFacade().isASignal(umlSignal))//1
{ 
String n = Model.getFacade().getName(umlSignal);
if(n != null)//1
{ 
result = n;
} 
} 
} 
return result;
} 
protected void buildAction(Object umlMessage)
    { 
if(Model.getFacade().getAction(umlMessage) == null)//1
{ 
Object a = Model.getCommonBehaviorFactory()
                       .createCallAction();
Model.getCoreHelper().addOwnedElement(Model.getFacade().getContext(
                    Model.getFacade().getInteraction(umlMessage)), a);
} 
} 
protected boolean handleArguments(Object umlMessage, List<String> args,
                                      boolean refindOperation)
    { 
if(args != null)//1
{ 
Collection c = new ArrayList(
                Model.getFacade().getActualArguments(
                    Model.getFacade().getAction(umlMessage)));
Iterator it = c.iterator();
int ii;
for (ii = 0; ii < args.size(); ii++) //1
{ 
Object umlArgument = (it.hasNext() ? it.next() : null);
if(umlArgument == null)//1
{ 
umlArgument = Model.getCommonBehaviorFactory()
                                  .createArgument();
Model.getCommonBehaviorHelper().addActualArgument(
                        Model.getFacade().getAction(umlMessage), umlArgument);
refindOperation = true;
} 
if(Model.getFacade().getValue(umlArgument) == null
                        || !args.get(ii).equals(
                            Model.getFacade().getBody(
                                Model.getFacade().getValue(umlArgument))))//1
{ 
String value = (args.get(ii) != null ? args.get(ii)
                                    : "");
Object umlExpression =
                        Model.getDataTypesFactory().createExpression(
                            getExpressionLanguage(),
                            value.trim());
Model.getCommonBehaviorHelper().setValue(umlArgument, umlExpression);
} 
} 
while (it.hasNext()) //1
{ 
Model.getCommonBehaviorHelper()
                .removeActualArgument(Model.getFacade().getAction(umlMessage),
                                      it.next());
refindOperation = true;
} 
} 
return refindOperation;
} 
private Object walkTree(Object root, List path)
    { 
int i;
for (i = 0; i + 1 < path.size(); i += 2) //1
{ 
int bv = 0;
if(path.get(i) != null)//1
{ 
bv = Math.max(((Integer) path.get(i)).intValue() - 1, 0);
} 
int sv = 0;
if(path.get(i + 1) != null)//1
{ 
sv = Math.max(((Integer) path.get(i + 1)).intValue(), 0);
} 
root = walk(root, bv - 1, true);
if(root == null)//1
{ 
return null;
} 
if(bv > 0)//1
{ 
root = successor(root, sv);
if(root == null)//1
{ 
return null;
} 
} 
if(i + 3 < path.size())//1
{ 
Iterator it =
                    findCandidateRoots(
                        Model.getFacade().getActivatedMessages(root),
                        root,
                        null).iterator();
if(!it.hasNext())//1
{ 
return null;
} 
root = /* (MMessage) */it.next();
} 
} 
return root;
} 
protected void handleOperation(Object umlMessage, String fname,
                                   boolean refindOperation) throws ParseException
    { 
if(fname != null && refindOperation)//1
{ 
Object role = Model.getFacade().getReceiver(umlMessage);
List ops =
                getOperation(
                    Model.getFacade().getBases(role),
                    fname.trim(),
                    Model.getFacade().getActualArguments(
                        Model.getFacade().getAction(umlMessage)).size());
Object callAction = Model.getFacade().getAction(umlMessage);
if(Model.getFacade().isACallAction(callAction))//1
{ 
if(ops.size() > 0)//1
{ 
Model.getCommonBehaviorHelper().setOperation(callAction,
                            ops.get(0));
} 
else
{ 
Model.getCommonBehaviorHelper().setOperation(
                        callAction, null);
} 
} 
} 
} 
private static int findMsgOrderBreak(String s)
    { 
int i, t;
t = s.length();
for (i = 0; i < t; i++) //1
{ 
char c = s.charAt(i);
if(c < '0' || c > '9')//1
{ 
break;

} 
} 
return i;
} 
private boolean isMsgNumberStartOf(String n1, String n2)
    { 
int i, j, len, jlen;
len = n1.length();
jlen = n2.length();
i = 0;
j = 0;
for (; i < len;) //1
{ 
int ibv, isv;
int jbv, jsv;
ibv = 0;
for (; i < len; i++) //1
{ 
char c = n1.charAt(i);
if(c < '0' || c > '9')//1
{ 
break;

} 
ibv *= 10;
ibv += c - '0';
} 
isv = 0;
for (; i < len; i++) //2
{ 
char c = n1.charAt(i);
if(c < 'a' || c > 'z')//1
{ 
break;

} 
isv *= 26;
isv += c - 'a';
} 
jbv = 0;
for (; j < jlen; j++) //1
{ 
char c = n2.charAt(j);
if(c < '0' || c > '9')//1
{ 
break;

} 
jbv *= 10;
jbv += c - '0';
} 
jsv = 0;
for (; j < jlen; j++) //2
{ 
char c = n2.charAt(j);
if(c < 'a' || c > 'z')//1
{ 
break;

} 
jsv *= 26;
jsv += c - 'a';
} 
if(ibv != jbv || isv != jsv)//1
{ 
return false;
} 
if(i < len && n1.charAt(i) != '.')//1
{ 
return false;
} 
i++;
if(j < jlen && n2.charAt(j) != '.')//1
{ 
return false;
} 
j++;
} 
return true;
} 
private Object successor(Object/* MMessage */r, int steps)
    { 
Iterator it = Model.getFacade().getSuccessors(r).iterator();
while (it.hasNext() && steps > 0) //1
{ 
it.next();
steps--;
} 
if(it.hasNext())//1
{ 
return /* (MMessage) */it.next();
} 
return null;
} 
private boolean isBadPreMsg(Object ans, Object chld)
    { 
while (chld != null) //1
{ 
if(ans == chld)//1
{ 
return true;
} 
if(isPredecessorMsg(ans, chld, 100))//1
{ 
return true;
} 
chld = Model.getFacade().getActivator(chld);
} 
return false;
} 
private Object findMsg(Object/* MClassifierRole */r, String n)
    { 
Collection c = Model.getFacade().getReceivedMessages(r);
Iterator it = c.iterator();
while (it.hasNext()) //1
{ 
Object msg = /* (MMessage) */it.next();
String gname = generateMessageNumber(msg);
if(compareMsgNumbers(gname, n))//1
{ 
return msg;
} 
} 
return null;
} 
protected static class MsgPtr  { 
Object message;

 } 

 } 
