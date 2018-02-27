package yaolei.aop.service;

public class DeptServiceImpl implements DeptService {

	public void delete() {
		System.out.println("删除部门操作");
	}

	public boolean save() {
		System.out.println("保存部门操作");
		return true;
	}

	public void update() {
		System.out.println("更新部门操作");
	}

}
