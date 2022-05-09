//package com.sin.utils;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.connection.DataType;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
///**
// * redis根据类
// */
//@Component
//public class RedisUtil {
//
//    @Autowired(required = false)
//    private RedisTemplate<String,Object> redisTemplate;
//
//    /**
//     * 判断key是否存在
//     * @param key 键
//     * @return 如果操作 key 则返回 true，否则返回false；
//     */
//    public Boolean exists(String key){
//        return redisTemplate.hasKey(key);
//    }
//
//
////     * 获取 key的类型
////     * @param key
//
//    public String type(String key){
//        DataType dataType = redisTemplate.type(key);
//        assert dataType != null;
//        return dataType.code();
//    }
//
//    /**
//     * 指定缓存失效时间
//     * @param key
//     * @param time
//     * @return
//     */
//    public boolean expire(String key,long time){
//        try {
//            if (time > 0){
//                //缓存时间单位为秒
//                redisTemplate.expire(key,time, TimeUnit.SECONDS);
//            }
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 根据key 获取过期时间
//     * @param key 键，不能为null
//     * @return 时间（秒） 返回0 代表为永久有效
//     */
//    public long getExpire(String key){
//        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
//    }
//
//    /**
//     * 判断key是否存在
//     * @param key 键
//     * @return true：存在，false：不存在
//     */
//    public boolean hasKey(String key){
//        try{
//            return redisTemplate.hasKey(key);
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 删除key
//     * @param key
//     * @return
//     */
//    public long delete(String... key){
//        if (key == null || key.length < 1){
//            return 0l;
//        }
//        return redisTemplate.delete(Arrays.asList(key));
//    }
//
//    /**
//     * 获取所有的keys
//     * @return
//     */
//    public Set<String> keys(){
//        Set<String> k = redisTemplate.keys("*");
//        return k;
//    }
//
//    /**
//     * 获取所有的keys的所有值
//     * @param keys
//     * @return
//     */
//    public HashMap<Object,Object> getKeysValue(String keys){
//        Set<String> k = redisTemplate.keys("*");
//        HashMap<Object,Object> hashMap = new HashMap<Object, Object>();
//        for(String s : k) {
//            //根据keys获取对应的值
//            Object o = redisTemplate.opsForValue().get(keys + s);
//            System.out.println("o=" + o);
//            hashMap.put(k, o);
//        }
//        return hashMap;
//    }
//
//    /**
//     * 删除缓存
//     * @param key 可以传一个值，或者多个值
//     */
//    public void del(String... key){
//        if (key != null && key.length > 0 ){
//            if (key.length == 1){
//                redisTemplate.delete(key[0]);
//            }else {
//                redisTemplate.delete((Collection<String>) CollectionUtils.arrayToList(key));
//            }
//        }
//    }
//
//    //=================================String=======================================
//
//    /**
//     * 获取普通缓存
//     * @param key
//     * @return
//     */
//    public Object get(String key){
//        return key == null ? null : redisTemplate.opsForValue().get(key);
//    }
//
//    /**
//     * 普通缓存的存放
//     * @param key
//     * @param value
//     * @return
//     */
//    public boolean set(String key,Object value){
//        try{
//            redisTemplate.opsForValue().set(key,value);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 普通缓存放入的时间进行设置
//     * @param key 键
//     * @param value 值
//     * @param time 时间（秒） time要大于0，如果timg小于等于0，将设置时间无期限
//     * @return true成功，false失败
//     */
//    public boolean set(String key,Object value,long time){
//        try{
//            if(time > 0){
//                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
//            }else {
//                set(key,value);
//            }
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 递增
//     * @param key 值
//     * @param delta 要增加的几（大于0）
//     * @return 将存储在 key下作为字符串值的整数值递增为 delta
//     */
//    public long incr(String key,long delta){
//        if (delta < 0){
//            throw new RuntimeException("递增因子必须大于0");
//        }
//
//        return redisTemplate.opsForValue().increment(key, delta);
//    }
//
//    /**
//     * 递减
//     * @param key 键
//     * @param delta 要减少的几（小于0）
//     * @return
//     */
//
//    public long decr(String key,long delta){
//        if (delta < 0){
//            throw new RuntimeException("递减因子必须大于0");
//        }
//        return redisTemplate.opsForValue().increment(key,-delta);
//    }
//
//    //=================================hash=======================================
//
//    /**
//     * hashget键项
//     * @param key 键  不能为null
//     * @param item 项 不能为null
//     * @return 值
//     */
//    public Object hget(String key,String item){
//        return redisTemplate.opsForHash().get(key,item);
//    }
//
//    /**
//     * 获取hash key对应的所有键值
//     * @param key  键
//     * @return 对应的多个键值
//     */
//    public Map<Object, Object> hmget(String key){
//        return redisTemplate.opsForHash().entries(key);
//    }
//
//    /**
//     * hast set
//     * @param key 键
//     * @param map 对应的多个键值
//     * @return true 成功，false 失败
//     */
//    public boolean hmset(String key,Map<String,Object> map){
//        try{
//            redisTemplate.opsForHash().putAll(key,map);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//
//    }
//
//    /**
//     * hash set 设置时间
//     * @param key 键
//     * @param map 对应的多个值
//     * @param time 时间（秒）
//     * @return true 成功 false 失败
//     */
//    public boolean hmset(String key,Map<String,Object> map,long time){
//        try {
//            redisTemplate.opsForHash().putAll(key,map);
//            if (time > 0){
//                expire(key,time);
//            }
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//
//    }
//
//    /**
//     * 向一张hash表中放入数据，如果不存在将他创建
//     * @param key 键
//     * @param item 项
//     * @param value 值
//     * @return true 成功，false 失败
//     */
//    public boolean hset(String key,String item ,Object value){
//        try {
//            redisTemplate.opsForHash().put(key,item,value);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 向一张hash表中放入数据，如果不存在将创建
//     * @param key 键
//     * @param item 项
//     * @param value 值
//     * @param time 时间（秒）
//     * @return true成功 false失败
//     */
//    public boolean hset(String key,String item ,Object value,long time){
//        try {
//            redisTemplate.opsForHash().put(key,item,value);
//            if (time>0){
//                expire(key,time);
//            }
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 删除hash表中的值
//     * @param key 键 不能为null
//     * @param item 项 不能为null
//     */
//    public void hdel(String key, Object... item){
//        redisTemplate.opsForHash().delete(key,item);
//    }
//
//    /**
//     * 判断hash表中的是否有该项的值
//     * @param key 键
//     * @param item 项
//     * @return true 存在 false不存在
//     */
//    public boolean hHasKey(String key,String item){
//        return redisTemplate.opsForHash().hasKey(key,item);
//    }
//
//    /**
//     * hash 递增，如果不存在，就会创建一个，并把新增的值返回
//     * @param key 键
//     * @param item 项
//     * @param by 要增加的几（大于0）
//     * @return 递增数值
//     */
//    public double hincr(String key,String item,double by){
//        return redisTemplate.opsForHash().increment(key,item,by);
//    }
//
//    /**
//     * hash 递减操作
//     * @param key 键
//     * @param item 项
//     * @param by 要减少几（小于0）
//     * @return 递减的数值
//     */
//    public double hdecr(String key,String item,double by){
//        return redisTemplate.opsForHash().increment(key,item,-by);
//    }
//    //=================================set=======================================
//
//    /**
//     * 根据key获取set中的所有值
//     * @param key 键
//     * @return
//     */
//    public Set<Object> sGet(String key) {
//        try {
//            return redisTemplate.opsForSet().members(key);
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 根据value从一个set中查找，是否存在
//     * @param key 键
//     * @param value 值
//     * @return true 存在，false不存在
//     */
//    public boolean sHasKey(String key,Object value){
//        try {
//            return redisTemplate.opsForSet().isMember(key,value);
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 将数据放入set缓存中
//     * @param key 键
//     * @param values 值（多个）
//     * @return 成功的个数
//     */
//    public long sSet(String key,Object... values){
//        try {
//            return redisTemplate.opsForSet().add(key,values);
//        }catch (Exception e){
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    /**
//     * 键数据放入set缓存中设置时间
//     * @param key  键
//     * @param time 时间（秒）
//     * @param values 值（多个）
//     * @return 成功的个数
//     */
//    public long sSetAndTime(String key,long time,Object... values){
//        try {
//            Long count = redisTemplate.opsForSet().add(key,values);
//            if (time > 0){
//                expire(key, time);
//            }
//            return count;
//        }catch (Exception e){
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    /**
//     * 获取set缓存的长度
//     * @param key 键
//     * @return 缓存长度
//     */
//    public long sGetSetSize(String key){
//        try {
//            return redisTemplate.opsForSet().size(key);
//        }catch (Exception e){
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    /**
//     * 移除值为values的
//     * @param key 键
//     * @param values 值
//     * @return 移除的个数
//     */
//    public long setRemove(String key,Object... values){
//        try {
//            return redisTemplate.opsForSet().remove(key,values);
//        }catch (Exception e){
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    //=================================list=======================================
//
//    /**
//     * 获取list缓存的内容
//     * @param key 键
//     * @param start 开始
//     * @param end 结束0到-1表示所有值
//     * @return
//     */
//    public List<Object> lGet(String key, long start, long end){
//        try {
//            return redisTemplate.opsForList().range(key,start,end);
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 获取list缓存的内容
//     * @param key 键
//     * @param start 开始
//     * @param end 结束0到-1表示所有值
//     * @return
//     */
//    public List<Object> getList(String key, long start, long end){
//        try {
//            return redisTemplate.opsForList().range(key,start,end);
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 获取list缓存的长度
//     * @param key 键
//     * @return 从0开始
//     */
//    public long lGetListSize(String key){
//        try {
//            return redisTemplate.opsForList().size(key);
//        }catch (Exception e){
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    /**
//     * 通过索引 获取list中的值
//     * @param key 键
//     * @param index 索引 index>=0时，0：表头，1：第二个元素，以此类推，index<0时，-1：表尾，-2:倒数第二个元素，以此类推
//     * @return
//     */
//    public Object lGetIndex(String key,long index){
//        try {
//            return redisTemplate.opsForList().index(key,index);
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 将list放入缓存中
//     * @param key 键
//     * @param value 值
//     * @return
//     */
//    public boolean lSet(String key,Object value){
//        try {
//            redisTemplate.opsForList().rightPush(key,value);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 将list放入缓存加入时间
//     * @param key 键
//     * @param value 值
//     * @param time 时间（秒）
//     * @return
//     */
//    public boolean lSet(String key,Object value,long time){
//        try {
//            redisTemplate.opsForList().rightPush(key,value);
//            if (time >0){
//                expire(key,time);
//            }
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 将list放入缓存
//     * @param key 键
//     * @param value 值
//     * @return
//     */
//    public boolean lSet(String key,List<Object> value){
//        try {
//            redisTemplate.opsForList().rightPushAll(key,value);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 将list放入缓存加入时间
//     * @param key 键
//     * @param value 值
//     * @param time 时间（秒）
//     * @return
//     */
//    public boolean lSet(String key,List<Object> value,long time){
//        try {
//            redisTemplate.opsForList().rightPushAll(key,value);
//            if (time> 0){
//                expire(key,time);
//            }
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 根据索引修改list中的数据
//     * @param key 键
//     * @param index 索引
//     * @param value 值
//     * @return
//     */
//    public boolean lUpdateIndex(String key,long index,Object value){
//        try {
//            redisTemplate.opsForList().set(key,index,value);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * 移除n个值为value
//     * @param key 键
//     * @param count 移除多少个
//     * @param value 值
//     * @return 记录移除的个数
//     */
//    public long lRemove(String key,long count,Object value){
//        try {
//            Long remove = redisTemplate.opsForList().remove(key, count, value);
//            return remove;
//        }catch (Exception e){
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//}