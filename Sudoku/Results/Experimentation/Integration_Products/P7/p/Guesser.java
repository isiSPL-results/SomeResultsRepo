package p;
import java.util.LinkedList;
import java.util.List;
@p.R4Feature(p.R4Feature.SOLVER)
public class Guesser
{
    public List guess(Board board)
    {
        int structIndex = -1;
        int elementIndex = -1;
        for (int i = 0; i < Field.POSSIBILITIES; i++) { //1
            for (int j = 0; j < Field.POSSIBILITIES; j++) { //1
                if(!board.getField(Structure.ROW, i, j).isSet()
                        && ((-1 == structIndex && -1 == elementIndex) || (board
                                .getField(Structure.ROW, i, j)
                                .getRemainingPos().size() < board
                                .getField(Structure.ROW, structIndex,
                                          elementIndex).getRemainingPos().size()))) { //1
                    structIndex = i;
                    elementIndex = j;
                }
            }
        }
        List guessed = new LinkedList();
        for (int i = 0; i < board
                .getField(Structure.ROW, structIndex, elementIndex)
                .getRemainingPos().size(); i++) { //1
            try { //1
                Board guess = (Board) board.clone();
                if(guess
                        .trySetField(
                            Structure.ROW,
                            structIndex,
                            elementIndex,
                            new Field((Integer) board
                                      .getField(Structure.ROW, structIndex,
                                                elementIndex).getRemainingPos()
                                      .get(i)))) { //1
                    guessed.add(guess);
                }
            } catch (CloneNotSupportedException e) { //1
            }
        }
        return guessed;
    }

}
