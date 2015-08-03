package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.MemberVisionCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberVisionCardDaoImpl implements MemberVisionCardDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		jdbcTemplate = this.jdbcTemplate;
	}
	
	/************** get member vision card details for the user/member ****************/
	@Override
	public MemberVisionCard getmembervisioncard(String username) {
		
		String query = "select fkusername,coveragetype,doctornetwork,copayexam,copaymaterials "
				+ "from membervisioncard where fkusername = ? ";
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		MemberVisionCard membervisioncarddata = jdbcTemplate.queryForObject(query,
				new Object[] { username }, new RowMapper<MemberVisionCard>() {
					@Override
					public MemberVisionCard mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						MemberVisionCard membervisioncardobj = new MemberVisionCard();
						membervisioncardobj.setUsername(rs.getString("fkusername"));
						membervisioncardobj.setCoveragetype(rs.getString("coveragetype"));
						membervisioncardobj.setDoctornetwork(rs.getString("doctornetwork"));
						membervisioncardobj.setCopayexam(rs.getString("copayexam"));
						membervisioncardobj.setCopaymaterials(rs.getString("copaymaterials"));
						
						return membervisioncardobj;
					}
				});
		return membervisioncarddata;

	}

}
