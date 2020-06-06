package voxel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;

public class renderer {
	Matrix4f projection;
	static float fov=70f;
	static float np=0.01f;
	static float fp=100000f;
	float aspect=(float)Display.getWidth()/(float)Display.getHeight();
	staticshp shader=new staticshp();
	drawmodels d=new drawmodels();
	Map<simpletexture, List<ent>> entities=new HashMap<simpletexture, List<ent>>();
	
	public renderer()
	{
		proj();
		shader.start();
		shader.loadprojection(projection);
		shader.stop();
		
	}
	
	public void initial()
	{GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClearColor(0.4f, 0.7f, 1.0f, 1);
	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
	}
	
	public void ren(cam camera) {
		initial();
		shader.start();
		shader.loadview(camera);
		
		d.draw(entities);
		shader.stop();
		entities.clear();
			
	}
public void add(ent entity) {
		
		simpletexture sim = entity.getSim();
		
		List<ent> batch = entities.get(sim);
		
		if (batch != null) {
			batch.add(entity);
		} else {
			
			List<ent> batch1 = new ArrayList<ent>();
			batch1.add(entity);
			entities.put(sim, batch1);
			
		}
		
	}
	public void proj()
	
	{
		projection=new Matrix4f();
		float y=(float) (1/Math.tan(Math.toRadians(fov/2f)));
	float x=y/aspect;
	float zp=fp+np;
	float zm=fp-np;
	projection.m00=x;
	projection.m11=y;
	projection.m22=-zp/zm;
	projection.m23=-1;
	projection.m32=-(2*fp*np)/zm;
	
	
		
		
	}

	
}
