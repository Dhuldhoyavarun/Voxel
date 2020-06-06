package voxel;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Matrix4f;

public class staticshp extends shp{

private static String vfile="/voxel/vs.txt";
private static String ffile="/voxel/fs.txt";
int loctr;
int locpr;
int locv;
public staticshp()  { super(vfile,ffile);}

@Override
protected void abin()
{super.abi("position", 0);
super.abi("tc", 1);
	}

@Override
protected void getlocs() {
	loctr=super.getloc("transform");
	locpr=super.getloc("projection");
	locv=super.getloc("view");
}
	public void loadtransform(Matrix4f mat)
	{
		FloatBuffer m=BufferUtils.createFloatBuffer(16);
		mat.store(m);
		m.flip();
		GL20.glUniformMatrix4(loctr, false, m);
		
	}
	public void loadprojection(Matrix4f mat)
	{
		FloatBuffer m=BufferUtils.createFloatBuffer(16);
		mat.store(m);
		m.flip();
		GL20.glUniformMatrix4(locpr, false, m);
		
	}
	public void loadview(cam camera)
	{
		FloatBuffer m=BufferUtils.createFloatBuffer(16);
		maths.view(camera).store(m);
		m.flip();
		GL20.glUniformMatrix4(locv, false, m);
		
	}

}
