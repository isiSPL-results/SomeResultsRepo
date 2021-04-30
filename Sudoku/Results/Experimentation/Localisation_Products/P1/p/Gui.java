package p;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
public class Gui extends JFrame
  { 
protected GuiBoard guiBoard;
protected ListenerFactory listenerFactory;
protected void update(Board b)
    { 
getGlassPane().setVisible(true);
if(null != b)//1
{ 
if(null == guiBoard)//1
{ 
guiBoard = new GuiBoard(listenerFactory);
getContentPane().add(guiBoard);
} 
guiBoard.update(b);
} 
else
{ 
if(null != guiBoard)//1
{ 
getContentPane().remove(guiBoard);
guiBoard = null;
} 
} 
pack();
getGlassPane().setVisible(false);
} 
protected void createAndShowGUI()
    { 
setTitle("Sudoku");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
pack();
setResizable(false);
setVisible(true);
} 
protected JMenu createFileMenu()
    { 
JMenu fileMenu = new JMenu();
fileMenu.setText("File");
fileMenu.add(createLoadMenuItem());
fileMenu.add(createExitMenuItem());
return fileMenu;
} 
protected JMenuItem createExitMenuItem()
    { 
JMenuItem exitMenuItem = new JMenuItem();
exitMenuItem.setText("Exit");
exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                                    Event.CTRL_MASK, true));
exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
return exitMenuItem;
} 
protected JMenuBar createMenuBar()
    { 
JMenuBar menuBar = new JMenuBar();
menuBar.add(createFileMenu());
menuBar.add(createOptionsMenu());
return menuBar;
} 
protected JMenu createOptionsMenu()
    { 
JMenu optionsMenu = new JMenu();
optionsMenu.setText("Options");
return optionsMenu;
} 
protected JPanel createContentPane()
    { 
JPanel pane = new JPanel();
pane.setLayout(new BorderLayout());
return pane;
} 
public Gui(ListenerFactory listenerFactory)
    { 
super();
this.listenerFactory = listenerFactory;
setContentPane(createContentPane());
setJMenuBar(createMenuBar());
} 
protected JMenuItem createLoadMenuItem()
    { 
JMenuItem loadMenuItem = new JMenuItem();
loadMenuItem.setText("Load");
loadMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
                                    Event.CTRL_MASK, true));
loadMenuItem.addActionListener(listenerFactory.getLoadFileListener());
return loadMenuItem;
} 

 } 
