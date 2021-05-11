
//#if -1298906792 
// Compilation Unit of /NotationUtilityUml.java 
 

//#if -147813606 
package org.argouml.notation.providers.uml;
//#endif 


//#if -769127321 
import java.text.ParseException;
//#endif 


//#if 180046343 
import java.util.ArrayList;
//#endif 


//#if -1668899782 
import java.util.Collection;
//#endif 


//#if -1257926742 
import java.util.Iterator;
//#endif 


//#if 2089780218 
import java.util.List;
//#endif 


//#if 2007096866 
import java.util.Map;
//#endif 


//#if -1147535747 
import java.util.NoSuchElementException;
//#endif 


//#if 568689078 
import java.util.Stack;
//#endif 


//#if 689851953 
import org.argouml.i18n.Translator;
//#endif 


//#if -830024141 
import org.argouml.kernel.Project;
//#endif 


//#if -161067690 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1299465808 
import org.argouml.kernel.ProjectSettings;
//#endif 


//#if 664263031 
import org.argouml.model.Model;
//#endif 


//#if -1641506756 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 788709851 
import org.argouml.uml.StereotypeUtility;
//#endif 


//#if -1880959981 
import org.argouml.util.CustomSeparator;
//#endif 


//#if -1471836004 
import org.argouml.util.MyTokenizer;
//#endif 


