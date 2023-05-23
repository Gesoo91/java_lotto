package com.lotto.array;

import java.util.Scanner;

public class Lotto {
//todo : 46의 랜덤숫자에서 6번 뽑기, 6개 뽑는 중에 중복 제거, 입력값이 맞는 갯수로 당첨확인, 3등중에 보너스번호 맞는사람 2등, 
	
	void run() {
		int ran = 0;

		Scanner sc = new Scanner(System.in);
//		String user[] = sc.next();
		int user[] = new int[6];
		
//		입력값을 user 배열에 넣는 법 기억이 안남. 공부할것. Scanner 객체인 sc 생성, nextInt() 메서드를 사용하여 입력한 정수를 읽고 for루프문 안에 user 배열의 각 요소에 할당하기.
		
		int com_num[] = new int[7];
		int win = 0;
		//외부입력된 숫자 순차적으로 적기.
		for(int i=0; i<6; i++) {
			System.out.println(i+1+"번 숫자 입력:");
			user[i]=sc.nextInt();
//		todo 입력번호 중복방지
			if(user[i]<1||user[i]>45) {
				System.out.println("1~45의 숫자를 입력해주세요.");
				i--;
				continue;
			}
			for(int j=0; j<i; j++) {
				if(user[i]==user[j]) {
					System.out.println("중복된 숫자입니다.");
					j=0;
					i--;
				}
			}
			
		}

		//로또번호뽑기 외부반복문에서 7번, 내부에서는 j가i보다 하나적게 ==> 0일때 j는없으니 바로나오고, 1일때는 0일때랑 같으면~~ 반복 6일때 5,4,3,2,1과 같으면 다시하게함.
		for(int i=0; i<com_num.length; i++) {
			ran = (int)(Math.random()*46+1); //1~46 번호 나오는 값
			com_num[i]=ran;
			for(int j=0;i>j;j++) {
				if(com_num[i]==com_num[j]) {
					i--;
					break;
				}
			}
		}
		//로또번호 순차적으로 입력, 처음에 for문 안쪽에서 한번에 처리하려했으니 그 경우네는 do while 문이나 arrayList 를 사용해야됨.
		for(int i=0; i<6; i++) {
			System.out.println(i+1+"번째 번호"+com_num[i]);
//				중복번호 제거하는 방법 fisher-yates알고리즘, do while에서 isDuplicate 변수사용하여 중복여부 확인, availableNumbers 라는 ArrayList를 사용하여 관리하기
//				아니면 출력에 반복문을 넣어서 i값을 지정하여 적게하기.
		}
		//보너스번호 지정
		System.out.println("보너스번호"+com_num[6]);
		
		
		//입력값과 로또값 맞으면 +1되는 식.
		for(int i=0; i<6; i++) {
			for(int j=0; j<i; j++) {
				if(user[i] == com_num[j]) {
					win=win+1;
				}
			}
		}
		//win 값에 따른 당첨 맞추기
		System.out.println("맞은 갯수:"+win);
		if(win<3) {
			System.out.println("꽝");
		}
		else if(win==3) {
			System.out.println("5등입니다.");
		}
		else if(win==4) {
			System.out.println("4등입니다.");
		}
		else if(win==5) {
			//5개 맞은 상태를 boolean을 이용해 false값을 주고 보너스번호가 맞았다면(5개 맞았고 1개 틀렷는데 그 틀린 1개가 보너스와 맞은 상태) 아래 if문에서 2등과 3등으로 나눔.
			boolean bonus = false;
			for(int i=0;i<6;i++) {
				if(user[i]==com_num[6]) {//5개 맞은상태고 남은 한개가 보너스번호와 맞으면 2등이 된다. 5개 맞으면 fulse상태, 거기에 for문으로 i=1~6일때 == com_num[6] 이면 true 하면될듯
					bonus = true;
					break;
				}
			}
				if(bonus == true) {
					System.out.println("2등입니다.");
				}
				else {
					System.out.println("3등입니다.");
				}
			
		}
		else if(win==6) {
			System.out.println("1등입니다.");
		}
		
	}
}


