/*
 * CRUD operations implementation.
 */

package edu.gmu.student_survey.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.gmu.student_survey.entity.Survey;
import edu.gmu.student_survey.repository.SurveyRepository;


@Service
public class SurveyService {
    private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        super();
        this.surveyRepository = surveyRepository;
    }

    public Survey post(Survey survey) {
        return surveyRepository.save(survey);
    }

    public List<Survey> getAll() {
        return surveyRepository.findAll();
    }

    public Survey getById(long id) {
        return surveyRepository.findById(id).orElseThrow();
    }

    public Survey update(Survey newSurvey, long id) {
        Survey survey = surveyRepository.findById(id).orElseThrow();

        survey.setFirst_name(newSurvey.getFirst_name());
        survey.setLast_name(newSurvey.getLast_name());
        survey.setAddress(newSurvey.getAddress());
        survey.setCity(newSurvey.getCity());
        survey.setState(newSurvey.getState());
        survey.setZip(newSurvey.getZip());
        survey.setTele(newSurvey.getTele());
        survey.setEmail(newSurvey.getEmail());
        survey.setDate(newSurvey.getDate());
        survey.setLiked(newSurvey.getLiked());
        survey.setInterest(newSurvey.getInterest());
        survey.setLikelihood(newSurvey.getLikelihood());
        survey.setComment(newSurvey.getComment());

        return surveyRepository.save(survey);
    }

    public void delete(long id) {
        surveyRepository.findById(id).orElseThrow();

        surveyRepository.deleteById(id);
    }
}
