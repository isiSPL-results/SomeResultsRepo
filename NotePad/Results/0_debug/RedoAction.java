
//#if 1031884111
// Compilation Unit of /RedoAction.java


//#if -1157374782
import java.awt.event.*;
//#endif


//#if 1696018392
import javax.swing.*;
//#endif


//#if -1311518604
import javax.swing.undo.*;
//#endif


//#if -44738862
class RedoAction extends
//#if -1813981027
    AbstractAction
//#endif

{

//#if -1338344555
    private static final long serialVersionUID = 1;
//#endif


//#if 75550806
    Notepad notepad;
//#endif


//#if -1887887193
    protected void update()
    {

//#if 1018476652
        if(notepad.undo.canRedo()) { //1

//#if 2142967791
            setEnabled(true);
//#endif


//#if -787404019
            putValue("Redo", notepad.undo.getRedoPresentationName());
//#endif

        } else {

//#if 239563288
            setEnabled(false);
//#endif


//#if 364875287
            putValue(Action.NAME, "Redo");
//#endif

        }

//#endif

    }

//#endif


//#if 2040204643
    public RedoAction(Notepad notepad)
    {

//#if -836669441
        super("Redo");
//#endif


//#if 1026019715
        putValue( Action.SMALL_ICON,
                  new ImageIcon(this.getClass().getResource("images/redo.gif")));
//#endif


//#if 2140956746
        setEnabled(false);
//#endif


//#if 1021892648
        this.notepad = notepad;
//#endif

    }

//#endif


//#if -874917752
    public void actionPerformed(ActionEvent e)
    {

//#if 451628753
        try { //1

//#if 1118527013
            notepad.undo.redo();
//#endif

        }

//#if -939910125
        catch (CannotRedoException ex) { //1

//#if -2130388209
            System.out.println("Unable to redo: " + ex);
//#endif


//#if 2084294888
            ex.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if 1675562998
        update();
//#endif


//#if 664653701
        notepad.undoAction.update();
//#endif

    }

//#endif

}

//#endif


//#endif

