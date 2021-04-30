package p;
@p.R4Feature(p.R4Feature.SOLVER)
public class ForcedNumber implements Solver
  { 
@p.R4Feature(p.R4Feature.SOLVER)

    public boolean trySolve(Board board)
    { 
for (int i = 0; i < Structure.values().length; i++) //1
{ 
for (int j = 0; j < Field.POSSIBILITIES; j++) //1
{ 
for (int k = 1; k <= Field.POSSIBILITIES; k++) //1
{ 
int counter = 0;
int element = -1;
for (int l = 0; l < Field.POSSIBILITIES; l++) //1
{ 
if(board.getField(Structure.values()[i], j, l)
                                .getRemainingPos().contains((Object) k))//1
{ 
counter++;
element = l;
} 
if(counter > 1)//1
{ 
break;

} 
} 
if(counter == 1
                            && !board.getField(Structure.values()[i], j,
                                               element).isSet()
                            && !board.trySetField(Structure.values()[i], j,
                                                  element, new Field(k)))//1
{ 
return false;
} 
} 
} 
} 
return true;
} 

 } 
