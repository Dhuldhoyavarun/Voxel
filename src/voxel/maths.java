package voxel;



import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;



public class maths {
	
	public static Matrix4f transformation(Vector3f translation, float rox, float roy, float roz, float s) {
		
		Matrix4f mat = new Matrix4f();
		mat.setIdentity();
		
		Matrix4f.translate(translation, mat, mat);
		Matrix4f.rotate((float) Math.toRadians(rox), new Vector3f(1, 0, 0),  mat, mat);
		Matrix4f.rotate((float) Math.toRadians(roy), new Vector3f(0, 1, 0),  mat, mat);
		Matrix4f.rotate((float) Math.toRadians(roz), new Vector3f(0, 0, 1),  mat, mat);
		Matrix4f.scale(new Vector3f(s, s, s), mat, mat);
		
		return mat;
		
	}
	
	public static Matrix4f view(cam camera) {
		
		Matrix4f mat = new Matrix4f();
		mat.setIdentity();
		
		Matrix4f.rotate((float) Math.toRadians(camera.getRox()), new Vector3f(1, 0, 0),  mat, mat);
		Matrix4f.rotate((float) Math.toRadians(camera.getRoy()), new Vector3f(0, 1, 0),  mat, mat);
		Matrix4f.rotate((float) Math.toRadians(camera.getRoz()), new Vector3f(0, 0, 1),  mat, mat);
		Matrix4f.translate(new Vector3f(-camera.getPos().x, -camera.getPos().y, -camera.getPos().z), mat, mat);
		
		return mat;
		
	}

}
