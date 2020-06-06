package voxel;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

public class chunk {
private List<ent> blocks;
private Vector3f or;

public chunk(List<ent> blocks, Vector3f og)
{this.setBlocks(blocks);;
this.or=og;
	}

public List<ent> getBlocks() {
	return blocks;
}

public Vector3f getOr() {
	return or;
}

public void setBlocks(List<ent> blocks) {
	this.blocks = blocks;
}
}
