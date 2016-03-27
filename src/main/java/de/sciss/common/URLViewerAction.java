/*
 *  URLViewerAction.java
 *  (ScissLib)
 *
 *  Copyright (c) 2004-2016 Hanns Holger Rutz. All rights reserved.
 *
 *	This library is free software; you can redistribute it and/or
 *	modify it under the terms of the GNU Lesser General Public
 *	License as published by the Free Software Foundation; either
 *	version 2.1 of the License, or (at your option) any later version.
 *
 *	This library is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *	Lesser General Public License for more details.
 *
 *	You should have received a copy of the GNU Lesser General Public
 *	License along with this library; if not, write to the Free Software
 *	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 *	For further information, please contact Hanns Holger Rutz at
 *	contact@sciss.de
 */
package de.sciss.common;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.KeyStroke;

import net.roydesign.mac.MRJAdapter;
import de.sciss.gui.HelpFrame;
import de.sciss.gui.MenuAction;

/**
 *	Generic action for bringing up
 *	a html document either in the
 *	help viewer or the default web browser
 * 
 *	@author		Hanns Holger Rutz
 *	@version	0.10, 09-Aug-09
 */
public class URLViewerAction extends MenuAction
{
    private final String	theURL;
    private final boolean	openWebBrowser;

    /**
     * @param	theURL			what file to open ; when using the
     * 							help viewer, that's the relative help file name
     *							without .html extension. when using web browser,
     *							that's the complete URL!
     * @param text
     * @param shortcut
     * @param theURL
     * @param   openWebBrowser	if true, use the default web browser,
     *							if false use internal help viewer
     */
    public URLViewerAction( String text, KeyStroke shortcut, String theURL, boolean openWebBrowser )
    {
        super( text, shortcut );

        this.theURL			= theURL;
        this.openWebBrowser	= openWebBrowser;
    }

    /**
     *  Tries to find the component using
     *  the <code>Main</code> class' <code>getComponent</code>
     *  method. It does not instantiate a
     *  new object if the component is not found.
     *  If the window is already open, this
     *  method will bring it to the front.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( openWebBrowser ) {
            try {
                MRJAdapter.openURL( theURL );
            }
            catch( IOException e1 ) {
                BasicWindowHandler.showErrorDialog( null, e1, NAME );
            }
        } else {
            HelpFrame.openViewerAndLoadHelpFile( theURL );
        }
    }
}
