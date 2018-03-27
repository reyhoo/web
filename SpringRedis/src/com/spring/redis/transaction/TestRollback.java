package com.spring.redis.transaction;
//命令正确，但 操作的数据格式不正确时，其它事务内的操作不受影响
/***
 * 127.0.0.1:6379> multi
OK
127.0.0.1:6379> set key1 value1
QUEUED
127.0.0.1:6379> set key2 value2
QUEUED
127.0.0.1:6379> incr key1
QUEUED
127.0.0.1:6379> del key2
QUEUED
127.0.0.1:6379> exec
1) OK
2) OK
3) (error) ERR value is not an integer or out of range
4) (integer) 1
127.0.0.1:6379> get key1
"value1"
127.0.0.1:6379> get key2
(nil)
 */



//命令不正确，执行了exec，事务内的操作都会被回滚
/**
 * 127.0.0.1:6379> multi
OK
127.0.0.1:6379> set key1 value1
QUEUED
127.0.0.1:6379> incr
(error) ERR wrong number of arguments for 'incr' command
127.0.0.1:6379> set key2 value2
QUEUED
127.0.0.1:6379> exec
(error) EXECABORT Transaction discarded because of previous errors.
127.0.0.1:6379> get key1
(nil)
127.0.0.1:6379> get key2
(nil)
 * @author Administrator
 *
 */
public class TestRollback {

}
