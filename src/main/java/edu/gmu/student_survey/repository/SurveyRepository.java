/*
 * Repository for Survey table
 */
package edu.gmu.student_survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.gmu.student_survey.entity.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    
}
