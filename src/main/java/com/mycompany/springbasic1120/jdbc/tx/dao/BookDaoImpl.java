package com.mycompany.springbasic1120.jdbc.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Integer getPrice(Integer bid) {
        String sql = "SELECT price FROM Book WHERE bid = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bid);
        return price;
    }

    @Override
    public void updateStock(Integer bid) {
        String sql = "UPDATE Stock SET amount = amount - 1 WHERE bid = ?";
        jdbcTemplate.update(sql, bid);
    }

    @Override
    public void updateWallet(Integer wid, Integer money) {
        String sql = "UPDATE Wallet SET money = money - ? WHERE wid = ?";
        jdbcTemplate.update(sql, money, wid);
    }
    
}
