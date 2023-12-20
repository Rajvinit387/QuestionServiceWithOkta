package com.Question.QuestionService.Service;

import com.Question.QuestionService.Entities.Question;

import java.util.List;

public interface MyQuestionService {

    Question addQuestion(Question question);

    List<Question> getAllQuestions();

    Question getQuestionbyId(Long id);

    List<Question> findQuestionsByQuizId(Long quizId);


}
