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
    @p.R4Feature(p.R4Feature.EXTENDED)

    protected JMenuItem createSetPossibilitiesMenuItem()
    {
        JMenuItem setPossibilitiesMenuItem = new JMenuItem();
        setPossibilitiesMenuItem.setText("Set Possibilities");
        setPossibilitiesMenuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, Event.CTRL_MASK, true));
        setPossibilitiesMenuItem.addActionListener(listenerFactory
                .getSetPossibilitiesListener());
        return setPossibilitiesMenuItem;
    }
    protected void update(Board b)
    {
        getGlassPane().setVisible(true);
        if(null != b) { //1
            if(null == guiBoard) { //1
                guiBoard = new GuiBoard(listenerFactory);
                getContentPane().add(guiBoard);
            }
            guiBoard.update(b);
        } else {
            if(null != guiBoard) { //1
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
        if(p.R4Feature.STATES) { //1
            fileMenu.add(createOpenStateMenuItem());
        }
        if(p.R4Feature.STATES) { //2
            fileMenu.add(createSaveStateMenuItem());
        }
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
    @p.R4Feature(p.R4Feature.STATES)

    protected JMenuItem createOpenStateMenuItem()
    {
        JMenuItem openStateMenuItem = new JMenuItem();
        openStateMenuItem.setText("Open State");
        openStateMenuItem.addActionListener(listenerFactory
                                            .getLoadStateListener());
        openStateMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                                         Event.CTRL_MASK, true));
        return openStateMenuItem;
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
        if(p.R4Feature.UNDO) { //1
            optionsMenu.add(createUndoMenuItem());
        }
        if(p.R4Feature.EXTENDED) { //1
            optionsMenu.add(createSetPossibilitiesMenuItem());
        }
        return optionsMenu;
    }
    @p.R4Feature(p.R4Feature.STATES)

    protected JMenuItem createSaveStateMenuItem()
    {
        JMenuItem saveStateMenuItem = new JMenuItem();
        saveStateMenuItem.setText("Save State");
        saveStateMenuItem.addActionListener(listenerFactory
                                            .getSaveStateListener());
        saveStateMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                                         Event.CTRL_MASK, true));
        return saveStateMenuItem;
    }
    protected JPanel createContentPane()
    {
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        return pane;
    }
    @p.R4Feature(p.R4Feature.UNDO)

    protected JMenuItem createUndoMenuItem()
    {
        JMenuItem loadMenuItem = new JMenuItem();
        loadMenuItem.setText("Undo");
        loadMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
                                    Event.CTRL_MASK, true));
        loadMenuItem.addActionListener(listenerFactory.getUndoListener());
        return loadMenuItem;
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
