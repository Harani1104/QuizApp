package com.example.quizapp.model.questions;

import com.example.quizapp.R;

import java.util.ArrayList;

public class Quiz {
    ArrayList<Question> questions;

    public Quiz() {
        /*
        ArrayList<String> answer1 = new ArrayList<>();
        answer1.add("Galdhøpiggen");
        answer1.add("Mount Everest");
        answer1.add("Danmark");
        answer1.add("Olympus");

        ArrayList<String> answer2 = new ArrayList<>();
        answer2.add("Bergen");
        answer2.add("Sverige");
        answer2.add("Noreg");
        answer2.add("Narnia");

        ArrayList<String> answer3 = new ArrayList<>();
        answer3.add("ja");
        answer3.add("nei");
        answer3.add("ein bil kan bare vere rød");
        answer3.add("biler har ikkje farger...");

        ArrayList<String> answer4 = new ArrayList<>();
        answer4.add("netflix er ein PC-komponent");
        answer4.add("ja");
        answer4.add("Netflix er youtube");
        answer4.add("Netflix er eit land i Kina");

        ArrayList<String> answer5 = new ArrayList<>();
        answer5.add("ja");
        answer5.add("Den er motordrevet");
        answer5.add("Datamaskiner er ein myte");
        answer5.add("datamaskiner bruker vannkraft");

        ArrayList<String> answer6 = new ArrayList<>();
        answer6.add("Sverige er hovudstaden i USA");
        answer6.add("USA er hovudstaden i Sverige");
        answer6.add("Sverige er ein bydel i Oslo");
        answer6.add("nei");

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("kva er verdas høgaste fjell?", 1, answer1));
        questions.add(new Question("i kva land ligg Bergen?", 2, answer2));
        questions.add(new Question("kan ein bil vere blå?", 0, answer3));
        questions.add(new Question("Er Netflix ein streamingtjeneste?", 1, answer4));
        questions.add(new Question("bruker datamaskiner straum?", 0, answer5));
        questions.add(new Question("Er Sverige hovudstaden i USA?", 3, answer6));
        this.questions = questions;
         */
    }

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }



    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString(){
        return "første spørsmål er: " + questions.get(0).getQuestion();
    }
}
