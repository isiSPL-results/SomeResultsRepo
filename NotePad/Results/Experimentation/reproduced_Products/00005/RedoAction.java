import java.awt.event.*;
import javax.swing.*;
import javax.swing.undo.*;
class RedoAction extends AbstractAction
{
    private static final long serialVersionUID = 1;
    Notepad notepad;
    protected void update()
    {
        if(notepad.undo.canRedo()) { //1
            setEnabled(true);
            putValue("Redo", notepad.undo.getRedoPresentationName());
        } else {
            setEnabled(false);
            putValue(Action.NAME, "Redo");
        }
    }
    public RedoAction(Notepad notepad)
    {
        super("Redo");
        putValue( Action.SMALL_ICON,
                  new ImageIcon(this.getClass().getResource("images/redo.gif")));
        setEnabled(false);
        this.notepad = notepad;
    }
    public void actionPerformed(ActionEvent e)
    {
        try { //1
            notepad.undo.redo();
        } catch (CannotRedoException ex) { //1
            System.out.println("Unable to redo: " + ex);
            ex.printStackTrace();
        }
        update();
        notepad.undoAction.update();
    }

}
