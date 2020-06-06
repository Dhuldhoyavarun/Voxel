package voxel;

import org.lwjgl.util.vector.Vector3f;

public class ent {
simpletexture sim;


Vector3f pos;
float rox,roz,roy;
float s;

public ent(simpletexture sim, Vector3f pos, float rox, float roz, float roy, float s) {
	
	this.sim = sim;
	this.pos = pos;
	this.rox = rox;
	this.roz = roz;
	this.roy = roy;
	this.s = s;
}

public void changep(float cx,float cy,float cz) {
	this.pos.x+=cx;
	this.pos.y+=cy;
	this.pos.z+=cz;
}
public void changer(float cx,float cy,float cz) {
	this.rox+=cx;
	this.roy+=cy;
	this.roz+=cz;
}

public void changes(float s) {
	this.s+=s;
	
}
public simpletexture getSim() {
	return sim;
}

public void setSim(simpletexture sim) {
	this.sim = sim;
}

public Vector3f getPos() {
	return pos;
}

public void setPos(Vector3f pos) {
	this.pos = pos;
}

public float getRox() {
	return rox;
}

public void setRox(float rox) {
	this.rox = rox;
}

public float getRoz() {
	return roz;
}

public void setRoz(float roz) {
	this.roz = roz;
}

public float getRoy() {
	return roy;
}

public void setRoy(float roy) {
	this.roy = roy;
}

public float getS() {
	return s;
}

public void setS(float s) {
	this.s = s;
}

}
