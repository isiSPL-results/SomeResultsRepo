
//#if -215558701
// Compilation Unit of /Guesser.java


//#if -122885368
package p;
//#endif


//#if -42280138
import java.util.LinkedList;
//#endif


//#if 630572879
import java.util.List;
//#endif


//#if -830175106

//#if 93054236
@p.R4Feature(p.R4Feature.SOLVER)
//#endif

public class Guesser
{

//#if -1826133855
    public List guess(Board board)
    {

//#if 1598476639
        int structIndex = -1;
//#endif


//#if 1637586632
        int elementIndex = -1;
//#endif


//#if -474793080
        for (int i = 0; i < Field.POSSIBILITIES; i++) { //1

//#if -1158294927
            for (int j = 0; j < Field.POSSIBILITIES; j++) { //1

//#if -608890010
                if(!board.getField(Structure.ROW, i, j).isSet()
                        && ((-1 == structIndex && -1 == elementIndex) || (board
                                .getField(Structure.ROW, i, j)
                                .getRemainingPos().size() < board
                                .getField(Structure.ROW, structIndex,
                                          elementIndex).getRemainingPos().size()))) { //1

//#if -1962263491
                    structIndex = i;
//#endif


//#if -445218035
                    elementIndex = j;
//#endif

                }

//#endif

            }

//#endif

        }

//#endif


//#if -354271713
        List guessed = new LinkedList();
//#endif


//#if 172406905
        for (int i = 0; i < board
                .getField(Structure.ROW, structIndex, elementIndex)
                .getRemainingPos().size(); i++) { //1

//#if 1610597673
            try { //1

//#if -260753027
                Board guess = (Board) board.clone();
//#endif


//#if 1420532773
                if(guess
                        .trySetField(
                            Structure.ROW,
                            structIndex,
                            elementIndex,
                            new Field((Integer) board
                                      .getField(Structure.ROW, structIndex,
                                                elementIndex).getRemainingPos()
                                      .get(i)))) { //1

//#if 1925285541
                    guessed.add(guess);
//#endif

                }

//#endif

            }

//#if -1534065562
            catch (CloneNotSupportedException e) { //1
            }
//#endif


//#endif

        }

//#endif


//#if -85930260
        return guessed;
//#endif

    }

//#endif

}

//#endif


//#endif

