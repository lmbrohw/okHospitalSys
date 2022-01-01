package com.fightlandlord.sys_back.util;


import java.util.UUID;

public class UUIDGenerator {
    /**
    * @Author: hudongyue
    * @Description: 生成带有前缀的uuid作为主键
    * @DateTime: 2022/1/1 22:12
    * @Params: 
    * @Return 
    */
    public static String makeUUID(String prefix) {
        return prefix + UUID.randomUUID().toString();
    }
}