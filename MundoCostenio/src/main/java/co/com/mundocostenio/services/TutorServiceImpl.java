package co.com.mundocostenio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mundocostenio.domain.Tutor;
import co.com.mundocostenio.mybatis.mappers.TutorMapper;

@Service("tutorService")
public class TutorServiceImpl implements TutorService {
	
	@Autowired
	private TutorMapper tutorMapper;

	@Override
	public Tutor selectTutorById(int tutorId) {
		return this.tutorMapper.selectTutorById(tutorId);
	}

}
