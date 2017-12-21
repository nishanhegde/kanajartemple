package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.BankAccount;
import com.Admin.bean.BankAccountEntry;
import com.Admin.bean.Donation;
import com.Brahmalingeshwara.kanajartemple.TransactionEnum;
import com.Brahmalingeshwara.kanajartemple.TypeEnum;

public class BankAccountEntryRowMapper implements RowMapper<BankAccountEntry> {

	@Override
	public BankAccountEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
		BankAccountEntry ba = new BankAccountEntry();
		ba.setId(rs.getInt("id"));
		ba.setBankAccountId(rs.getInt("bankaccount_id"));
		ba.setBankAccountEntryId(rs.getInt("bankaccountentry_id"));
		ba.setAmount(rs.getDouble("amount"));
		ba.setType(TypeEnum.valueOf(rs.getString("type")));
		ba.setTransaction(TransactionEnum.valueOf(rs.getString("transaction")));

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		ba.setTransactionDate(formatter.format(rs.getDate("transaction_date")));

		ba.setChequeOrRefNo(rs.getString("chequeorrefno"));
		ba.setDescription(rs.getString("description"));
		return ba;
	}
}
