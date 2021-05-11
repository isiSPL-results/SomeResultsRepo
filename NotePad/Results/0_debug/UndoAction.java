
//#if -191366936
// Compilation Unit of /UndoAction.java


//#if -1897039945
import java.awt.event.*;
//#endif


//#if -1265401597
import javax.swing.*;
//#endif


//#if 834830889
import javax.swing.undo.*;
//#endif


//#if 1943269677
class UndoAction extends
//#if -422152320
    AbstractAction
//#endif

{

//#if -1207195950
    private static final long serialVersionUID = 1;
//#endif


//#if 272567763
    Notepad notepad;
//#endif


//#if 184059884
    public UndoAction(Notepad notepad)
    {

//#if -1514013383
        super( "Undo" );
//#endif


//#if -1087042691
        putValue( Action.SMALL_ICON,
                  new ImageIcon( this.getClass().getResource( "images/undo.gif" ) ) );
//#endif


//#if -132336086
        setEnabled( false );
//#endif


//#if 399457864
        this.notepad = notepad;
//#endif

    }

//#endif


//#if 88116324
    protected void update()
    {

//#if -932132030
        if(notepad.undo.canUndo()) { //1

//#if 1948945453
            setEnabled( true );
//#endif


//#if -1544020901
            putValue( "Undo", notepad.undo.getUndoPresentationName() );
//#endif

        } else {

//#if 1140317666
            setEnabled( false );
//#endif


//#if 1919487847
            putValue( Action.NAME, "Undo" );
//#endif

        }

//#endif

    }

//#endif


//#if 193373957
    public void actionPerformed( ActionEvent e )
    {

//#if 651859299
        try { //1

//#if 201550736
            notepad.undo.undo();
//#endif

        }

//#if -1440890706
        catch ( CannotUndoException ex ) { //1

//#if 1770595523
            System.out.println( "Unable to undo: " + ex );
//#endif


//#if 1780615874
            ex.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if 1034184740
        update();
//#endif


//#if -191166031
        notepad.redoAction.update();
//#endif

    }

//#endif

}

//#endif


//#endif

