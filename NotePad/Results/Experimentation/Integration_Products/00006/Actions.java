import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class Actions  { 
private int returnVal;
private int option;
private String fileContent = null;
private String fileName = null;
private JFileChooser jfc = new JFileChooser(".");
private ExampleFileFilter filter = new ExampleFileFilter();
Notepad n;
public Fonts font = new Fonts();
public void save()
    { 
try//1
{ 
PrintWriter fout = new PrintWriter(new FileWriter(jfc.getSelectedFile()));
fileContent = n.getTextArea().getText();
StringTokenizer st=new StringTokenizer(fileContent,System.getProperty("line.separator"));
while(st.hasMoreTokens()) //1
{ 
fout.println(st.nextToken());
} 
fout.close();
} 
catch(IOException ioe)//1
{ 
System.err.println("I/O Error on Save");
} 
n.setTitle(jfc.getSelectedFile().getName() + " - JAVA� Notepad");
} 
public void fonT()
    { 
font.setVisible(true);
font.pack();
font.getOkjb().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                n.getTextArea().setFont(font.font());
                //after we chose the font, then the JDialog will be closed
                font.setVisible(false);
            }
        });
font.getCajb().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //after we cancel the, then the JDialog will be closed
                font.setVisible(false);
            }
        });
} 
public void savE()
    { 
if(fileName == null)//1
{ 
saveAs();
} 
else
{ 
save();
} 
} 
public void open()
    { 
filter.addExtension("txt");
filter.setDescription("TXT Documents");
jfc.setFileFilter(filter);
returnVal = jfc.showOpenDialog(n);
if(returnVal == JFileChooser.APPROVE_OPTION)//1
{ 
n.getTextArea().setText(null);
try//1
{ 
fileName = jfc.getSelectedFile().getPath();
Reader in = new FileReader(jfc.getSelectedFile());
char[] buff = new char[100000];
int nch;
while((nch = in.read(buff, 0, buff.length)) != -1) //1
{ 
n.getTextArea().append(new String(buff, 0, nch));
} 
fileContent = n.getTextArea().getText();
} 
catch(FileNotFoundException x)//1
{
}catch(IOException ioe)//1
{ 
System.err.println("I/O Error on Open");
} 
} 
n.setTitle(jfc.getSelectedFile().getName() + " - JAVA� Notepad");
} 
public void lineWraP()
    { 
if(n.getLineWrap().isSelected())//1
{ 
n.getTextArea().setLineWrap(true);
n.getTextArea().setWrapStyleWord(true);
} 
else
{ 
n.getTextArea().setLineWrap(false);
n.getTextArea().setWrapStyleWord(false);
} 
} 
public void neW()
    { 
if(!n.getTextArea().getText().equals("") && !n.getTextArea().getText().equals(fileContent))//1
{ 
if(fileName == null)//1
{ 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
if(option == 0)//1
{ 
saveAs();
n.getTextArea().setText("");
} 
if(option == 1)//1
{ 
n.getTextArea().setText("");
} 
} 
else
{ 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
if(option == 0)//1
{ 
save();
n.getTextArea().setText("");
} 
if(option == 1)//1
{ 
n.getTextArea().setText("");
} 
} 
} 
else
{ 
n.getTextArea().setText("");
} 
n.setTitle("Untitled - JAVA� Notepad");
} 
public void prinT()
    { 
Print.printComponent(n.getTextArea());
} 
public void selectALL()
    { 
n.getTextArea().selectAll();
} 
public void saveAs()
    { 
filter.addExtension("txt");
filter.setDescription("TXT Documents");
jfc.setFileFilter(filter);
returnVal = jfc.showSaveDialog(n);
if(returnVal == JFileChooser.APPROVE_OPTION)//1
{ 
PrintWriter fout = null;
try//1
{ 
fout = new PrintWriter(new FileWriter(jfc.getSelectedFile() + ".txt"));
fileContent = n.getTextArea().getText();
fileName = jfc.getSelectedFile().getPath();
StringTokenizer st=new StringTokenizer(fileContent,System.getProperty("line.separator"));
while(st.hasMoreTokens()) //1
{ 
fout.println(st.nextToken());
} 
fout.close();
} 
catch(IOException ioe)//1
{ 
System.err.println ("I/O Error on Save");
} 
} 
n.setTitle(jfc.getSelectedFile().getName() + " - JAVA� Notepad");
} 
public void abouT()
    { 
JOptionPane.showMessageDialog(null, new About(),"About Notepad",JOptionPane.PLAIN_MESSAGE);
} 
public Actions(Notepad n)
    { 
this.n = n;
} 
public void opeN()
    { 
if(!n.getTextArea().getText().equals("") && !n.getTextArea().getText().equals(fileContent))//1
{ 
if(fileName == null)//1
{ 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
if(option == 0)//1
{ 
saveAs();
open();
} 
if(option == 1)//1
{ 
open();
} 
} 
else
{ 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
if(option == 0)//1
{ 
save();
open();
} 
if(option == 1)//1
{ 
open();
} 
} 
} 
else
{ 
open();
} 
} 
public void exiT()
    { 
if(!n.getTextArea().getText().equals("") && !n.getTextArea().getText().equals(fileContent))//1
{ 
if(fileName == null)//1
{ 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
if(option == 0)//1
{ 
saveAs();
System.exit(0);
} 
if(option == 1)//1
{ 
System.exit(0);
} 
} 
else
{ 
option = JOptionPane.showConfirmDialog(null,"Do you want to save the changes ??");
if(option == 0)//1
{ 
save();
System.exit(0);
} 
if(option == 1)//1
{ 
System.exit(0);
} 
} 
} 
else
{ 
System.exit(0);
} 
} 

 } 
