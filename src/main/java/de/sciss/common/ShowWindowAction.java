/*
 *  ShowWindowAction.java
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

import de.sciss.app.AbstractApplication;
import de.sciss.app.AbstractWindow;
import de.sciss.gui.MenuAction;
import de.sciss.util.Disposable;

/**
 * 	@version	0.11, 28-Jun-08
 *	@author		Hanns Holger Rutz
 *
 */
public class ShowWindowAction
extends MenuAction
implements Disposable
{
    private final AbstractWindow			w;
    private final AbstractWindow.Listener	l;
    protected boolean						disposed	= false;

    public ShowWindowAction( AbstractWindow w )
    {
        super( null, null );
        this.w	= w;

        l = new AbstractWindow.Adapter() {
            public void windowActivated( AbstractWindow.Event e )
            {
                if( !disposed ) ((BasicApplication) AbstractApplication.getApplication()).getMenuFactory().setSelectedWindow( ShowWindowAction.this );
            }
        };
        w.addListener( l );
    }

    public void actionPerformed( ActionEvent e )
    {
        w.setVisible( true );
        w.toFront();
    }

    public void dispose()
    {
        disposed = true;	// the listener might still be called!
        w.removeListener( l );
    }
}