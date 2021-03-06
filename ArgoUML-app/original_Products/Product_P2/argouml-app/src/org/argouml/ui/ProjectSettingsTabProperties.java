//    ProjectSettingsTabProperties.java 41 2010-04-03 20:04:12Z marcusvnac $
// Copyright (c) 2006-2008 The Regents of the University of California. All
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

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.argouml.application.api.Argo;
import org.argouml.application.api.GUISettingsTabInterface;
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;

/*
 * Tab Panel for setting the project attributes:
 * author name and email, project description.
 * These are stored in the project file.
 *
 * @author Michiel
 */
public class ProjectSettingsTabProperties extends JPanel implements
    GUISettingsTabInterface
{
    /*
     * This is where the user enters full name in settings tab.
     * This information is stored in the zargo file.
     */
    private JTextField userFullname;

    /*
     * This is where the user enters email in settings tab.
     * This information is stored in the zargo file.
     */
    private JTextField userEmail;

    /*
     * This is where the user enters a description of the project
     * in the settings tab.
     * This information is stored in the zargo file.
     */
    private JTextArea description;

    /*
     * This is where the ArgoUML version that last saved this project
     * is shown in the settings tab.
     * This information is stored in the zargo file.
     */
    private JTextField version;

    /*
     * The constructor.
     */
    ProjectSettingsTabProperties()
    {
        setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.setLayout(new GridBagLayout());

        GridBagConstraints labelConstraints = new GridBagConstraints();
        /* Labels at the left ... */
        labelConstraints.anchor = GridBagConstraints.LINE_START;
        labelConstraints.gridy = 0;
        labelConstraints.gridx = 0;
        labelConstraints.gridwidth = 1;
        labelConstraints.gridheight = 1;
        labelConstraints.insets = new Insets(2, 20, 2, 4);
        labelConstraints.anchor =
            GridBagConstraints.FIRST_LINE_START;

        GridBagConstraints fieldConstraints = new GridBagConstraints();
        /* ... and fields at the right. */
        fieldConstraints.anchor = GridBagConstraints.LINE_END;
        fieldConstraints.fill = GridBagConstraints.BOTH;
        fieldConstraints.gridy = 0;
        fieldConstraints.gridx = 1;
        fieldConstraints.gridwidth = 3;
        fieldConstraints.gridheight = 1;
        fieldConstraints.weightx = 1.0;
        fieldConstraints.insets = new Insets(2, 4, 2, 20);

        /* The user's full name: */
        labelConstraints.gridy = 0;
        fieldConstraints.gridy = 0;
        top.add(new JLabel(Translator.localize("label.user")),
                labelConstraints);
        userFullname = new JTextField();
        top.add(userFullname, fieldConstraints);

        /* The user's email: */
        labelConstraints.gridy = 1;
        fieldConstraints.gridy = 1;
        top.add(new JLabel(Translator.localize("label.email")),
                labelConstraints);
        userEmail = new JTextField();
        top.add(userEmail, fieldConstraints);

        /* The project description: */
        labelConstraints.gridy = 2;
        fieldConstraints.gridy = 2;
        fieldConstraints.weighty = 1.0;
        labelConstraints.weighty = 1.0;
        JLabel lblDescription = new JLabel(
            Translator.localize("label.project.description"));
        lblDescription.setVerticalAlignment(SwingConstants.TOP);
        top.add(lblDescription,
                labelConstraints);
        description = new JTextArea();
        JScrollPane area = new JScrollPane(description);
        area.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        description.setMargin(new Insets(3, 3, 3, 3));
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        top.add(area, fieldConstraints);

        /* This non-editable field shows
         * the version of the ArgoUML
         * that last saved this project: */
        labelConstraints.gridy = 3;
        fieldConstraints.gridy = 3;
        fieldConstraints.weighty = 0.0;
        labelConstraints.weighty = 0.0;
        top.add(new JLabel(Translator.localize("label.argouml.version")),
                labelConstraints);
        version = new JTextField();
        version.setEditable(false);
        top.add(version, fieldConstraints);

        /* We need to fill the whole pane,
         * so that the description field can
         * take all available space: */
        add(top, BorderLayout.CENTER);
    }

    /*
     * @see org.argouml.ui.GUISettingsTabInterface#handleSettingsTabRefresh()
     */
    public void handleSettingsTabRefresh()
    {
        Project p = ProjectManager.getManager().getCurrentProject();
        userFullname.setText(p.getAuthorname());
        userEmail.setText(p.getAuthoremail());
        description.setText(p.getDescription());
        description.setCaretPosition(0);
        version.setText(p.getVersion());
    }

    /*
     * @see org.argouml.ui.GUISettingsTabInterface#handleSettingsTabSave()
     */
    public void handleSettingsTabSave()
    {
        Project p = ProjectManager.getManager().getCurrentProject();
        p.setAuthorname(userFullname.getText());
        p.setAuthoremail(userEmail.getText());
        p.setDescription(description.getText());
    }

    /*
     * @see org.argouml.ui.GUISettingsTabInterface#handleSettingsTabCancel()
     */
    public void handleSettingsTabCancel()
    {
        handleSettingsTabRefresh();
    }

    /*
     * @see org.argouml.ui.GUISettingsTabInterface#handleResetToDefault()
     */
    public void handleResetToDefault()
    {
        userFullname.setText(Configuration.getString(Argo.KEY_USER_FULLNAME));
        userEmail.setText(Configuration.getString(Argo.KEY_USER_EMAIL));
        // There is no default description.
    }

    /*
     * @see org.argouml.ui.GUISettingsTabInterface#getTabKey()
     */
    public String getTabKey()
    {
        return "tab.user";
    }

    /*
     * @see org.argouml.ui.GUISettingsTabInterface#getTabPanel()
     */
    public JPanel getTabPanel()
    {
        return this;
    }

}
