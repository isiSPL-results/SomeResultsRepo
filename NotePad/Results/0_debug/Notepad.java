
//#if -102184318
// Compilation Unit of /Notepad.java


//#if 1285324149
import java.awt.*;
//#endif


//#if -732574135
import java.awt.event.*;
//#endif


//#if -768408655
import javax.swing.*;
//#endif


//#if 979744645
import javax.swing.event.*;
//#endif


//#if -1099989957
import javax.swing.undo.*;
//#endif


//#if -1727851867
public class Notepad extends
//#if -2132033600
    JFrame
//#endif

{

//#if -1629914979
    private static final long serialVersionUID = 1;
//#endif


//#if -166773148
    public Actions actions = new Actions(this);
//#endif


//#if -2020228080
    public Center center = new Center(this);
//#endif


//#if 141952515
    private JTextArea textArea;
//#endif


//#if -306913865
    private JMenuBar Menubar;
//#endif


//#if 1775949879
    private JMenu filE, ediT, vieW, formaT, helP;
//#endif


//#if -580286111
    private JMenuItem neW, opeN, savE, saveAS, prinT, exiT, fonT, abouT,
            cuT, copY, pastE, selectALL;
//#endif


//#if 263375748
    private JCheckBoxMenuItem lineWraP;
//#endif


//#if -1005159529
    private JToolBar toolBar;
//#endif


//#if -1577546100
    private JButton newButton, openButton, saveButton, saveAsButton, printButton,
            fontButton, aboutButton;
//#endif


//#if -2144664531
    private JButton cutButton, copyButton, pasteButton;
//#endif


//#if -56508198
    private JButton findButton;
//#endif


//#if -404957102
    private JMenuItem finD, findNexT;
//#endif


//#if 1582506564
    UndoManager undo = new UndoManager();
//#endif


//#if -312311350
    UndoAction undoAction = new UndoAction(this);
//#endif


//#if 311017660
    RedoAction redoAction = new RedoAction(this);
//#endif


//#if -616475605
    private JButton undoButton, redoButton;
//#endif


//#if 1012309235
    public JTextArea getTextArea()
    {

//#if 1089068561
        return textArea;
//#endif

    }

//#endif


//#if 990264284
    public Notepad()
    {

//#if -768032243
        setTitle("Untitled - JAVA� Notepad");
//#endif


//#if -65426504
        setSize(800,600);
//#endif


//#if -338773175
        Container cp = getContentPane();
//#endif


//#if 86763113
        cp.add(textArea = new JTextArea());
//#endif


//#if -1719883191
        cp.add("North", toolBar = new JToolBar("Tool Bar"));
//#endif


//#if -554898007
        cp.add(new JScrollPane(textArea));
//#endif


//#if -245403103
        setJMenuBar(Menubar= new JMenuBar());
//#endif


//#if -1810980095
        Menubar.add(filE   = new JMenu("File"));
//#endif


//#if -1589275327
        Menubar.add(ediT   = new JMenu("Edit"));
//#endif


//#if -1686561823
        Menubar.add(vieW   = new JMenu("View"));
//#endif


//#if 331418465
        Menubar.add(formaT = new JMenu("Format"));
//#endif


//#if -15495071
        Menubar.add(helP   = new JMenu("Help"));
//#endif


//#if -1827698980
        filE.add(neW    = new JMenuItem("New", new ImageIcon(this.getClass().getResource("images/new.gif"))));
//#endif


//#if 98017862
        filE.add(opeN   = new JMenuItem("Open", new ImageIcon(this.getClass().getResource("images/open.gif"))));
//#endif


//#if -1991448423
        filE.add(savE   = new JMenuItem("Save", new ImageIcon(this.getClass().getResource("images/save.gif"))));
//#endif


//#if 2019482923
        filE.add(saveAS = new JMenuItem("Save As", new ImageIcon(this.getClass().getResource("images/saveAs.gif"))));
//#endif


//#if -2099078845
        filE.add(prinT  = new JMenuItem("Print", new ImageIcon(this.getClass().getResource("images/print.gif"))));
//#endif


//#if -678197974
        filE.add(exiT   = new JMenuItem("Exit"));
//#endif


//#if -352626545
        filE.insertSeparator(4);
//#endif


//#if -352624623
        filE.insertSeparator(6);
//#endif


//#if 1048642652
        ediT.add(selectALL= new JMenuItem("Select All"));
//#endif


//#if -1263872024
        formaT.add(lineWraP = new JCheckBoxMenuItem("Line Wrap"));
//#endif


//#if 1757214544
        formaT.add(fonT = new JMenuItem("Font", new ImageIcon(this.getClass().getResource("images/font.gif"))));
//#endif


//#if 719859797
        helP.add(abouT = new JMenuItem("About Notepad", new ImageIcon(this.getClass().getResource("images/about.gif"))));
//#endif


//#if -1154137189
        filE.setMnemonic('f');
//#endif


//#if 1271431242
        ediT.setMnemonic('e');
//#endif


//#if 1143354996
        vieW.setMnemonic('v');
//#endif


//#if -426601747
        formaT.setMnemonic('o');
//#endif


//#if 1815084766
        helP.setMnemonic('h');
//#endif


//#if -1810003120
        neW.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
//#endif


//#if 979741047
        opeN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
//#endif


//#if 1528331680
        savE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
//#endif


//#if 974412769
        prinT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
//#endif


//#if -175850430
        exiT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
//#endif


//#if -172341224
        selectALL.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
//#endif


//#if 1126819063
        toolBar.add(newButton   = new JButton(new ImageIcon(this.getClass().getResource("images/new.gif"))));
//#endif


//#if 1024784101
        toolBar.add(openButton  = new JButton(new ImageIcon(this.getClass().getResource("images/open.gif"))));
//#endif


//#if 878204805
        toolBar.add(saveButton  = new JButton(new ImageIcon(this.getClass().getResource("images/save.gif"))));
//#endif


//#if -1873493563
        toolBar.add(saveAsButton= new JButton(new ImageIcon(this.getClass().getResource("images/saveAs.gif"))));
//#endif


//#if -1477167151
        toolBar.add(printButton = new JButton(new ImageIcon(this.getClass().getResource("images/print.gif"))));
//#endif


//#if 1299299180
        toolBar.addSeparator();
//#endif


//#if 1553254213
        toolBar.add(fontButton  = new JButton(new ImageIcon(this.getClass().getResource("images/font.gif"))));
//#endif


//#if -2035152495
        toolBar.add(aboutButton = new JButton(new ImageIcon(this.getClass().getResource("images/about.gif"))));
//#endif


//#if -2081658641
        newButton.setToolTipText("New");
//#endif


//#if -1798541849
        openButton.setToolTipText("Open");
//#endif


//#if 865624519
        saveButton.setToolTipText("Save");
//#endif


//#if 220779207
        saveAsButton.setToolTipText("Save As");
//#endif


//#if -1039689323
        printButton.setToolTipText("Print");
//#endif


//#if 1521638663
        fontButton.setToolTipText("Font");
//#endif


//#if -1047865390
        aboutButton.setToolTipText("About Notepad");
//#endif


//#if -1647800275
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//#endif


//#if 1476448175
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                actions.exiT();
            }
        });
