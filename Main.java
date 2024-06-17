package tic_tac_toe;
import java.util.Scanner;
public class Main {
	
	static String ticTac[][] = {{"00","01","02"},{"10","11","12"},{"20","21","22"}};
	static int playerCount=0;
	
	public static void printing() {
		for(int i=0;i<ticTac.length;i++) {
			for(int j=0;j<ticTac[i].length;j++) {
				System.out.print(ticTac[i][j]+" | ");
			}
			System.out.println();
		}
	}
	
	public static void msg(Scanner s) {
		int x=0;
		int y=0;
		System.out.println(playerCount%2==0?"Player X":" Player Y");
		System.out.print("Enter the x value : ");
		x=s.nextInt();
		System.out.print("Enter the y value : ");
		y=s.nextInt();
		System.out.println(insert(x,y,playerCount%2==0?"X":"Y"));
	}
	
	public static String insert(int x,int y, String s) {
		if((x>=0 && x<3)&&(y<3 && y>=0)) {
			if(!ticTac[x][y].equals("X") && !ticTac[x][y].equals("O")) {
				ticTac[x][y]=s;
				playerCount++;
				if(check()) {
					System.out.println(s+" wins");
					System.exit(0);
				}
				else if(playerCount==9) {
					System.out.println("Match Draw");
					System.exit(0);
				}
				printing();
				return "Inserted";
			}
			else {
				return "Already occupied";
			}
		}
		return "Unexpected Place";
	}
	
	public static Boolean check() {
		for(int i=0;i<ticTac.length;i++) {
			if(ticTac[i][0].equals(ticTac[i][1])&&ticTac[i][1].equals(ticTac[i][2])) {
				return true;
			}
		}
		for(int i=0;i<ticTac.length;i++) {
			if(ticTac[0][i].equals(ticTac[1][i])&&ticTac[1][i].equals(ticTac[2][i])) {
				return true;
			}
		}
		if(ticTac[0][2].equals(ticTac[1][1])&&ticTac[1][1].equals(ticTac[2][0])) {
			return true;
		}
		if(ticTac[0][0].equals(ticTac[1][1])&&ticTac[1][1].equals(ticTac[2][2])) {
			return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		while(true) {
			msg(s);
		}
		
	}

}
