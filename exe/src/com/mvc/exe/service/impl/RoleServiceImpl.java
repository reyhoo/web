package com.mvc.exe.service.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.exe.mapper.RoleMapper;
import com.mvc.exe.pojo.Role;
import com.mvc.exe.service.RoleService;
import com.mvc.exe.util.Const;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Role> findByUserId(Long userId) {
		return roleMapper.findByUserId(userId);
	}
	@Transactional
	@Override
	public int add(Long userId, Role role) {
		return roleMapper.add(userId, role);
	}
	@Transactional
	@Override
	public int update(Role role) {
		return roleMapper.update(role);
	}
	@Transactional
	@Override
	public int delete(Long id) {
		return roleMapper.delete(id);
	}

	@Override
	public Role findById(Long id) {
		return roleMapper.findById(id);
	}
	@Override
	public int uploadPic(Role role) {
		return roleMapper.savePic(role);
	}
	@Override
	public void deleteUselessPicFile() {
		
		new Thread() {
			public void run() {
				List<String> list = roleMapper.getAllPic();
				List<File> fileList = new ArrayList<>();
				File dirFile = new File(Const.ROLE_PIC_FILE_DIR_PATH,"img");
				File[] all = dirFile.listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File pathname) {
						return pathname.isFile();
					}
				});
				System.err.println(list);
				for (String s : list) {
					s = s.substring(s.lastIndexOf("/")+1);
					File file = new File(dirFile,s);
					fileList.add(file);
				}
				deleteUseless(fileList,all);
			}
		}.start();
	}
	protected void deleteUseless(List<File> fileList, File[] all) {
		for (File file : all) {
			if(!fileList.contains(file)) {
				file.delete();
			}
		}
	}
	
	

}
