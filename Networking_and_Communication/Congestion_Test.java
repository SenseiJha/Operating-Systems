package Networking_and_Communication;

public class Congestion_Test {
	public static void main(String[] args) {
		Congestion_Control congestionControl = new Congestion_Control();
		
		for(int i = 0;i < 20;i++) {
			if(i == 10) {
				congestionControl.receivedData(true);
			}
			else if(i == 15) {
				congestionControl.receivedData(false);
			}
			congestionControl.sendData();
		}
	}
}
