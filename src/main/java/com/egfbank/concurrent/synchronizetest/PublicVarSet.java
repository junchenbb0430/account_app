package com.egfbank.concurrent.synchronizetest;

public class PublicVarSet {

	public static void main(String[] args) {
		final PublicVar pv = new PublicVar();
		Thread t = new Thread(new Runnable(){

			public void run() {
				 pv.setValue("B", "BB");
			}
			
		});
		t.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pv.getValue();
	}

}

class PublicVar{
	private String userName ="A";
	private String password = "AA";
	
	public synchronized void setValue(String userName,String password){
		this.userName = userName;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.password = password;
		System.out.println("setValue method execute : userName="+this.userName+",password = "+this.password+
				",current Thread Name : "+Thread.currentThread().getName());
	}
	
	public void getValue(){
		System.out.println(Thread.currentThread().getName()+",userName ="+this.userName+",password= "+this.password);
	}
}

 
