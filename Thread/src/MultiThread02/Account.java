package MultiThread02;

public class Account {
	int balance = 1000;
	
	// 메소드 설명 : 통장에서 금액 인출하기
	// lock 설정 :synchronized 예약어 설정 (크리티컬 섹션 알고리즘)
	public synchronized void withDraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(1000); // sleep(1000)에서 숫자는 m/s
			} catch (Exception e) {
				System.out.println("에러가 발생했습니다.");
			}
			balance -= money;
		}
	}

}
