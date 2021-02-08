package com.mycompany.springbasic1120.jdbc.tx.service;

import com.mycompany.springbasic1120.jdbc.tx.exception.InsufficientAmount;

public interface BookService {
    void buyOne(Integer wid, Integer bid) throws InsufficientAmount;
    void buyMany(Integer wid, Integer... bids);
}
