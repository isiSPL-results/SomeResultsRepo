package p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
public class BoardManager  { 
protected Board board;
protected List sudokuViews;
public void loadFile(File f) throws IOException
    { 
preLoadWrapper();
board = new Board();
BufferedReader fileReader = new BufferedReader(new FileReader(f));
int digit = (Field.POSSIBILITIES / 10) + 1;
int row = 0;
while (row < Field.POSSIBILITIES) //1
{ 
String sudokuLine = fileReader.readLine();
int value;
char c;
int extendedInt;
char extendedC;
if(digit == 1)//1
{ 
for (int i = 0; i < Field.POSSIBILITIES; i++) //1
{ 
c = sudokuLine.charAt(i);
if(c != '.')//1
{ 
value = Integer.parseInt(Character.toString(c));
setFieldPrivate(Structure.ROW, row, i, new Field(value,
                                        true));
} 
} 
} 
else
if(digit == 2)//1
{ 
for (int i = 0; i < Field.POSSIBILITIES * digit; i = i + digit) //1
{ 
c = sudokuLine.charAt(i);
extendedC = sudokuLine.charAt(i + 1);
if(c != '.')//1
{ 
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
public void preLoadWrapper()
    { 
} 
public BoardManager()
    { 
sudokuViews = new LinkedList();
} 
public void setBoard(Board board)
    { 
this.board = board;
} 
protected void updateSudokuViews()
    { 
for (int i = 0; i < sudokuViews.size(); i++) //1
{ 
((Gui) sudokuViews.get(i)).update(getBoard());
} 
} 
public void preSetFieldWrapper(Structure structure, int structNr,
                                   int element, Field f)
    { 
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
