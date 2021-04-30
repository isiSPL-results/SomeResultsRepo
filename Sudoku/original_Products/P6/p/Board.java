package p;

//#if STATES
import java.io.IOException;
//#endif
//#if STATES
import java.io.ObjectInputStream;
//#endif
//#if STATES
import java.io.ObjectOutputStream;
//#endif
//#if STATES
import java.io.Serializable;
//#endif
//#if SOLVER
//@import java.util.LinkedList;
//#endif
//#if SOLVER
//@import java.util.List;
//#endif
//#if GENERATOR
//@import java.util.Random;
//@
//#endif
public class Board 
// #ifdef STATES
 implements  Cloneable , Serializable
// #endif
    
{
    
    public static int ELEMENTS = Field.POSSIBILITIES * Field.POSSIBILITIES;
    protected Field[] board;

    
    public Board()
    {
        this.board = new Field[ELEMENTS];
        for (int i = 0; i < ELEMENTS; i++) {
            this.board[i] = new Field();
        }
    }

    
    public Field getField(Structure struct, int structNr, int element)
    {
        return board[getIndex(struct, structNr, element)];
    }

    protected int getIndex(Structure str, int nr, int ele)
    {
        int sqrt = (int) Math.round(Math.sqrt(Field.POSSIBILITIES));
        if (str.name().equals("COL")) {
            return nr + (ele * Field.POSSIBILITIES);
        } else if (str.name().equals("ROW")) {
            return (nr * Field.POSSIBILITIES) + ele;
        } else if (str.name().equals("BOX")){
            return Field.POSSIBILITIES * (nr / sqrt * sqrt + ele / sqrt)
                   + (nr % sqrt * sqrt + ele % sqrt);
        }
        else {
            return -1;
        }
    }

    public void setField(Structure structure, int structNr, int element, Field f)
    {
        board[getIndex(structure, structNr, element)] = f;
    }

   // #if STATES
    @p.R4Feature(p.R4Feature.STATES)
    public Object clone() throws CloneNotSupportedException
    {
        Board clone = new Board();
        for (int i = 0; i < board.length; i++) {
            clone.board[i] = (Field) board[i].clone();
        }
        return clone;
    }

    // #endif
   // #if STATES
    @p.R4Feature(p.R4Feature.STATES)
    private void writeObject(ObjectOutputStream aOutputStream)
    throws IOException
    {
        aOutputStream.writeObject(board);
        aOutputStream.defaultWriteObject();
    }

    // #endif
   // #if STATES
    @p.R4Feature(p.R4Feature.STATES)
    private void readObject(ObjectInputStream aInputStream)
    throws ClassNotFoundException, IOException
    {
        aInputStream.defaultReadObject();
        board = (Field[]) aInputStream.readObject();
    }

    // #endif
   // #if SOLVER
//@    @p.R4Feature(p.R4Feature.SOLVER)
//@    public boolean isSolved()
//@    {
//@        for (int i = 0; i < board.length; i++){
//@            if (!board[i].isSet()) {
//@                return false;
//@            }
//@        }
//@        return true;
//@    }
//@
    // #endif
   // #if SOLVER
//@    @p.R4Feature(p.R4Feature.SOLVER)
//@    public boolean trySetField(Structure str, int strIndex, int element, Field f)
//@    {
//@        boolean validRemoveAction = removeValueFromStructures(
//@                                        getIndex(str, strIndex, element), f.getValue());
//@        if (validRemoveAction
//@                && getField(str, strIndex, element).getRemainingPos().contains(
//@                    (Object) f.getValue())) {
//@            this.setField(str, strIndex, element, f);
//@            return true;
//@        } else {
//@            return false;
//@        }
//@    }
//@
    // #endif
   // #if SOLVER
//@    @p.R4Feature(p.R4Feature.SOLVER)
//@    protected boolean removeValueFromStructures(int index, int value)
//@    {
//@        List relatedFieldIndices = getRelatedFieldIndices(index);
//@        for (int i = 0; i < relatedFieldIndices.size(); i++) {
//@            if (!board[(Integer) relatedFieldIndices.get(i)].isSet()) {
//@                List remainingPos = board[(Integer) relatedFieldIndices.get(i)]
//@                                    .getRemainingPos();
//@                if (remainingPos.contains(value) && remainingPos.size() <= 1) {
//@                    return false;
//@                }
//@                remainingPos.remove((Object) value);
//@                board[(Integer) relatedFieldIndices.get(i)] = new Field(
//@                    remainingPos);
//@            }
//@        }
//@        return true;
//@    }
//@
    // #endif
   // #if SOLVER
//@    @p.R4Feature(p.R4Feature.SOLVER)
//@    protected int getStructureIndex(int index, Structure str)
//@    {
//@        int sqrt = (int) Math.round(Math.sqrt(Field.POSSIBILITIES));
//@        if (str.name().equals("ROW")) {
//@            return index / Field.POSSIBILITIES;
//@        } else if (str.name().equals("COL")) {
//@            return index % Field.POSSIBILITIES;
//@        } else if (str.name().equals("BOX")){
//@            return sqrt * (index / (sqrt * Field.POSSIBILITIES))
//@                   + (index % Field.POSSIBILITIES) / sqrt;
//@        }
//@        else {
//@            return -1;
//@        }
//@    }
//@
    // #endif
   // #if SOLVER
//@    @p.R4Feature(p.R4Feature.SOLVER)
//@    protected List getRelatedFieldIndices(int index)
//@    {
//@        List indices = new LinkedList();
//@        Structure str;
//@        int strIndex;
//@        int indexProcessing;
//@        for (int i = 0; i < Structure.values().length; i++) {
//@            str = Structure.values()[i];
//@            strIndex = getStructureIndex(index, str);
//@            for (int j = 0; j < Field.POSSIBILITIES; j++) {
//@                indexProcessing = getIndex(str, strIndex, j);
//@                if (!(indices.contains(indexProcessing) || indexProcessing == index)) {
//@                    indices.add(indexProcessing);
//@                }
//@            }
//@        }
//@        return indices;
//@    }
    // #endif
    
   // #if GENERATOR
//@    @p.R4Feature(p.R4Feature.GENERATOR)
//@    public void removeRandomSetField()
//@    {
//@        Random r = new Random();
//@        int size = Field.POSSIBILITIES * Field.POSSIBILITIES;
//@        int rIndex = r.nextInt(size);
//@        int counter = 0;
//@        while ((board[rIndex].value <= 0) && counter < size) {
//@            rIndex = ((rIndex + counter) % size);
//@            counter++;
//@        }
//@        Board output = new Board();
//@        for (int i = 0; i < Field.POSSIBILITIES; i++) {
//@            for (int j = 0; j < Field.POSSIBILITIES; j++) {
//@                if (getIndex(Structure.ROW, i, j) != rIndex) {
//@                    Field f = getField(Structure.ROW, i, j);
//@                    if (f.isSet()){
//@                        output.trySetField(Structure.ROW, i, j,
//@                                           new Field(f.getValue()));
//@                    }
//@                }
//@            }
//@        }
//@        board = output.board;
//@    }
    // #endif
}
