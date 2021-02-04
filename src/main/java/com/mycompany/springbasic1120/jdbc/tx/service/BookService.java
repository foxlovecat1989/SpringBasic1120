package com.mycompany.springbasic1120.jdbc.tx.service;

public interface BookService {
    void buyOne(Integer wid, Integer bid);
    void buyMany(Integer wid, Integer... bids);
}
