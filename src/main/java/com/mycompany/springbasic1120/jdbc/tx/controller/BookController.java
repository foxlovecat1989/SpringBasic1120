package com.mycompany.springbasic1120.jdbc.tx.controller;

public interface BookController {
    void buyBook(Integer wid, Integer bid);
    void buyBooks(Integer wid, Integer... bids);
}
