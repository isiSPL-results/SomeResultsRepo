package org.argouml.profile.internal.ocl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.argouml.profile.internal.ocl.uml14.Bag;
import org.argouml.profile.internal.ocl.uml14.HashBag;
import org.argouml.profile.internal.ocl.uml14.OclEnumLiteral;
import tudresden.ocl.parser.analysis.DepthFirstAdapter;
import tudresden.ocl.parser.node.AActualParameterList;
import tudresden.ocl.parser.node.AAdditiveExpressionTail;
import tudresden.ocl.parser.node.AAndLogicalOperator;
import tudresden.ocl.parser.node.ABooleanLiteral;
import tudresden.ocl.parser.node.ADeclaratorTail;
import tudresden.ocl.parser.node.ADivMultiplyOperator;
import tudresden.ocl.parser.node.AEmptyFeatureCallParameters;
import tudresden.ocl.parser.node.AEnumLiteral;
import tudresden.ocl.parser.node.AEqualRelationalOperator;
import tudresden.ocl.parser.node.AExpressionListOrRange;
import tudresden.ocl.parser.node.AFeatureCall;
import tudresden.ocl.parser.node.AFeatureCallParameters;
import tudresden.ocl.parser.node.AFeaturePrimaryExpression;
import tudresden.ocl.parser.node.AGtRelationalOperator;
import tudresden.ocl.parser.node.AGteqRelationalOperator;
import tudresden.ocl.parser.node.AIfExpression;
import tudresden.ocl.parser.node.AImpliesLogicalOperator;
import tudresden.ocl.parser.node.AIntegerLiteral;
import tudresden.ocl.parser.node.AIterateDeclarator;
import tudresden.ocl.parser.node.ALetExpression;
import tudresden.ocl.parser.node.AListExpressionListOrRangeTail;
import tudresden.ocl.parser.node.ALiteralCollection;
import tudresden.ocl.parser.node.ALogicalExpressionTail;
import tudresden.ocl.parser.node.ALtRelationalOperator;
import tudresden.ocl.parser.node.ALteqRelationalOperator;
import tudresden.ocl.parser.node.AMinusAddOperator;
import tudresden.ocl.parser.node.AMinusUnaryOperator;
import tudresden.ocl.parser.node.AMultMultiplyOperator;
import tudresden.ocl.parser.node.AMultiplicativeExpressionTail;
import tudresden.ocl.parser.node.ANEqualRelationalOperator;
import tudresden.ocl.parser.node.ANotUnaryOperator;
import tudresden.ocl.parser.node.AOrLogicalOperator;
import tudresden.ocl.parser.node.APlusAddOperator;
import tudresden.ocl.parser.node.APostfixExpressionTail;
import tudresden.ocl.parser.node.ARealLiteral;
import tudresden.ocl.parser.node.ARelationalExpressionTail;
import tudresden.ocl.parser.node.AStandardDeclarator;
import tudresden.ocl.parser.node.AStringLiteral;
import tudresden.ocl.parser.node.AUnaryUnaryExpression;
import tudresden.ocl.parser.node.AXorLogicalOperator;
import tudresden.ocl.parser.node.PActualParameterListTail;
import tudresden.ocl.parser.node.PDeclaratorTail;
import tudresden.ocl.parser.node.PExpression;
import tudresden.ocl.parser.node.PExpressionListTail;
import org.apache.log4j.Logger;
public class EvaluateExpression extends DepthFirstAdapter
  { 
private Map<String, Object> vt = null;
private Object val = null;
private Object fwd = null;
private ModelInterpreter interp = null;
private static final Logger LOG = Logger
                                      .getLogger(EvaluateExpression.class);
@Override
    public void caseAAdditiveExpressionTail(AAdditiveExpressionTail node)
    { 
Object left = val;
val = null;
inAAdditiveExpressionTail(node);
if(node.getAddOperator() != null)//1
{ 
node.getAddOperator().apply(this);
} 
if(node.getMultiplicativeExpression() != null)//1
{ 
node.getMultiplicativeExpression().apply(this);
} 
Object op = node.getAddOperator();
Object right = val;
val = null;
if(left != null && op != null && right != null)//1
{ 
if(op instanceof AMinusAddOperator)//1
{ 
val = asInteger(left, node) - asInteger(right, node);
} 
else
if(op instanceof APlusAddOperator)//1
{ 
val = asInteger(left, node) + asInteger(right, node);
} 
else
{ 
error(node);
} 
} 
else
{ 
error(node);
} 
outAAdditiveExpressionTail(node);
} 
public void reset(Map<String, Object> newVT, ModelInterpreter mi)
    { 
this.interp = mi;
this.val = null;
this.fwd = null;
this.vt = newVT;
} 
private boolean asBoolean(Object value, Object node)
    { 
if(value instanceof Boolean)//1
{ 
return (Boolean) value;
} 
else
{ 
errorNotType(node, "Boolean", false);
return false;
} 
} 
@SuppressWarnings("unchecked")

    @Override
    public void caseAFeatureCallParameters(AFeatureCallParameters node)
    { 
inAFeatureCallParameters(node);
if(node.getLPar() != null)//1
{ 
node.getLPar().apply(this);
} 
boolean hasDeclarator = false;
if(node.getDeclarator() != null)//1
{ 
node.getDeclarator().apply(this);
hasDeclarator = true;
} 
if(node.getActualParameterList() != null)//1
{ 
List<String> vars = null;
if(hasDeclarator)//1
{ 
List ret = new ArrayList();
vars = (List) val;
final PExpression exp = ((AActualParameterList) node
                                         .getActualParameterList()).getExpression();
ret.add(vars);
ret.add(exp);
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
val = ret;
} 
else
{ 
node.getActualParameterList().apply(this);
} 
} 
if(node.getRPar() != null)//1
{ 
node.getRPar().apply(this);
} 
outAFeatureCallParameters(node);
} 
@Override
    public void caseAFeatureCall(AFeatureCall node)
    { 
Object subject = val;
Object feature = null;
Object type = fwd;
List parameters = null;
inAFeatureCall(node);
if(node.getPathName() != null)//1
{ 
node.getPathName().apply(this);
feature = node.getPathName().toString().trim();
} 
if(node.getTimeExpression() != null)//1
{ 
node.getTimeExpression().apply(this);
} 
if(node.getQualifiers() != null)//1
{ 
node.getQualifiers().apply(this);
} 
if(node.getFeatureCallParameters() != null)//1
{ 
val = null;
node.getFeatureCallParameters().apply(this);
parameters = (List) val;
} 
else
{ 
parameters = new ArrayList();
} 
val = runFeatureCall(subject, feature, type, parameters);
outAFeatureCall(node);
} 
public void caseAPostfixExpressionTail(APostfixExpressionTail node)
    { 
inAPostfixExpressionTail(node);
if(node.getPostfixExpressionTailBegin() != null)//1
{ 
node.getPostfixExpressionTailBegin().apply(this);
} 
if(node.getFeatureCall() != null)//1
{ 
fwd = node.getPostfixExpressionTailBegin();
node.getFeatureCall().apply(this);
} 
outAPostfixExpressionTail(node);
} 
public void caseAIfExpression(AIfExpression node)
    { 
boolean test = false;
boolean ret = false;
inAIfExpression(node);
if(node.getTIf() != null)//1
{ 
node.getTIf().apply(this);
} 
if(node.getIfBranch() != null)//1
{ 
node.getIfBranch().apply(this);
test = asBoolean(val, node.getIfBranch());
val = null;
} 
if(node.getTThen() != null)//1
{ 
node.getTThen().apply(this);
} 
if(node.getThenBranch() != null)//1
{ 
node.getThenBranch().apply(this);
if(test)//1
{ 
ret = asBoolean(val, node.getThenBranch());
val = null;
} 
} 
if(node.getTElse() != null)//1
{ 
node.getTElse().apply(this);
} 
if(node.getElseBranch() != null)//1
{ 
node.getElseBranch().apply(this);
if(!test)//1
{ 
ret = asBoolean(val, node.getThenBranch());
val = null;
} 
} 
if(node.getEndif() != null)//1
{ 
node.getEndif().apply(this);
} 
val = ret;
outAIfExpression(node);
} 
public EvaluateExpression(Map<String, Object> variableTable,
                              ModelInterpreter modelInterpreter)
    { 
reset(variableTable, modelInterpreter);
} 
public void caseAMultiplicativeExpressionTail(
        AMultiplicativeExpressionTail node)
    { 
Object left = val;
val = null;
inAMultiplicativeExpressionTail(node);
if(node.getMultiplyOperator() != null)//1
{ 
node.getMultiplyOperator().apply(this);
} 
if(node.getUnaryExpression() != null)//1
{ 
node.getUnaryExpression().apply(this);
} 
Object op = node.getMultiplyOperator();
Object right = val;
val = null;
if(left != null && op != null && right != null)//1
{ 
if(op instanceof ADivMultiplyOperator)//1
{ 
val = asInteger(left, node) / asInteger(right, node);
} 
else
if(op instanceof AMultMultiplyOperator)//1
{ 
val = asInteger(left, node) * asInteger(right, node);
} 
else
{ 
error(node);
} 
} 
else
{ 
error(node);
} 
outAMultiplicativeExpressionTail(node);
} 
@Override
    public void outAEmptyFeatureCallParameters(AEmptyFeatureCallParameters node)
    { 
val = new ArrayList();
defaultOut(node);
} 
public void outABooleanLiteral(ABooleanLiteral node)
    { 
val = Boolean.parseBoolean(node.getBool().getText());
defaultOut(node);
} 
private Object saveState()
    { 
return new Object[] {vt, val, fwd};
} 
@Override
    public void caseAActualParameterList(AActualParameterList node)
    { 
List list = new ArrayList();
inAActualParameterList(node);
if(node.getExpression() != null)//1
{ 
val = null;
node.getExpression().apply(this);
list.add(val);
} 
{ 
Object temp[] = node.getActualParameterListTail().toArray();
for (int i = 0; i < temp.length; i++) //1
{ 
val = null;
((PActualParameterListTail) temp[i]).apply(this);
list.add(val);
} 
} 
val = list;
outAActualParameterList(node);
} 
private void errorNotType(Object node, String type, Object dft)
    { 
LOG.error("OCL does not evaluate to a " + type + " expression!! Exp: "
                  + node + " Val: " + val);
val = dft;
throw new RuntimeException();
} 
@Override
    public void outAIterateDeclarator(AIterateDeclarator node)
    { 
val = new ArrayList<String>();
defaultOut(node);
} 
private void error(Object node)
    { 
LOG.error("Unknown error processing OCL exp!! Exp: " + node + " Val: "
                  + val);
val = null;
throw new RuntimeException();
} 
@Override
    public void caseALetExpression(ALetExpression node)
    { 
Object name = null;
Object value = null;
inALetExpression(node);
if(node.getTLet() != null)//1
{ 
node.getTLet().apply(this);
} 
if(node.getName() != null)//1
{ 
node.getName().apply(this);
name = node.getName().toString().trim();
} 
if(node.getLetExpressionTypeDeclaration() != null)//1
{ 
node.getLetExpressionTypeDeclaration().apply(this);
} 
if(node.getEqual() != null)//1
{ 
node.getEqual().apply(this);
} 
if(node.getExpression() != null)//1
{ 
node.getExpression().apply(this);
value = val;
} 
if(node.getTIn() != null)//1
{ 
node.getTIn().apply(this);
} 
vt.put(("" + name).trim(), value);
val = null;
outALetExpression(node);
} 
private Object runFeatureCall(Object subject, Object feature, Object type,
                                  List parameters)
    { 
if(parameters == null)//1
{ 
parameters = new ArrayList<Object>();
} 
if((subject instanceof Collection)
                && type.toString().trim().equals("."))//1
{ 
Collection col = (Collection) subject;
Bag res = new HashBag();
for (Object obj : col) //1
{ 
res.add(interp.invokeFeature(vt, obj,
                                             feature.toString().trim(), ".", parameters.toArray()));
} 
return res;
} 
else
{ 
return interp.invokeFeature(vt, subject, feature.toString().trim(),
                                        type.toString().trim(), parameters.toArray());
} 
} 
public Object getValue()
    { 
return val;
} 
@SuppressWarnings("unchecked")

    public void caseALiteralCollection(ALiteralCollection node)
    { 
Collection<Object> col = null;
inALiteralCollection(node);
if(node.getCollectionKind() != null)//1
{ 
node.getCollectionKind().apply(this);
String kind = node.getCollectionKind().toString().trim();
if(kind.equalsIgnoreCase("Set"))//1
{ 
col = new HashSet<Object>();
} 
else
if(kind.equalsIgnoreCase("Sequence"))//1
{ 
col = new ArrayList<Object>();
} 
else
if(kind.equalsIgnoreCase("Bag"))//1
{ 
col = new HashBag<Object>();
} 
} 
if(node.getLBrace() != null)//1
{ 
node.getLBrace().apply(this);
} 
if(node.getExpressionListOrRange() != null)//1
{ 
val = null;
node.getExpressionListOrRange().apply(this);
col.addAll((Collection<Object>) val);
} 
if(node.getRBrace() != null)//1
{ 
node.getRBrace().apply(this);
} 
val = col;
outALiteralCollection(node);
} 
@Override
    public void caseAExpressionListOrRange(AExpressionListOrRange node)
    { 
List ret = new ArrayList();
inAExpressionListOrRange(node);
if(node.getExpression() != null)//1
{ 
val = null;
node.getExpression().apply(this);
ret.add(val);
} 
if(node.getExpressionListOrRangeTail() != null)//1
{ 
val = null;
node.getExpressionListOrRangeTail().apply(this);
ret.addAll((Collection) val);
} 
val = ret;
outAExpressionListOrRange(node);
} 
public EvaluateExpression(Object modelElement, ModelInterpreter mi)
    { 
reset(modelElement, mi);
} 
@Override
    public void caseAFeaturePrimaryExpression(AFeaturePrimaryExpression node)
    { 
Object subject = val;
Object feature = null;
List parameters = null;
inAFeaturePrimaryExpression(node);
if(node.getPathName() != null)//1
{ 
node.getPathName().apply(this);
feature = node.getPathName().toString().trim();
} 
if(node.getTimeExpression() != null)//1
{ 
node.getTimeExpression().apply(this);
} 
if(node.getQualifiers() != null)//1
{ 
node.getQualifiers().apply(this);
} 
if(node.getFeatureCallParameters() != null)//1
{ 
val = null;
node.getFeatureCallParameters().apply(this);
parameters = (List) val;
} 
if(subject == null)//1
{ 
val = vt.get(feature);
if(val == null)//1
{ 
val = this.interp.getBuiltInSymbol(feature.toString().trim());
} 
} 
else
{ 
val = runFeatureCall(subject, feature, fwd, parameters);
} 
outAFeaturePrimaryExpression(node);
} 
public void outAEnumLiteral(AEnumLiteral node)
    { 
val = new OclEnumLiteral(node.getName().toString().trim());
defaultOut(node);
} 
@Override
    public void caseAListExpressionListOrRangeTail(
        AListExpressionListOrRangeTail node)
    { 
inAListExpressionListOrRangeTail(node);
{ 
List ret = new ArrayList();
Object temp[] = node.getExpressionListTail().toArray();
for (int i = 0; i < temp.length; i++) //1
{ 
val = null;
((PExpressionListTail) temp[i]).apply(this);
ret.add(val);
} 
val = ret;
} 
outAListExpressionListOrRangeTail(node);
} 
public void caseARelationalExpressionTail(ARelationalExpressionTail node)
    { 
Object left = val;
val = null;
inARelationalExpressionTail(node);
if(node.getRelationalOperator() != null)//1
{ 
node.getRelationalOperator().apply(this);
} 
if(node.getAdditiveExpression() != null)//1
{ 
node.getAdditiveExpression().apply(this);
} 
Object op = node.getRelationalOperator();
Object right = val;
val = null;
if(left != null && op != null && right != null)//1
{ 
if(op instanceof AEqualRelationalOperator)//1
{ 
val = left.equals(right);
} 
else
if(op instanceof AGteqRelationalOperator)//1
{ 
val = asInteger(left, node) >= asInteger(right, node);
} 
else
if(op instanceof AGtRelationalOperator)//1
{ 
val = asInteger(left, node) > asInteger(right, node);
} 
else
if(op instanceof ALteqRelationalOperator)//1
{ 
val = asInteger(left, node) <= asInteger(right, node);
} 
else
if(op instanceof ALtRelationalOperator)//1
{ 
val = asInteger(left, node) < asInteger(right, node);
} 
else
if(op instanceof ANEqualRelationalOperator)//1
{ 
val = !left.equals(right);
} 
else
{ 
error(node);
} 
} 
else
{ 
if(op instanceof AEqualRelationalOperator)//1
{ 
val = (left == right);
} 
else
if(op instanceof ANEqualRelationalOperator)//1
{ 
val = (left != right);
} 
else
{ 
error(node);
val = null;
} 
} 
outARelationalExpressionTail(node);
} 
public void outARealLiteral(ARealLiteral node)
    { 
val = (int) Double.parseDouble(node.getReal().getText());
defaultOut(node);
} 
public void outAIntegerLiteral(AIntegerLiteral node)
    { 
val = Integer.parseInt(node.getInt().getText());
defaultOut(node);
} 
public void reset(Object element, ModelInterpreter mi)
    { 
vt = new HashMap<String, Object>();
vt.put("self", element);
reset(vt, mi);
} 
public void outAStringLiteral(AStringLiteral node)
    { 
String text = node.getStringLit().getText();
val = text.substring(1, text.length() - 1);
defaultOut(node);
} 
@Override
    public void caseAStandardDeclarator(AStandardDeclarator node)
    { 
inAStandardDeclarator(node);
List<String> vars = new ArrayList<String>();
if(node.getName() != null)//1
{ 
node.getName().apply(this);
vars.add(node.getName().toString().trim());
} 
{ 
Object temp[] = node.getDeclaratorTail().toArray();
for (int i = 0; i < temp.length; i++) //1
{ 
((PDeclaratorTail) temp[i]).apply(this);
vars.add(((ADeclaratorTail) temp[i]).getName()
                         .toString().trim());
} 
val = vars;
} 
if(node.getDeclaratorTypeDeclaration() != null)//1
{ 
node.getDeclaratorTypeDeclaration().apply(this);
} 
if(node.getBar() != null)//1
{ 
node.getBar().apply(this);
} 
outAStandardDeclarator(node);
} 
public void caseALogicalExpressionTail(ALogicalExpressionTail node)
    { 
Object left = val;
val = null;
inALogicalExpressionTail(node);
if(node.getLogicalOperator() != null)//1
{ 
node.getLogicalOperator().apply(this);
} 
if(node.getRelationalExpression() != null)//1
{ 
node.getRelationalExpression().apply(this);
} 
Object op = node.getLogicalOperator();
Object right = val;
val = null;
if(op != null)//1
{ 
if(op instanceof AAndLogicalOperator)//1
{ 
if(left != null && left instanceof Boolean && ((Boolean)left).booleanValue() == false)//1
{ 
val = false;
} 
else
if(right != null && right instanceof Boolean && ((Boolean)right).booleanValue() == false)//1
{ 
val = false;
} 
else
{ 
val = asBoolean(left, node) && asBoolean(right, node);
} 
} 
else
if(op instanceof AImpliesLogicalOperator)//1
{ 
val = !asBoolean(left, node) || asBoolean(right, node);
} 
else
if(op instanceof AOrLogicalOperator)//1
{ 
if(left != null && left instanceof Boolean && ((Boolean)left).booleanValue() == true)//1
{ 
val = true;
} 
else
if(right != null && right instanceof Boolean && ((Boolean)right).booleanValue() == true)//1
{ 
val = true;
} 
else
{ 
val = asBoolean(left, node) || asBoolean(right, node);
} 
} 
else
if(op instanceof AXorLogicalOperator)//1
{ 
val = !asBoolean(left, node) ^ asBoolean(right, node);
} 
else
{ 
error(node);
} 
} 
else
{ 
error(node);
} 
outALogicalExpressionTail(node);
} 
public void caseAUnaryUnaryExpression(AUnaryUnaryExpression node)
    { 
inAUnaryUnaryExpression(node);
if(node.getUnaryOperator() != null)//1
{ 
node.getUnaryOperator().apply(this);
} 
if(node.getPostfixExpression() != null)//1
{ 
val = null;
node.getPostfixExpression().apply(this);
} 
Object op = node.getUnaryOperator();
if(op instanceof AMinusUnaryOperator)//1
{ 
val = -asInteger(val, node);
} 
else
if(op instanceof ANotUnaryOperator)//1
{ 
val = !asBoolean(val, node);
} 
outAUnaryUnaryExpression(node);
} 
@SuppressWarnings("unchecked")

    private void loadState(Object state)
    { 
Object[] stateArr = (Object[]) state;
this.vt = (Map<String, Object>) stateArr[0];
this.val = stateArr[1];
this.fwd = stateArr[2];
} 
private int asInteger(Object value, Object node)
    { 
if(value instanceof Integer)//1
{ 
return (Integer) value;
} 
else
{ 
errorNotType(node, "integer", 0);
return 0;
} 
} 

 } 
