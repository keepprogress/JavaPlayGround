package com.nick.playground.mainmethods;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.nick.playground.vo.StoreChineseVO;

public class TestJSONString {

    public static void main(String[] args) {
        StoreChineseVO storeChineseVO = new StoreChineseVO();
        storeChineseVO.setMessage("測試中文");
        String jsonString = JSON.toJSONString(storeChineseVO, SerializerFeature.WriteMapNullValue,SerializerFeature.BrowserCompatible);

        System.out.println(jsonString);
    }
}
