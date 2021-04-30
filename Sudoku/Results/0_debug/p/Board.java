
//#if -259757907
// Compilation Unit of /Board.java


//#if 1340840449
package p;
//#endif


//#if 682328899
import java.io.IOException;
//#endif


//#if -1795946111
import java.io.ObjectInputStream;
//#endif


//#if -1889629558
import java.io.ObjectOutputStream;
//#endif


//#if 153571691
import java.io.Serializable;
//#endif


//#if 442703343
import java.util.LinkedList;
//#endif


//#if -1682913080
import java.util.List;
//#endif


//#if -1575785853
import java.util.Random;
//#endif


//#if -1751108601
public class Board implements
//#if -2007850774
    Cloneable
//#endif

    ,
//#if 453645164
    Serializable
//#endif

{

//#if -1911713050
    public static int ELEMENTS = Field.POSSIBILITIES * Field.POSSIBILITIES;
//#endif


//#if -212940816
    protected Field[] board;
//#endif


//#if 1501973992
    public void setField(Structure structure, int structNr, int element, Field f)
    {

//#if 1729843599
        board[getIndex(structure, structNr, element)] = f;
//#endif

    }

//#endif


//#if 1217355907

//#if -132258592
    @p.R4Feature(p.R4Feature.SOLVER)
//#endif


    protected int getStructureIndex(int index, Structure str)
    {

//#if 414330903
        int sqrt = (int) Math.round(Math.sqrt(Field.POSSIBILITIES));
//#endif


//#if -1694233941
        if(str.name().equals("ROW")) { //1

//#if 2069580450
            return index / Field.POSSIBILITIES;
//#endif

        } else

//#if -1741262773
            if(str.name().equals("COL")) { //1

//#if -1980394307
                return index % Field.POSSIBILITIES;
//#endif

            } else

//#if -898948110
                if(str.name().equals("BOX")) { //1

//#if 1767508940
                    return sqrt * (index / (sqrt * Field.POSSIBILITIES))
                           + (index % Field.POSSIBILITIES) / sqrt;
//#endif

                } else {

//#if -1962253786
                    return -1;
//#endif

                }

//#endif


//#endif


//#endif

    }

//#endif


//#if 477822783

//#if 612913690
    @p.R4Feature(p.R4Feature.SOLVER)
//#endif


    protected List getRelatedFieldIndices(int index)
    {

//#if 685418487
        List indices = new LinkedList();
//#endif


//#if -2042344419
        Structure str;
//#endif


//#if -1799554037
        int strIndex;
//#endif


//#if -1859783323
        int indexProcessing;
//#endif


//#if 575055562
        for (int i = 0; i < Structure.values().length; i++) { //1

//#if -2002608401
            str = Structure.values()[i];
//#endif


//#if -251563661
            strIndex = getStructureIndex(index, str);
//#endif


//#if -804597171
            for (int j = 0; j < Field.POSSIBILITIES; j++) { //1

//#if -2085327209
                indexProcessing = getIndex(str, strIndex, j);
//#endif


//#if -880943001
                if(!(indices.contains(indexProcessing) || indexProcessing == index)) { //1

//#if -846838647
                    indices.add(indexProcessing);
//#endif

                }

//#endif

            }

//#endif

        }

//#endif


//#if -736566652
        return indices;
//#endif

    }

//#endif


//#if 1959240129

//#if 1272417299
    @p.R4Feature(p.R4Feature.STATES)
//#endif


    private void writeObject(ObjectOutputStream aOutputStream)
    throws IOException
    {

//#if 755163472
        aOutputStream.writeObject(board);
//#endif


//#if 1783677087
        aOutputStream.defaultWriteObject();
//#endif

    }

//#endif


//#if -590836012
    public Field getField(Structure struct, int structNr, int element)
    {

//#if -1530914528
        return board[getIndex(struct, structNr, element)];
//#endif

    }

//#endif


//#if -1539596691

//#if -1229849744
    @p.R4Feature(p.R4Feature.STATES)
//#endif


    public Object clone() throws CloneNotSupportedException
    {

//#if -733898315
        Board clone = new Board();
//#endif


//#if 122929663
        for (int i = 0; i < board.length; i++) { //1

//#if 1836081959
            clone.board[i] = (Field) board[i].clone();
//#endif

        }

//#endif


//#if -1388868043
        return clone;
//#endif

    }

//#endif


//#if -1168975151
    protected int getIndex(Structure str, int nr, int ele)
    {

//#if -1583752334
        int sqrt = (int) Math.round(Math.sqrt(Field.POSSIBILITIES));
//#endif


//#if 1361328662
        if(str.name().equals("COL")) { //1

//#if -892368330
            return nr + (ele * Field.POSSIBILITIES);
//#endif

        } else

//#if 723738080
            if(str.name().equals("ROW")) { //1

//#if 958614614
                return (nr * Field.POSSIBILITIES) + ele;
//#endif

            } else

//#if 1805808515
                if(str.name().equals("BOX")) { //1

//#if 1930552022
                    return Field.POSSIBILITIES * (nr / sqrt * sqrt + ele / sqrt)
                           + (nr % sqrt * sqrt + ele % sqrt);
//#endif

                } else {

//#if -1073182939
                    return -1;
//#endif

                }

//#endif


//#endif


//#endif

    }

//#endif


//#if -378314416

//#if 1022880455
    @p.R4Feature(p.R4Feature.STATES)
//#endif


    private void readObject(ObjectInputStream aInputStream)
    throws ClassNotFoundException, IOException
    {

//#if -530126050
        aInputStream.defaultReadObject();
//#endif


//#if -1043436845
        board = (Field[]) aInputStream.readObject();
//#endif

    }

//#endif


//#if -620948778

//#if -768932562
    @p.R4Feature(p.R4Feature.SOLVER)
//#endif


    protected boolean removeValueFromStructures(int index, int value)
    {

//#if -460099171
        List relatedFieldIndices = getRelatedFieldIndices(index);
//#endif


//#if 901182164
        for (int i = 0; i < relatedFieldIndices.size(); i++) { //1

//#if 1465546993
            if(!board[(Integer) relatedFieldIndices.get(i)].isSet()) { //1

//#if 113566982
                List remainingPos = board[(Integer) relatedFieldIndices.get(i)]
                                    .getRemainingPos();
//#endif


//#if 111818040
                if(remainingPos.contains(value) && remainingPos.size() <= 1) { //1

//#if 2076972365
                    return false;
//#endif

                }

//#endif


//#if -95828157
                remainingPos.remove((Object) value);
//#endif


//#if -864910814
                board[(Integer) relatedFieldIndices.get(i)] = new Field(
                    remainingPos);
//#endif

            }

//#endif

        }

//#endif


//#if 2119591425
        return true;
//#endif

    }

//#endif


//#if 44953610

//#if 752077154
    @p.R4Feature(p.R4Feature.GENERATOR)
//#endif


    public void removeRandomSetField()
    {

//#if 1070643167
        Random r = new Random();
//#endif


//#if -769317134
        int size = Field.POSSIBILITIES * Field.POSSIBILITIES;
//#endif


//#if 1307468739
        int rIndex = r.nextInt(size);
//#endif


//#if -2040003263
        int counter = 0;
//#endif


//#if 420427255
        while ((board[rIndex].value <= 0) && counter < size) { //1

//#if -219683562
            rIndex = ((rIndex + counter) % size);
//#endif


//#if -1678022042
            counter++;
//#endif

        }

//#endif


//#if 123658724
        Board output = new Board();
//#endif


//#if -284165493
        for (int i = 0; i < Field.POSSIBILITIES; i++) { //1

//#if -1682384394
            for (int j = 0; j < Field.POSSIBILITIES; j++) { //1

//#if 1989380300
                if(getIndex(Structure.ROW, i, j) != rIndex) { //1

//#if 985151728
                    Field f = getField(Structure.ROW, i, j);
//#endif


//#if 680112791
                    if(f.isSet()) { //1

//#if -272620343
                        output.trySetField(Structure.ROW, i, j,
                                           new Field(f.getValue()));
//#endif

                    }

//#endif

                }

//#endif

            }

//#endif

        }

//#endif


//#if -325991695
        board = output.board;
//#endif

    }

//#endif


//#if -2134549118

//#if 382217271
    @p.R4Feature(p.R4Feature.SOLVER)
//#endif


    public boolean isSolved()
    {

//#if 1079309197
        for (int i = 0; i < board.length; i++) { //1

//#if -846491979
            if(!board[i].isSet()) { //1

//#if 853106919
                return false;
//#endif

            }

//#endif

        }

//#endif


//#if 708508132
        return true;
//#endif

    }

//#endif


//#if -492408159

//#if 302353381
    @p.R4Feature(p.R4Feature.SOLVER)
//#endif


    public boolean trySetField(Structure str, int strIndex, int element, Field f)
    {

//#if 1760042657
        boolean validRemoveAction = removeValueFromStructures(
                                        getIndex(str, strIndex, element), f.getValue());
//#endif


//#if 1085685429
        if(validRemoveAction
                && getField(str, strIndex, element).getRemainingPos().contains(
                    (Object) f.getValue())) { //1

//#if 1114819843
            this.setField(str, strIndex, element, f);
//#endif


//#if -481792206
            return true;
//#endif

        } else {

//#if -1540386490
            return false;
//#endif

        }

//#endif

    }

//#endif


//#if 774062865
    public Board()
    {

//#if -1011885427
        this.board = new Field[ELEMENTS];
//#endif


//#if -1213129487
        for (int i = 0; i < ELEMENTS; i++) { //1

//#if 2026046951
            this.board[i] = new Field();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

