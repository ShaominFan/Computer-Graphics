import java.awt.*;

public class Fill {
	Graphics g;
	Robot r;
	Color pointc;
	
	Fill(Graphics gl) throws AWTException{
		g=gl;
		r=new Robot();
		
	}
	
	public void floodfill(int x1,int y1){//选择一个内部点
		   pointc=r.getPixelColor(x1+8, y1+52);
		   if(pointc.getRGB()!=Color.WHITE.getRGB()) {
		      return ;
		   }
		   else {
			
			g.drawLine(x1, y1, x1, y1);
			System.out.println(x1);
			floodfill(x1+1,y1);
			floodfill(x1,y1-1);	
			
			floodfill(x1,y1+1);	
			floodfill(x1-1,y1);
			
					
		}
		
	}

}
