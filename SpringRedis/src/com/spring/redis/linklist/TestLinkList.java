package com.spring.redis.linklist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisListCommands.Position;
import org.springframework.data.redis.core.RedisCommand;
import org.springframework.data.redis.core.RedisTemplate;

public class TestLinkList {

	public static void main(String[] args) throws Exception {
		ApplicationContext cxt = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		RedisTemplate redisTemplate = (RedisTemplate) cxt
				.getBean("hashRedisTemplate");
		printList(redisTemplate, "list");
		// del list
		redisTemplate.delete("list");
		// lpush list node3
		redisTemplate.opsForList().leftPush("list", "node3");
		List<String> nodeList = new ArrayList<>();
		for (int i = 2; i >= 1; i--) {
			nodeList.add("node" + i);
		}
		// lpush list node2,node1
		redisTemplate.opsForList().leftPushAll("list", nodeList);
		printList(redisTemplate, "list");
		// rpush list node4
		redisTemplate.opsForList().rightPush("list", "node4");
		printList(redisTemplate, "list");
		// lindex list 0
		String node1 = (String) redisTemplate.opsForList().index("list", 0);
		System.out.println("node1:" + node1);
		// llen list
		Long size = redisTemplate.opsForList().size("list");
		System.out.println("size:" + size);
		printList(redisTemplate, "list");
		// lpop list
		System.out.println("lpop list");
		redisTemplate.opsForList().leftPop("list");
		printList(redisTemplate, "list");
		// rpop list
		System.out.println("rpop list");
		redisTemplate.opsForList().rightPop("list");
		printList(redisTemplate, "list");

		// linsert list before node2 before_node
		System.out.println("linsert list before node2 before_node");
		redisTemplate
				.getConnectionFactory()
				.getConnection()
				.lInsert("list".getBytes("utf-8"), Position.BEFORE,
						"node2".getBytes("utf-8"),
						"before_node".getBytes("utf-8"));
		printList(redisTemplate, "list");
		// linsert list after node2 after_node
		System.out.println("linsert list after node2 after_node");
		redisTemplate
				.getConnectionFactory()
				.getConnection()
				.lInsert("list".getBytes("utf-8"), Position.AFTER,
						"node2".getBytes("utf-8"),
						"after_node".getBytes("utf-8"));
		printList(redisTemplate, "list");
		// lpushx list head
		System.out.println("lpushx list head");
		redisTemplate.opsForList().leftPushIfPresent("list", "head");
		printList(redisTemplate, "list");
		// rpushx list end
		System.out.println("rpushx list end");
		redisTemplate.opsForList().rightPushIfPresent("list", "end");
		printList(redisTemplate, "list");
		//
		List rList = redisTemplate.opsForList().range("list", 0, 2);
		System.out.println("lrange list 0 2 \nlist:" + rList);
		nodeList.clear();
		for (int i = 1; i <= 3; i++) {
			nodeList.add("node");
		}
		System.out.println("lpush list ${nodeList}");
		redisTemplate.opsForList().leftPushAll("list", nodeList);
		printList(redisTemplate, "list");
		System.out.println("lrem list 3 node");
		System.out.println("从左到右删除到多三个node节点");
		redisTemplate.opsForList().remove("list", 3, "node");
		printList(redisTemplate, "list");
		System.out.println("lset list 0 new_head_value");
		redisTemplate.opsForList().set("list", 0, "new_head_value");
		printList(redisTemplate, "list");
	}

	static void printList(RedisTemplate redisTemplate, String key) {
		Long size = redisTemplate.opsForList().size(key);
		// lrange key start end 包含start和end
		List valueList = redisTemplate.opsForList().range(key, 0, size);// 严格意义上讲这里应该是size-1
		System.out.println(valueList);
	}

}
