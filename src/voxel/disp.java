package voxel;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class disp {
static int width=1200;
static int height=600;
static int fcap=120;
public static void dispc() 
{ContextAttribs att=new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
	try {
	Display.setDisplayMode(new DisplayMode(width,height));
	Display.create(new PixelFormat(), att);
	Display.setTitle("ICG");
	GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
} catch (LWJGLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

public static void dispup() 
{
Display.sync(fcap);
Display.update();
}

public static void dispdes() {
	voxel.r1.deallocate();
	voxel.s1.deallocate();
	Display.destroy();
	System.exit(0);
}
}
