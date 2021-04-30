package p;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class Board implements Cloneable
,Serializable
  { 
public static int ELEMENTS = Field.POSSIBILITIES * Field.POSSIBILITIES;
protected Field[] board;
public void setField(Structure structure, int structNr, int element, Field f)
    { 
board[getIndex(structure, structNr, element)] = f;
} 
@p.R4Feature(p.R4Feature.SOLVER)

    protected int getStructureIndex(int index, Structure str)
    { 
int sqrt = (int) Math.round(Math.sqrt(Field.POSSIBILITIES));
if(str.name().equals("ROW"))//1
{ 
return index / Field.POSSIBILITIES;
} 
else
if(str.name().equals("COL"))//1
{ 
return index % Field.POSSIBILITIES;
} 
else
if(str.name().equals("BOX"))//1
{ 
return sqrt * (index / (sqrt * Field.POSSIBILITIES))
                   + (index % Field.POSSIBILITIES) / sqrt;
} 
else
{ 
return -1;
} 
} 
@p.R4Feature(p.R4Feature.SOLVER)

    protected List getRelatedFieldIndices(int index)
    { 
List indices = new LinkedList();
Structure str;
int strIndex;
int indexProcessing;
for (int i = 0; i < Structure.values().length; i++) //1
{ 
str = Structure.values()[i];
strIndex = getStructureIndex(index, str);
for (int j = 0; j < Field.POSSIBILITIES; j++) //1
{ 
indexProcessing = getIndex(str, strIndex, j);
if(!(indices.contains(indexProcessing) || indexProcessing == index))//1
{ 
indices.add(indexProcessing);
} 
} 
} 
return indices;
} 
@p.R4Feature(p.R4Feature.STATES)

    private void writeObject(ObjectOutputStream aOutputStream)
    throws IOException
    { 
aOutputStream.writeObject(board);
aOutputStream.defaultWriteObject();
} 
public Field getField(Structure struct, int structNr, int element)
    { 
return board[getIndex(struct, structNr, element)];
} 
@p.R4Feature(p.R4Feature.STATES)

    public Object clone() throws CloneNotSupportedException
    { 
Board clone = new Board();
for (int i = 0; i < board.length; i++) //1
{ 
clone.board[i] = (Field) board[i].clone();
} 
return clone;
} 
protected int getIndex(Structure str, int nr, int ele)
    { 
int sqrt = (int) Math.round(Math.sqrt(Field.POSSIBILITIES));
if(str.name().equals("COL"))//1
{ 
return nr + (ele * Field.POSSIBILITIES);
} 
else
if(str.name().equals("ROW"))//1
{ 
return (nr * Field.POSSIBILITIES) + ele;
} 
else
if(str.name().equals("BOX"))//1
{ 
return Field.POSSIBILITIES * (nr / sqrt * sqrt + ele / sqrt)
                   + (nr % sqrt * sqrt + ele % sqrt);
} 
else
{ 
return -1;
} 
} 
@p.R4Feature(p.R4Feature.STATES)

    private void readObject(ObjectInputStream aInputStream)
    throws ClassNotFoundException, IOException
    { 
aInputStream.defaultReadObject();
board = (Field[]) aInputStream.readObject();
} 
@p.R4Feature(p.R4Feature.SOLVER)

    protected boolean removeValueFromStructures(int index, int value)
    { 
List relatedFieldIndices = getRelatedFieldIndices(index);
for (int i = 0; i < relatedFieldIndices.size(); i++) //1
{ 
if(!board[(Integer) relatedFieldIndices.get(i)].isSet())//1
{ 
List remainingPos = board[(Integer) relatedFieldIndices.get(i)]
                                    .getRemainingPos();
if(remainingPos.contains(value) && remainingPos.size() <= 1)//1
{ 
return false;
} 
remainingPos.remove((Object) value);
board[(Integer) relatedFieldIndices.get(i)] = new Field(
                    remainingPos);
} 
} 
return true;
} 
@p.R4Feature(p.R4Feature.GENERATOR)

    public void removeRandomSetField()
    { 
Random r = new Random();
int size = Field.POSSIBILITIES * Field.POSSIBILITIES;
int rIndex = r.nextInt(size);
int counter = 0;
while ((board[rIndex].value <= 0) && counter < size) //1
{ 
rIndex = ((rIndex + counter) % size);
counter++;
} 
Board output = new Board();
for (int i = 0; i < Field.POSSIBILITIES; i++) //1
{ 
for (int j = 0; j < Field.POSSIBILITIES; j++) //1
{ 
if(getIndex(Structure.ROW, i, j) != rIndex)//1
{ 
Field f = getField(Structure.ROW, i, j);
if(f.isSet())//1
{ 
output.trySetField(Structure.ROW, i, j,
                                           new Field(f.getValue()));
} 
} 
} 
} 
board = output.board;
} 
@p.R4Feature(p.R4Feature.SOLVER)

    public boolean isSolved()
    { 
for (int i = 0; i < board.length; i++)//1
{ 
if(!board[i].isSet())//1
{ 
return false;
} 
} 
return true;
} 
@p.R4Feature(p.R4Feature.SOLVER)

    public boolean trySetField(Structure str, int strIndex, int element, Field f)
    { 
boolean validRemoveAction = removeValueFromStructures(
                                        getIndex(str, strIndex, element), f.getValue());
if(validRemoveAction
                && getField(str, strIndex, element).getRemainingPos().contains(
                    (Object) f.getValue()))//1
{ 
this.setField(str, strIndex, element, f);
return true;
} 
else
{ 
return false;
} 
} 
public Board()
    { 
this.board = new Field[ELEMENTS];
for (int i = 0; i < ELEMENTS; i++) //1
{ 
this.board[i] = new Field();
} 
} 

 } 
