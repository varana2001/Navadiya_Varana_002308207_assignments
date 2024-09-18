/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import model.PersonProfile;

/**
 *
 * @author varananavadiya
 */
public class ViewJPanel extends javax.swing.JPanel {
    PersonProfile personprofile;
    /**
     * Creates new form ViewJPanel
     */
    public ViewJPanel(PersonProfile pf) {
        initComponents();
        personprofile=pf;
        displayPersonProfile();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtoccupation = new javax.swing.JTextField();
        lblgender = new javax.swing.JLabel();
        txtmaritalstatus = new javax.swing.JTextField();
        lbloccupation = new javax.swing.JLabel();
        txteducationlevel = new javax.swing.JTextField();
        lblfname = new javax.swing.JLabel();
        txtlname = new javax.swing.JTextField();
        lblstate = new javax.swing.JLabel();
        lblmaritalstatus = new javax.swing.JLabel();
        lbllname = new javax.swing.JLabel();
        lbleducationlevel = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        lblphone = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        lbldln = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        lbldls = new javax.swing.JLabel();
        txtdln = new javax.swing.JTextField();
        lblssn = new javax.swing.JLabel();
        txtdls = new javax.swing.JTextField();
        lbladdress1 = new javax.swing.JLabel();
        txtssn = new javax.swing.JTextField();
        lbladdress2 = new javax.swing.JLabel();
        txtaddress1 = new javax.swing.JTextField();
        txtaddress2 = new javax.swing.JTextField();
        lblcity = new javax.swing.JLabel();
        txtcity = new javax.swing.JTextField();
        txtstate = new javax.swing.JTextField();
        lblzip = new javax.swing.JLabel();
        txtzip = new javax.swing.JTextField();
        lbltelephonenumber = new javax.swing.JLabel();
        txttelephonenumber = new javax.swing.JTextField();
        lblfaxnumber = new javax.swing.JLabel();
        txtfaxnumber = new javax.swing.JTextField();
        txtdob = new javax.swing.JTextField();
        txtnationality = new javax.swing.JTextField();
        lbldob = new javax.swing.JLabel();
        txtgender = new javax.swing.JTextField();
        lblnationality = new javax.swing.JLabel();

        lblgender.setText("Gender");

        lbloccupation.setText("Occupation");

        lblfname.setText("First Name");

        txtlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlnameActionPerformed(evt);
            }
        });

        lblstate.setText("State");

        lblmaritalstatus.setText("Marital Status");

        lbllname.setText("Last Name");

        lbleducationlevel.setText("Educational Level");

        lblemail.setText("Email");

        txtfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfnameActionPerformed(evt);
            }
        });

        lblphone.setText("Phone No.");

        lbltitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbltitle.setText("                                                      View Person Profile");

        lbldln.setText("Driver License No.");

        txtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphoneActionPerformed(evt);
            }
        });

        lbldls.setText("Driver License Status");

        lblssn.setText("Social Security No.");

        lbladdress1.setText("Address1");

        lbladdress2.setText("Address2");

        txtaddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddress1ActionPerformed(evt);
            }
        });

        lblcity.setText("City");

        lblzip.setText("ZIP");

        lbltelephonenumber.setText("Telephone No.");

        txttelephonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelephonenumberActionPerformed(evt);
            }
        });

        lblfaxnumber.setText("Fax No.");

        lbldob.setText("DOB");

        lblnationality.setText("Nationality");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbladdress1)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblstate)
                                    .addComponent(lbltelephonenumber)
                                    .addComponent(lblfaxnumber)
                                    .addComponent(lbloccupation)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblnationality)
                                    .addComponent(lbleducationlevel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txteducationlevel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtdob, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                                        .addComponent(lblmaritalstatus)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmaritalstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txtgender)
                            .addComponent(txttelephonenumber)
                            .addComponent(txtzip))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblzip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtstate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbllname)
                                .addComponent(lblfname)
                                .addComponent(lblemail)
                                .addComponent(lblphone)
                                .addComponent(lbldln)
                                .addComponent(lbldls)
                                .addComponent(lblssn)
                                .addComponent(lbldob)
                                .addComponent(lblgender))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtdln)
                                .addComponent(txtemail)
                                .addComponent(txtphone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtlname, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtdls)
                                .addComponent(txtssn)
                                .addComponent(txtfaxnumber, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtnationality, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtfname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(txtaddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtoccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbladdress2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtaddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblcity)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addComponent(lbltitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(lbladdress1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(lblstate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblzip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltelephonenumber)
                    .addComponent(txtzip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelephonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfaxnumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbloccupation))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmaritalstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmaritalstatus)
                    .addComponent(txtdob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnationality))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txteducationlevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbleducationlevel))
                .addGap(74, 74, 74))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(lbltitle)
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblfname)
                        .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtaddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbllname)
                        .addComponent(txtaddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbladdress2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblemail)
                        .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblcity))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblphone)
                        .addComponent(txtoccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbldln, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbldls))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtssn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblssn))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbldob)
                        .addComponent(txtfaxnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblgender))
                    .addContainerGap(129, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlnameActionPerformed

    private void txtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfnameActionPerformed

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneActionPerformed

    private void txtaddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddress1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddress1ActionPerformed

    private void txttelephonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelephonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelephonenumberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbladdress1;
    private javax.swing.JLabel lbladdress2;
    private javax.swing.JLabel lblcity;
    private javax.swing.JLabel lbldln;
    private javax.swing.JLabel lbldls;
    private javax.swing.JLabel lbldob;
    private javax.swing.JLabel lbleducationlevel;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfaxnumber;
    private javax.swing.JLabel lblfname;
    private javax.swing.JLabel lblgender;
    private javax.swing.JLabel lbllname;
    private javax.swing.JLabel lblmaritalstatus;
    private javax.swing.JLabel lblnationality;
    private javax.swing.JLabel lbloccupation;
    private javax.swing.JLabel lblphone;
    private javax.swing.JLabel lblssn;
    private javax.swing.JLabel lblstate;
    private javax.swing.JLabel lbltelephonenumber;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lblzip;
    private javax.swing.JTextField txtaddress1;
    private javax.swing.JTextField txtaddress2;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtdln;
    private javax.swing.JTextField txtdls;
    private javax.swing.JTextField txtdob;
    private javax.swing.JTextField txteducationlevel;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfaxnumber;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtgender;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtmaritalstatus;
    private javax.swing.JTextField txtnationality;
    private javax.swing.JTextField txtoccupation;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtssn;
    private javax.swing.JTextField txtstate;
    private javax.swing.JTextField txttelephonenumber;
    private javax.swing.JTextField txtzip;
    // End of variables declaration//GEN-END:variables
    private void displayPersonProfile(){
    
        txtfname.setText(personprofile.getFirstName());
        txtlname.setText(personprofile.getLastName());
        txtemail.setText(personprofile.getEmail());
        txtphone.setText(personprofile.getPhone());
        txtdln.setText(personprofile.getDriverLicenseNumber());
        txtdls.setText(personprofile.getDriverLicenseStatus());
        txtssn.setText(personprofile.getSsn());
        txtaddress1.setText(personprofile.getAddress1());
        txtaddress2.setText(personprofile.getAddress2());
        txtcity.setText(personprofile.getCity());
        txtstate.setText(personprofile.getState());
        txtzip.setText(personprofile.getZip());
        txttelephonenumber.setText(personprofile.getTelephoneNumber());
        txtfaxnumber.setText(personprofile.getFaxNumber());
        txtdob.setText(personprofile.getDob());
        txtnationality.setText(personprofile.getNationality());
        txtgender.setText(personprofile.getGender());
        txtoccupation.setText(personprofile.getOccupation());
        txtmaritalstatus.setText(personprofile.getMaritalStatus());
        txteducationlevel.setText(personprofile.getEducationLevel());
    
    }
}
