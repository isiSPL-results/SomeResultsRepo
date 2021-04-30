
//#if 1856132287 
// Compilation Unit of /RuleSet.java 
 

//#if 2130171379 
import java.util.Arrays;
//#endif 


//#if -536255680 
public class RuleSet  { 

//#if 1330446518 
private final boolean[] causesBirth;
//#endif 


//#if 1383504289 
private final boolean[] causesDeath;
//#endif 


//#if -1925235 
int apply(LifeForm lf)
    { 

//#if 1429188600 
int type = lf.getType();
//#endif 


//#if -554707254 
int size = 0;
//#endif 


//#if 1213816866 
for(int i = 0; i < lf.getNeighbourhood().length; i++) //1
{ 

//#if -202574176 
if(lf.getNeighbourhood()[i] > 0)//1
{ 

//#if 1516615881 
size++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1522202082 
if((type == 0 && causesBirth[size]) || (type==1 && !causesDeath[size]))//1
{ 

//#if 573149280 
return 1;
//#endif 

} 
else
{ 

//#if -1027518981 
return 0;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 443150170 
public RuleSet(boolean[] causesBirth, boolean[] causesDeath)
    { 

//#if -1689215027 
this.causesBirth = causesBirth;
//#endif 


//#if -364459741 
this.causesDeath = causesDeath;
//#endif 

} 

//#endif 


//#if -1586806678 
public boolean equals(Object o)
    { 

//#if 354242986 
if(o == null)//1
{ 

//#if -173093870 
return false;
//#endif 

} 
else

//#if -48501339 
if(o instanceof RuleSet)//1
{ 

//#if -1747195012 
RuleSet rso = (RuleSet) o;
//#endif 


//#if -1522551791 
return Arrays.equals(rso.causesBirth, this.causesBirth) && Arrays.equals(rso.causesDeath, this.causesDeath);
//#endif 

} 
else
{ 

//#if -1811261219 
return false;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

