package ke.co.dinerinn.models;

public class ReserveModel {
    Integer langimage;
    String langname;
    public ReserveModel(Integer langimage,String langname){
        this.langimage=langimage;
        this.langname=langname;
    }
    public Integer getLangimage(){
        return langimage;
    }
    public String getLangname(){
        return langname;
    }




}
