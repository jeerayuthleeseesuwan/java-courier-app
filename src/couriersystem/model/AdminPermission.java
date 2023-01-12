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
public class AdminPermission extends Permission {
    @Override
    public Boolean allowAccountManagement() {
        return true;
    }
    @Override
    public Boolean allowOrderManagement() {
        return true;
    }
    @Override
    public Boolean allowFeedbackManagement() {
        return true;
    }
    @Override
    public Boolean allowReportManagement() {
        return true;
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
