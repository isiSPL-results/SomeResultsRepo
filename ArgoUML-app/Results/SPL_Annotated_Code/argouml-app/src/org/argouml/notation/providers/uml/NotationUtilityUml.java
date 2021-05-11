// Compilation Unit of /NotationUtilityUml.java 
 
package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.kernel.ProjectSettings;
import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
import org.argouml.uml.StereotypeUtility;
import org.argouml.util.CustomSeparator;
import org.argouml.util.MyTokenizer;
public final class NotationUtilityUml  { 
static PropertySpecialString[] attributeSpecialStrings;
static List<CustomSeparator> attributeCustomSep;
static PropertySpecialString[] operationSpecialStrings;
static final List<CustomSeparator> operationCustomSep;
private static final List<CustomSeparator> parameterCustomSep;
static final String VISIBILITYCHARS = "+#-~";
static
    {
        attributeSpecialStrings = new PropertySpecialString[2];

        attributeCustomSep = new ArrayList<CustomSeparator>();
        attributeCustomSep.add(MyTokenizer.SINGLE_QUOTED_SEPARATOR);
        attributeCustomSep.add(MyTokenizer.DOUBLE_QUOTED_SEPARATOR);
        attributeCustomSep.add(MyTokenizer.PAREN_EXPR_STRING_SEPARATOR);

        operationSpecialStrings = new PropertySpecialString[8];

        operationCustomSep = new ArrayList<CustomSeparator>();
        operationCustomSep.add(MyTokenizer.SINGLE_QUOTED_SEPARATOR);
        operationCustomSep.add(MyTokenizer.DOUBLE_QUOTED_SEPARATOR);
        operationCustomSep.add(MyTokenizer.PAREN_EXPR_STRING_SEPARATOR);

        parameterCustomSep = new ArrayList<CustomSeparator>();
        parameterCustomSep.add(MyTokenizer.SINGLE_QUOTED_SEPARATOR);
        parameterCustomSep.add(MyTokenizer.DOUBLE_QUOTED_SEPARATOR);
        parameterCustomSep.add(MyTokenizer.PAREN_EXPR_STRING_SEPARATOR);
    }
public static String generateMultiplicity(Object element,
            boolean showSingularMultiplicity)
    { 
Object multiplicity;
if(Model.getFacade().isAMultiplicity(element))//1
{ 
multiplicity = element;
} 
else
if(Model.getFacade().isAUMLElement(element))//1
{ 
multiplicity = Model.getFacade().getMultiplicity(element);
} 
else
{ 
throw new IllegalArgumentException();
} 


if(multiplicity != null)//1
{ 
int upper = Model.getFacade().getUpper(multiplicity);
int lower = Model.getFacade().getLower(multiplicity);
if(lower != 1 || upper != 1 || showSingularMultiplicity)//1
{ 
return Model.getFacade().toString(multiplicity);
} 

} 

return "";
} 

public NotationUtilityUml() { 
} 

public static String generateVisibility2(Object o)
    { 
if(o == null)//1
{ 
return "";
} 

if(Model.getFacade().isAModelElement(o))//1
{ 
if(Model.getFacade().isPublic(o))//1
{ 
return "+";
} 

if(Model.getFacade().isPrivate(o))//1
{ 
return "-";
} 

if(Model.getFacade().isProtected(o))//1
{ 
return "#";
} 

if(Model.getFacade().isPackage(o))//1
{ 
return "~";
} 

} 

if(Model.getFacade().isAVisibilityKind(o))//1
{ 
if(Model.getVisibilityKind().getPublic().equals(o))//1
{ 
return "+";
} 

if(Model.getVisibilityKind().getPrivate().equals(o))//1
{ 
return "-";
} 

if(Model.getVisibilityKind().getProtected().equals(o))//1
{ 
return "#";
} 

if(Model.getVisibilityKind().getPackage().equals(o))//1
{ 
return "~";
} 

} 

return "";
} 

@Deprecated
    public static String formatSingleStereotype(String name, Map args)
    { 
if(name == null || name.length() == 0)//1
{ 
return "";
} 

Boolean useGuillemets = null;
if(args != null)//1
{ 
useGuillemets = (Boolean) args.get("useGuillemets");
if(useGuillemets == null)//1
{ 
String left = (String) args.get("leftGuillemot");
if(left != null)//1
{ 
useGuillemets = left.equals("\u00ab");
} 

} 

} 

if(useGuillemets == null)//1
{ 
useGuillemets = false;
} 

return formatStereotype(name, useGuillemets);
} 

static String generateParameter(Object parameter)
    { 
StringBuffer s = new StringBuffer();
s.append(generateKind(Model.getFacade().getKind(parameter)));
if(s.length() > 0)//1
{ 
s.append(" ");
} 

s.append(Model.getFacade().getName(parameter));
String classRef =
            generateClassifierRef(Model.getFacade().getType(parameter));
if(classRef.length() > 0)//1
{ 
s.append(" : ");
s.append(classRef);
} 

String defaultValue =
            generateExpression(Model.getFacade().getDefaultValue(parameter));
if(defaultValue.length() > 0)//1
{ 
s.append(" = ");
s.append(defaultValue);
} 

return s.toString();
} 

@Deprecated
    protected static String generateVisibility(Object modelElement, Map args)
    { 
if(isValue("visibilityVisible", args))//1
{ 
String s = NotationUtilityUml.generateVisibility2(modelElement);
if(s.length() > 0)//1
{ 
s = s + " ";
} 

return s;
} 
else
{ 
return "";
} 

} 

public void init()
    { 
int assPos = 0;
attributeSpecialStrings[assPos++] =
            new PropertySpecialString("frozen",
        new PropertyOperation() {
            public void found(Object element, String value) {
                if (Model.getFacade().isAStructuralFeature(element)) {
                    if (value == null) {
                        /* the text was: {frozen} */
                        Model.getCoreHelper().setReadOnly(element, true);
                    } else if ("false".equalsIgnoreCase(value)) {
                        /* the text was: {frozen = false} */
                        Model.getCoreHelper().setReadOnly(element, false);
                    } else if ("true".equalsIgnoreCase(value)) {
                        /* the text was: {frozen = true} */
                        Model.getCoreHelper().setReadOnly(element, true);
                    }
                }
            }
        });
attributeSpecialStrings[assPos++] =
            new PropertySpecialString("addonly",
        new PropertyOperation() {
            public void found(Object element, String value) {
                if (Model.getFacade().isAStructuralFeature(element)) {
                    if ("false".equalsIgnoreCase(value)) {
                        Model.getCoreHelper().setReadOnly(element, true);
                    } else {
                        Model.getCoreHelper().setChangeability(element,
                                                               Model.getChangeableKind().getAddOnly());
                    }
                }
            }
        });
assert assPos == attributeSpecialStrings.length;
operationSpecialStrings = new PropertySpecialString[8];
int ossPos = 0;
operationSpecialStrings[ossPos++] =
            new PropertySpecialString("sequential",
        new PropertyOperation() {
            public void found(Object element, String value) {
                if (Model.getFacade().isAOperation(element)) {
                    Model.getCoreHelper().setConcurrency(element,
                                                         Model.getConcurrencyKind().getSequential());
                }
            }
        });
operationSpecialStrings[ossPos++] =
            new PropertySpecialString("guarded",
        new PropertyOperation() {
            public void found(Object element, String value) {
                Object kind = Model.getConcurrencyKind().getGuarded();
                if (value != null && value.equalsIgnoreCase("false")) {
                    kind = Model.getConcurrencyKind().getSequential();
                }
                if (Model.getFacade().isAOperation(element)) {
                    Model.getCoreHelper().setConcurrency(element, kind);
                }
            }
        });
operationSpecialStrings[ossPos++] =
            new PropertySpecialString("concurrent",
        new PropertyOperation() {
            public void found(Object element, String value) {
                Object kind =
                    Model.getConcurrencyKind().getConcurrent();
                if (value != null && value.equalsIgnoreCase("false")) {
                    kind = Model.getConcurrencyKind().getSequential();
                }
                if (Model.getFacade().isAOperation(element)) {
                    Model.getCoreHelper().setConcurrency(element, kind);
                }
            }
        });
operationSpecialStrings[ossPos++] =
            new PropertySpecialString("concurrency",
        new PropertyOperation() {
            public void found(Object element, String value) {
                Object kind =
                    Model.getConcurrencyKind().getSequential();
                if ("guarded".equalsIgnoreCase(value)) {
                    kind = Model.getConcurrencyKind().getGuarded();
                } else if ("concurrent".equalsIgnoreCase(value)) {
                    kind = Model.getConcurrencyKind().getConcurrent();
                }
                if (Model.getFacade().isAOperation(element)) {
                    Model.getCoreHelper().setConcurrency(element, kind);
                }
            }
        });
operationSpecialStrings[ossPos++] =
            new PropertySpecialString("abstract",
        new PropertyOperation() {
            public void found(Object element, String value) {
                boolean isAbstract = true;
                if (value != null && value.equalsIgnoreCase("false")) {
                    isAbstract = false;
                }
                if (Model.getFacade().isAOperation(element)) {
                    Model.getCoreHelper().setAbstract(
                        element,
                        isAbstract);
                }
            }
        });
operationSpecialStrings[ossPos++] =
            new PropertySpecialString("leaf",
        new PropertyOperation() {
            public void found(Object element, String value) {
                boolean isLeaf = true;
                if (value != null && value.equalsIgnoreCase("false")) {
                    isLeaf = false;
                }
                if (Model.getFacade().isAOperation(element)) {
                    Model.getCoreHelper().setLeaf(element, isLeaf);
                }
            }
        });
operationSpecialStrings[ossPos++] =
            new PropertySpecialString("query",
        new PropertyOperation() {
            public void found(Object element, String value) {
                boolean isQuery = true;
                if (value != null && value.equalsIgnoreCase("false")) {
                    isQuery = false;
                }
                if (Model.getFacade().isABehavioralFeature(element)) {
                    Model.getCoreHelper().setQuery(element, isQuery);
                }
            }
        });
operationSpecialStrings[ossPos++] =
            new PropertySpecialString("root",
        new PropertyOperation() {
            public void found(Object element, String value) {
                boolean isRoot = true;
                if (value != null && value.equalsIgnoreCase("false")) {
                    isRoot = false;
                }
                if (Model.getFacade().isAOperation(element)) {
                    Model.getCoreHelper().setRoot(element, isRoot);
                }
            }
        });
assert ossPos == operationSpecialStrings.length;
} 

public static String generateStereotype(Object st, boolean useGuillemets)
    { 
if(st == null)//1
{ 
return "";
} 

if(st instanceof String)//1
{ 
return formatStereotype((String) st, useGuillemets);
} 

if(Model.getFacade().isAStereotype(st))//1
{ 
return formatStereotype(Model.getFacade().getName(st),
                                    useGuillemets);
} 

if(Model.getFacade().isAModelElement(st))//1
{ 
st = Model.getFacade().getStereotypes(st);
} 

if(st instanceof Collection)//1
{ 
String result = null;
boolean found = false;
for (Object stereotype : (Collection) st) //1
{ 
String name =  Model.getFacade().getName(stereotype);
if(!found)//1
{ 
result = name;
found = true;
} 
else
{ 
result = Translator.localize("misc.stereo.concatenate",
                                                 new Object[] {result, name});
} 

} 

if(found)//1
{ 
return formatStereotype(result, useGuillemets);
} 

} 

return "";
} 

@Deprecated
    public static String generateStereotype(Object st, Map args)
    { 
if(st == null)//1
{ 
return "";
} 

if(st instanceof String)//1
{ 
return formatSingleStereotype((String) st, args);
} 

if(Model.getFacade().isAStereotype(st))//1
{ 
return formatSingleStereotype(Model.getFacade().getName(st), args);
} 

if(Model.getFacade().isAModelElement(st))//1
{ 
st = Model.getFacade().getStereotypes(st);
} 

if(st instanceof Collection)//1
{ 
Object o;
StringBuffer sb = new StringBuffer(10);
boolean first = true;
Iterator iter = ((Collection) st).iterator();
while (iter.hasNext()) //1
{ 
if(!first)//1
{ 
sb.append(',');
} 

o = iter.next();
if(o != null)//1
{ 
sb.append(Model.getFacade().getName(o));
first = false;
} 

} 

if(!first)//1
{ 
return formatSingleStereotype(sb.toString(), args);
} 

} 

return "";
} 

public static String formatStereotype(String name, boolean useGuillemets)
    { 
if(name == null || name.length() == 0)//1
{ 
return "";
} 

String key = "misc.stereo.guillemets."
                     + Boolean.toString(useGuillemets);
return Translator.localize(key, new Object[] {name});
} 

static Object getType(String name, Object defaultSpace)
    { 
Object type = null;
Project p = ProjectManager.getManager().getCurrentProject();
type = p.findType(name, false);
if(type == null)//1
{ 
type = Model.getCoreFactory().buildClass(name,
                    defaultSpace);
} 

return type;
} 

static String generateAction(Object umlAction)
    { 
Collection c;
Iterator it;
String s;
StringBuilder p;
boolean first;
if(umlAction == null)//1
{ 
return "";
} 

Object script = Model.getFacade().getScript(umlAction);
if((script != null) && (Model.getFacade().getBody(script) != null))//1
{ 
s = Model.getFacade().getBody(script).toString();
} 
else
{ 
s = "";
} 

p = new StringBuilder();
c = Model.getFacade().getActualArguments(umlAction);
if(c != null)//1
{ 
it = c.iterator();
first = true;
while (it.hasNext()) //1
{ 
Object arg = it.next();
if(!first)//1
{ 
p.append(", ");
} 

if(Model.getFacade().getValue(arg) != null)//1
{ 
p.append(generateExpression(
                                 Model.getFacade().getValue(arg)));
} 

first = false;
} 

} 

if(s.length() == 0 && p.length() == 0)//1
{ 
return "";
} 

if(p.length() == 0)//1
{ 
return s;
} 

return s + " (" + p + ")";
} 

protected static void parseModelElement(Object me, String text)
    throws ParseException
    { 
MyTokenizer st;
List<String> path = null;
String name = null;
StringBuilder stereotype = null;
String token;
try //1
{ 
st = new MyTokenizer(text, "<<,\u00AB,\u00BB,>>,::");
while (st.hasMoreTokens()) //1
{ 
token = st.nextToken();
if("<<".equals(token) || "\u00AB".equals(token))//1
{ 
if(stereotype != null)//1
{ 
String msg =
                            "parsing.error.model-element-name.twin-stereotypes";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 

stereotype = new StringBuilder();
while (true) //1
{ 
token = st.nextToken();
if(">>".equals(token) || "\u00BB".equals(token))//1
{ 
break;

} 

stereotype.append(token);
} 

} 
else
if("::".equals(token))//1
{ 
if(name != null)//1
{ 
name = name.trim();
} 

if(path != null && (name == null || "".equals(name)))//1
{ 
String msg =
                            "parsing.error.model-element-name.anon-qualifiers";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 

if(path == null)//1
{ 
path = new ArrayList<String>();
} 

if(name != null)//2
{ 
path.add(name);
} 

name = null;
} 
else
{ 
if(name != null)//1
{ 
String msg =
                            "parsing.error.model-element-name.twin-names";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 

name = token;
} 


} 

} 
catch (NoSuchElementException nsee) //1
{ 
String msg =
                "parsing.error.model-element-name.unexpected-name-element";
throw new ParseException(Translator.localize(msg),
                                     text.length());
} 

catch (ParseException pre) //1
{ 
throw pre;
} 


if(name != null)//1
{ 
name = name.trim();
} 

if(path != null && (name == null || "".equals(name)))//1
{ 
String msg = "parsing.error.model-element-name.must-end-with-name";
throw new ParseException(Translator.localize(msg), 0);
} 

if(name != null && name.startsWith("+"))//1
{ 
name = name.substring(1).trim();
Model.getCoreHelper().setVisibility(me,
                                                Model.getVisibilityKind().getPublic());
} 

if(name != null && name.startsWith("-"))//1
{ 
name = name.substring(1).trim();
Model.getCoreHelper().setVisibility(me,
                                                Model.getVisibilityKind().getPrivate());
} 

if(name != null && name.startsWith("#"))//1
{ 
name = name.substring(1).trim();
Model.getCoreHelper().setVisibility(me,
                                                Model.getVisibilityKind().getProtected());
} 

if(name != null && name.startsWith("~"))//1
{ 
name = name.substring(1).trim();
Model.getCoreHelper().setVisibility(me,
                                                Model.getVisibilityKind().getPackage());
} 

if(name != null)//2
{ 
Model.getCoreHelper().setName(me, name);
} 

StereotypeUtility.dealWithStereotypes(me, stereotype, false);
if(path != null)//1
{ 
Object nspe =
                Model.getModelManagementHelper().getElement(
                    path,
                    Model.getFacade().getRoot(me));
if(nspe == null || !(Model.getFacade().isANamespace(nspe)))//1
{ 
String msg =
                    "parsing.error.model-element-name.namespace-unresolved";
throw new ParseException(Translator.localize(msg),
                                         0);
} 

Object model =
                ProjectManager.getManager().getCurrentProject().getRoot();
if(!Model.getCoreHelper().getAllPossibleNamespaces(me, model)
                    .contains(nspe))//1
{ 
String msg =
                    "parsing.error.model-element-name.namespace-invalid";
throw new ParseException(Translator.localize(msg),
                                         0);
} 

Model.getCoreHelper().addOwnedElement(nspe, me);
} 

} 

public static String generateActionSequence(Object a)
    { 
if(Model.getFacade().isAActionSequence(a))//1
{ 
StringBuffer str = new StringBuffer("");
Collection actions = Model.getFacade().getActions(a);
Iterator i = actions.iterator();
if(i.hasNext())//1
{ 
str.append(generateAction(i.next()));
} 

while (i.hasNext()) //1
{ 
str.append("; ");
str.append(generateAction(i.next()));
} 

return str.toString();
} 
else
{ 
return generateAction(a);
} 

} 

static int indexOfNextCheckedSemicolon(String s, int start)
    { 
if(s == null || start < 0 || start >= s.length())//1
{ 
return -1;
} 

int end;
boolean inside = false;
boolean backslashed = false;
char c;
for (end = start; end < s.length(); end++) //1
{ 
c = s.charAt(end);
if(!inside && c == ';')//1
{ 
return end;
} 
else
if(!backslashed && (c == '\'' || c == '\"'))//1
{ 
inside = !inside;
} 


backslashed = (!backslashed && c == '\\');
} 

return end;
} 

public static boolean isValue(final String key, final Map map)
    { 
if(map == null)//1
{ 
return false;
} 

Object o = map.get(key);
if(!(o instanceof Boolean))//1
{ 
return false;
} 

return ((Boolean) o).booleanValue();
} 

private static String generateKind(Object /*Parameter etc.*/ kind)
    { 
StringBuffer s = new StringBuffer();
if(kind == null /* "in" is the default */
                || kind == Model.getDirectionKind().getInParameter())//1
{ 
s.append(/*"in"*/ "");
} 
else
if(kind == Model.getDirectionKind().getInOutParameter())//1
{ 
s.append("inout");
} 
else
if(kind == Model.getDirectionKind().getReturnParameter())//1
{ 
} 
else
if(kind == Model.getDirectionKind().getOutParameter())//1
{ 
s.append("out");
} 




return s.toString();
} 

private static String generateExpression(Object expr)
    { 
if(Model.getFacade().isAExpression(expr))//1
{ 
return generateUninterpreted(
                       (String) Model.getFacade().getBody(expr));
} 
else
if(Model.getFacade().isAConstraint(expr))//1
{ 
return generateExpression(Model.getFacade().getBody(expr));
} 


return "";
} 

static Object getVisibility(String name)
    { 
if("+".equals(name) || "public".equals(name))//1
{ 
return Model.getVisibilityKind().getPublic();
} 
else
if("#".equals(name) || "protected".equals(name))//1
{ 
return Model.getVisibilityKind().getProtected();
} 
else
if("~".equals(name) || "package".equals(name))//1
{ 
return Model.getVisibilityKind().getPackage();
} 
else
{ 
return Model.getVisibilityKind().getPrivate();
} 



} 

private static String generateUninterpreted(String un)
    { 
if(un == null)//1
{ 
return "";
} 

return un;
} 

static void setProperties(Object elem, List<String> prop,
                              PropertySpecialString[] spec)
    { 
String name;
String value;
int i, j;
nextProp://1
for (i = 0; i + 1 < prop.size(); i += 2) //1
{ 
name = prop.get(i);
value = prop.get(i + 1);
if(name == null)//1
{ 
continue;
} 

name = name.trim();
if(value != null)//1
{ 
value = value.trim();
} 

for (j = i + 2; j < prop.size(); j += 2) //1
{ 
String s = prop.get(j);
if(s != null && name.equalsIgnoreCase(s.trim()))//1
{ 
continue nextProp;
} 

} 

if(spec != null)//1
{ 
for (j = 0; j < spec.length; j++) //1
{ 
if(spec[j].invoke(elem, name, value))//1
{ 
continue nextProp;
} 

} 

} 

Model.getCoreHelper().setTaggedValue(elem, name, value);
} 


} 

public static String generateVisibility(Object o)
    { 
if(o == null)//1
{ 
return "";
} 

Project p = ProjectManager.getManager().getCurrentProject();
ProjectSettings ps = p.getProjectSettings();
if(ps.getShowVisibilityValue())//1
{ 
return generateVisibility2(o);
} 
else
{ 
return "";
} 

} 

protected static String generatePath(Object modelElement)
    { 
StringBuilder s = new StringBuilder();
Object p = modelElement;
Stack<String> stack = new Stack<String>();
Object ns = Model.getFacade().getNamespace(p);
while (ns != null && !Model.getFacade().isAModel(ns)) //1
{ 
stack.push(Model.getFacade().getName(ns));
ns = Model.getFacade().getNamespace(ns);
} 

while (!stack.isEmpty()) //1
{ 
s.append(stack.pop() + "::");
} 

if(s.length() > 0 && !(s.lastIndexOf(":") == s.length() - 1))//1
{ 
s.append("::");
} 

return s.toString();
} 

private static void setParamKind(Object parameter, String description)
    { 
Object kind;
if("out".equalsIgnoreCase(description))//1
{ 
kind = Model.getDirectionKind().getOutParameter();
} 
else
if("inout".equalsIgnoreCase(description))//1
{ 
kind = Model.getDirectionKind().getInOutParameter();
} 
else
{ 
kind = Model.getDirectionKind().getInParameter();
} 


Model.getCoreHelper().setKind(parameter, kind);
} 

static String generateTaggedValue(Object tv)
    { 
if(tv == null)//1
{ 
return "";
} 

return Model.getFacade().getTagOfTag(tv)
               + "="
               + generateUninterpreted(Model.getFacade().getValueOfTag(tv));
} 

static void parseParamList(Object op, String param, int paramOffset)
    throws ParseException
    { 
MyTokenizer st =
            new MyTokenizer(param, " ,\t,:,=,\\,", parameterCustomSep);
Collection origParam =
            new ArrayList(Model.getFacade().getParameters(op));
Object ns = Model.getFacade().getRoot(op);
if(Model.getFacade().isAOperation(op))//1
{ 
Object ow = Model.getFacade().getOwner(op);
if(ow != null && Model.getFacade().getNamespace(ow) != null)//1
{ 
ns = Model.getFacade().getNamespace(ow);
} 

} 

Iterator it = origParam.iterator();
while (st.hasMoreTokens()) //1
{ 
String kind = null;
String name = null;
String tok;
String type = null;
StringBuilder value = null;
Object p = null;
boolean hasColon = false;
boolean hasEq = false;
while (it.hasNext() && p == null) //1
{ 
p = it.next();
if(Model.getFacade().isReturn(p))//1
{ 
p = null;
} 

} 

while (st.hasMoreTokens()) //1
{ 
tok = st.nextToken();
if(",".equals(tok))//1
{ 
break;

} 
else
if(" ".equals(tok) || "\t".equals(tok))//1
{ 
if(hasEq)//1
{ 
value.append(tok);
} 

} 
else
if(":".equals(tok))//1
{ 
hasColon = true;
hasEq = false;
} 
else
if("=".equals(tok))//1
{ 
if(value != null)//1
{ 
String msg =
                            "parsing.error.notation-utility.two-default-values";
throw new ParseException(Translator.localize(msg),
                                                 paramOffset + st.getTokenIndex());
} 

hasEq = true;
hasColon = false;
value = new StringBuilder();
} 
else
if(hasColon)//1
{ 
if(type != null)//1
{ 
String msg = "parsing.error.notation-utility.two-types";
throw new ParseException(Translator.localize(msg),
                                                 paramOffset + st.getTokenIndex());
} 

if(tok.charAt(0) == '\'' || tok.charAt(0) == '\"')//1
{ 
String msg =
                            "parsing.error.notation-utility.type-quoted";
throw new ParseException(Translator.localize(msg),
                                                 paramOffset + st.getTokenIndex());
} 

if(tok.charAt(0) == '(')//1
{ 
String msg =
                            "parsing.error.notation-utility.type-expr";
throw new ParseException(Translator.localize(msg),
                                                 paramOffset + st.getTokenIndex());
} 

type = tok;
} 
else
if(hasEq)//1
{ 
value.append(tok);
} 
else
{ 
if(name != null && kind != null)//1
{ 
String msg =
                            "parsing.error.notation-utility.extra-text";
throw new ParseException(Translator.localize(msg),
                                                 paramOffset + st.getTokenIndex());
} 

if(tok.charAt(0) == '\'' || tok.charAt(0) == '\"')//1
{ 
String msg =
                            "parsing.error.notation-utility.name-kind-quoted";
throw new ParseException(
                            Translator.localize(msg),
                            paramOffset + st.getTokenIndex());
} 

if(tok.charAt(0) == '(')//1
{ 
String msg =
                            "parsing.error.notation-utility.name-kind-expr";
throw new ParseException(
                            Translator.localize(msg),
                            paramOffset + st.getTokenIndex());
} 

kind = name;
name = tok;
} 






} 

if(p == null)//1
{ 
Object returnType =
                    ProjectManager.getManager()
                    .getCurrentProject().findType("void");
p = Model.getCoreFactory().buildParameter(
                        op,
                        returnType);
} 

if(name != null)//1
{ 
Model.getCoreHelper().setName(p, name.trim());
} 

if(kind != null)//1
{ 
setParamKind(p, kind.trim());
} 

if(type != null)//1
{ 
Model.getCoreHelper().setType(p, getType(type.trim(), ns));
} 

if(value != null)//1
{ 
Project project =
                    ProjectManager.getManager().getCurrentProject();
ProjectSettings ps = project.getProjectSettings();
String notationLanguage = ps.getNotationLanguage();
Object initExpr =
                    Model.getDataTypesFactory()
                    .createExpression(
                        notationLanguage,
                        value.toString().trim());
Model.getCoreHelper().setDefaultValue(p, initExpr);
} 

} 

while (it.hasNext()) //1
{ 
Object p = it.next();
if(!Model.getFacade().isReturn(p))//1
{ 
Model.getCoreHelper().removeParameter(op, p);
} 

} 

} 

private static String generateClassifierRef(Object cls)
    { 
if(cls == null)//1
{ 
return "";
} 

return Model.getFacade().getName(cls);
} 

public static String generateMultiplicity(Object multiplicityOwner,
            Map args)
    { 
return generateMultiplicity(multiplicityOwner,
                                    NotationProvider.isValue("singularMultiplicityVisible", args));
} 

static class PropertySpecialString  { 
private String name;
private PropertyOperation op;
public PropertySpecialString(String str, PropertyOperation propop)
        { 
name = str;
op = propop;
} 

boolean invoke(Object element, String pname, String value)
        { 
if(!name.equalsIgnoreCase(pname))//1
{ 
return false;
} 

op.found(element, value);
return true;
} 

 } 

interface PropertyOperation  { 
void found(Object element, String value);
 } 

 } 


