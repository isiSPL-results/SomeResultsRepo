import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
@SuppressWarnings("serial")
public class Main extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String lineText = "Line";
    JButton lineButton;
    protected JPanel toolPanel = new JPanel();
    protected Canvas canvas = new Canvas();
    Container contentPane;
    private static final String wipeText = "Wipe";
    JButton wipeButton;
    private static final String rectText = "Rectangle";
    JButton rectButton;
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
        lineButton = new JButton(lineText);
        wipeButton = new JButton(wipeText);
        rectButton = new JButton(rectText);
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
        lineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.selectedFigure(Canvas.FigureTypes.LINE);
            }
        });
        wipeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.wipe();
            }
        });
        rectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.selectedFigure(Canvas.FigureTypes.RECT);
            }
        });
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
        toolPanel.add(lineButton);
        toolPanel.add(wipeButton);
        toolPanel.add(rectButton);
        contentPane.add(toolPanel, BorderLayout.WEST);
        contentPane.add(canvas, BorderLayout.CENTER);
    }

}
