package com.ofds.server.ofdsserver.dao;

import com.ofds.server.ofdsserver.entity.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OfdsSystemDao {

    @PersistenceContext
    private EntityManager em;

    public <T extends BaseEntity> void insert(Class<T> clazz, Object obj)
    {
    }

    public <T extends BaseEntity> void update(Class<T> clazz, Object obj)
    {
    }

    public <T extends BaseEntity> void delete(Class<T> clazz, Object obj)
    {
    }

    public <T extends BaseEntity> void find(Class<T> clazz, Object obj)
    {
    }


    public List<? extends BaseEntity> find(Class<? extends BaseEntity> clazz, List<Field> features, String[] objectIds) {




        return null;
    }
}
