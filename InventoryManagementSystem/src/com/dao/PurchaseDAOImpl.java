package com.accenture.lkm.dao;  

  

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.entity.PurchaseEntity;
import com.accenture.lkm.entity.UserEntity;  

  

/**  

* <br/>  

* CLASS DESCRIPTION: <br/>  

* Implementation class for PurchaseDAO to perform the CRUD operation on  

* Purchase table <br/>  

*  

*/  

  

@Repository  

public class PurchaseDAOImpl implements PurchaseDAO {  

	private static Logger LOGGER = Logger.getLogger(PurchaseDAOImpl.class);  

  

	// Auto wire EntityManagerFactory here  

	@Autowired  

	private EntityManagerFactory entityManagerFactory;  

  

	/*  

	 * This method inserts the Purchase Data into the Purchase table.  

	 *  

	 * @param purchaseEntity  

	 *   

	 * @return PurchaseEntity  

	 */  

  
	@Override
	public Boolean validateLogin(String userName, String password) throws Exception {
		EntityManager entityManager = null;
		Boolean valid = null;
		try {  

			entityManager =entityManagerFactory.createEntityManager(); 
			UserEntity userEntity = entityManager.find(UserEntity.class, userName);
			if(userEntity != null) {
				valid = true;
			}
			else {
				valid = false;
			}
		}
		catch (Exception exception) {  

			throw exception;  

		} 

		finally{  

			if(entityManager!=null){  

				entityManager.close();  

			}
		}
		
		return valid;
		
	}
	
	@Override  

	public PurchaseBean savePurchaseDetail(PurchaseBean purchaseBean) throws Exception {  

  

		EntityManager entityManager = null;  

		 PurchaseEntity purchaseEntity = convertBeanToEntity(purchaseBean); 

		try {  

			 

			entityManager =entityManagerFactory.createEntityManager();  

			  			 

			  entityManager.getTransaction().begin(); 

			  entityManager.persist(purchaseEntity); 

			  entityManager.getTransaction().commit(); 

			   

			  entityManager.getTransaction().begin(); 

			  purchaseEntity.setTransactionId(purchaseEntity.getTransactionId() + purchaseEntity.getPurchaseId());  

			  //entityManager.merge(purchaseEntity); 

			  entityManager.getTransaction().commit(); 

			  

			purchaseBean = convertEntitytoBean(purchaseEntity); 

			 

		}  

		catch (Exception exception) {  

			throw exception;  

		} 

		finally{  

			if(entityManager!=null){  

				entityManager.close();  

			}  

		}  

  

		return purchaseBean;  

	} 

	 

	private PurchaseEntity convertBeanToEntity(PurchaseBean purchaseBean) {  

		// TODO Auto-generated method stub  

		PurchaseEntity purchaseEntityBean = new PurchaseEntity();  

		BeanUtils.copyProperties(purchaseBean,purchaseEntityBean);  

		return purchaseEntityBean;  

	} 

  

	private PurchaseBean convertEntitytoBean(PurchaseEntity savePurchaseDetail) {  

		// TODO Auto-generated method stub  

		PurchaseBean purchase = new PurchaseBean();  

		BeanUtils.copyProperties(savePurchaseDetail, purchase);  

		return purchase;  

	}  

} 