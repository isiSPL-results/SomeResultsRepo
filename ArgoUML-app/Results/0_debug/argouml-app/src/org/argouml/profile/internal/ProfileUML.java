
//#if 589461334 
// Compilation Unit of /ProfileUML.java 
 

//#if 1422395825 
package org.argouml.profile.internal;
//#endif 


//#if 1742732573 
import java.net.MalformedURLException;
//#endif 


//#if -989592412 
import java.util.ArrayList;
//#endif 


//#if 727004477 
import java.util.Collection;
//#endif 


//#if -1858287001 
import java.util.HashSet;
//#endif 


//#if 1530977337 
import java.util.Set;
//#endif 


//#if -1013449324 
import org.argouml.model.Model;
//#endif 


//#if -1834088168 
import org.argouml.profile.CoreProfileReference;
//#endif 


//#if 1223726703 
import org.argouml.profile.DefaultTypeStrategy;
//#endif 


//#if 162749823 
import org.argouml.profile.FormatingStrategy;
//#endif 


//#if 1046592724 
import org.argouml.profile.Profile;
//#endif 


//#if 1983018355 
import org.argouml.profile.ProfileException;
//#endif 


//#if -819122938 
import org.argouml.profile.ProfileModelLoader;
//#endif 


//#if 387245559 
import org.argouml.profile.ProfileReference;
//#endif 


//#if -648732561 
import org.argouml.profile.ResourceModelLoader;
//#endif 


//#if -1671186734 
import org.argouml.profile.internal.ocl.InvalidOclException;
//#endif 


//#if -451698986 
import org.argouml.cognitive.Critic;
//#endif 


//#if -536493167 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1332424073 
import org.argouml.profile.internal.ocl.CrOCL;
//#endif 


//#if -1775609902 
import org.argouml.uml.cognitive.critics.CrAssocNameConflict;
//#endif 


//#if -1976096956 
import org.argouml.uml.cognitive.critics.CrAttrNameConflict;
//#endif 


//#if -617309776 
import org.argouml.uml.cognitive.critics.CrCircularAssocClass;
//#endif 


//#if -1801270215 
import org.argouml.uml.cognitive.critics.CrCircularInheritance;
//#endif 


//#if 2056406078 
import org.argouml.uml.cognitive.critics.CrClassMustBeAbstract;
//#endif 


//#if 1785522922 
import org.argouml.uml.cognitive.critics.CrCrossNamespaceAssoc;
//#endif 


//#if 845697721 
import org.argouml.uml.cognitive.critics.CrDupParamName;
//#endif 


//#if 1731592767 
import org.argouml.uml.cognitive.critics.CrDupRoleNames;
//#endif 


//#if 1434780087 
import org.argouml.uml.cognitive.critics.CrFinalSubclassed;
//#endif 


//#if -312317329 
import org.argouml.uml.cognitive.critics.CrForkOutgoingTransition;
//#endif 


//#if 587427826 
import org.argouml.uml.cognitive.critics.CrIllegalGeneralization;
//#endif 


//#if 2019061697 
import org.argouml.uml.cognitive.critics.CrInterfaceAllPublic;
//#endif 


//#if -543003471 
import org.argouml.uml.cognitive.critics.CrInterfaceOperOnly;
//#endif 


//#if -354289941 
import org.argouml.uml.cognitive.critics.CrInvalidBranch;
//#endif 


//#if 1446826059 
import org.argouml.uml.cognitive.critics.CrInvalidFork;
//#endif 


//#if 597510229 
import org.argouml.uml.cognitive.critics.CrInvalidHistory;
//#endif 


//#if -2098582619 
import org.argouml.uml.cognitive.critics.CrInvalidInitial;
//#endif 


//#if 1450511587 
import org.argouml.uml.cognitive.critics.CrInvalidJoin;
//#endif 


//#if 266893913 
import org.argouml.uml.cognitive.critics.CrInvalidJoinTriggerOrGuard;
//#endif 


//#if 1166260520 
import org.argouml.uml.cognitive.critics.CrInvalidPseudoStateTrigger;
//#endif 


//#if -2011743652 
import org.argouml.uml.cognitive.critics.CrInvalidSynch;
//#endif 


//#if 658674701 
import org.argouml.uml.cognitive.critics.CrJoinIncomingTransition;
//#endif 


//#if -981776444 
import org.argouml.uml.cognitive.critics.CrMultiComposite;
//#endif 


//#if 1198046675 
import org.argouml.uml.cognitive.critics.CrMultipleAgg;
//#endif 


//#if 114205194 
import org.argouml.uml.cognitive.critics.CrMultipleDeepHistoryStates;
//#endif 


//#if -1519420128 
import org.argouml.uml.cognitive.critics.CrMultipleShallowHistoryStates;
//#endif 


//#if -101202076 
import org.argouml.uml.cognitive.critics.CrNWayAgg;
//#endif 


//#if 1119790389 
import org.argouml.uml.cognitive.critics.CrNameConflict;
//#endif 


