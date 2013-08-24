/*
 *  EmptyInternalFrameUI.java
 *  (ScissLib)
 *
 *  Copyright (c) 2004-2013 Hanns Holger Rutz. All rights reserved.
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

package de.sciss.gui;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 * 	A rather quick and dirty hack to be able
 * 	to produce borderless JInternalFrames.
 * 	This extends EmptyInternalFrameUI by
 * 	not creating the title bar and not
 * 	installing the mouse listeners that will
 * 	allow you to resize the window from its
 * 	borders.
 * 
 *	@author		Hanns Holger Rutz
 *	@version	0.10, 01-Aug-08
 */
public class EmptyInternalFrameUI
extends BasicInternalFrameUI	// BasicInternalFrameUI
{
    public EmptyInternalFrameUI( JInternalFrame b )
    {
    	super( b );
    }
	
    protected JComponent createNorthPane( JInternalFrame w )
    {
        return null;
    }

// this causes problems!
// instead make sure resizable is kept false
//    protected void installMouseHandlers( JComponent c )
//    {
//    	// nada
//    }
}
