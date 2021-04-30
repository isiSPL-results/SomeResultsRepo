package p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Stack;
public class BoardManager
{
    protected Board board;
    protected List sudokuViews;
    @p.R4Feature(p.R4Feature.STATES)
    protected Stack history;
    @p.R4Feature(p.R4Feature.SOLVER)
    protected boolean busy;
    @p.R4Feature(p.R4Feature.SOLVER)

    protected void setBusy(boolean busy)
    {
        for (int i = 0; i < sudokuViews.size(); i++) { //1
            ((Gui) sudokuViews.get(i)).setBusy(busy);
        }
    }
    public void loadFile(File f) throws IOException
    {
        preLoadWrapper();
        board = new Board();
        BufferedReader fileReader = new BufferedReader(new FileReader(f));
        int digit = (Field.POSSIBILITIES / 10) + 1;
        int row = 0;
        while (row < Field.POSSIBILITIES) { //1
            String sudokuLine = fileReader.readLine();
            int value;
            char c;
            int extendedInt;
            char extendedC;
            if(digit == 1) { //1
                for (int i = 0; i < Field.POSSIBILITIES; i++) { //1
                    c = sudokuLine.charAt(i);
                    if(c != '.') { //1
                        value = Integer.parseInt(Character.toString(c));
                        setFieldPrivate(Structure.ROW, row, i, new Field(value,
                                        true));
                    }
                }
            } else if(digit == 2) { //1
                for (int i = 0; i < Field.POSSIBILITIES * digit; i = i + digit) { //1
                    c = sudokuLine.charAt(i);
                    extendedC = sudokuLine.charAt(i + 1);
                    if(c != '.') { //1
                        value = Integer.parseInt(Character.toString(c)) * 10;
                        extendedInt = Integer.parseInt(Character
                                                       .toString(extendedC));
                        value += extendedInt;
                        setFieldPrivate(Structure.ROW, row, (i / digit),
                                        new Field(value, true));
                    }
                }
            }
            row++;
        }
        updateSudokuViews();
    }
    public void registerSudokuView(Gui f)
    {
        sudokuViews.add(f);
        updateSudokuViews();
    }
    @p.R4Feature(p.R4Feature.STATES)

    public void loadState(File f) throws IOException, ClassNotFoundException
    {
        ObjectInput i = new ObjectInputStream(new FileInputStream(f));
        board = (Board) i.readObject();
        history = (Stack) i.readObject();
        updateSudokuViews();
    }
    @p.R4Feature(p.R4Feature.SOLVER)

    public boolean tryLoadFile(File f) throws IOException
    {
        preLoadWrapper();
        board = new Board();
        BufferedReader fileReader = new BufferedReader(new FileReader(f));
        int digit = (Field.POSSIBILITIES / 10) + 1;
        int row = 0;
        while (row < Field.POSSIBILITIES) { //1
            String sudokuLine = fileReader.readLine();
            int value;
            char c;
            int extendedInt;
            char extendedC;
            if(digit == 1) { //1
                for (int i = 0; i < Field.POSSIBILITIES; i++) { //1
                    c = sudokuLine.charAt(i);
                    if(c != '.') { //1
                        value = Integer.parseInt(Character.toString(c));
                        if(!trySetFieldPrivate(Structure.ROW, row, i,
                                               new Field(value, true))) { //1
                            board = null;
                            updateSudokuViews();
                            return false;
                        }
                    }
                }
            } else if(digit == 2) { //1
                for (int i = 0; i < Field.POSSIBILITIES * digit; i = i + digit) { //1
                    c = sudokuLine.charAt(i);
                    extendedC = sudokuLine.charAt(i + 1);
                    if(c != '.' && extendedC != '.') { //1
                        value = Integer.parseInt(Character.toString(c)) * 10;
                        extendedInt = Integer.parseInt(Character
                                                       .toString(extendedC));
                        value += extendedInt;
                        if(!trySetFieldPrivate(Structure.ROW, row,
                                               (i / digit), new Field(value, true))) { //1
                            board = null;
                            updateSudokuViews();
                            return false;
                        }
                    }
                }
            }
            row++;
        }
        updateSudokuViews();
        return true;
    }
    public void preLoadWrapper()
    {
        if(p.R4Feature.STATES) { //1
            history.clear();
        }
    }
    @p.R4Feature(p.R4Feature.EXTENDED)

