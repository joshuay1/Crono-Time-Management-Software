package DataTransfer;

import java.sql.SQLException;

import datasource.TimeMapper;
import datasource.UserMapper;

public class TimeRemoteFacade {
	
	
	public TimeDTO getTime(int id) throws SQLException {
		
		return new TimeAssembler().writeDTO(TimeMapper.getTime(id));
		
	}
	
	public String getUserXml(int id) throws SQLException {
		TimeDTO dto = getTime(id);
		return dto.xmlToString();
	}
	
	public void updateTime(int id, TimeDTO dto) throws SQLException {
		new TimeAssembler().update(TimeMapper.getTime(id),dto);
	}

}
