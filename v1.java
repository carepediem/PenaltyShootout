import java.util.*;

class Attack{
	
	boolean shoot(int kick) {
		double baseShootProbability = 0.5;
		double VirtualShootProbability;
		
		VirtualShootProbability =  baseShootProbability + (kick-3)*0.1;
		
		Random random = new Random();
		double randomFactor = random.nextDouble() * 0.4 - 0.2;
		
		double FinalShootProbability = VirtualShootProbability+randomFactor;
		
		double randomValue = Math.random();
		
		return randomValue < FinalShootProbability;
	}
	
	
}

class Defense{
	 boolean punching(int diving ) {
		 double basePunchingProbability = 0.4;
			double VirtualSuccessProbability;
			
			VirtualSuccessProbability = basePunchingProbability + (diving-3)*0.1;
			
			Random random = new Random();
			double randomFactor = random.nextDouble() * 0.2 - 0.1;
			
			double FinalPunchingProbability = VirtualSuccessProbability+randomFactor;
			
			double randomValue = Math.random();
			
			return randomValue < FinalPunchingProbability;
	 }
	
} 

class MainGame{
	 void FirstAttack() {
		// Scanner scanner = new Scanner(System.in);
		 
		Process process = new Process();
		process.process();
			for(int i=1 ; i<=5 ;i++) {
				System.out.println(i+"번째 공격");
				
				Performance_firstattack performance = new Performance_firstattack();
				 performance.PerformKick( v1.Mypoint,  v1.Compoint,  i);
				 if(v1.isFinish) break;
				
				System.out.println(i+"번째 수비");
				
				 performance.PerformDive( v1.Mypoint, v1.Compoint,  i);
				 if(v1.isFinish) break;
				 
			}
		
			if(v1.Mypoint == v1.Compoint) {
				ExtraGame extra = new ExtraGame();
				extra.OneShotMatch_firstattack(v1.Mypoint, v1.Compoint);
			}
	}
	
	 void SecondAttack() {
	//	Scanner scanner = new Scanner(System.in);
		
		Process process = new Process();
		process.process();
		
			for(int i=1 ; i<=5 ;i++) {
				System.out.println(i+"번째 수비");
				
				Performance_secondattack performance = new Performance_secondattack();
				 performance.PerformDive( v1.Mypoint, v1.Compoint,  i);
				 if(v1.isFinish) break;
				
				System.out.println(i+"번째 공격");
				
				performance.PerformKick( v1.Mypoint,  v1.Compoint,  i); 
				 if(v1.isFinish) break;
				 
			}
		
			if(v1.Mypoint == v1.Compoint) {
				ExtraGame extra = new ExtraGame();
				extra.OneShotMatch_secondattack(v1.Mypoint, v1.Compoint);
			}
		
	}
}


class ExtraGame{
	
	 void OneShotMatch_firstattack(int mypoint, int compoint) {
		Scanner scanner = new Scanner(System.in);
		Print print = new Print();
		int turn =6;
		while(true) {
			
			System.out.println(turn+"번째 공격");
			Attack attack = new Attack();
			int kick = scanner.nextInt();
			if(attack.shoot( kick)) {
				System.out.println("멋진 골!");
				Performance_firstattack.my.add("O");
				print.Table_f();
				mypoint +=1;
			}
			else {
				System.out.println("실축ㅜㅜ");
				Performance_firstattack.my.add("X");
				print.Table_f();
			}
			
			System.out.println(turn+"번째 수비");
			Defense defense = new Defense();
			int diving = scanner.nextInt();
			if(defense.punching(diving) == false) {
				System.out.println("멋진 세이브!");
				Performance_firstattack.com.add("X");
				print.Table_f();
			}
			else {
				System.out.println("아쉬운 실점!");
				Performance_firstattack.com.add("O");
				print.Table_f();
				compoint += 1;
			}
			turn+=1;
			
			if(mypoint > compoint) {
				System.out.println("@@ 승리 @@");
				Performance_firstattack.my.clear();
				Performance_firstattack.com.clear();
				break;
			}
			else if(mypoint < compoint) {
				System.out.println("@@ 패배 @@");
				Performance_firstattack.my.clear();
				Performance_firstattack.com.clear();
				break;
			}

		}
	}
	
