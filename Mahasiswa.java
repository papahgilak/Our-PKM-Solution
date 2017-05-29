package model;

/**
 *
 * @author Unicen Cola Candy
 */
public class Mahasiswa extends User{
    private String nama;
    private String nim;
    private String fakultas;
    private String jurusan;
    
    public Mahasiswa(String nama, String nim, String fakultas, String jurusan) {
        super();
        this.nama = nama;
        this.nim = nim;
        this.fakultas = fakultas;
        this.jurusan = jurusan;
    }
    
    public void setNama(String nama){
      this.nama = nama;  
    }
    
    public void setNim(String nim){
        this.nim = nim;
    }
    
    public void setFakultas(String fakultas){
        this.fakultas = fakultas;
    }
    
    public void setJurusan(String jurusan){
        this.jurusan = jurusan;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public String getNim(){
        return this.nim;
    }
    
    public String getFakultas(){
        return this.fakultas;
    }
    
    public String getJurusan(){
        return this.jurusan;
    }
}
