package p;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Board implements Cloneable
    ,Serializable
{
    public static int ELEMENTS = Field.POSSIBILITIES * Field.POSSIBILITIES;
    protected Field[] board;
    public void setField(Structure structure, int structNr, int element, Field f)
    {
        board[getIndex(structure, structNr, element)] = f;
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
        for (int i = 0; i < board.length; i++) { //1
            clone.board[i] = (Field) board[i].clone();
        }
        return clone;
    }
    protected int getIndex(Structure str, int nr, int ele)
    {
        int sqrt = (int) Math.round(Math.sqrt(Field.POSSIBILITIES));
        if(str.name().equals("COL")) { //1
            return nr + (ele * Field.POSSIBILITIES);
        } else if(str.name().equals("ROW")) { //1
            return (nr * Field.POSSIBILITIES) + ele;
        } else if(str.name().equals("BOX")) { //1
            return Field.POSSIBILITIES * (nr / sqrt * sqrt + ele / sqrt)
                   + (nr % sqrt * sqrt + ele % sqrt);
        } else {
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
    public Board()
    {
        this.board = new Field[ELEMENTS];
        for (int i = 0; i < ELEMENTS; i++) { //1
            this.board[i] = new Field();
        }
    }

}
