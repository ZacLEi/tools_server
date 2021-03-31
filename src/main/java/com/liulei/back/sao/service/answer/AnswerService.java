package com.liulei.back.sao.service.answer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liulei.back.sao.entity.answer.Answer;
import com.liulei.back.sao.mapper.answer.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    public List<Answer> get(String tags){
        QueryWrapper<Answer> wrapper = new QueryWrapper<>();
        List<String> collect = Stream.of(tags.split(",")).collect(Collectors.toList());
        collect.forEach((t) -> {
            wrapper.like("tag","%"+t+"%");
        });

        List<Answer> answers = answerMapper.selectList(wrapper);
        return answers;
    }

    public Integer add(String answer,String tag) {
        Answer answer1 = answerMapper.selectOne(new QueryWrapper<Answer>().eq("answer", answer));
        Answer answer2 = Answer.builder()
                .answer(answer)
                .tags(tag)
                .build();
        if(answer1 != null) {
            answer1.setTags(answer1.getAnswer()+","+tag);
            answerMapper.updateById(answer1);
        }else {
            answerMapper.insert(answer2);
        }
        return answer2.getId();
    }

    public void batchInsert(File file,String tag) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null) {
            if (line.equals("")|| line.equals("\r")||line.equals("\n")){
                continue;
            }

            if (line.contains("点赞")){
                continue;
            }

            String regexStr = "[0-9]";

            Pattern compile = Pattern.compile(regexStr);
            Matcher matcher = compile.matcher(line);
            if (matcher.find()) {
                int start = matcher.start();
                String substring = line.substring(start+2);
                Answer answer = answerMapper.selectOne(new QueryWrapper<Answer>().eq("answer",substring));
                if (answer!=null) {
                    if (answer.getTags()!= null && answer.getTags().contains(tag)){
                        continue;
                    }
                    answer.setTags(answer.getTags()+","+tag);
                    answerMapper.updateById(answer);
                }else {
                    answerMapper.insert(Answer.builder()
                            .answer(substring)
                            .tags(tag)
                            .build());
                }
            }

        }
    }

}
