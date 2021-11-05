package com.example.quizapp.model.questions;

import com.example.quizapp.R;

public class Quiz {
    Question[] questions;

    public Quiz() {
        this.questions = new Question[] {
                // array of objects of class Question
                // providing questions from string
                // resource and the correct ans
                // trueAnswer should have lower value than the length of the array
                new Question("kva er verdas høgaste fjell?", 1, new String[] {"Galdhøpiggen",
                        "Mount Everest", "Danmark", "Olympus"}),
                new Question("i kva land ligg Bergen?", 2, new String[] {"Bergen",
                        "Sverige", "Noreg", "Narnia"}),
                new Question("kan ein bil vere blå?", 0, new String[] {"ja",
                        "nei", "ein bil kan bare vere rød", "biler har ikkje farger..."}),
                new Question("Er Netflix ein streamingtjeneste?", 1, new String[] {"netflix er ein PC-komponent",
                        "ja", "Netflix er youtube", "Netflix er eit land i Kina"}),
                new Question("bruker datamaskiner straum?", 0, new String[] {"ja",
                        "nei, den er motordrevet", "Datamaskiner er ein myte", "datamaskiner bruker vannkraft"}),
                new Question("Er Sverige hovudstaden i USA?", 3, new String[] {"Sveriger er hovudstaden i USA",
                        "USA er hovudstaden i Sverige", "Sverige er ein bydel i Oslo", "nei"}),
        };
    }



    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}
