
//#if 924633554 
// Compilation Unit of /Gui.java 
 

//#if 1146103800 
package p;
//#endif 


//#if -131967033 
import java.awt.BorderLayout;
//#endif 


//#if -657166282 
import java.awt.Color;
//#endif 


//#if -593652769 
import java.awt.Event;
//#endif 


//#if -1687008375 
import java.awt.event.ActionEvent;
//#endif 


//#if 791512671 
import java.awt.event.ActionListener;
//#endif 


//#if -1194989426 
import java.awt.event.KeyEvent;
//#endif 


//#if 1955832498 
import javax.swing.JFrame;
//#endif 


//#if 2111929867 
import javax.swing.JLabel;
//#endif 


//#if 69181432 
import javax.swing.JMenu;
//#endif 


//#if -599956021 
import javax.swing.JMenuBar;
//#endif 


//#if -1411747675 
import javax.swing.JMenuItem;
//#endif 


//#if -2068163333 
import javax.swing.JPanel;
//#endif 


//#if 275269162 
import javax.swing.KeyStroke;
//#endif 


//#if -195358918 
import java.awt.event.KeyListener;
//#endif 


//#if -209725740 
import java.awt.event.MouseEvent;
//#endif 


//#if -11390156 
import java.awt.event.MouseListener;
//#endif 


//#if 1183989509 
public class Gui extends 
//#if 1869954722 
JFrame
//#endif 

  { 

//#if 805193974 
protected GuiBoard guiBoard;
//#endif 


//#if -943525620 
protected ListenerFactory listenerFactory;
//#endif 


//#if 1890926790 
@p.R4Feature(p.R4Feature.SOLVER)
    private static final int GLASS_PANE_ALPHA = 180;
//#endif 


//#if 1745656267 

//#if -1949009399 
@p.R4Feature(p.R4Feature.EXTENDED)
//#endif 


    protected JMenuItem createSetPossibilitiesMenuItem()
    { 

//#if 1437089490 
JMenuItem setPossibilitiesMenuItem = new JMenuItem();
//#endif 


//#if 911120509 
setPossibilitiesMenuItem.setText("Set Possibilities");
//#endif 


//#if -349042232 
setPossibilitiesMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, Event.CTRL_MASK, true));
//#endif 


//#if -1100437674 
setPossibilitiesMenuItem.addActionListener(listenerFactory
                .getSetPossibilitiesListener());
//#endif 


//#if -1372875682 
return setPossibilitiesMenuItem;
//#endif 

} 

//#endif 


//#if 604685800 

//#if 1445260865 
@p.R4Feature(p.R4Feature.GENERATOR)
//#endif 


    protected JMenuItem createGenerateSudokuMenuItem()
    { 

//#if 328901481 
JMenuItem generateSudokuMenuItem = new JMenuItem();
//#endif 


//#if -1953920003 
generateSudokuMenuItem.setText("Generate Sudoku");
//#endif 


//#if -1459532382 
generateSudokuMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, Event.CTRL_MASK, true));
//#endif 


//#if -2029525162 
generateSudokuMenuItem.addActionListener(listenerFactory
                .getGenerateSudokuListener());
//#endif 


//#if -702422053 
return generateSudokuMenuItem;
//#endif 

} 

//#endif 


