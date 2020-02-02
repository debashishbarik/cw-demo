package com.debashish.spring.cosmosdb.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DeepCopyUtils {

    /**
     * Applicable for Similar objects
     *
     * @param fromValue
     * @param toValueType
     * @param <T>
     * @return
     */
    public static <T> T copyProperties(Object fromValue, Class<T> toValueType) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(fromValue, toValueType);
    }


    public static <T, E> List<T> copyListOfObjects(List<E> fromList, Class<T> toValueType) {

        List<T> toList = fromList.stream().map(fromType ->
                {
                    T t = DeepCopyUtils.copyProperties(fromType, toValueType);
                    return t;
                }
        ).collect(Collectors.toList());
        return toList;
    }
}
