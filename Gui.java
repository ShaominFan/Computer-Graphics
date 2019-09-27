import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class Gui extends JFrame {
	public  int choosenum;//选择哪个menu功能
	public int choosenum2;//用于记录前一个选择的menu功能
	Color c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param g 
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param g 
	 */
	private void initialize() {
		c=Color.BLACK;//设置默认颜色为黑色
		this.setTitle("图形操作系统");
		this.setBackground(SystemColor.activeCaption);
		this.setLayout(new BorderLayout());
		
		

		//绘图面板p1
		panel p1= new panel();
		this.add(p1,BorderLayout.CENTER);
		this.addMouseListener(p1);//!在frame上添加监听器才有用！
		//
		JTextArea f1=new JTextArea();
		f1.setPreferredSize(new Dimension(400,0));
		f1.setBackground(Color.LIGHT_GRAY);
		this.add(f1,BorderLayout.EAST);
		
		//添加颜色面板 ,并且给每个按钮注册事件监听
				JPanel paneldown =new JPanel();
				paneldown.setPreferredSize(new Dimension(0,60));
				paneldown.setLayout(null);
				paneldown.setBackground(Color.gray);
				this.add(paneldown, BorderLayout.SOUTH);
				
				//下方面板添加子面板
				JPanel paneldownchild = new JPanel();
				paneldownchild.setBackground(Color.gray);
				paneldownchild.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
				paneldownchild.setBounds(10,10,350,40);
				paneldown.add(paneldownchild);
				
				//按钮特效
				BevelBorder bb = new BevelBorder(0, Color.gray,Color.white);
	
				
		
		        //左面板
				JPanel left = new JPanel();
				left.setBackground(Color.gray);
				left.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
				left.setPreferredSize(new Dimension(270,40));				
				paneldownchild.add(left);
				//右面板
				JPanel right = new JPanel();
				right.setBackground(Color.gray);
				right.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
				right.setPreferredSize(new Dimension(70,40));
				paneldownchild.add(right);
				
				
				//颜色数组，用来设置按钮的背景颜色
				Color []colors = {new Color(0,0,0),new Color(150,150,150),new Color(220,220,220)
						,new Color(25,25,25),new Color(72,61,139),new Color(106,90,205)
						,new Color(100,149,237),new Color(30,144,255),new Color(135,206,250)
						,new Color(0,255,255),new Color(95,158,160),new Color(0,100,0)
						,new Color(0,255,0),new Color(124,252,0),new Color(255,255,0)
						,new Color(218,165,32),new Color(205,92,92),new Color(255,0,0)
						,new Color(178,34,34),new Color(255,69,0),new Color(208,32,144)
						,new Color(148,0,211),new Color(89,240,104),new Color(199,73,4),new Color(255,204,204)
						,new Color(255,231,186)};
				
				//循环添加26个颜色按钮
				for(int i=0;i<26;i++){
					JButton bt3 = new JButton();
				    bt3.setBackground(colors[i]);
				    bt3.setPreferredSize(new Dimension(20,20));
				    bt3.setBorder(bb);
				    bt3.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							c=bt3.getBackground();
						}
				    	
				    });
				    left.add(bt3);
				}

	            JButton bclear=new JButton("clear");
	            bclear.setSize(40, 20);
	            bclear.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						repaint();
					}
	            	
	            });
				right.add(bclear);
		
		
		
		
		
		
		
		
		this.setFont(new Font("黑体", Font.PLAIN, 12));
		this.setForeground(SystemColor.activeCaption);
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//框架关闭
		
