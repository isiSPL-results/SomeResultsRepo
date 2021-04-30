
//#if -584970492
// Compilation Unit of /SudokuGenerator.java


//#if 1774557074
package p;
//#endif


//#if 1303246041
import java.util.List;
//#endif


//#if -915024300
import java.util.Random;
//#endif


//#if -2077750676

//#if 128738418
@p.R4Feature(p.R4Feature.GENERATOR)
//#endif

public class SudokuGenerator
{

//#if 869612901
    public Board generate()
    {

//#if 369323724
        Board board = new Board();
//#endif


//#if -136699490
        fillBoard(board);
//#endif


//#if 1900880376
        makeSolvable(board, 50);
//#endif


//#if 1661980762
        return board;
//#endif

    }

//#endif


//#if -418661669
    private void fillBoard(Board board)
    {

//#if -2051508768
        BoardManager bm = new BoardManager();
//#endif


//#if -1982435965
        Random r = new Random();
//#endif


//#if -633501127
        bm.setBoard(board);
//#endif


//#if -89430624
        int fieldsToFill = Field.POSSIBILITIES * Field.POSSIBILITIES;
//#endif


//#if 216874833
        for (int i = 0; i < fieldsToFill; i++) { //1

//#if -604250842
            int row = r.nextInt(Field.POSSIBILITIES);
//#endif


//#if 833528832
            int fieldIndex = r.nextInt(Field.POSSIBILITIES);
//#endif


//#if 1869174058
            Field f = bm.getField(Structure.ROW, row, fieldIndex);
//#endif


//#if -863905916
            List remainingPos = null;
//#endif


//#if 1963202812
            remainingPos = f
                           .getRemainingPos();
//#endif


//#if 2040656050
            if(remainingPos.size() > 0) { //1

//#if 59435191
                int value = (Integer) remainingPos.get(r.nextInt(remainingPos
                                                       .size()));
//#endif


//#if 46246536
                boolean result = bm.trySetFieldPrivate(Structure.ROW, row,
                                                       fieldIndex, new Field(value, true));
//#endif


//#if -1898551329
                if(!result) { //1

//#if 445829970
                    bm.undo();
//#endif

                }

//#endif

            } else {

//#if 1209133870
                bm.undo();
//#endif

            }

//#endif

        }

//#endif

    }

//#endif


//#if 1163663532
    private boolean makeSolvable(Board board, int steps)
    {

//#if 1707696959
        BoardManager bm = new BoardManager();
//#endif


//#if 1082505688
        bm.setBoard(board);
//#endif


//#if -325832252
        Random r = new Random();
//#endif


//#if 155335958
        int k = steps;
//#endif


//#if 221411221
        try { //1

//#if 591372806
            List solutions = bm.solve((Board) board.clone());
//#endif


//#if -1017011115
            boolean solvable = !solutions.isEmpty();
//#endif


//#if 1097627212
            while (k > 0) { //1

//#if -2036168616
                board.removeRandomSetField();
//#endif


//#if 959216203
                solutions = bm.solve((Board) board.clone());
//#endif


//#if -2129523577
                if(!solutions.isEmpty()) { //1

//#if -1170580258
                    return true;
//#endif

                }

//#endif


//#if 773252363
                k--;
//#endif

            }

//#endif

        }

//#if 663731355
        catch (CloneNotSupportedException e) { //1
        }
//#endif


//#endif


//#if 1407672903
        return false;
//#endif

    }

//#endif

}

//#endif


//#endif

