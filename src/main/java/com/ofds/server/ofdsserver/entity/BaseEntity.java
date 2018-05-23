package com.ofds.server.ofdsserver.entity;

import com.ofds.server.ofdsserver.exception.ErrorCode;
import com.ofds.server.ofdsserver.util.OfdsBuilder;
import com.ofds.server.ofdsserver.exception.OfdsException;
import com.ofds.server.ofdsserver.util.FeatureType;
import com.ofds.server.ofdsserver.util.OFDSFeatureType;
import com.ofds.server.ofdsserver.util.OFDSObjectType;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseEntity<T extends BaseEntity<T>> implements Serializable {

    /**
     * Entity：是否已经初始化
     */
    private static final Map<Class<?>,Boolean> featureStatu = new ConcurrentHashMap<Class<?>,Boolean>();

    /**
     * 对象名字:{ 特征名字：Entity类}
     */
    private static final Map<String,HashMap<String,Class<? extends BaseEntity>>> featureEntity = new ConcurrentHashMap<String,HashMap<String,Class<? extends BaseEntity>>>();

    /**
     * 对象名字:{特征名字：Single类型还是Mulpti类型}
     */
    private static final Map<String,HashMap<String,FeatureType>> featureTypes = new ConcurrentHashMap<String,HashMap<String,FeatureType>>();

    /**
     * 对象名字:{ 特征名字 ： Field }
     */
    private static final Map<String,HashMap<String,Field>> featureFields = new ConcurrentHashMap<String,HashMap<String,Field>>();


    public BaseEntity()
    {
        if(!featureStatu.get(this.getClass())) {
            try {
                registerEntity(this.getClass());
                featureStatu.put(this.getClass(), Boolean.TRUE);
            } catch (OfdsException e) {
                System.out.println(e.toString());
                System.exit(-1);
            }
        }
    }

    /**
     * 根据对象名和特征名字获取对应的class对象
     */
    public static Class<? extends BaseEntity> getFeatureClass(String objectType, String featureType) throws OfdsException {
        if(null == featureEntity.get(objectType) || null == featureEntity.get(objectType).get(featureType)  ){
            throw OfdsBuilder.createException(ErrorCode.ENTITY_ERROR);
        }
        return  featureEntity.get(objectType).get(featureType);
    }
    /**
     * 根据对象名和特征名字获取对应的属性
     */
    public static Field getFeatureField(String objectType, String featureType) throws OfdsException {
        if(null == featureFields.get(objectType) || null == featureFields.get(objectType).get(featureType)  ){
            throw OfdsBuilder.createException(ErrorCode.ENTITY_ERROR);
        }
        return  featureFields.get(objectType).get(featureType);
    }


    private  void registerEntity(Class<? extends BaseEntity> clazz) throws OfdsException {
        checkEntity(clazz);
        //获取对象名
        String objectType = getObjectTypeName(clazz);
        //判断类型:是否是Single类型
        if(isSingleEntity(clazz)){
            Field[] fields = clazz.getFields();
            for(Field field:fields) {
                OFDSFeatureType ofdsFeatureType = field.getAnnotation(OFDSFeatureType.class);
                if(ofdsFeatureType.value()!=null) {
                    initFeatureEntity(objectType, ofdsFeatureType.value(), clazz);
                    initFeatureType(objectType,ofdsFeatureType.value(),FeatureType.SINGLE);
                    initFeatureField(objectType,ofdsFeatureType.value(),field);
                }
            }
        } else{
            OFDSFeatureType ofdsFeatureType = clazz.getAnnotation(OFDSFeatureType.class);
            String featureType = ofdsFeatureType.value();
            initFeatureEntity(objectType,featureType,clazz);
            initFeatureType(objectType,featureType,FeatureType.MULPTI);
        }
    }

    /**
     * 初始化FeatureTypes
     * @param objectType
     * @param ofdsFeatureType
     * @param field
     * @param <V>
     */
    private <V> void initFeatureField(String objectType, String ofdsFeatureType, Field field) {
        HashMap<String,Field> tempMap = featureFields.get(objectType);
        if(tempMap == null){
            tempMap = new HashMap<String,Field>();
        }
        tempMap.put(ofdsFeatureType.toUpperCase(),field);
        featureFields.put(objectType.toUpperCase(),tempMap);
    }

    /**
     *  初始化FeatureTypes
     * @param objectType
     * @param ofdsFeatureType
     * @param feature
     */
    private void initFeatureType(String objectType, String ofdsFeatureType, FeatureType feature) {
        HashMap<String,FeatureType> tempMap = featureTypes.get(objectType);
        if(tempMap == null){
            tempMap = new HashMap<String,FeatureType>();
        }
        tempMap.put(ofdsFeatureType.toUpperCase(),feature);
        featureTypes.put(objectType.toUpperCase(),tempMap);
    }

    /**
     * 初始化FeatureEntity
     * @param objectType
     * @param ofdsFeatureType
     * @param clazz
     * @param
     */
    private  void initFeatureEntity(String objectType, String ofdsFeatureType, Class<? extends BaseEntity> clazz)
    {
        HashMap<String,Class<? extends BaseEntity>> tempMap = featureEntity.get(objectType);
        if(tempMap == null){
            tempMap = new HashMap<String,Class<? extends BaseEntity>>();
        }
        tempMap.put(ofdsFeatureType.toUpperCase(),clazz);
        featureEntity.put(objectType.toUpperCase(),tempMap);
    }

    /**
     * 是否是Single模式
     * @param clazz
     * @param <V>
     * @return
     */
    private <V> boolean isSingleEntity(Class<V> clazz)
    {
        OFDSFeatureType ofdsFeatureType = clazz.getAnnotation(OFDSFeatureType.class);
        if(ofdsFeatureType == null){
            return Boolean.TRUE;
        } else{
            return Boolean.FALSE;
        }
    }


    /**
     * 校验Entity
     * @param clazz
     * @param <V>
     */
    private <V> void checkEntity(Class<V> clazz) throws OfdsException {
        OFDSObjectType ofdsObjectType = clazz.getAnnotation(OFDSObjectType.class);
        Entity entity = clazz.getAnnotation(Entity.class);
        Table table = clazz.getAnnotation(Table.class);
        if(entity==null || ofdsObjectType==null || table==null){
            throw new OfdsException(ErrorCode.ENTITY_ERROR);
        }
    }

    /**
     * 获取对象名
     * @param clazz
     * @param <V>
     * @return
     */
    private <V> String getObjectTypeName(Class<V> clazz) throws OfdsException {
        OFDSObjectType ofdsObjectType = clazz.getAnnotation(OFDSObjectType.class);
        if(ofdsObjectType == null) {
            throw OfdsBuilder.createException(ErrorCode.ENTITY_ERROR);
        }
        return ofdsObjectType.value();
    }


    public String getObjectIdFieldValue() throws OfdsException {
        try {
            Field field = this.getClass().getField("objectId");
            if(!field.isAccessible())
            {
                field.setAccessible(true);
            }
            return (String)field.get(this);
        } catch (IllegalAccessException e) {
            throw OfdsBuilder.createException(ErrorCode.ENTITY_NO_OBJECTID_ERROR);
        } catch (NoSuchFieldException e) {
            throw OfdsBuilder.createException(ErrorCode.ENTITY_NO_OBJECTID_ERROR);
        }
    }

    public String getFieldVlaue(Field field) throws OfdsException {
        try {
            if(!field.isAccessible())
            {
                field.setAccessible(true);
            }
            return (String)field.get(this);
        } catch (IllegalAccessException e) {
            throw OfdsBuilder.createException(ErrorCode.ENTITY_NO_OBJECTID_ERROR);
        }
    }
}
