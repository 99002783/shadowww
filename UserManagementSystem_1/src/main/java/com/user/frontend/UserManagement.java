package com.user.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.model.Add;
import com.user.model.User;
import com.user.model.Valid;
import com.user.service.RegisterService;

@Component
public class UserManagement  {
	
	@Autowired
    RegisterService registerservice;

//	@Autowired(required=true)
	
    User user=new User();
    Add  add=new Add();
    Valid valid=new Valid();
    JFrame frame=new JFrame();
    JLabel  title,firstName, lastName, EmailId,
    contactNumber, gender, country,state,city,password,confirmPassword,middlename,pincode;

    JPasswordField confirmpwdText,passwordText ;  
    JComboBox cb1 ;
    JButton b;
    JButton login;
    JButton signup;
    private JLabel firstVal,lastNameVal,emailVal,contactValid,pwdVal,confirmVal,pinValid,charFirst,charLast;
    DefaultTableModel model;
    JTextField firstText,lastText,emailText,
    contactText,tf5,tf6,middletext,pintext;
	JLabel titlelogin,email,passwordlogin,newUser;
	JTextField emailtext;
	JPasswordField pwdtext;
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagement window = new UserManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserManagement() {
		MainPage();
		
	}
	private void MainPage() {
        JFrame frame=new JFrame();//creating instance of JFrame  
		frame.setVisible(true);
		//System.out.println("user");
		JLabel l1 = new JLabel("User Management System"); 
		l1.setBounds(120, 50, 450, 50);
		l1.setFont(new Font("Serif", Font.PLAIN, 40));          
		JButton add=new JButton("Register User");//creating instance of JButton  
		JButton signin=new JButton("Sign In");
		add.setBounds(250,150,150, 40);//x axis, y axis, width, height  
		signin.setBounds(250,200,150, 40);         
		frame.add(add);//adding button in JFrame
		frame.add(signin);
		frame.add(l1);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//f.dispose();
				initialize();
				frame.dispose();
			}

		});
		
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//f.dispose();
				Login();
				frame.dispose();
				
			}

		});
		
		//f.setBackground(Color.cyan);
		frame.setSize(700,600);//400 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible  
		}  
	
	private void Login()
	{
		frame = new JFrame();
		//frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);  
		title= new JLabel("SIGN IN"); 
		title.setBounds(200, 50, 350, 50);
		title.setFont(new Font("Serif", Font.PLAIN, 40));
		frame.add(title);
		
		email = new JLabel("Email"); 
		email.setBounds(50, 150, 250, 20); 
		email.setFont(new Font("Serif", Font.PLAIN, 20));
		frame.add(email);
		
		emailtext = new JTextField(); 
		emailtext.setBounds(200, 150, 250,30); 
		frame.add(emailtext);
		
		password = new JLabel("Password"); 
		password.setBounds(50, 200, 250, 20); 
		password.setFont(new Font("Serif", Font.PLAIN, 20));
		frame.add(password);
		
		pwdtext=new JPasswordField();
		pwdtext.setBounds(200, 200, 250, 30);
		frame.add(pwdtext);
		
		
		 login =new JButton("LOGIN");
		login.setBounds(150,250, 100, 30);
		frame.add(login);
		
		newUser=new JLabel("New Here?");
		newUser.setBounds(150,350,250,60);
		frame.add(newUser);
		
		 signup =new JButton("SIGN UP");
		signup.setBounds(250,360, 100, 30);
		frame.add(signup);
		
		signup.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	initialize();
            	
            }
        });
		
		
	
		 frame.setSize(700,700);  
		 frame.setLayout(null); 
		 frame.setBackground(Color.cyan);
		 
		 emailtext.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) { 

				if(emailtext.getText().length()>40)
				   {
				    JOptionPane.showMessageDialog(null, "only 40 characters allowed");
				   }
		 }
});
		 login.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                String Email = emailtext.getText();
	                String password = pwdtext.getText();
	         
	                
	              try {
	                     if((emailtext.getText().length()==0)||(pwdtext.getText().length()==0)) {
	                         JOptionPane.showMessageDialog(login, "Enter Username & Password");
	                         //login.setEnabled(false);
	                     }
	                     
	                     if((emailtext.getText().length()!=0)&&(pwdtext.getText().length()!=0)){
	                    	 //login.setEnabled(true);
	                    	 valid.setEmailid(emailtext.getText());
	            			 valid.setPassword(pwdtext.getText());
	            			if(registerservice.loginauthenticate(valid)) 
	            			{
	            				//System.out.println("Logged in");
	            				frame.dispose();
	            				initializeSecond();	 
	            				
	            			}
	            			else {
	            				  JOptionPane.showMessageDialog(login, "Wrong Email & Password");
	            			     }
	                     }
	              }
	                 catch (Exception e1) {
	                	 
	                   System.out.println("Email ID doesn't exist");
	                }
	            }
	        });	
		 }
	
	private void initializeSecond() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(1000, 800);

		//frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel title= new JLabel("User Operations");
		title.setFont(new Font("Serif", Font.PLAIN, 40));
		title.setBounds(100, 20, 500, 50);
		frame.add(title);
		
		
		JButton logout= new JButton("Logout");
		logout.setBounds(450,22,100,43);
		frame.getContentPane().add(logout);
		
     
		logout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               frame.dispose();
            	MainPage();
            	
            }
        });
		
		JButton edit = new JButton("Edit");
	
		edit.setBounds(24, 150, 101, 43);
		frame.getContentPane().add(edit);
		
		
		edit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				initializeEdit();
			}
		});
		

		JButton search = new JButton("Show Details");
		search.setBounds(200, 150, 111, 43);
		frame.getContentPane().add(search);
        
	        search.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                System.out.println("Search Pressed");
	                String firstname= "";
	                String lastname = "";
	                String middlename = "";
	                String emailid="";
	                String mobilenumber="";
	                String gender="";
	                Optional<User> user=registerservice.search(valid.getEmailid());
	                firstname = user.get().getFirstname();
	                System.out.println(firstname);
	                middlename= user.get().getMiddlename();
	                lastname = user.get().getLastname(); 
	                emailid=user.get().getEmailid();
	                mobilenumber = user.get().getMobilenumber(); 
	                gender= user.get().getGender();
	                model.addRow(new Object[]{firstname,middlename,lastname,emailid,mobilenumber,gender});
	            }
	        });
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(65, 221, 836, 362);
        frame.getContentPane().add(scrollPane); 
         model = new DefaultTableModel();
        JTable table = new JTable();
        table.setBackground(new Color(176, 224, 230));
        scrollPane.setViewportView(table);
        model=new DefaultTableModel();
        Object[] columnNames = {"firstname", "lastname", "middlename","emailid","mobilenumber","gender"};
        Object[] row=new Object[0];
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        
		

	
		JButton delete = new JButton("Delete");
		 delete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(frame,"Sure? You want to Delete?", "Delete Confirmation",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	registerservice.deleteData(valid);
			            }else 
			            {
			            	 JOptionPane.showMessageDialog(null, "You have selected NO");
			            }
				
			}
		});
		
		 delete.setBounds(380,150, 101, 43);
		 
		 
		frame.getContentPane().add(delete);
		
		
	}
		
		 void initializeEdit() {
		        frame = new JFrame();
		        frame.setVisible(true);
		        frame.setBounds(100, 100, 951, 649);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.getContentPane().setLayout(null);
		        
		        JLabel lblNewLabel = new JLabel("First Name*");
		        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		        lblNewLabel.setBounds(241, 125, 200, 14);
		        frame.getContentPane().add(lblNewLabel);
		        
		        JLabel lblNewLabel_1 = new JLabel("Last Name*");
		        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		        lblNewLabel_1.setBounds(241, 175,200, 20);
		        frame.getContentPane().add(lblNewLabel_1);
		        
		        JLabel lblNewLabel_2 = new JLabel("Middlename");
		        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		        lblNewLabel_2.setBounds(241, 230,200, 20);
		        frame.getContentPane().add(lblNewLabel_2);
		        
		        JLabel lblNewLabel_3 = new JLabel("Mobile Number*");
		        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		        lblNewLabel_3.setBounds(241, 278,200, 14);
		        frame.getContentPane().add(lblNewLabel_3);
		        
		        JTextField textField0 = new JTextField();
		        textField0.setBounds(392, 122, 159, 23);
		        frame.getContentPane().add(textField0);
		        textField0.setColumns(10);
		        
		        JTextField   textField_1 = new JTextField();
		        textField_1.setBounds(392, 175, 159, 23);
		        frame.getContentPane().add(textField_1);
		        textField_1.setColumns(10);
		        
		        JTextField textField_2 = new JTextField();
		        textField_2.setBounds(392, 227, 159, 23);
		        frame.getContentPane().add(textField_2);
		        textField_2.setColumns(10);
		        
		        JTextField textField_3 = new JTextField();
		        textField_3.setBounds(392, 275, 159, 23);
		        frame.getContentPane().add(textField_3);
		        textField_3.setColumns(10);
		        
		        JButton btnNewButton = new JButton("Update");
		        btnNewButton.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                user.setEmailid(emailtext.getText());
		                user.setFirstname(textField0.getText());
		                user.setMiddlename(textField_2 .getText());
		                user.setLastname(textField_1.getText());
		                user.setMobilenumber(textField_3 .getText());
		                registerservice.saveUpdate(user);
		                //if()
		                JOptionPane.showMessageDialog(textField_2, "Updated Successfully");
		                frame.dispose();
		                initializeSecond();
		            }
		        });

		       

		        btnNewButton.setBounds(392, 347, 159, 36);
		        frame.getContentPane().add(btnNewButton);
		        
		        JLabel lblNewLabel_4 = new JLabel("Edit Form");
		        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		        lblNewLabel_4.setBounds(392, 46, 149, 28);
		        frame.getContentPane().add(lblNewLabel_4);
	}
	private void initialize() {
		frame=new JFrame();
		frame.setVisible(true);  
		frame.setBackground(Color.YELLOW);

		JButton back=new JButton("Home");  
		back.setBounds(10,10,100,40);

		title = new JLabel("User Registration");
		title.setBounds(200, 50, 350, 50);
		title.setFont(new Font("Serif", Font.PLAIN, 40));


		firstName = new JLabel("First Name*");
		firstName.setBounds(50, 150, 250, 20);
		firstName.setFont(new Font("Serif", Font.PLAIN, 20));

		firstText = new JTextField();
		firstText.setBounds(250, 150, 250,30);
		firstText.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		         firstText.setEditable(true);
		       
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		   
		        if((firstText.getText().length() == 0))
		        {
		        firstText.setBorder(new LineBorder(Color.red,1));
		        firstVal.setVisible(true);
		        }
		       error();
		    }
		});

		firstText.addKeyListener(new KeyAdapter() {
		public void keyReleased(KeyEvent e) {
		if(!(firstText.getText().length() == 0))
		{
		    firstText.setBorder(new LineBorder(Color.gray,1));
		    firstVal.setVisible(false);
		    //flag=0;
		    }

		if(firstText.getText().length()>20)
		    {
		    JOptionPane.showMessageDialog(null, "only 20 characters allowed");
		    //firstText.setText("");
		    }

		}
		   
		});
		
		firstText.addKeyListener(new KeyAdapter(){
		public void keyReleased(KeyEvent e){

		char ch = e.getKeyChar();
		   if(!(Character.isLetter(ch)|| (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE )){
		    e.consume();
		      firstText.setBorder(new LineBorder(Color.red,1));
		    charFirst.setVisible(true);
		     }
		   else
		   {
		    firstText.setBorder(new LineBorder(Color.gray,1));
		        charFirst.setVisible(false);
		   }
		   if((firstText.getText().toString()!=null) &&(lastText.getText().length()!=0)&&(emailText.getText().length()!=0)&&(contactText.getText().length()!=0)&&(pintext.getText().length()!=0)&&(passwordText.getText().length()!=0)) {
				b.setEnabled(true);
			}
			else {
				b.setEnabled(false);
			}
		}

		});

		firstVal = new JLabel("Enter First Name");
		firstVal.setForeground(Color.RED);
		firstVal.setBounds(521, 149, 130, 30);
		frame.add(firstVal);
		firstVal.setVisible(false);

		charFirst = new JLabel("Only Characters are Allowed");
		charFirst.setForeground(Color.RED);
		charFirst.setBounds(521, 149, 190, 30);
		frame.add(charFirst);
		charFirst.setVisible(false);

		middlename = new JLabel("Middle Name ");
		middlename.setBounds(50, 200, 250, 20);
		middlename.setFont(new Font("Serif", Font.PLAIN, 20));

		middletext = new JTextField();
		middletext.setBounds(250, 200, 250, 30);
		middletext.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	middletext.setEditable(true);
		       
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		   
		        if((middletext.getText().length()>20))
		        {
		        	 JOptionPane.showMessageDialog(null, "only 20 characters allowed");
		        }
		       
		    }
		});

		   lastName = new JLabel(
		"Last Name*");
		lastName.setBounds(50, 250, 250, 20);
		lastName.setFont(new Font("Serif", Font.PLAIN, 20));

		lastText = new JTextField();
		lastText.setBounds(250, 250, 250, 30);

		lastText.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		   
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		    // TODO Auto-generated method stub
		    if((lastText.getText().length() == 0))
		         {
		          lastText.setBorder(new LineBorder(Color.red,1));
		          lastNameVal.setVisible(true);
		         }
		    error();
		    }
		});

		lastText.addKeyListener(new KeyAdapter() {
		public void keyReleased(KeyEvent e) {
		if(!(lastText.getText().length() == 0))
		{
		    lastText.setBorder(new LineBorder(Color.gray,1));
		    lastNameVal.setVisible(false);
		   }

		if(lastText.getText().length()>20)
		   {
		    JOptionPane.showMessageDialog(null, "only 20 characters allowed");
		    lastText.setText("");
		   }
		if((firstText.getText().toString()!=null) &&(lastText.getText().length()!=0)&&(emailText.getText().length()!=0)&&(contactText.getText().length()!=0)&&(pintext.getText().length()!=0)&&(passwordText.getText().length()!=0)) {
			b.setEnabled(true);
		}
		else {
			b.setEnabled(false);
		}
		}
		   
		});

		lastText.addKeyListener(new KeyAdapter(){
		public void keyReleased(KeyEvent e){

		char ch = e.getKeyChar();
		   if(!(Character.isLetter(ch)|| (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE )){
		    //e.consume();
		    lastText.setBorder(new LineBorder(Color.red,1));
		    charLast.setVisible(true);
		     }
		   else
		   {
		    lastText.setBorder(new LineBorder(Color.gray,1));
		        charLast.setVisible(false);
		   }

		}
		});

		lastNameVal = new JLabel("Please Enter Last Name");
		lastNameVal.setForeground(Color.RED);
		lastNameVal.setBounds(521, 249, 172, 30);
		frame.add(lastNameVal);
		lastNameVal.setVisible(false);

		charLast = new JLabel("Only Characters are Allowed");
		charLast.setForeground(Color.RED);
		charLast.setBounds(521, 254, 186, 20);
		frame.add(charLast);
		charLast.setVisible(false);

		EmailId = new JLabel("Email ID*");
		EmailId.setBounds(50, 300, 250, 20);
		EmailId.setFont(new Font("Serif", Font.PLAIN, 20));

		emailText = new JTextField();
		emailText.setBounds(250, 300, 250, 30);

		emailVal = new JLabel("Enter Valid Email");
		emailVal.setForeground(Color.RED);
		emailVal.setBounds(521, 299, 172, 30);
		emailVal.setVisible(false);
		frame.add(emailVal);

		emailText.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		         emailText.setEditable(true);
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		    // TODO Auto-generated method stub
		    String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Pattern p = Pattern.compile(EMAIL_REGEX);
		       Matcher m = p.matcher(emailText.getText());
		       if((!m.matches()))
		{
		emailText.setBorder(new LineBorder(Color.red,1));
		    emailVal.setVisible(true);
		}
		       else
		       {
		        emailText.setBorder(new LineBorder(Color.gray,1));
		    emailVal.setVisible(false);
		       }
		       
		       
		    }
		});

		emailText.addKeyListener(new KeyAdapter(){
		public void keyTyped(KeyEvent e){
		char ch = e.getKeyChar();
		if((emailText.getText().length()>40 || (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE))
		       {
		e.consume();
		       }

		}
		 
		});
		emailText.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		         emailText.setEditable(true);
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		    // TODO Auto-generated method stub
		    	String Email=emailText.getText();
		    	if( Email.length()!=0) {
		               int source=0;
		           try {
		        	   valid.setEmailid(Email);         			 
       			   if(registerservice.authenticate(Email)) 
       			   {			
       				source=1;
       			
		            }
		              
		           } 
		           catch (Exception e1) {
		               // TODO Auto-generated catch block
		               e1.printStackTrace();
		           }
		             if(source==1) {
		                 JOptionPane.showMessageDialog(null, "user exists");
		                 b.setEnabled(false);
		                 
		             }
		             else
		             {
		            	// b.setEnabled(true);
		             }
		             }

		    }
		});

		emailText.addKeyListener(new KeyAdapter() {
			 public void keyReleased(KeyEvent e) {
		          
		           if((firstText.getText().toString()!=null) &&(lastText.getText().length()!=0)&&(emailText.getText().length()!=0)&&(contactText.getText().length()!=0)&&(pintext.getText().length()!=0)&&(passwordText.getText().length()!=0)) {
		        		b.setEnabled(true);
		        	}
		        	else {
		        		b.setEnabled(false);
		        	}
		       }
		   });
		password = new JLabel("Password*");
		password.setBounds(50,350,250,20);
		password.setFont(new Font("Serif", Font.PLAIN, 20));

		confirmpwdText=new JPasswordField();
		confirmpwdText.setBounds(250,350,250,30);
		confirmpwdText.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		         confirmpwdText.setEditable(true);
		          }
		    @Override
		    public void focusLost(FocusEvent e) {
		    // TODO Auto-generated method stub
		    String regex = "^(?=.*[0-9])"
		                + "(?=.*[a-z])(?=.*[A-Z])"
		                + "(?=.*[@#$%^&+=])";
		    Pattern p = Pattern.compile(regex);
		        // Pattern class contains matcher() method
		        // to find matching between given password
		        // and regular expression.
		        Matcher m = p.matcher(confirmpwdText.getText());
		        if(!m.matches()&&confirmpwdText.getText().length()<8 )
		        {
		confirmpwdText.setBorder(new LineBorder(Color.red,1));
		pwdVal.setVisible(true);
		   
		       }
		else
		{
		confirmpwdText.setBorder(new LineBorder(Color.gray,1));
		pwdVal.setVisible(false);
		}
		        
		    }
		    
		});


		pwdVal = new JLabel("Enter a password with length 8 ");
		pwdVal.setForeground(Color.RED);
		pwdVal.setBounds(521, 350, 253, 30);
		frame.add(pwdVal);
		pwdVal.setVisible(false);

		confirmPassword = new JLabel("Confirm Password*");
		confirmPassword.setBounds(50,400,250,20);
		confirmPassword.setFont(new Font("Serif", Font.PLAIN, 20));


		passwordText=new JPasswordField();
		passwordText.setBounds(250,400,250,30);

		passwordText.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		         passwordText.setEditable(true);
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		    // TODO Auto-generated method stub
		    if (!Arrays.equals(confirmpwdText.getPassword(),passwordText.getPassword())) {
		    passwordText.setBorder(new LineBorder(Color.red,1));
		    confirmVal.setVisible(true);
		    }
		else
		{
		passwordText.setBorder(new LineBorder(Color.gray,1));

		confirmVal.setVisible(false);
		}
		    if((firstText.getText().toString()!=null) &&(lastText.getText().length()!=0)&&(emailText.getText().length()!=0)&&(contactText.getText().length()!=0)&&(pintext.getText().length()!=0)&&(passwordText.getText().length()!=0)) {
				b.setEnabled(true);
			}
			else {
				b.setEnabled(false);
		    }
		    
		   
		}
		});

		passwordText.addKeyListener(new KeyAdapter(){
		public void keyReleased(KeyEvent e){
			if (Arrays.equals(confirmpwdText.getPassword(),passwordText.getPassword()))
			{
				e.consume();
			}
			 if((firstText.getText().toString()!=null) &&(lastText.getText().length()!=0)&&(emailText.getText().length()!=0)&&(contactText.getText().length()!=0)&&(pintext.getText().length()!=0)&&(passwordText.getText().length()!=0)) {
					b.setEnabled(true);
				}
				else {
					b.setEnabled(false);
			    }						
		}
		 
		});

		confirmVal = new JLabel("Password Doesn't Match");
		confirmVal.setForeground(Color.RED);
		confirmVal.setBounds(521, 400, 172, 30);
		frame.add(confirmVal);
		confirmVal.setVisible(false);

		

		contactNumber = new JLabel("Contact Number*");
		contactNumber.setBounds(50, 450, 250, 20);
		contactNumber.setFont(new Font("Serif", Font.PLAIN, 20));

		contactText = new JTextField();
		contactText.setBounds(250, 450, 250, 30);

		contactText.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		         contactText.setEditable(true);
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		    // TODO Auto-generated method stub
		    if((contactText.getText().length()>10 || contactText.getText().length()<10))
		   
		        {
		        contactText.setBorder(new LineBorder(Color.red,1));
		        contactValid.setVisible(true);
		        }
		        else
		        {
		        contactText.setBorder(new LineBorder(Color.gray,1));
		        contactValid.setVisible(false);
		        }
		    error();
		       
		    }
		});


		contactText.addKeyListener(new KeyAdapter(){
		public void keyReleased(KeyEvent e){
		char ch = e.getKeyChar();
		//System.out.println(contactText.getText().length());
		if(contactText.getText().length()==10) {

		contactText.setBorder(new LineBorder(Color.gray,1));

		contactValid.setVisible(false);

		}
		if((Character.isLetter(ch)|| (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE))
		       {
		        e.consume();
		        contactText.setBorder(new LineBorder(Color.red,1));
		contactValid.setVisible(true);
		// pinValid.setVisible(false);
		       }
		else
		{
		contactText.setBorder(new LineBorder(Color.gray,1));
//		     pinValid.setVisible(true);
		}
		if((firstText.getText().toString()!=null) &&(lastText.getText().length()!=0)&&(emailText.getText().length()!=0)&&(contactText.getText().length()!=0)&&(pintext.getText().length()!=0)&&(passwordText.getText().length()!=0)) {
			b.setEnabled(true);
		}
		else {
			b.setEnabled(false);
		}
		}

		 
		});

		contactText.addKeyListener(new KeyAdapter(){
		public void keyTyped(KeyEvent e){
		char ch = e.getKeyChar();
		if((contactText.getText().length()>9 || (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE))
		       {
		e.consume();
		contactText.setBorder(new LineBorder(Color.gray,1));
		contactValid.setVisible(false);
		       }
		}
		 
		});
		contactValid = new JLabel("Enter Valid Contact Number");
		contactValid.setForeground(Color.RED);
		contactValid.setBounds(521, 450, 186, 30);
		frame.add(contactValid);
		contactValid.setVisible(false);

		gender = new JLabel("Gender");
		gender.setBounds(50, 500, 250, 20);
		gender.setFont(new Font("Serif", Font.PLAIN, 20));

		JRadioButton r5= new JRadioButton("Male");
		r5.setActionCommand("Male");
		JRadioButton r6= new JRadioButton("Female");
		r6.setActionCommand("Female");
		r6.setSelected(true);
		r5.setBounds(250, 500, 100, 30);
		r6.setBounds(350, 500, 100, 30);

		ButtonGroup bg = new ButtonGroup();
		bg.add(r5);
		bg.add(r6);
		
		city = new JLabel("City");
		city.setBounds(50, 550, 250, 20);
		city.setFont(new Font("Serif", Font.PLAIN, 20));

		tf6 = new JTextField();
		tf6.setBounds(250, 550, 250, 30);
		
		tf6.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	tf6.setEditable(true);
		       
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		   
		        if((tf6.getText().length()>15))
		        {
		        	 JOptionPane.showMessageDialog(null, "only 15 characters allowed");
		        }
		       
		    }
		});

		state=new JLabel("State");
		state.setBounds(50,600,250,20);
		state.setFont(new Font("Serif", Font.PLAIN, 20));

		String states[]
		=  {
				"select",
				   "AP",
		           "Arunachal",
		           "Assam",
		           "Bihar",
		           "Chhattisgarh",
		           "Goa",
		           "Gujarat",
		           "Haryana",
		           "HimachalPradesh",
		           "Jammu",
		           "Jharkhand",
		           "Karnataka",
		           "Kerala",
		           "MadhyaPradesh",
		           "Maharashtra",
		           "Manipur",
		           "Meghalaya",
		           "Mizoram",
		           "Nagaland",
		           "Odisha",
		           "Punjab",
		           "Rajasthan",
		           "Sikkim",
		           "Tamil Nadu",
		           "Telangana",
		           "Tripura",
		           "Uttarakhand",
		           "Uttar Pradesh",
		           "West Bengal",
		           "Andaman ",
		           "Chandigarh",
		           "Dadra",
		           "Daman and Diu",
		           "Delhi",
		           "Lakshadweep",
		           "Puducherry"};

		cb1= new JComboBox(states);
		cb1.setBounds(250,600,250,20);
		
		country = new JLabel("Country");
		country.setBounds(50, 650, 250, 20);
		country.setFont(new Font("Serif", Font.PLAIN, 20));

		tf5 = new JTextField();
		tf5.setBounds(250, 650, 250, 30);
		
		tf5.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		    	tf5.setEditable(true);
		       
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		   
		        if((tf5.getText().length()>15))
		        {
		        	 JOptionPane.showMessageDialog(null, "only 15 characters allowed");
		        }
		       
		    }
		});

		pincode = new JLabel("Pin Code");
		pincode.setBounds(50, 700, 250, 20);
		pincode.setFont(new Font("Serif", Font.PLAIN, 20));

		pintext = new JTextField();
		pintext.setBounds(250, 700, 250, 30);

		pintext.addKeyListener(new KeyAdapter(){
		public void keyReleased(KeyEvent e){
		char ch = e.getKeyChar();
		//System.out.println(pintext.getText().length());
		if(pintext.getText().length()==6 || pintext.getText().length()<6) {

		pintext.setBorder(new LineBorder(Color.gray,1));
		    pinValid.setVisible(false);
		}
		if((Character.isLetter(ch)|| (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE))
		       {
		        //e.consume();
		// pinValid.setVisible(false);
		       }
		if(pintext.getText().length()>6 || Character.isLetter(ch) )
		{
		pintext.setBorder(new LineBorder(Color.red,1));
		    pinValid.setVisible(true);
		}
		
		}
		 
		});

		pintext.addKeyListener(new KeyAdapter(){
		public void keyTyped(KeyEvent e){
		char ch = e.getKeyChar();
		if((pintext.getText().length()>5 || (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE))
		       {
		e.consume();
		pintext.setBorder(new LineBorder(Color.gray,1));
		    pinValid.setVisible(false);
		       }
		if((firstText.getText().toString()!=null) &&(lastText.getText().length()!=0)&&(emailText.getText().length()!=0)&&(contactText.getText().length()!=0)&&(pintext.getText().length()!=0)&&(passwordText.getText().length()!=0)) {
			b.setEnabled(true);
		}
		else {
			b.setEnabled(false);
		}
		}
		 
		});

		pinValid = new JLabel("Please Enter 6 digits");
		pinValid.setForeground(Color.RED);
		pinValid.setBounds(521, 700, 172, 30);
		frame.add(pinValid);
		pinValid.setVisible(false);

		b=new JButton("Register");  
		b.setBounds(150,800,100,40);
		b.setEnabled(false);

		JButton clear=new JButton("Clear");
		clear.setBounds(300,800,100,40);
		frame.add(title);
		frame.add(firstName);
		frame.add(lastName);
		frame.add(EmailId);
		frame.add(contactNumber);
		frame.add(gender);
		frame.add(country);
		frame.add(state);
		frame.add(city);
		frame.add(password);
		frame.add(confirmPassword);
		frame.add(firstText);
		frame.add(lastText);
		frame.add(emailText);
		frame.add(contactText);
		frame.add(tf6);
		frame.add(confirmpwdText);
		frame.add(tf5);
		frame.add(passwordText);
		frame.add(r5);
		frame.add(middlename);
		frame.add(pincode);
		frame.add(pintext);
		frame.add(middletext);
		frame.add(r6);
		frame.add(cb1);
		frame.add(b);
		frame.add(back);
		frame.add(clear);
		
		        b.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		             String firstName = firstText.getText();
		             String middleName=middletext.getText();
		             String lastName = lastText.getText();
		             String mobileNumber = contactText.getText();
		             String emailId = emailText.getText();
//		             String gender=bg.getSelection().getActionCommand().toString();
		             String gender=null;
		             String city = tf6.getText();
		             String country=tf5.getText();
		             String state = cb1.getSelectedItem().toString();
		             String pincode = pintext.getText();
		             String password = confirmpwdText.getText();
		             String confirm = passwordText.getText();
		         
		             user.setFirstname(firstText.getText());
		             user.setMiddlename(middletext.getText());
		             user.setLastname(lastText.getText());
		             user.setEmailid(emailText.getText());
		             user.setGender(bg.getSelection().getActionCommand().toString());
		             user.setMobilenumber(contactText.getText());
		            
		             add.setEmailid(emailText.getText());
		             add.setCity(tf6.getText());
		             add.setState(cb1.getSelectedItem().toString());
		             add.setPincode(pintext.getText());
		             
		             valid.setEmailid(emailText.getText());
		             valid.setPassword(passwordText.getText());
		             valid.setConfirm(confirmpwdText.getText());

		              String greeting = "" + firstName;
		              greeting += " \n";
		              registerservice.saveData(user,add,valid);
		              JOptionPane.showMessageDialog(null, "Registered Successfully");
		              
		         }
		     });
		             

		back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {

		          MainPage();
		//main.setVisible(true);
		frame.dispose();
		}

		});

		clear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
		firstText.setText("");
		firstText.setBorder(new LineBorder(Color.gray,1));
		lastText.setText("");
		lastText.setBorder(new LineBorder(Color.gray,1));
		emailText.setText("");
		emailText.setBorder(new LineBorder(Color.gray,1));
		contactText.setText("");
		contactText.setBorder(new LineBorder(Color.gray,1));
		bg.clearSelection(); 
	    cb1.setSelectedIndex(0);
		tf5.setText("");
		middletext.setText("");
		pintext.setText("");
		pintext.setBorder(new LineBorder(Color.gray,1));
		passwordText.setText("");
		passwordText.setBorder(new LineBorder(Color.gray,1));
		confirmpwdText.setText("");
		confirmpwdText.setBorder(new LineBorder(Color.gray,1));
		firstVal.setVisible(false);
		lastNameVal.setVisible(false);
		emailVal.setVisible(false);
		contactValid.setVisible(false);
		pwdVal.setVisible(false);
		confirmVal.setVisible(false);
		pinValid.setVisible(false);
		charFirst.setVisible(false);
		charLast.setVisible(false);
		
		}

		});
		

		frame.setSize(800,900);  
		frame.setLayout(null);
		}	
	
