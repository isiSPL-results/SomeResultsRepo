
//#if -1809029231 
// Compilation Unit of /Actions.java 
 

//#if -1572694968 
import java.io.*;
//#endif 


//#if -1566645204 
import java.util.*;
//#endif 


//#if -1154463226 
import java.awt.event.*;
//#endif 


//#if 1877960980 
import javax.swing.*;
//#endif 


//#if 338041444 
public class Actions  { 

//#if 299809109 
private int returnVal;
//#endif 


//#if 957443963 
private int option;
//#endif 


//#if 960574879 
private String fileContent = null;
//#endif 


//#if -88447053 
private String fileName = null;
//#endif 


//#if 757865030 
private JFileChooser jfc = new JFileChooser(".");
//#endif 


//#if 1875193073 
private ExampleFileFilter filter = new ExampleFileFilter();
//#endif 


//#if 1141525423 
Notepad n;
//#endif 


//#if -1075176956 
public Fonts font = new Fonts();
//#endif 


//#if 463928803 
private String findword;
//#endif 


//#if 2144783034 
public void save()
    { 

//#if 700608312 
try //1
{ 

//#if 1673746745 
PrintWriter fout = new PrintWriter(new FileWriter(jfc.getSelectedFile()));
//#endif 


//#if -1348370341 
fileContent = n.getTextArea().getText();
//#endif 


//#if 560153246 
StringTokenizer st=new StringTokenizer(fileContent,System.getProperty("line.separator"));
//#endif 


//#if -1042089053 
while(st.hasMoreTokens()) //1
{ 

//#if -342817422 
fout.println(st.nextToken());
//#endif 

} 

//#endif 


//#if -707520703 
fout.close();
//#endif 

} 

//#if 14954488 
catch(IOException ioe)//1
{ 

//#if 317475356 
System.err.println("I/O Error on Save");
//#endif 

} 

//#endif 


//#endif 


//#if 1521678851 
n.setTitle(jfc.getSelectedFile().getName() + " - JAVA� Notepad");
//#endif 

} 

//#endif 


//#if 1785278700 
public void fonT()
    { 

//#if 2071467478 
font.setVisible(true);
//#endif 


//#if -886929345 
font.pack();
//#endif 


//#if -1818111311 
font.getOkjb().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                n.getTextArea().setFont(font.font());
                //after we chose the font, then the JDialog will be closed
                font.setVisible(false);
            }
        });
//#endif 


//#if -951198529 
font.getCajb().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //after we cancel the, then the JDialog will be closed
                font.setVisible(false);
            }
        });
//#endif 

} 

//#endif 


//#if -601042248 
public void pastE()
    { 

//#if -1134440465 
n.getTextArea().paste();
//#endif 

} 

//#endif 


