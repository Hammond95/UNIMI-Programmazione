import java.io.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.lang.Math.*;
import ch.aplu.turtle.*;

public class CurvaDiKoch
{	
	private TurtleFrame tf = null;
	private Playground pg = null;
	private Turtle koch = null;

	public CurvaDiKoch(){
		// Create Frame based on Screen Size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width  = (int) screenSize.getWidth() - 100;
		int height = (int) screenSize.getHeight() - 100;
		this.tf = new TurtleFrame("Koch Frame", width, height);
		this.pg = this.tf.getPlayground();
		this.koch = new Turtle(this.tf);
		this.pg.add(this.koch);
	}


	public Turtle getKoch(){
		return this.koch;
	}

	public void kochcurve(int lun, int liv){
		if(liv==0){
			getKoch().fd(lun);
		}
		else
		{	kochcurve(lun,liv-1);
			getKoch().left(60);
			kochcurve(lun,liv-1);
			getKoch().right(120);
			kochcurve(lun,liv-1);
			getKoch().left(60);
			kochcurve(lun,liv-1);
		}
		
	}
	
	/* Koch Snowflake Based build upon a triangle */
	public void kochSFT(int lun, int liv){
		getKoch().right(30);
		kochcurve(lun,liv);
		getKoch().right(120);
		kochcurve(lun,liv);
		getKoch().right(120);
		kochcurve(lun,liv);
	}
	
	/* Koch Snowflake Based build upon a square */
	public void kochSFS (int lun, int liv){
		getKoch().right(45);
		kochcurve(lun,liv);
		getKoch().right(90);
		kochcurve(lun,liv);
		getKoch().right(270);
		kochcurve(-lun,liv);
		getKoch().right(90);
		kochcurve(-lun,liv);
	}

	public static void main(String[] args)
	{	int size=6;
		int level=3;
		if(args.length>1){
			try {
				size = Integer.parseInt(args[0]);
				level = Integer.parseInt(args[1]);
			} catch (NumberFormatException e){
				System.out.println("Not a valid number: Default values will be used!");
			}
		}

				


		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = 10;
		int y = (int) screenSize.getHeight() - 100;
		
		Point p = new Point(500,500);
		
		CurvaDiKoch k = new CurvaDiKoch();
		k.getKoch().setScreenPos(p);
		k.getKoch().hideTurtle();
		k.getKoch().right(90);
		k.kochSFT(size,level);
		k.getKoch().left(90);
		k.kochSFT(--size,level);

	}

}
