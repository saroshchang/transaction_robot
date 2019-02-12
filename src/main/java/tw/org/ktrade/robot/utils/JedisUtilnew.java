package tw.org.ktrade.robot.utils;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.etchain.model.infoormation.MarketInfo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.SortingParams;
import redis.clients.util.SafeEncoder;

/**
 * Redis工具類
 * Created by caicf on 2017/1/1.
 */
@Component
public class JedisUtilnew {

    private static final Logger log = LoggerFactory.getLogger(JedisUtilnew.class);

    //默認緩存時間
    private static final int EXPIRE = 60000;

    private static Properties properties;

    private static JedisUtilnew instance;

    private static JedisPool jedisPool;

    private static ReentrantLock lock = new ReentrantLock();

    private JedisUtilnew() {
    }

    public static JedisUtilnew getInstance() {
        if (instance == null) {
            lock.lock();
                if (instance == null) {
                    instance = new JedisUtilnew();
                }
            lock.unlock();
        }
        return instance;
    }


    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;
    /**
     * 初始化JedisPool
     */
    private void initJedisPool() {
//        properties = ConfigHelper.loadProperties("config.properties");
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(500);
        config.setTestOnBorrow(false);
        config.setTestOnReturn(false);
//        jedisPool = new JedisPool(
//                config,
//                "47.74.18.69",6379
//        );
        jedisPool = new JedisPool(config, host,port, timeout,password);
    }

    /**
     * 通用方法：從JedisPool中獲取Jedis
     *
     * @return
     */
    private Jedis getJedis() {
        if (jedisPool == null) {
            lock.lock();    //防止吃初始化時多線程競爭問題
            initJedisPool();
            lock.unlock();
            log.info("JedisPool init success！");
        }
        return jedisPool.getResource();
    }

    /**
     * 通用方法：釋放Jedis
     *
     * @param jedis
     */
    private void closeJedis(Jedis jedis) {
        jedis.close();
    }

//===========================================================
    /**
     * 對Keys,以及存儲結構為String、List、Set、HashMap類型的操作
     */
    private final Keys keys = new Keys();
    private final Strings strings = new Strings();
    private final Lists lists = new Lists();
    private final Sets sets = new Sets();
    private final Hash hash = new Hash();
    private final SortSet sortset = new SortSet();

    public Keys keys() {
        return keys;
    }

    public Strings strings() {
        return strings;
    }

    public Lists lists() {
        return lists;
    }

    public Sets sets() {
        return sets;
    }

    public Hash hash() {
        return hash;
    }

    public SortSet sortSet() {
        return sortset;
    }
    //===========================================================

    //*******************************************Keys*******************************************//  
    public class Keys {

        /**
         * 設置過期時間
         *
         * @param key
         * @param seconds
         * @return 返回影響的記錄數
         */
        public long expire(String key, int seconds) {
            if (seconds <= 0) {
                return -1L;
            }
            Jedis jedis = getJedis();
            long result = jedis.expire(key, seconds);
            closeJedis(jedis);
            return result;
        }

        /**
         * 設置過期時間，默認值為60000seconds
         *
         * @param key
         */
        public long expire(String key) {
            return expire(key, EXPIRE);
        }

        /**
         * 設置key的過期時間,它是距歷元（即格林威治標準時間 1970 年 1 月 1 日的 00:00:00，格裏高利歷）的偏移量。
         *
         * @param key
         * @param timestamp 秒
         * @return 影響的記錄數
         */
        public long expireAt(String key, long timestamp) {
            Jedis jedis = getJedis();
            long count = jedis.expireAt(key, timestamp);
            closeJedis(jedis);
            return count;
        }

        /**
         * 查詢key的過期時間
         *
         * @param key
         * @return 以秒為單位的時間表示
         */
        public long ttl(String key) {
            //ShardedJedis sjedis = getShardedJedis();
            Jedis sjedis = getJedis();
            long len = sjedis.ttl(key);
            closeJedis(sjedis);
            return len;
        }

        /**
         * 取消對key過期時間的設置
         *
         * @param key
         * @return 影響的記錄數
         */
        public long persist(String key) {
            Jedis jedis = getJedis();
            long count = jedis.persist(key);
            closeJedis(jedis);
            return count;
        }

        /**
         * 清空所有key
         *
         * @return
         */
        public String flushAll() {
            Jedis jedis = getJedis();
            String stata = jedis.flushAll();
            closeJedis(jedis);
            return stata;
        }

