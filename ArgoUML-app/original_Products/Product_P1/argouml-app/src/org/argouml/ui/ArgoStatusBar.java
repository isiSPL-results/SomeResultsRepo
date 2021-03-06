//    ArgoStatusBar.java 41 2010-04-03 20:04:12Z marcusvnac $
// Copyright (c) 2007-2008 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies. This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason. IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.ui;

import java.text.MessageFormat;

import javax.swing.SwingUtilities;

import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.application.events.ArgoHelpEventListener;
import org.argouml.application.events.ArgoStatusEvent;
import org.argouml.application.events.ArgoStatusEventListener;
import org.argouml.i18n.Translator;
import org.tigris.gef.ui.IStatusBar;

/*
 * A StatusBar that registers itself with the ArgoEventPump to receive
 * help and status events.
 *
 * @author Tom Morris <tfmorris@gmail.com>
 */
public class ArgoStatusBar extends StatusBar implements IStatusBar,
    ArgoStatusEventListener, ArgoHelpEventListener
{

    /*
     * Default constructor.  Registers itself to receive Help & Status events
     * from the ArgoUML event pump.
     */
    public ArgoStatusBar()
    {
        super();
        ArgoEventPump.addListener(ArgoEventTypes.ANY_HELP_EVENT, this);
        ArgoEventPump.addListener(ArgoEventTypes.ANY_STATUS_EVENT, this);
    }

    public void projectLoaded(ArgoStatusEvent e)
    {
        String status = MessageFormat.format(
                            Translator.localize("statusmsg.bar.open-project-status-read"),
                            new Object[] {e.getText()});
        showStatusOnSwingThread(status);
    }

    public void projectModified(ArgoStatusEvent e)
    {
        String status = MessageFormat.format(
                            Translator.localize("statusmsg.bar.project-modified"),
                            new Object[] {e.getText()});
        showStatusOnSwingThread(status);
    }

    public void projectSaved(ArgoStatusEvent e)
    {
        String status = MessageFormat.format(
                            Translator.localize("statusmsg.bar.save-project-status-wrote"),
                            new Object[] {e.getText()});
        showStatusOnSwingThread(status);
    }

    public void statusCleared(ArgoStatusEvent e)
    {
        showStatusOnSwingThread("");
    }

    public void statusText(ArgoStatusEvent e)
    {
        showStatusOnSwingThread(e.getText());
    }

    public void helpChanged(ArgoHelpEvent e)
    {
        showStatusOnSwingThread(e.getHelpText());
    }

    public void helpRemoved(ArgoHelpEvent e)
    {
        showStatusOnSwingThread("");
    }

    // We don't know what thread events will be delivered on, so make sure
    // we run Swing methods on the Swing thread
    private void showStatusOnSwingThread(final String status)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showStatus(status);
            }
        });
    }

}