//#if -813782863 
protected void update(Board b)
    { 

//#if -69229769 
getGlassPane().setVisible(true);
//#endif 


//#if 1036018842 
if(null != b)//1
{ 

//#if 749407067 
if(null == guiBoard)//1
{ 

//#if -1047968534 
guiBoard = new GuiBoard(listenerFactory);
//#endif 


//#if 564815189 
getContentPane().add(guiBoard);
//#endif 

} 

//#endif 


//#if 1099874094 
guiBoard.update(b);
//#endif 

} 
else
{ 

//#if -1904056419 
if(null != guiBoard)//1
{ 

//#if -1494120975 
getContentPane().remove(guiBoard);
//#endif 


//#if 673184628 
guiBoard = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1270538493 
pack();
//#endif 


//#if 2114161790 
getGlassPane().setVisible(false);
//#endif 

} 

//#endif 


//#if -204760889 
protected void createAndShowGUI()
    { 

//#if -834381042 
setTitle("Sudoku");
//#endif 


//#if 66771419 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//#endif 


//#if -1884833022 
pack();
//#endif 


//#if -1538391787 
setResizable(false);
//#endif 


//#if 853209305 
setVisible(true);
//#endif 

} 

//#endif 


//#if 478211986 
protected JMenu createFileMenu()
    { 

//#if 1711183630 
JMenu fileMenu = new JMenu();
//#endif 


//#if 1720939864 
fileMenu.setText("File");
//#endif 


//#if -1311635977 
fileMenu.add(createLoadMenuItem());
//#endif 


//#if -1498782161 
fileMenu.add(createExitMenuItem());
//#endif 


//#if 1782135427 
if(p.R4Feature.STATES)//1
{ 

//#if 530214058 
fileMenu.add(createOpenStateMenuItem());
//#endif 

} 

//#endif 


//#if 1505836366 
if(p.R4Feature.STATES)//2
{ 

//#if 1160470957 
fileMenu.add(createSaveStateMenuItem());
//#endif 

} 

//#endif 


//#if 1280857122 
if(p.R4Feature.GENERATOR)//1
{ 

//#if -1129482979 
fileMenu.add(createGenerateSudokuMenuItem());
//#endif 

} 

//#endif 


//#if -1111112698 
return fileMenu;
//#endif 

} 

//#endif 


//#if 1385527642 
protected JMenuItem createExitMenuItem()
    { 

//#if -1324941981 
JMenuItem exitMenuItem = new JMenuItem();
//#endif 


//#if 365362721 
exitMenuItem.setText("Exit");
//#endif 


//#if 46070045 
exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                                    Event.CTRL_MASK, true));
//#endif 


//#if 869971834 
exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
//#endif 


//#if 343396785 
return exitMenuItem;
//#endif 

} 

//#endif 


//#if 1098140401 

//#if 1474760611 
@p.R4Feature(p.R4Feature.STATES)
//#endif 


    protected JMenuItem createOpenStateMenuItem()
    { 

//#if -1953213803 
JMenuItem openStateMenuItem = new JMenuItem();
//#endif 


//#if -857029238 
openStateMenuItem.setText("Open State");
//#endif 


//#if -372874723 
openStateMenuItem.addActionListener(listenerFactory
                                            .getLoadStateListener());
//#endif 


//#if -753351460 
openStateMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                                         Event.CTRL_MASK, true));
//#endif 


//#if -1803742839 
return openStateMenuItem;
//#endif 

} 

//#endif 


//#if 232007772 

//#if 439054872 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    protected JMenuItem createSolutionHintMenuItem()
    { 

//#if 1817248743 
JMenuItem solutionMenuItem = new JMenuItem();
//#endif 


//#if -885797491 
solutionMenuItem.setText("Solution Hint");
//#endif 


//#if -200699361 
solutionMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,
                                        Event.CTRL_MASK, true));
//#endif 


//#if 432413638 
solutionMenuItem.addActionListener(listenerFactory
                                           .getSolutionHintListener());
//#endif 


//#if 404579615 
return solutionMenuItem;
//#endif 

} 

//#endif 


//#if -169403392 
protected JMenuBar createMenuBar()
    { 

//#if 528083133 
JMenuBar menuBar = new JMenuBar();
//#endif 


//#if 1864598373 
menuBar.add(createFileMenu());
//#endif 


//#if 1513809721 
menuBar.add(createOptionsMenu());
//#endif 


//#if 1696892849 
return menuBar;
//#endif 

} 

//#endif 


//#if 820281032 
protected JMenu createOptionsMenu()
    { 

//#if -2081607010 
JMenu optionsMenu = new JMenu();
//#endif 


//#if -1858103944 
optionsMenu.setText("Options");
//#endif 


//#if 1270885785 
if(p.R4Feature.UNDO)//1
{ 

//#if -1889485109 
optionsMenu.add(createUndoMenuItem());
//#endif 

} 

//#endif 


//#if -349967864 
if(p.R4Feature.SOLVER)//1
{ 

//#if -296855488 
optionsMenu.add(createSolutionHintMenuItem());
//#endif 

} 

//#endif 


//#if 1059399918 
if(p.R4Feature.EXTENDED)//1
{ 

//#if -663368287 
optionsMenu.add(createSetPossibilitiesMenuItem());
//#endif 

} 

//#endif 


//#if -685225948 
return optionsMenu;
//#endif 

} 

