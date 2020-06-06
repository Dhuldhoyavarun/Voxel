package voxel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

public class voxel {
public static read r1=null;
public static staticshp s1=null;
static int world=5*16;
static List<chunk> chunks=new ArrayList<chunk>();
static List<Vector3f> occupied=new ArrayList<Vector3f>();
static Vector3f cpos=new Vector3f(0,0,0);
public static void main(String[] args) {
		disp.dispc();
		read read1=new read(); 
		
		staticshp s=new staticshp();
		renderer r=new renderer();
		r1=read1;
		s1=s;
		float [] v= {
				-0.5f,0.5f,-0.5f,	
				-0.5f,-0.5f,-0.5f,	
				0.5f,-0.5f,-0.5f,	
				0.5f,0.5f,-0.5f,		
				
				-0.5f,0.5f,0.5f,	
				-0.5f,-0.5f,0.5f,	
				0.5f,-0.5f,0.5f,	
				0.5f,0.5f,0.5f,
				
				0.5f,0.5f,-0.5f,	
				0.5f,-0.5f,-0.5f,	
				0.5f,-0.5f,0.5f,	
				0.5f,0.5f,0.5f,
				
				-0.5f,0.5f,-0.5f,	
				-0.5f,-0.5f,-0.5f,	
				-0.5f,-0.5f,0.5f,	
				-0.5f,0.5f,0.5f,
				
				-0.5f,0.5f,0.5f,
				-0.5f,0.5f,-0.5f,
				0.5f,0.5f,-0.5f,
				0.5f,0.5f,0.5f,
				
				-0.5f,-0.5f,0.5f,
				-0.5f,-0.5f,-0.5f,
				0.5f,-0.5f,-0.5f,
				0.5f,-0.5f,0.5f
				
					
		};
		
		int [] i=
		{0,1,3,	
				3,1,2,	
				4,5,7,
				7,5,6,
				8,9,11,
				11,9,10,
				12,13,15,
				15,13,14,	
				16,17,19,
				19,17,18,
				20,21,23,
				23,21,22		};
		
		float [] tc= {

				0,0,
				0,1,
				1,1,
				1,0,			
				0,0,
				0,1,
				1,1,
				1,0,			
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0

		};
		
		simple sim=read1.ltv(multicube.v,multicube.i,multicube.tc);
		textures t=new textures(read1.tex("grassTex"));
		textures t1=new textures(read1.tex("TreeBark"));
		textures t2=new textures(read1.tex("Leaf"));
		textures t3=new textures(read1.tex("water"));
		simpletexture st=new simpletexture(sim,t);
		simpletexture st1=new simpletexture(sim,t1);
		simpletexture st2=new simpletexture(sim,t2);
		simpletexture st3=new simpletexture(sim,t3);
	
		Random rand =new Random();
		
		cam camera= new cam(new Vector3f(0,0,0),0,0,0);
		height h=new height();
		new Thread(new Runnable() {public void run() {
			while(!Display.isCloseRequested()) {
			for (int x=(int)(cpos.x-world)/16;x<(cpos.x+world)/16;x++)
			{
				for(int z=(int)(cpos.z-world)/16;z<(cpos.z+world)/16;z++)
				{int test=rand.nextInt(9)+1;
				if(test<4)
				{if(!occupied.contains(new Vector3f(x*16,0,z*16) ))
				{List<ent> blocks=new ArrayList<ent>();
				int added=0;
				int test1=rand.nextInt(9)+1;
				for(int j=0;j<16;j++) {
					for(int k=0;k<16;k++)
					{ int y=(int)height.generateHeight((x*16)+j,(z*16)+k);
						//int y=0;
						blocks.add(new ent(st,new Vector3f((x*16)+j,y,(z*16)+k),0,0,0,1));
						if(test1<5 && added==0)
						{blocks.add(new ent(st1,new Vector3f((x*16)+j,y+1,(z*16)+k),0,0,0,1));
						blocks.add(new ent(st1,new Vector3f((x*16)+j,y+2,(z*16)+k),0,0,0,1));
						blocks.add(new ent(st2,new Vector3f((x*16)+j,y+3,(z*16)+k),0,0,0,1));
						blocks.add(new ent(st2,new Vector3f((x*16)+j,y+4,(z*16)+k),0,0,0,1));
						blocks.add(new ent(st2,new Vector3f((x*16)+j+1,y+3,(z*16)+k),0,0,0,1));
						blocks.add(new ent(st2,new Vector3f((x*16)+j-1,y+3,(z*16)+k),0,0,0,1));
						blocks.add(new ent(st2,new Vector3f((x*16)+j,y+3,(z*16)+k+1),0,0,0,1));
						blocks.add(new ent(st2,new Vector3f((x*16)+j,y+3,(z*16)+k-1),0,0,0,1));
						
						added=1;
							
						}
					
					}
				
				}
				chunks.add(new chunk(blocks,new Vector3f(x*16,0*16,z*16)));
				occupied.add(new Vector3f(x*16,0*16,z*16));}
				}
				else {
					if(!occupied.contains(new Vector3f(x*16,0,z*16) ))
				{List<ent> blocks=new ArrayList<ent>();
				int test1=rand.nextInt(9)+1;
				for(int j=0;j<16;j++) {
					for(int k=0;k<16;k++)
					{
					int y=(int)height.generateHeight((x*16)+j,(z*16)+k);
					//int y=0;
						blocks.add(new ent(st,new Vector3f((x*16)+j,y,(z*16)+k),0,0,0,1));}
				
				}
				chunks.add(new chunk(blocks,new Vector3f(x*16,0*16,z*16)));
				occupied.add(new Vector3f(x*16,0*16,z*16));}
				}}
			}
		}
		}
		}
		).start();
		
		while(!Display.isCloseRequested())
		{
			camera.move();
			cpos=camera.getPos();
			
		
			for(int j=0;j<chunks.size();j++)
			{Vector3f og=chunks.get(j).getOr();
			//System.out.println(og);
				int dix=(int)(cpos.x-og.x);
			int diz=(int)(cpos.z-og.z);
			if(dix<0)
				dix=-dix;
			if(diz<0)
				diz=-diz;
			if((dix<=world)&&(diz<=world))
				for(int k=0;k<chunks.get(j).getBlocks().size();k++)
					
				{
					r.add(chunks.get(j).getBlocks().get(k));
				}
			}
			
			r.ren(camera);
			disp.dispup();
		}
		
		disp.dispdes();
		// TODO Auto-generated method stub

	}

}
