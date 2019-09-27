import java.awt.*;
import javax.swing.*;

public class StraightLine {
	int x1,y1;
	int x2,y2;//直线的两个端点坐标
	Graphics g;
	
	StraightLine(int a,int b, int c,int d,Graphics gl){
		if(a>c) {
			x1=c;
			y1=d;
			x2=a;
			y2=b;
		}else {
			x1=a;
		    y1=b;
		    x2=c;
		    y2=d;
		}
		
		g=gl;
	}
	//中点直线算法
	public void midpointstraight(Graphics g){
				
		int a=0,b=0,delta1=0,delta2=0,d=0,x=0,y=0;
		a=y1-y2;
		b=x2-x1;
		x=x1;
		y=y1;
		g.drawLine(x,y,x,y);
		//当直线斜率为0时
		if(a==0) {
			while(x<x2){
				g.drawLine(x++,y,x++,y);
			}
		}
		//当直线斜率为无穷大时
		else if(b==0) {
			if(y2>y1) {
				while(y<y2) {
					g.drawLine(x, y++, x, y++);
				}
			}
			else {
				while(y<y2) {
					g.drawLine(x,y--,x,y--);
				}
			}
		}
		//根据直线斜率和y1，y2的大小分成四种情况讨论
		else if(y1<y2) {
		
		  if(-a/b<1) {
			delta1=2*a;
			delta2=2*(a+b);
			d=2*a+b;
			while(x<x2) {
				if(d<0) {//取上面的点
					x++;
					y++;
					d+=delta2;
				}
				else {//取下面的点
					x++;
					d+=delta1;
				}
				g.drawLine(x,y,x,y);//画这个点
			}
		  }
		  else {
			delta1=2*b;//有点问题
			delta2=2*(a+b);
			d=a+2*b;
			while(y<y2) {
				if(d<0) {
					y++;//取左边的点
					d+=delta1;						
				}
				else {
					x++;
					y++;
					d+=delta2;
				}
			    g.drawLine(x,y,x,y);//画这个点
			}
		  }
		}
		else {
			
			if(-a/b>-1) {
				delta1=2*a;
				delta2=2*(a-b);
				d=2*a-b;
				while(x<x2) {
					if(d<0) {//取上面的点
						x++;						
						d+=delta1;						
					}
					else {//取下面的点
						x++;
						y--;
						d+=delta2;
					}
					g.drawLine(x,y,x,y);//画这个点
				}
			  }
			  else {
				
				delta1=-2*b;
				delta2=2*(a-b);
				d=a-2*b;
				while(y>y2) {
					if(d>0) {
						y--;//取左边的点
						d+=delta1;							
					}
					else {
						x++;
						y--;
						d+=delta2;
					}
				    g.drawLine(x,y,x,y);//画这个点
				}
		    }
		}
	}				
}   
			


		






