package DataTransfer;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


//import javax.xml.bind.*;

public class UserDTO {
	private String firstName;
    
    private String lastName;
    private String email;
    
    private String userName;
    private String password;
    
    private int id;
    private String role;
    private List<TimeDTO> times;
    
    XMLEncoder xml;
   

	
	//serialisation
	public static void toXML(UserDTO userDTO, OutputStream outputStream) {
        XMLEncoder encoder = new XMLEncoder(outputStream);
        encoder.writeObject(userDTO);
        encoder.close();
        
    }

    public static UserDTO fromXML(InputStream inputStream) {
        XMLDecoder decoder = new XMLDecoder(inputStream);
        UserDTO result = (UserDTO) decoder.readObject();
        decoder.close();
        return result;
    }
    
    
    ///serialisation to string? 
    public String xmlToString() {
	    return xml.toString();
	    
    }

	
	
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public List<TimeDTO> getTimes() {
		return times;
	}

	public void setTimes(List<TimeDTO> times) {
		this.times = times;
	}
	
	
	
	
	
	

}
