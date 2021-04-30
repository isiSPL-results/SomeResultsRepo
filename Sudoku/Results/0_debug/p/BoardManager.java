
//#if 624182129 
// Compilation Unit of /BoardManager.java 
 

//#if -1742872628 
package p;
//#endif 


//#if 1782088403 
import java.io.BufferedReader;
//#endif 


//#if -210647143 
import java.io.File;
//#endif 


//#if -488071018 
import java.io.FileReader;
//#endif 


//#if 1012542680 
import java.io.IOException;
//#endif 


//#if 2089395962 
import java.util.LinkedList;
//#endif 


//#if -1685473773 
import java.util.List;
//#endif 


//#if -350138477 
import java.io.FileInputStream;
//#endif 


//#if -19265864 
import java.io.FileOutputStream;
//#endif 


//#if -1683644618 
import java.io.ObjectInput;
//#endif 


//#if 1967157078 
import java.io.ObjectInputStream;
//#endif 


//#if 580631157 
import java.io.ObjectOutput;
//#endif 


//#if -1197547691 
import java.io.ObjectOutputStream;
//#endif 


//#if -500067651 
import java.util.Stack;
//#endif 


//#if 721024049 
public class BoardManager  { 

//#if 1138756774 
protected Board board;
//#endif 


//#if 769418583 
protected List sudokuViews;
//#endif 


//#if -1258310825 
@p.R4Feature(p.R4Feature.STATES)
    protected Stack history;
//#endif 


//#if 1615037891 
@p.R4Feature(p.R4Feature.SOLVER)
    protected boolean busy;
//#endif 


//#if 1213096414 

//#if 878545337 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    protected void setBusy(boolean busy)
    { 

//#if -415548281 
for (int i = 0; i < sudokuViews.size(); i++) //1
{ 

//#if -1228736273 
((Gui) sudokuViews.get(i)).setBusy(busy);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1835665427 
public void loadFile(File f) throws IOException
    { 

//#if 971683418 
preLoadWrapper();
//#endif 


//#if 654541671 
board = new Board();
//#endif 


//#if -1931873462 
BufferedReader fileReader = new BufferedReader(new FileReader(f));
//#endif 


//#if 569544732 
int digit = (Field.POSSIBILITIES / 10) + 1;
//#endif 


//#if 1165740807 
int row = 0;
//#endif 


//#if 1264531062 
while (row < Field.POSSIBILITIES) //1
{ 

//#if 2109631081 
String sudokuLine = fileReader.readLine();
//#endif 


//#if -545767680 
int value;
//#endif 


//#if 865597959 
char c;
//#endif 


//#if 463027355 
int extendedInt;
//#endif 


//#if 2114042400 
char extendedC;
//#endif 


//#if 2132270622 
if(digit == 1)//1
{ 

//#if 946513490 
for (int i = 0; i < Field.POSSIBILITIES; i++) //1
{ 

//#if 537345047 
c = sudokuLine.charAt(i);
//#endif 


//#if 768202726 
if(c != '.')//1
{ 

//#if -982453129 
value = Integer.parseInt(Character.toString(c));
//#endif 


//#if -383206501 
setFieldPrivate(Structure.ROW, row, i, new Field(value,
                                        true));
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -1908867729 
if(digit == 2)//1
{ 

//#if 1133306678 
for (int i = 0; i < Field.POSSIBILITIES * digit; i = i + digit) //1
{ 

//#if -330323728 
c = sudokuLine.charAt(i);
//#endif 


//#if 1275997981 
extendedC = sudokuLine.charAt(i + 1);
//#endif 


//#if -1131229185 
if(c != '.')//1
{ 

//#if 640953306 
value = Integer.parseInt(Character.toString(c)) * 10;
//#endif 


//#if -1922445849 
extendedInt = Integer.parseInt(Character
                                                       .toString(extendedC));
//#endif 


//#if 1113072756 
value += extendedInt;
//#endif 


//#if 1910838838 
setFieldPrivate(Structure.ROW, row, (i / digit),
                                        new Field(value, true));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#if 1302085306 
row++;
//#endif 

} 

//#endif 


//#if -1296538782 
updateSudokuViews();
//#endif 

} 

//#endif 


//#if 1018499275 
public void registerSudokuView(Gui f)
    { 

//#if -755135995 
sudokuViews.add(f);
//#endif 


//#if 755805345 
updateSudokuViews();
//#endif 

} 

//#endif 


//#if -205981302 

//#if -856384726 
@p.R4Feature(p.R4Feature.STATES)
//#endif 


    public void loadState(File f) throws IOException, ClassNotFoundException
    { 

//#if -779137656 
ObjectInput i = new ObjectInputStream(new FileInputStream(f));
//#endif 


//#if 83931573 
board = (Board) i.readObject();
//#endif 


//#if 725191081 
history = (Stack) i.readObject();
//#endif 


//#if 1106688661 
updateSudokuViews();
//#endif 

} 

//#endif 


//#if 917995916 

//#if -1141446444 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    public boolean tryLoadFile(File f) throws IOException
    { 

//#if -1770832056 
preLoadWrapper();
//#endif 


//#if -2087973803 
board = new Board();
//#endif 


//#if 1714114360 
BufferedReader fileReader = new BufferedReader(new FileReader(f));
//#endif 


//#if 2059555950 
int digit = (Field.POSSIBILITIES / 10) + 1;
//#endif 


//#if -602201611 
int row = 0;
//#endif 


//#if -742120604 
while (row < Field.POSSIBILITIES) //1
{ 

//#if -948016280 
String sudokuLine = fileReader.readLine();
//#endif 


//#if 155760703 
int value;
//#endif 


//#if 1894850856 
char c;
//#endif 


//#if -2146202982 
int extendedInt;
//#endif 


//#if -602525631 
char extendedC;
//#endif 


//#if -476959715 
if(digit == 1)//1
{ 

//#if 1963517195 
for (int i = 0; i < Field.POSSIBILITIES; i++) //1
{ 

//#if -647965486 
c = sudokuLine.charAt(i);
//#endif 


//#if -414380447 
if(c != '.')//1
{ 

//#if -1527567980 
value = Integer.parseInt(Character.toString(c));
//#endif 


//#if -669158192 
if(!trySetFieldPrivate(Structure.ROW, row, i,
                                                new Field(value, true)))//1
{ 

//#if -61101623 
board = null;
//#endif 


//#if -1563085664 
updateSudokuViews();
//#endif 


//#if -685315012 
return false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if 212832212 
if(digit == 2)//1
{ 

//#if -1700050298 
for (int i = 0; i < Field.POSSIBILITIES * digit; i = i + digit) //1
{ 

//#if -439006408 
c = sudokuLine.charAt(i);
//#endif 


//#if 2093193061 
extendedC = sudokuLine.charAt(i + 1);
//#endif 


//#if -983875455 
if(c != '.' && extendedC != '.')//1
{ 

//#if -1782023158 
value = Integer.parseInt(Character.toString(c)) * 10;
//#endif 


//#if 1314029495 
extendedInt = Integer.parseInt(Character
                                                       .toString(extendedC));
//#endif 


//#if 230025380 
value += extendedInt;
//#endif 


//#if -1138764480 
if(!trySetFieldPrivate(Structure.ROW, row,
                                                (i / digit), new Field(value, true)))//1
{ 

//#if -199867222 
board = null;
//#endif 


//#if -1628158241 
updateSudokuViews();
//#endif 


//#if -692081285 
return false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#if -1963629093 
row++;
//#endif 

} 

//#endif 


//#if -412152908 
updateSudokuViews();
//#endif 


//#if -1318038123 
return true;
//#endif 

} 

//#endif 


//#if -1375544287 
public void preLoadWrapper()
    { 

//#if 1251058985 
if(p.R4Feature.STATES)//1
{ 

//#if 1320035398 
history.clear();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1312799684 

//#if -596917788 
@p.R4Feature(p.R4Feature.EXTENDED)
//#endif 


    public void setPossibilities(int possibilities)
    { 

//#if 913565748 
Field.POSSIBILITIES = possibilities;
//#endif 


//#if 1661679095 
this.board = null;
//#endif 


//#if 190969206 
updateSudokuViews();
//#endif 

} 

//#endif 


//#if -626215641 

//#if -1206176618 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    public boolean solutionHint()
    { 

//#if -495687434 
if(board.isSolved())//1
{ 

//#if 303374522 
return true;
//#endif 

} 

//#endif 


//#if -1801950677 
try //1
{ 

//#if 1862058433 
setBusy(true);
//#endif 


//#if -292947845 
List solutions = solve((Board) board.clone());
//#endif 


//#if -1545879967 
if(solutions.isEmpty())//1
{ 

//#if -783158307 
setBusy(false);
//#endif 


//#if -1090938925 
return false;
//#endif 

} 

//#endif 


//#if -918581243 
for (int i = 0; i < Field.POSSIBILITIES; i++)//1
{ 

//#if 240866358 
for (int j = 0; j < Field.POSSIBILITIES; j++)//1
{ 

//#if -1510778179 
if(!board.getField(Structure.ROW, i, j).isSet()
                            && ((Board) solutions.get(0)).getField(
                                Structure.ROW, i, j).isSet())//1
{ 

//#if -2111356241 
trySetField(Structure.ROW, i, j,
                                    ((Board) solutions.get(0)).getField(
                                        Structure.ROW, i, j));
//#endif 


//#if -1242165804 
updateSudokuViews();
//#endif 


//#if -264736907 
return true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1854553908 
setBusy(false);
//#endif 

} 

//#if -1933351246 
catch (CloneNotSupportedException e)//1
{
}
//#endif 


//#endif 


//#if -1636397987 
return false;
//#endif 

} 

//#endif 


//#if -1951432741 

//#if -2086099315 
@p.R4Feature(p.R4Feature.UNDO)
//#endif 


    public void undo()
    { 

//#if 1025727199 
if(!history.empty())//1
{ 

//#if 1134395257 
board = (Board) history.pop();
//#endif 


//#if -1654487766 
updateSudokuViews();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -831605590 
public BoardManager()
    { 

//#if -1205346604 
sudokuViews = new LinkedList();
//#endif 


//#if 973120866 
if(p.R4Feature.STATES)//1
{ 

//#if 1064392148 
history = new Stack();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 680179539 

//#if -129393197 
@p.R4Feature(p.R4Feature.STATES)
//#endif 


    public void saveState(File f) throws IOException
    { 

//#if -270290018 
ObjectOutput o = new ObjectOutputStream(new FileOutputStream(f));
//#endif 


//#if -1013441484 
o.writeObject(getBoard());
//#endif 


//#if 825181525 
o.writeObject(history);
//#endif 


//#if 1563339913 
o.close();
//#endif 

} 

//#endif 


//#if -126331589 
public void setBoard(Board board)
    { 

//#if -1554864212 
this.board = board;
//#endif 

} 

//#endif 


//#if -1018383763 

//#if -259641083 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    protected List solve(Board board)
    { 

//#if -1777288628 
List solutions = new LinkedList();
//#endif 


//#if 1379869670 
List solvers = new LinkedList();
//#endif 


//#if 788253681 
solvers.add(new ForcedField());
//#endif 


//#if 2043720504 
solvers.add(new ForcedNumber());
//#endif 


//#if -234148319 
Guesser guesser = new Guesser();
//#endif 


//#if 796332448 
for (int i = 0; i < solvers.size(); i++)//1
{ 

//#if -460626282 
if(!((Solver) solvers.get(i)).trySolve(board))//1
{ 

//#if 341843381 
return solutions;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -229110210 
if(!board.isSolved())//1
{ 

//#if -1565714441 
List guessed = guesser.guess(board);
//#endif 


//#if 290948913 
for (int i = 0; i < guessed.size(); i++) //1
{ 

//#if -1883835438 
solutions.addAll(solve(((Board) guessed.get(i))));
//#endif 

} 

//#endif 

} 
else
{ 

//#if -528680000 
solutions.add(board);
//#endif 

} 

//#endif 


//#if 1699811417 
return solutions;
//#endif 

} 

//#endif 


//#if -712647117 

//#if -1412608939 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    public boolean trySetField(Structure structure, int structNr, int element,
                               Field f)
    { 

//#if 369231279 
preSetFieldWrapper(structure, structNr, element, f);
//#endif 


//#if -453173838 
boolean set = trySetFieldPrivate(structure, structNr, element, f);
//#endif 


//#if -169317586 
if(set)//1
{ 

//#if 1612160591 
updateSudokuViews();
//#endif 


//#if 1607096474 
return true;
//#endif 

} 
else
{ 

//#if -1666892081 
undo();
//#endif 


//#if -1286722193 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2049905350 
protected void updateSudokuViews()
    { 

//#if -118171488 
for (int i = 0; i < sudokuViews.size(); i++) //1
{ 

//#if -736431489 
((Gui) sudokuViews.get(i)).update(getBoard());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 380243892 

//#if -1841244683 
@p.R4Feature(p.R4Feature.GENERATOR)
//#endif 


    public void loadSudoku(Board board)
    { 

//#if 136359387 
preLoadWrapper();
//#endif 


//#if 1255416103 
this.board = board;
//#endif 


//#if -1394233279 
updateSudokuViews();
//#endif 

} 

//#endif 


//#if 1867629449 

//#if -1620794928 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    protected boolean trySetFieldPrivate(Structure structure, int structNr,
                                         int element, Field f)
    { 

//#if -1788808503 
return board.trySetField(structure, structNr, element, f);
//#endif 

} 

//#endif 


//#if 392216244 
public void preSetFieldWrapper(Structure structure, int structNr,
                                   int element, Field f)
    { 

//#if -1614578510 
if(p.R4Feature.STATES)//1
{ 

//#if 552039865 
try
               // #if STATES
            //1
{ 

//#if -2090663277 
history.push(board.clone());
//#endif 

} 

//#if 2039288406 
catch (CloneNotSupportedException e)//1
{
}
//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 223620436 
public void setField(Structure structure, int structNr, int element, Field f)
    { 

//#if 819694946 
preSetFieldWrapper(structure, structNr, element, f);
//#endif 


//#if -271224729 
setFieldPrivate(structure, structNr, element, f);
//#endif 


//#if 70600968 
updateSudokuViews();
//#endif 

} 

//#endif 


//#if 1842311944 
protected void setFieldPrivate(Structure structure, int structNr,
                                   int element, Field f)
    { 

//#if -1215267098 
board.setField(structure, structNr, element, f);
//#endif 

} 

//#endif 


//#if -786007720 
public Field getField(Structure structure, int structNr, int element)
    { 

//#if 1502870605 
return getBoard().getField(structure, structNr, element);
//#endif 

} 

//#endif 


//#if 885277269 
public Board getBoard()
    { 

//#if -813258754 
return this.board;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

