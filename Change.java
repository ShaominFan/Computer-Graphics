import java.awt.Color;
import java.awt.Graphics;

public class Change {
	Circle cchange;
	StraightLine sc;
	Oval ochange;
	Graphics g;
	int movex,movey;//平移变化的参数
	int zoomr;
	int x0,y0;//旋转点
	
	Change(int x3,int y3,int x4,int y4,StraightLine s,Graphics gl){
		sc=s;
		g=gl;
		movex=x4-x3;
		movey=y4-y3;
	}
	
	Change(int x3,int y3,int x4,int y4,Circle c,Graphics gl){
		movex=x4-x3;
		movey=y4-y3;
		zoomr=(int)Math.sqrt((double)(y4-y3)*(y4-y3)+(x4-x3)*(x4-x3));
		if(x3<x4) {
			zoomr=-zoomr;
		}
		cchange=c;
		g=gl;
	}
	
	Change(int x3,int y3,int x4,int y4,Oval o1,Graphics gl){
		movex=x4-x3;
		movey=y4-y3;
		ochange=o1;
		g=gl;
	}
	
	Change(int x1,int y1,Graphics gl){
		x0=x1;
		y0=y1;
		g=gl;
	}
	//直线的旋转
	public void straightrotate(int x3,int y3,int x4,int y4,StraightLine s) {
		sc=s;
		double r1=Math.sqrt((double)(y4-y0)*(y4-y0)+(x4-x0)*(x4-x0));
		System.out.println("r1"+r1);
		double r2=Math.sqrt((double)(y3-y0)*(y3-y0)+(x3-x0)*(x3-x0));
		System.out.println("r2"+r2);
		double r3=Math.sqrt((double)(y4-y3)*(y4-y3)+(x4-x3)*(x4-x3));//旋转角对边
		System.out.println("r3"+r3);
		double cos=(r1*r1+r2*r2-r3*r3)/(2*r1*r2);
		System.out.println("c0s"+cos);
		double sin=Math.sqrt(1-cos*cos);
		System.out.println("sin"+sin);
		int xx1=(int)(x0+(sc.x1-x0)*cos-(sc.y1-y0)*sin);
		int yy1=(int)(x0+(sc.y1-x0)*cos+(sc.x1-x0)*sin);
		int xx2=(int)(x0+(sc.x2-x0)*cos-(sc.y2-y0)*sin);
		int yy2=(int)(x0+(sc.y2-x0)*cos+(sc.x2-x0)*sin);
		System.out.println("xx1"+xx1);
		System.out.println("yy1"+yy1);
		System.out.println("xx2"+xx2);
		System.out.println("yy2"+yy2);
		Color cc=g.getColor();
		g.setColor(Color.white);
		sc.midpointstraight(g);
		StraightLine scafter=new StraightLine(xx1,yy1,xx2,yy2,g);	
		g.setColor(cc);
		scafter.midpointstraight(g);
	}
	
    //椭圆的旋转
	public void ovalrotate(int x3,int y3,int x4,int y4,Oval o) {
		ochange=o;
		double r1=Math.sqrt((double)(y4-y0)*(y4-y0)+(x4-x0)*(x4-x0));
		double r2=Math.sqrt((double)(y3-y0)*(y3-y0)+(x3-x0)*(x3-x0));
		double r3=Math.sqrt((double)(y4-y3)*(y4-y3)+(x4-x3)*(x4-x3));//旋转角对边
		double cos=(r1*r1+r2*r2-r3*r3)/(2*r1*r2);
		double sin=Math.sqrt(1-cos*cos);
		//原来判断椭圆a,b的点(aa,bb)
		int aa=ochange.a+ochange.x0;
		int bb=ochange.y0-ochange.b;
		//将（aa,bb)旋转
		int aa0=(int)(x0+(aa-x0)*cos-(bb-y0)*sin);
		int bb0=(int)(x0+(bb-y0)*cos+(aa-x0)*sin);
		int x=(int)(x0+(ochange.x0-x0)*cos-(ochange.y0-y0)*sin);
		int y=(int)(x0+(ochange.y0-y0)*cos+(ochange.x0-x0)*sin);
		Color cc=g.getColor();
		g.setColor(Color.white);
		ochange.midpointoval(g);
		Oval o1=new Oval(Math.abs(aa0-x),Math.abs(bb0-y),x,y,g);
		g.setColor(cc);
		o1.midpointoval(g);
	}
	//椭圆的缩放
	public void ovalzoom(){
		Color cc=g.getColor();
		g.setColor(Color.white);
		ochange.midpointoval(g);
		Oval o1=new Oval(ochange.a+movex,ochange.b-movey,ochange.x0,ochange.y0,g);
		g.setColor(cc);
		o1.midpointoval(g);
	}
	//圆的缩放
	public void circlezoom() {
		Color cc=g.getColor();
		g.setColor(Color.white);
		cchange.midpointcircle(g);
		Circle cafter=new Circle(cchange.a,cchange.b,cchange.r-zoomr,g);
		g.setColor(cc);
		cafter.midpointcircle(g);
	}
	//直线的平移
	public void move() {
		Color cc=g.getColor();
		g.setColor(Color.white);
		sc.midpointstraight(g);
		StraightLine scafter=new StraightLine(sc.x1+movex,sc.x2+movey,sc.y1+movex,sc.y2+movey,g);	
		g.setColor(cc);
		scafter.midpointstraight(g);
	}
	//圆的平移
	public void circlemove() {
		Color cc=g.getColor();
		g.setColor(Color.white);
		cchange.midpointcircle(g);
		Circle cafter=new Circle(cchange.a+movex,cchange.b+movey,cchange.r,g);
		g.setColor(cc);
		cafter.midpointcircle(g);
	}
	//椭圆的平移
	public void ovalmove(){
		Color cc=g.getColor();
		g.setColor(Color.white);
		ochange.midpointoval(g);
		Oval o1=new Oval(ochange.a,ochange.b,ochange.x0+movex,ochange.y0+movey,g);
		g.setColor(cc);
		o1.midpointoval(g);
	}

}
