package p;
import java.util.List;
import java.util.Random;
@p.R4Feature(p.R4Feature.GENERATOR)
public class SudokuGenerator  { 
public Board generate()
    { 
Board board = new Board();
fillBoard(board);
makeSolvable(board, 50);
return board;
} 
private void fillBoard(Board board)
    { 
BoardManager bm = new BoardManager();
Random r = new Random();
bm.setBoard(board);
int fieldsToFill = Field.POSSIBILITIES * Field.POSSIBILITIES;
for (int i = 0; i < fieldsToFill; i++) //1
{ 
int row = r.nextInt(Field.POSSIBILITIES);
int fieldIndex = r.nextInt(Field.POSSIBILITIES);
Field f = bm.getField(Structure.ROW, row, fieldIndex);
List remainingPos = null;
remainingPos = f
                           .getRemainingPos();
if(remainingPos.size() > 0)//1
{ 
int value = (Integer) remainingPos.get(r.nextInt(remainingPos
                                                       .size()));
boolean result = bm.trySetFieldPrivate(Structure.ROW, row,
                                                       fieldIndex, new Field(value, true));
if(!result)//1
{ 
bm.undo();
} 
} 
else
{ 
bm.undo();
} 
} 
} 
private boolean makeSolvable(Board board, int steps)
    { 
BoardManager bm = new BoardManager();
bm.setBoard(board);
Random r = new Random();
int k = steps;
try//1
{ 
List solutions = bm.solve((Board) board.clone());
boolean solvable = !solutions.isEmpty();
while (k > 0) //1
{ 
board.removeRandomSetField();
solutions = bm.solve((Board) board.clone());
if(!solutions.isEmpty())//1
{ 
return true;
} 
k--;
} 
} 
catch (CloneNotSupportedException e)//1
{
}return false;
} 

 } 
