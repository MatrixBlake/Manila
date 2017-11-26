import java.util.*;

public class Manila {

	public static void main(String[] args) {
		System.out.println("Please input the color of the boats:");
		Scanner scn1 = new Scanner(System.in);
		String[] boat = scn1.nextLine().split(" ");
		
		System.out.println();
		System.out.println("Please input the number of people the boats:");
		Scanner scn2 = new Scanner(System.in);
		String[] numberString = scn2.nextLine().split(" ");
		int[] number = new int[3];
		for(int i=0;i<3;i++) {
			number[i]=Integer.parseInt(numberString[i]);
		}
		
		System.out.println();
		System.out.println("Please input the position of the boats");
		Scanner scn3 = new Scanner(System.in);
		String[] positionString = scn2.nextLine().split(" ");
		int[] position = new int[3];
		for(int i=0;i<3;i++) {
			position[i]=Integer.parseInt(positionString[i]);
		}
		
		System.out.println();
		System.out.println("Please input the number of rounds left");
		Scanner scn4 = new Scanner(System.in);
		int round = scn4.nextInt();
		
		double[] pSafe= new double[3];
		double[] pDestroyed = new double[3];
		double[] pPirate = new double[3];
		double[] pPort= new double[3];
		double[] pMend = new double[3];
		

		if(round==3) {
			for(int j=0;j<3;j++) {
				switch(position[j]){
				case 0: pSafe[j]=0.162;pPirate[j]=0.0972;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 1: pSafe[j]=0.2592;pPirate[j]=0.1157;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 2: pSafe[j]=0.3749;pPirate[j]=0.125;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 3: pSafe[j]=0.4999;pPirate[j]=0.125;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 4: pSafe[j]=0.6249;pPirate[j]=0.1158;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 5: pSafe[j]=0.7404;pPirate[j]=0.0973;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				}
			}
		}
		
		if(round==2) {
			for(int j=0;j<3;j++) {
				switch(position[j]){
				case 1: pSafe[j]=0;pPirate[j]=0.0278;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 2: pSafe[j]=0.0278;pPirate[j]=0.0555;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 3: pSafe[j]=0.0833;pPirate[j]=0.0833;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 4: pSafe[j]=0.1666;pPirate[j]=0.1111;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 5: pSafe[j]=0.2777;pPirate[j]=0.1389;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 6: pSafe[j]=0.4166;pPirate[j]=0.1667;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 7: pSafe[j]=0.5833;pPirate[j]=0.1389;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 8: pSafe[j]=0.7222;pPirate[j]=0.1111;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 9: pSafe[j]=0.8333;pPirate[j]=0.0833;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 10: pSafe[j]=0.9166;pPirate[j]=0.0555;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 11: pSafe[j]=0.9721;pPirate[j]=0.0278;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				}
			}
		}
		
		if(round==1) {
			for(int j=0;j<3;j++) {
				switch(position[j]){
				case 2: pSafe[j]=0;pPirate[j]=0;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 3: pSafe[j]=0;pPirate[j]=0;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 4: pSafe[j]=0;pPirate[j]=0;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 5: pSafe[j]=0;pPirate[j]=0;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 6: pSafe[j]=0;pPirate[j]=0;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 7: pSafe[j]=0;pPirate[j]=0.1667;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 8: pSafe[j]=0.1667;pPirate[j]=0.1667;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 9: pSafe[j]=0.3333;pPirate[j]=0.1667;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 10: pSafe[j]=0.5;pPirate[j]=0.1667;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 11: pSafe[j]=0.6667;pPirate[j]=0.1667;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 12: pSafe[j]=0.8333;pPirate[j]=0.1667;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 13: pSafe[j]=1;pPirate[j]=0;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				case 14: pSafe[j]=1;pPirate[j]=0;pDestroyed[j]=1-pSafe[j]-pPirate[j];break;
				}
			}
		}
		
		pPort[2]=pSafe[0]*pSafe[1]*pSafe[2];
		pPort[1]=pPort[2]+pSafe[0]*pSafe[1]*(1-pSafe[2])+pSafe[0]*pSafe[2]*(1-pSafe[1])+pSafe[1]*pSafe[2]*(1-pSafe[0]);
		pPort[0]=1-(1-pSafe[0])*(1-pSafe[0])*(1-pSafe[0]);
		double portA=pPort[0]*6-4;
		double portB=pPort[1]*8-3;
		double portC=pPort[2]*15-2;
		
		pMend[2]=pDestroyed[0]*pDestroyed[1]*pDestroyed[2];
		pMend[1]=pMend[2]+pDestroyed[0]*pDestroyed[1]*(1-pDestroyed[2])+pDestroyed[0]*pDestroyed[2]*(1-pDestroyed[1])+pDestroyed[1]*pDestroyed[2]*(1-pDestroyed[0]);
		pMend[0]=1-(1-pDestroyed[1])*(1-pDestroyed[2])*(1-pDestroyed[0]);
		double mendA=pMend[0]*6-4;
		double mendB=pMend[1]*8-3;
		double mendC=pMend[2]*15-2;		
		
		double blue=0;
		double green=0;
		double yellow=0;
		double black=0;
		double pirate=0;
		
		for(int i=0;i<3;i++) {
			if(boat[i].equals("blue")) {
				switch(number[i]) {
				case 0: blue = 10*pSafe[i]-3;break;
				case 1: blue = 10*pSafe[i]-4;break;
				case 2: blue = 10*pSafe[i]-5;break;
				case 3: blue = -99;break;
				}
				pirate=pirate+pPirate[i]*30;
			}
			if(boat[i].equals("black")) {
				switch(number[i]) {
				case 0: black = 8*pSafe[i]-2;break;
				case 1: black = 8*pSafe[i]-3;break;
				case 2: black = 8*pSafe[i]-4;break;
				case 3: black = -99;break;
				}
				pirate=pirate+pPirate[i]*24;
			}
			if(boat[i].equals("green")) {
				switch(number[i]) {
				case 0: green = 9*pSafe[i]-3;break;
				case 1: green = 8*pSafe[i]-4;break;
				case 2: green = 8*pSafe[i]-5;break;
				case 3: green = 8*pSafe[i]-5;break;
				case 4: green = -99;break;
				}
				pirate=pirate+pPirate[i]*36;
			}
			if(boat[i].equals("yellow")) {
				switch(number[i]) {
				case 0: yellow = 6*pSafe[i]-1;
				case 1: yellow = 6*pSafe[i]-2;
				case 2: yellow = 6*pSafe[i]-3;
				case 3: yellow = -99;
				}
				pirate=pirate+pPirate[i]*18;
			}
		}
		
		pirate=pirate-5;
		
		System.out.println(pPort[0]);
		System.out.println(pPort[1]);
		System.out.println(pPort[2]);
		
		System.out.println("Boarding on yellow: "+yellow);
		System.out.println("Boarding on green: "+green);
		System.out.println("Boarding on black: "+black);
		System.out.println("Boarding on blue: "+blue);
		System.out.println("Being a pirate: "+pirate);
		System.out.println("Taking port A: "+portA);
		System.out.println("Taking port B: "+portB);
		System.out.println("Taking port C: "+portC);
		System.out.println("Taking mend A: "+mendA);
		System.out.println("Taking mend B: "+mendB);
		System.out.println("Taking mend C: "+mendC);
				
	}

}
