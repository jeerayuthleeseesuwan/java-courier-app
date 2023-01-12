/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package couriersystem.model;

/**
 *
 * @author jeera
 */

// Abstract class
public abstract class Permission {
  public abstract Boolean allowAccountManagement();
  public abstract Boolean allowOrderManagement();
  public abstract Boolean allowFeedbackManagement();
  public abstract Boolean allowReportManagement();
  public abstract Boolean allowDeliveryManagement();
  public abstract Boolean allowIndividualProfileManagement();
}
