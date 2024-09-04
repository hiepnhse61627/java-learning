package io_api.model;

public class InfoMedium {
  private String theMedium;

  public InfoMedium() { // IS called when de-serialising as this class IS NOT Serializable
    theMedium = "Unknown";
  }

  public String getTheMedium() {
    return theMedium;
  }

  public void setTheMedium(String theMedium) {
    this.theMedium = theMedium;
  }
}
