// Compilation Unit of /Main.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
@SuppressWarnings("serial")
public class Main extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

//#if  LINE
    private static final String lineText = "Line";
//#endif


//#if  LINE
    JButton lineButton;
//#endif

    protected JPanel toolPanel = new JPanel();
    protected Canvas canvas = new Canvas();
    Container contentPane;

//#if  COLOR
    private static final Vector<String> colors = new Vector<String>();
//#endif


//#if  COLOR
    private static final String red = "Red";
//#endif


//#if  COLOR
    private static final String green = "Green";
//#endif


//#if  COLOR
    private static final String blue = "Blue";
//#endif


//#if  COLOR
    private static final String black = "Black";
//#endif


//#if  COLOR
    JComboBox colorsBox;
//#endif


//#if  COLOR
    protected JPanel colorsPanel = new JPanel();
//#endif


//#if  WIPE
    private static final String wipeText = "Wipe";
//#endif


//#if  WIPE
    JButton wipeButton;
//#endif


//#if  RECT
    private static final String rectText = "Rectangle";
//#endif


//#if  RECT
    JButton rectButton;
//#endif

    public Main(String appTitle)
    {
        super(appTitle);
        init();
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setResizable(true);
        validate();
    }

    /** main method */
    public static void main(String[] args)
    {
        new Main("Draw Product Line");
    }

    public void initAtoms()
    {

//#if  LINE
        lineButton = new JButton(lineText);
//#endif


//#if (  ( COLOR  &&  BASE  &&  LINE  &&  WIPE ) ||  ( COLOR  &&  BASE  &&  RECT  &&  WIPE ) )
        wipeButton = new JButton(wipeText);
//#endif


//#if  ( COLOR  &&  BASE  &&  RECT )
        rectButton = new JButton(rectText);
//#endif


//#if  COLOR
        colors.add(black);
//#endif


//#if  COLOR
        colors.add(red);
//#endif


//#if  COLOR
        colors.add(green);
//#endif


//#if  COLOR
        colors.add(blue);
//#endif


//#if  COLOR
        colorsBox = new JComboBox(colors);
//#endif


//#if  COLOR
        colorsBox.setSelectedIndex(0);
//#endif


//#if  COLOR
        colorsPanel.add(colorsBox);
//#endif


//#if  ( WIPE  &&  BASE ) && ! COLOR
        wipeButton = new JButton(wipeText);
//#endif


//#if  ( RECT  &&  BASE ) && ! COLOR
        rectButton = new JButton(rectText);
//#endif

    }

    public void init()
    {
        initAtoms();
        initLayout();
        initContentPane();
        initListeners();
    }

    /** Initializes the listeners for the buttons and the combo box */

    public void initListeners()
    {

//#if  LINE
        lineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.selectedFigure(Canvas.FigureTypes.LINE);
            }
        });
//#endif


//#if  ( COLOR  &&  BASE  &&  LINE ) && ! WIPE  && ! RECT
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


//#if  WIPE
        wipeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.wipe();
            }
        });
//#endif


//#if (  ( COLOR  &&  BASE  &&  LINE  &&  WIPE ) ||  ( COLOR  &&  BASE  &&  RECT ) )
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


//#if  RECT
        rectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.selectedFigure(Canvas.FigureTypes.RECT);
            }
        });
//#endif

    }

    /** Initializes layout . No need to change */
    public void initLayout()
    {
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.Y_AXIS));
    }

    /** Initializes the content pane */
    public void initContentPane()
    {

//#if  LINE
        toolPanel.add(lineButton);
//#endif


//#if  ( COLOR  &&  BASE  &&  LINE ) && ! WIPE  && ! RECT
        toolPanel.add(colorsPanel);
//#endif


//#if  WIPE
        toolPanel.add(wipeButton);
//#endif


//#if (  ( COLOR  &&  BASE  &&  LINE  &&  WIPE ) ||  ( COLOR  &&  BASE  &&  RECT ) )
        toolPanel.add(colorsPanel);
//#endif


//#if  RECT
        toolPanel.add(rectButton);
//#endif

        contentPane.add(toolPanel, BorderLayout.WEST);
        contentPane.add(canvas, BorderLayout.CENTER);
    }

}


