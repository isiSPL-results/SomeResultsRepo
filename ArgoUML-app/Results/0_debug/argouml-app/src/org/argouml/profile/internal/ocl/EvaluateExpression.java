
//#if -62591016 
// Compilation Unit of /EvaluateExpression.java 
 

//#if 1990779613 
package org.argouml.profile.internal.ocl;
//#endif 


//#if 2131974202 
import java.util.ArrayList;
//#endif 


//#if -1288678297 
import java.util.Collection;
//#endif 


//#if -720027197 
import java.util.HashMap;
//#endif 


//#if -719844483 
import java.util.HashSet;
//#endif 


//#if -499244569 
import java.util.List;
//#endif 


//#if 1507937941 
import java.util.Map;
//#endif 


//#if 528323385 
import org.argouml.profile.internal.ocl.uml14.Bag;
//#endif 


//#if -1174790553 
import org.argouml.profile.internal.ocl.uml14.HashBag;
//#endif 


//#if 1480396031 
import org.argouml.profile.internal.ocl.uml14.OclEnumLiteral;
//#endif 


//#if -685439802 
import tudresden.ocl.parser.analysis.DepthFirstAdapter;
//#endif 


//#if -128725700 
import tudresden.ocl.parser.node.AActualParameterList;
//#endif 


//#if 1415704493 
import tudresden.ocl.parser.node.AAdditiveExpressionTail;
//#endif 


//#if -2046406677 
import tudresden.ocl.parser.node.AAndLogicalOperator;
//#endif 


//#if -1717487974 
import tudresden.ocl.parser.node.ABooleanLiteral;
//#endif 


//#if 512850720 
import tudresden.ocl.parser.node.ADeclaratorTail;
//#endif 


//#if -1272519524 
import tudresden.ocl.parser.node.ADivMultiplyOperator;
//#endif 


//#if 560516624 
import tudresden.ocl.parser.node.AEmptyFeatureCallParameters;
//#endif 


//#if 1099849319 
import tudresden.ocl.parser.node.AEnumLiteral;
//#endif 


//#if 20563638 
import tudresden.ocl.parser.node.AEqualRelationalOperator;
//#endif 


//#if 1090733105 
import tudresden.ocl.parser.node.AExpressionListOrRange;
//#endif 


//#if 1761661217 
import tudresden.ocl.parser.node.AFeatureCall;
//#endif 


//#if 1925156055 
import tudresden.ocl.parser.node.AFeatureCallParameters;
//#endif 


//#if 1076116541 
import tudresden.ocl.parser.node.AFeaturePrimaryExpression;
//#endif 


//#if -2100119831 
import tudresden.ocl.parser.node.AGtRelationalOperator;
//#endif 


//#if -599457667 
import tudresden.ocl.parser.node.AGteqRelationalOperator;
//#endif 


//#if -2147151444 
import tudresden.ocl.parser.node.AIfExpression;
//#endif 


//#if -2069023797 
import tudresden.ocl.parser.node.AImpliesLogicalOperator;
//#endif 


//#if -344468048 
import tudresden.ocl.parser.node.AIntegerLiteral;
//#endif 


//#if 1423929514 
import tudresden.ocl.parser.node.AIterateDeclarator;
//#endif 


//#if -739890718 
import tudresden.ocl.parser.node.ALetExpression;
//#endif 


//#if 1171596543 
import tudresden.ocl.parser.node.AListExpressionListOrRangeTail;
//#endif 


//#if 1005923976 
import tudresden.ocl.parser.node.ALiteralCollection;
//#endif 


//#if 1111446340 
import tudresden.ocl.parser.node.ALogicalExpressionTail;
//#endif 


//#if -1043365266 
import tudresden.ocl.parser.node.ALtRelationalOperator;
//#endif 


//#if 1329397442 
import tudresden.ocl.parser.node.ALteqRelationalOperator;
//#endif 


//#if -143276948 
import tudresden.ocl.parser.node.AMinusAddOperator;
//#endif 


//#if 68460062 
import tudresden.ocl.parser.node.AMinusUnaryOperator;
//#endif 


//#if 608425833 
import tudresden.ocl.parser.node.AMultMultiplyOperator;
//#endif 


//#if -219956893 
import tudresden.ocl.parser.node.AMultiplicativeExpressionTail;
//#endif 


//#if -684644144 
import tudresden.ocl.parser.node.ANEqualRelationalOperator;
//#endif 


//#if -316426047 
import tudresden.ocl.parser.node.ANotUnaryOperator;
//#endif 


//#if -1610380437 
import tudresden.ocl.parser.node.AOrLogicalOperator;
//#endif 


//#if 1649018634 
import tudresden.ocl.parser.node.APlusAddOperator;
//#endif 


//#if 1947826776 
import tudresden.ocl.parser.node.APostfixExpressionTail;
//#endif 


//#if -1081592316 
import tudresden.ocl.parser.node.ARealLiteral;
//#endif 