//#if 2144752282 
public void savE()
    { 

//#if 633071139 
if(fileName == null)//1
{ 

//#if -885743325 
saveAs();
//#endif 

} 
else
{ 

//#if 1203851332 
save();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2043621447 
public void open()
    { 

//#if 1906702755 
filter.addExtension("txt");
//#endif 


//#if -1991020847 
filter.setDescription("TXT Documents");
//#endif 


//#if 302938642 
jfc.setFileFilter(filter);
//#endif 


//#if -1192468759 
returnVal = jfc.showOpenDialog(n);
//#endif 


//#if 356581043 
if(returnVal == JFileChooser.APPROVE_OPTION)//1
{ 

//#if -1623162310 
n.getTextArea().setText(null);
//#endif 


//#if 1610726177 
try //1
{ 

//#if -664346025 
fileName = jfc.getSelectedFile().getPath();
//#endif 


//#if -999984064 
Reader in = new FileReader(jfc.getSelectedFile());
//#endif 


//#if -1069342609 
char[] buff = new char[100000];
//#endif 


//#if 1881384466 
int nch;
//#endif 


//#if 2109517491 
while((nch = in.read(buff, 0, buff.length)) != -1) //1
{ 

//#if 1502650349 
n.getTextArea().append(new String(buff, 0, nch));
//#endif 

} 

//#endif 


//#if -523145895 
fileContent = n.getTextArea().getText();
//#endif 

} 

//#if 264036579 
catch(FileNotFoundException x)//1
{
}
//#endif 


//#if 1566766565 
catch(IOException ioe)//1
{ 

//#if 374915885 
System.err.println("I/O Error on Open");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 208671920 
n.setTitle(jfc.getSelectedFile().getName() + " - JAVA� Notepad");
//#endif 

} 

//#endif 


//#if -663393367 
public void findNexT()
    { 

//#if 385390660 
n.getTextArea().select(n.getTextArea().getText().indexOf(findword,(int)n.getTextArea().getText().indexOf(findword)+1),
                               n.getTextArea().getText().indexOf(findword,(int)n.getTextArea().getText().indexOf(findword)+1));
//#endif 

} 

//#endif 


//#if -685991621 
public void lineWraP()
    { 

//#if 1853148721 
if(n.getLineWrap().isSelected())//1
{ 

//#if -640229074 
n.getTextArea().setLineWrap(true);
//#endif 


//#if -1869804621 
n.getTextArea().setWrapStyleWord(true);
//#endif 

} 
else
{ 

//#if -1918136968 
n.getTextArea().setLineWrap(false);
//#endif 


//#if 1946031633 
n.getTextArea().setWrapStyleWord(false);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1182269563 
public void neW()
    { 

//#if 39045528 
if(!n.getTextArea().getText().equals("") && !n.getTextArea().getText().equals(fileContent))//1
{ 

//#if 461545689 
if(fileName == null)//1
{ 

//#if -1660815273 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
//#endif 


//#if 587172464 
if(option == 0)//1
{ 

//#if 398901163 
saveAs();
//#endif 


//#if -1987209336 
n.getTextArea().setText("");
//#endif 

} 

//#endif 


//#if 588095985 
if(option == 1)//1
{ 

//#if -2036525703 
n.getTextArea().setText("");
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1686350266 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
//#endif 


//#if 1427995041 
if(option == 0)//1
{ 

//#if -1063298800 
save();
//#endif 


//#if 1130534485 
n.getTextArea().setText("");
//#endif 

} 

//#endif 


//#if 1428918562 
if(option == 1)//1
{ 

//#if -789369942 
n.getTextArea().setText("");
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if -1249597002 
n.getTextArea().setText("");
//#endif 

} 

//#endif 


//#if -1624933764 
n.setTitle("Untitled - JAVA� Notepad");
//#endif 

} 

//#endif 


//#if -123746222 
public void prinT()
    { 

//#if -735727588 
Print.printComponent(n.getTextArea());
//#endif 

} 

//#endif 


//#if 1779722198 
public void finD()
    { 

//#if 444349459 
try //1
{ 

//#if -1715176920 
findword = JOptionPane.showInputDialog("Type the word to find");
//#endif 


//#if 497405434 
while(n.getTextArea().getText().indexOf(findword) == -1) //1
{ 

//#if 2121675943 
JOptionPane.showMessageDialog(null,"Word not found!","No match",JOptionPane.WARNING_MESSAGE);
//#endif 


//#if -775264215 
findword = JOptionPane.showInputDialog("Type the word to find");
//#endif 

} 

//#endif 


//#if -1964876103 
n.getTextArea().select(n.getTextArea().getText().indexOf(findword),
                                   n.getTextArea().getText().indexOf(findword) + findword.length());
//#endif 

} 

//#if -2064983511 
catch(Exception ex)//1
{ 

//#if -1639509349 
JOptionPane.showMessageDialog(null,"Search canceled","Abourted",JOptionPane.WARNING_MESSAGE);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1191954521 
public void cuT()
    { 

//#if 689069674 
n.getTextArea().cut();
//#endif 

} 

//#endif 


//#if -1585902390 
public void selectALL()
    { 

//#if 1162753006 
n.getTextArea().selectAll();
//#endif 

} 

//#endif 


//#if -446989236 
public void saveAs()
    { 

//#if 33295889 
filter.addExtension("txt");
//#endif 


//#if -1233262173 
filter.setDescription("TXT Documents");
//#endif 


//#if 1905074148 
jfc.setFileFilter(filter);
//#endif 


//#if -1618782546 
returnVal = jfc.showSaveDialog(n);
//#endif 


//#if 720376737 
if(returnVal == JFileChooser.APPROVE_OPTION)//1
{ 

//#if -2095076073 
PrintWriter fout = null;
//#endif 


//#if 1750905502 
try //1
{ 

//#if -1693268264 
fout = new PrintWriter(new FileWriter(jfc.getSelectedFile() + ".txt"));
//#endif 


//#if 244328745 
fileContent = n.getTextArea().getText();
//#endif 


//#if 1061737607 
fileName = jfc.getSelectedFile().getPath();
//#endif 


//#if -1078114416 
StringTokenizer st=new StringTokenizer(fileContent,System.getProperty("line.separator"));
//#endif 


//#if 1515826673 
while(st.hasMoreTokens()) //1
{ 

//#if 726672872 
fout.println(st.nextToken());
//#endif 

} 

//#endif 


//#if 1801769651 
fout.close();
//#endif 

} 

//#if -45763483 
catch(IOException ioe)//1
{ 

//#if 1156128491 
System.err.println ("I/O Error on Save");
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 500352514 
n.setTitle(jfc.getSelectedFile().getName() + " - JAVA� Notepad");
//#endif 

} 

//#endif 


//#if -1003716302 
public void abouT()
    { 

//#if -161031510 
JOptionPane.showMessageDialog(null, new About(),"About Notepad",JOptionPane.PLAIN_MESSAGE);
//#endif 

} 

//#endif 


//#if 347596809 
public Actions(Notepad n)
    { 

//#if 1650670412 
this.n = n;
//#endif 

} 

//#endif 


//#if 1699455634 
public void copY()
    { 

//#if -102486328 
n.getTextArea().copy();
//#endif 

} 

//#endif 


//#if 2043590695 
public void opeN()
    { 

//#if 1148373924 
if(!n.getTextArea().getText().equals("") && !n.getTextArea().getText().equals(fileContent))//1
{ 

//#if -107730345 
if(fileName == null)//1
{ 

//#if 946946866 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
//#endif 


//#if 418581301 
if(option == 0)//1
{ 

//#if -1830900670 
saveAs();
//#endif 


//#if 1116803175 
open();
//#endif 

} 

//#endif 


//#if 419504822 
if(option == 1)//1
{ 

//#if 1490399758 
open();
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1140379017 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
//#endif 


//#if -1633047472 
if(option == 0)//1
{ 

//#if 2077301279 
save();
//#endif 


//#if -1058707918 
open();
//#endif 

} 

//#endif 


//#if -1632123951 
if(option == 1)//1
{ 

//#if 1987055850 
open();
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if 1289956256 
open();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1764812283 
public void exiT()
    { 

//#if 1212240213 
if(!n.getTextArea().getText().equals("") && !n.getTextArea().getText().equals(fileContent))//1
{ 

//#if 66843705 
if(fileName == null)//1
{ 

//#if 2015758719 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
//#endif 


//#if 1509956680 
if(option == 0)//1
{ 

//#if -533405401 
saveAs();
//#endif 


//#if 1223197907 
System.exit(0);
//#endif 

} 

//#endif 


//#if 1510880201 
if(option == 1)//1
{ 

//#if -542186817 
System.exit(0);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1155237701 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
//#endif 


//#if -423005812 
if(option == 0)//1
{ 

//#if 399251797 
save();
//#endif 


//#if 1719997359 
System.exit(0);
//#endif 

} 

//#endif 


//#if -422082291 
if(option == 1)//1
{ 

//#if -1418525136 
System.exit(0);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if 230093127 
System.exit(0);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

