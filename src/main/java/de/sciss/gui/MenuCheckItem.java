/*
 *  MenuCheckItem.java
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

package de.sciss.gui;

import java.util.Iterator;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;

/**
 *  @author		Hanns Holger Rutz
 *  @version	0.70, 30-Aug-06
 */
public class MenuCheckItem
extends MenuItem
{
    private boolean checked = false;

    public MenuCheckItem( String id, Action a )
    {
        super( id, a );
    }

    public void setSelected( boolean b )
    {
        Realized r;

        for( Iterator iter = mapRealized.values().iterator(); iter.hasNext(); ) {
            r = (Realized) iter.next();
            ((AbstractButton) r.c).setSelected( b );
        }

        checked = b;
    }

    public boolean isSelected()
    {
        return checked;
    }

    protected JComponent createComponent( Action a )
    {
        final JCheckBoxMenuItem cmi = new JCheckBoxMenuItem( a );
        if( checked ) cmi.setSelected( true );
        return cmi;
    }
}