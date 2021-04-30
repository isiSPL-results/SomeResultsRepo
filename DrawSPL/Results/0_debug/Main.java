
//#if -827871280
// Compilation Unit of /Main.java


//#if -2029730042
import javax.swing.*;
//#endif


//#if 1014530624
import java.awt.*;
//#endif


//#if -89141548
import java.awt.event.*;
//#endif


//#if 1351325195
import java.util.Vector;
//#endif


//#if -1708509056

//#if 1315049939
@SuppressWarnings("serial")
//#endif

public class Main extends
//#if 260533745
    JFrame
//#endif

{

//#if 307803862
    private static final int WIDTH = 800;
//#endif


//#if 1956736703
    private static final int HEIGHT = 600;
//#endif


//#if -825929865
    private static final String lineText = "Line";
//#endif


//#if 1333031111
    JButton lineButton;
//#endif


//#if 811951915
    protected JPanel toolPanel = new JPanel();
//#endif


//#if -711447313
    protected Canvas canvas = new Canvas();
//#endif


//#if -2039176371
    Container contentPane;
//#endif


//#if -1730591572
    private static final Vector<String> colors = new Vector<String>();
//#endif


//#if 1711612792
    private static final String red = "Red";
//#endif


//#if 1007944376
    private static final String green = "Green";
//#endif


//#if -1032542090
    private static final String blue = "Blue";
//#endif


//#if 55250744
    private static final String black = "Black";
//#endif


//#if -356493191
    JComboBox colorsBox;
//#endif


//#if -1869990269
    protected JPanel colorsPanel = new JPanel();
//#endif


//#if 1451991773
    private static final String wipeText = "Wipe";
//#endif


//#if -573506284
    JButton wipeButton;
//#endif


//#if 1586645038
    private static final String rectText = "Rectangle";
//#endif


//#if -1293174569
    JButton rectButton;
//#endif


//#if 1651718025
    public Main(String appTitle)
    {

//#if 421536990
        super(appTitle);
//#endif


//#if 978730594
        init();
//#endif


//#if 409825420
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
//#endif


//#if 1838216656
        setVisible(true);
//#endif


//#if 1320457484
        setSize(WIDTH, HEIGHT);
//#endif


//#if -704552201
        setResizable(true);
//#endif


//#if -985270116
        validate();
//#endif

    }

//#endif


//#if -1713018731
    /** main method */
    public static void main(String[] args)
    {

//#if 1052635661
        new Main("Draw Product Line");
//#endif

    }

//#endif


//#if -734191992
    public void initAtoms()
    {

//#if 157141950
        lineButton = new JButton(lineText);
//#endif


//#if 1120853261
        wipeButton = new JButton(wipeText);
//#endif


//#if 2084425811
        rectButton = new JButton(rectText);
//#endif


//#if 378033314
        colors.add(black);
//#endif


//#if -820791052
        colors.add(red);
//#endif


//#if 696115878
        colors.add(green);
//#endif


//#if -125756997
        colors.add(blue);
//#endif


//#if 1875692523
        colorsBox = new JComboBox(colors);
//#endif


//#if 1365192824
        colorsBox.setSelectedIndex(0);
//#endif


//#if -2078325834
        colorsPanel.add(colorsBox);
//#endif


//#if 867440548
        wipeButton = new JButton(wipeText);
//#endif


//#if 1452712862
        rectButton = new JButton(rectText);
//#endif

    }

//#endif


//#if -728706820
    public void init()
    {

//#if 2097163166
        initAtoms();
//#endif


//#if -521768982
        initLayout();
//#endif


//#if -719844225
        initContentPane();
//#endif


//#if 1673190017
        initListeners();
//#endif

    }

//#endif


//#if -1227962002
    /** Initializes the listeners for the buttons and the combo box */

    public void initListeners()
    {

//#if 619517133
        lineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.selectedFigure(Canvas.FigureTypes.LINE);
            }
        });
//#endif


//#if -273933705
        colorsBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == colorsBox) {
                    String colorString = ((String)colorsBox.getSelectedItem());
                    // colorString holds the String value of the selected item in the
                    // colors box
                    canvas.setColor(colorString);
                }
            }
        });
//#endif


//#if 331819907
        wipeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.wipe();
            }
        });
//#endif


//#if 97989786
        colorsBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == colorsBox) {
                    String colorString = ((String)colorsBox.getSelectedItem());
                    // colorString holds the String value of the selected item in the
                    // colors box
                    canvas.setColor(colorString);
                }
            }
        });
//#endif


//#if -1438169939
        rectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.selectedFigure(Canvas.FigureTypes.RECT);
            }
        });
//#endif

    }

//#endif


//#if 1428219233
    /** Initializes layout . No need to change */
    public void initLayout()
    {

//#if 1501569549
        contentPane = getContentPane();
//#endif


//#if 1040650170
        contentPane.setLayout(new BorderLayout());
//#endif


//#if 668121516
        toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.Y_AXIS));
//#endif

    }

//#endif


//#if 370591454
    /** Initializes the content pane */
    public void initContentPane()
    {

//#if 1480435317
        toolPanel.add(lineButton);
//#endif


//#if 1213180873
        toolPanel.add(colorsPanel);
//#endif


//#if -1787649080
        toolPanel.add(wipeButton);
//#endif


//#if -1046098552
        toolPanel.add(colorsPanel);
//#endif


//#if 1672437861
        toolPanel.add(rectButton);
//#endif


//#if -344707535
        contentPane.add(toolPanel, BorderLayout.WEST);
//#endif


//#if -80801485
        contentPane.add(canvas, BorderLayout.CENTER);
//#endif

    }

//#endif

}

//#endif


//#endif

