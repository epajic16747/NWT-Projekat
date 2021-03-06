package com.nwtProject.KorisnikRecenzija.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwtProject.KorisnikRecenzija.Models.Korisnik;
import com.nwtProject.KorisnikRecenzija.Repositories.KorisnikRepozitorij;

@Service
public class KorisnikService implements IKorisnikService{
	
	
	@Autowired
	private KorisnikRepozitorij korisnikRepo;
	
	@Override
	public List<Korisnik> dajSveKorisnike(){
		
		List<Korisnik> listaKorisnika = new ArrayList<>();
		korisnikRepo.findAll().forEach(e -> listaKorisnika.add(e));
		
		return listaKorisnika;
	}
	
	@Override
	public Korisnik dajKorisnika(long idKorisnika) {
		Korisnik korisnik = korisnikRepo.findById(idKorisnika).get();

		return korisnik;
	}
	
	@Override
	public void dodajKorisnika(Korisnik korisnik) {
		
	    korisnikRepo.save(korisnik);

	}
	@Override
	public void azurirajKorisnika(Korisnik korisnik) {
	    korisnikRepo.save(korisnik);
	}

	@Override
	public void obrisiKorisnika(int idKorisnika) {
	    korisnikRepo.delete(dajKorisnika(idKorisnika));
		
	}

    @Override
    public boolean postojiKorisnikPoIdu(long idKorisnika) {
	    return korisnikRepo.existsById(idKorisnika);
    }
    
   
    public boolean postojiKorisnikPoUsername(String username){
    	List<Korisnik> korisnik = (List<Korisnik>) korisnikRepo.findByUsername(username);
        if(korisnik.size()!=0) return true;
        else return false;
    }
    public boolean postojiKorisnikPoUsernamePw(String username,String password){
    	List<Korisnik> korisnik = (List<Korisnik>) korisnikRepo.findByUsernamePw(username,password);
        if(korisnik.size()!=0) return true;
        else return false;
    }
    
    public Korisnik dajKorisnikaLogin(String username, String password) {
    	Korisnik k = korisnikRepo.findByUsernameAndPassword(username, password);
    	
    	return k;
    }
    
   /* public boolean postojiKorisnik(String username, String password) {
        Optional<Korisnik> user = KorisnikRepozitorij.findByUsername(username);
        if (((Optional<Korisnik>) user).isPresent() && user.get().getPassword() == password)
        	return true;
        else
        	return false;
    }
*/

}
