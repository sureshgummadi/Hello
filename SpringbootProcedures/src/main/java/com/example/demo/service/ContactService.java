package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.example.demo.model.Contact;

@Component
public class ContactService {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Contact addContactDetails1(Contact con) {
		try {
			System.out.println("hi");
			StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("insertcontect")
					.registerStoredProcedureParameter("uname", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter("uphone", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter("umail", String.class, ParameterMode.IN);		
			 storedProcedure.setParameter("uname", con.getName())
							.setParameter("uphone", con.getPhone())
							.setParameter("umail", con.getMail());
			storedProcedure.executeUpdate();
			storedProcedure.getFirstResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	@SuppressWarnings("unchecked")
	public List<Contact> findAllViaProc(String name) {
		
		StoredProcedureQuery storedProcedureQuery = this.entityManager
				.createNamedStoredProcedureQuery("gettingconlikename");
		//System.out.println(storedProcedureQuery);
		storedProcedureQuery.setParameter("name", name);
		storedProcedureQuery.execute();
		System.out.println(storedProcedureQuery.getResultList());
		return storedProcedureQuery.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Contact> findAllViaProcId(Long id) {
		StoredProcedureQuery storedProcedureQuery = this.entityManager
				.createNamedStoredProcedureQuery("gettingconlikeid");
		storedProcedureQuery.setParameter("id", id);
		System.out.println(storedProcedureQuery.execute());
		return  storedProcedureQuery.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> getAllContactProc(){
		StoredProcedureQuery storedProcedureQuery = this.entityManager
				.createNamedStoredProcedureQuery("getAllContacts");
		storedProcedureQuery.execute();
		return storedProcedureQuery.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> findAllByViaQuery(String name) {
		List<Contact> contacts = this.entityManager
				.createNativeQuery("select name, phone, mail from contact where name like :name", "conatctMapping")
				.setParameter("name", name).setMaxResults(5).getResultList();

		return contacts;
	}

}
