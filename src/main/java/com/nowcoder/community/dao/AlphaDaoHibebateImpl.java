package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphaDaoHibebateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
