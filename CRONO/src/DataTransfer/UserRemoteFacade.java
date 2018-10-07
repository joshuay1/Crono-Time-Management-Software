package DataTransfer;

import java.sql.SQLException;

import datasource.UserMapper;

public class UserRemoteFacade {
	
	
	public UserDTO getUser(int id) throws SQLException {
		
		return new UserAssembler().writeDTO(UserMapper.getUser(id));
		
	}
	
	public String getUserXml(int id) throws SQLException {
		UserDTO dto = getUser(id);
		return dto.xmlToString();
	}
	
	public void updateUSer(int id, UserDTO dto) throws SQLException {
		new UserAssembler().update(UserMapper.getUser(id),dto);
	}
	

}
