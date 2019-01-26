package com.citydo.dialogue.service.Impl;

import com.citydo.dialogue.utils.ResultEnum;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import static com.citydo.dialogue.utils.ResultUtil.*;

@Service
@Transactional
public class SpikeServiceImpl {

    private final static Logger logger = LoggerFactory.getLogger(SpikeServiceImpl.class);

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String SPIKE_KEY = "spike:limit";
    private final String SPIKE_VALUE = "over";
    private final String SPIKE_TOPIC = "spike_topic";

    public String spike(String userName) {
        //推送给kafka处理 生成订单操作
        String content ="content:"+userName;
        kafkaTemplate.send(SPIKE_TOPIC, content);
        return success(ResultEnum.SUCCESS);
    }

    @KafkaListener(topics = SPIKE_TOPIC)
    public void messageConsumerHandler(String content) {
        logger.info("进入kafka消费队列content"+content);
        //生成订单记录
        Long orderId = Long.parseLong(RandomStringUtils.randomNumeric(18));
        String[] split = content.split(":");
        logger.info("生成订单success");
    }
}