	 void OneShotMatch_secondattack(int mypoint, int compoint) {
		Scanner scanner = new Scanner(System.in);
		Print print = new Print();
		int turn =6;
		while(true) {
			
			
			System.out.println(turn+"번째 수비");
			Defense defense = new Defense();
			int diving = scanner.nextInt();
			if(defense.punching(diving) == false) {
				System.out.println("멋진 세이브!");
				Performance_secondattack.com.add("X");
				print.Table_s();
			}
			else {
				System.out.println("아쉬운 실점!");
				Performance_secondattack.com.add("O");
				print.Table_s();
				compoint += 1;
			}
			
			System.out.println(turn+"번째 공격");
			Attack attack = new Attack();
			int kick = scanner.nextInt();
			if(attack.shoot( kick)) {
				System.out.println("멋진 골!");
				Performance_secondattack.my.add("O");
				print.Table_s();
				mypoint +=1;
			}
			else {
				System.out.println("실축ㅜㅜ");
				Performance_secondattack.my.add("X");
				print.Table_s();
			}
			
			turn+=1;
			
			if(mypoint > compoint) {
				System.out.println("@@ 승리 @@");
				Performance_secondattack.my.clear();
				Performance_secondattack.com.clear();
				break;
			}
			else if(mypoint < compoint) {
				System.out.println("@@ 패배 @@");
				Performance_secondattack.my.clear();
				Performance_secondattack.com.clear();
				break;
			}

		}
	}
	
}

class Performance_firstattack{
	
	 static ArrayList<String> my = new ArrayList<>();
	static  ArrayList<String> com = new ArrayList<>();
	
	  void PerformKick(int mypoint, int compoint, int turn) {
		 Print print = new Print();
		 Scanner scanner = new Scanner(System.in);
		 mypoint =0;
		 compoint =0;
		 
		Attack attack = new Attack();
		int kick = scanner.nextInt();
		if(attack.shoot( kick)) {
			System.out.println("멋진 골!");
			my.add("O");
			print.Table_f();
			mypoint +=1;
			
		}
		else {
			System.out.println("실축ㅜㅜ");
			my.add("X");
			print.Table_f();
			
		}
		
		v1.Mypoint += mypoint;
		
		if(v1.Mypoint > v1.Compoint) {
			 if(v1.Compoint + (5-turn)+1 < v1.Mypoint ) {
				   System.out.println("@@ 승리 @@");
				   System.out.println("");
				   
				   v1.isFinish = true;
				   my.clear();
				   com.clear();
				   
				   return;
			   }
			  }
		else if(v1.Mypoint < v1.Compoint) {
            if(v1.Mypoint + (5-turn) < v1.Compoint ) {
				   System.out.println("@@ 패배 @@");
				   System.out.println("");
				  
				  
				   v1.isFinish = true;
				   my.clear();
				   com.clear();
				   
				   return;
			  }   
		   }
		
		//scanner.close();
	}
	
	 void PerformDive(int mypoint, int compoint, int turn) {
		 Scanner scanner = new Scanner(System.in);
		 mypoint =0;
		 compoint =0;
		 Print print = new Print();
		 Defense defense = new Defense();
			int diving = scanner.nextInt();
			if(defense.punching(diving) ) {
				System.out.println("멋진 세이브!");
				com.add("X");
				print.Table_f();
			}
			else {
				System.out.println("아쉬운 실점!");
				com.add("O");
				print.Table_f();
				compoint += 1;
			}
			
			v1.Compoint += compoint;
			
			if(v1.Mypoint > v1.Compoint) {
				   if(v1.Compoint + (5-turn) < v1.Mypoint ) {
					   System.out.println("@@ 승리 @@");
					   System.out.println("");
				
					  
					  v1.isFinish = true;
					   my.clear();
					   com.clear();
					   return;
				   }	  
			   }
			else if(v1.Mypoint < v1.Compoint) {
             if(v1.Mypoint + (5-turn) < v1.Compoint ) {
           	  System.out.println("@@ 패배 @@");
				   System.out.println("");
				   
				   
				   v1.isFinish = true;
				   my.clear();
				   com.clear();
					   return;
				   }   
			   }
		//	 scanner.close();		
	}
	
	
}

class Performance_secondattack{
	
	 static ArrayList<String> my = new ArrayList<>();
	static  ArrayList<String> com = new ArrayList<>();
	
