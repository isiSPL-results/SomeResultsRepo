


//    CollabDiagramRenderer.java 127 2010-09-25 22:23:13Z marcusvnac $
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

package org.argouml.uml.diagram.collaboration.ui;

import java.util.Map;




import org.apache.log4j.Logger;

import org.argouml.model.Model;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.UmlDiagramRenderer;
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
import org.argouml.uml.diagram.ui.FigDependency;
import org.argouml.uml.diagram.ui.FigGeneralization;
import org.argouml.uml.diagram.ui.UMLDiagram;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerPerspective;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;

/*
 * This class defines a renderer object for UML Collaboration Diagrams.
 * In a collaboration Diagram the following UML objects are displayed with the
 * following Figs:<p>
 *
 * <pre>
 *   UML Object       ---  Fig
 *   ---------------------------------------
 *   MClassifierRole  ---  FigClassifierRole
 *   MMessage         ---  FigMessage
 *   MComment         ---  FigComment
 * </pre>
 *
 * Provides {@link #getFigNodeFor} to implement the
 * {@link org.tigris.gef.graph.GraphNodeRenderer} interface and
 * {@link #getFigEdgeFor} to implement the
 * {@link org.tigris.gef.graph.GraphEdgeRenderer} interface.<p>
 *
 * <em>Note</em>. Should be implemented as a singleton - we don't really
 * need a separate instance for each use case diagram.<p>
 *
 *
 * @author agauthie
 */
public class CollabDiagramRenderer extends UmlDiagramRenderer
{



    /*
     * Logger.
     */
    private static final Logger LOG =
        Logger.getLogger(CollabDiagramRenderer.class);

    /*
     * @see org.tigris.gef.graph.GraphNodeRenderer#getFigNodeFor(
     *         org.tigris.gef.graph.GraphModel, org.tigris.gef.base.Layer,
     *         java.lang.Object, java.util.Map)
     */
    public FigNode getFigNodeFor(GraphModel gm, Layer lay,
                                 Object node, Map styleAttributes)
    {

        FigNode figNode = null;

        assert node != null;

        // Although not generally true for GEF, for Argo we know that the layer
        // is a LayerPerspective which knows the associated diagram
        Diagram diag = ((LayerPerspective) lay).getDiagram();
        if (diag instanceof UMLDiagram
                && ((UMLDiagram) diag).doesAccept(node)) {
            figNode = ((UMLDiagram) diag).drop(node, null);
        } else {



            LOG.error("TODO: CollabDiagramRenderer getFigNodeFor");

            throw new IllegalArgumentException(
                "Node is not a recognised type. Received "
                + node.getClass().getName());
        }

        lay.add(figNode);
        return figNode;
    }

    /*
     * Return a Fig that can be used to represent the given edge,
     * Generally the same code as for the ClassDiagram, since its
     * very related to it.
     *
     * {@inheritDoc}
     */
    public FigEdge getFigEdgeFor(GraphModel gm, Layer lay,
                                 Object edge, Map styleAttributes)
    {




        if (LOG.isDebugEnabled()) {
            LOG.debug("making figedge for " + edge);
        }

        if (edge == null) {
            throw new IllegalArgumentException("A model edge must be supplied");
        }

        assert lay instanceof LayerPerspective;
        ArgoDiagram diag = (ArgoDiagram) ((LayerPerspective) lay).getDiagram();
        DiagramSettings settings = diag.getDiagramSettings();

        FigEdge newEdge = null;
        if (Model.getFacade().isAAssociationRole(edge)) {
            newEdge = new FigAssociationRole(edge, settings);
        } else if (Model.getFacade().isAGeneralization(edge)) {
            newEdge = new FigGeneralization(edge, settings);
        } else if (Model.getFacade().isADependency(edge)) {
            newEdge = new FigDependency(edge, settings);
        } else if (edge instanceof CommentEdge) {
            newEdge = new FigEdgeNote(edge, settings); // TODO -> settings
        }

        if (newEdge == null) {
            throw new IllegalArgumentException(
                "Don't know how to create FigEdge for model type "
                + edge.getClass().getName());
        }

        setPorts(lay, newEdge);

        assert newEdge != null : "There has been no FigEdge created";
        assert (newEdge.getDestFigNode() != null)
        : "The FigEdge has no dest node";
        assert (newEdge.getDestPortFig() != null)
        : "The FigEdge has no dest port";
        assert (newEdge.getSourceFigNode() != null)
        : "The FigEdge has no source node";
        assert (newEdge.getSourcePortFig() != null)
        : "The FigEdge has no source port";

        lay.add(newEdge);
        return newEdge;
    }
}