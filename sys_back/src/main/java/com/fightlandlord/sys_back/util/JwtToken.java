package com.fightlandlord.sys_back.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.*;

public class JwtToken {
    // private static UserService userService=new UserService();
    private static final long EXPIRE_TIME=60*60*1000*24*7; //过期时间7天
    private static final String KEY = "huterox"; //加密秘钥

    /**
     * 生成token
     * 由于只有当账号密码正确之后才会生成token所以这边只需要用户名进行识别
     * @param userName  用户名
     * @return
     */
    public static String createToken(String userName){
        Map<String,Object> header = new HashMap();
        header.put("typ","JWT");
        header.put("alg","HS256");
        JwtBuilder builder = Jwts.builder().setHeader(header)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE_TIME))
                .setSubject(userName)//设置信息，也就是用户名
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,KEY);//加密方式
        return builder.compact();
    }

    /**
     * 验证token是否有效
     * @param token  请求头中携带的token
     * @return  token验证结果  2-token过期；1-token认证通过；0-token认证失败
     */
    public static int verify(String token){
        Claims claims = null;
        try {
            //token过期后，会抛出ExpiredJwtException 异常，通过这个来判定token过期，
            claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        }catch (ExpiredJwtException e){
            return 2;
        }
        //从token中获取用户名，当用户查询通过后即可
        String username = claims.getSubject();
//        if(LoginRouterController.auth(username)) return 1;

        return 1;
    }
}
