


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Munzhedzi Munyadziwa Petrus @Petcom Digital And Software Distribution
 */
public class CrecheChildReg {
    
   private String childName;
   private String gender;

    public CrecheChildReg() {
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
   
   public String joinString(){
       
       return childName + "#" + gender;
   }
   
}
