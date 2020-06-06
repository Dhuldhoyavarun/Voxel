package voxel;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class read {
	
	static List<Integer> vao=new ArrayList<Integer>();
	static List<Integer> vbo=new ArrayList<Integer>();
	static List<Integer> tids=new ArrayList<Integer>();

	
	
public simple ltv(float[] v,int [] i,float [] tc) {
	int idvao=crv();
	store(v,0,3);
	store(tc,1,2);
	indexbuffer(i);
	GL30.glBindVertexArray(0);
	return new simple(idvao,i.length);
	
}

int crv() {
	int idvao=GL30.glGenVertexArrays();
	GL30.glBindVertexArray(idvao);
	vao.add(idvao);
	return idvao;
}

void store(float [] d, int an, int dims) {
	int idvbo=GL15.glGenBuffers();
	FloatBuffer x=BufferUtils.createFloatBuffer(d.length);
	vbo.add(idvbo);
	x.put(d);
	x.flip();
	GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, idvbo);
	GL15.glBufferData(GL15.GL_ARRAY_BUFFER, x, GL15.GL_STATIC_DRAW);
	GL20.glVertexAttribPointer(an,dims,GL11.GL_FLOAT,false,0,0);
	GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
	
	
	
}

public int tex(String name)
{Texture tex=null;
try {
	tex=TextureLoader.getTexture("PNG", Class.class.getResourceAsStream("/res/"+name+".PNG"));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
int tid=tex.getTextureID();
tids.add(tid);
return tid;
	}

void indexbuffer(int [] i)
{int idvbo=GL15.glGenBuffers();
GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, idvbo);

IntBuffer x=BufferUtils.createIntBuffer(i.length);
vbo.add(idvbo);
x.put(i);
x.flip();
GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, x, GL15.GL_STATIC_DRAW);	}
void deallocate()
{for(int i: vao)
{GL30.glDeleteVertexArrays(i);
	}
for(int i: vbo)
{GL15.glDeleteBuffers(i);
	}
for(int i: tids)
{GL11.glDeleteTextures(i);
	}
		}
}
