package com.example.app_rent_book.service;

import com.example.app_rent_book.model.RentDetail;

import java.util.List;

public interface IRentDetailService extends IGenerateService<RentDetail> {
    public List<RentDetail> findAllByRentStatusContaining(int status);

    boolean isValidBorrowCode(int id, String borrowCode);
}