//#if -777002925 
public final class NotationUtilityUml  { 

//#if -821092373 
static PropertySpecialString[] attributeSpecialStrings;
//#endif 


//#if 36321924 
static List<CustomSeparator> attributeCustomSep;
//#endif 


//#if -378690112 
static PropertySpecialString[] operationSpecialStrings;
//#endif 


//#if 78988993 
static final List<CustomSeparator> operationCustomSep;
//#endif 


//#if 476056136 
private static final List<CustomSeparator> parameterCustomSep;
//#endif 


//#if 727816525 
static final String VISIBILITYCHARS = "+#-~";
//#endif 


//#if -1215664614 
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
//#endif 


//#if -158308907 
public static String generateMultiplicity(Object element,
            boolean showSingularMultiplicity)
    { 

//#if 1231873716 
Object multiplicity;
//#endif 


//#if -92397589 
if(Model.getFacade().isAMultiplicity(element))//1
{ 

//#if -742377143 
multiplicity = element;
//#endif 

} 
else

//#if -1264309632 
if(Model.getFacade().isAUMLElement(element))//1
{ 

//#if -767962039 
multiplicity = Model.getFacade().getMultiplicity(element);
//#endif 

} 
else
{ 

//#if 496281351 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#endif 


//#if -647479604 
if(multiplicity != null)//1
{ 

//#if 440059649 
int upper = Model.getFacade().getUpper(multiplicity);
//#endif 


//#if -411077023 
int lower = Model.getFacade().getLower(multiplicity);
//#endif 


//#if -1191348147 
if(lower != 1 || upper != 1 || showSingularMultiplicity)//1
{ 

//#if -504860050 
return Model.getFacade().toString(multiplicity);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1445477726 
return "";
//#endif 

} 

//#endif 


//#if 2016621128 
public NotationUtilityUml() { 
} 

//#endif 


//#if 1553922162 
public static String generateVisibility2(Object o)
    { 

//#if -626703063 
if(o == null)//1
{ 

//#if 1371833776 
return "";
//#endif 

} 

//#endif 


//#if 1917609495 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if -108814203 
if(Model.getFacade().isPublic(o))//1
{ 

//#if -771464427 
return "+";
//#endif 

} 

//#endif 


//#if 883914531 
if(Model.getFacade().isPrivate(o))//1
{ 

//#if -281563304 
return "-";
//#endif 

} 

//#endif 


//#if -527008872 
if(Model.getFacade().isProtected(o))//1
{ 

//#if 209237886 
return "#";
//#endif 

} 

//#endif 


//#if 1116002048 
if(Model.getFacade().isPackage(o))//1
{ 

//#if 543909792 
return "~";
//#endif 

} 

//#endif 

} 

//#endif 


//#if -398149500 
if(Model.getFacade().isAVisibilityKind(o))//1
{ 

//#if 888524805 
if(Model.getVisibilityKind().getPublic().equals(o))//1
{ 

//#if 1138469340 
return "+";
//#endif 

} 

//#endif 


//#if -326887773 
if(Model.getVisibilityKind().getPrivate().equals(o))//1
{ 

//#if -999214738 
return "-";
//#endif 

} 

//#endif 


//#if 1196344910 
if(Model.getVisibilityKind().getProtected().equals(o))//1
{ 

//#if 135915402 
return "#";
//#endif 

} 

//#endif 


//#if -1028636826 
if(Model.getVisibilityKind().getPackage().equals(o))//1
{ 

//#if 197167492 
return "~";
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1312076597 
return "";
//#endif 

} 

//#endif 


//#if 1174835568 
@Deprecated
    public static String formatSingleStereotype(String name, Map args)
    { 

//#if 1183605643 
if(name == null || name.length() == 0)//1
{ 

//#if -1757684359 
return "";
//#endif 

} 

//#endif 


//#if 1368929591 
Boolean useGuillemets = null;
//#endif 


//#if 134689491 
if(args != null)//1
{ 

//#if 965298022 
useGuillemets = (Boolean) args.get("useGuillemets");
//#endif 


//#if -2050603163 
if(useGuillemets == null)//1
{ 

//#if -1769988694 
String left = (String) args.get("leftGuillemot");
//#endif 


//#if 385385600 
if(left != null)//1
{ 

//#if -908529288 
useGuillemets = left.equals("\u00ab");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 681696492 
if(useGuillemets == null)//1
{ 

//#if -403800919 
useGuillemets = false;
//#endif 

} 

//#endif 


//#if 1341284584 
return formatStereotype(name, useGuillemets);
//#endif 

} 

//#endif 


//#if -159846426 
static String generateParameter(Object parameter)
    { 

//#if 246184087 
StringBuffer s = new StringBuffer();
//#endif 


//#if -1042145796 
s.append(generateKind(Model.getFacade().getKind(parameter)));
//#endif 


//#if -1489300812 
if(s.length() > 0)//1
{ 

//#if -1682910673 
s.append(" ");
//#endif 

} 

//#endif 


//#if -188083973 
s.append(Model.getFacade().getName(parameter));
//#endif 


//#if 1545445109 
String classRef =
            generateClassifierRef(Model.getFacade().getType(parameter));
//#endif 


//#if -1127837124 
if(classRef.length() > 0)//1
{ 

//#if -230594189 
s.append(" : ");
//#endif 


//#if 2058514646 
s.append(classRef);
//#endif 

} 

//#endif 


//#if 1841199624 
String defaultValue =
            generateExpression(Model.getFacade().getDefaultValue(parameter));
//#endif 


//#if 1315046887 
if(defaultValue.length() > 0)//1
{ 

//#if -139315184 
s.append(" = ");
//#endif 


//#if 1800618315 
s.append(defaultValue);
//#endif 

} 

//#endif 


//#if 1844721424 
return s.toString();
//#endif 

} 

//#endif 


//#if -893217449 
@Deprecated
    protected static String generateVisibility(Object modelElement, Map args)
    { 

//#if 900792253 
if(isValue("visibilityVisible", args))//1
{ 

//#if 1760012838 
String s = NotationUtilityUml.generateVisibility2(modelElement);
//#endif 


//#if -1121478398 
if(s.length() > 0)//1
{ 

//#if 318938481 
s = s + " ";
//#endif 

} 

//#endif 


//#if 1389066781 
return s;
//#endif 

} 
else
{ 

//#if -1225560300 
return "";
//#endif 

} 

//#endif 

} 

//#endif 


//#if -94811358 
public void init()
    { 

//#if 105460560 
int assPos = 0;
//#endif 


//#if -222285114 
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
//#endif 


//#if -7614235 
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
//#endif 


//#if -1051066359 
assert assPos == attributeSpecialStrings.length;
//#endif 


//#if 1697715143 
operationSpecialStrings = new PropertySpecialString[8];
//#endif 


//#if 570901854 
int ossPos = 0;
//#endif 


//#if -1207946822 
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
//#endif 


//#if -1894063412 
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
//#endif 


//#if -691388602 
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
//#endif 


//#if -157260780 
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
//#endif 


//#if -155461076 
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
//#endif 


//#if 720819824 
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
//#endif 


//#if -1027021896 
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
//#endif 


//#if -407762580 
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
//#endif 


//#if 1240708642 
assert ossPos == operationSpecialStrings.length;
//#endif 

} 

//#endif 


//#if -2102554174 
public static String generateStereotype(Object st, boolean useGuillemets)
    { 

//#if 1295067408 
if(st == null)//1
{ 

//#if -370455922 
return "";
//#endif 

} 

//#endif 


//#if 1032587270 
if(st instanceof String)//1
{ 

//#if -1716675817 
return formatStereotype((String) st, useGuillemets);
//#endif 

} 

//#endif 


//#if -1807749073 
if(Model.getFacade().isAStereotype(st))//1
{ 

//#if 1621543979 
return formatStereotype(Model.getFacade().getName(st),
                                    useGuillemets);
//#endif 

} 

//#endif 


//#if 757253712 
if(Model.getFacade().isAModelElement(st))//1
{ 

//#if -1966785900 
st = Model.getFacade().getStereotypes(st);
//#endif 

} 

//#endif 


//#if -959116909 
if(st instanceof Collection)//1
{ 

//#if -1941534777 
String result = null;
//#endif 


//#if 121872217 
boolean found = false;
//#endif 


//#if -1564503404 
for (Object stereotype : (Collection) st) //1
{ 

//#if -2081014886 
String name =  Model.getFacade().getName(stereotype);
//#endif 


//#if 1330635936 
if(!found)//1
{ 

//#if 1410101770 
result = name;
//#endif 


//#if 608832088 
found = true;
//#endif 

} 
else
{ 

//#if 38087463 
result = Translator.localize("misc.stereo.concatenate",
                                                 new Object[] {result, name});
//#endif 

} 

//#endif 

} 

//#endif 


//#if -875976575 
if(found)//1
{ 

//#if 1102121584 
return formatStereotype(result, useGuillemets);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -535801056 
return "";
//#endif 

} 

//#endif 


//#if -537237758 
@Deprecated
    public static String generateStereotype(Object st, Map args)
    { 

//#if -1681053395 
if(st == null)//1
{ 

//#if -359588490 
return "";
//#endif 

} 

//#endif 


//#if -686798877 
if(st instanceof String)//1
{ 

//#if 989801334 
return formatSingleStereotype((String) st, args);
//#endif 

} 

//#endif 


//#if 1272038898 
if(Model.getFacade().isAStereotype(st))//1
{ 

//#if -987725314 
return formatSingleStereotype(Model.getFacade().getName(st), args);
//#endif 

} 

//#endif 


//#if 1201026899 
if(Model.getFacade().isAModelElement(st))//1
{ 

//#if -233906466 
st = Model.getFacade().getStereotypes(st);
//#endif 

} 

//#endif 


//#if -2108943632 
if(st instanceof Collection)//1
{ 

//#if 378736858 
Object o;
//#endif 


//#if 932832726 
StringBuffer sb = new StringBuffer(10);
//#endif 


//#if 831110311 
boolean first = true;
//#endif 


//#if -913542205 
Iterator iter = ((Collection) st).iterator();
//#endif 


//#if 293246342 
while (iter.hasNext()) //1
{ 

//#if -1677761585 
if(!first)//1
{ 

//#if 1116553610 
sb.append(',');
//#endif 

} 

//#endif 


//#if -1022104750 
o = iter.next();
//#endif 


//#if -1369741854 
if(o != null)//1
{ 

//#if -1984678413 
sb.append(Model.getFacade().getName(o));
//#endif 


//#if -1132387148 
first = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 726464499 
if(!first)//1
{ 

//#if 1238240457 
return formatSingleStereotype(sb.toString(), args);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -750654211 
return "";
//#endif 

} 

//#endif 


//#if -1961216772 
public static String formatStereotype(String name, boolean useGuillemets)
    { 

//#if -1334006754 
if(name == null || name.length() == 0)//1
{ 

//#if -874772689 
return "";
//#endif 

} 

//#endif 


//#if 34828224 
String key = "misc.stereo.guillemets."
                     + Boolean.toString(useGuillemets);
//#endif 


//#if -1727850955 
return Translator.localize(key, new Object[] {name});
//#endif 

} 

//#endif 


//#if -597405330 
static Object getType(String name, Object defaultSpace)
    { 

//#if 1891405308 
Object type = null;
//#endif 


//#if 1315624858 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1774752116 
type = p.findType(name, false);
//#endif 


//#if -2126042456 
if(type == null)//1
{ 

//#if 1368505335 
type = Model.getCoreFactory().buildClass(name,
                    defaultSpace);
//#endif 

} 

//#endif 


//#if 263637349 
return type;
//#endif 

} 

//#endif 


//#if 881403272 
static String generateAction(Object umlAction)
    { 

//#if -781888142 
Collection c;
//#endif 


//#if 770315174 
Iterator it;
//#endif 


//#if 758113813 
String s;
//#endif 


//#if -602966535 
StringBuilder p;
//#endif 


//#if -382174409 
boolean first;
//#endif 


//#if 1558644042 
if(umlAction == null)//1
{ 

//#if -532429021 
return "";
//#endif 

} 

//#endif 


//#if 1249803964 
Object script = Model.getFacade().getScript(umlAction);
//#endif 


//#if 465641640 
if((script != null) && (Model.getFacade().getBody(script) != null))//1
{ 

//#if -471467309 
s = Model.getFacade().getBody(script).toString();
//#endif 

} 
else
{ 

//#if 1977687838 
s = "";
//#endif 

} 

//#endif 


//#if -1637118681 
p = new StringBuilder();
//#endif 


//#if -1360310754 
c = Model.getFacade().getActualArguments(umlAction);
//#endif 


//#if 184562655 
if(c != null)//1
{ 

//#if -1698742894 
it = c.iterator();
//#endif 


//#if -617647747 
first = true;
//#endif 


//#if -687089171 
while (it.hasNext()) //1
{ 

//#if 1105577673 
Object arg = it.next();
//#endif 


//#if 36356867 
if(!first)//1
{ 

//#if 9656176 
p.append(", ");
//#endif 

} 

//#endif 


//#if 334994333 
if(Model.getFacade().getValue(arg) != null)//1
{ 

//#if 418281154 
p.append(generateExpression(
                                 Model.getFacade().getValue(arg)));
//#endif 

} 

//#endif 


//#if -1628703676 
first = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1898539468 
if(s.length() == 0 && p.length() == 0)//1
{ 

//#if 850816660 
return "";
//#endif 

} 

//#endif 


//#if 1518312196 
if(p.length() == 0)//1
{ 

//#if -1021179010 
return s;
//#endif 

} 

//#endif 


//#if 1178755374 
return s + " (" + p + ")";
//#endif 

} 

//#endif 


//#if -1714134275 
protected static void parseModelElement(Object me, String text)
    throws ParseException
    { 

//#if 1025969910 
MyTokenizer st;
//#endif 


//#if 940618962 
List<String> path = null;
//#endif 


//#if -163429254 
String name = null;
//#endif 


//#if 221466348 
StringBuilder stereotype = null;
//#endif 


//#if 531314202 
String token;
//#endif 


//#if 1522640189 
try //1
{ 

//#if -356921258 
st = new MyTokenizer(text, "<<,\u00AB,\u00BB,>>,::");
//#endif 


//#if -787349545 
while (st.hasMoreTokens()) //1
{ 

//#if 881142001 
token = st.nextToken();
//#endif 


//#if -1682663837 
if("<<".equals(token) || "\u00AB".equals(token))//1
{ 

//#if -1291862413 
if(stereotype != null)//1
{ 

//#if -1582700422 
String msg =
                            "parsing.error.model-element-name.twin-stereotypes";
//#endif 


//#if 253448620 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 1558071354 
stereotype = new StringBuilder();
//#endif 


//#if -1755119358 
while (true) //1
{ 

//#if 1333275501 
token = st.nextToken();
//#endif 


//#if 106337312 
if(">>".equals(token) || "\u00BB".equals(token))//1
{ 

//#if 940890415 
break;

//#endif 

} 

//#endif 


//#if -933954775 
stereotype.append(token);
//#endif 

} 

//#endif 

} 
else

//#if -562000343 
if("::".equals(token))//1
{ 

//#if -322585801 
if(name != null)//1
{ 

//#if 1179178482 
name = name.trim();
//#endif 

} 

//#endif 


//#if 1718498495 
if(path != null && (name == null || "".equals(name)))//1
{ 

//#if -970441345 
String msg =
                            "parsing.error.model-element-name.anon-qualifiers";
//#endif 


//#if 1080110571 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 1561545653 
if(path == null)//1
{ 

//#if -325151575 
path = new ArrayList<String>();
//#endif 

} 

//#endif 


//#if 1983287322 
if(name != null)//2
{ 

//#if -1870792235 
path.add(name);
//#endif 

} 

//#endif 


//#if 227879244 
name = null;
//#endif 

} 
else
{ 

//#if 437675974 
if(name != null)//1
{ 

//#if -1970221041 
String msg =
                            "parsing.error.model-element-name.twin-names";
//#endif 


//#if 1092953658 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 523043449 
name = token;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#if 441132217 
catch (NoSuchElementException nsee) //1
{ 

//#if 399743301 
String msg =
                "parsing.error.model-element-name.unexpected-name-element";
//#endif 


//#if -882633922 
throw new ParseException(Translator.localize(msg),
                                     text.length());
//#endif 

} 

//#endif 


//#if -822604258 
catch (ParseException pre) //1
{ 

//#if -105288299 
throw pre;
//#endif 

} 

//#endif 


//#endif 


//#if 101993242 
if(name != null)//1
{ 

//#if -889961656 
name = name.trim();
//#endif 

} 

//#endif 


//#if 1507223676 
if(path != null && (name == null || "".equals(name)))//1
{ 

//#if 1005740502 
String msg = "parsing.error.model-element-name.must-end-with-name";
//#endif 


//#if -1306075889 
throw new ParseException(Translator.localize(msg), 0);
//#endif 

} 

//#endif 


//#if 1498402328 
if(name != null && name.startsWith("+"))//1
{ 

//#if -1574830586 
name = name.substring(1).trim();
//#endif 


//#if 1911893703 
Model.getCoreHelper().setVisibility(me,
                                                Model.getVisibilityKind().getPublic());
//#endif 

} 

//#endif 


//#if -1021557606 
if(name != null && name.startsWith("-"))//1
{ 

//#if 1669655510 
name = name.substring(1).trim();
//#endif 


//#if -450201445 
Model.getCoreHelper().setVisibility(me,
                                                Model.getVisibilityKind().getPrivate());
//#endif 

} 

//#endif 


//#if -1306659824 
if(name != null && name.startsWith("#"))//1
{ 

//#if -2145663948 
name = name.substring(1).trim();
//#endif 


//#if 949777128 
Model.getCoreHelper().setVisibility(me,
                                                Model.getVisibilityKind().getProtected());
//#endif 

} 

//#endif 


//#if 2146763819 
if(name != null && name.startsWith("~"))//1
{ 

//#if -1186611566 
name = name.substring(1).trim();
//#endif 


//#if 720296610 
Model.getCoreHelper().setVisibility(me,
                                                Model.getVisibilityKind().getPackage());
//#endif 

} 

//#endif 


//#if 1938870615 
if(name != null)//2
{ 

//#if -548993598 
Model.getCoreHelper().setName(me, name);
//#endif 

} 

//#endif 


//#if -42648901 
StereotypeUtility.dealWithStereotypes(me, stereotype, false);
//#endif 


//#if -1101431756 
if(path != null)//1
{ 

//#if -149630275 
Object nspe =
                Model.getModelManagementHelper().getElement(
                    path,
                    Model.getFacade().getRoot(me));
//#endif 


//#if 1131486496 
if(nspe == null || !(Model.getFacade().isANamespace(nspe)))//1
{ 

//#if 262402254 
String msg =
                    "parsing.error.model-element-name.namespace-unresolved";
//#endif 


//#if -316127874 
throw new ParseException(Translator.localize(msg),
                                         0);
//#endif 

} 

//#endif 


//#if 1418140599 
Object model =
                ProjectManager.getManager().getCurrentProject().getRoot();
//#endif 


//#if -1177228888 
if(!Model.getCoreHelper().getAllPossibleNamespaces(me, model)
                    .contains(nspe))//1
{ 

//#if -1345370013 
String msg =
                    "parsing.error.model-element-name.namespace-invalid";
//#endif 


//#if -1984467851 
throw new ParseException(Translator.localize(msg),
                                         0);
//#endif 

} 

//#endif 


//#if -1422929298 
Model.getCoreHelper().addOwnedElement(nspe, me);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 865175911 
public static String generateActionSequence(Object a)
    { 

//#if -235766848 
if(Model.getFacade().isAActionSequence(a))//1
{ 

//#if -4561636 
StringBuffer str = new StringBuffer("");
//#endif 


//#if -1013107992 
Collection actions = Model.getFacade().getActions(a);
//#endif 


//#if 1900458211 
Iterator i = actions.iterator();
//#endif 


//#if 138006268 
if(i.hasNext())//1
{ 

//#if -254340068 
str.append(generateAction(i.next()));
//#endif 

} 

//#endif 


//#if -401484892 
while (i.hasNext()) //1
{ 

//#if 217344851 
str.append("; ");
//#endif 


//#if 120225805 
str.append(generateAction(i.next()));
//#endif 

} 

//#endif 


//#if -1792676501 
return str.toString();
//#endif 

} 
else
{ 

//#if 1469610336 
return generateAction(a);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1638464061 
static int indexOfNextCheckedSemicolon(String s, int start)
    { 

//#if -644878530 
if(s == null || start < 0 || start >= s.length())//1
{ 

//#if 977592407 
return -1;
//#endif 

} 

//#endif 


//#if -581789611 
int end;
//#endif 


//#if -876459029 
boolean inside = false;
//#endif 


//#if -419328498 
boolean backslashed = false;
//#endif 


//#if -1582110680 
char c;
//#endif 


//#if 1467954207 
for (end = start; end < s.length(); end++) //1
{ 

//#if 546694195 
c = s.charAt(end);
//#endif 


//#if -991831686 
if(!inside && c == ';')//1
{ 

//#if 1820819749 
return end;
//#endif 

} 
else

//#if -1956049119 
if(!backslashed && (c == '\'' || c == '\"'))//1
{ 

//#if 770228278 
inside = !inside;
//#endif 

} 

//#endif 


//#endif 


//#if 1895976113 
backslashed = (!backslashed && c == '\\');
//#endif 

} 

//#endif 


//#if 1152573706 
return end;
//#endif 

} 

//#endif 


//#if 1448734185 
public static boolean isValue(final String key, final Map map)
    { 

//#if -2005199252 
if(map == null)//1
{ 

//#if -798225013 
return false;
//#endif 

} 

//#endif 


//#if 726633236 
Object o = map.get(key);
//#endif 


//#if 91373534 
if(!(o instanceof Boolean))//1
{ 

//#if 766902285 
return false;
//#endif 

} 

//#endif 


//#if 1694971898 
return ((Boolean) o).booleanValue();
//#endif 

} 

//#endif 


//#if 454771832 
private static String generateKind(Object /*Parameter etc.*/ kind)
    { 

//#if -1838378047 
StringBuffer s = new StringBuffer();
//#endif 


//#if -298692304 
if(kind == null /* "in" is the default */
                || kind == Model.getDirectionKind().getInParameter())//1
{ 

//#if -148529774 
s.append(/*"in"*/ "");
//#endif 

} 
else

//#if 503669351 
if(kind == Model.getDirectionKind().getInOutParameter())//1
{ 

//#if -2057305013 
s.append("inout");
//#endif 

} 
else

//#if -175281818 
if(kind == Model.getDirectionKind().getReturnParameter())//1
{ 
} 
else

//#if -1097524584 
if(kind == Model.getDirectionKind().getOutParameter())//1
{ 

//#if 450118479 
s.append("out");
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 773144486 
return s.toString();
//#endif 

} 

//#endif 


//#if 1257543400 
private static String generateExpression(Object expr)
    { 

//#if 777568648 
if(Model.getFacade().isAExpression(expr))//1
{ 

//#if -1872092737 
return generateUninterpreted(
                       (String) Model.getFacade().getBody(expr));
//#endif 

} 
else

//#if 1829502453 
if(Model.getFacade().isAConstraint(expr))//1
{ 

//#if -1093777873 
return generateExpression(Model.getFacade().getBody(expr));
//#endif 

} 

//#endif 


//#endif 


//#if 1123139641 
return "";
//#endif 

} 

//#endif 


//#if 808141260 
static Object getVisibility(String name)
    { 

//#if -979347776 
if("+".equals(name) || "public".equals(name))//1
{ 

//#if 224126043 
return Model.getVisibilityKind().getPublic();
//#endif 

} 
else

//#if -668490220 
if("#".equals(name) || "protected".equals(name))//1
{ 

//#if -1595490807 
return Model.getVisibilityKind().getProtected();
//#endif 

} 
else

//#if -1171566779 
if("~".equals(name) || "package".equals(name))//1
{ 

//#if 363142175 
return Model.getVisibilityKind().getPackage();
//#endif 

} 
else
{ 

//#if 240396051 
return Model.getVisibilityKind().getPrivate();
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 2139210215 
private static String generateUninterpreted(String un)
    { 

//#if -2048530142 
if(un == null)//1
{ 

//#if -501757799 
return "";
//#endif 

} 

//#endif 


//#if -335600319 
return un;
//#endif 

} 

//#endif 


//#if 287363036 
static void setProperties(Object elem, List<String> prop,
                              PropertySpecialString[] spec)
    { 

//#if 360804491 
String name;
//#endif 


//#if -1470942513 
String value;
//#endif 


//#if -1617769809 
int i, j;
//#endif 


//#if -442659775 
nextProp://1

//#if -1769737320 
for (i = 0; i + 1 < prop.size(); i += 2) //1
{ 

//#if -897204970 
name = prop.get(i);
//#endif 


//#if -159694838 
value = prop.get(i + 1);
//#endif 


//#if -472243861 
if(name == null)//1
{ 

//#if 66563380 
continue;
//#endif 

} 

//#endif 


//#if 1439847853 
name = name.trim();
//#endif 


//#if 638862507 
if(value != null)//1
{ 

//#if 68165871 
value = value.trim();
//#endif 

} 

//#endif 


//#if 1410806293 
for (j = i + 2; j < prop.size(); j += 2) //1
{ 

//#if 79202579 
String s = prop.get(j);
//#endif 


//#if 1660513899 
if(s != null && name.equalsIgnoreCase(s.trim()))//1
{ 

//#if -287958266 
continue nextProp;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 662537015 
if(spec != null)//1
{ 

//#if -1869416546 
for (j = 0; j < spec.length; j++) //1
{ 

//#if -846255402 
if(spec[j].invoke(elem, name, value))//1
{ 

//#if -1472998741 
continue nextProp;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -872720061 
Model.getCoreHelper().setTaggedValue(elem, name, value);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1006377474 
public static String generateVisibility(Object o)
    { 

//#if -475691419 
if(o == null)//1
{ 

//#if 445105920 
return "";
//#endif 

} 

//#endif 


//#if 1481681396 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 456177030 
ProjectSettings ps = p.getProjectSettings();
//#endif 


//#if 398985895 
if(ps.getShowVisibilityValue())//1
{ 

//#if 257228616 
return generateVisibility2(o);
//#endif 

} 
else
{ 

//#if 208861210 
return "";
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1159363330 
protected static String generatePath(Object modelElement)
    { 

//#if 1718157599 
StringBuilder s = new StringBuilder();
//#endif 


//#if 983077721 
Object p = modelElement;
//#endif 


//#if 1698919766 
Stack<String> stack = new Stack<String>();
//#endif 


//#if -523825993 
Object ns = Model.getFacade().getNamespace(p);
//#endif 


//#if 1956097815 
while (ns != null && !Model.getFacade().isAModel(ns)) //1
{ 

//#if -1561595508 
stack.push(Model.getFacade().getName(ns));
//#endif 


//#if -1386186137 
ns = Model.getFacade().getNamespace(ns);
//#endif 

} 

//#endif 


//#if 312345823 
while (!stack.isEmpty()) //1
{ 

//#if 1670829602 
s.append(stack.pop() + "::");
//#endif 

} 

//#endif 


//#if -1048822151 
if(s.length() > 0 && !(s.lastIndexOf(":") == s.length() - 1))//1
{ 

//#if -1290074403 
s.append("::");
//#endif 

} 

//#endif 


//#if -971235648 
return s.toString();
//#endif 

} 

//#endif 


//#if 1081381976 
private static void setParamKind(Object parameter, String description)
    { 

//#if -1409623941 
Object kind;
//#endif 


//#if -423910202 
if("out".equalsIgnoreCase(description))//1
{ 

//#if 301581853 
kind = Model.getDirectionKind().getOutParameter();
//#endif 

} 
else

//#if 231617762 
if("inout".equalsIgnoreCase(description))//1
{ 

//#if 829503955 
kind = Model.getDirectionKind().getInOutParameter();
//#endif 

} 
else
{ 

//#if 2071963479 
kind = Model.getDirectionKind().getInParameter();
//#endif 

} 

//#endif 


//#endif 


//#if -976291753 
Model.getCoreHelper().setKind(parameter, kind);
//#endif 

} 

//#endif 


//#if -1768907491 
static String generateTaggedValue(Object tv)
    { 

//#if -1768548249 
if(tv == null)//1
{ 

//#if 1015945555 
return "";
//#endif 

} 

//#endif 


//#if -1524108683 
return Model.getFacade().getTagOfTag(tv)
               + "="
               + generateUninterpreted(Model.getFacade().getValueOfTag(tv));
//#endif 

} 

//#endif 


//#if 201419647 
static void parseParamList(Object op, String param, int paramOffset)
    throws ParseException
    { 

//#if 203798134 
MyTokenizer st =
            new MyTokenizer(param, " ,\t,:,=,\\,", parameterCustomSep);
//#endif 


//#if 1716978532 
Collection origParam =
            new ArrayList(Model.getFacade().getParameters(op));
//#endif 


//#if 1105308296 
Object ns = Model.getFacade().getRoot(op);
//#endif 


//#if -321450033 
if(Model.getFacade().isAOperation(op))//1
{ 

//#if -1228664473 
Object ow = Model.getFacade().getOwner(op);
//#endif 


//#if -156263072 
if(ow != null && Model.getFacade().getNamespace(ow) != null)//1
{ 

//#if 560012690 
ns = Model.getFacade().getNamespace(ow);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 651551196 
Iterator it = origParam.iterator();
//#endif 


//#if -1085184238 
while (st.hasMoreTokens()) //1
{ 

//#if -30002590 
String kind = null;
//#endif 


//#if 99884057 
String name = null;
//#endif 


//#if -1159880062 
String tok;
//#endif 


//#if -574967416 
String type = null;
//#endif 


//#if -1530448604 
StringBuilder value = null;
//#endif 


//#if -941183486 
Object p = null;
//#endif 


//#if 1609831726 
boolean hasColon = false;
//#endif 


//#if 454288209 
boolean hasEq = false;
//#endif 


//#if -1518585353 
while (it.hasNext() && p == null) //1
{ 

//#if 1161099014 
p = it.next();
//#endif 


//#if 1353144151 
if(Model.getFacade().isReturn(p))//1
{ 

//#if 326108686 
p = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1441549310 
while (st.hasMoreTokens()) //1
{ 

//#if -1942609483 
tok = st.nextToken();
//#endif 


//#if 1897107240 
if(",".equals(tok))//1
{ 

//#if 1204416073 
break;

//#endif 

} 
else

//#if -207681624 
if(" ".equals(tok) || "\t".equals(tok))//1
{ 

//#if 1297611031 
if(hasEq)//1
{ 

//#if -247053646 
value.append(tok);
//#endif 

} 

//#endif 

} 
else

//#if -459457008 
if(":".equals(tok))//1
{ 

//#if 1566181322 
hasColon = true;
//#endif 


//#if -1903058972 
hasEq = false;
//#endif 

} 
else

//#if 1195885317 
if("=".equals(tok))//1
{ 

//#if -395290134 
if(value != null)//1
{ 

//#if -2146296318 
String msg =
                            "parsing.error.notation-utility.two-default-values";
//#endif 


//#if 327872013 
throw new ParseException(Translator.localize(msg),
                                                 paramOffset + st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -1746841379 
hasEq = true;
//#endif 


//#if -1074133993 
hasColon = false;
//#endif 


//#if -1502897141 
value = new StringBuilder();
//#endif 

} 
else

//#if 1278307736 
if(hasColon)//1
{ 

//#if 96491536 
if(type != null)//1
{ 

//#if 662604841 
String msg = "parsing.error.notation-utility.two-types";
//#endif 


//#if -2091135013 
throw new ParseException(Translator.localize(msg),
                                                 paramOffset + st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -331139432 
if(tok.charAt(0) == '\'' || tok.charAt(0) == '\"')//1
{ 

//#if 718796764 
String msg =
                            "parsing.error.notation-utility.type-quoted";
//#endif 


//#if -1799856885 
throw new ParseException(Translator.localize(msg),
                                                 paramOffset + st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -178781217 
if(tok.charAt(0) == '(')//1
{ 

//#if -1255294079 
String msg =
                            "parsing.error.notation-utility.type-expr";
//#endif 


//#if -1889722765 
throw new ParseException(Translator.localize(msg),
                                                 paramOffset + st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -1481509426 
type = tok;
//#endif 

} 
else

//#if -792371579 
if(hasEq)//1
{ 

//#if 1879241691 
value.append(tok);
//#endif 

} 
else
{ 

//#if 117899465 
if(name != null && kind != null)//1
{ 

//#if -131692385 
String msg =
                            "parsing.error.notation-utility.extra-text";
//#endif 


//#if 502259183 
throw new ParseException(Translator.localize(msg),
                                                 paramOffset + st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -1455560983 
if(tok.charAt(0) == '\'' || tok.charAt(0) == '\"')//1
{ 

//#if -540588262 
String msg =
                            "parsing.error.notation-utility.name-kind-quoted";
//#endif 


//#if 194616053 
throw new ParseException(
                            Translator.localize(msg),
                            paramOffset + st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 1972094704 
if(tok.charAt(0) == '(')//1
{ 

//#if 91932894 
String msg =
                            "parsing.error.notation-utility.name-kind-expr";
//#endif 


//#if -970437140 
throw new ParseException(
                            Translator.localize(msg),
                            paramOffset + st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -1579678602 
kind = name;
//#endif 


//#if -1847690706 
name = tok;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -360658182 
if(p == null)//1
{ 

//#if 2084182009 
Object returnType =
                    ProjectManager.getManager()
                    .getCurrentProject().findType("void");
//#endif 


//#if 880332979 
p = Model.getCoreFactory().buildParameter(
                        op,
                        returnType);
//#endif 

} 

//#endif 


//#if -325228709 
if(name != null)//1
{ 

//#if 883455137 
Model.getCoreHelper().setName(p, name.trim());
//#endif 

} 

//#endif 


//#if 770257188 
if(kind != null)//1
{ 

//#if -213698507 
setParamKind(p, kind.trim());
//#endif 

} 

//#endif 


//#if -1423069878 
if(type != null)//1
{ 

//#if 536076518 
Model.getCoreHelper().setType(p, getType(type.trim(), ns));
//#endif 

} 

//#endif 


//#if 2126334423 
if(value != null)//1
{ 

//#if 106415211 
Project project =
                    ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1596375727 
ProjectSettings ps = project.getProjectSettings();
//#endif 


//#if -753649579 
String notationLanguage = ps.getNotationLanguage();
//#endif 


//#if 432551667 
Object initExpr =
                    Model.getDataTypesFactory()
                    .createExpression(
                        notationLanguage,
                        value.toString().trim());
//#endif 


//#if 1854614250 
Model.getCoreHelper().setDefaultValue(p, initExpr);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2128435584 
while (it.hasNext()) //1
{ 

//#if -1859148239 
Object p = it.next();
//#endif 


//#if 938186806 
if(!Model.getFacade().isReturn(p))//1
{ 

//#if -34618158 
Model.getCoreHelper().removeParameter(op, p);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -611406793 
private static String generateClassifierRef(Object cls)
    { 

//#if 598401552 
if(cls == null)//1
{ 

//#if -760241168 
return "";
//#endif 

} 

//#endif 


//#if -1743032127 
return Model.getFacade().getName(cls);
//#endif 

} 

//#endif 


//#if -332238529 
public static String generateMultiplicity(Object multiplicityOwner,
            Map args)
    { 

//#if 241893841 
return generateMultiplicity(multiplicityOwner,
                                    NotationProvider.isValue("singularMultiplicityVisible", args));
//#endif 

} 

//#endif 


//#if 954219519 
static class PropertySpecialString  { 

//#if -1306666249 
private String name;
//#endif 


//#if 1843046352 
private PropertyOperation op;
//#endif 


//#if 921318998 
public PropertySpecialString(String str, PropertyOperation propop)
        { 

//#if -1543599773 
name = str;
//#endif 


//#if -1509860364 
op = propop;
//#endif 

} 

//#endif 


//#if 728962301 
boolean invoke(Object element, String pname, String value)
        { 

//#if 785282489 
if(!name.equalsIgnoreCase(pname))//1
{ 

//#if -485845818 
return false;
//#endif 

} 

//#endif 


//#if -1861794391 
op.found(element, value);
//#endif 


//#if 606498484 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -301983443 
interface PropertyOperation  { 

//#if -1148975112 
void found(Object element, String value);
//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

