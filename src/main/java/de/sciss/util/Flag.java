/*
 *  Flag.java
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

/**
 *	A mutable Boolean essentially.
 *
 *	@version	0.11, 21-Apr-08
 *	@author		Hanns Holger Rutz
 */
public class Flag
{
	private boolean	value;
	
	public Flag( boolean onOff )
	{
		value = onOff;
	}
	
	public boolean isSet()
	{
		return value;
	}
	
	public void set( boolean onOff )
	{
		value = onOff;
	}

	public String toString()
	{
		return "Flag( " + value + " )";
	}
}