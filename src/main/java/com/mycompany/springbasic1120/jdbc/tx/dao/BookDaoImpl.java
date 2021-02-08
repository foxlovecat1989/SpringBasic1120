package com.mycompany.springbasic1120.jdbc.tx.dao;

import com.mycompany.springbasic1120.jdbc.tx.exception.InsufficientAmount;
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
    public void updateWallet(Integer wid, Integer money) throws InsufficientAmount{
        // 先判斷 Wallet 的 money 是否足夠 ?
        String sql = "SELECT money FROM Wallet WHERE wid = ?";
        int walletMoney = jdbcTemplate.queryForObject(sql, Integer.class, wid);
        if(walletMoney < money) {
            throw new InsufficientAmount();
        }
        // 進行錢包餘額更新
        sql = "Update Wallet SET money = money - ? WHERE wid = ?";
        jdbcTemplate.update(sql, money, wid);
    }
    
}
