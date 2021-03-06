//    DiagramFactoryInterface.java 41 2010-04-03 20:04:12Z marcusvnac $
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

package org.argouml.uml.diagram;

/*
 * An interface to be implemented by an factories for a specific diagram type.
 *
 * @author Bob Tarling
 * @deprecated for 0.27.3 by tfmorris. Use {@link DiagramFactoryInterface2}
 *             which provides the default diagram settings to the factory when
 *             the create method is invoked..
 */
@Deprecated
public interface DiagramFactoryInterface
{

    /*
     * Factory method to create a new instance of an ArgoDiagram.
     *
     * @param namespace The namespace that (in)directly
     *                        owns the elements on the diagram
     * @param machine The StateMachine for the diagram
     *                         (only: statemachine - activitygraph)
     * @return the newly instantiated diagram
     * @deprecated for 0.27.3 by tfmorris.  Use
     * {@link DiagramFactoryInterface2#createDiagram(Object, Object, DiagramSettings)}.
     */
    @Deprecated
    public ArgoDiagram createDiagram(Object namespace, final Object machine);
}