//menu:start
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaption);
		this.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("文件");
		mnNewMenu.setFont(new Font("黑体", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("保存");		
		menuItem.setFont(new Font("黑体", Font.PLAIN, 12));
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosenum=10;//当要保存时，设为10
				try {
					saveimg(p1);
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		mnNewMenu.add(menuItem);
		
		JMenu menu = new JMenu("基础图形绘制");
		menu.setFont(new Font("黑体", Font.PLAIN, 12));
		menuBar.add(menu);
		
		
		
		
		JMenuItem menuItem_3 = new JMenuItem("圆");
		menuItem_3.setFont(new Font("黑体", Font.PLAIN, 12));
		menuItem_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosenum=1;//当要画圆时，设为1
			}
			
		});
		menu.add(menuItem_3);
		
		JMenuItem menuItem_2 = new JMenuItem("直线");
		menuItem_2.setFont(new Font("黑体", Font.PLAIN, 12));
		menuItem_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosenum=2;//当要画直线时，设为1
			}
			
		});
		menu.add(menuItem_2);
		
		
		JMenuItem menuItem_4 = new JMenuItem("椭圆");
		menuItem_4.setFont(new Font("黑体", Font.PLAIN, 12));
		menuItem_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosenum=3;//当要画椭圆时，设为3
			}
		});
		menu.add(menuItem_4);
		
		JMenuItem quxian = new JMenuItem("曲线");
		quxian.setFont(new Font("黑体", Font.PLAIN, 12));
		quxian.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosenum=4;//当要画曲线时，设为4
			}
			
		});
		menu.add(quxian);
		
		JMenu menu_1 = new JMenu("基础操作");
		menu_1.setFont(new Font("黑体", Font.PLAIN, 12));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_5 = new JMenuItem("填充");
		menuItem_5.setFont(new Font("黑体", Font.PLAIN, 12));
		menuItem_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosenum=5;//当要填充时，设为5
			}
			
		});
		menu_1.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("裁剪");
		menuItem_6.setFont(new Font("黑体", Font.PLAIN, 12));
		menuItem_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosenum=6;//当要裁剪时，设为6
			}
			
		});
		menu_1.add(menuItem_6);
		
		JMenu menu_2 = new JMenu("变换");
		menu_2.setFont(new Font("黑体", Font.PLAIN, 12));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_7 = new JMenuItem("平移");
		menuItem_7.setFont(new Font("黑体", Font.PLAIN, 12));
		menuItem_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosenum=7;//当要平移时，设为7
			}
			
		});
		menu_2.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("旋转");
		menuItem_8.setFont(new Font("黑体", Font.PLAIN, 12));
		menuItem_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosenum=8;//当要旋转时，设为8
			}
			
		});
		menu_2.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("缩放");
		menuItem_9.setFont(new Font("黑体", Font.PLAIN, 12));
		menuItem_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choosenum=9;//当要缩放时，设为9
			}
			
		});
		menu_2.add(menuItem_9);
	   //menu:end
	}


//把panel写成内部类，然后在里面重写paint，调用其他的class
   class panel extends JPanel implements MouseListener{
		int x1,y1,x2,y2;//数据点
		int a1,b1,a2,b2;//控制点
		StraightLine sl;
		Curve curve;
		Circle c1;
		Oval o1;
		Change rotate1;//用于旋转的change对象
		
		panel(){
			this.setBackground(Color.white);
			a1=0;b1=0;a2=0;b2=0;
		}
		

		@Override		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//曲线的绘制
			Graphics g=this.getGraphics();
		    g.setColor(c);
			if(a1==0 && b1==0) {
				a1=e.getX()-8;
			    b1=e.getY()-52;
			}else {
				a2=e.getX()-8;
			    b2=e.getY()-52;    
			    
				this.draw2(g);
				a1=0;b1=0;a2=0;b2=0;//画好后重置
			}
			//通过click获取旋转的旋转点
			int x0=e.getX()-8;
			int y0=e.getY()-52;
			if(choosenum==8) {
				rotate1=new Change(x0,y0,g);
				System.out.println(x0);
				System.out.println(y0);
			}
			
			
		     
		}
        @Override//释放鼠标后执行画图操作函数
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			x2=e.getX()-8;
			y2=e.getY()-52;
			//System.out.println(x2);
		    //System.out.println(y2);
			//获取该面板上的画笔，获得按钮的颜色，传入draw画图函数中
		    Graphics g=this.getGraphics();
		    g.setColor(c);
		    try {
				this.draw(g);
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		   
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			x1=e.getX()-8;
		    y1=e.getY()-52;
		    
		    
		}
