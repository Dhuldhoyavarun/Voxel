package voxel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.lwjgl.opengl.GL20;

public abstract class shp {
	int pid;
	int vertexsid;
	int fragmentsid;
	protected abstract void abin();
	protected void abi(String vn,int a) {GL20.glBindAttribLocation(pid,  a,vn);}
	
public shp(String vfile,String ffile)
{
	pid=GL20.glCreateProgram();
	vertexsid=ls(vfile,GL20.GL_VERTEX_SHADER);
	fragmentsid=ls(ffile,GL20.GL_FRAGMENT_SHADER);
	GL20.glAttachShader(pid, vertexsid);
	GL20.glAttachShader(pid, fragmentsid);
	abin();
	GL20.glLinkProgram(pid);
	GL20.glValidateProgram(pid);
	getlocs();
	
}
protected abstract void getlocs();

protected int getloc(String var)
{return GL20.glGetUniformLocation(pid, var);
	
}
	private int ls(String f,int t)
	{
		StringBuilder ss=new StringBuilder();
		InputStream in=Class.class.getResourceAsStream(f);
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String l;
		try {
			while((l=br.readLine()) != null) {
				ss.append(l).append("//\n");
				
			}
			br.close();
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int sid=GL20.glCreateShader(t);
		GL20.glShaderSource(sid, ss);
		GL20.glCompileShader(sid);
		
		return sid;
		
	}
public void start() {
	GL20.glUseProgram(pid);
}

public void stop() {
	GL20.glUseProgram(0);
}

public void deallocate()
{
stop();
GL20.glDetachShader(pid, vertexsid);
GL20.glDetachShader(pid, fragmentsid);
GL20.glDeleteShader(vertexsid);
GL20.glDeleteShader(fragmentsid);
GL20.glDeleteProgram(pid);
}
}