        /**
         * 判斷key是否存在
         *
         * @param key
         * @return boolean
         */
        public boolean exists(String key) {
            Jedis sjedis = getJedis();
            boolean exis = sjedis.exists(key);
            closeJedis(sjedis);
            return exis;
        }

        /**
         * 更改key
         */
        public String rename(String oldKey, String newKey) {
            return rename(SafeEncoder.encode(oldKey),
                    SafeEncoder.encode(newKey));
        }

        /**
         * 更改key,僅當新key不存在時才執行
         *
         * @param oldKey
         * @param newKey
         * @return 狀態碼
         */
        public long renamenx(String oldKey, String newKey) {
            Jedis jedis = getJedis();
            long status = jedis.renamenx(oldKey, newKey);
            closeJedis(jedis);
            return status;
        }

        /**
         * 更改key
         */
        public String rename(byte[] oldKey, byte[] newKey) {
            Jedis jedis = getJedis();
            String status = jedis.rename(oldKey, newKey);
            closeJedis(jedis);
            return status;
        }


        /**
         * 刪除keys對應的記錄,可以是多個key
         *
         * @param keys
         * @return 刪除的記錄數
         */
        public long del(String... keys) {
            Jedis jedis = getJedis();
            long count = jedis.del(keys);
            closeJedis(jedis);
            return count;
        }

        /**
         * 刪除keys對應的記錄,可以是多個key
         *
         * @param keys
         * @return 刪除的記錄數
         */
        public long del(byte[]... keys) {
            Jedis jedis = getJedis();
            long count = jedis.del(keys);
            closeJedis(jedis);
            return count;
        }


        /**
         * 對List,Set,SortSet進行排序,如果集合數據較大應避免使用這個方法
         *
         * @param key
         * @return List<String> 集合的全部記錄
         **/
        public List<String> sort(String key) {
            Jedis sjedis = getJedis();
            List<String> list = sjedis.sort(key);
            closeJedis(sjedis);
            return list;
        }

        /**
         * 對List,Set,SortSet進行排序或limit
         *
         * @param key
         * @param parame 定義排序類型或limit的起止位置.
         * @return List<String> 全部或部分記錄
         **/
        public List<String> sort(String key, SortingParams parame) {
            Jedis jedis = getJedis();
            List<String> list = jedis.sort(key, parame);
            closeJedis(jedis);
            return list;
        }

        /**
         * 返回指定key存儲的類型
         *
         * @param key
         * @return String string|list|set|zset|hash
         **/
        public String type(String key) {
            Jedis sjedis = getJedis();
            String type = sjedis.type(key);
            closeJedis(sjedis);
            return type;
        }

        /**
         * 查找所有匹配給定的模式的鍵
         *
         * @param pattern 的表達式,*表示多個，？表示一個
         */
        public Set<String> keys(String pattern) {
            Jedis jedis = getJedis();
            Set<String> set = jedis.keys(pattern);
            closeJedis(jedis);
            return set;
        }
    }

    //*******************************************Sets*******************************************//  
    public class Sets {

        /**
         * 向Set添加一條記錄，如果member已存在返回0,否則返回1
         *
         * @param key
         * @param member
         * @return 操作碼, 0或1
         */
        public long sadd(String key, String member) {
            Jedis jedis = getJedis();
            long s = jedis.sadd(key, member);
            closeJedis(jedis);
            return s;
        }

        public long sadd(byte[] key, byte[] member) {
            Jedis jedis = getJedis();
            long s = jedis.sadd(key, member);
            closeJedis(jedis);
            return s;
        }

        /**
         * 獲取給定key中元素個數
         *
         * @param key
         * @return 元素個數
         */
        public long scard(String key) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            long len = sjedis.scard(key);
            closeJedis(sjedis);
            return len;
        }

        /**
         * 返回從第一組和所有的給定集合之間的差異的成員
         *
         * @param keys
         * @return 差異的成員集合
         */
        public Set<String> sdiff(String... keys) {
            Jedis jedis = getJedis();
            Set<String> set = jedis.sdiff(keys);
            closeJedis(jedis);
            return set;
        }

        /**
         * 這個命令等於sdiff,但返回的不是結果集,而是將結果集存儲在新的集合中，如果目標已存在，則覆蓋。
         *
         * @param newKey 新結果集的key
         * @param keys   比較的集合
         * @return 新集合中的記錄數
         **/
        public long sdiffstore(String newKey, String... keys) {
            Jedis jedis = getJedis();
            long s = jedis.sdiffstore(newKey, keys);
            closeJedis(jedis);
            return s;
        }

