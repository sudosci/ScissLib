/*
 *  GradientPanel.java
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

import javax.swing.*;
import java.awt.*;

public class GradientPanel
extends JPanel
{
    private static final Paint		pntTopBorderLight    = new GradientPaint(  0, 0, new Color( 0xFF, 0xFF, 0xFF, 0xFF ),
            0, 8, new Color( 0xFF, 0xFF, 0xFF, 0x00 ));
    private static final Paint		pntBottomBorderLight = new GradientPaint(  0, 0, new Color( 0x9F, 0x9F, 0x9F, 0x00 ),
            0, 8, new Color( 0x9F, 0x9F, 0x9F, 0xFF ));

    private static final Paint pntTopBorderDark     = new GradientPaint(0, 0, new Color(0xFF, 0xFF, 0xFF, 0x4F),
            0, 8, new Color(0xFF, 0xFF, 0xFF, 0x00));
    private static final Paint pntBottomBorderDark  = new GradientPaint(0, 0, new Color(0x00, 0x00, 0x00, 0x00),
            0, 8, new Color(0x00, 0x00, 0x00, 0x7F));

    private GradientPaint	grad			= null;
    private boolean			topBorder		= false;
    private boolean			bottomBorder	= false;
    private int				gradXShift		= 0;
    private int				gradYShift		= 0;

    private static boolean isDark() { return UIManager.getBoolean("dark-skin"); }

    public static Paint pntTopBorder() {
        return isDark() ? pntTopBorderDark : pntTopBorderLight;
    }

    public static Paint pntBottomBorder() {
        return isDark() ? pntBottomBorderDark : pntBottomBorderLight;
    }

    public GradientPanel() {
        super();

        setOpaque(true);
    }

    public void setGradient(GradientPaint grad) {
        this.grad = grad;
        repaint();
    }

    public void setGradientShift(int x, int y) {
        gradXShift = x;
        gradYShift = y;
        repaint();
    }

    public void setTopBorder(boolean b) {
        topBorder = b;
        repaint();
    }

    public void setBottomBorder(boolean b) {
        bottomBorder = b;
        repaint();
    }

    public void paintComponent(Graphics g) {
        final Graphics2D g2 = (Graphics2D) g;
        final int w = getWidth();
        final int h = getHeight();

        if (grad != null) {
            g2.setPaint(grad);
            g2.translate(-gradXShift, -gradYShift);
            g2.fillRect(gradXShift, gradYShift, w, h);
            g2.translate(gradXShift, gradYShift);
        } else {
            super.paintComponent(g);
        }
        if (bottomBorder) {
            g2.translate(0, h - 8);
            g2.setPaint(pntBottomBorder());
            g2.fillRect(0, 0, w, 8);
            g2.translate(0, 8 - h);
        }
    }

    public void paintChildren(Graphics g) {
        super.paintChildren(g);

        if (topBorder) {
            final Graphics2D g2 = (Graphics2D) g;
            final int w = getWidth();
            g2.setPaint(pntTopBorder());
            g2.fillRect(0, 0, w, 8);
        }
    }
}
