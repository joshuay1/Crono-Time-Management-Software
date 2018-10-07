package DataTransfer;

import java.sql.SQLException;
import java.util.List;

import domain.Time;
import domain.User;

public class UserAssembler {
	
	List<TimeDTO> timeDTO; 
	public UserDTO writeDTO(User user) throws SQLException {
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setEmail(user.getEmail());
		userDTO.setId(user.getID());
		userDTO.setUserName(user.getUserName());
		userDTO.setPassword(user.getPassword());
		List<Time> times = user.getTimeSheet();
		
		for(int i = 0; i < times.size();i++) {
			TimeAssembler t = new TimeAssembler();
			timeDTO.add(t.writeDTO(times.get(i)));
			
		}
		userDTO.setTimes(timeDTO);
		userDTO.setRole(user.getRole());
		
		return userDTO;
	}
	
	
	public UserDTO update(User user, UserDTO userDTO) throws SQLException {
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setEmail(user.getEmail());
		userDTO.setId(user.getID());
		userDTO.setUserName(user.getUserName());
		userDTO.setPassword(user.getPassword());
		List<Time> times = user.getTimeSheet();
		
		for(int i = 0; i < times.size();i++) {
			TimeAssembler t = new TimeAssembler();
			timeDTO.add(t.writeDTO(times.get(i)));
			
		}
		userDTO.setTimes(timeDTO);
		userDTO.setRole(user.getRole());
		
		return userDTO;
	}


}
