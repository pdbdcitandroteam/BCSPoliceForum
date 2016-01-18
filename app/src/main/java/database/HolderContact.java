package database;

/**
 * Created by Hi on 17-Jan-16.
 */
public class HolderContact {
    public int cont_ID , cont_verification,cont_claimed ,cont_verified  ;
    public String cont_display_id,cont_name , cont_father , cont_mother ,
            cont_address ,cont_phone , cont_email,cont_password ,
            cont_position , cont_posting , cont_blood_group ;


    public HolderContact( int cont_ID,int cont_verification, String cont_display_id, String cont_name,
                          String cont_father, String cont_mother, String cont_address,
                          String cont_phone, String cont_email, String cont_password, String cont_position,
                          String cont_posting, String cont_blood_group, int cont_claimed,int cont_verified) {
        this.cont_address = cont_address;
        this.cont_blood_group = cont_blood_group;
        this.cont_claimed = cont_claimed;
        this.cont_display_id = cont_display_id;
        this.cont_email = cont_email;
        this.cont_father = cont_father;
        this.cont_ID = cont_ID;
        this.cont_mother = cont_mother;
        this.cont_name = cont_name;
        this.cont_password = cont_password;
        this.cont_phone = cont_phone;
        this.cont_position = cont_position;
        this.cont_posting = cont_posting;
        this.cont_verification = cont_verification;
        this.cont_verified = cont_verified;
    }

    public HolderContact(int cont_verification, String cont_display_id, String cont_name,String cont_father,
                         String cont_mother, String cont_address,String cont_phone, String cont_email,
                         String cont_password, String cont_position,String cont_posting, String cont_blood_group,
                         int cont_claimed,int cont_verified )

    {
        this.cont_address = cont_address;
        this.cont_blood_group = cont_blood_group;
        this.cont_claimed = cont_claimed;
        this.cont_display_id = cont_display_id;
        this.cont_email = cont_email;
        this.cont_father = cont_father;
        this.cont_mother = cont_mother;
        this.cont_name = cont_name;
        this.cont_password = cont_password;
        this.cont_phone = cont_phone;
        this.cont_position = cont_position;
        this.cont_posting = cont_posting;
        this.cont_verification = cont_verification;
        this.cont_verified = cont_verified;
    }
}
