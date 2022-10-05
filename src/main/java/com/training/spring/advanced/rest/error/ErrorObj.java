package com.training.spring.advanced.rest.error;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         errorDesc;
    private Integer        errorCode;


    public static ErrorObj createBaseErrorObj() {
        return new ErrorObj();
    }
    public ErrorObj addMultipleSubErrors(Collection<ErrorObj> errorObj) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.addAll(errorObj);
        return this;
    }

    public ErrorObj addSubError(ErrorObj errorObj) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.add(errorObj);
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return subErrors;
    }

    public ErrorObj setSubErrors(List<ErrorObj> subErrors) {
        this.subErrors = subErrors;
        return this;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public ErrorObj setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
        return this;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public ErrorObj setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public static void main(String[] args) {
        String str = "osman";
        // str += " yay";
        String concat = str.concat(" yay");
        if (str.equals("osman")) {
            System.out.println("eşit");
        }

        ErrorObj errorObj = ErrorObj.createBaseErrorObj()
                                    .setErrorDesc("deneme1")
                                    .setErrorCode(1000)
                                    .addSubError(ErrorObj.createBaseErrorObj()
                                                         .setErrorDesc("deneme2")
                                                         .setErrorCode(1000))
                                    .addSubError(ErrorObj.createBaseErrorObj()
                                                         .setErrorDesc("deneme3")
                                                         .setErrorCode(1000))
                                    .addSubError(ErrorObj.createBaseErrorObj()
                                                         .setErrorDesc("deneme4")
                                                         .setErrorCode(1000));
    }

    @Override
    public String toString() {
        return "ErrorObj{" +
                "subErrors=" + subErrors +
                ", errorDesc='" + errorDesc + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}
