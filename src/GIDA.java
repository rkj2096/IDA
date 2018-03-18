/**
 * @(#)GIDA.java
 *
 *
 * @author
 * @version 1.00 2015/11/3
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GIDA extends JFrame {
    JTextField tf[];
    JTextArea ta,tas;
    JButton jb[];
    JButton jbc;
    JCheckBox cb[];
    JLabel mssl,nl,ml,pl,fl,dl;
    GridBagLayout gd;
    GridBagConstraints gc;
    JPanel cbp,jbp,mjp,ap;
    int n,m,p;
    String st="",stt="";
  public GIDA() {
    super("Information Dispersal algorithm");
    gd=new GridBagLayout();
    setLayout(gd);
    gc=new GridBagConstraints();

    //checkbox panel
    cbp=new JPanel();
    cbp.setLayout(new GridLayout(2,n));
    cbp.setBorder(BorderFactory.createTitledBorder("Select slices"));

    //button panel
    jbp=new JPanel();
    jbp.setLayout(new FlowLayout());

    //n,m,p panel
    mjp=new JPanel();
    mjp.setLayout(new GridLayout(1,6));


    //label
    mssl=new JLabel("Enter Messsage:");
    nl=new JLabel("Slices:");
    ml=new JLabel("Threshold:");
    pl=new JLabel("Prime:");
    fl=new JLabel("Message Fragments:");
    dl=new JLabel("Recovered Message:");

    //array init
    tf=new JTextField[5];
    jb=new JButton[3];
    cb=new JCheckBox[n];

    //text field
    tf[0]=new JTextField("",40);
    tf[0].setFont(new Font("Serif",Font.PLAIN,18));
    tf[1]=new JTextField("",40);
    tf[1].setFont(new Font("Serif",Font.PLAIN,18));
    tf[1].setEditable(false);
    tf[2]=new JTextField("",5);
    tf[2].setFont(new Font("Serif",Font.PLAIN,18));
    tf[3]=new JTextField("",5);
    tf[3].setFont(new Font("Serif",Font.PLAIN,18));
    tf[4]=new JTextField("",5);
    tf[4].setFont(new Font("Serif",Font.PLAIN,18));

    //text area
    Box box=Box.createHorizontalBox();
    ta=new JTextArea(100,150);
    tas=new JTextArea(100,150);
    jbc=new JButton("copy>>");
    ta.setFont(new Font("Serif",Font.PLAIN,16));
    ta.setEditable(false);
    tas.setFont(new Font("Serif",Font.PLAIN,16));
    tas.setEditable(false);
    box.add(new JScrollPane(ta));
    box.add(jbc);
    box.add(new JScrollPane(tas));

    //button
    jb[0]=new JButton("Disperse Message");
    jb[1]=new JButton("Cancel");
    jb[2]=new JButton("Recover Message");
    jbp.add(jb[0]);
    jbp.add(jb[2]);
    jbp.add(jb[1]);

    //n,m,p panel mjp
    mjp.add(nl);
    mjp.add(tf[2]);
    mjp.add(ml);
    mjp.add(tf[3]);
    mjp.add(pl);
    mjp.add(tf[4]);

    //check box
    for(int i=0;i<n;++i){
    cb[i]=new JCheckBox(""+i);
    cbp.add(cb[i]);
    }

    //add in bag
  	gc.fill=GridBagConstraints.HORIZONTAL;

   	addComponent(mssl,0,0,1,1);
   	addComponent(tf[0],1,0,1,1);
   	addComponent(mjp,2,0,1,1);
   	addComponent(fl,3,0,1,1);

   	gc.fill=GridBagConstraints.HORIZONTAL;
   	addComponent(cbp,8,0,1,1);
   	addComponent(jbp,9,0,1,1);
   	addComponent(dl,10,0,1,1);
    addComponent(tf[1],11,0,1,1);
    gc.fill=GridBagConstraints.BOTH;
   	gc.weightx = 1;
   	gc.weighty = 1;
   	addComponent(box,4,0,1,4);
    Bhandler bh =new Bhandler();
    jb[0].addActionListener(bh);
    jb[1].addActionListener(bh);
    jb[2].addActionListener(bh);
   	jbc.addActionListener(bh);
    }
   	private void addComponent(Component co,int r,int c,int w,int h)
   	{
    		gc.gridx=c;
    		gc.gridy=r;
    		gc.gridwidth=w;
    		gc.gridheight=h;
    		gd.setConstraints(co,gc);
    		add(co);
   	}
   	private class Bhandler implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    	  if(e.getSource()==jb[0]){
    	  	 st=tf[0].getText();
    	  	 n=Integer.parseInt(tf[2].getText());
    	  	 m=Integer.parseInt(tf[3].getText());
    	  	 p=Integer.parseInt(tf[4].getText());
    	   	 IDA id=new IDA(n,m,p);
    	  	 ta.setText(id.sencode(st));
    	  }
    	  if(e.getSource()==jbc){
    	  	if(tas.getText().equals("")){
    	  	stt=ta.getSelectedText();
    	  	tas.setText(ta.getSelectedText());
    	  	}else
    	  	{
    	    stt=stt+"\n"+ta.getSelectedText();
    	  	tas.setText(tas.getText()+"\n"+ta.getSelectedText());
    	  	}
    	  }
    	  if(e.getSource()==jb[2]){
    	  	n=Integer.parseInt(tf[2].getText());
    	    m=Integer.parseInt(tf[3].getText());
    	  	p=Integer.parseInt(tf[4].getText());
    	  	IDA idd=new IDA(n,m,p);
    	  	String tm=idd.sdecode(stt);
            tf[1].setText(tm);
    	  }
    	}
    }


    public static void main(String[] args) {
		try // For nimbus look and fill
		{
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GIDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GIDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GIDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GIDA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
        GIDA cd=new GIDA();
        cd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cd.setSize(600,500);
        cd.setVisible(true);
        cd.setResizable(true);
    }
}
