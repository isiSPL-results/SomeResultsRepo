package org.argouml.ocl;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import tudresden.ocl.check.OclTypeException;
import tudresden.ocl.check.types.Any;
import tudresden.ocl.check.types.Basic;
import tudresden.ocl.check.types.Type;
import tudresden.ocl.check.types.Type2;
import org.apache.log4j.Logger;
class ArgoAny implements Any
,Type2
  { 
private Object classifier;
private static final Logger LOG = Logger.getLogger(ArgoAny.class);
private Type internalNavigateParameterized(final String name,
            final Type[] params,
            boolean fCheckIsQuery)
    throws OclTypeException
    { 
if(classifier == null)//1
{ 
throw new OclTypeException("attempting to access features of Void");
} 
Type type = Basic.navigateAnyParameterized(name, params);
if(type != null)//1
{ 
return type;
} 
Object foundOp = null;
java.util.Collection operations =
            Model.getFacade().getOperations(classifier);
Iterator iter = operations.iterator();
while (iter.hasNext() && foundOp == null) //1
{ 
Object op = iter.next();
if(operationMatchesCall(op, name, params))//1
{ 
foundOp = op;
} 
} 
if(foundOp == null)//1
{ 
throw new OclTypeException("operation " + name
                                       + " not found in classifier "
                                       + toString());
} 
if(fCheckIsQuery)//1
{ 
if(!Model.getFacade().isQuery(foundOp))//1
{ 
throw new OclTypeException("Non-query operations cannot "
                                           + "be used in OCL expressions. ("
                                           + name + ")");
} 
} 
Collection returnParams =
            Model.getCoreHelper().getReturnParameters(foundOp);
Object rp;
if(returnParams.size() == 0)//1
{ 
rp = null;
} 
else
{ 
rp = returnParams.iterator().next();
} 
if(returnParams.size() > 1)//1
{ 
LOG.warn("OCL compiler only handles one return parameter"
                     + " - Found " + returnParams.size()
                     + " for " + Model.getFacade().getName(foundOp));
} 
if(rp == null || Model.getFacade().getType(rp) == null)//1
{ 
LOG.warn("WARNING: supposing return type void!");
return new ArgoAny(null);
} 
Object returnType = Model.getFacade().getType(rp);
return getOclRepresentation(returnType);
} 
public boolean conformsTo(Type type)
    { 
if(type instanceof ArgoAny)//1
{ 
ArgoAny other = (ArgoAny) type;
return equals(type)
                   || Model.getCoreHelper()
                   .getAllSupertypes(classifier).contains(other.classifier);
} 
return false;
} 
public boolean hasState(String name)
    { 
LOG.warn("ArgoAny.hasState() has been called, but is "
                 + "not implemented yet!");
return false;
} 
public Type navigateQualified(String name, Type[] qualifiers)
    throws OclTypeException
    { 
if(classifier == null)//1
{ 
throw new OclTypeException("attempting to access features of Void");
} 
if(qualifiers != null)//1
{ 
throw new OclTypeException("qualified associations "
                                       + "not supported yet!");
} 
Type type = Basic.navigateAnyQualified(name, this, qualifiers);
if(type != null)//1
{ 
return type;
} 
Object foundAssocType = null, foundAttribType = null;
boolean isSet = false, isSequence = false;
Collection attributes =
            Model.getCoreHelper().getAttributesInh(classifier);
Iterator iter = attributes.iterator();
while (iter.hasNext() && foundAttribType == null) //1
{ 
Object attr = iter.next();
if(Model.getFacade().getName(attr).equals(name))//1
{ 
foundAttribType = Model.getFacade().getType(attr);
} 
} 
Collection associationEnds =
            Model.getCoreHelper().getAssociateEndsInh(classifier);
Iterator asciter = associationEnds.iterator();
while (asciter.hasNext() && foundAssocType == null) //1
{ 
Object ae = asciter.next();
if(Model.getFacade().getName(ae) != null
                    && name.equals(Model.getFacade().getName(ae)))//1
{ 
foundAssocType = Model.getFacade().getType(ae);
} 
else
if(Model.getFacade().getName(ae) == null
                       || Model.getFacade().getName(ae).equals(""))//1
{ 
String oppositeName =
                    Model.getFacade().getName(Model.getFacade().getType(ae));
if(oppositeName != null)//1
{ 
String lowerOppositeName =
                        oppositeName.substring(0, 1).toLowerCase();
lowerOppositeName += oppositeName.substring(1);
if(lowerOppositeName.equals(name))//1
{ 
foundAssocType = Model.getFacade().getType(ae);
} 
} 
} 
if(foundAssocType != null)//1
{ 
Object multiplicity = Model.getFacade().getMultiplicity(ae);
if(multiplicity != null
                        && (Model.getFacade().getUpper(multiplicity) > 1
                            || Model.getFacade().getUpper(multiplicity)
                            == -1))//1
{ 
if(Model.getExtensionMechanismsHelper().hasStereotype(ae,
                            "ordered"))//1
{ 
isSequence = true;
} 
else
{ 
isSet = true;
} 
} 
} 
} 
if(foundAssocType != null && foundAttribType != null)//1
{ 
throw new OclTypeException("cannot access feature " + name
                                       + " of classifier " + toString()
                                       + " because both an attribute and "
                                       + "an association end of this name "
                                       + "where found");
} 
Object foundType;
if(foundAssocType == null)//1
{ 
foundType = foundAttribType;
} 
else
{ 
foundType = foundAssocType;
} 
if(foundType == null)//1
{ 
throw new OclTypeException("attribute " + name
                                       + " not found in classifier "
                                       + toString());
} 
Type result = getOclRepresentation(foundType);
if(isSet)//1
{ 
result =
                new tudresden.ocl.check.types.Collection(
                tudresden.ocl.check.types.Collection.SET,
                result);
} 
if(isSequence)//1
{ 
result =
                new tudresden.ocl.check.types.Collection(
                tudresden.ocl.check.types.Collection.SEQUENCE,
                result);
} 
return result;
} 
ArgoAny(Object cl)
    { 
classifier = cl;
} 
public Type navigateParameterizedQuery (String name, Type[] qualifiers)
    throws OclTypeException
    { 
return internalNavigateParameterized(name, qualifiers, true);
} 
public String toString()
    { 
if(classifier == null)//1
{ 
return "Void";
} 
return Model.getFacade().getName(classifier);
} 
protected boolean operationMatchesCall(Object operation,
                                           String callName,
                                           Type[] callParams)
    { 
if(!callName.equals(Model.getFacade().getName(operation)))//1
{ 
return false;
} 
Collection operationParameters =
            Model.getFacade().getParameters(operation);
if(!Model.getFacade().isReturn(
                    operationParameters.iterator().next()))//1
{ 
LOG.warn(
                "ArgoFacade$ArgoAny expects the first operation parameter "
                + "to be the return type; this isn't the case"
            );
} 
if(!(Model.getFacade().isReturn(operationParameters.iterator().next())
                && operationParameters.size() == (callParams.length + 1)))//1
{ 
return false;
} 
Iterator paramIter = operationParameters.iterator();
paramIter.next();
int index = 0;
while (paramIter.hasNext()) //1
{ 
Object nextParam = paramIter.next();
Object paramType =
                Model.getFacade().getType(nextParam);
Type operationParam = getOclRepresentation(paramType);
if(!callParams[index].conformsTo(operationParam))//1
{ 
return false;
} 
index++;
} 
return true;
} 
public int hashCode()
    { 
if(classifier == null)//1
{ 
return 0;
} 
return classifier.hashCode();
} 
protected Type getOclRepresentation(Object foundType)
    { 
Type result = null;
if(Model.getFacade().getName(foundType).equals("int")
                || Model.getFacade().getName(foundType).equals("Integer"))//1
{ 
result = Basic.INTEGER;
} 
if(Model.getFacade().getName(foundType).equals("float")
                || Model.getFacade().getName(foundType).equals("double"))//1
{ 
result = Basic.REAL;
} 
if(Model.getFacade().getName(foundType).equals("bool")
                || Model.getFacade().getName(foundType).equals("Boolean")
                || Model.getFacade().getName(foundType).equals("boolean"))//1
{ 
result = Basic.BOOLEAN;
} 
if(Model.getFacade().getName(foundType).equals("String"))//1
{ 
result = Basic.STRING;
} 
if(result == null)//1
{ 
result = new ArgoAny(foundType);
} 
return result;
} 
public Type navigateParameterized (String name, Type[] qualifiers)
    throws OclTypeException
    { 
return internalNavigateParameterized(name, qualifiers, false);
} 
public boolean equals(Object o)
    { 
ArgoAny any = null;
if(o instanceof ArgoAny)//1
{ 
any = (ArgoAny) o;
return (any.classifier == classifier);
} 
return false;
} 

 } 
public class ArgoFacade implements tudresden.ocl.check.types.ModelFacade
  { 
private Object target;
public ArgoFacade(Object t)
    { 
if(Model.getFacade().isAClassifier(t))//1
{ 
target = t;
} 
} 
public Any getClassifier(String name)
    { 
Project p = ProjectManager.getManager().getCurrentProject();
if(target != null && Model.getFacade().getName(target).equals(name))//1
{ 
return new ArgoAny(target);
} 
Object classifier = p.findTypeInModel(name, p.getModel());
if(classifier == null)//1
{ 
classifier = p.findType(name, false);
if(classifier == null)//1
{ 
throw new OclTypeException("cannot find classifier: " + name);
} 
} 
return new ArgoAny(classifier);
} 

 } 
