import java.awt.Color;
import java.awt.Graphics;

//3阶Bezier的实现
public class Curve {
	public int x1,y1,x2,y2;//两个数据点和两个控制点
	Graphics g;
	
	Curve(int a1,int b1,int c1,int d1,Graphics gl){//先初始化数据点
		x1=a1;
		y1=b1;
		x2=c1;
		y2=d1;
		g=gl;

	}
	
	public void Breziercurve(int a1,int b1,int a2,int b2){//传入两个控制点
		double t=0;
		int x,y;
		
		while(t<1) {
			x=(int) (Math.pow((1-t), 3)*x1+3*t*Math.pow((1-t), 3)*a1+3*t*t*(1-t)*a2+t*t*t*x2);
			y=(int) (Math.pow((1-t), 3)*y1+3*t*Math.pow((1-t), 3)*b1+3*t*t*(1-t)*b2+t*t*t*y2);
			g.drawLine(x, y, x, y);
			t+=0.001;
		 }
		
	}

	
	

}
