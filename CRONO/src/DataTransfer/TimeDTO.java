package DataTransfer;



import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;
import java.io.OutputStream;



public class TimeDTO {
	private int timeID;
	private String startTime; 
	private String finishTime;
	
	
	private String date;
	private int paid;
	
	private XMLEncoder xml;
	
	
	
	
    public static void toXML(TimeDTO timeDTO, OutputStream outputStream) {
        XMLEncoder encoder = new XMLEncoder(outputStream);
        encoder.writeObject(timeDTO);
        encoder.close();
    }

    public static TimeDTO fromXML(InputStream inputStream) {
        XMLDecoder decoder = new XMLDecoder(inputStream);
        TimeDTO result = (TimeDTO) decoder.readObject();
        decoder.close();
        return result;
    }
    
  ///serialisation to string? 
    public String xmlToString() {
	    return xml.toString();
	    
    }
	
	


	public int getTimeID() {
		return timeID;
	}


	public void setTimeID(int timeID) {
		this.timeID = timeID;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getFinishTime() {
		return finishTime;
	}


	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getPaid() {
		return paid;
	}


	public void setPaid(int paid) {
		this.paid = paid;
	}
	
	

}
