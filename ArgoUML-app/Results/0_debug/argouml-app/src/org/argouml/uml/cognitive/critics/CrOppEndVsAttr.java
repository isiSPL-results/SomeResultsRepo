
//#if -979296880 
// Compilation Unit of /CrOppEndVsAttr.java 
 

//#if 1465952734 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1635627960 
import java.util.ArrayList;
//#endif 


//#if 504457385 
import java.util.Collection;
//#endif 


//#if 79638139 
import java.util.HashSet;
//#endif 


//#if 174500825 
import java.util.Iterator;
//#endif 


//#if -2078250419 
import java.util.Set;
//#endif 


//#if -1966365118 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1383252971 
import org.argouml.cognitive.Designer;
//#endif 


//#if 515637928 
import org.argouml.model.Model;
//#endif 


//#if 2118984746 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1016106615 
public class CrOppEndVsAttr extends 
//#if 1973945681 
CrUML
//#endif 

  { 

//#if 1465210861 
private static final long serialVersionUID = 5784567698177480475L;
//#endif 


//#if 556514407 
public CrOppEndVsAttr()
    { 

//#if -1158409888 
setupHeadAndDesc();
//#endif 


//#if 167957870 
addSupportedDecision(UMLDecision.INHERITANCE);
//#endif 


//#if 67615007 
addSupportedDecision(UMLDecision.RELATIONSHIPS);
//#endif 


//#if 1424306792 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if 342734187 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if 2124075514 
addTrigger("associationEnd");
//#endif 


//#if -128899365 
addTrigger("structuralFeature");
//#endif 

} 

//#endif 


//#if -1199201923 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1809772018 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1151685700 
ret.add(Model.getMetaTypes().getClassifier());
//#endif 


//#if -589969286 
return ret;
//#endif 

} 

//#endif 


//#if -1408257178 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1628312738 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 

//#if -640949153 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -601351570 
Object cls = /*(MClassifier)*/ dm;
//#endif 


//#if -359196014 
Collection<String> namesSeen = new ArrayList<String>();
//#endif 


//#if -1510213692 
Collection str = Model.getFacade().getFeatures(cls);
//#endif 


//#if -1586490444 
Iterator features = str.iterator();
//#endif 


//#if 1684293939 
while (features.hasNext()) //1
{ 

//#if 425292801 
Object o = features.next();
//#endif 


//#if 1867301351 
if(!(Model.getFacade().isAStructuralFeature(o)))//1
{ 

//#if 104718929 
continue;
//#endif 

} 

//#endif 


//#if -434334162 
Object sf = /*(MStructuralFeature)*/ o;
//#endif 


//#if 439710238 
String sfName = Model.getFacade().getName(sf);
//#endif 


//#if 1633608971 
if("".equals(sfName))//1
{ 

//#if -1206355750 
continue;
//#endif 

} 

//#endif 


//#if -1382472233 
String nameStr = sfName;
//#endif 


//#if 348918492 
if(nameStr.length() == 0)//1
{ 

//#if -433685397 
continue;
//#endif 

} 

//#endif 


//#if -1271073496 
namesSeen.add(nameStr);
//#endif 

} 

//#endif 


//#if 144937310 
Collection assocEnds = Model.getFacade().getAssociationEnds(cls);
//#endif 


//#if 1112417527 
Iterator myEnds = assocEnds.iterator();
//#endif 


//#if 823164666 
while (myEnds.hasNext()) //1
{ 

//#if 616846979 
Object myAe = /*(MAssociationEnd)*/ myEnds.next();
//#endif 


//#if -588812635 
Object asc =
                /*(MAssociation)*/
                Model.getFacade().getAssociation(myAe);
//#endif 


//#if 417971119 
Collection conn = Model.getFacade().getConnections(asc);
//#endif 


//#if 1589840123 
if(Model.getFacade().isAAssociationRole(asc))//1
{ 

//#if -970932474 
conn = Model.getFacade().getConnections(asc);
//#endif 

} 

//#endif 


//#if 1576182150 
if(conn == null)//1
{ 

//#if 1004776288 
continue;
//#endif 

} 

//#endif 


//#if 1922432140 
Iterator ascEnds = conn.iterator();
//#endif 


//#if 2107499738 
while (ascEnds.hasNext()) //1
{ 

//#if 470609790 
Object ae = /*(MAssociationEnd)*/ ascEnds.next();
//#endif 


//#if 891759880 
if(Model.getFacade().getType(ae) == cls)//1
{ 

//#if -884506788 
continue;
//#endif 

} 

//#endif 


//#if 1816114898 
String aeName = Model.getFacade().getName(ae);
//#endif 


//#if -690727866 
if("".equals(aeName))//1
{ 

//#if 1533916993 
continue;
//#endif 

} 

//#endif 


//#if -1952398794 
String aeNameStr = aeName;
//#endif 


//#if 1410683517 
if(aeNameStr == null || aeNameStr.length() == 0)//1
{ 

//#if -1217977695 
continue;
//#endif 

} 

//#endif 


//#if -1150260692 
if(namesSeen.contains(aeNameStr))//1
{ 

//#if 1319354939 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 145949491 
return NO_PROBLEM;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

