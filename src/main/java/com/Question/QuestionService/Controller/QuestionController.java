package com.Question.QuestionService.Controller;


import com.Question.QuestionService.Entities.Question;
import com.Question.QuestionService.Service.MyQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private MyQuestionService myQuestionService;


    @PreAuthorize("hasAuthority('Admin)")
    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question question)
    {
        this.myQuestionService.addQuestion(question);
        return ResponseEntity.ok(question);
    }


    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin)")
    @GetMapping
    public List<Question> getAllQuestions()
    {
        return  this.myQuestionService.getAllQuestions();
    }



    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{id}")
    public  Question getQuestionById(@PathVariable Long id)
    {

        return  this.myQuestionService.getQuestionbyId(id);
    }


    @GetMapping("/findQuestionByQuizId/{id}")
    public List<Question> findQuestionsByQuizId(@PathVariable Long id)
    {
       return this.myQuestionService.findQuestionsByQuizId(id);
    }


}
