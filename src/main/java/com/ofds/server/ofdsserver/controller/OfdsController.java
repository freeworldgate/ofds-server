package com.ofds.server.ofdsserver.controller;

import com.ofds.server.ofdsserver.dao.OfdsSystemDao;
import com.ofds.server.ofdsserver.entity.BaseEntity;
import com.ofds.server.ofdsserver.exception.OfdsException;
import com.ofds.server.ofdsserver.util.OFDSFeatureType;
import com.ofds.server.ofdsserver.util.OfdsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OfdsController {

    @Autowired
    OfdsSystemDao ofdsSystemDao;


    @RequestMapping(path="/findSingleFeature")
    public Map<String, HashMap<String, String>>  singleFeature(String objectType,String[] featureTypes,String[] objectIds) throws OfdsException {
        //objectId:{featureType:FeatureValue}
        Map<String, HashMap<String, String>> result = new HashMap<String, HashMap<String, String>>();
        //校验对象是否具有这些特征
        OfdsUtil.checkSingleFeatureRequest(objectType,featureTypes);
        Map<Class<? extends BaseEntity>,ArrayList<Field>> spliteSingleFeature = OfdsUtil.spliteSingleFeatureRequest(objectType,featureTypes);
        //特征对应的属性和特征对应
        Map<Field,String> featureMap = OfdsUtil.getFeatureMap(objectType,featureTypes);

        for(Map.Entry<Class<? extends BaseEntity>,ArrayList<Field>> entry:spliteSingleFeature.entrySet())
        {
            Class<? extends BaseEntity> clazz = entry.getKey();
            List<Field> features = entry.getValue();
            //查找clazz的特征，objectIds是目标主键集合
            List<? extends BaseEntity> singleFeatureResult = ofdsSystemDao.find(clazz,features,objectIds);
            for(BaseEntity entity:singleFeatureResult)
            {
                String objectId = entity.getObjectIdFieldValue();
                HashMap<String,String> featureValues = new HashMap<String,String>();
                for(Field field:features){
                    String value = entity.getFieldVlaue(field);
                    String featureName = featureMap.get(field);
                    featureValues.put(featureName,value);
                }
                result.put(objectId,featureValues);

            }



        }



        return null;
    }

    @RequestMapping(path="/insert")
    public OfdsResponse insert(){

        return null;
    }



    @RequestMapping(path="/add")
    public OfdsResponse add(){
        return null;
    }






}
