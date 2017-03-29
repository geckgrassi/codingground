import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class MyPanel extends JPanel implements ActionListener{
    
	private static final long serialVersionUID = 1L;
	private JPanel pnlMain;
	private JPanel pnlPush;
	private JPanel pnlRimuovi;
	private JPanel pnlRicerca;

	private JPanel pnlCenter;

    private Lista gestione; 
    private int index=0;
    private JTextField txtCodice;
    private JLabel lblCodice;
    private JTextField txtStazza;
    private JLabel lblStazza;
    private JTextField txtCarico;
    private JLabel lblCarico;
    //private JTextField txtPosizione;
    //private JLabel lblPosizione;
    private JTextField txtRicerca;
    private JLabel lblRisultato;
    private JButton btnAggiungi;
    private JButton btnRimuovi;
    private JButton btnRicerca;
    private JButton btnInserisci;
    private JButton btnResearch;

    private JButton btnReturn;

    
    private String panelShown;

	

    public MyPanel(){		
    	//this.setLayout(new BorderLayout());
    	this.gestione =new Lista();
    	this.btnReturn = new JButton("INDIETRO");
        this.btnReturn.addActionListener(this);

		//this.setBackground(new Color(255,112,67));

    	
    	//pannello main
    	this.pnlMain = new JPanel();
		this.btnAggiungi = new JButton("AGGIUNGI");
		this.btnAggiungi.addActionListener(this);
        this.btnRimuovi = new JButton("RIMUOVI");
        this.btnRimuovi.addActionListener(this);
        this.btnRicerca = new JButton("RICERCA");
        this.btnRicerca.addActionListener(this);
        this.pnlMain.add(this.btnAggiungi);
        this.pnlMain.add(this.btnRicerca);
        this.pnlMain.add(this.btnRimuovi);
        

		
		//pannello push
		this.pnlPush = new JPanel();
		this.pnlPush.setLayout(new GridLayout(5,2));
		this.lblCodice = new JLabel("CODICE: ");
		this.txtCodice = new JTextField(10);
		this.lblStazza = new JLabel("STAZZA: ");
		this.txtStazza = new JTextField(10);
		this.lblCarico = new JLabel("CARICO: ");
		this.txtCarico = new JTextField(10);
		//this.lblPosizione = new JLabel("POSIZIONE: ");
		//this.txtPosizione = new JTextField(10);
		this.btnInserisci = new JButton("INSERISCI");
        this.btnInserisci.addActionListener(this);
        
        //pannello rimuovi
        this.pnlRimuovi = new JPanel();
        
        //pannello ricerca
        this.pnlRicerca = new JPanel();
        new JLabel("CODICE: ");
		this.txtRicerca = new JTextField(10);
		this.btnResearch = new JButton("RICERCA");
        this.btnResearch.addActionListener(this);
		this.lblRisultato = new JLabel(" ");

        

		
        
		//Pannello Centro
		this.pnlCenter = new JPanel();
		this.pnlCenter.setLayout(new CardLayout());
        this.pnlCenter.add(this.pnlPush, "push");
        this.pnlCenter.add(this.pnlRimuovi, "remove");
        this.pnlCenter.add(this.pnlRicerca, "research");
        this.pnlCenter.add(this.pnlMain, "main");
        this.panelShown = "main";
        this.add(this.pnlCenter);
        
        
       
      
        
		
	
        
    }
    
    public void actionPerformed(ActionEvent e){
        Object evento = e.getSource();
        Container container;
        if(evento == this.btnAggiungi){
        	this.pnlPush.add(lblCodice);
        	this.pnlPush.add(txtCodice);
        	this.pnlPush.add(lblStazza);
        	this.pnlPush.add(txtStazza);
        	this.pnlPush.add(lblCarico);
        	this.pnlPush.add(txtCarico);
        	//this.pnlPush.add(lblPosizione);
        	//this.pnlPush.add(txtPosizione);
        	this.pnlPush.add(btnInserisci);
        	this.pnlPush.add(btnReturn);
        	this.panelShown = "push";	
        		

		}else if(evento == this.btnRimuovi){
        	this.pnlRimuovi.add(btnReturn);
        	this.panelShown = "remove";	
		}else if(evento == this.btnRicerca){
			this.pnlRicerca.add(txtRicerca);
			this.pnlRicerca.add(lblRisultato);
			this.pnlRicerca.add(btnResearch);
        	this.pnlRicerca.add(btnReturn);
        	this.pnlRicerca.add(lblRisultato);
			this.panelShown = "research";
		}
        
        
        
        if(evento == this.btnInserisci){
        	try{
        		container = new Container(this.txtCodice.getText(),this.txtStazza.getText(),Integer.parseInt(this.txtCarico.getText()));
        		Nodo n = new Nodo(container);
        		this.gestione.aggiungiInPosizione(index, n);
        		index++;
       		}catch(Eccezione exception){
       			JOptionPane.showMessageDialog(null, exception.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE); 
       		}
        	this.panelShown = "main";
        }
        
        if(evento == this.btnResearch){
        	this.lblRisultato.setText(this.gestione.ricerca(this.txtRicerca.getText()));
        }
        
        if(evento == this.btnReturn)
        	this.panelShown = "main";
        
        
        this.clearField();
        this.repaint();
    }
    
    
    
    private void clearField(){
    	this.txtCodice.setText(null);
    	this.txtStazza.setText(null);
    	this.txtCarico.setText(null);
	}
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        CardLayout cardLayout = (CardLayout)this.pnlCenter.getLayout();
    	cardLayout.show(this.pnlCenter, this.panelShown);
    }
 
}
