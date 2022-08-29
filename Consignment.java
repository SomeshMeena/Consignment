package interview;

public class Consignment {
	
	public String ConsignmentNoteNumberGenerator (String prefix, String accountNumber,  int  digits, int lastUsedIndex, int rangeStart, int rangeEnd) {
		String resValue="";
		resValue=resValue+prefix+accountNumber;
		
	
		String zeroNumber="00000";
		if(digits==10) {
			
			//Validate the range
			if(lastUsedIndex>=rangeStart && lastUsedIndex<= rangeEnd) {
				lastUsedIndex=lastUsedIndex+1;
				zeroNumber=zeroNumber+lastUsedIndex;
		
		
		//  ..................calculate the checksum..........................
		
		String first="";
		String second="";
		int lenValue=zeroNumber.length();
		for(int i = lenValue-1; i>=0; i--) {
			if(i%2==0) {
				second=second + zeroNumber.charAt(i); 
				
			}
			else {
				first=first + zeroNumber.charAt(i); 
				
				
			}
			
		}
		
		System.out.println("second Value is -> " + second);
		System.out.println("First Value is -> " + first);
		
		int firstNumber  =Integer.parseInt(first); 
		
		int secoundNumber  =Integer.parseInt(second);
		int rem1=0, sum1=0, sum2=0, rem2=0;
		while(firstNumber !=0 ){
			
			rem1=firstNumber%10;
			sum1= sum1+rem1;
			firstNumber=firstNumber/10;	
			
		}
		
		while(secoundNumber !=0 ){
			rem2=secoundNumber%10;
			sum2= sum2+rem2;
			secoundNumber=secoundNumber/10;
		}
		
		int multi3Number=sum1*3;
		int multi7Number=sum2*7;
		
		int sumOfMulti3NumberMulti7Number = multi3Number+multi7Number;
		
		System.out.println("sum1 Value is -> " + sum1);
		System.out.println("sum2 Value is -> " + sum2);
		System.out.println("multi3Number Value is -> " + multi3Number);
		System.out.println("multi7Number Value is -> " + multi7Number);
		System.out.println("sumOfMulti3NumberMulti7Number Value is -> " + sumOfMulti3NumberMulti7Number);
		
		int rem3=sumOfMulti3NumberMulti7Number%10;
		System.out.println("rem3 Value is -> " + rem3);
		
		int checksum=10-rem3;
		System.out.println("checksum Value is -> " + checksum);
		
		zeroNumber=zeroNumber+checksum;
		resValue=resValue+zeroNumber;
	}
			
			
		}
		return resValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Consignment cont= new Consignment();
	
		 String carrierName = "FreightmateCourierCo";
		 String prefix="FMCC";
		 String accountNumber="123ABC";
		 int  digits= 10;
		  int lastUsedIndex=19604;
		  int rangeStart=19000;
		  int rangeEnd=20000;
		  
			String result= cont.ConsignmentNoteNumberGenerator( prefix, accountNumber, digits,lastUsedIndex,rangeStart, rangeEnd);

			System.out.println(carrierName + " consignment no is  ->  " + result );
	}

}
