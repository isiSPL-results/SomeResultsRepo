
//#if  ModelBase  
// Compilation Unit of /RuleSet.java 
 

//#if  Test  
import java.util.Arrays;
//#endif 

public class RuleSet  { 
private final boolean[] causesBirth;
private final boolean[] causesDeath;
int apply(LifeForm lf)
    { 
int type = lf.getType();
int size = 0;
for(int i = 0; i < lf.getNeighbourhood().length; i++) //1
{ 
if(lf.getNeighbourhood()[i] > 0)//1
{ 
size++;
} 

} 

if((type == 0 && causesBirth[size]) || (type==1 && !causesDeath[size]))//1
{ 
return 1;
} 
else
{ 
return 0;
} 

} 

public RuleSet(boolean[] causesBirth, boolean[] causesDeath)
    { 
this.causesBirth = causesBirth;
this.causesDeath = causesDeath;
} 


//#if  Test  
public boolean equals(Object o)
    { 
if(o == null)//1
{ 
return false;
} 
else
if(o instanceof RuleSet)//1
{ 
RuleSet rso = (RuleSet) o;
return Arrays.equals(rso.causesBirth, this.causesBirth) && Arrays.equals(rso.causesDeath, this.causesDeath);
} 
else
{ 
return false;
} 


} 

//#endif 

 } 


//#endif 

