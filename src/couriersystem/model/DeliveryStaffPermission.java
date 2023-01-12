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
public class DeliveryStaffPermission extends Permission {
    @Override
    public Boolean allowAccountManagement() {
        return false;
    }
    @Override
    public Boolean allowOrderManagement() {
        return false;
    }
    @Override
    public Boolean allowFeedbackManagement() {
        return false;
    }
    @Override
    public Boolean allowReportManagement() {
        return false;
    }
    @Override
    public Boolean allowDeliveryManagement() {
        return true;
    }
    @Override
    public Boolean allowIndividualProfileManagement() {
        return true;
    }
}
