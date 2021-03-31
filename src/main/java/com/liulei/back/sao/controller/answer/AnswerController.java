package com.liulei.back.sao.controller.answer;

import com.liulei.back.sao.entity.answer.Answer;
import com.liulei.back.sao.service.answer.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
/**
 * TODO： 计划写一个知乎建议问答生成器
 * v1.0: 实现基本的增删改查，并能够根据问题标签生成随机答案。
 */
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @GetMapping("/answer")
    public List<String> getAnswers(@RequestParam("tags") String tags) {
        List<Answer> answers = answerService.get(tags);
        Collections.shuffle(answers);
        List<String> answersResult = new ArrayList<>();
        Random random = new Random(10);
        int randomInt = random.nextInt(answers.size());
        int seq = 1;
        for(int i=0;i<answers.size();i++){
            if (randomInt == i) {
                answersResult.add((seq+1)+".点赞吧！！");
                seq++;
            }
            answersResult.add(""+(seq+1)+"."+answers.get(i).getAnswer());
            seq++;
        }

        return answersResult;
    }

    @PostMapping("/answer")
    public Integer addAnswer(@RequestBody Answer answer){
        return answerService.add(answer.getAnswer(),answer.getTags());
    }

    @PostMapping("/answer/batch")
    public void batchAddAnswer( MultipartFile file, @RequestParam("tag")String tag) throws IOException {
        File file1 = new File(file.getOriginalFilename());
        FileUtils.copyInputStreamToFile(file.getInputStream(),file1);
        answerService.batchInsert(file1, tag);
    }
}
