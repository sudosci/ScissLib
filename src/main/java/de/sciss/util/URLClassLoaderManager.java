/*
 *  URLClassLoaderManager.java
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

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class URLClassLoaderManager
{
	private final ClassLoader		parent;
	private DynamicURLClassLoader 	loader;
	private Set						urls	= new HashSet();
	
	public URLClassLoaderManager()
	{
		parent = null;
		makeLoader();
	}

	public URLClassLoaderManager( ClassLoader parent )
	{
		this.parent = parent;
		makeLoader();
	}
	
	private void makeLoader()
	{
		final Object[]	urlsA	= this.urls.toArray();
		final URL[]		urlsTA	= new URL[ urlsA.length ];
		for( int i = 0; i < urlsA.length; i++ ) urlsTA[ i ] = (URL) urlsA[ i ];
		loader = parent == null ?	new DynamicURLClassLoader( urlsTA ) :
									new DynamicURLClassLoader( urlsTA, parent );
	}

	public void addURL( URL url )
	{
		loader.addURL( url );
		urls.add( url );
	}
	
	public void addURLs( URL[] u )
	{
		loader.addURLs( u );
		for( int i = 0; i < u.length; i++ ) this.urls.add( u[ i ]);
	}

	public void removeURL( URL url )
	{
		if( urls.remove( url )) makeLoader();
	}
	
	public void removeURLs( URL[] u )
	{
		boolean changed = false;
		for( int i = 0; i < u.length; i++ ) changed |= this.urls.remove( u[ i ]);
		if( changed ) makeLoader();
	}

	public ClassLoader getCurrentLoader()
	{
		return loader;
	}
}