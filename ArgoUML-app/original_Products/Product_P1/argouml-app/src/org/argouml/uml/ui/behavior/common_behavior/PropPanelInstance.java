//    PropPanelInstance.java 41 2010-04-03 20:04:12Z marcusvnac $
// Copyright (c) 1996-2007 The Regents of the University of California. All
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

package org.argouml.uml.ui.behavior.common_behavior;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.argouml.uml.ui.foundation.core.PropPanelModelElement;

/*
 * The abstract properties panel for any type of Instance.
 *
 * @author jrobbins
 */
public abstract class PropPanelInstance extends PropPanelModelElement
{

    private JPanel stimuliSenderScroll;

    private JPanel stimuliReceiverScroll;

    private static UMLInstanceSenderStimulusListModel stimuliSenderListModel
        = new UMLInstanceSenderStimulusListModel();

    private static UMLInstanceReceiverStimulusListModel
    stimuliReceiverListModel = new UMLInstanceReceiverStimulusListModel();

    /*
     * Construct a property panel for an Instance with the given name, icon and
     * orientation.
     *
     * @param name the name for the properties panel
     * @param icon the icon shown next to the name
     */
    public PropPanelInstance(String name, ImageIcon icon)
    {
        super(name, icon);
    }


    /*
     * @return the scrollpane for stimuli sender
     */
    protected JPanel getStimuliSenderScroll()
    {
        if (stimuliSenderScroll == null) {
            stimuliSenderScroll = getSingleRowScroll(stimuliSenderListModel);
        }
        return stimuliSenderScroll;
    }

    /*
     * @return the scrollpane for stimuli receiver
     */
    protected JPanel getStimuliReceiverScroll()
    {
        if (stimuliReceiverScroll == null) {
            stimuliReceiverScroll =
                getSingleRowScroll(stimuliReceiverListModel);
        }
        return stimuliReceiverScroll;
    }
}
