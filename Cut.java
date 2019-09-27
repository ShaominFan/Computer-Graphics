import java.awt.Color;
import java.awt.Graphics;

public class Cut {
	public int x1,y1,x2,y2;
	public int x3,y3,x4,y4;
	StraightLine s1;
	Graphics g;
	
	Cut(int a,int b,int c,int d,StraightLine s2,Graphics gl){
		x1=a;
		y1=b;
		x2=c;
		y2=d;
		x3=s2.x1;
		y3=s2.y1;
		x4=s2.x2;
		y4=s2.y2;
		s1=s2;//方便一点
		g=gl;
	}
	
	public void CScut() {
		//coding：start
		int[] str1 = new int[4];
		if(y3<y1) {
			str1[0]=1;
		}else {
			str1[0]=0;
		}
		if(y3>y2) {
			str1[1]=1;
		}else {
			str1[1]=0;
		}
		if(x3<x1) {
			str1[2]=1;
		}else {
			str1[2]=0;
		}
		if(x3>x2) {
			str1[3]=1;
		}else {
			str1[3]=0;
		}
		
		int[] str2 = new int[4];
		if(y4<y1) {
			str2[0]=1;
		}else {
			str2[0]=0;
		}
		if(y4>y2) {
			str2[1]=1;
		}else {
			str2[1]=0;
		}
		if(x4<x1) {
			str2[2]=1;
		}else {
			str2[2]=0;
		}
		if(x4>x2) {
			str2[3]=1;
		}else {
			str2[3]=0;
		}
		//coding：end
		int[] str3=new int[4]; 
		for(int i=0;i<4;i++) {
			str3[i]=str1[i]&str2[i];
		}
		//判断是否两个端点都在内部
		boolean bool1=(str1[0]==0 && str1[1]==0 && str1[2]==0 && str1[3]==0);
		boolean bool2=(str2[0]==0 && str2[1]==0 && str2[2]==0 && str2[3]==0);
		boolean bool3=(str3[0]==1 || str3[1]==1 || str3[2]==1 || str3[3]==1);
		if(bool1 && bool2) {
			System.out.println("都在裁剪框内部");
		}
		else if(bool3) {
			g.setColor(Color.white);
			s1.midpointstraight(g);//用白色覆盖
			System.out.println("都在裁剪框外部");
			
		}else {
			int a1,a2,b1,b2;//保留交点
			int aa1=0,aa2=0,bb1=0,bb2=0;//最终交点
			b1=y3+(int)((double)((y4-y3))/(double)((x4-x3))*(x1-x3));//左边
			b2=y3+(int)((double)((y4-y3))/(double)((x4-x3))*(x2-x3));//右边
			a1=x3+(int)((double)((x4-x3))/(double)((y4-y3))*(y1-y3));//上边
			a2=x3+(int)((double)((x4-x3))/(double)((y4-y3))*(y2-y3));//下边
			System.out.println("y3"+y3);
			if(b1>=y1 && b1<=y2 && (b1>Math.min(y3, y4))) {
				aa1=x1;
				bb1=b1;
				System.out.println("b1"+bb1);
			}
            if(b2>=y1 && b2<=y2 && (b2>Math.min(y3, y4))){
				if(aa1!=0 && bb1!=0) {
					aa2=x2;
					bb2=b2;
					
				}else {
					aa1=x2;
					bb1=b2;
				}
				System.out.println("b2"+bb2);
			}
			if(a1>=x1 && a1<=x2 && a1>x3 && a1<x4) {
				if(aa1!=0) {
					aa2=a1;
					bb2=y1;
				}else {
					aa1=a1;
					bb1=y1;
				}
				System.out.println("a1"+a1);
			}
            if(a2>=x1 && a2<=x2 && a2>x3 && a2<x4){
            	if(aa1!=0) {
					aa2=a2;
					bb2=y2;
				}else {
					aa1=a2;
					bb1=y2;
				}
            	System.out.println("a2"+a2);
			}
			g.setColor(Color.WHITE);
			s1.midpointstraight(g);
			g.setColor(Color.BLACK);
			if(bool1) {
				StraightLine s3=new StraightLine(aa1,bb1,x3,y3,g);
				s3.midpointstraight(g);
			}else if(bool2){
				StraightLine s3=new StraightLine(aa1,bb1,x4,y4,g);
				s3.midpointstraight(g);
			}else {
				StraightLine s3=new StraightLine(aa1,bb1,aa2,bb2,g);
				s3.midpointstraight(g);
			}

		}
		
	}
	
	
	
	

}
