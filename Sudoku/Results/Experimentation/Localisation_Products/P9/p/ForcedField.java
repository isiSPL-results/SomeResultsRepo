package p;
@p.R4Feature(p.R4Feature.SOLVER)
public class ForcedField implements Solver
  { 
@p.R4Feature(p.R4Feature.SOLVER)

    public boolean trySolve(Board board)
    { 
for (int i = 0; i < Field.POSSIBILITIES; i++)//1
{ 
for (int j = 0; j < Field.POSSIBILITIES; j++)//1
{ 
if((board.getField(Structure.ROW, i, j).getRemainingPos()
                        .size() == 1)
                        && !board.getField(Structure.ROW, i, j).isSet())//1
{ 
if(!board.trySetField(Structure.ROW, i, j, new Field(
                                               (Integer) board.getField(Structure.ROW, i, j)
                                               .getRemainingPos().get(0))))//1
{ 
return false;
} 
} 
} 
} 
return true;
} 

 } 
