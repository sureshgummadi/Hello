package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ParameterMode;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import lombok.Data;

@Data
@Entity
@Table(name="contact")

@SqlResultSetMapping(
		name = "conatctMapping", 
		entities = @EntityResult(
			entityClass = Contact.class, 
			fields = {
				@FieldResult(name = "name", column = "name"),
				@FieldResult(name = "phone", column = "phone"),
				@FieldResult(name = "mail", column = "mail")})
)
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "gettingconlikename", procedureName = "geting_user_ne",resultClasses= {Contact.class},
													       parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "name", type = String.class)}
							 ),@NamedStoredProcedureQuery(name = "gettingconlikeid", procedureName = "geting_user_Id",resultClasses= {Contact.class},
														   parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "id", type = Long.class)}
							 ),@NamedStoredProcedureQuery(name = "getAllContacts", procedureName = "geting_user_All",resultClasses= {Contact.class})
							  ,@NamedStoredProcedureQuery(name = "insertcontect", procedureName = "insert_contact_detailsA",resultClasses= {Contact.class})
							 }
)
public class Contact implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;   
    private String name;   
    private String phone;   
    private String mail;
}