//#if -234122894 
import tudresden.ocl.parser.node.ARelationalExpressionTail;
//#endif 


//#if 1942725395 
import tudresden.ocl.parser.node.AStandardDeclarator;
//#endif 


//#if -2092741897 
import tudresden.ocl.parser.node.AStringLiteral;
//#endif 


//#if 1666940841 
import tudresden.ocl.parser.node.AUnaryUnaryExpression;
//#endif 


//#if 774970991 
import tudresden.ocl.parser.node.AXorLogicalOperator;
//#endif 


//#if -1554690725 
import tudresden.ocl.parser.node.PActualParameterListTail;
//#endif 


//#if 1444772657 
import tudresden.ocl.parser.node.PDeclaratorTail;
//#endif 


//#if 1160637722 
import tudresden.ocl.parser.node.PExpression;
//#endif 


//#if 871835052 
import tudresden.ocl.parser.node.PExpressionListTail;
//#endif 


//#if 166226615 
import org.apache.log4j.Logger;
//#endif 


//#if 1005556399 
public class EvaluateExpression extends 
//#if -1821762495 
DepthFirstAdapter
//#endif 

  { 

//#if 2041587643 
private Map<String, Object> vt = null;
//#endif 


//#if -1072573609 
private Object val = null;
//#endif 


//#if -1041046423 
private Object fwd = null;
//#endif 


//#if 918879358 
private ModelInterpreter interp = null;
//#endif 


//#if 150619486 
private static final Logger LOG = Logger
                                      .getLogger(EvaluateExpression.class);
//#endif 


//#if 2047443005 
@Override
    public void caseAAdditiveExpressionTail(AAdditiveExpressionTail node)
    { 

//#if 1121963413 
Object left = val;
//#endif 


//#if -297822820 
val = null;
//#endif 


//#if -2019318840 
inAAdditiveExpressionTail(node);
//#endif 


//#if -2049562024 
if(node.getAddOperator() != null)//1
{ 

//#if -2092731163 
node.getAddOperator().apply(this);
//#endif 

} 

//#endif 


//#if -936038509 
if(node.getMultiplicativeExpression() != null)//1
{ 

//#if -1965456825 
node.getMultiplicativeExpression().apply(this);
//#endif 

} 

//#endif 


//#if 1114479264 
Object op = node.getAddOperator();
//#endif 


//#if 1807443126 
Object right = val;
//#endif 


//#if 962849590 
val = null;
//#endif 


//#if -1454463446 
if(left != null && op != null && right != null)//1
{ 

//#if 432984683 
if(op instanceof AMinusAddOperator)//1
{ 

//#if -998865792 
val = asInteger(left, node) - asInteger(right, node);
//#endif 

} 
else

//#if 2068284955 
if(op instanceof APlusAddOperator)//1
{ 

//#if 1514586942 
val = asInteger(left, node) + asInteger(right, node);
//#endif 

} 
else
{ 

//#if 89203787 
error(node);
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if 1345480330 
error(node);
//#endif 

} 

//#endif 


//#if -619492295 
outAAdditiveExpressionTail(node);
//#endif 

} 

//#endif 


//#if -1884449101 
public void reset(Map<String, Object> newVT, ModelInterpreter mi)
    { 

//#if -1372158843 
this.interp = mi;
//#endif 


//#if 1803815753 
this.val = null;
//#endif 


//#if 1835342939 
this.fwd = null;
//#endif 


//#if -1105939187 
this.vt = newVT;
//#endif 

} 

//#endif 


//#if -209303498 
private boolean asBoolean(Object value, Object node)
    { 

//#if 1218277869 
if(value instanceof Boolean)//1
{ 

//#if -537599989 
return (Boolean) value;
//#endif 

} 
else
{ 

//#if 1699671799 
errorNotType(node, "Boolean", false);
//#endif 


//#if -39259441 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -726274185 

//#if -1055366244 
@SuppressWarnings("unchecked")
//#endif 


    @Override
    public void caseAFeatureCallParameters(AFeatureCallParameters node)
    { 

//#if -1215027463 
inAFeatureCallParameters(node);
//#endif 


//#if 535549141 
if(node.getLPar() != null)//1
{ 

//#if 532877999 
node.getLPar().apply(this);
//#endif 

} 

//#endif 


//#if 415248465 
boolean hasDeclarator = false;
//#endif 


//#if 571850097 
if(node.getDeclarator() != null)//1
{ 

//#if -183567243 
node.getDeclarator().apply(this);
//#endif 


//#if 937514036 
hasDeclarator = true;
//#endif 

} 

//#endif 


//#if -226588591 
if(node.getActualParameterList() != null)//1
{ 

//#if -763632893 
List<String> vars = null;
//#endif 


//#if 1722224473 
if(hasDeclarator)//1
{ 

//#if -1400479638 
List ret = new ArrayList();
//#endif 


//#if -1674489585 
vars = (List) val;
//#endif 


//#if 695059393 
final PExpression exp = ((AActualParameterList) node
                                         .getActualParameterList()).getExpression();
//#endif 


//#if 1212437265 
ret.add(vars);
//#endif 


//#if 439734012 
ret.add(exp);
//#endif 


//#if -994352808 
ret.add(new LambdaEvaluator() {

                    /*
                     * @see org.argouml.profile.internal.ocl.LambdaEvaluator#evaluate(java.util.Map,
                     *      java.lang.Object)
                     */
                    public Object evaluate(Map<String, Object> vti,
                                           Object expi) {

                        Object state = EvaluateExpression.this.saveState();

                        EvaluateExpression.this.vt = vti;
                        EvaluateExpression.this.val = null;
                        EvaluateExpression.this.fwd = null;

                        ((PExpression) expi).apply(EvaluateExpression.this);

                        Object reti = EvaluateExpression.this.val;
                        EvaluateExpression.this.loadState(state);
                        return reti;
                    }

                });
//#endif 


//#if -969216235 
val = ret;
//#endif 

} 
else
{ 

//#if 1116310455 
node.getActualParameterList().apply(this);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1767311375 
if(node.getRPar() != null)//1
{ 

//#if -55376304 
node.getRPar().apply(this);
//#endif 

} 

//#endif 


//#if -813709742 
outAFeatureCallParameters(node);
//#endif 

} 

//#endif 


//#if 63500791 
@Override
    public void caseAFeatureCall(AFeatureCall node)
    { 

//#if 355890193 
Object subject = val;
//#endif 


//#if 811832807 
Object feature = null;
//#endif 


//#if -956377435 
Object type = fwd;
//#endif 


//#if 1334705350 
List parameters = null;
//#endif 


//#if -1449912963 
inAFeatureCall(node);
//#endif 


//#if 1841888778 
if(node.getPathName() != null)//1
{ 

//#if -291282947 
node.getPathName().apply(this);
//#endif 


//#if -750599613 
feature = node.getPathName().toString().trim();
//#endif 

} 

//#endif 


//#if 1984891135 
if(node.getTimeExpression() != null)//1
{ 

//#if -1873932889 
node.getTimeExpression().apply(this);
//#endif 

} 

//#endif 


//#if 2021673411 
if(node.getQualifiers() != null)//1
{ 

//#if 1123722408 
node.getQualifiers().apply(this);
//#endif 

} 

//#endif 


//#if 1257706140 
if(node.getFeatureCallParameters() != null)//1
{ 

//#if 182126530 
val = null;
//#endif 


//#if -60275655 
node.getFeatureCallParameters().apply(this);
//#endif 


//#if -701311878 
parameters = (List) val;
//#endif 

} 
else
{ 

//#if -2136420953 
parameters = new ArrayList();
//#endif 

} 

//#endif 


//#if -197266692 
val = runFeatureCall(subject, feature, type, parameters);
//#endif 


//#if 2082330210 
outAFeatureCall(node);
//#endif 

} 

//#endif 


//#if -362518963 
public void caseAPostfixExpressionTail(APostfixExpressionTail node)
    { 

//#if -1510877550 
inAPostfixExpressionTail(node);
//#endif 


//#if 659610724 
if(node.getPostfixExpressionTailBegin() != null)//1
{ 

//#if -923341381 
node.getPostfixExpressionTailBegin().apply(this);
//#endif 

} 

//#endif 


//#if 323691380 
if(node.getFeatureCall() != null)//1
{ 

//#if 416193944 
fwd = node.getPostfixExpressionTailBegin();
//#endif 


//#if -1168847249 
node.getFeatureCall().apply(this);
//#endif 

} 

//#endif 


//#if 214369083 
outAPostfixExpressionTail(node);
//#endif 

} 

//#endif 


//#if -1032979791 
public void caseAIfExpression(AIfExpression node)
    { 

//#if 483112716 
boolean test = false;
//#endif 


//#if 1475776299 
boolean ret = false;
//#endif 


//#if 967367900 
inAIfExpression(node);
//#endif 


//#if 542091001 
if(node.getTIf() != null)//1
{ 

//#if 1584850215 
node.getTIf().apply(this);
//#endif 

} 

//#endif 


//#if 666615663 
if(node.getIfBranch() != null)//1
{ 

//#if -1725648906 
node.getIfBranch().apply(this);
//#endif 


//#if 1323392236 
test = asBoolean(val, node.getIfBranch());
//#endif 


//#if -599768448 
val = null;
//#endif 

} 

//#endif 


//#if -1751305223 
if(node.getTThen() != null)//1
{ 

//#if 2139701170 
node.getTThen().apply(this);
//#endif 

} 

//#endif 


//#if -687767697 
if(node.getThenBranch() != null)//1
{ 

//#if 1105168067 
node.getThenBranch().apply(this);
//#endif 


//#if 1751233658 
if(test)//1
{ 

//#if 1585286743 
ret = asBoolean(val, node.getThenBranch());
//#endif 


//#if 1995562966 
val = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1090213611 
if(node.getTElse() != null)//1
{ 

//#if 985315907 
node.getTElse().apply(this);
//#endif 

} 

//#endif 


//#if -1754550389 
if(node.getElseBranch() != null)//1
{ 

//#if 1873912561 
node.getElseBranch().apply(this);
//#endif 


//#if 197145809 
if(!test)//1
{ 

//#if 1135174674 
ret = asBoolean(val, node.getThenBranch());
//#endif 


//#if 1799918971 
val = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1919616000 
if(node.getEndif() != null)//1
{ 

//#if 1177197581 
node.getEndif().apply(this);
//#endif 

} 

//#endif 


//#if -121455801 
val = ret;
//#endif 


//#if 88663427 
outAIfExpression(node);
//#endif 

} 

//#endif 


//#if 240761212 
public EvaluateExpression(Map<String, Object> variableTable,
                              ModelInterpreter modelInterpreter)
    { 

//#if -294312859 
reset(variableTable, modelInterpreter);
//#endif 

} 

//#endif 


//#if -464000801 
public void caseAMultiplicativeExpressionTail(
        AMultiplicativeExpressionTail node)
    { 

//#if 1603413286 
Object left = val;
//#endif 


//#if 925576685 
val = null;
//#endif 


//#if 1573740237 
inAMultiplicativeExpressionTail(node);
//#endif 


//#if -1626013314 
if(node.getMultiplyOperator() != null)//1
{ 

//#if -57989510 
node.getMultiplyOperator().apply(this);
//#endif 

} 

//#endif 


//#if -218438167 
if(node.getUnaryExpression() != null)//1
{ 

//#if 527727067 
node.getUnaryExpression().apply(this);
//#endif 

} 

//#endif 


//#if -88392298 
Object op = node.getMultiplyOperator();
//#endif 


//#if -447479995 
Object right = val;
//#endif 


//#if 165029189 
val = null;
//#endif 


//#if -1070316615 
if(left != null && op != null && right != null)//1
{ 

//#if -846290352 
if(op instanceof ADivMultiplyOperator)//1
{ 

//#if -1638787626 
val = asInteger(left, node) / asInteger(right, node);
//#endif 

} 
else

//#if 1688795261 
if(op instanceof AMultMultiplyOperator)//1
{ 

//#if -366078533 
val = asInteger(left, node) * asInteger(right, node);
//#endif 

} 
else
{ 

//#if 1830883477 
error(node);
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if 990935243 
error(node);
//#endif 

} 

//#endif 


//#if -2093322816 
outAMultiplicativeExpressionTail(node);
//#endif 

} 

//#endif 


//#if -1301347759 
@Override
    public void outAEmptyFeatureCallParameters(AEmptyFeatureCallParameters node)
    { 

//#if -2141876631 
val = new ArrayList();
//#endif 


//#if -279001231 
defaultOut(node);
//#endif 

} 

//#endif 


//#if 751509039 
public void outABooleanLiteral(ABooleanLiteral node)
    { 

//#if 1089565260 
val = Boolean.parseBoolean(node.getBool().getText());
//#endif 


//#if -619152083 
defaultOut(node);
//#endif 

} 

//#endif 


//#if -1283210028 
private Object saveState()
    { 

//#if 1829341354 
return new Object[] {vt, val, fwd};
//#endif 

} 

//#endif 


//#if 1847027159 
@Override
    public void caseAActualParameterList(AActualParameterList node)
    { 

//#if -1402470999 
List list = new ArrayList();
//#endif 


//#if -235769608 
inAActualParameterList(node);
//#endif 


//#if 633410418 
if(node.getExpression() != null)//1
{ 

//#if 899215311 
val = null;
//#endif 


//#if 753558060 
node.getExpression().apply(this);
//#endif 


//#if -308536859 
list.add(val);
//#endif 

} 

//#endif 

{ 

//#if -938751134 
Object temp[] = node.getActualParameterListTail().toArray();
//#endif 


//#if -1565206748 
for (int i = 0; i < temp.length; i++) //1
{ 

//#if -1504420765 
val = null;
//#endif 


//#if -423217329 
((PActualParameterListTail) temp[i]).apply(this);
//#endif 


//#if 28404177 
list.add(val);
//#endif 

} 

//#endif 

} 

//#if -1756071814 
val = list;
//#endif 


//#if 2010626973 
outAActualParameterList(node);
//#endif 

} 

//#endif 


//#if 1603215513 
private void errorNotType(Object node, String type, Object dft)
    { 

//#if 25882571 
LOG.error("OCL does not evaluate to a " + type + " expression!! Exp: "
                  + node + " Val: " + val);
//#endif 


//#if -1264637817 
val = dft;
//#endif 


//#if 1068329735 
throw new RuntimeException();
//#endif 

} 

//#endif 


//#if -1180430363 
@Override
    public void outAIterateDeclarator(AIterateDeclarator node)
    { 

//#if 694821727 
val = new ArrayList<String>();
//#endif 


//#if 1128269880 
defaultOut(node);
//#endif 

} 

//#endif 


//#if 912853426 
private void error(Object node)
    { 

//#if -1082859064 
LOG.error("Unknown error processing OCL exp!! Exp: " + node + " Val: "
                  + val);
//#endif 


//#if -299189708 
val = null;
//#endif 


//#if -924529499 
throw new RuntimeException();
//#endif 

} 

//#endif 


//#if 832552215 
@Override
    public void caseALetExpression(ALetExpression node)
    { 

//#if -1717848092 
Object name = null;
//#endif 


//#if 449609286 
Object value = null;
//#endif 


//#if 1956925282 
inALetExpression(node);
//#endif 


//#if -23233051 
if(node.getTLet() != null)//1
{ 

//#if 1973846697 
node.getTLet().apply(this);
//#endif 

} 

//#endif 


//#if 695397737 
if(node.getName() != null)//1
{ 

//#if -1147592332 
node.getName().apply(this);
//#endif 


//#if -1526657173 
name = node.getName().toString().trim();
//#endif 

} 

//#endif 


//#if -571993045 
if(node.getLetExpressionTypeDeclaration() != null)//1
{ 

//#if 1324140528 
node.getLetExpressionTypeDeclaration().apply(this);
//#endif 

} 

//#endif 


//#if 2033274670 
if(node.getEqual() != null)//1
{ 

//#if 1946970692 
node.getEqual().apply(this);
//#endif 

} 

//#endif 


//#if 1001501814 
if(node.getExpression() != null)//1
{ 

//#if 904672300 
node.getExpression().apply(this);
//#endif 


//#if 429397263 
value = val;
//#endif 

} 

//#endif 


//#if -1729673037 
if(node.getTIn() != null)//1
{ 

//#if -1116111136 
node.getTIn().apply(this);
//#endif 

} 

//#endif 


//#if 1460710867 
vt.put(("" + name).trim(), value);
//#endif 


//#if 1574727093 
val = null;
//#endif 


//#if 192138815 
outALetExpression(node);
//#endif 

} 

//#endif 


//#if 1087847808 
private Object runFeatureCall(Object subject, Object feature, Object type,
                                  List parameters)
    { 

//#if 237981784 
if(parameters == null)//1
{ 

//#if -295659998 
parameters = new ArrayList<Object>();
//#endif 

} 

//#endif 


//#if -328234654 
if((subject instanceof Collection)
                && type.toString().trim().equals("."))//1
{ 

//#if 1292042897 
Collection col = (Collection) subject;
//#endif 


//#if -99674017 
Bag res = new HashBag();
//#endif 


//#if 1708393379 
for (Object obj : col) //1
{ 

//#if 1930007913 
res.add(interp.invokeFeature(vt, obj,
                                             feature.toString().trim(), ".", parameters.toArray()));
//#endif 

} 

//#endif 


//#if -555979057 
return res;
//#endif 

} 
else
{ 

//#if 825668986 
return interp.invokeFeature(vt, subject, feature.toString().trim(),
                                        type.toString().trim(), parameters.toArray());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -84660507 
public Object getValue()
    { 

//#if 158908098 
return val;
//#endif 

} 

//#endif 


//#if -1218023347 

//#if -1953103415 
@SuppressWarnings("unchecked")
//#endif 


    public void caseALiteralCollection(ALiteralCollection node)
    { 

//#if -1477582795 
Collection<Object> col = null;
//#endif 


//#if -1307601590 
inALiteralCollection(node);
//#endif 


//#if 539825138 
if(node.getCollectionKind() != null)//1
{ 

//#if -460843802 
node.getCollectionKind().apply(this);
//#endif 


//#if 132926917 
String kind = node.getCollectionKind().toString().trim();
//#endif 


//#if 298233906 
if(kind.equalsIgnoreCase("Set"))//1
{ 

//#if 811592504 
col = new HashSet<Object>();
//#endif 

} 
else

//#if 1444679736 
if(kind.equalsIgnoreCase("Sequence"))//1
{ 

//#if -972468843 
col = new ArrayList<Object>();
//#endif 

} 
else

//#if -1723512856 
if(kind.equalsIgnoreCase("Bag"))//1
{ 

//#if -1159242763 
col = new HashBag<Object>();
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -1711067577 
if(node.getLBrace() != null)//1
{ 

//#if -400484354 
node.getLBrace().apply(this);
//#endif 

} 

//#endif 


//#if -1390787620 
if(node.getExpressionListOrRange() != null)//1
{ 

//#if 650777178 
val = null;
//#endif 


//#if -1393474437 
node.getExpressionListOrRange().apply(this);
//#endif 


//#if -1839417417 
col.addAll((Collection<Object>) val);
//#endif 

} 

//#endif 


//#if 896432897 
if(node.getRBrace() != null)//1
{ 

//#if -241394685 
node.getRBrace().apply(this);
//#endif 

} 

//#endif 


//#if -1751811464 
val = col;
//#endif 


//#if 2105019235 
outALiteralCollection(node);
//#endif 

} 

//#endif 


//#if 1457056311 
@Override
    public void caseAExpressionListOrRange(AExpressionListOrRange node)
    { 

//#if -1029392256 
List ret = new ArrayList();
//#endif 


//#if 1157994603 
inAExpressionListOrRange(node);
//#endif 


//#if -434875664 
if(node.getExpression() != null)//1
{ 

//#if -628513118 
val = null;
//#endif 


//#if 1281921023 
node.getExpression().apply(this);
//#endif 


//#if -796388983 
ret.add(val);
//#endif 

} 

//#endif 


//#if 489175700 
if(node.getExpressionListOrRangeTail() != null)//1
{ 

//#if -11755702 
val = null;
//#endif 


//#if 855908635 
node.getExpressionListOrRangeTail().apply(this);
//#endif 


//#if -1455080445 
ret.addAll((Collection) val);
//#endif 

} 

//#endif 


//#if 1431711167 
val = ret;
//#endif 


//#if 1089576852 
outAExpressionListOrRange(node);
//#endif 

} 

//#endif 


//#if -90127281 
public EvaluateExpression(Object modelElement, ModelInterpreter mi)
    { 

//#if -69244870 
reset(modelElement, mi);
//#endif 

} 

//#endif 


//#if 213488669 
@Override
    public void caseAFeaturePrimaryExpression(AFeaturePrimaryExpression node)
    { 

//#if 1487636681 
Object subject = val;
//#endif 


//#if 1536235567 
Object feature = null;
//#endif 


//#if -1978612866 
List parameters = null;
//#endif 


//#if -1510588485 
inAFeaturePrimaryExpression(node);
//#endif 


//#if -610446254 
if(node.getPathName() != null)//1
{ 

//#if -872453337 
node.getPathName().apply(this);
//#endif 


//#if 1261370349 
feature = node.getPathName().toString().trim();
//#endif 

} 

//#endif 


//#if 1842055495 
if(node.getTimeExpression() != null)//1
{ 

//#if 1551732430 
node.getTimeExpression().apply(this);
//#endif 

} 

//#endif 


//#if -1030214133 
if(node.getQualifiers() != null)//1
{ 

//#if 439225932 
node.getQualifiers().apply(this);
//#endif 

} 

//#endif 


//#if -37801644 
if(node.getFeatureCallParameters() != null)//1
{ 

//#if 1842593361 
val = null;
//#endif 


//#if -673952950 
node.getFeatureCallParameters().apply(this);
//#endif 


//#if -419746679 
parameters = (List) val;
//#endif 

} 

//#endif 


//#if -1005873937 
if(subject == null)//1
{ 

//#if -1760444350 
val = vt.get(feature);
//#endif 


//#if -1554540763 
if(val == null)//1
{ 

//#if 1042955729 
val = this.interp.getBuiltInSymbol(feature.toString().trim());
//#endif 

} 

//#endif 

} 
else
{ 

//#if -251255512 
val = runFeatureCall(subject, feature, fwd, parameters);
//#endif 

} 

//#endif 


//#if -2022365050 
outAFeaturePrimaryExpression(node);
//#endif 

} 

//#endif 


//#if 347072463 
public void outAEnumLiteral(AEnumLiteral node)
    { 

//#if -150376855 
val = new OclEnumLiteral(node.getName().toString().trim());
//#endif 


//#if -868483790 
defaultOut(node);
//#endif 

} 

//#endif 


//#if 1132868983 
@Override
    public void caseAListExpressionListOrRangeTail(
        AListExpressionListOrRangeTail node)
    { 

//#if -1354941537 
inAListExpressionListOrRangeTail(node);
//#endif 

{ 

//#if 1257817868 
List ret = new ArrayList();
//#endif 


//#if -1958867986 
Object temp[] = node.getExpressionListTail().toArray();
//#endif 


//#if -534525071 
for (int i = 0; i < temp.length; i++) //1
{ 

//#if 1769183689 
val = null;
//#endif 


//#if -1533845272 
((PExpressionListTail) temp[i]).apply(this);
//#endif 


//#if 627448112 
ret.add(val);
//#endif 

} 

//#endif 


//#if 187717811 
val = ret;
//#endif 

} 

//#if 2139703996 
outAListExpressionListOrRangeTail(node);
//#endif 

} 

//#endif 


//#if 787843261 
public void caseARelationalExpressionTail(ARelationalExpressionTail node)
    { 

//#if 250573526 
Object left = val;
//#endif 


//#if -750747747 
val = null;
//#endif 


//#if -1646366612 
inARelationalExpressionTail(node);
//#endif 


//#if 1741564465 
if(node.getRelationalOperator() != null)//1
{ 

//#if 1111233877 
node.getRelationalOperator().apply(this);
//#endif 

} 

//#endif 


//#if -1383990454 
if(node.getAdditiveExpression() != null)//1
{ 

//#if -1386167779 
node.getAdditiveExpression().apply(this);
//#endif 

} 

//#endif 


//#if -1279848445 
Object op = node.getRelationalOperator();
//#endif 


//#if 564160405 
Object right = val;
//#endif 


//#if -1631373931 
val = null;
//#endif 


//#if -958350327 
if(left != null && op != null && right != null)//1
{ 

//#if -2103168597 
if(op instanceof AEqualRelationalOperator)//1
{ 

//#if -2116265806 
val = left.equals(right);
//#endif 

} 
else

//#if 1621444484 
if(op instanceof AGteqRelationalOperator)//1
{ 

//#if -2109647060 
val = asInteger(left, node) >= asInteger(right, node);
//#endif 

} 
else

//#if -809655607 
if(op instanceof AGtRelationalOperator)//1
{ 

//#if 256501282 
val = asInteger(left, node) > asInteger(right, node);
//#endif 

} 
else

//#if -960199605 
if(op instanceof ALteqRelationalOperator)//1
{ 

//#if 116567402 
val = asInteger(left, node) <= asInteger(right, node);
//#endif 

} 
else

//#if 683709940 
if(op instanceof ALtRelationalOperator)//1
{ 

//#if -568054786 
val = asInteger(left, node) < asInteger(right, node);
//#endif 

} 
else

//#if -461802552 
if(op instanceof ANEqualRelationalOperator)//1
{ 

//#if 1202187507 
val = !left.equals(right);
//#endif 

} 
else
{ 

//#if 958285785 
error(node);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 
else
{ 

//#if 1986795538 
if(op instanceof AEqualRelationalOperator)//1
{ 

//#if 197771142 
val = (left == right);
//#endif 

} 
else

//#if -1335890449 
if(op instanceof ANEqualRelationalOperator)//1
{ 

//#if -1456084567 
val = (left != right);
//#endif 

} 
else
{ 

//#if -329094248 
error(node);
//#endif 


//#if -372371308 
val = null;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1758695999 
outARelationalExpressionTail(node);
//#endif 

} 

//#endif 


//#if -233742609 
public void outARealLiteral(ARealLiteral node)
    { 

//#if -1176411470 
val = (int) Double.parseDouble(node.getReal().getText());
//#endif 


//#if -1131299735 
defaultOut(node);
//#endif 

} 

//#endif 


//#if -2048492965 
public void outAIntegerLiteral(AIntegerLiteral node)
    { 

//#if -437256309 
val = Integer.parseInt(node.getInt().getText());
//#endif 


//#if -1096768654 
defaultOut(node);
//#endif 

} 

//#endif 


//#if -646990058 
public void reset(Object element, ModelInterpreter mi)
    { 

//#if 1348968059 
vt = new HashMap<String, Object>();
//#endif 


//#if 503056083 
vt.put("self", element);
//#endif 


//#if 1160872919 
reset(vt, mi);
//#endif 

} 

//#endif 


//#if -2012485489 
public void outAStringLiteral(AStringLiteral node)
    { 

//#if 1851731213 
String text = node.getStringLit().getText();
//#endif 


//#if 1653719937 
val = text.substring(1, text.length() - 1);
//#endif 


//#if -689694155 
defaultOut(node);
//#endif 

} 

//#endif 


//#if -1246133111 
@Override
    public void caseAStandardDeclarator(AStandardDeclarator node)
    { 

//#if -8774512 
inAStandardDeclarator(node);
//#endif 


//#if -1375244370 
List<String> vars = new ArrayList<String>();
//#endif 


//#if 57313390 
if(node.getName() != null)//1
{ 

//#if 1497809614 
node.getName().apply(this);
//#endif 


//#if -495712845 
vars.add(node.getName().toString().trim());
//#endif 

} 

//#endif 

{ 

//#if -1626643209 
Object temp[] = node.getDeclaratorTail().toArray();
//#endif 


//#if 1376443509 
for (int i = 0; i < temp.length; i++) //1
{ 

//#if 156122005 
((PDeclaratorTail) temp[i]).apply(this);
//#endif 


//#if 232192669 
vars.add(((ADeclaratorTail) temp[i]).getName()
                         .toString().trim());
//#endif 

} 

//#endif 


//#if -1107292878 
val = vars;
//#endif 

} 

//#if -1158698492 
if(node.getDeclaratorTypeDeclaration() != null)//1
{ 

//#if -1329137701 
node.getDeclaratorTypeDeclaration().apply(this);
//#endif 

} 

//#endif 


//#if 1864843624 
if(node.getBar() != null)//1
{ 

//#if 55908053 
node.getBar().apply(this);
//#endif 

} 

//#endif 


//#if -1555462147 
outAStandardDeclarator(node);
//#endif 

} 

//#endif 


//#if -259924787 
public void caseALogicalExpressionTail(ALogicalExpressionTail node)
    { 

//#if 814063299 
Object left = val;
//#endif 


//#if 1009606986 
val = null;
//#endif 


//#if 2079047193 
inALogicalExpressionTail(node);
//#endif 


//#if -154797742 
if(node.getLogicalOperator() != null)//1
{ 

//#if -1045314054 
node.getLogicalOperator().apply(this);
//#endif 

} 

//#endif 


//#if -858423214 
if(node.getRelationalExpression() != null)//1
{ 

//#if -1323703436 
node.getRelationalExpression().apply(this);
//#endif 

} 

//#endif 


//#if 409884390 
Object op = node.getLogicalOperator();
//#endif 


//#if 852474184 
Object right = val;
//#endif 


//#if -454207288 
val = null;
//#endif 


//#if 2145333897 
if(op != null)//1
{ 

//#if -762220754 
if(op instanceof AAndLogicalOperator)//1
{ 

//#if -863598179 
if(left != null && left instanceof Boolean && ((Boolean)left).booleanValue() == false)//1
{ 

//#if 1241105418 
val = false;
//#endif 

} 
else

//#if -1429349604 
if(right != null && right instanceof Boolean && ((Boolean)right).booleanValue() == false)//1
{ 

//#if 312685355 
val = false;
//#endif 

} 
else
{ 

//#if 115297142 
val = asBoolean(left, node) && asBoolean(right, node);
//#endif 

} 

//#endif 


//#endif 

} 
else

//#if -1347969453 
if(op instanceof AImpliesLogicalOperator)//1
{ 

//#if -630165155 
val = !asBoolean(left, node) || asBoolean(right, node);
//#endif 

} 
else

//#if 1558896961 
if(op instanceof AOrLogicalOperator)//1
{ 

//#if -698982861 
if(left != null && left instanceof Boolean && ((Boolean)left).booleanValue() == true)//1
{ 

//#if -1096505937 
val = true;
//#endif 

} 
else

//#if 148703844 
if(right != null && right instanceof Boolean && ((Boolean)right).booleanValue() == true)//1
{ 

//#if 310414743 
val = true;
//#endif 

} 
else
{ 

//#if -1311715816 
val = asBoolean(left, node) || asBoolean(right, node);
//#endif 

} 

//#endif 


//#endif 

} 
else

//#if -1024605591 
if(op instanceof AXorLogicalOperator)//1
{ 

//#if 248340830 
val = !asBoolean(left, node) ^ asBoolean(right, node);
//#endif 

} 
else
{ 

//#if 265187211 
error(node);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 

} 
else
{ 

//#if 8169695 
error(node);
//#endif 

} 

//#endif 


//#if 721420012 
outALogicalExpressionTail(node);
//#endif 

} 

//#endif 


//#if -1503601173 
public void caseAUnaryUnaryExpression(AUnaryUnaryExpression node)
    { 

//#if -838366090 
inAUnaryUnaryExpression(node);
//#endif 


//#if 277011416 
if(node.getUnaryOperator() != null)//1
{ 

//#if -1908529703 
node.getUnaryOperator().apply(this);
//#endif 

} 

//#endif 


//#if 1157990738 
if(node.getPostfixExpression() != null)//1
{ 

//#if -1139431694 
val = null;
//#endif 


//#if 1142402746 
node.getPostfixExpression().apply(this);
//#endif 

} 

//#endif 


//#if -1584440800 
Object op = node.getUnaryOperator();
//#endif 


//#if 348859650 
if(op instanceof AMinusUnaryOperator)//1
{ 

//#if -1650099192 
val = -asInteger(val, node);
//#endif 

} 
else

//#if -1120151811 
if(op instanceof ANotUnaryOperator)//1
{ 

//#if 1428981743 
val = !asBoolean(val, node);
//#endif 

} 

//#endif 


//#endif 


//#if -561126141 
outAUnaryUnaryExpression(node);
//#endif 

} 

//#endif 


//#if -621810582 

//#if -1436768945 
@SuppressWarnings("unchecked")
//#endif 


    private void loadState(Object state)
    { 

//#if -552807109 
Object[] stateArr = (Object[]) state;
//#endif 


//#if 1184084490 
this.vt = (Map<String, Object>) stateArr[0];
//#endif 


//#if -172595627 
this.val = stateArr[1];
//#endif 


//#if -2038079292 
this.fwd = stateArr[2];
//#endif 

} 

//#endif 


//#if -1972251291 
private int asInteger(Object value, Object node)
    { 

//#if 2124296011 
if(value instanceof Integer)//1
{ 

//#if 935343006 
return (Integer) value;
//#endif 

} 
else
{ 

//#if 858175370 
errorNotType(node, "integer", 0);
//#endif 


//#if -942470874 
return 0;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

