package com.mysoft.weather.model.vo;

public class GlobalErrorVO {

  private String message;

  private String errorReason;

  public GlobalErrorVO() {
  }

  public GlobalErrorVO(String message, String errorReason) {
    this.message = message;
    this.errorReason = errorReason;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setErrorReason(String errorReason) {
    this.errorReason = errorReason;
  }

  public String getMessage() {
    return message;
  }

  public String getErrorReason() {
    return errorReason;
  }

}
