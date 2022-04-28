package com.techelevator.tenmo.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

public class JdbcTransferDao implements TransferDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void transferTo(long userId, BigDecimal amountToDeposit) {
        String sql = "UPDATE account\n" +
                "SET balance = \"balance + ?\"\n" +
                "WHERE user_id = ?;";

        jdbcTemplate.update(sql, userId, amountToDeposit);
    }

    @Override
    public void transferFrom(long userId, BigDecimal amountToWithdraw) {

        String sql = "UPDATE account\n" +
                "SET balance = \"balance - ?\"\n" +
                "WHERE user_id = ?;";

        jdbcTemplate.update(sql, userId, amountToWithdraw);
    }

}
