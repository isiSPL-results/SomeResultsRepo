// Compilation Unit of /ResolvedCritic.java 
 

//#if COGNITIVE 
package org.argouml.cognitive;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.util.ItemUID;
//#endif 


//#if COGNITIVE 
public class ResolvedCritic  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG = Logger.getLogger(ResolvedCritic.class);
//#endif 

private String critic;
private List<String> offenders;
public ResolvedCritic(Critic c, ListSet offs, boolean canCreate)
    throws UnresolvableException
    { 
if(c == null)//1
{ 
throw new IllegalArgumentException();
} 

try //1
{ 
if(offs != null && offs.size() > 0)//1
{ 
offenders = new ArrayList<String>(offs.size());
importOffenders(offs, canCreate);
} 
else
{ 
offenders = new ArrayList<String>();
} 

} 

//#if COGNITIVE 
catch (UnresolvableException ure) //1
{ 
try //1
{ 
getCriticString(c);
} 

//#if COGNITIVE 
catch (UnresolvableException ure2) //1
{ 
throw new UnresolvableException(ure2.getMessage() + "\n"
                                                + ure.getMessage());
} 

//#endif 


throw ure;
} 

//#endif 


critic = getCriticString(c);
} 

protected void importOffenders(ListSet set, boolean canCreate)
    throws UnresolvableException
    { 
String fail = null;
for (Object obj : set) //1
{ 
String id = ItemUID.getIDOfObject(obj, canCreate);
if(id == null)//1
{ 
if(!canCreate)//1
{ 
throw new UnresolvableException("ItemUID missing or "
                                                    + "unable to "
                                                    + "create for class: "
                                                    + obj.getClass());
} 

if(fail == null)//1
{ 
fail = obj.getClass().toString();
} 
else
{ 
fail = fail + ", " + obj.getClass().toString();
} 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.warn("Offender " + obj.getClass() + " unresolvable");
//#endif 

} 
else
{ 
offenders.add(id);
} 

} 

if(fail != null)//1
{ 
throw new UnresolvableException("Unable to create ItemUID for "
                                            + "some class(es): "
                                            + fail);
} 

} 

protected String getCriticString(Critic c) throws UnresolvableException
    { 
if(c == null)//1
{ 
throw (new UnresolvableException("Critic is null"));
} 

String s = c.getClass().toString();
return s;
} 

@Override
    public String toString()
    { 
StringBuffer sb =
            new StringBuffer("ResolvedCritic: " + critic + " : ");
for (int i = 0; i < offenders.size(); i++) //1
{ 
if(i > 0)//1
{ 
sb.append(", ");
} 

sb.append(offenders.get(i));
} 

return sb.toString();
} 

public ResolvedCritic(Critic c, ListSet offs)
    throws UnresolvableException
    { 
this(c, offs, true);
} 

@Override
    public int hashCode()
    { 
if(critic == null)//1
{ 
return 0;
} 

return critic.hashCode();
} 

public ResolvedCritic(String cr, List<String> offs)
    { 
critic = cr;
if(offs != null)//1
{ 
offenders = new ArrayList<String>(offs);
} 
else
{ 
offenders = new ArrayList<String>();
} 

} 

public List<String> getOffenderList()
    { 
return offenders;
} 

@Override
    public boolean equals(Object obj)
    { 
ResolvedCritic rc;
if(obj == null || !(obj instanceof ResolvedCritic))//1
{ 
return false;
} 

rc = (ResolvedCritic) obj;
if(critic == null)//1
{ 
if(rc.critic != null)//1
{ 
return false;
} 

} 
else

//#if COGNITIVE 
if(!critic.equals(rc.critic))//1
{ 
return false;
} 

//#endif 


if(offenders == null)//1
{ 
return true;
} 

if(rc.offenders == null)//1
{ 
return false;
} 

for (String offender : offenders) //1
{ 
if(offender == null)//1
{ 
continue;
} 

int j;
for (j = 0; j < rc.offenders.size(); j++) //1
{ 
if(offender.equals(rc.offenders.get(j)))//1
{ 
break;

} 

} 

if(j >= rc.offenders.size())//1
{ 
return false;
} 

} 

return true;
} 

public String getCritic()
    { 
return critic;
} 

 } 

//#endif 


