package voxel;

import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;

public class drawmodels {
 

staticshp s=new staticshp();
	public void draw(Map<simpletexture, List<ent>> entities) {
		
		for (simpletexture sim : entities.keySet()) {
			
			GL30.glBindVertexArray(sim.getSim().getIdvao());
			GL20.glEnableVertexAttribArray(0);
			GL20.glEnableVertexAttribArray(1);
			
			GL13.glActiveTexture(GL13.GL_TEXTURE0);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, sim.getT().getTid());
			
			List<ent> batch = entities.get(sim);
			
			for (ent entity : batch) {
				
				Matrix4f transform = maths.transformation(entity.getPos(), entity.getRox(), entity.getRoy(), entity.getRoz(), entity.getS());
				s.loadtransform(transform);
				
				GL11.glDrawElements(GL11.GL_TRIANGLES,sim.getSim().getVc(),GL11.GL_UNSIGNED_INT,0);
				
			}
			
			GL20.glDisableVertexAttribArray(0);
			GL20.glDisableVertexAttribArray(1);
			GL30.glBindVertexArray(0);
			
		}
}
}
