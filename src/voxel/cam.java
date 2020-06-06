package voxel;



import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class cam {
	
	Vector3f pos;
	float rox;
	float roy;
	float roz;
	
	private static final float speed = 0.3f; 
	private static final float turnSpeed = 0.1f; 
	float moveAt = 0;
	float offsetx=0;
	float offsety=0;
	
	public cam(Vector3f pos, float rox, float roy, float roz) {

		this.pos = pos;
		this.rox = rox;
		this.roy = roy;
		this.roz = roz;
		
	}
	
	public void move() {
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			moveAt = -speed;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			moveAt = speed;
		} else {
			moveAt = 0;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			offsetx=-speed;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			offsetx=speed;
		}
		
		else {
			offsetx=0;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_G)) {
			offsety=-speed;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_R)) {
			offsety=speed;
		}
		
		else {
			offsety=0;
		}
		rox += -Mouse.getDY() * turnSpeed;
		roy += Mouse.getDX() * turnSpeed;
		
		float cx = (float) -(moveAt * Math.sin(Math.toRadians(roy)));
		float cy = (float) (moveAt * Math.sin(Math.toRadians(rox)));
		float cz = (float) (moveAt * Math.cos(Math.toRadians(roy)));
		
		pos.x += cx+offsetx;
		pos.y += cy+offsety;
		pos.z += cz;
		
	}

	public Vector3f getPos() {
		return pos;
	}

	public float getRox() {
		return rox;
	}

	public float getRoy() {
		return roy;
	}

	public float getRoz() {
		return roz;
	}

	
}

