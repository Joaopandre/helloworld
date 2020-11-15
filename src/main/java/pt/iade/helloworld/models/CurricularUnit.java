package pt.iade.helloworld.models;

public class CurricularUnit {

    private String name;
    private double grade;
    private int semestre;
    private double ects;

    public CurricularUnit(String name, double grade, int semestre, double ects) {
        this.name = name;
        this.grade = grade;
        this.semestre = semestre;
        this.ects = ects;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getSemestre() {
        return semestre;
    }

    public double getEcts() {
        return ects;
    }

    public boolean isApproved(){


        return (grade >=9.5);



    }
    }





