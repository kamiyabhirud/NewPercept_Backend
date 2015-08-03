package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.BenefitsWithOutOfNetworkProviders;

public class BenefitsWithOutOfNetworkProvidersDaoImpl implements BenefitsWithOutOfNetworkProvidersDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		jdbcTemplate = this.jdbcTemplate;
	}
	
	@Override
	public BenefitsWithOutOfNetworkProviders getoutofnetworkbenefits(String username) {
		String query = "select fkusername,exam_eligibility,exam_frequency,exam_copay,exam_coverage,"
				+ "prescriptionlenses_eligibility,prescriptionlenses_frequency,prescriptionlenses_copay,"
			 +"prescriptionlenses_coverage,frame_eligibility,frame_frequency,frame_copay,frame_coverage,"
			 + "contactsinsteadofglass_eligibility,"
			 +"contactsinsteadofglass_frequency,contactsinsteadofglass_copay,contactsinsteadofglass_coverage "
			 + "from benefitswithoutofnetwork where fkusername = ? ";
		// using RowMapper anonymous class, we can create a separate RowMapper
		// for reuse
		BenefitsWithOutOfNetworkProviders benefitswithoutofnetworkprovidersdata = jdbcTemplate.queryForObject(query,
				new Object[] { username }, new RowMapper<BenefitsWithOutOfNetworkProviders>() {
					@Override
					public BenefitsWithOutOfNetworkProviders mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						BenefitsWithOutOfNetworkProviders benefitswithoutofnetworkprovidersobj = new BenefitsWithOutOfNetworkProviders();
						benefitswithoutofnetworkprovidersobj.setUsername(rs.getString("fkusername"));
						benefitswithoutofnetworkprovidersobj.setExam_eligibility(rs.getString("exam_eligibility"));
						benefitswithoutofnetworkprovidersobj.setExam_frequence(rs.getString("exam_frequency"));
						benefitswithoutofnetworkprovidersobj.setExam_copay(rs.getString("exam_copay"));
						benefitswithoutofnetworkprovidersobj.setExam_coverage(rs.getString("exam_coverage"));
						benefitswithoutofnetworkprovidersobj.setPrescriptionlenses_eligibility(rs.getString("prescriptionlenses_eligibility"));
						benefitswithoutofnetworkprovidersobj.setPrescriptionlenses_frequency(rs.getString("prescriptionlenses_frequency"));
						benefitswithoutofnetworkprovidersobj.setPrescriptionlenses_copay(rs.getString("prescriptionlenses_copay"));
						benefitswithoutofnetworkprovidersobj.setPrescriptionlenses_coverage(rs.getString("prescriptionlenses_coverage"));
						benefitswithoutofnetworkprovidersobj.setFrame_eligibility(rs.getString("frame_eligibility"));
						benefitswithoutofnetworkprovidersobj.setFrame_frequency(rs.getString("frame_frequency"));
						benefitswithoutofnetworkprovidersobj.setFrame_copay(rs.getString("frame_copay"));
						benefitswithoutofnetworkprovidersobj.setFrame_coverage(rs.getString("frame_coverage"));
						benefitswithoutofnetworkprovidersobj.setContactsinsteadofglass_eligibility(rs.getString("contactsinsteadofglass_eligibility"));
						benefitswithoutofnetworkprovidersobj.setContactsinsteadofglass_frequency(rs.getString("contactsinsteadofglass_frequency"));
						benefitswithoutofnetworkprovidersobj.setContactsinsteadofglass_copay(rs.getString("contactsinsteadofglass_copay"));
						benefitswithoutofnetworkprovidersobj.setContactsinsteadofglass_coverage(rs.getString("contactsinsteadofglass_coverage"));
						
						return benefitswithoutofnetworkprovidersobj;
					}
				});
		return benefitswithoutofnetworkprovidersdata;
	}

}
