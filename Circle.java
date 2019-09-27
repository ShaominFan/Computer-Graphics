import java.awt.*;
import javax.swing.*;

public class Circle {
	//属性，圆的圆心和半径
	public  int a;
	public  int b;
	public  int r;
	public Graphics g;
	
	Circle(int i,int j,int k,Graphics g1){
		a=i;
		b=j;
		r=k;
		g=g1;
	}
	
	public void midpointcircle(Graphics g){
		int x,y,deltax,deltay,d;
		x=0;
		y=r;
		d=1-r;//判断值
		deltax=3;//当前一个点选择的是上面的像素，即d<0
		deltay=5-2*r;//当前一个点选择的是下面的像素，即d>0时
		g.drawLine(a+x, b-y, a+x, b-y);//第一象限
		g.drawLine(a+y, b-x, a+y, b-x);//第一象限
		g.drawLine(a-x, b-y, a-x, b-y);//第二象限
		g.drawLine(a-y, b-x, a-y, b-x);//第二象限
		g.drawLine(a-x, b+y, a-x, b+y);//第三象限
		g.drawLine(a-y, b+x, a-y, b+x);//第三象限
		g.drawLine(a+x, b+y, a+x, b+y);//第四象限
		g.drawLine(a+y, b+x, a+y, b+x);//第四象限
		while(x<y) {
			if(d<0) {
				d+=deltax;
				deltax+=2;
				deltay+=2;
				x++;
				}
			else {
				d+=deltay;
				deltax+=2;
				deltay+=4;
				x++;
				y--;
			}
			
			g.drawLine(a+x, b-y, a+x, b-y);//第一象限
			g.drawLine(a+y, b-x, a+y, b-x);//第一象限
			g.drawLine(a-x, b-y, a-x, b-y);//第二象限
			g.drawLine(a-y, b-x, a-y, b-x);//第二象限
			g.drawLine(a-x, b+y, a-x, b+y);//第三象限
			g.drawLine(a-y, b+x, a-y, b+x);//第三象限
			g.drawLine(a+x, b+y, a+x, b+y);//第四象限
			g.drawLine(a+y, b+x, a+y, b+x);//第四象限
					
			}
	}
			

}
		
		
		






