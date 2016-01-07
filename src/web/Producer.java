package web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Soap WebService
  * @author Arthur
 *
 */
@WebService
public class Producer {
	

	/**
	 * WebMethod used to ping this producer
	 * @return "pong"
	 */
	@WebMethod(operationName="pingpong")
	public String pingpong(@WebParam(name ="processTime")int processTime,@WebParam(name="mot") String mot) {
		
			
			
		try {
			Thread.sleep(processTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	

		return "pong";
    }
}
	

