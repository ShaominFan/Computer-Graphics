import java.awt.*;

import javax.swing.*;

public class Oval {
	public int a;
	public int b;
	public int x0;
	public int y0;
	Graphics g;
	
	Oval(int i,int j,int k,int h,Graphics gl){
		a=i;
		b=j;
		x0=k;//(x0,y0)是椭圆的中心
		y0=h;
		g=gl;
	}
	//中点椭圆算法的实现    
	public void midpointoval(Graphics g)
			{
				int x,y,deltax,deltay,d;
				x=0;
				y=b;
				d=b*b+(1/4)*a*a-a*a*b;//判断值
				deltax=b*b;//当前一个点选择的是上面的像素，即d<0时
				deltay=b*b+2*a*a-2*a*a*b;//当前一个点选择的是下面的像素，即d>0时
				g.drawLine(x0+x, y0-y, x0+x, y0-y);//第1象限
				g.drawLine(x0-x, y0-y, x0-x, y0-y);//第2象限
				g.drawLine(x0-x, y0+y, x0-x, y0+y);//第3象限
				g.drawLine(x0+x, y0+y, x0+x, y0+y);//第4象限
				while(b*b*(x+1)<=a*a*(y-0.5)) {
					if(d<0) {
						d+=deltax;
						deltax+=2*b*b;
						deltay+=2*b*b;
						x++;
					}
					else {
						d+=deltay;
						deltax+=2*b*b;
						deltay+=2*b*b+2*a*a;
						x++;
						y--;
					}
					g.drawLine(x0+x, y0-y, x0+x, y0-y);//第1象限
					g.drawLine(x0-x, y0-y, x0-x, y0-y);//第2象限
					g.drawLine(x0-x, y0+y, x0-x, y0+y);//第3象限
					g.drawLine(x0+x, y0+y, x0+x, y0+y);//第4象限
				}
				d=(int) (b*b*(x+1)*(x+1)+a*a*(y+0.5)*(y+0.5)-a*a*b*b);
				deltax=2*b*b*x+2*b*b-2*a*a*y+a*a;
				deltay=-2*a*a*y+a*a;
				while(y>=0) {
					if(d<0) {
						d+=deltax;
						deltax+=2*a*a+2*b*b;
						deltay+=2*a*a;
						x++;
						y--;
					}
					else {
						d+=deltay;
						deltax+=2*a*a;
						deltay+=2*a*a;
						y--;
					}
					g.drawLine(x0+x, y0-y, x0+x, y0-y);//第1象限
					g.drawLine(x0-x, y0-y, x0-x, y0-y);//第2象限
					g.drawLine(x0-x, y0+y, x0-x, y0+y);//第3象限
					g.drawLine(x0+x, y0+y, x0+x, y0+y);//第4象限
				}
			}
		}
		


