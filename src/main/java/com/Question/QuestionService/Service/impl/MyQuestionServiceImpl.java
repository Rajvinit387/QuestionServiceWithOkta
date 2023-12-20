package com.Question.QuestionService.Service.impl;

import com.Question.QuestionService.Entities.Question;
import com.Question.QuestionService.Service.MyQuestionService;
import com.Question.QuestionService.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyQuestionServiceImpl implements MyQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question getQuestionbyId(Long id) {
        return this.questionRepository.findById(id).get();
    }

    @Override
    public List<Question> findQuestionsByQuizId(Long quizId) {
        return this.questionRepository.findByQuizId(quizId);
    }
}
