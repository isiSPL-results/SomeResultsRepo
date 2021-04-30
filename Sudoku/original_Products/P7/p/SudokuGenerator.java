package p;

//#if GENERATOR
//@import java.util.List;
//@import java.util.Random;
//@
//@@p.R4Feature(p.R4Feature.GENERATOR)
//@public class SudokuGenerator
//@{
//@    public Board generate()
//@    {
//@        Board board = new Board();
//@        fillBoard(board);
//@        makeSolvable(board, 50);
//@        return board;
//@    }
//@
//@    private void fillBoard(Board board)
//@    {
//@        BoardManager bm = new BoardManager();
//@        Random r = new Random();
//@        bm.setBoard(board);
//@        int fieldsToFill = Field.POSSIBILITIES * Field.POSSIBILITIES;
//@        for (int i = 0; i < fieldsToFill; i++) {
//@            int row = r.nextInt(Field.POSSIBILITIES);
//@            int fieldIndex = r.nextInt(Field.POSSIBILITIES);
//@            Field f = bm.getField(Structure.ROW, row, fieldIndex);
//@            List remainingPos = null;
//@            //if(p.R4Feature.SOLVER) {
//@            remainingPos = f
//@                           .getRemainingPos();
//@            //}
//@            if (remainingPos.size() > 0) {
//@                int value = (Integer) remainingPos.get(r.nextInt(remainingPos
//@                                                       .size()));
//@                boolean result = bm.trySetFieldPrivate(Structure.ROW, row,
//@                                                       fieldIndex, new Field(value, true));
//@                if (!result) {
//@                    bm.undo();
//@                }
//@            } else {
//@                bm.undo();
//@            }
//@        }
//@    }
//@
//@    private boolean makeSolvable(Board board, int steps)
//@    {
//@        BoardManager bm = new BoardManager();
//@        bm.setBoard(board);
//@        Random r = new Random();
//@        int k = steps;
//@        try {
//@            List solutions = bm.solve((Board) board.clone());
//@            boolean solvable = !solutions.isEmpty();
//@            while (k > 0) {
//@                board.removeRandomSetField();
//@                solutions = bm.solve((Board) board.clone());
//@                if (!solutions.isEmpty()) {
//@                    return true;
//@                }
//@                k--;
//@            }
//@        } catch (CloneNotSupportedException e) {
//@        }
//@        return false;
//@    }
//@}
// #endif
