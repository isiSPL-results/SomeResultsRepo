//    ArgoFigLine.java 40 2010-04-03 19:25:46Z marcusvnac $
// Copyright (c) 2007 The Regents of the University of California. All
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

package org.argouml.gefext;

import java.awt.Color;

import javax.management.ListenerNotFoundException;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationEmitter;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;

import org.tigris.gef.presentation.FigLine;

/*
 * Primitive Fig for drawing a line in a diagram.
 *
 * @author Michiel
 */
public class ArgoFigLine extends FigLine implements NotificationEmitter
{

    private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();

    public ArgoFigLine()
    {
        super();
    }

    public ArgoFigLine(int x1, int y1, int x2, int y2)
    {
        super(x1, y1, x2, y2 );
    }

    /*
     * Create a line from x1,y1 to x2,y2 in the given color
     * @param x1 x1
     * @param y1 y1
     * @param x2 x2
     * @param y2 y2
     * @param lineColor color of line
     */
    public ArgoFigLine(int x1, int y1, int x2, int y2, Color lineColor)
    {
        super(x1, y1, x2, y2, lineColor);
    }

    /*
     * @see org.tigris.gef.presentation.Fig#deleteFromModel()
     */
    @Override
    public void deleteFromModel()
    {
        super.deleteFromModel();
        firePropChange("remove", null, null);
        notifier.sendNotification(new Notification("remove", this, 0));
    }

    /*
     * @see javax.management.NotificationEmitter#removeNotificationListener(javax.management.NotificationListener, javax.management.NotificationFilter, java.lang.Object)
     */
    public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    {
        notifier.removeNotificationListener(listener, filter, handback);
    }

    /*
     * @see javax.management.NotificationBroadcaster#addNotificationListener(javax.management.NotificationListener, javax.management.NotificationFilter, java.lang.Object)
     */
    public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    {
        notifier.addNotificationListener(listener, filter, handback);
    }

    /*
     * @see javax.management.NotificationBroadcaster#getNotificationInfo()
     */
    public MBeanNotificationInfo[] getNotificationInfo()
    {
        return notifier.getNotificationInfo();
    }

    /*
     * @see javax.management.NotificationBroadcaster#removeNotificationListener(javax.management.NotificationListener)
     */
    public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    {
        notifier.removeNotificationListener(listener);
    }

}
