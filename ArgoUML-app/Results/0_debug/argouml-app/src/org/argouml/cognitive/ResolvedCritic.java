
//#if -1415809002 
// Compilation Unit of /ResolvedCritic.java 
 

//#if -164134593 
package org.argouml.cognitive;
//#endif 


//#if 1463072174 
import java.util.ArrayList;
//#endif 


//#if 879569907 
import java.util.List;
//#endif 


//#if 242609707 
import org.apache.log4j.Logger;
//#endif 


//#if 1371444259 
import org.argouml.util.ItemUID;
//#endif 


//#if -1769714634 
public class ResolvedCritic  { 

//#if -450721817 
private static final Logger LOG = Logger.getLogger(ResolvedCritic.class);
//#endif 


//#if 959820710 
private String critic;
//#endif 


//#if 1835513952 
private List<String> offenders;
//#endif 


//#if 718921810 
public ResolvedCritic(Critic c, ListSet offs, boolean canCreate)
    throws UnresolvableException
    { 

//#if -190970212 
if(c == null)//1
{ 

//#if -1967931926 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -1848912373 
try //1
{ 

//#if 690765546 
if(offs != null && offs.size() > 0)//1
{ 

//#if 417820327 
offenders = new ArrayList<String>(offs.size());
//#endif 


//#if -691158065 
importOffenders(offs, canCreate);
//#endif 

} 
else
{ 

//#if -2025401096 
offenders = new ArrayList<String>();
//#endif 

} 

//#endif 

} 

//#if 140399719 
catch (UnresolvableException ure) //1
{ 

//#if 458959079 
try //1
{ 

//#if -1574955220 
getCriticString(c);
//#endif 

} 

//#if 464584188 
catch (UnresolvableException ure2) //1
{ 

//#if -1226306761 
throw new UnresolvableException(ure2.getMessage() + "\n"
                                                + ure.getMessage());
//#endif 

} 

//#endif 


//#endif 


//#if 1704124392 
throw ure;
//#endif 

} 

//#endif 


//#endif 


//#if -616554444 
critic = getCriticString(c);
//#endif 

} 

//#endif 


//#if 1070436029 
protected void importOffenders(ListSet set, boolean canCreate)
    throws UnresolvableException
    { 

//#if -1046835745 
String fail = null;
//#endif 


//#if -397099824 
for (Object obj : set) //1
{ 

//#if -2050112196 
String id = ItemUID.getIDOfObject(obj, canCreate);
//#endif 


//#if -1208843553 
if(id == null)//1
{ 

//#if -1089684788 
if(!canCreate)//1
{ 

//#if 973737362 
throw new UnresolvableException("ItemUID missing or "
                                                    + "unable to "
                                                    + "create for class: "
                                                    + obj.getClass());
//#endif 

} 

//#endif 


//#if 642858406 
if(fail == null)//1
{ 

//#if -1138357769 
fail = obj.getClass().toString();
//#endif 

} 
else
{ 

//#if -830464463 
fail = fail + ", " + obj.getClass().toString();
//#endif 

} 

//#endif 


//#if 1698889465 
LOG.warn("Offender " + obj.getClass() + " unresolvable");
//#endif 

} 
else
{ 

//#if -555986510 
offenders.add(id);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1419753701 
if(fail != null)//1
{ 

//#if -1036172070 
throw new UnresolvableException("Unable to create ItemUID for "
                                            + "some class(es): "
                                            + fail);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1244702563 
protected String getCriticString(Critic c) throws UnresolvableException
    { 

//#if 1815573743 
if(c == null)//1
{ 

//#if 1953832052 
throw (new UnresolvableException("Critic is null"));
//#endif 

} 

//#endif 


//#if 126870001 
String s = c.getClass().toString();
//#endif 


//#if 331359744 
return s;
//#endif 

} 

//#endif 


//#if -2115331648 
@Override
    public String toString()
    { 

//#if 73460572 
StringBuffer sb =
            new StringBuffer("ResolvedCritic: " + critic + " : ");
//#endif 


//#if 62906268 
for (int i = 0; i < offenders.size(); i++) //1
{ 

//#if 2016922765 
if(i > 0)//1
{ 

//#if -1002268849 
sb.append(", ");
//#endif 

} 

//#endif 


//#if 653966748 
sb.append(offenders.get(i));
//#endif 

} 

//#endif 


//#if -1160825167 
return sb.toString();
//#endif 

} 

//#endif 


//#if -1225223016 
public ResolvedCritic(Critic c, ListSet offs)
    throws UnresolvableException
    { 

//#if -1234958311 
this(c, offs, true);
//#endif 

} 

//#endif 


//#if -984215447 
@Override
    public int hashCode()
    { 

//#if -748183909 
if(critic == null)//1
{ 

//#if -965411954 
return 0;
//#endif 

} 

//#endif 


//#if -813116184 
return critic.hashCode();
//#endif 

} 

//#endif 


//#if 1647755818 
public ResolvedCritic(String cr, List<String> offs)
    { 

//#if -17519899 
critic = cr;
//#endif 


//#if 905196728 
if(offs != null)//1
{ 

//#if 1981203554 
offenders = new ArrayList<String>(offs);
//#endif 

} 
else
{ 

//#if 388128817 
offenders = new ArrayList<String>();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -869846941 
public List<String> getOffenderList()
    { 

//#if 61377011 
return offenders;
//#endif 

} 

//#endif 


//#if 522763316 
@Override
    public boolean equals(Object obj)
    { 

//#if 1366288460 
ResolvedCritic rc;
//#endif 


//#if 292283502 
if(obj == null || !(obj instanceof ResolvedCritic))//1
{ 

//#if -1067179277 
return false;
//#endif 

} 

//#endif 


//#if -504514701 
rc = (ResolvedCritic) obj;
//#endif 


//#if 712194588 
if(critic == null)//1
{ 

//#if -252939053 
if(rc.critic != null)//1
{ 

//#if 950704225 
return false;
//#endif 

} 

//#endif 

} 
else

//#if 62008166 
if(!critic.equals(rc.critic))//1
{ 

//#if -1762788703 
return false;
//#endif 

} 

//#endif 


//#endif 


//#if -377661072 
if(offenders == null)//1
{ 

//#if 2017639952 
return true;
//#endif 

} 

//#endif 


//#if 571291909 
if(rc.offenders == null)//1
{ 

//#if -1318913615 
return false;
//#endif 

} 

//#endif 


//#if -1334412349 
for (String offender : offenders) //1
{ 

//#if 1423483306 
if(offender == null)//1
{ 

//#if 709335116 
continue;
//#endif 

} 

//#endif 


//#if 1661890647 
int j;
//#endif 


//#if -1618767054 
for (j = 0; j < rc.offenders.size(); j++) //1
{ 

//#if -1435458991 
if(offender.equals(rc.offenders.get(j)))//1
{ 

//#if 1452383972 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1374238644 
if(j >= rc.offenders.size())//1
{ 

//#if -2069415356 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1521328651 
return true;
//#endif 

} 

//#endif 


//#if -1845672546 
public String getCritic()
    { 

//#if 2135265461 
return critic;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

