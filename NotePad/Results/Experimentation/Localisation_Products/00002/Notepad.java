import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Notepad extends JFrame
  { 
private static final long serialVersionUID = 1;
public Actions actions = new Actions(this);
public Center center = new Center(this);
private JTextArea textArea;
private JMenuBar Menubar;
private JMenu filE, ediT, vieW, formaT, helP;
private JMenuItem neW, opeN, savE, saveAS, prinT, exiT, fonT, abouT,
            cuT, copY, pastE, selectALL;
private JCheckBoxMenuItem lineWraP;
private JToolBar toolBar;
private JButton newButton, openButton, saveButton, saveAsButton, printButton,
            fontButton, aboutButton;
private JButton cutButton, copyButton, pasteButton;
public JTextArea getTextArea()
    { 
return textArea;
} 
public Notepad()
    { 
setTitle("Untitled - JAVA� Notepad");
setSize(800,600);
Container cp = getContentPane();
cp.add(textArea = new JTextArea());
cp.add("North", toolBar = new JToolBar("Tool Bar"));
cp.add(new JScrollPane(textArea));
setJMenuBar(Menubar= new JMenuBar());
Menubar.add(filE   = new JMenu("File"));
Menubar.add(ediT   = new JMenu("Edit"));
Menubar.add(vieW   = new JMenu("View"));
Menubar.add(formaT = new JMenu("Format"));
Menubar.add(helP   = new JMenu("Help"));
filE.add(neW    = new JMenuItem("New", new ImageIcon(this.getClass().getResource("images/new.gif"))));
filE.add(opeN   = new JMenuItem("Open", new ImageIcon(this.getClass().getResource("images/open.gif"))));
filE.add(savE   = new JMenuItem("Save", new ImageIcon(this.getClass().getResource("images/save.gif"))));
filE.add(saveAS = new JMenuItem("Save As", new ImageIcon(this.getClass().getResource("images/saveAs.gif"))));
filE.add(prinT  = new JMenuItem("Print", new ImageIcon(this.getClass().getResource("images/print.gif"))));
filE.add(exiT   = new JMenuItem("Exit"));
filE.insertSeparator(4);
filE.insertSeparator(6);
ediT.add(selectALL= new JMenuItem("Select All"));
formaT.add(lineWraP = new JCheckBoxMenuItem("Line Wrap"));
formaT.add(fonT = new JMenuItem("Font", new ImageIcon(this.getClass().getResource("images/font.gif"))));
helP.add(abouT = new JMenuItem("About Notepad", new ImageIcon(this.getClass().getResource("images/about.gif"))));
filE.setMnemonic('f');
ediT.setMnemonic('e');
vieW.setMnemonic('v');
formaT.setMnemonic('o');
helP.setMnemonic('h');
neW.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
opeN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
savE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
prinT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
exiT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
selectALL.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
toolBar.add(newButton   = new JButton(new ImageIcon(this.getClass().getResource("images/new.gif"))));
toolBar.add(openButton  = new JButton(new ImageIcon(this.getClass().getResource("images/open.gif"))));
toolBar.add(saveButton  = new JButton(new ImageIcon(this.getClass().getResource("images/save.gif"))));
toolBar.add(saveAsButton= new JButton(new ImageIcon(this.getClass().getResource("images/saveAs.gif"))));
toolBar.add(printButton = new JButton(new ImageIcon(this.getClass().getResource("images/print.gif"))));
toolBar.addSeparator();
toolBar.add(fontButton  = new JButton(new ImageIcon(this.getClass().getResource("images/font.gif"))));
toolBar.add(aboutButton = new JButton(new ImageIcon(this.getClass().getResource("images/about.gif"))));
newButton.setToolTipText("New");
openButton.setToolTipText("Open");
saveButton.setToolTipText("Save");
saveAsButton.setToolTipText("Save As");
printButton.setToolTipText("Print");
fontButton.setToolTipText("Font");
aboutButton.setToolTipText("About Notepad");
setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                actions.exiT();
            }
        });
neW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.neW();
            }
        });
opeN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.opeN();
            }
        });
savE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.savE();
            }
        });
saveAS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.saveAs();
            }
        });
prinT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.prinT();
            }
        });
exiT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.exiT();
            }
        });
selectALL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.selectALL();
            }
        });
lineWraP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.lineWraP();
            }
        });
fonT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.fonT();
            }
        });
abouT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.abouT();
            }
        });
newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.neW();
            }
        });
openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.opeN();
            }
        });
saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.savE();
            }
        });
saveAsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.saveAs();
            }
        });
printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.prinT();
            }
        });
fontButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.fonT();
            }
        });
aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.abouT();
            }
        });
textArea.setLineWrap(true);
textArea.setWrapStyleWord(true);
center.nCenter();
show();
ediT.add(cuT  = new JMenuItem("Cut",  new ImageIcon(this.getClass().getResource("images/cut.gif"))));
ediT.add(copY = new JMenuItem("Copy", new ImageIcon(this.getClass().getResource("images/copy.gif"))));
ediT.add(pastE= new JMenuItem("Paste",new ImageIcon(this.getClass().getResource("images/paste.gif"))));
cuT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
copY.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
pastE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
toolBar.add(cutButton   = new JButton(new ImageIcon(this.getClass().getResource("images/cut.gif"))));
toolBar.add(copyButton  = new JButton(new ImageIcon(this.getClass().getResource("images/copy.gif"))));
toolBar.add(pasteButton = new JButton(new ImageIcon(this.getClass().getResource("images/paste.gif"))));
cutButton.setToolTipText("Cut");
copyButton.setToolTipText("Copy");
pasteButton.setToolTipText("Paste");
cuT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.cuT();
            }
        });
copY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.copY();
            }
        });
pastE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.pastE();
            }
        });
cutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.cuT();
            }
        });
copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.copY();
            }
        });
pasteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.pastE();
            }
        });
} 
public static void main(String[] args)
    { 
new Notepad();
} 
public JCheckBoxMenuItem getLineWrap()
    { 
return lineWraP;
} 

 } 
