package com.ofds.server.ofdsserver.util;

import com.ofds.server.ofdsserver.entity.BaseEntity;
import com.ofds.server.ofdsserver.exception.ErrorCode;
import com.ofds.server.ofdsserver.exception.OfdsException;

import java.util.List;

public abstract class OfdsBuilder {

    /**
     * @param errorCode
     * @return
     */
    public static OfdsException createException(ErrorCode errorCode){
        return new OfdsException(errorCode);
    }


    public static <T extends BaseEntity<T>> T createSingleFeatureObject(String objectType, List<String> featureTypes){

        return null;
    }















}
