package com.ofds.server.ofdsserver.test;
import com.ofds.server.ofdsserver.entity.mulpti.UserContact;
import com.ofds.server.ofdsserver.entity.single.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {


    @PersistenceContext
    private EntityManager em;


    @RequestMapping(path="/test1",method=RequestMethod.GET)
    @Transactional
    public String test1() {


        em.persist(new TestTable(System.currentTimeMillis()+"","BBBBB","CCCCC"));
        em.persist(new User(System.currentTimeMillis()+"","BBBBB","CCCCC"));

        em.persist(new UserContact(System.currentTimeMillis()+"",System.currentTimeMillis()+"",System.currentTimeMillis()+"",System.currentTimeMillis()+"",System.currentTimeMillis()+""));



        return "DOWN";
    }

    @RequestMapping(path="/test2",method=RequestMethod.GET)
    public  Map<String,HashMap<String,Class<?>>>  test2() {

        HashMap<String,Class<?>> map1 = new HashMap<String,Class<?>>();

        map1.put("String1",User.class);
        map1.put("String2",User.class);
        map1.put("String3",User.class);
        map1.put("String4",User.class);
        map1.put("String5",User.class);
        Map<String,HashMap<String,Class<?>>> map2 = new HashMap<String,HashMap<String,Class<?>>>();
        map2.put("key1",map1);
        map2.put("key2",map1);
        map2.put("key3",map1);
        map2.put("key4",map1);




        return map2;
    }
}
