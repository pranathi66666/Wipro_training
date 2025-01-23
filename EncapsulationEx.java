public class EncapsulationEx {
    private int age;
	
	public int getage() {
		return age;
	}
	
	public void setage(int age) {
		if (age>=18) {
			System.out.println("Eligible to vote");
		}else {
			System.out.println("Not eligible to vote");
		}
	}
	
	public static void main(String[] args) {
		EncapsulationEx en=new EncapsulationEx();
		en.setage(18);

	}

    
}
