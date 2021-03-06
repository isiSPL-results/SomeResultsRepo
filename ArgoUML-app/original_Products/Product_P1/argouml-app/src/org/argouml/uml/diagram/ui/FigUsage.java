//    FigUsage.java 41 2010-04-03 20:04:12Z marcusvnac $
// Copyright (c) 1996-2008 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
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

package org.argouml.uml.diagram.ui;

import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.base.Layer;

/*
 * This class represents a Fig for a Usage.
 *
 * @author Markus Klink
 */
public class FigUsage extends FigDependency
{

    /*
     * The constructor.
     * @deprecated for 0.27.3 by tfmorris. Use
     *             {@link #FigUsage(Object, DiagramSettings)}.
     */
    @SuppressWarnings("deprecation")
    @Deprecated
    public FigUsage()
    {
        super();
    }

    /*
     * The constructor.
     *
     * @param edge the owning UML element
     * @deprecated for 0.27.3 by tfmorris. Use
     *             {@link #FigUsage(Object, DiagramSettings)}.
     */
    @SuppressWarnings("deprecation")
    @Deprecated
    public FigUsage(Object edge)
    {
        super(edge);
    }

    /*
     * The constructor.
     *
     * @param edge the owning UML element
     * @param lay the layer
     * @deprecated for 0.27.3 by tfmorris. Use
     *             {@link #FigUsage(Object, DiagramSettings)}.
     */
    @SuppressWarnings("deprecation")
    @Deprecated
    public FigUsage(Object edge, Layer lay)
    {
        super(edge, lay);
    }

    /*
     * Construct a Fig.
     *
     * @param owner owning UML element
     * @param settings render settings
     */
    public FigUsage(Object owner, DiagramSettings settings)
    {
        super(owner, settings);
    }

    /*
     * The UID.
     */
    private static final long serialVersionUID = -1805275467987372774L;
}

