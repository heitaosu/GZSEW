package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Created by CodeGenerator on 2021/12/20.
*/
@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    /**
     * 向kafka中发送数据
     * @param input
     * @return
     */
    @GetMapping("/send.json")
    public Result<String> sendFoo(String input) {
        this.template.send("quickstart-events", input);
        return  ResultGenerator.genSuccessResult(input);
    }

    /**
     * 监听kafka中的主题消息
     * @param input
     */
    @KafkaListener(id = "webGroup", topics = "quickstart-events")
    public void listen(String input) {
        log.error("input value: {}" , input);
    }
}
