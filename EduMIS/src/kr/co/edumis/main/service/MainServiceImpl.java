package kr.co.edumis.main.service;

import kr.co.edumis.main.dao.MainDAO;

public class MainServiceImpl implements MainService{
	
	private static MainDAO dao;
	
	public MainServiceImpl() {
		dao = new MainDAO();
	}
	
}