	 void PerformDive(int mypoint, int compoint, int turn) {
		 Scanner scanner = new Scanner(System.in);
		 mypoint =0;
		 compoint =0;
		 Print print = new Print();
		 Defense defense = new Defense();
			int diving = scanner.nextInt();
			if(defense.punching(diving) ) {
				System.out.println("멋진 세이브!");
				com.add("X");
				print.Table_s();
			}
			else {
				System.out.println("아쉬운 실점!");
				com.add("O");
				print.Table_s();
				compoint += 1;
			}
		//	scanner.close();
			v1.Compoint += compoint;
			
			if(v1.Compoint > v1.Mypoint) {
				 if(v1.Mypoint + (5-turn)+1 < v1.Compoint ) {
					   System.out.println("@@ 패배 @@");
					   System.out.println("");
					   
					   v1.isFinish = true;
					   my.clear();
					   com.clear();
					   return;
				   }
				  }
			else if(v1.Compoint < v1.Mypoint) {
			   if(v1.Compoint + (5-turn) < v1.Mypoint ) {
					   System.out.println("@@ 승리 @@");
					   System.out.println("");
					  
					  
					  v1.isFinish = true;
					   my.clear();
					   com.clear();
					   return;
				  }   
			  }

			
	}
	
	 void PerformKick(int mypoint, int compoint, int turn) {
		 Print print = new Print();
		 Scanner scanner = new Scanner(System.in);
		 mypoint =0;
		 compoint =0;
		 
		Attack attack = new Attack();
		int kick = scanner.nextInt();
		if(attack.shoot( kick)) {
			System.out.println("멋진 골!");
			my.add("O");
			print.Table_s();
			mypoint +=1;
			
		}
		else {
			System.out.println("실축ㅜㅜ");
			my.add("X");
			print.Table_s();
			
		}
		//scanner.close();
		v1.Mypoint += mypoint;
		if(v1.Compoint > v1.Mypoint) {
			   if(v1.Mypoint + (5-turn) < v1.Compoint ) {
				   System.out.println("@@ 패배 @@");
				
				   System.out.println("");
			
				  
				   v1.isFinish = true;
				   my.clear();
				   com.clear();
				   return;
			   }	  
		}
		else if(v1.Compoint < v1.Mypoint) {
		if(v1.Compoint + (5-turn) < v1.Mypoint ) {
		  System.out.println("@@ 승리 @@");
		 
			   System.out.println("");
			   
			   
			   v1.isFinish = true;
			   my.clear();
			   com.clear();
				   return;
			   }   
		}
		
	}
	
	
}

class Menu{
	 void MainMenu() {
		System.out.println("승부차기 게임");
		 System.out.println("1.선공");
		 System.out.println("2.후공");
		 System.out.println("3.게임 종료");
		 System.out.println("");
	}
}

class Print{
	 void Table_f() {
		System.out.println("my : "+Performance_firstattack.my);
		System.out.println("com: "+Performance_firstattack.com);
		 System.out.println("");
	}
	 void Table_s() {
		System.out.println("com: "+Performance_secondattack.com);
		System.out.println("my : "+Performance_secondattack.my);
		
		 System.out.println("");
	}
}

class Process{
	 void process() {
		 System.out.println("##################게임방법############################");
		 System.out.println("#                공격                               #");                
		 System.out.println("#        1~5까지의 세기 중 하나를 입력하세요               #");
		 System.out.println("# 성공확률은 세기 순으로 0.3~0.7이며 +-0.2의 오차가 있습니다  #");
		 System.out.println("#                수비                                #");                                      
		 System.out.println("#       1~5까지의 세기 중 하나를 입력하세요                #");             
	     System.out.println("# 성공확률은 세기 순으로 0.2~0.6이며 +-0.1의 오차가 있습니다  #");
		 System.out.println("####################################################");
	}
}


public class v1 {
	
	 static boolean isFinish;
	 static  int Compoint;
	 static int Mypoint;
	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);
		  
	    
		 while(true) {
			 MainGame maingame = new MainGame();   //메인게임 객체 생성
			  Menu menu = new Menu();
			  menu.MainMenu();
			  int choice = scanner.nextInt();
		 scanner.nextLine();
		
		 switch(choice) {
		
		 case 1:                               //선공
			 isFinish = false;
			 Mypoint =0;
			 Compoint =0;
			 maingame.FirstAttack();
			 
			 break;
		 case 2:                              //후공
			 isFinish = false;
			 Mypoint =0;
			 Compoint =0;
			 maingame.SecondAttack();
			 
			 break;
		 case 3:
				System.out.println("Bye Bye!");
				System.exit(0);
				scanner.close();
     		 break;		
     		 
		 default:
				System.out.println("Please try correct option");
				System.out.println("");
		
		 }
     }
 }
	

}







