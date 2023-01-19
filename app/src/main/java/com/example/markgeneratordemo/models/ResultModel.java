package com.example.markgeneratordemo.models;

public class ResultModel {
    private String subject;
    private int mark;
    private int outOf;

    public ResultModel() {
    }

    public ResultModel(String subject, int mark, int outOf) {
        this.subject = subject;
        this.mark = mark;
        this.outOf = outOf;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getOutOf() {
        return outOf;
    }

    public void setOutOf(int outOf) {
        this.outOf = outOf;
    }
}