//#endif


//#if 825415658
        neW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.neW();
            }
        });
//#endif


//#if 1562540108
        opeN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.opeN();
            }
        });
//#endif


//#if 1324041638
        savE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.savE();
            }
        });
//#endif


//#if 1412774498
        saveAS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.saveAs();
            }
        });
//#endif


//#if 13977354
        prinT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.prinT();
            }
        });
//#endif


//#if 1195527076
        exiT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.exiT();
            }
        });
//#endif


//#if -1631535606
        selectALL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.selectALL();
            }
        });
//#endif


//#if 1420595620
        lineWraP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.lineWraP();
            }
        });
//#endif


//#if 540528258
        fonT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.fonT();
            }
        });
//#endif


//#if 1246272266
        abouT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.abouT();
            }
        });
//#endif


//#if 1964434460
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.neW();
            }
        });
//#endif


//#if -371323814
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.opeN();
            }
        });
//#endif


//#if 2131653620
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.savE();
            }
        });
//#endif


//#if -596516176
        saveAsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.saveAs();
            }
        });
//#endif


//#if -1793531652
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.prinT();
            }
        });
//#endif


//#if -2102930864
        fontButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.fonT();
            }
        });
//#endif


//#if 509611260
        aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.abouT();
            }
        });
//#endif


