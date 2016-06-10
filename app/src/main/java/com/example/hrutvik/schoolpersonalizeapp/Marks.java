package com.example.hrutvik.schoolpersonalizeapp;

/**
 * Created by hrutvik on 16-06-10.
 */
public class Marks {
    private double knowledge;
    private double thinking;
    private double application;
    private double communication;

    public Marks(double knowledge, double thinking, double application, double communication) {
        this.knowledge = knowledge;
        this.thinking = thinking;
        this.application = application;
        this.communication = communication;
    }
    public Marks(){

    }

    public double getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(double knowledge) {
        this.knowledge = knowledge;
    }

    public double getThinking() {
        return thinking;
    }

    public void setThinking(double thinking) {
        this.thinking = thinking;
    }

    public double getApplication() {
        return application;
    }

    public void setApplication(double application) {
        this.application = application;
    }

    public double getCommunication() {
        return communication;
    }

    public void setCommunication(double communication) {
        this.communication = communication;
    }

}
