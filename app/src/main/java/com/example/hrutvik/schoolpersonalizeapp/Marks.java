package com.example.hrutvik.schoolpersonalizeapp;

/**
 * This class is made for reuseablity sake. It is used to change the weight of each category
 * It contains instance variables that represent each category
 */
public class Marks {
    private double knowledge;
    private double thinking;
    private double application;
    private double communication;

    /**
     * This is the constructor for the class when an object with 4 arguments is created
     * Made for reuseablitiy incase we want to change the code later on
     * @param knowledge
     * @param thinking
     * @param application
     * @param communication
     */
    public Marks(double knowledge, double thinking, double application, double communication) {
        this.knowledge = knowledge;
        this.thinking = thinking;
        this.application = application;
        this.communication = communication;
    }

    /**
     * This is an overloaded constructer which we use when an object with no arguments is created
     * We used the object to access the methods in this class through this constructor
     */
    public Marks(){

    }

    /**
     * This accessor method is used to get the weight of the knowledge category
     * @return
     */
    public double getKnowledge() {
        return knowledge;
    }

    /**
     * This mutator method is used to change the weight of the knowledge category
     * @param knowledge
     */
    public void setKnowledge(double knowledge) {
        this.knowledge = knowledge;
    }

    /**
     * This accessor method is used to get the weight of the thinking category
     * @return
     */
    public double getThinking() {
        return thinking;
    }

    /**
     * This mutator method is used to change the weight of the thinking category
     * @param thinking
     */
    public void setThinking(double thinking) {
        this.thinking = thinking;
    }

    /**
     * This accessor method is used to get the weight of the application category
     * @return
     */
    public double getApplication() {
        return application;
    }

    /**
     * This mutator method is used to change the weight of the application category
     * @param application
     */
    public void setApplication(double application) {
        this.application = application;
    }

    /**
     * This accessor method is used to get the weight of the communication category
     * @return
     */
    public double getCommunication() {
        return communication;
    }

    /**
     * This mutator method is used to change the weight of the communication category
     * @param communication
     */
    public void setCommunication(double communication) {
        this.communication = communication;
    }

}
