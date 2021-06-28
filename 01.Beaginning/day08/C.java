class Account //BlackBoxModel  
{
	private String ssn = "123456-1234567"; //??? ??
	private long balance = 10000L;
	String getSsn(){
		return ssn;
	}
	long getBalance(){
		return balance;
	}
	/*void setSsn(String ssn){
		this.ssn = ssn;
	}*/
	void setBalance(long balance){
		this.balance = balance;
	}
}

class Banker
{
	public static void main(String args[]){
		Account acc = new Account();
		System.out.println("acc.getSsn(): " + acc.getSsn());
		System.out.println("acc.getBalance(): " + acc.getBalance());
		System.out.println();

        //acc.setSsn("654321-1234567");
		acc.setBalance(20000L);
		System.out.println("acc.getSsn(): " + acc.getSsn());
		System.out.println("acc.getBalance(): " + acc.getBalance());
	}
}
