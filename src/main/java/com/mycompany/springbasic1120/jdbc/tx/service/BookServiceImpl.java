package com.mycompany.springbasic1120.jdbc.tx.service;

import com.mycompany.springbasic1120.jdbc.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookDao bookDao;
    
    @Override
    public void buyOne(Integer wid, Integer bid) {
        int price = bookDao.getPrice(bid);
        System.out.println("BookService 交易開始");
        bookDao.updateStock(bid);
        bookDao.updateWallet(wid, price);
        System.out.println("BookService 交易完成");
    }

    @Override
    public void buyMany(Integer wid, Integer... bids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
