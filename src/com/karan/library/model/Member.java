package com.karan.library.model;

public abstract class Member {

    private int memberId;
    private String name;
    private int maxBooksAllowed;

    public abstract int getLoanDurationDays();

    public Member(int memberId , String name , int maxBooksAllowed) {

        this.memberId = memberId;
        this.name = name;
        this.maxBooksAllowed = maxBooksAllowed;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getMaxBooksAllowed() {
        return maxBooksAllowed;
    }
}