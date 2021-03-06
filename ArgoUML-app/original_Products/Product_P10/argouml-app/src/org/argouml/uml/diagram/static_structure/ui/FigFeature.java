//    FigFeature.java 41 2010-04-03 20:04:12Z marcusvnac $
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

package org.argouml.uml.diagram.static_structure.ui;

import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;

import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.CompartmentFigText;
import org.tigris.gef.base.Selection;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.Handle;

/*
 * Fig to show features in class or interface like attributes or operations.<p>
 *
 * This class is responsible to listen to "ownerScope"
 * changes in the model, so that the text can be shown underlined
 * if the ownerScope becomes "classifier" iso "instance". <p>
 *
 * This class is abstract, since its corresponding class in the
 * UML metamodel is, too.
 *
 * @since Dec 1, 2002
 * @author jaap.branderhorst@xs4all.nl
 */
public abstract class FigFeature extends CompartmentFigText
{

    // TODO: for UML 2.x this is isStatic
    private static final String EVENT_NAME = "ownerScope";

    private static class SelectionFeature extends Selection
    {
        /*
         * Constructor for SelectionFeature.
         *
         * @param f The Fig.
         */
        public SelectionFeature(Fig f)
        {
            super(f);
        }

        /*
         * @see org.tigris.gef.base.Selection#dragHandle(int, int, int, int,
         *      org.tigris.gef.presentation.Handle)
         */
        public void dragHandle(int mx, int my, int anX, int anY, Handle h)
        {
            // Does nothing.
        }

        /*
         * @see org.tigris.gef.base.Selection#hitHandle(java.awt.Rectangle,
         *      org.tigris.gef.presentation.Handle)
         */
        public void hitHandle(Rectangle r, Handle h)
        {
            // Does nothing.
        }

        /*
         * The UID.
         */
        private static final long serialVersionUID = 7437255966804296937L;
    }

    /*
     * Constructor for FigFeature.
     *
     * @param x x
     * @param y x
     * @param w w
     * @param h h
     * @param aFig the fig
     * @param np the notation provider for the text
     * @deprecated for 0.27.3 by tfmorris. Use
     * {@link #FigFeature(Object, Rectangle, DiagramSettings, NotationProvider)}
     */
    @SuppressWarnings("deprecation")
    @Deprecated
    public FigFeature(int x, int y, int w, int h, Fig aFig,
                      NotationProvider np)
    {
        super(x, y, w, h, aFig, np);
    }

    /*
     * Construct a Feature fig.
     * @deprecated by mvw in V0.27.3. Use the constructor without np parameter.
     *
     * @param owner owning UML element
     * @param bounds position and size
     * @param settings rendering settings
     * @param np notation provider
     */
    @Deprecated
    public FigFeature(Object owner, Rectangle bounds, DiagramSettings settings,
                      NotationProvider np)
    {
        super(owner, bounds, settings, np);
        updateOwnerScope(Model.getFacade().isStatic(owner));
        Model.getPump().addModelEventListener(this, owner, EVENT_NAME);
    }

    /*
     * Construct a Feature fig
     *
     * @param owner owning UML element
     * @param bounds position and size
     * @param settings rendering settings
     */
    public FigFeature(Object owner, Rectangle bounds,
                      DiagramSettings settings)
    {
        super(owner, bounds, settings);
        updateOwnerScope(Model.getFacade().isStatic(owner));
        Model.getPump().addModelEventListener(this, owner, EVENT_NAME);
    }

    /*
     * @see org.argouml.uml.diagram.ui.FigSingleLineText#setOwner(java.lang.Object)
     */
    @SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public void setOwner(Object owner)
    {
        super.setOwner(owner);

        if (owner != null) {
            updateOwnerScope(Model.getFacade().isStatic(owner));
            Model.getPump().addModelEventListener(this, owner, EVENT_NAME);
        }
    }

    /*
     * @see org.argouml.uml.diagram.ui.FigSingleLineText#removeFromDiagram()
     */
    @Override
    public void removeFromDiagram()
    {
        Model.getPump().removeModelEventListener(this, getOwner(),
                EVENT_NAME);
        super.removeFromDiagram();
    }

    /*
     * @see org.argouml.uml.diagram.ui.FigSingleLineText#propertyChange(java.beans.PropertyChangeEvent)
     */
    @Override
    public void propertyChange(PropertyChangeEvent pce)
    {
        super.propertyChange(pce);
        if (EVENT_NAME.equals(pce.getPropertyName())) {
            // TODO: This needs to be modified for UML 2.x
            updateOwnerScope(Model.getScopeKind().getClassifier().equals(
                                 pce.getNewValue()));
        }
    }

    /*
     * @see org.tigris.gef.presentation.Fig#makeSelection()
     */
    @Override
    public Selection makeSelection()
    {
        return new SelectionFeature(this);
    }

    /*
     * @see org.tigris.gef.presentation.FigText#setTextFilled(boolean)
     */
    @Override
    public void setTextFilled(boolean filled)
    {
        super.setTextFilled(false);
    }

    /*
     * @see org.tigris.gef.presentation.Fig#setFilled(boolean)
     */
    @Override
    public void setFilled(boolean filled)
    {
        super.setFilled(false);
    }

    /*
     * Underline if the scope is Classifier.
     *
     * @param isClassifier true will cause underlining
     */
    protected void updateOwnerScope(boolean isClassifier)
    {
        setUnderline(isClassifier);
    }
}
