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
	public String pingpong() {
		int time = 500;
		BufferedReader reader;
		
		try {
			
			//Open the file where the last processTime is saved
			reader = new BufferedReader(new FileReader(new File("processTime.txt")));
			
			//Read it
			time = Integer.parseInt(reader.readLine());
			
			//Close the I/O with the file
			reader.close();
			
			//Sleep to respect the processTime
			Thread.sleep(time);
		
		
		} catch (NumberFormatException | IOException | InterruptedException e) {
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
	@WebMethod(operationName="change")
	public Boolean changeProcess(@WebParam(name="process")int process) {
		
		try {
			
			//Create a new File(execute it only if not create)
			File file = new File("processTime");
			file.createNewFile();
			
			//Change the value
			FileWriter fw = new FileWriter(new File("processTime"));
			fw.write(""+process);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

