/*
 *  ComboBoxEditorBorder.java
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

import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Obsolete - now simply empty.
 */
public class ComboBoxEditorBorder
        extends AbstractBorder {

    private final Insets		insets; // , offsets;
    // private final Image			img;

//    private static final Map	mapOffsets	= new HashMap();
    private static final Map<String, Insets> mapInsets	= new HashMap<String, Insets>();

    static {
//        mapOffsets.put("Aqua", new Insets(4, 0, 2, 0));
        mapInsets.put("Aqua", new Insets(2, 0, 0, 0));
//        mapOffsets.put("Metal", new Insets(0, 0, 1, 0));
        mapInsets.put("Metal", new Insets(0, 0, 0, 0));
//        mapOffsets.put("Motif", new Insets(-1, 0, -1, 0));
        mapInsets.put("Motif", new Insets(0, 0, 0, 0));
    }

    public ComboBoxEditorBorder() {
        super();

        final String	id	= javax.swing.UIManager.getLookAndFeel().getID();
        Insets			in;

//        in		= (Insets) mapOffsets.get( id );
//        offsets	= in == null ? new Insets( 0, 0, 0, 0 ) : in;
        in		= mapInsets.get( id );
        insets	= in == null ? new Insets( 0, 0, 0, 0 ) : in;

//        final URL url = getClass().getResource( "cbe.png" );
//        img = Toolkit.getDefaultToolkit().getImage( url );
//        final MediaTracker mt = new MediaTracker( new Container() );
//        mt.addImage( img, 0 );
//
//        try {
//            mt.waitForAll( 10000 );
//        }
//        catch( InterruptedException e1 ) { /* ignore */ }
    }

    public Insets getBorderInsets( Component c )
    {
        return new Insets( insets.top, insets.left, insets.bottom, insets.right );
    }

    public Insets getBorderInsets( Component c, Insets i )
    {
        i.top		= this.insets.top;
        i.left		= this.insets.left;
        i.bottom	= this.insets.bottom;
        i.right	= this.insets.right;
        return i;
    }

    public void paintBorder( Component c, Graphics g, int x, int y, int width, int height )
    {
//        x		+= offsets.left;
//        y		+= offsets.top;
//        width	-= offsets.left + offsets.right;
//        height	-= offsets.top + offsets.bottom;
//
//        g.drawImage( img, x + width - 20, y, x + width, y + 1, 0, 0, 20, 1, c );
//        g.drawImage( img, x + width - 20, y + 1, x + width, y + height - 1, 0, 1, 20, 20, c );
//        g.drawImage( img, x + width - 20, y + height - 1, x + width, y + height, 0, 20, 20, 21, c );
    }
}