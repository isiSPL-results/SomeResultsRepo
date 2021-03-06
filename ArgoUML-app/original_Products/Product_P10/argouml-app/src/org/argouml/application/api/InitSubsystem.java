//    InitSubsystem.java 34 2010-04-03 19:12:23Z marcusvnac $
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

package org.argouml.application.api;

import java.util.List;


/*
 * Any subsystem that needs to initialise itself,
 * could implement this interface.
 * The Main class (or any other top-level class
 * that knows about the subsystem) then takes care
 * of the initialisation,
 * without causing dependency cycles.
 *
 * @author Michiel
 */
public interface InitSubsystem
{

    /*
     * ArgoUML shall call this at initialisation time,
     * before the other operations in this interface are called.
     * <p>
     * Use it at will.
     */
    public void init();

    /*
     * This method shall not return null.
     *
     * @return an ordered list of tab panels
     * to be added to the settings dialog
     */
    public List<GUISettingsTabInterface> getSettingsTabs();

    /*
     * This method shall not return null.
     *
     * @return an ordered list of tab panels
     * to be added to the project-settings dialog
     */
    public List<GUISettingsTabInterface> getProjectSettingsTabs();

    /*
     * This method shall not return null.
     *
     * @return an ordered list of Tabs
     * to be added to the DetailsPanel
     */
    public List<AbstractArgoJPanel> getDetailsTabs();
}
