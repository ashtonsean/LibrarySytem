/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication30;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kei
 */
public class CrudMethod extends SqlConnector1{
    
        void addNewStudent (String std_id, String std_fname, String std_lname,
                        String std_course, String std_address, String std_number) {
        String messageResult = "";
        String query = "INSERT INTO student_table\n" +
                        "(std_school_id_number, std_fname, std_lname, std_course, std_address, std_contact_num)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = createConnection()){
            conn.setAutoCommit(false);
        
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, std_id.trim());
            pstmt.setString(2, std_fname.trim());
            pstmt.setString(3, std_lname.trim());
            pstmt.setString(4, std_course.trim());
            pstmt.setString(5, std_address.trim());
            pstmt.setString(6, std_number.trim());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 1) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "New Item Recorded!");
            } else {
                conn.rollback();
               messageResult = "There is a problem with (" + rowsAffected +")";
               JOptionPane.showMessageDialog(null, messageResult);
            }           
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }    
    }     
    void showAllStudentData (JTable stdData) {
        DefaultTableModel dtm = (DefaultTableModel) stdData.getModel();
        dtm.setRowCount(0);
        String query = "SELECT std_school_id_number, std_fname, std_lname, std_course, std_address, std_contact_num\n"
                + "FROM `student_table`";
        try (Connection conn = createConnection();){
           PreparedStatement pstmt = conn.prepareStatement(query);
           ResultSet rs = pstmt.executeQuery();
           
          while (rs.next()) {
                Object [] newRow = {                    
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                };
             dtm.addRow(newRow);
          }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
    }
    
    public void updateStudent (String std_id, String std_fname, String std_lname,
                        String std_course, String std_address, String std_number ) {
            String query = "UPDATE student_table "
                          + "SET std_fname = ?, std_lname = ?, std_course = ?, std_address = ?, std_contact_num = ? " 
                          +  "WHERE std_school_id_number = ?";
        try (Connection conn = createConnection()){
            conn.setAutoCommit(false);

             PreparedStatement pstmt = conn.prepareStatement(query);
             pstmt.setString(1, std_fname.trim());
             pstmt.setString(2, std_lname.trim());
             pstmt.setString(3, std_course.trim());
             pstmt.setString(4, std_address.trim());
             pstmt.setString(5, std_number.trim());
             pstmt.setString(6, std_id.trim());

             boolean confirm = (JOptionPane.showConfirmDialog(null, "Are you sure you want to update this student info?"
                     , "Confirm Update"
                     , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
             if (confirm) {
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected == 1) {
                    conn.commit();
                    JOptionPane.showMessageDialog(null, "Student Information Updated!");

                }else {
                    conn.rollback();
                   JOptionPane.showMessageDialog(null, "No record updated.");
                }
            }else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Update Cancel");
                  }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Er ror: " + e.getMessage());
        }    
    }  
    
    void deleteStudent (String std_id ) {
        String query = "DELETE FROM student_table "
                + "WHERE std_school_id_number = ?";
      
        try (Connection conn = createConnection()){
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(query);       
            pstmt.setString(1, std_id);
            
         boolean confirm = (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete student information?"
                 , "Confirm Delete"
                 , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION); 
            
         if (confirm) {
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected == 1) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Student Information Deleted!");
            
            }else {
               conn.rollback();
               JOptionPane.showMessageDialog(null, "No record updated.");
            }
        }else {
            conn.rollback();
            JOptionPane.showMessageDialog(null, "Delete Unsuccessful");
              }    
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
          
    }
    
    void addStaff(String stf_id, String stf_fname, String stf_lname, String stf_email, String stf_number, String stf_position){
        String query = "INSERT INTO user_table\n " +
                    "(stf_id, staff_fname, staff_lname, staff_email, staff_contact_num, staff_type) \n" +
                    "VALUES ( ?, ?, ?, ?, ?, ?);";
        
        try (Connection conn = createConnection()) {
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, stf_id);
            pstmt.setString(2, stf_fname);
            pstmt.setString(3, stf_lname);
            pstmt.setString(4, stf_email);
            pstmt.setString(5, stf_number);
            pstmt.setString(6, stf_position);
            
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 1) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "New Staff Added!");
            } else { 
                conn.rollback();
               JOptionPane.showMessageDialog(null, "There is a problem with (" + rowsAffected +")");
            }           
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }  
    }
    
    void showStaffData(JTable stf_data) {
        DefaultTableModel dtm = (DefaultTableModel) stf_data.getModel();
        dtm.setRowCount(0);
        String query ="SELECT stf_id, staff_fname, staff_lname,  staff_email, staff_contact_num, staff_type \n" +
                    "FROM user_table \n";
                    
        try(Connection conn = createConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Object [] newRow = {
                          rs.getString(1),
                          rs.getString(2),
                          rs.getString(3),
                          rs.getString(4),
                          rs.getString(5),
                          rs.getString(6)
                                 };
                dtm.addRow(newRow);
            } 
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "E rror: " + e.getMessage());
        }              
    }
    
    void updateStaff(String stf_id, String stf_fname, String stf_lname, String stf_email, String stf_number, String stf_position) {
        String query = "UPDATE user_table \n" +
                "SET staff_fname = ?, staff_lname = ?, staff_email = ?, staff_contact_num = ?, staff_type =? \n" +
                "WHERE stf_id";
        try (Connection conn = createConnection()){
            conn.setAutoCommit(false);

             PreparedStatement pstmt = conn.prepareStatement(query);
             pstmt.setString(1, stf_fname.trim());
             pstmt.setString(2, stf_lname.trim());
             pstmt.setString(3, stf_email.trim());
             pstmt.setString(4, stf_number.trim());
             pstmt.setString(5, stf_position.trim());
             pstmt.setString(6, stf_id.trim());

             boolean confirm = (JOptionPane.showConfirmDialog(null, "Are you sure you want to update this student info?"
                     , "Confirm Update"
                     , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
             if (confirm) {
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected == 1) {
                    conn.commit();
                    JOptionPane.showMessageDialog(null, "Staff Information Updated!");

                }else {
                    conn.rollback();
                   JOptionPane.showMessageDialog(null, "No record updated.");
                }
            }else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Update Cancel");
                  }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }    
    }
    
     void deleteStaff(String stf_id) {
        String query = "DELETE FROM user_table WHERE stf_id = ?";
      
        try (Connection conn = createConnection()){
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(query);       
            pstmt.setString(1, stf_id);
            
         boolean confirm = (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete staff information?"
                 , "Confirm Delete"
                 , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION); 
            
         if (confirm) {
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected == 1) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Staff Information Deleted!");
            
            }else {
               conn.rollback();
               JOptionPane.showMessageDialog(null, "No record updated.");
            }
        }else {
            conn.rollback();
            JOptionPane.showMessageDialog(null, "Delete Unsuccessful");
              }    
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
          
    }
     
   

    void addBook(String book_id, String book_title, String book_author, String book_category, int book_copies, String book_status, double cost) {
        String query = "INSERT INTO books_inv \n" +
                        "(bk_id, book_title, book_author, book_category, book_copies, book_status, book_cost)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = createConnection()) {
            conn.setAutoCommit(false);
            
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, book_id.trim());
            pstmt.setString(2, book_title.trim());
            pstmt.setString(3, book_author.trim());
            pstmt.setString(4, book_category.trim());
            pstmt.setInt(5, book_copies);
            pstmt.setString(6, book_status.trim());
            pstmt.setDouble(7, cost);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 1) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "New Book Added!");
            } else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "There is a problem with (" + rowsAffected + ")");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    void showBooks(JTable booksData) {
        DefaultTableModel dtm = (DefaultTableModel) booksData.getModel();
        dtm.setRowCount(0);
        String query = "SELECT book_id, book_title, book_author, book_category, book_copies, book_status\n" +
                        "FROM books_inv";
        try (Connection conn = createConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Object[] newRow = {
                    rs.getString(1),  // Book ID
                    rs.getString(2),  // Title
                    rs.getString(3),  // Author
                    rs.getString(4),  // Category
                    rs.getInt(5),     // Copies
                    rs.getString(6)   // Book Status
                };
                dtm.addRow(newRow);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    void updateBook(String book_id, String book_title, String book_author, String book_category, int book_copies, String book_status, double cost) {
        String query = "UPDATE books_table\n" +
                        "SET book_title = ?, book_author = ?, book_category = ?, book_copies = ?, book_status = ?, book_cost = ?\n" +
                        "WHERE bk_id = ?";
        try (Connection conn = createConnection()) {
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, book_title.trim());
            pstmt.setString(2, book_author.trim());
            pstmt.setString(3, book_category.trim());
            pstmt.setInt(4, book_copies);
            pstmt.setString(5, book_status.trim());
            pstmt.setDouble(6, cost);
            pstmt.setString(7, book_id.trim());
  

            boolean confirm = (JOptionPane.showConfirmDialog(null, "Are you sure you want to update this book info?",
                    "Confirm Update", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
            if (confirm) {
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected == 1) {
                    conn.commit();
                    JOptionPane.showMessageDialog(null, "Book Information Updated!");
                } else {
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "No record updated.");
                }
            } else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Update Cancelled");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    void deleteBook(String book_id) {
        String query = "DELETE FROM books_inv WHERE book_id = ?";
        try (Connection conn = createConnection()) {
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, book_id);

            boolean confirm = (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this book?",
                    "Confirm Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
            if (confirm) {
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected == 1) {
                    conn.commit();
                    JOptionPane.showMessageDialog(null, "Book Deleted!");
                } else {
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "No record deleted.");
                }
            } else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Delete Cancelled");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    
            
    
    public static void main (String [] args) {
        /*  CrudMethod CallMethods = new CrudMethod();
        String std_fname = "Sean";
        String std_lname = "Neri";
        String std_course = "DIT";
        String std_address = "109 Burgos Street, Conception, Malabon City";
        String std_number = "0932-0000-1832";
        String std_id = "2025-0002";
        
        CallMethods.addNewStudent(std_id, std_fname, std_lname, std_course, std_address, std_number); */
    }
}


