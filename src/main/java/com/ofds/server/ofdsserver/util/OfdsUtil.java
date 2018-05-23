package com.ofds.server.ofdsserver.util;

import com.ofds.server.ofdsserver.entity.BaseEntity;
import com.ofds.server.ofdsserver.exception.OfdsException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OfdsUtil {
    public static void checkFindRequest(String objectType, String[] featureTypes) {
    }



    public static List<Class<?>> spliteMulptiFeatureRequest(String objectType, String[] featureTypes) {







        return null;
    }

    public static Map<Class<? extends BaseEntity>, ArrayList<Field>> spliteSingleFeatureRequest(String objectType, String[] featureTypes) throws OfdsException {
        Map<Class<?>,ArrayList<Field>> features = new HashMap<Class<?>,ArrayList<Field>>();

        for(String featureType:featureTypes){
            Class<? extends BaseEntity> clazz = BaseEntity.getFeatureClass(objectType,featureType);
            Field field = BaseEntity.getFeatureField(objectType,featureType);
            ArrayList<Field> fields = features.get(clazz);
            if(fields == null){
                fields = new ArrayList<Field>();
            }
            fields.add(field);
            features.put(clazz,fields);
        }

        return null;
    }

    public static void checkSingleFeatureRequest(String objectType, String[] featureTypes) {
    }

    public static Map<Field,String> getFeatureMap(String objectType, String[] featureTypes) throws OfdsException {
        Map<Field,String> fieldMap = new HashMap<Field, String>();
        for(String featureType:featureTypes){
            Field field = BaseEntity.getFeatureField(objectType,featureType);
            fieldMap.put(field ,featureType);
        }
        return fieldMap;
    }
}








