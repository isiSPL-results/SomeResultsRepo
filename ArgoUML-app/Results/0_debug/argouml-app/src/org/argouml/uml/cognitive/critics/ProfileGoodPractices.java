
//#if 373201530 
// Compilation Unit of /ProfileGoodPractices.java 
 

//#if 634294783 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -124740550 
import java.util.HashSet;
//#endif 


//#if 85233548 
import java.util.Set;
//#endif 


//#if 458128163 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1214489319 
import org.argouml.profile.Profile;
//#endif 


//#if -402837773 
public class ProfileGoodPractices extends 
//#if 20996905 
Profile
//#endif 

  { 

//#if -517235315 
private Set<Critic>  critics = new HashSet<Critic>();
//#endif 


//#if 2091235632 
private CrMissingClassName crMissingClassName = new CrMissingClassName();
//#endif 


//#if -1066354658 
@Override
    public String getDisplayName()
    { 

//#if -83101539 
return "Critics for Good Practices";
//#endif 

} 

//#endif 


//#if -242292772 
public ProfileGoodPractices()
    { 

//#if 633976912 
critics.add(new CrEmptyPackage());
//#endif 


//#if -1166423059 
critics.add(new CrNodesOverlap());
//#endif 


//#if 495936162 
critics.add(new CrZeroLengthEdge());
//#endif 


//#if 452061402 
critics.add(new CrCircularComposition());
//#endif 


//#if -362956431 
critics.add(new CrMissingAttrName());
//#endif 


//#if -57760983 
critics.add(crMissingClassName);
//#endif 


//#if 886066573 
critics.add(new CrMissingStateName());
//#endif 


//#if -1305192242 
critics.add(new CrMissingOperName());
//#endif 


//#if -1088358737 
critics.add(new CrNonAggDataType());
//#endif 


//#if -2056780478 
critics.add(new CrSubclassReference());
//#endif 


//#if -840025191 
critics.add(new CrTooManyAssoc());
//#endif 


//#if -495424205 
critics.add(new CrTooManyAttr());
//#endif 


//#if -1550367984 
critics.add(new CrTooManyOper());
//#endif 


//#if 190545922 
critics.add(new CrTooManyTransitions());
//#endif 


//#if 1937488132 
critics.add(new CrTooManyStates());
//#endif 


//#if 1951880938 
critics.add(new CrTooManyClasses());
//#endif 


//#if 1552994606 
critics.add(new CrWrongLinkEnds());
//#endif 


//#if 445374781 
critics.add(new CrUtilityViolated());
//#endif 


//#if 1761826017 
this.setCritics(critics);
//#endif 

} 

//#endif 


//#if -275155145 
public String getProfileIdentifier()
    { 

//#if -1616704900 
return "GoodPractices";
//#endif 

} 

//#endif 


//#if 1748496166 
public Critic getCrMissingClassName()
    { 

//#if -284790543 
return crMissingClassName;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

