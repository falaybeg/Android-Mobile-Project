package com.example.mehmethan.denemelogin;

/**
 * Created by Admin on 12/10/2017.
 */

public class KullaniciBilgi {


    private String Name;
    private String Surname;
    private int Yas;
    private String Cinsiyet;


    private String Email;
    private String Password;

public KullaniciBilgi()
{}



    public KullaniciBilgi(String email, String password)
    {
        setEmail(email);
        setPassword(password);
    }

    // Register Information
    public void setEmail(String email)
    {
        Email= email;
    }
    public  String getIsım()
    {
        return Email;
    }

    public void setPassword(String password)
    {
        Password = password;
    }
    public  String getEmail()

    {
        return Password;
    }


    // User Information
    public void setName(String name)
    {
        Name= name;
    }
    public  String getName()
    {
        return Name;
    }

    public void setSurname(String surname)
    {
        Surname = surname;
    }
    public  String getSurname()

    {
        return Surname;
    }

    public void setYas(int yas)
    {
        Yas= yas;
    }
    public int getYas()
    {
        return Yas;
    }

    public void setCinsiyet(String cinsiyet)
    {
        Cinsiyet = cinsiyet;
    }
    public  String getCinsiyet()

    {
        return Cinsiyet;
    }


}
