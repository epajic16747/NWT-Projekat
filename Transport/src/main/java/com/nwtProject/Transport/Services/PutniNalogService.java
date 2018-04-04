package com.nwtProject.Transport.Services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwtProject.model.PutniNalog;
import com.nwtProject.repository.PutniNalogRepository;




@Service
public class PutniNalogService implements IPutniNalogService {

	
	@Autowired
	private PutniNalogRepository putniNalogRepo;
	
	@Override
	public List<PutniNalog> dajSvePutneNaloge(){
		
		List<PutniNalog> listaPutnihNaloga= new ArrayList<>();
		putniNalogRepo.findAll().forEach(e -> listaPutnihNaloga.add(e));
		
		return listaPutnihNaloga;
	}
	
	@Override
	public PutniNalog dajPutniNalog(long idPutnogNaloga) {
		PutniNalog putniNalog= putniNalogRepo.findById(idPutnogNaloga).get();
		return putniNalog;
	}
	
	@Override
	public void dodajPutniNalog(PutniNalog putniNalog) {
		
		putniNalogRepo.save(putniNalog);

	}
	@Override
	public void azurirajPutniNalog(PutniNalog putniNalog) {
		putniNalogRepo.save(putniNalog);
	}
	@Override
	public void obrisiPutniNalog(int idPutnogNaloga) {
		putniNalogRepo.delete(dajPutniNalog(idPutnogNaloga));
	
	}
}