    public void setPossibilities(int possibilities)
    {
        Field.POSSIBILITIES = possibilities;
        this.board = null;
        updateSudokuViews();
    }
    @p.R4Feature(p.R4Feature.SOLVER)

    public boolean solutionHint()
    {
        if(board.isSolved()) { //1
            return true;
        }
        try { //1
            setBusy(true);
            List solutions = solve((Board) board.clone());
            if(solutions.isEmpty()) { //1
                setBusy(false);
                return false;
            }
            for (int i = 0; i < Field.POSSIBILITIES; i++) { //1
                for (int j = 0; j < Field.POSSIBILITIES; j++) { //1
                    if(!board.getField(Structure.ROW, i, j).isSet()
                            && ((Board) solutions.get(0)).getField(
                                Structure.ROW, i, j).isSet()) { //1
                        trySetField(Structure.ROW, i, j,
                                    ((Board) solutions.get(0)).getField(
                                        Structure.ROW, i, j));
                        updateSudokuViews();
                        return true;
                    }
                }
            }
            setBusy(false);
        } catch (CloneNotSupportedException e) { //1
        } return false;
    }
    @p.R4Feature(p.R4Feature.UNDO)

    public void undo()
    {
        if(!history.empty()) { //1
            board = (Board) history.pop();
            updateSudokuViews();
        }
    }
    public BoardManager()
    {
        sudokuViews = new LinkedList();
        if(p.R4Feature.STATES) { //1
            history = new Stack();
        }
    }
    @p.R4Feature(p.R4Feature.STATES)

    public void saveState(File f) throws IOException
    {
        ObjectOutput o = new ObjectOutputStream(new FileOutputStream(f));
        o.writeObject(getBoard());
        o.writeObject(history);
        o.close();
    }
    public void setBoard(Board board)
    {
        this.board = board;
    }
    @p.R4Feature(p.R4Feature.SOLVER)

    protected List solve(Board board)
    {
        List solutions = new LinkedList();
        List solvers = new LinkedList();
        solvers.add(new ForcedField());
        solvers.add(new ForcedNumber());
        Guesser guesser = new Guesser();
        for (int i = 0; i < solvers.size(); i++) { //1
            if(!((Solver) solvers.get(i)).trySolve(board)) { //1
                return solutions;
            }
        }
        if(!board.isSolved()) { //1
            List guessed = guesser.guess(board);
            for (int i = 0; i < guessed.size(); i++) { //1
                solutions.addAll(solve(((Board) guessed.get(i))));
            }
        } else {
            solutions.add(board);
        }
        return solutions;
    }
    @p.R4Feature(p.R4Feature.SOLVER)

    public boolean trySetField(Structure structure, int structNr, int element,
                               Field f)
    {
        preSetFieldWrapper(structure, structNr, element, f);
        boolean set = trySetFieldPrivate(structure, structNr, element, f);
        if(set) { //1
            updateSudokuViews();
            return true;
        } else {
            undo();
            return false;
        }
    }
    protected void updateSudokuViews()
    {
        for (int i = 0; i < sudokuViews.size(); i++) { //1
            ((Gui) sudokuViews.get(i)).update(getBoard());
        }
    }
    @p.R4Feature(p.R4Feature.SOLVER)

    protected boolean trySetFieldPrivate(Structure structure, int structNr,
                                         int element, Field f)
    {
        return board.trySetField(structure, structNr, element, f);
    }
    public void preSetFieldWrapper(Structure structure, int structNr,
                                   int element, Field f)
    {
        if(p.R4Feature.STATES) { //1
            try { //1
                history.push(board.clone());
            } catch (CloneNotSupportedException e) { //1
            }
        }
    }
    public void setField(Structure structure, int structNr, int element, Field f)
    {
        preSetFieldWrapper(structure, structNr, element, f);
        setFieldPrivate(structure, structNr, element, f);
        updateSudokuViews();
    }
    protected void setFieldPrivate(Structure structure, int structNr,
                                   int element, Field f)
    {
        board.setField(structure, structNr, element, f);
    }
    public Field getField(Structure structure, int structNr, int element)
    {
        return getBoard().getField(structure, structNr, element);
    }
    public Board getBoard()
    {
        return this.board;
    }

}
