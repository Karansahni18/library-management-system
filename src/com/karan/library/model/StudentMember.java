package com.karan.library.model;

public class StudentMember extends Member{

    public StudentMember(int memberId,String name) {
        super(memberId, name, 3);
    }

    public int getLoanDurationDays() {
        return 14;
    }
}