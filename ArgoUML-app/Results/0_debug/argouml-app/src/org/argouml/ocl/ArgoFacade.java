
//#if 1086028996 
// Compilation Unit of /ArgoFacade.java 
 

//#if -1305107767 
package org.argouml.ocl;
//#endif 


//#if 1235502203 
import java.util.Collection;
//#endif 


//#if -1102949333 
import java.util.Iterator;
//#endif 


//#if -147093068 
import org.argouml.kernel.Project;
//#endif 


//#if 638178997 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -707347050 
import org.argouml.model.Model;
//#endif 


//#if -637066078 
import tudresden.ocl.check.OclTypeException;
//#endif 


//#if -652467232 
import tudresden.ocl.check.types.Any;
//#endif 


//#if 60707230 
import tudresden.ocl.check.types.Basic;
//#endif 


//#if 1266219600 
import tudresden.ocl.check.types.Type;
//#endif 


//#if 598101716 
import tudresden.ocl.check.types.Type2;
//#endif 


//#if 1740083747 
import org.apache.log4j.Logger;
//#endif 


//#if -1884149576 
class ArgoAny implements 
//#if -628493730 
Any
//#endif 

, 
//#if 1625783338 
Type2
//#endif 

  { 

//#if -1416148730 
private Object classifier;
//#endif 


//#if -1018081365 
private static final Logger LOG = Logger.getLogger(ArgoAny.class);
//#endif 


//#if -118897851 
private Type internalNavigateParameterized(final String name,
            final Type[] params,
            boolean fCheckIsQuery)
    throws OclTypeException
    { 

//#if -2125707056 
if(classifier == null)//1
{ 

//#if 1070530203 
throw new OclTypeException("attempting to access features of Void");
//#endif 

} 

//#endif 


//#if 1224837549 
Type type = Basic.navigateAnyParameterized(name, params);
//#endif 


//#if 2131895109 
if(type != null)//1
{ 

//#if -217594214 
return type;
//#endif 

} 

//#endif 


//#if -1521770672 
Object foundOp = null;
//#endif 


//#if -1088671773 
java.util.Collection operations =
            Model.getFacade().getOperations(classifier);
//#endif 


//#if 193710166 
Iterator iter = operations.iterator();
//#endif 


//#if 1062241528 
while (iter.hasNext() && foundOp == null) //1
{ 

//#if -1112902652 
Object op = iter.next();
//#endif 


//#if 1640030104 
if(operationMatchesCall(op, name, params))//1
{ 

//#if -70574423 
foundOp = op;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1078692786 
if(foundOp == null)//1
{ 

//#if 908535737 
throw new OclTypeException("operation " + name
                                       + " not found in classifier "
                                       + toString());
//#endif 

} 

//#endif 


//#if -454289948 
if(fCheckIsQuery)//1
{ 

//#if -688335405 
if(!Model.getFacade().isQuery(foundOp))//1
{ 

//#if 1407336687 
throw new OclTypeException("Non-query operations cannot "
                                           + "be used in OCL expressions. ("
                                           + name + ")");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -661543344 
Collection returnParams =
            Model.getCoreHelper().getReturnParameters(foundOp);
//#endif 


//#if 742119507 
Object rp;
//#endif 


//#if -2138158402 
if(returnParams.size() == 0)//1
{ 

//#if 553663919 
rp = null;
//#endif 

} 
else
{ 

//#if -1223370324 
rp = returnParams.iterator().next();
//#endif 

} 

//#endif 


//#if 225465941 
if(returnParams.size() > 1)//1
{ 

//#if -820390129 
LOG.warn("OCL compiler only handles one return parameter"
                     + " - Found " + returnParams.size()
                     + " for " + Model.getFacade().getName(foundOp));
//#endif 

} 

//#endif 


//#if -1346862885 
if(rp == null || Model.getFacade().getType(rp) == null)//1
{ 

//#if -1831393955 
LOG.warn("WARNING: supposing return type void!");
//#endif 


//#if -486154826 
return new ArgoAny(null);
//#endif 

} 

//#endif 


//#if -1714570317 
Object returnType = Model.getFacade().getType(rp);
//#endif 


//#if -2124331814 
return getOclRepresentation(returnType);
//#endif 

} 

//#endif 


//#if -345243546 
public boolean conformsTo(Type type)
    { 

//#if 809086322 
if(type instanceof ArgoAny)//1
{ 

//#if -705467369 
ArgoAny other = (ArgoAny) type;
//#endif 


//#if -772192922 
return equals(type)
                   || Model.getCoreHelper()
                   .getAllSupertypes(classifier).contains(other.classifier);
//#endif 

} 

//#endif 


//#if 1584555984 
return false;
//#endif 

} 

//#endif 


//#if 69255437 
public boolean hasState(String name)
    { 

//#if 672658423 
LOG.warn("ArgoAny.hasState() has been called, but is "
                 + "not implemented yet!");
//#endif 


//#if -100742359 
return false;
//#endif 

} 

//#endif 


//#if 196354700 
public Type navigateQualified(String name, Type[] qualifiers)
    throws OclTypeException
    { 

//#if 1183134942 
if(classifier == null)//1
{ 

//#if -1997589402 
throw new OclTypeException("attempting to access features of Void");
//#endif 

} 

//#endif 


//#if 1189174882 
if(qualifiers != null)//1
{ 

//#if 1189673771 
throw new OclTypeException("qualified associations "
                                       + "not supported yet!");
//#endif 

} 

//#endif 


//#if -1642519581 
Type type = Basic.navigateAnyQualified(name, this, qualifiers);
//#endif 


//#if 741913043 
if(type != null)//1
{ 

//#if 1896590144 
return type;
//#endif 

} 

//#endif 


//#if -17632436 
Object foundAssocType = null, foundAttribType = null;
//#endif 


//#if 695775825 
boolean isSet = false, isSequence = false;
//#endif 


//#if -1507326741 
Collection attributes =
            Model.getCoreHelper().getAttributesInh(classifier);
//#endif 


//#if -680716209 
Iterator iter = attributes.iterator();
//#endif 


//#if -121325943 
while (iter.hasNext() && foundAttribType == null) //1
{ 

//#if -715894935 
Object attr = iter.next();
//#endif 


//#if 1607157554 
if(Model.getFacade().getName(attr).equals(name))//1
{ 

//#if 380717890 
foundAttribType = Model.getFacade().getType(attr);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -38701658 
Collection associationEnds =
            Model.getCoreHelper().getAssociateEndsInh(classifier);
//#endif 


//#if -2019589416 
Iterator asciter = associationEnds.iterator();
//#endif 


//#if 265481777 
while (asciter.hasNext() && foundAssocType == null) //1
{ 

//#if 1573393287 
Object ae = asciter.next();
//#endif 


//#if -1960725042 
if(Model.getFacade().getName(ae) != null
                    && name.equals(Model.getFacade().getName(ae)))//1
{ 

//#if 669414229 
foundAssocType = Model.getFacade().getType(ae);
//#endif 

} 
else

//#if -966336171 
if(Model.getFacade().getName(ae) == null
                       || Model.getFacade().getName(ae).equals(""))//1
{ 

//#if 962492743 
String oppositeName =
                    Model.getFacade().getName(Model.getFacade().getType(ae));
//#endif 


//#if -1500518437 
if(oppositeName != null)//1
{ 

//#if 1583080880 
String lowerOppositeName =
                        oppositeName.substring(0, 1).toLowerCase();
//#endif 


//#if 1419235371 
lowerOppositeName += oppositeName.substring(1);
//#endif 


//#if 811534137 
if(lowerOppositeName.equals(name))//1
{ 

//#if -148270170 
foundAssocType = Model.getFacade().getType(ae);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#if -1037647772 
if(foundAssocType != null)//1
{ 

//#if -170482856 
Object multiplicity = Model.getFacade().getMultiplicity(ae);
//#endif 


//#if 799174669 
if(multiplicity != null
                        && (Model.getFacade().getUpper(multiplicity) > 1
                            || Model.getFacade().getUpper(multiplicity)
                            == -1))//1
{ 

//#if 366199996 
if(Model.getExtensionMechanismsHelper().hasStereotype(ae,
                            "ordered"))//1
{ 

//#if 403426429 
isSequence = true;
//#endif 

} 
else
{ 

//#if -285412238 
isSet = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -383622989 
if(foundAssocType != null && foundAttribType != null)//1
{ 

//#if -477918334 
throw new OclTypeException("cannot access feature " + name
                                       + " of classifier " + toString()
                                       + " because both an attribute and "
                                       + "an association end of this name "
                                       + "where found");
//#endif 

} 

//#endif 


//#if -1969093061 
Object foundType;
//#endif 


//#if 915989578 
if(foundAssocType == null)//1
{ 

//#if -505866261 
foundType = foundAttribType;
//#endif 

} 
else
{ 

//#if -1909114401 
foundType = foundAssocType;
//#endif 

} 

//#endif 


//#if -1053107331 
if(foundType == null)//1
{ 

//#if 1155972722 
throw new OclTypeException("attribute " + name
                                       + " not found in classifier "
                                       + toString());
//#endif 

} 

//#endif 


//#if -1526015746 
Type result = getOclRepresentation(foundType);
//#endif 


//#if 1841572946 
if(isSet)//1
{ 

//#if 467443075 
result =
                new tudresden.ocl.check.types.Collection(
                tudresden.ocl.check.types.Collection.SET,
                result);
//#endif 

} 

//#endif 


//#if -1636412831 
if(isSequence)//1
{ 

//#if 798728932 
result =
                new tudresden.ocl.check.types.Collection(
                tudresden.ocl.check.types.Collection.SEQUENCE,
                result);
//#endif 

} 

//#endif 


//#if 1204320753 
return result;
//#endif 

} 

//#endif 


//#if 1269072254 
ArgoAny(Object cl)
    { 

//#if 196283781 
classifier = cl;
//#endif 

} 

//#endif 


//#if 389512949 
public Type navigateParameterizedQuery (String name, Type[] qualifiers)
    throws OclTypeException
    { 

//#if -787594648 
return internalNavigateParameterized(name, qualifiers, true);
//#endif 

} 

//#endif 


//#if 1541407221 
public String toString()
    { 

//#if 1645553057 
if(classifier == null)//1
{ 

//#if 1458931117 
return "Void";
//#endif 

} 

//#endif 


//#if -1655703578 
return Model.getFacade().getName(classifier);
//#endif 

} 

//#endif 


//#if 294362225 
protected boolean operationMatchesCall(Object operation,
                                           String callName,
                                           Type[] callParams)
    { 

//#if -203598274 
if(!callName.equals(Model.getFacade().getName(operation)))//1
{ 

//#if -1184380485 
return false;
//#endif 

} 

//#endif 


//#if -590964745 
Collection operationParameters =
            Model.getFacade().getParameters(operation);
//#endif 


//#if 2042376515 
if(!Model.getFacade().isReturn(
                    operationParameters.iterator().next()))//1
{ 

//#if -774434191 
LOG.warn(
                "ArgoFacade$ArgoAny expects the first operation parameter "
                + "to be the return type; this isn't the case"
            );
//#endif 

} 

//#endif 


//#if -232268912 
if(!(Model.getFacade().isReturn(operationParameters.iterator().next())
                && operationParameters.size() == (callParams.length + 1)))//1
{ 

//#if -1780918517 
return false;
//#endif 

} 

//#endif 


//#if -20277925 
Iterator paramIter = operationParameters.iterator();
//#endif 


//#if -1648539600 
paramIter.next();
//#endif 


//#if 15967159 
int index = 0;
//#endif 


//#if -1148532632 
while (paramIter.hasNext()) //1
{ 

//#if -100804289 
Object nextParam = paramIter.next();
//#endif 


//#if -188120064 
Object paramType =
                Model.getFacade().getType(nextParam);
//#endif 


//#if 1883420832 
Type operationParam = getOclRepresentation(paramType);
//#endif 


//#if 673621322 
if(!callParams[index].conformsTo(operationParam))//1
{ 

//#if -30004726 
return false;
//#endif 

} 

//#endif 


//#if 1477984134 
index++;
//#endif 

} 

//#endif 


//#if 1785851663 
return true;
//#endif 

} 

//#endif 


//#if -1059349420 
public int hashCode()
    { 

//#if -942210047 
if(classifier == null)//1
{ 

//#if -77065268 
return 0;
//#endif 

} 

//#endif 


//#if -8339140 
return classifier.hashCode();
//#endif 

} 

//#endif 


//#if -1872134837 
protected Type getOclRepresentation(Object foundType)
    { 

//#if -22837928 
Type result = null;
//#endif 


//#if 1586406914 
if(Model.getFacade().getName(foundType).equals("int")
                || Model.getFacade().getName(foundType).equals("Integer"))//1
{ 

//#if -1831303276 
result = Basic.INTEGER;
//#endif 

} 

//#endif 


//#if -23294370 
if(Model.getFacade().getName(foundType).equals("float")
                || Model.getFacade().getName(foundType).equals("double"))//1
{ 

//#if 698339866 
result = Basic.REAL;
//#endif 

} 

//#endif 


//#if 1077084293 
if(Model.getFacade().getName(foundType).equals("bool")
                || Model.getFacade().getName(foundType).equals("Boolean")
                || Model.getFacade().getName(foundType).equals("boolean"))//1
{ 

//#if 1063683348 
result = Basic.BOOLEAN;
//#endif 

} 

//#endif 


//#if 152572848 
if(Model.getFacade().getName(foundType).equals("String"))//1
{ 

//#if -226293295 
result = Basic.STRING;
//#endif 

} 

//#endif 


//#if 821893709 
if(result == null)//1
{ 

//#if 165969753 
result = new ArgoAny(foundType);
//#endif 

} 

//#endif 


//#if -35145820 
return result;
//#endif 

} 

//#endif 


//#if -1897433521 
public Type navigateParameterized (String name, Type[] qualifiers)
    throws OclTypeException
    { 

//#if -226694338 
return internalNavigateParameterized(name, qualifiers, false);
//#endif 

} 

//#endif 


//#if 1987486897 
public boolean equals(Object o)
    { 

//#if -1950681251 
ArgoAny any = null;
//#endif 


//#if 627920318 
if(o instanceof ArgoAny)//1
{ 

//#if 382953463 
any = (ArgoAny) o;
//#endif 


//#if -2094593908 
return (any.classifier == classifier);
//#endif 

} 

//#endif 


//#if 1816317173 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1579832965 
public class ArgoFacade implements 
//#if -1849885907 
tudresden.ocl.check.types.ModelFacade
//#endif 

  { 

//#if 1289442991 
private Object target;
//#endif 


//#if -1990352647 
public ArgoFacade(Object t)
    { 

//#if -749709890 
if(Model.getFacade().isAClassifier(t))//1
{ 

//#if 244973698 
target = t;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1406085888 
public Any getClassifier(String name)
    { 

//#if 808538291 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1304393016 
if(target != null && Model.getFacade().getName(target).equals(name))//1
{ 

//#if -1435922986 
return new ArgoAny(target);
//#endif 

} 

//#endif 


//#if 1011868678 
Object classifier = p.findTypeInModel(name, p.getModel());
//#endif 


//#if 1837384936 
if(classifier == null)//1
{ 

//#if -768710235 
classifier = p.findType(name, false);
//#endif 


//#if -2020164475 
if(classifier == null)//1
{ 

//#if 1794038112 
throw new OclTypeException("cannot find classifier: " + name);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 903876165 
return new ArgoAny(classifier);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

