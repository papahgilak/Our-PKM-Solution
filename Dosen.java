package model;

/**
 *
 * @author Unicen Cola Candy
 */
public class Dosen extends User{
    private String nama;
    
    public Dosen(String nama){
        super();
        this.nama = nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return this.nama;
    }
}