        /**
         * 返回給定集合交集的成員,如果其中一個集合為不存在或為空，則返回空Set
         *
         * @param keys
         * @return 交集成員的集合
         **/
        public Set<String> sinter(String... keys) {
            Jedis jedis = getJedis();
            Set<String> set = jedis.sinter(keys);
            closeJedis(jedis);
            return set;
        }

        /**
         * 這個命令等於sinter,但返回的不是結果集,而是將結果集存儲在新的集合中，如果目標已存在，則覆蓋。
         *
         * @param newKey 新結果集的key
         * @param keys   比較的集合
         * @return 新集合中的記錄數
         **/
        public long sinterstore(String newKey, String... keys) {
            Jedis jedis = getJedis();
            long s = jedis.sinterstore(newKey, keys);
            closeJedis(jedis);
            return s;
        }

        /**
         * 確定一個給定的值是否存在
         *
         * @param key
         * @param member 要判斷的值
         * @return 存在返回1，不存在返回0
         **/
        public boolean sismember(String key, String member) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            boolean s = sjedis.sismember(key, member);
            closeJedis(sjedis);
            return s;
        }

        /**
         * 返回集合中的所有成員
         *
         * @param key
         * @return 成員集合
         */
        public Set<String> smembers(String key) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            Set<String> set = sjedis.smembers(key);
            closeJedis(sjedis);
            return set;
        }

        public Set<byte[]> smembers(byte[] key) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            Set<byte[]> set = sjedis.smembers(key);
            closeJedis(sjedis);
            return set;
        }

        /**
         * 將成員從源集合移出放入目標集合 <br/>
         * 如果源集合不存在或不包哈指定成員，不進行任何操作，返回0<br/>
         * 否則該成員從源集合上刪除，並添加到目標集合，如果目標集合中成員已存在，則只在源集合進行刪除
         *
         * @param srckey 源集合
         * @param dstkey 目標集合
         * @param member 源集合中的成員
         * @return 狀態碼，1成功，0失敗
         */
        public long smove(String srckey, String dstkey, String member) {
            Jedis jedis = getJedis();
            long s = jedis.smove(srckey, dstkey, member);
            closeJedis(jedis);
            return s;
        }

        /**
         * 從集合中刪除成員
         *
         * @param key
         * @return 被刪除的成員
         */
        public String spop(String key) {
            Jedis jedis = getJedis();
            String s = jedis.spop(key);
            closeJedis(jedis);
            return s;
        }

        /**
         * 從集合中刪除指定成員
         *
         * @param key
         * @param member 要刪除的成員
         * @return 狀態碼，成功返回1，成員不存在返回0
         */
        public long srem(String key, String member) {
            Jedis jedis = getJedis();
            long s = jedis.srem(key, member);
            closeJedis(jedis);
            return s;
        }

        /**
         * 合並多個集合並返回合並後的結果，合並後的結果集合並不保存<br/>
         *
         * @param keys
         * @return 合並後的結果集合
         */
        public Set<String> sunion(String... keys) {
            Jedis jedis = getJedis();
            Set<String> set = jedis.sunion(keys);
            closeJedis(jedis);
            return set;
        }

        /**
         * 合並多個集合並將合並後的結果集保存在指定的新集合中，如果新集合已經存在則覆蓋
         *
         * @param newKey 新集合的key
         * @param keys   要合並的集合
         **/
        public long sunionstore(String newKey, String... keys) {
            Jedis jedis = getJedis();
            long s = jedis.sunionstore(newKey, keys);
            closeJedis(jedis);
            return s;
        }
    }

    //*******************************************SortSet*******************************************//  
    public class SortSet {

        /**
         * 向集合中增加一條記錄,如果這個值已存在，這個值對應的權重將被置為新的權重
         *
         * @param key
         * @param score  權重
         * @param member 要加入的值，
         * @return 狀態碼 1成功，0已存在member的值
         */
        public long zadd(String key, double score, String member) {
            Jedis jedis = getJedis();
            long s = jedis.zadd(key, score, member);
            closeJedis(jedis);
            return s;
        }

        /**
         * 獲取集合中元素的數量
         *
         * @param key
         * @return 如果返回0則集合不存在
         */
        public long zcard(String key) {
            Jedis sjedis = getJedis();
            long len = sjedis.zcard(key);
            closeJedis(sjedis);
            return len;
        }

        /**
         * 獲取指定權重區間內集合的數量
         *
         * @param key
         * @param min 最小排序位置
         * @param max 最大排序位置
         */
        public long zcount(String key, double min, double max) {
            Jedis sjedis = getJedis();
            long len = sjedis.zcount(key, min, max);
            closeJedis(sjedis);
            return len;
        }

        /**
         * 獲得set的長度
         *
         * @param key
         * @return
         */
        public long zlength(String key) {
            long len = 0;
            Set<String> set = zrange(key, 0, -1);
            len = set.size();
            return len;
        }

        /**
         * 權重增加給定值，如果給定的member已存在
         *
         * @param key
         * @param score  要增的權重
         * @param member 要插入的值
         * @return 增後的權重
         */
        public double zincrby(String key, double score, String member) {
            Jedis jedis = getJedis();
            double s = jedis.zincrby(key, score, member);
            closeJedis(jedis);
            return s;
        }

        /**
         * 返回指定位置的集合元素,0為第一個元素，-1為最後一個元素
         *
         * @param key
         * @param start 開始位置(包含)
         * @param end   結束位置(包含)
         * @return Set<String>
         */
        public Set<String> zrange(String key, int start, int end) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            Set<String> set = sjedis.zrange(key, start, end);
            closeJedis(sjedis);
            return set;
        }

        /**
         * 返回指定權重區間的元素集合
         *
         * @param key
         * @param min 上限權重
         * @param max 下限權重
         * @return Set<String>
         */
        public Set<String> zrangeByScore(String key, double min, double max) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            Set<String> set = sjedis.zrangeByScore(key, min, max);
            closeJedis(sjedis);
            return set;
        }

        /**
         * 獲取指定值在集合中的位置，集合排序從低到高
         *
         * @param key
         * @param member
         * @return long 位置
         */
        public long zrank(String key, String member) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            long index = sjedis.zrank(key, member);
            closeJedis(sjedis);
            return index;
        }

        /**
         * 獲取指定值在集合中的位置，集合排序從高到低
         *
         * @param key
         * @param member
         * @return long 位置
         */
        public long zrevrank(String key, String member) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            long index = sjedis.zrevrank(key, member);
            closeJedis(sjedis);
            return index;
        }

        /**
         * 從集合中刪除成員
         *
         * @param key
         * @param member
         * @return 返回1成功
         */
        public long zrem(String key, String member) {
            Jedis jedis = getJedis();
            long s = jedis.zrem(key, member);
            closeJedis(jedis);
            return s;
        }

        /**
         * 刪除
         *
         * @param key
         * @return
         */
        public long zrem(String key) {
            Jedis jedis = getJedis();
            long s = jedis.del(key);
            closeJedis(jedis);
            return s;
        }

        /**
         * 刪除給定位置區間的元素
         *
         * @param key
         * @param start 開始區間，從0開始(包含)
         * @param end   結束區間,-1為最後一個元素(包含)
         * @return 刪除的數量
         */
        public long zremrangeByRank(String key, int start, int end) {
            Jedis jedis = getJedis();
            long s = jedis.zremrangeByRank(key, start, end);
            closeJedis(jedis);
            return s;
        }

        /**
         * 刪除給定權重區間的元素
         *
         * @param key
         * @param min 下限權重(包含)
         * @param max 上限權重(包含)
         * @return 刪除的數量
         */
        public long zremrangeByScore(String key, double min, double max) {
            Jedis jedis = getJedis();
            long s = jedis.zremrangeByScore(key, min, max);
            closeJedis(jedis);
            return s;
        }

        /**
         * 獲取給定區間的元素，原始按照權重由高到低排序
         *
         * @param key
         * @param start
         * @param end
         * @return Set<String>
         */
        public Set<String> zrevrange(String key, int start, int end) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            Set<String> set = sjedis.zrevrange(key, start, end);
            closeJedis(sjedis);
            return set;
        }

        /**
         * 獲取給定值在集合中的權重
         *
         * @param key
         * @param memebr
         * @return double 權重
         */
        public double zscore(String key, String memebr) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            Double score = sjedis.zscore(key, memebr);
            closeJedis(sjedis);
            if (score != null)
                return score;
            return 0;
        }
    }

    //*******************************************Hash*******************************************//  
    public class Hash {

        /**
         * 從hash中刪除指定的存儲
         *
         * @param key
         * @param fieid 存儲的名字
         * @return 狀態碼，1成功，0失敗
         */
        public long hdel(String key, String fieid) {
            Jedis jedis = getJedis();
            long s = jedis.hdel(key, fieid);
            closeJedis(jedis);
            return s;
        }

        public long hdel(String key) {
            Jedis jedis = getJedis();
            long s = jedis.del(key);
            closeJedis(jedis);
            return s;
        }

        /**
         * 測試hash中指定的存儲是否存在
         *
         * @param key
         * @param fieid 存儲的名字
         * @return 1存在，0不存在
         */
        public boolean hexists(String key, String fieid) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            boolean s = sjedis.hexists(key, fieid);
            closeJedis(sjedis);
            return s;
        }

        /**
         * 返回hash中指定存儲位置的值
         *
         * @param key
         * @param fieid 存儲的名字
         * @return 存儲對應的值
         */
        public String hget(String key, String fieid) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            String s = sjedis.hget(key, fieid);
            closeJedis(sjedis);
            return s;
        }

        public byte[] hget(byte[] key, byte[] fieid) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            byte[] s = sjedis.hget(key, fieid);
            closeJedis(sjedis);
            return s;
        }

        /**
         * 以Map的形式返回hash中的存儲和值
         *
         * @param key
         * @return Map<Strinig,String>
         */
        public Map<String, String> hgetAll(String key) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            Map<String, String> map = sjedis.hgetAll(key);
            closeJedis(sjedis);
            return map;
        }

        /**
         * 添加一個對應關系
         *
         * @param key
         * @param fieid
         * @param value
         * @return 狀態碼 1成功，0失敗，fieid已存在將更新，也返回0
         **/
        public long hset(String key, String fieid, String value) {
            Jedis jedis = getJedis();
            long s = jedis.hset(key, fieid, value);
            closeJedis(jedis);
            return s;
        }

        public long hset(String key, String fieid, byte[] value) {
            Jedis jedis = getJedis();
            long s = jedis.hset(key.getBytes(), fieid.getBytes(), value);
            closeJedis(jedis);
            return s;
        }

        /**
         * 添加對應關系，只有在fieid不存在時才執行
         *
         * @param key
         * @param fieid
         * @param value
         * @return 狀態碼 1成功，0失敗fieid已存
         **/
        public long hsetnx(String key, String fieid, String value) {
            Jedis jedis = getJedis();
            long s = jedis.hsetnx(key, fieid, value);
            closeJedis(jedis);
            return s;
        }

        /**
         * 獲取hash中value的集合
         *
         * @param key
         * @return List<String>
         */
        public List<String> hvals(String key) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            List<String> list = sjedis.hvals(key);
            closeJedis(sjedis);
            return list;
        }

        /**
         * 在指定的存儲位置加上指定的數字，存儲位置的值必須可轉為數字類型
         *
         * @param key
         * @param fieid 存儲位置
         * @param value 要增加的值,可以是負數
         * @return 增加指定數字後，存儲位置的值
         */
        public long hincrby(String key, String fieid, long value) {
            Jedis jedis = getJedis();
            long s = jedis.hincrBy(key, fieid, value);
            closeJedis(jedis);
            return s;
        }

        /**
         * 返回指定hash中的所有存儲名字,類似Map中的keySet方法
         *
         * @param key
         * @return Set<String> 存儲名稱的集合
         */
        public Set<String> hkeys(String key) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            Set<String> set = sjedis.hkeys(key);
            closeJedis(sjedis);
            return set;
        }

        /**
         * 獲取hash中存儲的個數，類似Map中size方法
         *
         * @param key
         * @return long 存儲的個數
         */
        public long hlen(String key) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            long len = sjedis.hlen(key);
            closeJedis(sjedis);
            return len;
        }

        /**
         * 根據多個key，獲取對應的value，返回List,如果指定的key不存在,List對應位置為null
         *
         * @param key
         * @param fieids 存儲位置
         * @return List<String>
         */
        public List<String> hmget(String key, String... fieids) {
            Jedis sjedis = getJedis();
            List<String> list = sjedis.hmget(key, fieids);
            closeJedis(sjedis);
            return list;
        }

        public List<byte[]> hmget(byte[] key, byte[]... fieids) {
            Jedis sjedis = getJedis();
            List<byte[]> list = sjedis.hmget(key, fieids);
            closeJedis(sjedis);
            return list;
        }

        /**
         * 添加對應關系，如果對應關系已存在，則覆蓋
         *
         * @param key
         * @param map 對應關系
         * @return 狀態，成功返回OK
         */
        public String hmset(String key, Map<String, String> map) {
            Jedis jedis = getJedis();
            String s = jedis.hmset(key, map);
            closeJedis(jedis);
            return s;
        }

        /**
         * 添加對應關系，如果對應關系已存在，則覆蓋
         *
         * @param key
         * @param map 對應關系
         * @return 狀態，成功返回OK
         */
        public String hmset(byte[] key, Map<byte[], byte[]> map) {
            Jedis jedis = getJedis();
            String s = jedis.hmset(key, map);
            closeJedis(jedis);
            return s;
        }

    }


    //*******************************************Strings*******************************************//  
    public class Strings {
        /**
         * 根據key獲取記錄
         *
         * @param key
         * @return 值
         */
        public String get(String key) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            String value = sjedis.get(key);
            closeJedis(sjedis);
            return value;
        }

        /**
         * 根據key獲取記錄
         *
         * @param key
         * @return 值
         */
        public byte[] get(byte[] key) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            byte[] value = sjedis.get(key);
            closeJedis(sjedis);
            return value;
        }

        /**
         * 添加有過期時間的記錄
         *
         * @param key
         * @param seconds 過期時間，以秒為單位
         * @param value
         * @return String 操作狀態
         */
        public String setEx(String key, int seconds, String value) {
            Jedis jedis = getJedis();
            String str = jedis.setex(key, seconds, value);
            closeJedis(jedis);
            return str;
        }

        /**
         * 添加有過期時間的記錄
         *
         * @param key
         * @param seconds 過期時間，以秒為單位
         * @param value
         * @return String 操作狀態
         */
        public String setEx(byte[] key, int seconds, byte[] value) {
            Jedis jedis = getJedis();
            String str = jedis.setex(key, seconds, value);
            closeJedis(jedis);
            return str;
        }

        /**
         * 添加一條記錄，僅當給定的key不存在時才插入
         *
         * @param key
         * @param value
         * @return long 狀態碼，1插入成功且key不存在，0未插入，key存在
         */
        public long setnx(String key, String value) {
            Jedis jedis = getJedis();
            long str = jedis.setnx(key, value);
            closeJedis(jedis);
            return str;
        }

        /**
         * 添加記錄,如果記錄已存在將覆蓋原有的value
         *
         * @param key
         * @param value
         * @return 狀態碼
         */
        public String set(String key, String value) {
            return set(SafeEncoder.encode(key), SafeEncoder.encode(value));
        }

        /**
         * 添加記錄,如果記錄已存在將覆蓋原有的value
         *
         * @param key
         * @param value
         * @return 狀態碼
         */
        public String set(String key, byte[] value) {
            return set(SafeEncoder.encode(key), value);
        }

        /**
         * 添加記錄,如果記錄已存在將覆蓋原有的value
         *
         * @param key
         * @param value
         * @return 狀態碼
         */
        public String set(byte[] key, byte[] value) {
            Jedis jedis = getJedis();
            String status = jedis.set(key, value);
            closeJedis(jedis);
            return status;
        }

        /**
         * 從指定位置開始插入數據，插入的數據會覆蓋指定位置以後的數據<br/>
         * 例:String str1="123456789";<br/>
         * 對str1操作後setRange(key,4,0000)，str1="123400009";
         *
         * @param key
         * @param offset
         * @param value
         * @return long value的長度
         */
        public long setRange(String key, long offset, String value) {
            Jedis jedis = getJedis();
            long len = jedis.setrange(key, offset, value);
            closeJedis(jedis);
            return len;
        }

        /**
         * 在指定的key中追加value
         *
         * @param key
         * @param value
         * @return long 追加後value的長度
         **/
        public long append(String key, String value) {
            Jedis jedis = getJedis();
            long len = jedis.append(key, value);
            closeJedis(jedis);
            return len;
        }

        /**
         * 將key對應的value減去指定的值，只有value可以轉為數字時該方法才可用
         *
         * @param key
         * @param number 要減去的值
         * @return long 減指定值後的值
         */
        public long decrBy(String key, long number) {
            Jedis jedis = getJedis();
            long len = jedis.decrBy(key, number);
            closeJedis(jedis);
            return len;
        }

        /**
         * <b>可以作為獲取唯一id的方法</b><br/>
         * 將key對應的value加上指定的值，只有value可以轉為數字時該方法才可用
         *
         * @param key
         * @param number 要減去的值
         * @return long 相加後的值
         */
        public long incrBy(String key, long number) {
            Jedis jedis = getJedis();
            long len = jedis.incrBy(key, number);
            closeJedis(jedis);
            return len;
        }

        /**
         * 對指定key對應的value進行截取
         *
         * @param key
         * @param startOffset 開始位置(包含)
         * @param endOffset   結束位置(包含)
         * @return String 截取的值
         */
        public String getrange(String key, long startOffset, long endOffset) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            String value = sjedis.getrange(key, startOffset, endOffset);
            closeJedis(sjedis);
            return value;
        }

        /**
         * 獲取並設置指定key對應的value<br/>
         * 如果key存在返回之前的value,否則返回null
         *
         * @param key
         * @param value
         * @return String 原始value或null
         */
        public String getSet(String key, String value) {
            Jedis jedis = getJedis();
            String str = jedis.getSet(key, value);
            closeJedis(jedis);
            return str;
        }

        /**
         * 批量獲取記錄,如果指定的key不存在返回List的對應位置將是null
         *
         * @param keys
         * @return List<String> 值得集合
         */
        public List<String> mget(String... keys) {
            Jedis jedis = getJedis();
            List<String> str = jedis.mget(keys);
            closeJedis(jedis);
            return str;
        }

        /**
         * 批量存儲記錄
         *
         * @param keysvalues 例:keysvalues="key1","value1","key2","value2";
         * @return String 狀態碼
         */
        public String mset(String... keysvalues) {
            Jedis jedis = getJedis();
            String str = jedis.mset(keysvalues);
            closeJedis(jedis);
            return str;
        }

        /**
         * 獲取key對應的值的長度
         *
         * @param key
         * @return value值得長度
         */
        public long strlen(String key) {
            Jedis jedis = getJedis();
            long len = jedis.strlen(key);
            closeJedis(jedis);
            return len;
        }
    }


    //*******************************************Lists*******************************************//  
    public class Lists {
        /**
         * List長度
         *
         * @param key
         * @return 長度
         */
        public long llen(String key) {
            return llen(SafeEncoder.encode(key));
        }

        /**
         * List長度
         *
         * @param key
         * @return 長度
         */
        public long llen(byte[] key) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            long count = sjedis.llen(key);
            closeJedis(sjedis);
            return count;
        }

        /**
         * 覆蓋操作,將覆蓋List中指定位置的值
         *
         * @param key
         * @param index 位置
         * @param value 值
         * @return 狀態碼
         */
        public String lset(byte[] key, int index, byte[] value) {
            Jedis jedis = getJedis();
            String status = jedis.lset(key, index, value);
            closeJedis(jedis);
            return status;
        }

        /**
         * 覆蓋操作,將覆蓋List中指定位置的值
         *
         * @param
         * @param index 位置
         * @param value 值
         * @return 狀態碼
         */
        public String lset(String key, int index, String value) {
            return lset(SafeEncoder.encode(key), index,
                    SafeEncoder.encode(value));
        }

        /**
         * 獲取List中指定位置的值
         *
         * @param key
         * @param index 位置
         * @return 值
         **/
        public String lindex(String key, int index) {
            return SafeEncoder.encode(lindex(SafeEncoder.encode(key), index));
        }

        /**
         * 獲取List中指定位置的值
         *
         * @param key
         * @param index 位置
         * @return 值
         **/
        public byte[] lindex(byte[] key, int index) {
            Jedis sjedis = getJedis();
            byte[] value = sjedis.lindex(key, index);
            closeJedis(sjedis);
            return value;
        }

        /**
         * 將List中的第一條記錄移出List
         *
         * @param key
         * @return 移出的記錄
         */
        public String lpop(String key) {
            return SafeEncoder.encode(lpop(SafeEncoder.encode(key)));
        }

        /**
         * 將List中的第一條記錄移出List
         *
         * @param key
         * @return 移出的記錄
         */
        public byte[] lpop(byte[] key) {
            Jedis jedis = getJedis();
            byte[] value = jedis.lpop(key);
            closeJedis(jedis);
            return value;
        }

        /**
         * 將List中最後第一條記錄移出List
         *
         * @param key
         * @return 移出的記錄
         */
        public String rpop(String key) {
            Jedis jedis = getJedis();
            String value = jedis.rpop(key);
            closeJedis(jedis);
            return value;
        }

        /**
         * 向List尾部追加記錄
         *
         * @param key
         * @param value
         * @return 記錄總數
         */
        public long lpush(String key, String value) {
            return lpush(SafeEncoder.encode(key), SafeEncoder.encode(value));
        }

        /**
         * 向List頭部追加記錄
         *
         * @param key
         * @param value
         * @return 記錄總數
         */
        public long rpush(String key, String value) {
            Jedis jedis = getJedis();
            long count = jedis.rpush(key, value);
            closeJedis(jedis);
            return count;
        }

        /**
         * 向List頭部追加記錄
         *
         * @param key
         * @param value
         * @return 記錄總數
         */
        public long rpush(byte[] key, byte[] value) {
            Jedis jedis = getJedis();
            long count = jedis.rpush(key, value);
            closeJedis(jedis);
            return count;
        }
        
        /**
         * 向List頭部追加記錄
         *
         * @param key
         * @param value
         * @return 記錄總數
         */
        public long rpushVar(String key, String parentMarketInfo) {
            Jedis jedis = getJedis();
            long count = jedis.rpush(key, parentMarketInfo);
            closeJedis(jedis);
            return count;
        }

        /**
         * 向List中追加記錄
         *
         * @param key
         * @param value
         * @return 記錄總數
         */
        public long lpush(byte[] key, byte[] value) {
            Jedis jedis = getJedis();
            long count = jedis.lpush(key, value);
            closeJedis(jedis);
            return count;
        }

        /**
         * 獲取指定範圍的記錄，可以做為分頁使用
         *
         * @param key
         * @param start
         * @param end
         * @return List
         */
        public List<String> lrange(String key, long start, long end) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            List<String> list = sjedis.lrange(key, start, end);
            closeJedis(sjedis);
            return list;
        }

        /**
         * 獲取指定範圍的記錄，可以做為分頁使用
         *
         * @param key
         * @param start
         * @param end   如果為負數，則尾部開始計算
         * @return List
         */
        public List<byte[]> lrange(byte[] key, int start, int end) {
            //ShardedJedis sjedis = getShardedJedis();  
            Jedis sjedis = getJedis();
            List<byte[]> list = sjedis.lrange(key, start, end);
            closeJedis(sjedis);
            return list;
        }

        /**
         * 刪除List中c條記錄，被刪除的記錄值為value
         *
         * @param key
         * @param c     要刪除的數量，如果為負數則從List的尾部檢查並刪除符合的記錄
         * @param value 要匹配的值
         * @return 刪除後的List中的記錄數
         */
        public long lrem(byte[] key, int c, byte[] value) {
            Jedis jedis = getJedis();
            long count = jedis.lrem(key, c, value);
            closeJedis(jedis);
            return count;
        }

        /**
         * 刪除List中c條記錄，被刪除的記錄值為value
         *
         * @param key
         * @param c     要刪除的數量，如果為負數則從List的尾部檢查並刪除符合的記錄
         * @param value 要匹配的值
         * @return 刪除後的List中的記錄數
         */
        public long lrem(String key, int c, String value) {
            return lrem(SafeEncoder.encode(key), c, SafeEncoder.encode(value));
        }

        /**
         * 算是刪除吧，只保留start與end之間的記錄
         *
         * @param key
         * @param start 記錄的開始位置(0表示第一條記錄)
         * @param end   記錄的結束位置（如果為-1則表示最後一個，-2，-3以此類推）
         * @return 執行狀態碼
         */
        public String ltrim(byte[] key, int start, int end) {
            Jedis jedis = getJedis();
            String str = jedis.ltrim(key, start, end);
            closeJedis(jedis);
            return str;
        }

        /**
         * 算是刪除吧，只保留start與end之間的記錄
         *
         * @param key
         * @param start 記錄的開始位置(0表示第一條記錄)
         * @param end   記錄的結束位置（如果為-1則表示最後一個，-2，-3以此類推）
         * @return 執行狀態碼
         */
        public String ltrim(String key, int start, int end) {
            return ltrim(SafeEncoder.encode(key), start, end);
        }
    }

    public static void main(String[] args) {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("1", 1);
//        map.put("2", "sfasdfa");
//        map.put("3", "sfawrwere3fa");
//        for (int i = 0; i < 10000; i++) {
//        	 String werwe = JedisUtilnew.getInstance().lists.lrange(key, start, end);
//             System.out.println(werwe);
             String s = JedisUtilnew.getInstance().strings().get("werwe");
             System.out.println(s);
//		}
//    	 JedisUtilnew.Lists lists = new JedisUtilnew.Lists();
    	 String key = "Tradelast_nuls_btc_sell";
    	 int len = (int) JedisUtilnew.getInstance().lists.llen(key);
//    	 System.out.println(len);
         List<byte[]> bytes = JedisUtilnew.getInstance().lists.lrange(key.getBytes(),0,len-1);
//         List<MarketInfo> list=new ArrayList<MarketInfo>();
//         for(byte[] b:bytes){
//             MarketInfo marketInfo = (MarketInfo)SerializeUtils.unserialize(b);
//                 list.add(marketInfo);
//         }
//         for (int i = 0; i < list.size(); i++) {
//        	 System.out.println(list.get(i));
//		}
        
    }
}
