package com.i2i.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import com.i2i.model.Teacher;
import com.i2i.model.Subject;

/**
 * Model class for Standard
 * Standard is a physical entity which contains students 
 * Setter and Getter methods for the class variables
 * Mapping is done by annotation
 * 
 * @author Manigandan
 * 
 * @created 2016-09-08
 */

@Entity
@Table(name= "standard")
public class Standard {
    @Id
    @GeneratedValue
    @Column(name = "standard_id")
    private int standardId;
    
    @Column(name = "standard_name")
    private String standardName;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "standard_id")
    List<Subject> subjects = new ArrayList<Subject>();
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "coordinator_id")    
    private Teacher classCoordinator;

    public int getStandardId() {
        return standardId;
    }

    public void setStandardId(int standardId) {
        this.standardId = standardId;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }
    
    public Teacher getClassCoordinator() {
        return classCoordinator;
    }

    public void setClassCoordinator(Teacher classCoordinator) {
        this.classCoordinator = classCoordinator;
    }
    
    public Standard() { 
    }
    
    public Standard(String standardName) { 
        this.standardName = standardName;
    }
    
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    
    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }
}
