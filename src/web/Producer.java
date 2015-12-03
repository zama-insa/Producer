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
 * Propose 2 services : changeProcessTime and pingpong
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
	public String pingpong(@WebParam(name="processTime")int processTime) {
		
		try {
			Thread.sleep(processTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return "pong";
    }
	
	/**
	 * change the ProcessTime
	 * @param process
	 * @return true or false if the operation worked
	 */
	
}

