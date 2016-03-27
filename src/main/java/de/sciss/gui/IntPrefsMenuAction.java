/*
 *  IntPrefsMenuAction.java
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

import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;

/**
 *	Adds PreferenceEntrySync functionality to the superclass
 *	note that unlike PrefCheckBox and the like, it's only
 *	valid to listen to the prefs changes, not the action events
 *
 *  @author		Hanns Holger Rutz
 *  @version	0.10, 10-Sep-06
 */
public class IntPrefsMenuAction
extends PrefMenuAction
{
    private final int		id;
    private MenuRadioGroup	g;

    public IntPrefsMenuAction( String text, KeyStroke shortcut, int id )
    {
        super( text, shortcut );
        this.id = id;
    }

    public void setRadioGroup( MenuRadioGroup g )
    {
        this.g = g;
    }

    /**
     *  Fired when radio button is checked
     */
    public void actionPerformed( ActionEvent e )
    {
        if( shouldWritePrefs() ) {
            if( getPreferenceNode().getInt( getPreferenceKey(), -1 ) != id ) {
                getPreferenceNode().putInt( getPreferenceKey(), id );
            }
        }
    }

    protected void readPrefsFromString( String prefsValue )
    {
        if( prefsValue == null ) return;
        final int prefsVal	= Integer.parseInt( prefsValue );

        if( (prefsVal == id) && (g != null) ) g.setSelected( id );
    }

    public void writePrefs()
    {
        if( canWritePrefs() ) {
            getPreferenceNode().putInt( getPreferenceKey(), id );
        }
    }
}

