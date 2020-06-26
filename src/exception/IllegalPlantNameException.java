/**
 * 
 */
package exception;

import java.io.IOException;

/**
 * @author Jushita Rahman
 * Date: 09/06/2020
 * Course: CS622
 * Throws exception when plant name is illegal
 */
public class IllegalPlantNameException extends IOException {
	public IllegalPlantNameException() {
		super();
	}
	public IllegalPlantNameException(String s) {
		super(s);
	}
	
	public IllegalPlantNameException(String name, String reason) {
        super(name + ((reason == null)
                      ? ""
                      : " (" + reason + ")"));
    }
}
