package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.BenefitsWithInNetworkSpecialityEyecareDiabetic;
import model.BenefitsWithInNetworkSpecialityEyecareDiabetic;

public class BenefitsWithInNetworkSpecialityEyecareDiabeticDaoImpl implements BenefitsWithInNetworkSpecialityEyecareDiabeticDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		jdbcTemplate = this.jdbcTemplate;
	}
	
	@Override
	public BenefitsWithInNetworkSpecialityEyecareDiabetic getinnetworkbenefits(String username) {
		
		String query = "select distinct niceeligibility,nicefrequency,nicecopay,nicecoverage,nicedesc,"
				+ "contacteligibility,contactfrequency,contactcopay,contactcoverage,contactdesc,"
				+ "prescriptioneligibility,prescriptionfrequency,prescriptioncopay,prescriptioncoverage,prescriptiondesc,"
				+ "frameeligibility,framefrequency,framecopay,framecoverage,framedesc,"
				+ "lasereligibility,laserfrequency,lasercopay,lasercoverage,laserdesc,"
				+ "diabeticeligibility,diabeticfrequency,diabeticcopay,diabeticcoverage,diabeticdesc,"
				+ "plandesc,comdesc,howdesc "
				+ "from benfitsinnetwork where fkusername = ?";
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		BenefitsWithInNetworkSpecialityEyecareDiabetic benefitswithinnetworkdata = jdbcTemplate.queryForObject(query,
				new Object[] { username }, new RowMapper<BenefitsWithInNetworkSpecialityEyecareDiabetic>() {
					@Override
					public BenefitsWithInNetworkSpecialityEyecareDiabetic mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						BenefitsWithInNetworkSpecialityEyecareDiabetic benefitswithinnetworkspecialityeyecareobj = new BenefitsWithInNetworkSpecialityEyecareDiabetic();
						benefitswithinnetworkspecialityeyecareobj.setNiceeligibility(rs.getString("niceeligibility"));
						benefitswithinnetworkspecialityeyecareobj.setNicefrequency(rs.getString("nicefrequency"));
						benefitswithinnetworkspecialityeyecareobj.setNicecopay(rs.getString("nicecopay"));
						benefitswithinnetworkspecialityeyecareobj.setNicecoverage(rs.getString("nicecoverage"));
						benefitswithinnetworkspecialityeyecareobj.setNicedesc(rs.getString("nicedesc"));
						benefitswithinnetworkspecialityeyecareobj.setContacteligibility(rs.getString("contacteligibility"));
						benefitswithinnetworkspecialityeyecareobj.setContactfrequency(rs.getString("contactfrequency"));
						benefitswithinnetworkspecialityeyecareobj.setContactcopay(rs.getString("contactcopay"));
						benefitswithinnetworkspecialityeyecareobj.setContactcoverage(rs.getString("contactcoverage"));
						benefitswithinnetworkspecialityeyecareobj.setContactdesc(rs.getString("contactdesc"));
						benefitswithinnetworkspecialityeyecareobj.setPrescriptioneligibility(rs.getString("prescriptioneligibility"));
						benefitswithinnetworkspecialityeyecareobj.setPrescriptionfrequency(rs.getString("prescriptionfrequency"));
						benefitswithinnetworkspecialityeyecareobj.setPrescriptioncopay(rs.getString("prescriptioncopay"));
						benefitswithinnetworkspecialityeyecareobj.setPrescriptioncoverage(rs.getString("prescriptioncoverage"));
						benefitswithinnetworkspecialityeyecareobj.setPrescriptiondesc(rs.getString("prescriptiondesc"));
						benefitswithinnetworkspecialityeyecareobj.setFrameeligibility(rs.getString("frameeligibility"));
						benefitswithinnetworkspecialityeyecareobj.setFramefrequency(rs.getString("framefrequency"));
						benefitswithinnetworkspecialityeyecareobj.setFramecopay(rs.getString("framecopay"));
						benefitswithinnetworkspecialityeyecareobj.setFramecoverage(rs.getString("framecoverage"));
						benefitswithinnetworkspecialityeyecareobj.setFramedesc(rs.getString("framedesc"));
						benefitswithinnetworkspecialityeyecareobj.setLasereligibility(rs.getString("lasereligibility"));
						benefitswithinnetworkspecialityeyecareobj.setLaserfrequency(rs.getString("laserfrequency"));
						benefitswithinnetworkspecialityeyecareobj.setLasercopay(rs.getString("lasercopay"));
						benefitswithinnetworkspecialityeyecareobj.setLasercoverage(rs.getString("lasercoverage"));
						benefitswithinnetworkspecialityeyecareobj.setLaserdesc(rs.getString("laserdesc"));
						benefitswithinnetworkspecialityeyecareobj.setDiabeticeligibility(rs.getString("diabeticeligibility"));
						benefitswithinnetworkspecialityeyecareobj.setDiabeticfrequency(rs.getString("diabeticfrequency"));
						benefitswithinnetworkspecialityeyecareobj.setDiabeticcopay(rs.getString("diabeticcopay"));
						benefitswithinnetworkspecialityeyecareobj.setDiabeticcoverage(rs.getString("diabeticcoverage"));
						benefitswithinnetworkspecialityeyecareobj.setDiabeticdesc(rs.getString("diabeticdesc"));
						benefitswithinnetworkspecialityeyecareobj.setPlandesc(rs.getString("plandesc"));
						benefitswithinnetworkspecialityeyecareobj.setComdesc(rs.getString("comdesc"));
						benefitswithinnetworkspecialityeyecareobj.setHowdesc(rs.getString("howdesc"));
						
						return benefitswithinnetworkspecialityeyecareobj;
					}
				});
		return benefitswithinnetworkdata;
	}

}
