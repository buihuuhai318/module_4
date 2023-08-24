package com.example.app_rent_book.service.imp;

import com.example.app_rent_book.model.Log;
import com.example.app_rent_book.repository.ILogRepository;
import com.example.app_rent_book.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService implements ILogService {

    @Autowired
    private ILogRepository logRepository;

    @Override
    public List<Log> findAll() {
        return logRepository.findAll();
    }

    @Override
    public Optional<Log> findById(Integer id) {
        return logRepository.findById(id);
    }

    @Override
    public void save(Log log) {
        logRepository.save(log);
    }

    @Override
    public void remove(Integer id) {
        logRepository.deleteById(id);
    }
}
