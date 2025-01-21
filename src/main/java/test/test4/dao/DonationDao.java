package test.test4.dao;


import test.test4.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import test.test4.Donation;

import java.util.List;

public class DonationDao {
    public void addDonation(Donation donation) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.save(donation);
            tx.commit();
        }catch(RuntimeException e){
            if (tx != null) tx.rollback();
            throw e;
        }
    }
    public List<Donation> getAllDonations() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Donation ", Donation.class).list();
        }
    }
public boolean deleteDonationById(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Donation donation = session.get(Donation.class, id);
            if (donation != null) {
                session.delete(donation);
                tx.commit();
                return true;
            } else {
                tx.commit();
                return false;
            }
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;  // Proper exception handling should be implemented
        }
    }
    public Donation updateDonation(int id, Donation newDonationDetails) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Donation donation = session.get(Donation.class, id);
            if (donation != null) {
                donation.setName(newDonationDetails.getName());
                donation.setAmount(newDonationDetails.getAmount());
                donation.setKeepAnonymous(newDonationDetails.isKeepAnonymous());
                donation.setMessage(newDonationDetails.getMessage());
                session.update(donation);
                tx.commit();
                return donation;
            } else {
                tx.rollback();  // Roll back if no donation found
                return null;
            }
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;  // Proper exception handling should be implemented
        }
    }

}