//#if -1427747451
        textArea.setLineWrap(true);
//#endif


//#if -256459332
        textArea.setWrapStyleWord(true);
//#endif


//#if -114682247
        center.nCenter();
//#endif


//#if -1032069210
        show();
//#endif


//#if 1301232848
        ediT.add(cuT  = new JMenuItem("Cut",  new ImageIcon(this.getClass().getResource("images/cut.gif"))));
//#endif


//#if 1274674627
        ediT.add(copY = new JMenuItem("Copy", new ImageIcon(this.getClass().getResource("images/copy.gif"))));
//#endif


//#if 353809411
        ediT.add(pastE= new JMenuItem("Paste",new ImageIcon(this.getClass().getResource("images/paste.gif"))));
//#endif


//#if 1152358692
        cuT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
//#endif


//#if 576884920
        copY.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
//#endif


//#if -1132390283
        pastE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
//#endif


//#if -682811461
        toolBar.add(cutButton   = new JButton(new ImageIcon(this.getClass().getResource("images/cut.gif"))));
//#endif


//#if -1082150779
        toolBar.add(copyButton  = new JButton(new ImageIcon(this.getClass().getResource("images/copy.gif"))));
//#endif


//#if -581121379
        toolBar.add(pasteButton = new JButton(new ImageIcon(this.getClass().getResource("images/paste.gif"))));
//#endif


//#if -461703253
        cutButton.setToolTipText("Cut");
//#endif


//#if 2108374215
        copyButton.setToolTipText("Copy");
//#endif


//#if -684756151
        pasteButton.setToolTipText("Paste");
//#endif


//#if 399476010
        cuT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.cuT();
            }
        });
//#endif


//#if 337346486
        copY.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.copY();
            }
        });
//#endif


//#if 1754893642
        pastE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.pastE();
            }
        });
//#endif


//#if 217018332
        cutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.cuT();
            }
        });
//#endif


//#if -197572604
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.copY();
            }
        });
//#endif


//#if -14261572
        pasteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.pastE();
            }
        });
//#endif


//#if -1097712249
        ediT.add(finD = new JMenuItem("Find", new ImageIcon(this.getClass().getResource("images/find.gif"))));
//#endif


//#if 1434395512
        ediT.add(findNexT = new JMenuItem("Find Next"));
//#endif


//#if 2050536017
        finD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
//#endif


//#if 938652753
        findNexT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.CTRL_MASK));
//#endif


//#if -601580539
        toolBar.add(findButton  = new JButton(new ImageIcon(this.getClass().getResource("images/find.gif"))));
//#endif


//#if 248715079
        findButton.setToolTipText("Find");
//#endif


//#if -1385465810
        finD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.finD();
            }
        });
//#endif


//#if 132267592
        findNexT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.findNexT();
            }
        });
//#endif


//#if -723197060
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                actions.finD();
            }
        });
//#endif


//#if -1454114752
        ediT.add(undoAction);
//#endif


//#if 1446297434
        ediT.add(redoAction);
//#endif


//#if 1176646502
        toolBar.addSeparator();
//#endif


//#if 1256109309
        toolBar.add(undoAction);
//#endif


//#if -138445801
        toolBar.add(redoAction);
//#endif


//#if 1176646503
        toolBar.addSeparator();
//#endif


//#if 2032780579
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                //Remember the edit and update the menus
                undo.addEdit(e.getEdit());
                undoAction.update();
                redoAction.update();
            }
        });
//#endif

    }

//#endif


//#if -1532393294
    public static void main(String[] args)
    {

//#if 1733436061
        new Notepad();
//#endif

    }

//#endif


//#if -567379876
    public JCheckBoxMenuItem getLineWrap()
    {

//#if -1412538062
        return lineWraP;
//#endif

    }

//#endif

}

//#endif


//#endif

