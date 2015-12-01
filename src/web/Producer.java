package web;

import javax.jws.WebMethod;
import javax.jws.WebParam;

public class Producer {
	
	/*
	 * process time in ms
	 */
	private int processTime = 3000;
	/**
	 * WebMethod used to ping this producer
	 * @return "pong"
	 */
	@WebMethod(operationName="pingpong")
	public String pingpong() {
		try {
			Thread.sleep(processTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pong";
    }
}
