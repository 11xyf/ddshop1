package com.xyf.ddshop.jedis;

/**
 * User: Administrator
 * Date: 2017/11/20
 * Time: 16:34
 * Version:V1.0
 */
public class JedisTest {

    //普通方法,使用Jedis
   /* @Test
    public void testJedis1(){
        Jedis jedis = new Jedis("10.31.161.47",6379);
        jedis.set("name","zs");
        System.out.println(jedis.get("name"));
        jedis.close();
    }

    //连接池方法,使用JedisPool
    @Test
    public void testJedis2(){
        JedisPool jedisPool = new JedisPool("10.31.161.47", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("key","name");
        System.out.println(jedis.get("key"));
        jedis.close();
        jedisPool.close();
    }

    //利用集群存入数据
    @Test
    public void testmJedis3(){
        //创建集群节点集合
        Set<HostAndPort> set=new HashSet<HostAndPort>();
        //将6个节点加入到集合中
        set.add(new HostAndPort("10.31.161.47",9001));
        set.add(new HostAndPort("10.31.161.47",9002));
        set.add(new HostAndPort("10.31.161.47",9003));
        set.add(new HostAndPort("10.31.161.47",9004));
        set.add(new HostAndPort("10.31.161.47",9005));
        set.add(new HostAndPort("10.31.161.47",9006));
        //创建集群对象
        JedisCluster jedisCluster = new JedisCluster(set);
        //存入数据
        jedisCluster.set("key1","夏云飞");
        jedisCluster.hset("content_list","123456","{'key1':'xyf'}");
        System.out.println(jedisCluster.get("key1"));
        //关闭连接
        jedisCluster.close();
    }*/
}
