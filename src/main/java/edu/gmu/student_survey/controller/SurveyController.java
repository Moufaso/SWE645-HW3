/*
 * REST API implementation.
 */

package edu.gmu.student_survey.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.gmu.student_survey.entity.Survey;
import edu.gmu.student_survey.service.SurveyService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class SurveyController {
    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        super();
        this.surveyService = surveyService;
    }

    // post new survey
    @PostMapping("/survey")
    public ResponseEntity<Survey> postSurvey(@RequestBody Survey survey) {
        return new ResponseEntity<Survey>(surveyService.post(survey), HttpStatus.CREATED);
    }

    //list all surveys
    @GetMapping("/list")
    public List<Survey> getAllSurveys() {
        return surveyService.getAll();
    }
    
    // get survey
    @GetMapping("list/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable("id") long id) {
        return new ResponseEntity<Survey>(surveyService.getById(id), HttpStatus.OK);
    }

    //update survey
    @PutMapping("list/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable("id") long id, @RequestBody Survey survey) {
        return new ResponseEntity<Survey>(surveyService.update(survey, id), HttpStatus.OK);
    }

    // delete survey
    @DeleteMapping("list/{id}")
    public ResponseEntity<String> deleteSurvey(@PathVariable("id") long id) {
        surveyService.delete(id);

        return new ResponseEntity<String>("Survey deleted successfully.", HttpStatus.OK);
    }
}