//#if -1918219565 
import org.argouml.uml.cognitive.critics.CrNameConflictAC;
//#endif 


//#if 620836841 
import org.argouml.uml.cognitive.critics.CrNameConfusion;
//#endif 


//#if -1599124620 
import org.argouml.uml.cognitive.critics.CrOppEndConflict;
//#endif 


//#if 1765590840 
import org.argouml.uml.cognitive.critics.CrOppEndVsAttr;
//#endif 


//#if -1071920033 
public class ProfileUML extends 
//#if -1276908726 
Profile
//#endif 

  { 

//#if -1764000834 
private static final String PROFILE_FILE = "default-uml14.xmi";
//#endif 


//#if -356812698 
static final String NAME = "UML 1.4";
//#endif 


//#if 180193943 
private FormatingStrategy formatingStrategy;
//#endif 


//#if 1280039025 
private ProfileModelLoader profileModelLoader;
//#endif 


//#if -2036181580 
private Collection model;
//#endif 


//#if -1912583951 
@Override
    public DefaultTypeStrategy getDefaultTypeStrategy()
    { 

//#if 1852410716 
return new DefaultTypeStrategy() {
            public Object getDefaultAttributeType() {
                return ModelUtils.findTypeInModel("Integer", model.iterator()
                                                  .next());
            }

            public Object getDefaultParameterType() {
                return ModelUtils.findTypeInModel("Integer", model.iterator()
                                                  .next());
            }

            public Object getDefaultReturnType() {
                return null;
            }

        };
//#endif 

} 

//#endif 


//#if 129571537 
@Override
    public FormatingStrategy getFormatingStrategy()
    { 

//#if -2129175223 
return formatingStrategy;
//#endif 

} 

//#endif 


//#if 784799358 

//#if 2010812481 
@SuppressWarnings("unchecked")
//#endif 


    ProfileUML() throws ProfileException
    { 

//#if 657102052 
formatingStrategy = new JavaFormatingStrategy();
//#endif 


//#if 874439485 
profileModelLoader = new ResourceModelLoader();
//#endif 


//#if -2091307306 
ProfileReference profileReference = null;
//#endif 


//#if 1012923313 
try //1
{ 

//#if 1552313891 
profileReference = new CoreProfileReference(PROFILE_FILE);
//#endif 

} 

//#if -951827558 
catch (MalformedURLException e) //1
{ 

//#if -505760418 
throw new ProfileException(
                "Exception while creating profile reference.", e);
//#endif 

} 

//#endif 


//#endif 


//#if 1403947397 
model = profileModelLoader.loadModel(profileReference);
//#endif 


//#if 483404168 
if(model == null)//1
{ 

//#if -476501535 
model = new ArrayList();
//#endif 


//#if -658401816 
model.add(Model.getModelManagementFactory().createModel());
//#endif 

} 

//#endif 


//#if -2105000500 
loadWellFormednessRules();
//#endif 

} 

//#endif 


//#if -801632129 
@Override
    public String getDisplayName()
    { 

//#if -1967621133 
return NAME;
//#endif 

} 

//#endif 


//#if 793681941 
@Override
    public Collection getProfilePackages()
    { 

//#if 471922881 
return model;
//#endif 

} 

//#endif 


//#if -1335745198 
private void loadWellFormednessRules()
    { 

//#if 1252450074 
Set<Critic> critics = new HashSet<Critic>();
//#endif 


//#if 1725307420 
critics.add(new CrAssocNameConflict());
//#endif 


//#if 1279630122 
critics.add(new CrAttrNameConflict());
//#endif 


//#if 1548765502 
critics.add(new CrCircularAssocClass());
//#endif 


//#if -2069057451 
critics.add(new CrCircularInheritance());
//#endif 


//#if 1525448240 
critics.add(new CrClassMustBeAbstract());
//#endif 


//#if 1888897028 
critics.add(new CrCrossNamespaceAssoc());
//#endif 


//#if 1343696789 
critics.add(new CrDupParamName());
//#endif 


//#if 468978255 
critics.add(new CrDupRoleNames());
//#endif 


//#if -1335214427 
critics.add(new CrNameConfusion());
//#endif 


//#if 160517241 
critics.add(new CrInvalidHistory());
//#endif 


//#if 1559560466 
critics.add(new CrInvalidSynch());
//#endif 


//#if -1916209611 
critics.add(new CrInvalidJoinTriggerOrGuard());
//#endif 


//#if -891612922 
critics.add(new CrInvalidPseudoStateTrigger());
//#endif 


//#if 1041884969 
critics.add(new CrInvalidInitial());
//#endif 


//#if 1956173675 
critics.add(new CrInvalidJoin());
//#endif 


//#if -465208573 
critics.add(new CrInvalidFork());
//#endif 


//#if -178386845 
critics.add(new CrInvalidBranch());
//#endif 


//#if 1999496420 
critics.add(new CrMultipleDeepHistoryStates());
//#endif 


//#if -1665083442 
critics.add(new CrMultipleShallowHistoryStates());
//#endif 


//#if 2128206879 
critics.add(new CrForkOutgoingTransition());
//#endif 


//#if -1947933247 
critics.add(new CrJoinIncomingTransition());
//#endif 


//#if 574894615 
critics.add(new CrFinalSubclassed());
//#endif 


//#if 953155068 
critics.add(new CrIllegalGeneralization());
//#endif 


//#if -375624307 
critics.add(new CrInterfaceAllPublic());
//#endif 


//#if 333112541 
critics.add(new CrInterfaceOperOnly());
//#endif 


//#if 1261715579 
critics.add(new CrMultipleAgg());
//#endif 


//#if -510193334 
critics.add(new CrNWayAgg());
//#endif 


//#if 1233539387 
critics.add(new CrNameConflictAC());
//#endif 


//#if -1666547462 
critics.add(new CrOppEndConflict());
//#endif 


//#if -1296997718 
critics.add(new CrMultiComposite());
//#endif 


//#if 2105539481 
critics.add(new CrNameConflict());
//#endif 


//#if -306710858 
critics.add(new CrOppEndVsAttr());
//#endif 


//#if -527283098 
try //1
{ 

//#if -1007721155 
critics.add(new CrOCL("context AssociationClass inv:"
                                  + "self.allConnections->"
                                  + "forAll( ar | self.allFeatures->"
                                  + "forAll( f | f.oclIsKindOf(StructuralFeature) "
                                  + "implies ar.name <> f.name ))",
                                  "The names of the AssociationEnds and "
                                  + "the StructuralFeatures do not overlap.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
//#endif 

} 

//#if -830634533 
catch (InvalidOclException e) //1
{ 

//#if -912049430 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -1595294581 
try //2
{ 

//#if -979167868 
critics.add(new CrOCL("context AssociationClass inv:"
                                  + "self.allConnections->"
                                  + "forAll(ar | ar.participant <> self)",

                                  "An AssociationClass cannot be defined "
                                  + "between itself and something else.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
//#endif 

} 

//#if 1672540186 
catch (InvalidOclException e) //1
{ 

//#if -569062150 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -1595264789 
try //3
{ 

//#if 1725825510 
critics.add(new CrOCL("context Classifier inv:"
                                  + "self.oppositeAssociationEnds->"
                                  + "forAll( o | not self.allAttributes->"
                                  + "union (self.allContents)->"
                                  + "collect ( q | q.name )->includes (o.name) )",
                                  "The name of an opposite AssociationEnd may not be the same "
                                  + "as the name of an Attribute or a ModelElement contained "
                                  + "in the Classifier.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
//#endif 

} 

//#if -769889567 
catch (InvalidOclException e) //1
{ 

//#if 995861575 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -1595234997 
try //4
{ 

//#if -2113605869 
critics.add(new CrOCL("context DataType inv:"
                                  + "self.allFeatures->forAll(f | f.oclIsKindOf(Operation)"
                                  + " and f.oclAsType(Operation).isQuery)",
                                  "A DataType can only contain Operations, "
                                  + "which all must be queries.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
//#endif 

} 

//#if -140487939 
catch (InvalidOclException e) //1
{ 

//#if -1705124634 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -1595205205 
try //5
{ 

//#if -1751940539 
critics.add(new CrOCL("context GeneralizableElement inv:"
                                  + "self.isRoot implies self.generalization->isEmpty",
                                  "A root cannot have any Generalizations.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
//#endif 

} 

//#if -1681136519 
catch (InvalidOclException e) //1
{ 

//#if -599259106 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -1595175413 
try //6
{ 

//#if -90884264 
critics.add(new CrOCL("context GeneralizableElement inv:"
                                  + "self.generalization->"
                                  + "forAll(g |self.namespace.allContents->"
                                  + "includes(g.parent) )",
                                  "The parent must be included in the Namespace of"
                                  + " the GeneralizableElement.", null,
                                  ToDoItem.HIGH_PRIORITY, null, null, "http://www.uml.org/"));
//#endif 

} 

//#if 1367871936 
catch (InvalidOclException e) //1
{ 

//#if -529627434 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -1595145621 
try //7
{ 

//#if 956193682 
critics.add(new CrOCL("context Namespace inv:"
                                  + "self.allContents -> select(x|x.oclIsKindOf(Association))->"
                                  + "forAll(a1, a2 |a1.name = a2.name and "
                                  + "a1.connection.participant = a2.connection.participant"
                                  + " implies a1 = a2)",
                                  "All Associations must have a unique combination of name "
                                  + "and associated Classifiers in the Namespace.",
                                  null, ToDoItem.HIGH_PRIORITY, null, null,
                                  "http://www.uml.org/"));
//#endif 

} 

//#if 1997273564 
catch (InvalidOclException e) //1
{ 

//#if 886863736 
e.printStackTrace();
//#endif 

} 

//#endif 


//#endif 


//#if -2087535114 
setCritics(critics);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

