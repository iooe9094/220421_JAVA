package MultiThread02;

public class BankTest {

	public static void main(String[] args) {
		DongSungBank r = new DongSungBank(); // 월드뱅크 객체 생성
		
		Thread t1 = new Thread(r); // 첫 번째 쓰레드
		Thread t2 = new Thread(r); // 두 번째 쓰레드
		
		// 쓰레드 실행
		t1.start();
		t2.start();

	}

}