//#endif 


//#if 1622704990 

//#if 10475287 
@p.R4Feature(p.R4Feature.STATES)
//#endif 


    protected JMenuItem createSaveStateMenuItem()
    { 

//#if 941586145 
JMenuItem saveStateMenuItem = new JMenuItem();
//#endif 


//#if -1426838677 
saveStateMenuItem.setText("Save State");
//#endif 


//#if -596300424 
saveStateMenuItem.addActionListener(listenerFactory
                                            .getSaveStateListener());
//#endif 


//#if -352790514 
saveStateMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                                         Event.CTRL_MASK, true));
//#endif 


//#if -1703542821 
return saveStateMenuItem;
//#endif 

} 

//#endif 


//#if 2035447165 
protected JPanel createContentPane()
    { 

//#if -846506896 
JPanel pane = new JPanel();
//#endif 


//#if 658505714 
pane.setLayout(new BorderLayout());
//#endif 


//#if -1930844872 
return pane;
//#endif 

} 

//#endif 


//#if 274995616 

//#if 1429159952 
@p.R4Feature(p.R4Feature.UNDO)
//#endif 


    protected JMenuItem createUndoMenuItem()
    { 

//#if -1309860816 
JMenuItem loadMenuItem = new JMenuItem();
//#endif 


//#if 1842054616 
loadMenuItem.setText("Undo");
//#endif 


//#if 953443005 
loadMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
                                    Event.CTRL_MASK, true));
//#endif 


//#if -1837454245 
loadMenuItem.addActionListener(listenerFactory.getUndoListener());
//#endif 


//#if -1424123602 
return loadMenuItem;
//#endif 

} 

//#endif 


//#if -1123000815 

//#if -97206074 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    public void setBusy(boolean busy)
    { 

//#if 803596575 
if(busy)//1
{ 

//#if 2129901520 
getGlassPane().setVisible(true);
//#endif 

} 
else
{ 

//#if -1774307135 
getGlassPane().setVisible(false);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1854651380 
public Gui(ListenerFactory listenerFactory)
    { 

//#if -995883671 
super();
//#endif 


//#if 501826226 
this.listenerFactory = listenerFactory;
//#endif 


//#if 87415321 
setContentPane(createContentPane());
//#endif 


//#if -417204955 
setJMenuBar(createMenuBar());
//#endif 


//#if 1182754004 
if(p.R4Feature.SOLVER)//1
{ 

//#if 538752380 
JPanel glassPane = new JPanel(new BorderLayout());
//#endif 


//#if 1009815927 
glassPane.setBackground(new Color(Color.BLACK.getRed(), Color.BLACK
                                              .getGreen(), Color.BLACK.getBlue(), GLASS_PANE_ALPHA));
//#endif 


//#if -571199331 
glassPane.addMouseListener(new MouseListener() {
                public void mousePressed(MouseEvent e) {
                }

                public void mouseReleased(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mouseClicked(MouseEvent e) {
                }
            });
//#endif 


//#if 929896950 
glassPane.addKeyListener(new KeyListener() {
                public void keyTyped(KeyEvent e) {
                }

                public void keyPressed(KeyEvent e) {
                }

                public void keyReleased(KeyEvent e) {
                }
            });
//#endif 


//#if 252465521 
JLabel label = new JLabel("Busy...", JLabel.CENTER);
//#endif 


//#if -494433785 
label.setForeground(Color.white);
//#endif 


//#if 1344152106 
glassPane.add(label, BorderLayout.CENTER);
//#endif 


//#if 629952028 
setGlassPane(glassPane);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1858966750 
protected JMenuItem createLoadMenuItem()
    { 

//#if -2081028709 
JMenuItem loadMenuItem = new JMenuItem();
//#endif 


//#if 1969981185 
loadMenuItem.setText("Load");
//#endif 


//#if -1574786455 
loadMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
                                    Event.CTRL_MASK, true));
//#endif 


//#if 46365166 
loadMenuItem.addActionListener(listenerFactory.getLoadFileListener());
//#endif 


//#if 1439405913 
return loadMenuItem;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

