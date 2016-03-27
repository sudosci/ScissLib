/*
 *  Param.java
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

package de.sciss.util;

import java.util.prefs.Preferences;

/**
 *  @version	0.27, 25-Sep-05
 */
public class Param
{
	public final double		val;
	public final int		unit;
	
	public Param( double val, int unit )
	{
		this.val	= val;
		this.unit	= unit;
	}
	
	public int hashCode()
	{
		final long v = Double.doubleToLongBits( val );
		
		return( (int) (v ^ (v >>> 32)) ^ unit);
	}
	
	public boolean equals( Object o )
	{
		if( (o != null) && (o instanceof Param) ) {
			final Param p2 = (Param) o;
			return( (Double.doubleToLongBits( this.val ) == Double.doubleToLongBits( p2.val )) &&
					(this.unit == p2.unit) );
		} else {
			return false;
		}
	}
 	
	public static Param fromPrefs( Preferences prefs, String key, Param defaultValue )
	{
		final String str = prefs.get( key, null );
		return( str == null ? defaultValue : Param.valueOf( str ));
	}

	public static Param valueOf( String str )
	{
		final int sepIdx = str.indexOf( ' ' );
		if( sepIdx >= 0 ) {
			return new Param( Double.parseDouble( str.substring( 0, sepIdx )),
							  ParamSpace.stringToUnit( str.substring( sepIdx + 1 )));
		} else {
			return new Param( Double.parseDouble( str ), ParamSpace.NONE );
		}
	}
	
	public String toString()
	{
		return( String.valueOf( val ) + ' ' + ParamSpace.unitToString( unit ));
	}
}
