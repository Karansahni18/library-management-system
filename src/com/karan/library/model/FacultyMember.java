package com.karan.library.model;

public class FacultyMember extends Member{

    public FacultyMember(int memberId ,  String name) {
        super(memberId , name , 10);
    }
    
    public int getLoanDurationDays() {
        return 30;
    }
}