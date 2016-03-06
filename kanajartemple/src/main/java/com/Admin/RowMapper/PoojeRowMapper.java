package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.Admin.bean.Pooje;

public class PoojeRowMapper implements RowMapper<Pooje> {

	@Override
	public Pooje mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pooje pooje =new Pooje();
		pooje.setPid(rs.getInt("pid"));
		pooje.setPoojeName(rs.getString("PoojeName"));
		pooje.setAmount(rs.getDouble("Amount"));
		return pooje;
	}

}
