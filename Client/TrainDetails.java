
package Client;
/**
 *
 * @author Priyanshi Dixit
 */
import static Client.Client.socket;
import java.awt.Color;
import java.awt.Font;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
public class TrainDetails extends javax.swing.JFrame {

    /**
     * Creates new form TrainDetails
     * @param Source
     * @param Destination
     * @param Train_no
     * @param Departure
     * @param Arrival
     * @param acSeat
     * @param SleeperSeat
     * @param acCost
     * @param date
     * @param slCost
     */
     String Trainno;
     String sor;
     String des,Seatsac,SeatsSl,fareAC,fareSL,Date;
     String dep;
     String arv;
     String user;
    public TrainDetails(String usnm,String date,String Train_no,String Source,String Destination,String Departure,String Arrival,String acSeat,String SleeperSeat,String acfare,String slfare) {
       initComponents();
       setLocation(400,100);
       this.user=usnm;
       JLabel user=new JLabel(usnm);
       user.setFont(new Font("Times new roman", Font.BOLD,14));
       user.setForeground(Color.white);
       user.setBounds(450,5,100,50);
       Panel1.add(user);
       
       Date=String.valueOf(date);
       Trainno=String.valueOf(Train_no);
       train_no=new JLabel(Trainno);
       train_no.setBounds(300,5,100,50);
       panel.add(train_no);
       
       sor=String.valueOf(Source);
       source=new JLabel(sor);
       source.setBounds(300,35,100,50);
       panel.add(source);
       
       des=String.valueOf(Destination);
       destination=new JLabel(des);
       destination.setBounds(300,65,100,50);
       panel.add(destination);
       
       Seatsac=String.valueOf(acSeat);
       ac_seats=new JLabel(acSeat);
       ac_seats.setBounds(300,95,100,50);
       panel.add(ac_seats);
       
       SeatsSl=String.valueOf(SleeperSeat);
       slpSeats=new JLabel(SleeperSeat);
       slpSeats.setBounds(300,130,100,50);
       panel.add(slpSeats);
       
       fareAC=String.valueOf(acfare);
       acCost=new JLabel(acfare);
       acCost.setBounds(300,165,100,50);
       panel.add(acCost);
       
       fareSL=String.valueOf(slfare);
       slCost=new JLabel(slfare);
       slCost.setBounds(300,200,100,50);
       panel.add(slCost);
       
       dep=String.valueOf(Departure);
       departure=new JLabel(dep);
       departure.setBounds(300,235,100,50);
       panel.add(departure);
       
       arv=String.valueOf(Arrival);
       arrival=new JLabel(arv);
       arrival.setBounds(300,265,100,50);
       panel.add(arrival);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pasg = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        coach = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        train_no = new javax.swing.JLabel();
        source = new javax.swing.JLabel();
        destination = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Arrival = new javax.swing.JLabel();
        departure = new javax.swing.JLabel();
        arrival = new javax.swing.JLabel();
        ac_seats = new javax.swing.JLabel();
        slpSeats = new javax.swing.JLabel();
        acCost = new javax.swing.JLabel();
        slCost = new javax.swing.JLabel();
        Panel1 = new javax.swing.JPanel();
        head = new javax.swing.JLabel();

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel18.setText("Sleeper fare");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Book Ticket ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        panel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setText("No of Tickets");

        pasg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pasg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        pasg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasgActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("source");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("destination");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("available seats in ac");

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel13.setText("available seats in sleeper");

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel14.setText("AC fare");

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel15.setText("select class");

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel16.setText("Sleeper fare");

        coach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "Sleeper" }));
        coach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel17.setText("Train Number");

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel19.setText("Arrival Time");

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel20.setText("Departure Time");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(arrival)
                        .addGap(61, 61, 61))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(train_no))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Arrival)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(departure))
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(64, 64, 64)
                                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(coach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pasg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(destination))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                        .addGap(242, 242, 242)
                                        .addComponent(source)))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(ac_seats))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(acCost)))))
                        .addContainerGap(73, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(slCost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slpSeats)
                        .addGap(91, 91, 91))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(train_no)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(source)
                            .addComponent(jLabel4))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(acCost)
                                    .addComponent(destination))))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(slpSeats)
                            .addComponent(slCost)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(ac_seats)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(coach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(Arrival)
                            .addComponent(departure))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(arrival))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel15)))
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pasg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        Panel1.setBackground(new java.awt.Color(102, 0, 102));

        head.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        head.setForeground(new java.awt.Color(255, 255, 255));
        head.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        head.setText("Train Details");

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(head, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(head)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ac_sl= (String) coach.getSelectedItem();
        String passg= (String) pasg.getSelectedItem();
        int fare;
        String Seats;
        if(ac_sl.equals("AC")){
            fare=Integer.parseInt(fareAC)*Integer.parseInt(passg);
            Seats=Seatsac;
        }
        else{
             fare=Integer.parseInt(fareSL)*Integer.parseInt(passg);
             Seats=SeatsSl;
        }
       // Integer.parseInt(passg);
      //  String coach,String arrival,String departure,String source,
     //   String destination,String passg,String fare,String date,String train_no
     /* String Trainno;
     String sor;
     String des,Seatsac,SeatsSl,fareAC,fareSL;
     String dep;
     String arv;*/
        TicketRequest tr=new TicketRequest(ac_sl,arv,dep,sor,des,passg,String.valueOf(fare),Date,Trainno,Seats);
        new Booking(user,Integer.parseInt(passg),tr).setVisible(true);
        this.hide();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        TrainsBetween tb = new TrainsBetween(user);
        this.hide();
        tb.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pasgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pasgActionPerformed

    private void coachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrainDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrainDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrainDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrainDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrainDetails("xyx123","2020-08-28","909090909","kanpur","allahabad","20:20","20:20","30","30","1000","700").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arrival;
    private javax.swing.JPanel Panel1;
    private javax.swing.JLabel acCost;
    private javax.swing.JLabel ac_seats;
    private javax.swing.JLabel arrival;
    private javax.swing.JComboBox<String> coach;
    private javax.swing.JLabel departure;
    private javax.swing.JLabel destination;
    private javax.swing.JLabel head;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panel;
    private javax.swing.JComboBox<String> pasg;
    private javax.swing.JLabel slCost;
    private javax.swing.JLabel slpSeats;
    private javax.swing.JLabel source;
    private javax.swing.JLabel train_no;
    // End of variables declaration//GEN-END:variables
}
