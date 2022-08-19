package com.mrwekayt.settings.app;

public class MobileModel {

    private String MobileRam;
    private String MobileBrand;
    private String MobileModel;
    private String MobileDpi;

    private int General;
    private int RedDot;
    private int Scope2x;
    private int Scope4x;
    private int AWMScope;
    private int FreeLook;



    public MobileModel() {

    }
    public MobileModel(String MobileRam, String MobileBrand,String MobileModel,String MobileDpi,int General,int RedDot,int Scope2x,int Scope4x,int AWMScope,int FreeLook) {

        this.MobileRam = MobileRam;
        this.MobileBrand= MobileBrand;
        this.MobileModel=MobileModel;
        this.MobileDpi=MobileDpi;
        this.General=General;
        this.RedDot=RedDot;
        this.Scope2x=Scope2x;
        this.Scope4x=Scope4x;
        this.AWMScope=AWMScope;
        this.FreeLook=FreeLook;

    }

    public String getMobileRam() {
        return MobileRam;
    }
    public String getMobileBrand() {
        return MobileBrand;
    }
    public String getMobileModel() {
        return MobileModel;
    }
    public String getMobileDpi() {
        return MobileDpi;
    }
    public int getGeneral() {
        return General;
    }
    public int getRedDot() {
        return RedDot;
    }
    public int getScope2x() {
        return Scope2x;
    }
    public int getScope4x() {
        return Scope4x;
    }
    public int getAWMScope() {
        return AWMScope;
    }
    public int getFreeLook() {
        return FreeLook;
    }
    public void setMobileRam(String mobileRam) {
        this.MobileRam = MobileRam;
    }
    public void setMobileBrand(String MobileBrand) {
        this.MobileBrand = MobileBrand;
    }
    public void setMobileModel(String MobileModel) {
        this.MobileModel = MobileModel;
    }
    public void setMobileDpi(String MobileDpi) {
        this.MobileDpi = MobileDpi;
    }
    public void setGeneral(int General) {
        this.General = General;
    }
    public void setRedDot(int RedDot) {
        this.RedDot = RedDot;
    }
    public void setScope2x(int Scope2X) {
        this.Scope2x = Scope2X;
    }
    public void setScope4x(int Scope4X) {
        this.Scope4x = Scope4X;
    }
    public void setAWMScope(int AWMScope) {
        this.AWMScope = AWMScope;
    }
    public void setFreeLook(int FreeLook) {
        this.FreeLook = FreeLook;
    }


}