protected void error() {
		// TODO Auto-generated method stub
	Border border1 = BorderFactory.createLineBorder(Color.gray, 1);
    firstText.setBorder(border1);
    lastText.setBorder(border1);
    emailText.setBorder(border1);
    contactText.setBorder(border1);
    confirmpwdText.setBorder(border1);
    passwordText.setBorder(border1);
    firstVal.setVisible(false);
    lastNameVal.setVisible(false);
    emailVal.setVisible(false);
    contactValid.setVisible(false);
    pwdVal.setVisible(false);
    confirmVal.setVisible(false);
    pinValid.setVisible(false);
    charFirst.setVisible(false);
    charLast.setVisible(false);	
	
		}

public int name(String firstText) {
	    // TODO Auto-generated method stub
	     int value=1;
	     //String regex="[a-zA-Z]";
	     //Pattern p = Pattern.compile(regex);
	     //Matcher m = p.matcher(firstText.toString());
	     if(firstText.toString().length()==0)
	         value=0;
	     return value;
	    
	}
	public int phone(String contactText) {
	    // TODO Auto-generated method stub
	    int value=1;
	    if( contactText.toString().length()!=10 )
	    {
	        value=0;
	    }
	        
	    return value;    
	}
 
	public int email(String emailText) {
	    // TODO Auto-generated method stub
	    
	     int value=1;
	     String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	     Pattern p = Pattern.compile(regex);
	     Matcher m = p.matcher(emailText.toString());
	     if((!m.matches())||emailText.toString().length()==0 )
	         value=0;
	     return value;
	    
	}
	public int password(String passwordText ) {
	    
	    int value=1;
	    if( passwordText.toString().length()!=8 )
	    {
	        value=0;
	    }
	        
	    return value;

	}
	public int lastname(String lastText) {
	    // TODO Auto-generated method stub
	    
	    int value=1;
//	     String regex="[a-zA-Z]";
//	     Pattern p = Pattern.compile(regex);
	    //Matcher m = p.matcher(lastText.toString());
	    if(lastText.toString().length()==0)
	        value=0;
	    return value;
	    
	}
	public int pin(String pintext) {
	    // TODO Auto-generated method stub
	    int value=1;
	     String regex="[a-zA-Z]";
	     Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(pintext.toString());
	    if( (m.matches())|| pintext.toString().length()!=6)
	    {
	        value=0;
	    }
	  return value;    
	}

	

	
}
	
	

	


