package yaolei.annotation.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yaolei.annotation.dao.PersonDao;


@Service
@Scope("prototype")
public class PersonServiceImpl implements PersonService {

	
	@Resource(name="personDaoImpl")
	private PersonDao mPersonDao;
	
	@Override
	public void regist() {
		System.out.println("PersonServiceImpl::regist");
		mPersonDao.save();
	}

}
