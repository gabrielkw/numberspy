package com.muthdra.numberspy;

public class Spyable {
	public float value;
	
	Spyable(float n){
		this.value = n;
	}
	
	public void setValue(long n){
		this.value = n;
	}
	
	public float getValue(){
		return value;
	}
	
	public String getSin(){
		return String.valueOf(Math.sin(value));
	}
	
	public String getLog(){
		return String.valueOf(Math.log(value));
	}
	
	public String getCos(){
		return String.valueOf(Math.cos(value));
	}
	
	public String getHex(){
		return Long.toHexString((long)value);
	}
	
	public String getOct(){
		return Long.toOctalString((long)value);
	}
	
	public String getBin(){
		return String.valueOf(Long.toBinaryString((long)value));
	}
	
	public String getRoman(){
		int input = (int)value;
		if (input < 1 || input > 3999)
	        return "Invalid Roman Number Value";
	    String s = "";
	    while (input >= 1000) {
	        s += "M";
	        input -= 1000;        }
	    while (input >= 900) {
	        s += "CM";
	        input -= 900;
	    }
	    while (input >= 500) {
	        s += "D";
	        input -= 500;
	    }
	    while (input >= 400) {
	        s += "CD";
	        input -= 400;
	    }
	    while (input >= 100) {
	        s += "C";
	        input -= 100;
	    }
	    while (input >= 90) {
	        s += "XC";
	        input -= 90;
	    }
	    while (input >= 50) {
	        s += "L";
	        input -= 50;
	    }
	    while (input >= 40) {
	        s += "XL";
	        input -= 40;
	    }
	    while (input >= 10) {
	        s += "X";
	        input -= 10;
	    }
	    while (input >= 9) {
	        s += "IX";
	        input -= 9;
	    }
	    while (input >= 5) {
	        s += "V";
	        input -= 5;
	    }
	    while (input >= 4) {
	        s += "IV";
	        input -= 4;
	    }
	    while (input >= 1) {
	        s += "I";
	        input -= 1;
	    }    
	    return s;
	}
	
	public String getIsPrime(){
		int i = (int)value;
		int count = 0;
		
		for(int j=1; j<=i; j++) {
							
			if((i%j) == 0) {
				
				count++;
			}
		}
		if(count == 2) {
			return "Yes";
		}
		else {
			return "No";
		}
	}
}
