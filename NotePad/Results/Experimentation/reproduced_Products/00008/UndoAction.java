import java.awt.event.*;
import javax.swing.*;
import javax.swing.undo.*;
class UndoAction extends AbstractAction
{
    private static final long serialVersionUID = 1;
    Notepad notepad;
    public UndoAction(Notepad notepad)
    {
        super( "Undo" );
        putValue( Action.SMALL_ICON,
                  new ImageIcon( this.getClass().getResource( "images/undo.gif" ) ) );
        setEnabled( false );
        this.notepad = notepad;
    }
    protected void update()
    {
        if(notepad.undo.canUndo()) { //1
            setEnabled( true );
            putValue( "Undo", notepad.undo.getUndoPresentationName() );
        } else {
            setEnabled( false );
            putValue( Action.NAME, "Undo" );
        }
    }
    public void actionPerformed( ActionEvent e )
    {
        try { //1
            notepad.undo.undo();
        } catch ( CannotUndoException ex ) { //1
            System.out.println( "Unable to undo: " + ex );
            ex.printStackTrace();
        }
        update();
        notepad.redoAction.update();
    }

}
