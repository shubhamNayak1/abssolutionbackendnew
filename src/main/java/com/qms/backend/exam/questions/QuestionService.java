package com.qms.backend.exam.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getQuestionsByIds(List<Long> ids) {
        return questionRepository.findByQuestionIdIn(ids);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
