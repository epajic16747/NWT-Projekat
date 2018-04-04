package com.nwtProject.Transport.Services;

import java.util.List;


import com.nwtProject.model.PutniNalog;

public interface IPutniNalogService {

	
	List<PutniNalog> dajSvePutneNaloge();
	PutniNalog dajPutniNalog(long idPutniNaloga);
	void dodajPutniNalog(PutniNalog putniNalog);
	void azurirajPutniNalog(PutniNalog putniNalog);
	void obrisiPutniNalog(int idPutniNaloga);
}
