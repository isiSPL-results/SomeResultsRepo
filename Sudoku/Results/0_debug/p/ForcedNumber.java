
//#if -549193553 
// Compilation Unit of /ForcedNumber.java 
 

//#if -137816804 
package p;
//#endif 


//#if 1965467420 

//#if 1453940240 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 

public class ForcedNumber implements 
//#if -1882762697 
Solver
//#endif 

  { 

//#if 2061326336 

//#if -309494652 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    public boolean trySolve(Board board)
    { 

//#if -1806966796 
for (int i = 0; i < Structure.values().length; i++) //1
{ 

//#if -1108380658 
for (int j = 0; j < Field.POSSIBILITIES; j++) //1
{ 

//#if 695917393 
for (int k = 1; k <= Field.POSSIBILITIES; k++) //1
{ 

//#if 868572057 
int counter = 0;
//#endif 


//#if -609921975 
int element = -1;
//#endif 


//#if 1678835836 
for (int l = 0; l < Field.POSSIBILITIES; l++) //1
{ 

//#if -2095015840 
if(board.getField(Structure.values()[i], j, l)
                                .getRemainingPos().contains((Object) k))//1
{ 

//#if 655893744 
counter++;
//#endif 


//#if -2033449119 
element = l;
//#endif 

} 

//#endif 


//#if -611710121 
if(counter > 1)//1
{ 

//#if -2130756306 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 75933602 
if(counter == 1
                            && !board.getField(Structure.values()[i], j,
                                               element).isSet()
                            && !board.trySetField(Structure.values()[i], j,
                                                  element, new Field(k)))//1
{ 

//#if -2022030068 
return false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1116906381 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

