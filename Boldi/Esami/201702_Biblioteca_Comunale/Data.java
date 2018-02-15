import java.io.*;
import java.util.Calendar;

/**
 * @author Martin De Luca
 * 
 * @throws NotValidDataException If the date is not a valid one. 
 */
public class Data {

	private int g = 1;
	private int m = 1;
	private int a = 1900;

	
	public Data(){
		Calendar cal = Calendar.getInstance();
		g=cal.get(Calendar.DAY_OF_MONTH);
		m=cal.get(Calendar.MONTH)+1;
		a=cal.get(Calendar.YEAR);
	}

	public Data(int g, int m, int a) {
		if(isValidData(g,m,a)){
			this.g=g;
			this.m=m;
			this.a=a;
		} else {
			// In case the inserted data is not a valid one,
			// returns a default high value
			this.g=1;
			this.m=1;
			this.a=9999;
			throw new NotValidDataException("This is not a valid date: "+g+"/"+m+"/"+a);
		}
	}

	@Override
	public String toString(){
		return g+"/"+m+"/"+a;
	}

	@Override
	public boolean equals(Object o){
		if(!(o instanceof Data)){
			return false;
		} else {
			Data d = (Data) o;
			return (this.g == d.g &&
					this.m == d.m &&
					this.a == d.a);
		}
	}

	@Override
	public int hashCode(){
		return (g*a)/m;
	}

	public int getG(){
		return this.g;
	}

	public int getM(){
		return this.m;
	}

	public int getA(){
		return this.a;
	}

	public boolean checkMonth(int m){
		return (m>0 && m<13);
	}

	public boolean checkDay(int d, int m, int a){
		if(d<1 || d>31)
			return false;
		switch(m)
		{
			case 4:
			case 6:
			case 9:
			case 11: 
				return (d<31);
			case 2:
				int b = (isBisestile(a)) ? 1 : 0;
				return (d<(28+b));
			default:
				return checkMonth(m);
		}
	}
	
	/* Calendario Gregoriano */
	public boolean isBisestile(int a){
		if(a%100==0)
			return (a%400==0);
		else
			return (a%4==0);
	}

	/*
	 * Checks if the passed date (day, month, year)
	 * is a correct one. The year is required
	 * to be greater or equal than 1582,
	 * since that was the year when the Gregorian
	 * Calendar was introduced.
	 */
	public boolean isValidData (int g, int m, int a){
		return (checkMonth(m) && checkDay(g,m,a) && a>=1582);
	}

	public int giorniDa(Data d){

		int gDiffA = giornitraAnni(this.a-1,d.a);
		int gGMThis = mesiInGiorni(this.m-1,this.a) + this.g;
		int gGMData = mesiInGiorni(d.m-1,d.a) + d.g;

		return gDiffA + Math.abs(gGMThis - gGMData);
	}

	public int giorniDaEpoca() {
		Data d = new Data(1,1,1970);

		return giorniDa(d);
	}

	public int giornitraAnni(int da, int a){
		if(da==a){
			return 0;
		}
		if(da>a) {
			int b = (isBisestile(da)) ? 1 : 0;
			return 365 + b + giornitraAnni(--da,a);
		} else {
			int b = (isBisestile(da)) ? 1 : 0;
			return 365 + b + giornitraAnni(++da,a);
		}
	}

	public int mesiInGiorni(int m, int a) {
		int giorniMesi=0;
		if(checkMonth(m)) {
			int b = (isBisestile(a)) ? 1 : 0;
			while(m>0){
				switch(m){
					case 4:
					case 6:
					case 9:
					case 11: 	giorniMesi+=30;
								break;
					case 2:  	giorniMesi+=(28+b);
								break;
					default: 	giorniMesi+=31;
				}
				m--;
			}
		}
		return giorniMesi;
	}

	public Data successiva() {
		int sM = ((m+2)%12==0) ? 12 : (m+2)%12;
		int sA = (sM<m) ? a+1 : a;
		
		Data d = new Data(1,sM,sA);

		return d;
	}

	public boolean vienePrimaDi(Data d){
		return
		(
		  (  (this.a-d.a) +
			 ((this.m*30+this.g) - (d.m*30+d.g))
		  ) < 0
		);
	}
}
