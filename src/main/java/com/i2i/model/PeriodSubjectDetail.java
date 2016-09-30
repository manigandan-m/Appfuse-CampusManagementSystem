package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import com.i2i.model.Teacher;
import com.i2i.model.Standard;
import com.i2i.model.Subject;

/**
 * Model class for PeriodSubjectDetail
 * Setter and Getter methods for the class variables
 * Mapping is done by annotation
 * 
 * @author Manigandan
 * 
 * @created 2016-09-12
 */

@Entity
@Table(name= "period_subject_detail")
public class PeriodSubjectDetail {
	
    @Id	
    @GeneratedValue
    @Column(name = "period_subject_id")
    private int periodSubjectId;
	
    @Column(name = "period_id") 
    private int periodId;
	
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_id")  
    private Teacher teacher;	
	
    @Column(name = "subject_code") 
    private String subjectCode;
	
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "standard_id")  
    private Standard standard;
	
    public void setPeriodSubjectId(int periodSubjectId) {
        this.periodSubjectId = periodSubjectId;
    }
	
    public int getPeriodSubjectId() {
        return periodSubjectId;
    }
	
    public void setPeriodId(int periodId) {
        this.periodId = periodId;                                                                                                    
    }
	
    public int getPeriodId() {
        return periodId;
    }
	
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;                                                                                                    
    }
	
    public Teacher getTeacher() {
        return teacher;
    }
	
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;                                                                                                    
    }
	
    public String getSubjectCode() {
        return subjectCode;
    }
	
    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public Standard getStandard() {
        return standard;
    }
    
    public List<Subject> addSubjects(List<Subject> subjects) {
    	List<Subject> periods = new ArrayList<Subject>();
    	periods.add(0,null);
    	periods.add(1,subjects.get(0));
    	periods.add(2,subjects.get(1));
    	periods.add(3,subjects.get(2));
    	periods.add(4,subjects.get(3));
    	periods.add(5,subjects.get(4));
    	periods.add(6,subjects.get(1));
    	periods.add(7,subjects.get(0));
    	periods.add(8,subjects.get(2));
    	periods.add(9,subjects.get(3));
    	periods.add(10,subjects.get(0));
    	periods.add(11,subjects.get(4));
    	periods.add(12,subjects.get(1));
    	periods.add(13,subjects.get(2));
    	periods.add(14,subjects.get(4));
    	periods.add(15,subjects.get(3));
    	periods.add(16,subjects.get(0));		
    	periods.add(17,subjects.get(1));		
    	periods.add(18,subjects.get(2));		
    	periods.add(19,subjects.get(3));		
    	periods.add(20,subjects.get(4));				
    	return periods;
    }
}