//draw函数				
		public void draw(Graphics g) throws AWTException {
			g.setColor(c);
			
			if(choosenum==1) {//圆
			   int r=(int)Math.sqrt((double)(y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
			   c1=new Circle(x1,y1,r,g);
			   c1.midpointcircle(g);
			
			   choosenum2=1;
			}
			else if(choosenum==2) {//直线
				sl=new StraightLine(x1,y1,x2,y2,g);
				sl.midpointstraight(g);	
				
				choosenum2=2;
			}
			else if(choosenum==3){//椭圆
				o1=new Oval(Math.abs(x2-x1),Math.abs(y2-y1),x1,y1,g);
				o1.midpointoval(g);
		
				choosenum2=3;
			}
			else if(choosenum==5) {//填充
				Fill floodf1=new Fill(g);
				floodf1.floodfill(x1, y1);
				choosenum=0;//防止填充完成之后选择一个图像外部的点，程序进入死循环
				System.out.println("fll over!!");
			}
			else if(choosenum==6) {//裁剪
				g.drawRect(x1, y1, x2-x1, y2-y1);
				Cut cut=new Cut(x1,y1,x2,y2,sl,g);
				cut.CScut();
				g.setColor(Color.WHITE);
				System.out.println("Cut over!!");
				//g.drawRect(x1, y1, x2-x1, y2-y1);				
				choosenum=0;
			}
			else if(choosenum==7) {//平移
				if(choosenum2==2) {//前一个是直线
					Change change=new Change(x1,y1,x2,y2,sl,g);
				    change.move();
				}else if(choosenum2==1) {//前一个是圆
					Change change=new Change(x1,y1,x2,y2,c1,g);
					change.circlemove();					
				}else if(choosenum2==3) {//前一个画的是椭圆
					Change change=new Change(x1,y1,x2,y2,o1,g);
					change.ovalmove();
				}
				
			}else if(choosenum==9) {//缩放
				if(choosenum2==1) {//前一个是圆
					Change change=new Change(x1,y1,x2,y2,c1,g);
					change.circlezoom();					
				}else if(choosenum2==3) {//前一个画的是椭圆
					Change change=new Change(x1,y1,x2,y2,o1,g);
					change.ovalzoom();
				}
			}
			else if(choosenum==8) {//旋转			
				if(choosenum2==2) {//前一个是直线
					if((x2-x1!=0)){//只有移动了的鼠标事件
						rotate1.straightrotate(x1, y1, x2, y2, sl);
					}
								    
				}				
				else if(choosenum2==3) {//前一个画的是椭圆
					if((x2-x1!=0)){//只有移动了的鼠标事件
						rotate1.ovalrotate(x1, y1, x2, y2, o1);
					}
					
				}
			}
			else if(choosenum==4) {//曲线
			   if((x2-x1!=0)){//只有移动了的鼠标事件才可以初始化曲线数据点
					curve=new Curve(x1,y1,x2,y2,g);
					g.drawLine(x1, y1, x1, y1);
					g.drawLine(x2, y2, x2, y2);
				}
			    
			}
			
		}
		
		public void draw2(Graphics g) {//画曲线在选好控制点后进行绘图,通过双击对曲线进行修改
			g.setColor(c);
			if(choosenum==4) {
				curve.Breziercurve(a1, b1, a2, b2);
				System.out.println("curve over!!");
				choosenum=20;//当曲线画好后设为20
			}else if(choosenum==20) {//曲线画好后如果进行修改
				g.setColor(Color.WHITE);
				g.fillRect(8, 52, this.getWidth(), this.getHeight());
				curve.Breziercurve(a1, b1, a2, b2);
				System.out.println("modify over!!");			
			}
				
		}
		
	//重绘刷新面板	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}

	}
   
 //class panel:end
   
 public void saveimg(panel p1) throws AWTException {
	 JFileChooser chooser = new JFileChooser();
	chooser.showSaveDialog(null);
	File f=chooser.getSelectedFile();
	
	
	
	if(f==null){
		JOptionPane.showMessageDialog(null, "没有选择文件");
	}else {
		Dimension di=p1.getSize();
		Point point=p1.getLocationOnScreen();
        BufferedImage screencapture = new Robot().createScreenCapture(
				new Rectangle(point.x, point.y, di.width, di.height));
        try {
        	ImageIO.write(screencapture, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }

	    System.out.println("export Image -->" + f.getAbsoluteFile());
	}
 }


	
	


	
}
