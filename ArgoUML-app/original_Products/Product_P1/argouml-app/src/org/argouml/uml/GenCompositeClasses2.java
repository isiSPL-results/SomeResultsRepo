//    GenCompositeClasses2.java 41 2010-04-03 20:04:12Z marcusvnac $
// Copyright (c) 2008 The Regents of the University of California. All
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

package org.argouml.uml;

import java.util.Iterator;

import org.argouml.util.ChildGenerator;

/*
 * Utility class to generate a list of the "children" of a class which are the
 * other classes that are associated with the parent class, and that Association
 * has a COMPOSITE end at the parent. This is used in one of the critics.
 *
 * @see org.argouml.uml.cognitive.critics.CrCircularComposition
 * @stereotype singleton
 */
public class GenCompositeClasses2 extends GenCompositeClasses implements
    ChildGenerator
{

    /*
     * This SINGLETON is used in CrCircularComposition.
     *
     */
    private static final GenCompositeClasses2 SINGLETON =
        new GenCompositeClasses2();

    /*
     * @return Return the singleton
     */
    public static GenCompositeClasses2 getInstance()
    {
        return SINGLETON;
    }

    public Iterator childIterator(Object parent)
    {
        return collectChildren(parent).iterator();
    }

}
