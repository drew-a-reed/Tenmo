package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.security.Principal;

@Component
public class JdbcAccountDao implements AccountDao
{
    JdbcTemplate jdbcTemplate;
    public JdbcAccountDao(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public BigDecimal accountBalance(long userId)
    {
        BigDecimal currentBalance = new BigDecimal("0");

        String sql = "SELECT balance\n" +
                "FROM account\n" +
                "WHERE user_id = ?;";

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, userId);

        while (row.next())
        {
            currentBalance = row.getBigDecimal("balance");
        }
        return currentBalance;
    }

    private Account mapRowToAccount(SqlRowSet row)
    {
        Account account = new Account();

        account.setMemberId(row.getLong("user_id"));
        account.setAccountBalance(row.getBigDecimal("balance"));
        return account;
    }
}
