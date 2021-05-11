
//#if 1604831922 
// Compilation Unit of /ProfileCodeGeneration.java 
 

//#if 1207030145 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -326459272 
import java.util.HashSet;
//#endif 


//#if -1731829046 
import java.util.Set;
//#endif 


//#if -1730023942 
import org.argouml.cognitive.CompoundCritic;
//#endif 


//#if 1789920293 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1374948955 
import org.argouml.profile.Profile;
//#endif 


//#if -1290304629 
public class ProfileCodeGeneration extends 
//#if -1967566818 
Profile
//#endif 

  { 

//#if -812535422 
private Set<Critic>  critics = new HashSet<Critic>();
//#endif 


//#if 221518581 
private static Critic crMissingClassName;
//#endif 


//#if -1421805341 
private static Critic crDisambigClassName = new CrDisambigClassName();
//#endif 


//#if 682954595 
private static Critic crNoTransitions = new CrNoTransitions();
//#endif 


//#if 1396070051 
private static Critic crNoIncomingTransitions =
        new CrNoIncomingTransitions();
//#endif 


//#if 410847971 
private static Critic crNoOutgoingTransitions =
        new CrNoOutgoingTransitions();
//#endif 


//#if -2006990517 
private static CompoundCritic crCompoundConstructorNeeded;
//#endif 


//#if -1934920178 
private static CompoundCritic clsNaming;
//#endif 


//#if 692922085 
private static CompoundCritic noTrans1 =
        new CompoundCritic(crNoTransitions, crNoIncomingTransitions);
//#endif 


//#if -1445294624 
private static CompoundCritic noTrans2 =
        new CompoundCritic(crNoTransitions, crNoOutgoingTransitions);
//#endif 


//#if 328938391 
public ProfileCodeGeneration(ProfileGoodPractices profileGoodPractices)
    { 

//#if 1649637336 
crMissingClassName = profileGoodPractices.getCrMissingClassName();
//#endif 


//#if 2033219213 
crCompoundConstructorNeeded = new CompoundCritic(
            crMissingClassName, new CrConstructorNeeded());
//#endif 


//#if -1616725431 
clsNaming = new CompoundCritic(crMissingClassName,
                                       crDisambigClassName);
//#endif 


//#if -53899972 
critics.add(crCompoundConstructorNeeded);
//#endif 


//#if -1702239399 
critics.add(clsNaming);
//#endif 


//#if -1829542171 
critics.add(new CrDisambigStateName());
//#endif 


//#if 950588501 
critics.add(crDisambigClassName);
//#endif 


//#if -1923317328 
critics.add(new CrIllegalName());
//#endif 


//#if 1076502698 
critics.add(new CrReservedName());
//#endif 


//#if -1191703451 
critics.add(new CrNoInitialState());
//#endif 


//#if 1864194722 
critics.add(new CrNoTriggerOrGuard());
//#endif 


//#if 1302843507 
critics.add(new CrNoGuard());
//#endif 


//#if -713940542 
critics.add(new CrOperNameConflict());
//#endif 


//#if -136234192 
critics.add(new CrNoInstanceVariables());
//#endif 


//#if 317038154 
critics.add(new CrNoAssociations());
//#endif 


//#if 1346359908 
critics.add(new CrNoOperations());
//#endif 


//#if -353766415 
critics.add(new CrUselessAbstract());
//#endif 


//#if 189381456 
critics.add(new CrUselessInterface());
//#endif 


//#if 371388579 
critics.add(new CrNavFromInterface());
//#endif 


//#if 1698025002 
critics.add(new CrUnnavigableAssoc());
//#endif 


//#if 1409252164 
critics.add(new CrAlreadyRealizes());
//#endif 


//#if 1235113797 
critics.add(new CrMultipleInitialStates());
//#endif 


//#if -274065947 
critics.add(new CrUnconventionalOperName());
//#endif 


//#if 668169864 
critics.add(new CrUnconventionalAttrName());
//#endif 


//#if -1479982787 
critics.add(new CrUnconventionalClassName());
//#endif 


//#if 1199789744 
critics.add(new CrUnconventionalPackName());
//#endif 


//#if -408553587 
critics.add(new CrNodeInsideElement());
//#endif 


//#if -2009995912 
critics.add(new CrNodeInstanceInsideElement());
//#endif 


//#if -550743164 
critics.add(new CrComponentWithoutNode());
//#endif 


//#if -1401470571 
critics.add(new CrCompInstanceWithoutNode());
//#endif 


//#if 11234364 
critics.add(new CrClassWithoutComponent());
//#endif 


//#if 544626557 
critics.add(new CrInterfaceWithoutComponent());
//#endif 


//#if -1589462069 
critics.add(new CrObjectWithoutComponent());
//#endif 


//#if 190991619 
critics.add(new CrInstanceWithoutClassifier());
//#endif 


//#if 627115879 
critics.add(noTrans1);
//#endif 


//#if 627116840 
critics.add(noTrans2);
//#endif 


//#if -1775215967 
this.setCritics(critics);
//#endif 


//#if 1650050811 
addProfileDependency("GoodPractices");
//#endif 

} 

//#endif 


//#if 55331411 
@Override
    public String getDisplayName()
    { 

//#if -1383009047 
return "Critics for Code Generation";
//#endif 

} 

//#endif 


//#if 1710823714 
public String getProfileIdentifier()
    { 

//#if -1165444062 
return "CodeGeneration";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

