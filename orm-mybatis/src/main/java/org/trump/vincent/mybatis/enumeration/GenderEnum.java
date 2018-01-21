package org.trump.vincent.mybatis.enumeration;

import java.io.Serializable;

public enum  GenderEnum implements Serializable {
    MALE(0),
    FEMALE(1)
    ;
    private int gender;
    GenderEnum(int gender){
        this.gender = gender;
    }
    public String getName(){
        return name();
    }

    public int getGenderCode(){
        return this.gender;
    }

    public static GenderEnum fromCode(int code){
        switch (code){
            case 0: return GenderEnum.MALE;

            case 1:
                return GenderEnum.FEMALE;
        }
        return null;
    }
}