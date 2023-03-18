package com.lab2.lab2.Dao;

import com.lab2.lab2.Entity.Major;

import java.util.List;

public interface MajorDao {

    void add(Major major);

    void modify(Major major);

    void remove(String mid);

    Major getByMid(String mid);

    List<Major> getAll(String sql);
}
